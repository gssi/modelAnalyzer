package it.gssi.cs.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.ecl.launch.EclRunConfiguration;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.emc.emf.EmfModel;

import distancemodel.Distance;
import distancemodel.DistanceModel;
import distancemodel.DistanceModelFactory;

public class DistanceCalculator {
	
	public static DistanceModel compare(Path source, Stream<Path> dataset, Path eolRoot, Path modelsRoot, DistanceModelFactory factory, DistanceModel distancemodel, int threshold_distance) {
		//System.out.println("Subject: "+source.getFileName());
		Iterator iterator= dataset.iterator();
		      
		while (iterator.hasNext()) {
			Path pf=(Path)iterator.next();
			
			if(!pf.getFileName().toString().equals(source.getFileName().toString())) {
			System.out.println("     ->"+pf.getFileName().toString());
			int sim = executeECL(source,pf, eolRoot,modelsRoot);
			if(sim >= threshold_distance) {
				
				System.err.println("Relevant distance:"+source.getFileName()+"-->"+pf.getFileName()+"("+sim+")");
				
			}
			
			Distance distance = factory.createDistance();
			distance.setLeft(source.getFileName().toString());
			distance.setRight(pf.getFileName().toString());
			distance.setValue(sim);
			distancemodel.getMeasurements().add(distance);
			}
			 
		}
		return distancemodel;
		 
		 
	}
	
	private static int executeECL(Path source, Path pf, Path eolRoot , Path modelsRoot) {
		// TODO Auto-generated method stub
		
		StringProperties subjProperties = new StringProperties();
		subjProperties.setProperty(EmfModel.PROPERTY_NAME, "Source");
		
		subjProperties.setProperty(EmfModel.PROPERTY_ALIASES,"Source");
		subjProperties.setProperty(EmfModel.PROPERTY_EXPAND, "true");
		subjProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
				
			modelsRoot.resolve(source.getFileName()).toUri().toString()
		);
		
		EmfModel sourceModel = new EmfModel();
		
		
		
		StringProperties repoProperties = new StringProperties();
		repoProperties.setProperty(EmfModel.PROPERTY_NAME, "Target");
		
		repoProperties.setProperty(EmfModel.PROPERTY_ALIASES,"Target");
		repoProperties.setProperty(EmfModel.PROPERTY_EXPAND, "true");
		repoProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
				
			modelsRoot.resolve(pf.getFileName()).toUri().toString()
		);
		
		
		EclRunConfiguration runConfig = EclRunConfiguration.Builder()
				.withScript(eolRoot.resolve("similarity.ecl"))
				.withModel(sourceModel, subjProperties)
				.withModel(new EmfModel(), repoProperties)
				//.withProfiling()
				.withParameter("Thread", Thread.class)
				.build();
		
		runConfig.run();
		MatchTrace trace = runConfig.getResult();
	
		int sim=0;
		MatchTrace successfull=(trace.getReduced());
		
				
		try {
			
			sourceModel.load(subjProperties);
			sim=checkComparison(sourceModel, successfull);
			
		//System.out.println("Matching everything");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sim;
}
	
public static int checkComparison(EmfModel modeltocheck, MatchTrace successfull) {
		
		int simIndex=0;
		Double packsim =0.0;
		Double classsim=0.0;
		Double featuresim=0.0;
		int numpackages=0;
		int nrclasses=0;
		int nrfeats=0;
	
		try {
		nrclasses =  modeltocheck.getAllOfKind("EClass").size();
		nrfeats=modeltocheck.getAllOfKind("EStructuralFeature").size();
		
		for (Match match : successfull.getMatches()) {
		
		//System.out.println(match.getLeft()+"<->"+match.getRight());
		EObject left=(EObject) match.getLeft();
			
		if(left.eClass().getName().equals("EPackage")) {
			packsim++;
		}else if (left.eClass().getName().equals("EClass")) {
			
			classsim = classsim + (1/successfull.getMatches(left).size());
			
			
		}else if(left.eClass().getName().equals("EReference") || (left.eClass().getName().equals("EAttribute"))) {
			featuresim = featuresim +  (1/successfull.getMatches(left).size());
		}
			
		}
		//System.out.println(classsim+"/"+nrclasses+","+featuresim+"/"+nrfeats);
			
			} catch (org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		//System.err.println("("+classsim+"*100/"+nrclasses+")"+"("+featuresim+"*100/"+nrfeats+")");
		simIndex= (int) ((((classsim*100)/nrclasses)+((featuresim*100)/nrfeats))/2);
		return simIndex;
		
		
	}

public static void computeDistance(Path modelsRoot, int threshold_distance, Path eolRoot ) {
	// TODO Auto-generated method stub
	System.out.println("Processing models distance");
	
	Iterator iterator;
	try {
		iterator = Files.list(modelsRoot).iterator();

	//distance model
	DistanceModelFactory factory = DistanceModelFactory.eINSTANCE;
	DistanceModel distancemodel = factory.createDistanceModel();
	distancemodel.setThreshold(threshold_distance);
	Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
    Map<String, Object> m = reg.getExtensionToFactoryMap();
    m.put("model", new XMIResourceFactoryImpl());

    // Obtain a new resource set
    ResourceSet resSet = new ResourceSetImpl();

    // create a resource
    Resource resource = resSet.createResource(URI
            .createURI("model/distance.model"));
	
	while (iterator.hasNext()) {
		Path pf=(Path)iterator.next();
		
		//compare if ecore
		if(pf.toString().endsWith(".ecore")) {
			System.out.println(pf.getFileName());
			compare(pf, Files.list(modelsRoot),eolRoot,modelsRoot, factory, distancemodel, threshold_distance);
		}
	}
		//save distance model
	   resource.getContents().add(distancemodel);
       resource.save(Collections.EMPTY_MAP);
       
       System.out.println("Saved distance model in " + resource.getURI().toString());
    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	System.out.println("*********************************");
}


}
