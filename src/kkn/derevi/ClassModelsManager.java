package kkn.derevi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;

public class ClassModelsManager implements Serializable {
    private List<String> classes;
    private List<String> methods;
    private List<String> dependencies;
    private BufferedReader inputReader;
    private List<ClassModel> classModelsCatalog;
    //private static final long private static final long serialVersionUID = 1L;

    public ClassModelsManager() {

        inputReader = new BufferedReader(new InputStreamReader(System.in));
        //create new catalogue
        //load
        //save
        //
        }







        //Todo read input and create classModel
        //todo allow for modification of any classModel as well as adding to and removing from list
        //Todo create test class, check for null, and out of bounds exception
        //Todo make serializable







    public void run(){

        String choice = "";
        do{

            try(){




                //switch
                //case 1 addNew class
                //case 2 Edit class -> name or method
                //case 3 remove class
                //exit program or edit a different UML diagram?

                //draw map
                //draw tree

                switch (choice){
                    case "add":;
                    case "edit":
                        //class name, methods or dependenicies?
                        List<String> methods;
                        List<String> dependencies;
                        ClassModel classModel = new ClassModel("", methods, dependencies);
                        classModelsCatalog.add();

                        classModelsCatalog.get("1").setClassName("");
                        classModelsCatalog.get("1").getClassDependencies("1").remove("");
                        classModelsCatalog.get("1").getClassDependencies().set("input", "input");
                        classModelsCatalog.get("1").getClassMethods("1").remove("");
                        classModelsCatalog.get("1").getClassMethods().set("input", "input");

                    case "remove":
                        classModelsCatalog.remove("name");

                    case "load":
                        classModelsCatalog = generateClassModelCatalog();
                    case "save":;
                    case "save and exit":;
                    case "exit":;

                }


            }


        }while(true);
    }

    public List<ClassModel> generateClassModelCatalog() throws IOException {
        String userChoice = inputReader.readLine();
        return ClassModelsCatalog.load(userChoice);

    }


    public List<ClassModel> classCatalogEditor(){
         return  classModelsCatalog;
    }

    public void saveClassModelCatalog(String fileName, List<ClassModel> classModelsCatalog) throws IOException {
        fileName = inputReader.readLine();
        ClassModelsCatalog.save(fileName, classModelsCatalog);

    }


}
