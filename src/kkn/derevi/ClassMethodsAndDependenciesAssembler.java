package kkn.derevi;

import java.util.List;
import java.util.Map;

public class ClassMethodsAndDependenciesAssembler {

    private List<ClassModel> allClassModelsList;
    private Map<String, List<String>> allClassesAndMethods;
    private Map<String, List<String>> allClassesAndDependencies;

    public ClassMethodsAndDependenciesAssembler(List<ClassModel> allClassModelList) {
        this.allClassModelsList = allClassModelsList;
        for(ClassModel classModel:allClassModelList) {
            allClassesAndMethods.put(classModel.getClassName(), classModel.getClassMethods());
            allClassesAndDependencies.put(classModel.getClassName(), classModel.getClassDependencies());
        }
    }

    public List<ClassModel> getAllClassModelsList() {
        return allClassModelsList;
    }

    public Map<String, List<String>> getAllClassesAndMethods() {
        return allClassesAndMethods;
    }

    public Map<String, List<String>> getAllClassesAndDependencies() {
        return allClassesAndDependencies;
    }

}
