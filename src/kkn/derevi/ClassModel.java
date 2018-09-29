package kkn.derevi;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ClassModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<String> classMethods;
    private List<String> classDependencies;
    private String className;


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

    public String wordBox(){
        return
        topBorder() +"\n" +
        getClassNameInBox() +"\n" +
        botBorder();
    }

    private String topBorder(){
        char[] additionalHook = new char[];
        char[] topBorder = new char[className.length()+2];
        Arrays.fill(topBorder, '-');
        topBorder[topBorder.length/2]= '|';
        additionalHook[topBorder.length/2] = '|';
        return additionalHook.toString()+'\n'+topBorder.toString();

    }

    private String botBorder(){
        char[] botBorder = new char[className.length()+2];
        char[] botBorderHookExt = new char[className.length()+2];
        Arrays.fill(botBorder, '-');
        int splitBottomBorder = botBorder.length/getClassDependencies().size();
        int i=splitBottomBorder;
        List<Integer> hookloc = new ArrayList<>();
        while(i< botBorder.length+2){
            botBorder[i] = '|';
            botBorderHookExt[i]= '|';
            hookloc.add(i);
            i=+splitBottomBorder;
        }
        return botBorder.toString();
    }

    public int getTopConnectionIndex(){
        return topBorder().toString().indexOf('|');
    }

    public List<Integer> getBotConnectionIndexes(){
        String[] some= botBorder().toString().split("|");
        //list to string
    }

    private String getClassNameInBox(){
        return "|"+getClassName()+"|";
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
