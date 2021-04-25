/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package it.gssi.cs.launcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.antlr.runtime.ClassicToken;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.ecl.launch.EclRunConfiguration;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;

import distancemodel.Distance;
import distancemodel.DistanceModel;
import distancemodel.DistanceModelFactory;
import it.gssi.cs.core.Analyzer;
import it.gssi.cs.core.QualityEvaluator;

import org.eclipse.epsilon.emc.emf.EmfMetaModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
/**
 * This example demonstrates using the Epsilon Object Language, the core language of Epsilon, in a stand-alone manner 
 * 
 * @author Sina Madani
 * @author Dimitrios Kolovos
 */
public class QualityEvalLauncher {
	
	public static void main(String[] args) {
		
		Path root;
		try {
			root = Paths.get(QualityEvalLauncher.class.getResource("").toURI());
		Path eolRoot = root.getParent().resolve("modelanalyzer");
		Path modelsRoot = root.getParent().resolve(Analyzer.getRepoFolder(eolRoot+ "/settings.properties"));
		
		Path mmRoot = root.getParent().resolve("metamodels");
		QualityEvaluator evaluator = new QualityEvaluator();
		
		evaluator.registerMMs(modelsRoot);	
		evaluator.evaluate(modelsRoot,eolRoot,mmRoot);	
		}
		catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
	
	


	
	


	

	
	

	

	
}


