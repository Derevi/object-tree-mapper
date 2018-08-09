package kkn.derevi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class EditorForClassMethodsAndDependencies {
    private ClassModel classModel;
    BufferedReader inputReader;


    public void editClassModelList(ClassModel classModel) throws IOException, InputMismatchException {
        this.classModel = classModel;
        inputReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> selectedList;
        String elementName = "";
        boolean continueListEdit = true;
        String choice = "";

        do{
            choice = inputReader.readLine();
            selectedList = listSelector(classModel);
            printAllSwitchCases();

            switch (choice){
                case "1":
                    addElementToSelectedList(selectedList, elementName);
                case "2":
                    deleteElementFromSelectedList(selectedList, elementName);
                case "3":
                    renameElementFromSelectedList(selectedList);
                case "4":
                    selectedList = listSelector(classModel);
                case "replace list": //reserve this as hidden option depending until UI is determined
                    List<String> replacementList = new ArrayList<>();
                    replaceAllElementsFromSelectedList(selectedList, replacementList);
                case "5":
                    continueListEdit = false;
                    break;
                default:
                    System.out.printf("%nPlease enter a valid choice, try again%n");
                    break;


            }
        }while(true);//determine what boolean

    }

    private List<String> listSelector(ClassModel selectedClassModel) throws IOException, InputMismatchException {

        List<String> selectedList;
        int classMetodsIndex = 1;
        int classDependencyIndex = 2;


        System.out.printf("Please select one of the following lists to edit: %n" +
                "(1) Methods list of %s%n" +
                "(2) Dependency list of %s %n", selectedClassModel.getClassName(), selectedClassModel.getClassName());

        int selectedListIndex = Integer.parseInt(inputReader.readLine().trim());

        if(selectedListIndex == classMetodsIndex){
            selectedList = selectedClassModel.getClassMethods();
            return selectedList;
        }
        else if (selectedListIndex == classDependencyIndex){
            selectedList = selectedClassModel.getClassDependencies();
            return selectedList;
        }

        else{
            System.out.printf("%nYou typed in an invalid choice, please enter in only the number 1 or 2 that correspond to methods or dependencies respectively. %n");
            return listSelector(classModel);
        }
    }

    private void addElementToSelectedList(List<String> selectedList, String elementName) {
        selectedList.add(elementName);
    }

    private void deleteElementFromSelectedList(List<String> selectedList, String elementName) {
        selectedList.remove(elementName);
    }

    private void renameElementFromSelectedList (List<String> selectedList) throws IOException {
        System.out.printf("%nPlease select an element in the list to rename by typing in the correspondig index:%n");
        int elementIndex = Integer.parseInt(inputReader.readLine().trim());

        if(elementIndex>selectedList.size()|| elementIndex<0){
            System.out.printf("Invalid input please select from the list by typing in a valid input");
            renameElementFromSelectedList(selectedList);
        }
        String newElementName = inputReader.readLine().trim();
        selectedList.set(elementIndex, newElementName);
    }

    private void replaceAllElementsFromSelectedList(List<String> selectedList, List<String> replacementList) {
        selectedList.clear();
        selectedList.addAll(replacementList);
    }

    private void printAllSwitchCases(){
        System.out.printf("%nPlease select one of the following editing options:%n" +
                "(1) Add an element to the curretly selected list%n" +
                "(2) Delete an element from the currently selected list by typing in the index number of that element%n" +
                "(3) Rename an element that already exists in the list%n" +
                "(4) Select a different list%n" +
                "(5) Exit class list editor.%n" );

    }



}
