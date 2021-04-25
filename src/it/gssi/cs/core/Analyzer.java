package it.gssi.cs.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.tools.EmfTool;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;

public class Analyzer {
	
	public static void registerMMs(Path modelsRoot) {
		// TODO Auto-generated method stub
		System.out.println("Registering all metamodels...");
		
		Iterator iterator;
		try {
			iterator = Files.list(modelsRoot).iterator();
		
		while (iterator.hasNext()) {
			
			Path pf=(Path)iterator.next();
			System.out.println(pf.getFileName());
			if( pf.toString().endsWith(".ecore") ) {
			
			org.eclipse.emf.common.util.URI mmuri = org.eclipse.emf.common.util.URI.createURI(pf.toString());
			
			EmfUtil.register(mmuri, EPackage.Registry.INSTANCE);
			
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*********************************");
	}
	public static void generateRepoGraph(Path modelsRoot, Path eolRoot, Path mmRoot)  {
		// TODO Auto-generated method stub
		//org.eclipse.epsilon.emc.emf.tools.EmfTool m= new EmfTool();
						
				EmfModel targetModel = new EmfModel();
				
				genGraphEcore(targetModel,modelsRoot,eolRoot,mmRoot);
				targetModel.dispose();
				
				genGraphModels(targetModel,modelsRoot,eolRoot,mmRoot);
				
				targetModel.dispose();
				System.out.println("Created ecosystem model in " + targetModel.getModelFile());
			
				
	}
	
private static void genGraphModels(EmfModel targetModel, Path modelsRoot, Path eolRoot, Path mmRoot) {
		// TODO Auto-generated method stub
	
String ecosystemMM = mmRoot.resolve("MDEEcosystemMM.ecore").toAbsolutePath().toUri().toString();
	
	StringProperties targetProperties = new StringProperties();
	targetProperties.setProperty(EmfModel.PROPERTY_NAME, "ecosystem");
	targetProperties.setProperty(EmfModel.PROPERTY_ALIASES, "ecosystem");
	targetProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, ecosystemMM);
	targetProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
		"model/ecosystem.model"
	);
	
	targetProperties.setProperty(EmfModel.PROPERTY_READONLOAD, "true");
	targetProperties.setProperty(EmfModel.PROPERTY_STOREONDISPOSAL, "true");
	
	
	
	EolRunConfiguration runConfig = EolRunConfiguration.Builder()
			.withScript(eolRoot.resolve("recoveryM.eol"))
			.withModel(targetModel,targetProperties)
			//.withProfiling()
			.withParameter("Thread", Thread.class)
			.build();
	
	
	//retrieve dependencies

	Iterator repoiterator;
	
	try {
	repoiterator = Files.list(modelsRoot).filter(path -> path.getFileName().toString().endsWith(".model")).iterator();
	
	registerMMs(modelsRoot);
	
	while(repoiterator.hasNext()) {
	Path pf=(Path)repoiterator.next();
	//System.out.println(pf.getFileName());
	StringProperties repoProperties = new StringProperties();
	repoProperties.setProperty(EmfModel.PROPERTY_NAME, pf.getFileName().toString());
	
	repoProperties.setProperty(EmfModel.PROPERTY_ALIASES, pf.getFileName().toString());
	repoProperties.setProperty(EmfModel.PROPERTY_EXPAND, "true");
	
	repoProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
		URI.createFileURI(new File(modelsRoot.resolve(pf.getFileName()).toString()).getAbsolutePath()).toString()
		
	);
	
	runConfig.modelsAndProperties.put(new EmfModel(), repoProperties);	
	
	}
			
	runConfig.run();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

private static void genGraphEcore(EmfModel targetModel, Path modelsRoot, Path eolRoot, Path mmRoot) {
		// TODO Auto-generated method stub
	String ecosystemMM = mmRoot.resolve("MDEEcosystemMM.ecore").toAbsolutePath().toUri().toString();
	
	StringProperties targetProperties = new StringProperties();
	targetProperties.setProperty(EmfModel.PROPERTY_NAME, "ecosystem");
	targetProperties.setProperty(EmfModel.PROPERTY_ALIASES, "ecosystem");
	targetProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, ecosystemMM);
	targetProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
		"model/ecosystem.model"
	);
	
	targetProperties.setProperty(EmfModel.PROPERTY_READONLOAD, "false");
	targetProperties.setProperty(EmfModel.PROPERTY_STOREONDISPOSAL, "true");
	
	
	
	EolRunConfiguration runConfig = EolRunConfiguration.Builder()
			.withScript(eolRoot.resolve("recoveryMM.eol"))
			.withModel(targetModel,targetProperties)
			//.withProfiling()
			.withParameter("Thread", Thread.class)
			.build();
	
	StringProperties distanceProperty = new StringProperties();
	
	distanceProperty.setProperty(EmfModel.PROPERTY_NAME, "distancemodel");
	
	distanceProperty.setProperty(EmfModel.PROPERTY_ALIASES, "distancemodel");
	distanceProperty.setProperty(EmfModel.PROPERTY_EXPAND, "true");
	distanceProperty.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, mmRoot.resolve("DistanceModel.ecore").toAbsolutePath().toUri().toString());
	File distancefile = new File("model/distance.model");
	distanceProperty.setProperty(EmfModel.PROPERTY_MODEL_URI,	
			URI.createFileURI(distancefile.getAbsolutePath()).toString()
		);
	if(distancefile.exists()) {
	runConfig.modelsAndProperties.put(new EmfModel(), distanceProperty);	
	}
	//retrieve dependencies

	Iterator repoiterator;
	
	try {
		repoiterator = Files.list(modelsRoot).filter(path -> path.getFileName().toString().endsWith(".ecore")).iterator();
	
	
	
	while(repoiterator.hasNext()) {
	Path pf=(Path)repoiterator.next();
	//System.out.println(pf.getFileName());
	StringProperties repoProperties = new StringProperties();
	repoProperties.setProperty(EmfModel.PROPERTY_NAME, pf.getFileName().toString());
	
	repoProperties.setProperty(EmfModel.PROPERTY_ALIASES, pf.getFileName().toString());
	repoProperties.setProperty(EmfModel.PROPERTY_EXPAND, "false");
	
	repoProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
		URI.createFileURI(new File(modelsRoot.resolve(pf.getFileName()).toString()).getAbsolutePath()).toString()
		
	);
	
	runConfig.modelsAndProperties.put(new EmfModel(), repoProperties);	
	runConfig.parameters.put("baseuri", modelsRoot);
	
	}
			
	runConfig.run();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public static String getRepoFolder(String path) {
	Properties prop = new Properties();
	try (InputStream input = new FileInputStream(path)) {

        // load a properties file
        prop.load(input);

        // get the property value and print it out
        System.out.println("Repository folder:"+prop.getProperty("repository.package"));
       

    } catch (IOException ex) {
        ex.printStackTrace();
    }
	return prop.getProperty("repository.package");
}
}
