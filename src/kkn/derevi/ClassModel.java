package kkn.derevi;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
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

    @Override
    public String toString(){
        String all=className + "\n" +className.length();
        for(char c: className.toCharArray()){

            all = all+"-";
        }

        all = all + "\n";
        all= all +"Methods:\t";

        for(String method: classMethods){
            int i=1;
            String numbered = String.valueOf(i);
            all=all + "("+numbered+") "+ method + "\t";
        }

        all = all + "\n";
        all= all +"Dependencies:\t";

        for(String dependency: classDependencies){
            int i=1;
            String numbered = String.valueOf(i);
            all= all + "("+numbered+") "+dependency + "\t";
        }
        all = all + "\n\n";
        return all;
    }

}
