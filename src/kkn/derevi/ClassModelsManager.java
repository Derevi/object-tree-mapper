package kkn.derevi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ClassModelsManager {
    ClassModelsCatalogGenerator classModelsCatalogGenerator;
    private List<ClassModel> classModelsCatalog;

        //Todo create test class, check for null, and out of bounds exception

    public void run(){
        boolean canExit = false;
        String choice = "";
        String fileName="";
        boolean switchChoiceIsValid = false;
        try(BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));)
        {do{
            do {

                System.out.printf("%nPlease select an option by typing in the number : " +
                        "%n1. Create new UML diagram" +
                        "%n2. Load UML diagram" +
                        "%n3. Save current UML diagram" +
                        "%n4. Save UML diagram to a new file" +
                        "%n5. exit%n");

                choice = inputReader.readLine();
                choiceBasedFileCreator(choice, fileName);

                switch (choice) {

                    case "1": //Create new UML diagram
                        classModelsCatalog = new ArrayList<>();
                        switchChoiceIsValid = true;
                        break;

                    case "2": //Load UML diagram
                        classModelsCatalog = classModelsCatalogGenerator.load(fileName);
                        switchChoiceIsValid = true;
                        break;
                    case "3": //Save current UML diagram
                        classModelsCatalogGenerator.save(fileName, classModelsCatalog);
                        switchChoiceIsValid = true;
                        break;
                    case "4": //Save UML diagram to a new file
                        classModelsCatalogGenerator.save(fileName, classModelsCatalog);
                        switchChoiceIsValid = true;
                        break;
                    case "5":
                        System.out.printf("Exiting");
                        System.exit(1);
                    case "creatingNewFile":
                        System.out.printf("%nPlease type in your desired file name:%n");
                        fileName = inputReader.readLine();
                        break;
                    default:
                        System.out.printf("enter command again");
                        break;

                }

            } while (switchChoiceIsValid);
                //write out all contents in table format after loading
                System.out.printf("%nEntering editing mode now.%n");
                ClassEditor classEditor = new ClassEditor(classModelsCatalog);
                classEditor.editorPrompter();
        }while(!switchChoiceIsValid);

        } catch(IOException ioe){
            System.out.printf("Please enter a valid input");
            ioe.printStackTrace();

        }catch (InputMismatchException ime){
            System.out.printf("Please enter the correct input, if the prompt asks for a number please only input a number.");
            ime.printStackTrace();
        }






    }

    private String choiceBasedFileCreator(String choice, String fileName){
        if(choice =="3" && !fileName.isEmpty()){
            return choice;
        }

        if(choice =="1"||
                choice =="2"||
                choice =="3"||
                choice =="4"&&
                fileName.isEmpty()){
            System.out.println("A file name is required!");
            choice = "creatingNewFile";
        }
            return choice;
    }



}

