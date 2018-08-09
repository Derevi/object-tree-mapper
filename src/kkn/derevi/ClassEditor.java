package kkn.derevi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ClassEditor {

    private List<ClassModel> classModelsCatalog;
    BufferedReader inputReader;

    public ClassEditor(List<ClassModel> classModelsCatalog) {
        this.classModelsCatalog = classModelsCatalog;
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void editorPrompter() throws IOException, InputMismatchException {
        String choice = "";
        String newClassName= "";
        boolean continueEditing = true;
        do {

        printAllClassModels();

        System.out.printf("%n%nPlease select an option to edit a Class:" +
                "%n1. Create new class" +
                "%n2. Rename existing class" +
                "%n3. Delete existing class" +
                "%n4. Edit methods or dependencies of a class" +
                "%n5. Draw classes as a tree diagram" +
                "%n6. Exit editor");
        choice = inputReader.readLine();
        int editClassModel = 0;
        int editListInClassModel = 1;
        int selectedClassModelIndex = inputStringToInt(inputReader.readLine());
        ClassModel selectedClassModel = classModelSelector(selectedClassModelIndex);

            if (classModelsCatalog.isEmpty()){ choice="1";}



            switch (choice) {
                    case "newClass":
                        newClassName = inputReader.readLine();
                        ClassModel newClassModel = new ClassModel(newClassName);
                        editClassModelList(newClassModel);

                    case "renameClassModel":
                        newClassName = inputReader.readLine();
                        renameClassName(selectedClassModel, newClassName);
                        break;
                    case "deleteClassModel":
                        deleteClassModel(selectedClassModel);
                        break;
                    case "editClassModelList":
                        selectedClassModel = classModelSelector(selectedClassModelIndex);
                        editClassModelList(selectedClassModel);
                        break;

                    case "render":
                        //todo put in its own method named: renderClassModelsCatalog
                        if (classModelsCatalog.isEmpty()) {
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
                        break;

                    case "exitEditor":
                        continueEditing = false;
                        break;
                    default:
                        System.out.printf("enter command again");
                        break;

                }

            } while (continueEditing);
    }






    private void printAllClassModels(){
        classModelsCatalog.forEach(classModel -> {
                int i = 1;
                System.out.printf("%n(d%) %s%n", i, classModel);
                i++;
    });
    }


    private void editClassModelList(ClassModel classModel) throws IOException {
            String choice = "";
            String elementName = "";
            boolean continueListEdit = true;
            int selectedClass;
            int elementIndex;
            int selecetedListIndex;
        List<String> selectedList;
            //select class
        //wrap do while
        do{
            choice = inputReader.readLine();
            String selectedListInput = inputReader.readLine();
            selecetedListIndex = Integer.parseInt(selectedListInput);

        selectedList = listSelector(classModel, selecetedListIndex);

            switch (choice){
                case "add":
                    addElementToSelectedList(selectedList, elementName);
                case "delete":
                    deleteElementFromSelectedList(selectedList, elementName);
                case "rename":
                    renameElementFromSelectedList(selectedList, elementIndex, elementName);
                case "replace list": //reserve this as hidden option depending in UI
                    List<String> replacementList = new ArrayList<>();
                    replaceAllElementsFromSelectedList(selectedList, replacementList);
                case "exit class list editor, and select class":
                    continueListEdit = false;
                    break;
                default:
                    System.out.printf("%nPlease enter a valid choice, try again%n");
                    break;


        }
        }while(true);//determine what boolean

    }




    private List<String> listSelector(ClassModel selectedClassModel, int selectedListIndex){
        int classMetodsIndex = 0;
        int classDependencyIndex = 1;
        List<String> selectedList = new ArrayList<>();

        if(selectedListIndex == classMetodsIndex){
            selectedList = selectedClassModel.getClassMethods();
            return selectedList;
        }
        else if (selectedListIndex == classDependencyIndex){
            selectedList = selectedClassModel.getClassDependencies();
            return selectedList;
        }

        else{
            System.out.printf("please select only one of 0 or 1");
            selectedListIndex = 0;//req new user inp
            return listSelector(selectedListIndex);
        }
    }

    private int inputStringToInt(String input) throws IOException {

        int inputToInt = Integer.parseInt(input);
        return inputToInt;
    }



    private void deleteClassModel(ClassModel classModel) {
        classModelsCatalog.remove(classModel);
    }

    private void renameClassName(ClassModel classModel, String newClassName) {

        if(newClassName.isEmpty()){
            System.out.printf("you did not type anything in, would you like to delete this entire class model?");
            newClassName = "user prompt";
            String userChoice="yes or no";
            if(userChoice == "yes"){
                deleteClassModel(classModel);
            }else {
            renameClassName(classModel, newClassName);
            }
        }

        else{classModel.setClassName(newClassName);}

    }
    private ClassModel classModelSelector(int selectionIndex) throws IOException {

        if(selectionIndex>classModelsCatalog.size() || selectionIndex<0){
            System.out.printf("%nPlease enter a number from the classes in the list:%n");
            selectionIndex = inputStringToInt(inputReader.readLine());
            return classModelSelector(selectionIndex);
        }
        return classModelsCatalog.get(selectionIndex);
    }

    private void addElementToSelectedList(List<String> selectedList, String elementName) {
        selectedList.add(elementName);
    }

    private void deleteElementFromSelectedList(List<String> selectedList, String elementName) {
        selectedList.remove(elementName);
    }

    private void renameElementFromSelectedList(List<String> selectedList, int elementIndex, String newElementName) {
       selectedList.set(elementIndex, newElementName);
    }

    private void replaceAllElementsFromSelectedList(List<String> selectedList, List<String> replacementList) {
        selectedList.clear();
        selectedList.addAll(replacementList);
    }



}
/*

Legacy CODE: Record of legacy code kept for the different possible usage scenario depending on typeof interface.

    public void addClassDependency(int selectedClass, String dependencyName) {
        classModelsCatalog.get(selectedClass).getClassDependencies().add(dependencyName);
    }

    public void deleteClassDependency(int selectedClass, int dependency) {
        classModelsCatalog.get(selectedClass).getClassDependencies().remove(dependency);
    }

    public void renameClassDependency(int selectedClass, int dependency, String newDependencyName) {
        classModelsCatalog.get(selectedClass).getClassDependencies().set(dependency, newDependencyName);
    }

    public void replaceAllClassDependency(int selectedClass, List<String> newDependencyList) {
        classModelsCatalog.get(selectedClass).getClassDependencies().clear();
        classModelsCatalog.get(selectedClass).getClassDependencies().addAll(newDependencyList);
    }


    public void addClassMethod(int selectedClass, String newMethodName) {
        classModelsCatalog.get(selectedClass).getClassMethods().add(newMethodName);
    }

    public void deleteClassMethod(int selectedClass, int methodIndex) {
        classModelsCatalog.get(selectedClass).getClassMethods().remove(methodIndex);
    }

    public void renameClassMethod(int selectedClass, int methodIndex, String newMethodName) {
        classModelsCatalog.get(selectedClass).getClassMethods().set(methodIndex, newMethodName);
    }

    public void replaceAllClassMethods(int selectedClass, List<String> newMethodsList) {
        classModelsCatalog.get(selectedClass).getClassDependencies().clear();
        classModelsCatalog.get(selectedClass).getClassDependencies().addAll(newMethodsList);
    }
*/
