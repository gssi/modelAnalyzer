pre variables {
var simmetrics : new Native('it.gssi.cs.modelanalyzer.comparison.tools.SimMetricsTool');
var nrclasses: Real=Source!EClass.all.size();
var nrattributes: Real=Source!EAttribute.all.size();
var nrreferences: Real=Source!EReference.all.size();
}

rule EClass
  match s : Source!EClass
  with v : Target!EClass {
  guard: not s.ePackage.name.equals(v.ePackage.name)
  compare {
  
    if(s.name.fuzzyMatch(v.name)){
    	//(s.name+"("+(s.ePackage.name)+")"+"->"+v.name+"("+(v.ePackage.name)+")").println();
    	return true;
    	
    }else{
    	return false;
    }
  }
  
}

rule EAttribute
  match s : Source!EAttribute
  with v : Target!EAttribute {
  
  compare {
  	if(s.name.fuzzyMatch(v.name) and s.etype.isDefined() and v.etype.isDefined() and s.etype.name.fuzzyMatch(v.etype.name) and s.eContainingClass.name.fuzzyMatch(v.eContainingClass.name)){
  // (s.name+"->"+v.name).println();
    	return true;
    }else{
     	
    	return false;
    }
  }
}

rule EReference
  match s : Source!EReference
  
  with v : Target!EReference {
  guard : s.isDefined() and v.isDefined() and s.etype.isDefined() and s.etype.name.isDefined() and v.etype.isDefined() and v.etype.name.isDefined() and ((s.eContainingClass.ePackage.isDefined() and v.eContainingClass.ePackage.isDefined()) and (s.eContainingClass.ePackage.name <> v.eContainingClass.ePackage.name))
  compare {
  	if( s.name.fuzzyMatch(v.name) and s.etype.name.fuzzyMatch(v.etype.name) and s.eContainingClass.name.fuzzyMatch(v.eContainingClass.name) and s.lowerBound==v.lowerBound and s.upperBound==v.upperBound and s.unique==v.unique and s.containment==v.containment){
    	//(s.name+"->"+v.name).println();
   
    	return true;
    }else{
    	return false;
    }
  }
}

rule EPackage
  match s : Source!EPackage
  with v : Target!EPackage {
  
  compare {
 	if(s.name.fuzzyMatch(v.name)){
 //(s.name+"->"+v.name).println();
 		return true;
 	}else{
 	 	return false;
 	}
   
  }
}

operation String fuzzyMatch(other: String): Boolean {
	return simmetrics.similarity(self,other,'Levenshtein') >0.7;
}
