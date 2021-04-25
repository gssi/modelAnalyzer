package it.gssi.cs.launcher;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import it.gssi.cs.core.Analyzer;
import it.gssi.cs.core.DistanceCalculator;

public class DistanceMatrixLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int threshold_distance=70;
		Path root;
		try {
			root = Paths.get(AnalyzerLauncher.class.getResource("").toURI());
		Path eolRoot = root.getParent().resolve("modelanalyzer");
		Path mmRoot = root.getParent().resolve("metamodels");
		Path modelsRoot = root.getParent().resolve(Analyzer.getRepoFolder(eolRoot+ "/settings.properties"));
		

		Analyzer analyzer = new Analyzer();
		Analyzer.registerMMs(modelsRoot);
		
		
		DistanceCalculator distancecalculator = new DistanceCalculator();
		distancecalculator.computeDistance(modelsRoot,threshold_distance,eolRoot);
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
