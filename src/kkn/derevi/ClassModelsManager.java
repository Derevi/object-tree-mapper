package kkn.derevi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassModelsManager implements Serializable {
    private List<String> classes;
    private List<String> methods;
    private List<String> dependencies;
    private BufferedReader inputReader;
    ClassModelsCatalogGenerator classModelsCatalogGenerator;
    private List<ClassModel> classModelsCatalog;
    //private static final long private static final long serialVersionUID = 1L;

    public ClassModelsManager() {

        inputReader = new BufferedReader(new InputStreamReader(System.in));


        }

        //Todo read input and create classModel
        //todo allow for modification of any classModel as well as adding to and removing from list
        //Todo create test class, check for null, and out of bounds exception



    public void run(){

        String choice = "";
        do{
            switch (choice){
                case "new":
                    classModelsCatalog = new ArrayList<>();
                case "load":
                    classModelsCatalog = classModelsCatalogGenerator.load();
                case "render":
                    //todo put in its own method named: renderClassModelsCatalog
                    if(classModelsCatalog.isEmpty()){
                        System.out.printf("The catalouge is empty, there is nothing to render, please add");
                        break;
                    }
                    ClassMethodsAndDependenciesAssembler classMethodsAndDependenciesAssembler = new ClassMethodsAndDependenciesAssembler(classModelsCatalog);
                    classMethodsAndDependenciesAssembler.getAllClassesAndDependencies();
                    classMethodsAndDependenciesAssembler.getAllClassesAndMethods();
                    List<String> allClasses = new ArrayList<>();
                    allClasses.addAll(classMethodsAndDependenciesAssembler.getAllClassesAndMethods().keySet());
                    //new sorter interface

                    //treesort and drawer
                case "save":
                    classModelsCatalog = classModelsCatalogGenerator.save();
                case "save&exit":
                    classModelsCatalog = classModelsCatalogGenerator.save();
                    System.exit(1);
                case "exit":
                    System.out.printf("Are you sure you want to exit without saving");
                    //yes = exit
                    // no = break repeat loop souf enter new command
                    System.exit(1);
                default:
                    System.out.printf("enter command again");

            }
            //write out all contents in table format after loading
            ClassEditor classEditor = new ClassEditor(classModelsCatalog);
            classEditor.editorPrompter();
        }while (true);//prompt user




    }

}

