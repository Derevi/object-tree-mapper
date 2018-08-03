package kkn.derevi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassGenerator implements Serializable {
    private List<String> classes;
    private List<String> methods;
    private List<String> dependencies;
    private BufferedReader userInput;
    //private static final long private static final long serialVersionUID = 1L;

    public ClassGenerator() {

        userInput = new BufferedReader(new InputStreamReader(System.in));


        //Todo read input and create classModel
        //todo allow for modification of any classModel as well as adding to and removing from list
        //Todo create test class, check for null, and out of bounds exception
        //Todo make serializable



    }






}
