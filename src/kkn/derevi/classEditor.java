package kkn.derevi;

import java.util.List;
import java.util.Map;

public class classEditor {

    private ClassModel classModel;
    private List<String> methodsList;
    private List<String> dependencyList;


    public classEditor(ClassModel classModel) {
        this.classModel = classModel;
        this.dependencyList = classModel.getClassDependencies();
        this.methodsList = classModel.getClassMethods();
    }

    public List<String> editClassMethodList(String className, String originalMethodName, String renamedMethod) {
        if (renamedMethod == null) {
            methodsList.remove(originalMethodName);
            return methodsList;
        }
        methodsList.set(methodsList.indexOf(originalMethodName), renamedMethod);
        return methodsList;
    }

    public void editClassName(String renamedClass) {
        classModel.setClassName(renamedClass);
    }

    public void deleteClassModel(ClassModel classModel) {
        classModel = null; //deleted by garbage collector
    }

    public List<String> addClassDependency(String dependencyName) {
        dependencyList.add(dependencyName);
        return dependencyList;
    }

    public List<String> removeClassDependency(String dependencyName) {
        dependencyList.add(dependencyName);
        return dependencyList;
    }


}
