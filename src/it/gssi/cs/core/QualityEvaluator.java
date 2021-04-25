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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfMetaModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.tools.EmfTool;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;

public class QualityEvaluator {
	
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
			//check if the uri already exists in the regsistry
			
			EmfUtil.register(mmuri, EPackage.Registry.INSTANCE);
			
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*********************************");
	}
	
	public static void evaluate(Path modelsRoot, Path eolRoot, Path mmRoot)  {
		// TODO Auto-generated method stub
		try {
				//load output model		
				EmfModel targetModel = new EmfModel();
				String evaluatedQualityEcosystenmMM = mmRoot.resolve("qualityEcosystem.ecore").toAbsolutePath().toUri().toString();
						
				StringProperties targetProperties = new StringProperties();
				targetProperties.setProperty(EmfModel.PROPERTY_NAME, "evaluatedecosystem");
				targetProperties.setProperty(EmfModel.PROPERTY_ALIASES, "evaluatedecosystem");
				targetProperties.setProperty(EmfModel.PROPERTY_EXPAND, "true");
				targetProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, evaluatedQualityEcosystenmMM);
				targetProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
						URI.createFileURI(new File("model/ecosystem.evaluated.model").getAbsolutePath()).toString()
				);
				
				targetProperties.setProperty(EmfModel.PROPERTY_READONLOAD, "false");
				targetProperties.setProperty(EmfModel.PROPERTY_STOREONDISPOSAL, "true");
				
				//load quality model definition
				StringProperties qualitymodelProperties = new StringProperties();
				String qualityMM = mmRoot.resolve("qualityDefMM.ecore").toAbsolutePath().toUri().toString();
				
				org.eclipse.emf.common.util.URI qualityMMuri = org.eclipse.emf.common.util.URI.createURI(qualityMM);
				
				EmfUtil.register(qualityMMuri, EPackage.Registry.INSTANCE);
				
				qualitymodelProperties.setProperty(EmfModel.PROPERTY_NAME, "qualitydef");
				
				qualitymodelProperties.setProperty(EmfModel.PROPERTY_ALIASES, "qualitydef");
				qualitymodelProperties.setProperty(EmfModel.PROPERTY_EXPAND, "true");
				qualitymodelProperties.setProperty(EmfModel.PROPERTY_METAMODEL_URI, "http://cs.gssi.it/qualitymodel");
				
				qualitymodelProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,	
						URI.createFileURI(new File("model/qualitydef.model").getAbsolutePath()).toString()
					);
				
				qualitymodelProperties.setProperty(EmfModel.PROPERTY_READONLOAD, "true");
				qualitymodelProperties.setProperty(EmfModel.PROPERTY_STOREONDISPOSAL, "false");
		
						
				EolRunConfiguration runConfig = EolRunConfiguration.Builder()
						.withScript(eolRoot.resolve("qualityEval.eol"))
						.withModel(targetModel,targetProperties)
						.withModel(new EmfModel(),qualitymodelProperties)
						//.withProfiling()
						.withParameter("Thread", Thread.class)
						.build();
				
				//load ecosystem model 
				StringProperties ecosystmProperties = new StringProperties();
				String ecosystemMM = mmRoot.resolve("MDEEcosystemMM.ecore").toAbsolutePath().toUri().toString();
				
				org.eclipse.emf.common.util.URI ecosystemMMuri = org.eclipse.emf.common.util.URI.createURI(ecosystemMM);
				
				EmfUtil.register(ecosystemMMuri, EPackage.Registry.INSTANCE);
				
				ecosystmProperties.setProperty(EmfModel.PROPERTY_NAME, "ecosystem");
				
				ecosystmProperties.setProperty(EmfModel.PROPERTY_ALIASES, "ecosystem");
				ecosystmProperties.setProperty(EmfModel.PROPERTY_EXPAND, "true");
				//ecosystmProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, ecosystemMM);
				ecosystmProperties.setProperty(EmfModel.PROPERTY_METAMODEL_URI, "http://cs.gssi.it/mdeecosystem");
				ecosystmProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,	
						URI.createFileURI(new File("model/ecosystem.model").getAbsolutePath()).toString()
					);
				ecosystmProperties.setProperty(EmfModel.PROPERTY_READONLOAD, "true");
				ecosystmProperties.setProperty(EmfModel.PROPERTY_STOREONDISPOSAL, "false");
				
				runConfig.modelsAndProperties.put(new EmfModel(), ecosystmProperties);
				
				Iterator repoiterator;
				
				repoiterator = Files.list(modelsRoot).iterator();
				
				//load repository
				while(repoiterator.hasNext()) {
				Path pf=(Path)repoiterator.next();
				//System.out.println(pf.getFileName());
				StringProperties repoProperties = new StringProperties();
				repoProperties.setProperty(EmfModel.PROPERTY_NAME, pf.getFileName().toString());
				
				repoProperties.setProperty(EmfModel.PROPERTY_ALIASES, pf.getFileName().toString());
				repoProperties.setProperty(EmfModel.PROPERTY_EXPAND, "true");
				
				repoProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
					
					modelsRoot.resolve(pf.getFileName()).toUri().toString()
				);
				EmfModel temp = new EmfModel();
								
				runConfig.modelsAndProperties.put(temp, repoProperties);	
				
				}
						
				runConfig.run();
				targetModel.dispose();
				System.out.println("Evaluated quality model saved in " + targetModel.getModelFile());
				
				}catch(FileNotFoundException ex) {
					System.err.println(ex.getMessage());
					
				}catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
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
