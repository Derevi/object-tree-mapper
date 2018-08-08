package kkn.derevi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<String> classMethods;
    private List<String> classDependencies;
    private String className;
    private ClassEditor classEditor;


    public ClassModel(String className) {
        this.className = className;
        classMethods = new ArrayList<>();
        classDependencies = new ArrayList<>();
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

    public List<String> getClassDependencies() {
        return classDependencies;
    }

}
