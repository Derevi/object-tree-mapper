package kkn.derevi;

import java.util.ArrayList;
import java.util.List;

public class UMLAppicationvertwo {
    Prompter prompter;
    int indexSelection;
    String newName;

    public void run() {
        //pass in command map as a parameter;
        prompter = new Prompter();

        System.out.printf("Please select option load or save");
        //if selection load
        prompter.requestSelection(indexSelection);
        if (indexSelection == 1) {
            ClassModelsCatalogGenerator classModelsCatalogGenerator = new ClassModelsCatalogGenerator();
            if (indexSelection == 2) {
                classModelsCatalogGenerator.load("user input");
            }

            //classCatalog now set...
            //Class catalog edit menu...
            //add delete rename OR edit class model

            //if class model choosen .
            //select list, add delete rename, select another model
            //x select list\
            //x out to other menu
            //x out to catalog editor


            //if selection save
            List<ClassModel> classCatalog = new ArrayList<>();
            classModelsCatalogGenerator.save("user  input", classCatalog);

            System.out.printf("Make an edit to the class catalog please select an option");
            //user input index,
            //if x run();
            //get.key from map and run command
            //or select model for editing


            System.out.printf("Please choose an otopion for class model");
            //selector tool to det list
            //reset class model recall func
            //x to go back to catalog

        }

    }

    public void prompts(){
        System.out.printf("Please select one of the following lists to edit: %n" +
                "(1) Methods list of %s%n" +
                "(2) Dependency list of %s %n", selectedClassModel.getClassName(), selectedClassModel.getClassName());


        System.out.printf("%nPlease select one of the following editing options:%n" +
                "(1) Add an element to the curretly selected list%n" +
                "(2) Delete an element from the currently selected list by typing in the index number of that element%n" +
                "(3) Rename an element that already exists in the list%n" +
                "(4) Select a different list%n" +
                "(5) Exit class list editor.%n" );

        System.out.printf("%nPlease select an option by typing in the number : " +
                "%n1. Create new UML diagram" +
                "%n2. Load UML diagram" +
                "%n3. Save current UML diagram" +
                "%n4. Save UML diagram to a new file" +
                "%n5. exit%n");
    }
}
