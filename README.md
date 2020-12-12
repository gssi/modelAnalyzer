# model Analyzer
Model analyzer is a workbench providing metrics calculated on a given model

Given a weight for the instances (weight_i) and a weight for the feature (weight_f), the script will calculate the size of the input model as:

foreach (istance i in instances) { 
	
	given c as the class of the instance i;
		
	foreach (feature in AllStructuralFeatures(c)) { 
		
		if(feature is set in i)  setfeatures = setfeatures+ weight_f;
	}
	size = nrinstances +  ((setfeatures/AllStructuralFeatures(c).size) + weight_i);
}

return size;

