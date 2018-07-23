package kkn.derevi;

import java.util.List;
import java.util.Map;

public class ClassModel {

    private List<String> classMethods;
    private List<String> classDependencies;
    private String className;


    public ClassModel(String className, List<String> classMethods, List<String> classDependencies) {
        this.className = className;
        this.classDependencies = classDependencies;
        this.classMethods = classMethods;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getClassMethods() {
        return classMethods;
    }

    public void setClassMethods(List<String> classMethods) {
        this.classMethods = classMethods;
    }

    public List<String> getClassDependencies() {
        return classDependencies;
    }

    public void setClassDependency(List<String> classDependencies) {
        this.classDependencies = classDependencies;
    }

}
