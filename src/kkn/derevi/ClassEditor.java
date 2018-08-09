package kkn.derevi;

import java.util.ArrayList;
import java.util.List;

public class ClassEditor {

    private List<ClassModel> classModelsCatalog;

    public ClassEditor(List<ClassModel> classModelsCatalog) {
        this.classModelsCatalog = classModelsCatalog;
    }

    public void editorPrompter(){
        String choice = "";
        int editClassModel = 0;
        int editListInClassModel = 1;
        int selectedClassModelIndex;//prompt input
        boolean continueEditing = true;
        ClassModel selectedClassModel = classModelsCatalog.get(selectedClassModelIndex);

        if(classModelsCatalog.isEmpty()){
            //please add class and notes its methods and dependencies
        }else {
            do {
                switch (choice) {
                    case "newClass":
                        String newClassName;
                        ClassModel newClassModel = new ClassModel(newClassName);
                        //prompt edit new class now?
                        editClassModelList(newClassModel);

                    case "renameClassModel":
                        String newClassName;
                        renameClassName(selectedClassModel, newClassName);
                        break;
                    case "deleteClassModel":
                        deleteClassModel(selectedClassModel);
                        break;
                    case "editClassModelList":
                        editClassModelList(selectedClassModel);
                        break;

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

                    case "exitEditor":
                        continueEditing = false;
                    default:
                        System.out.printf("enter command again");
                        break;

                }
            } while (continueEditing);
        };



    }


    public void editClassModelList(ClassModel classModel){
            String choice = "";
            String elementName = "";
            int selectedClass;
            int elementIndex;
            int selecetedListIndex;
        List<String> selectedList;
            //select class
        //wrap do while
        do{
        selectedList = listSelector(selecetedListIndex);
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
                default:
                    break;


        }
        }while(true);//determine what boolean

    }




    public List<String> listSelector(ClassModel selectedClassModel, int selectedListIndex){
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



    public void deleteClassModel(ClassModel classModel) {
        classModelsCatalog.remove(classModel);
    }

    public void renameClassName(ClassModel classModel, String newClassName) {

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

    public void addElementToSelectedList(List<String> selectedList, String elementName) {
        selectedList.add(elementName);
    }

    public void deleteElementFromSelectedList(List<String> selectedList, String elementName) {
        selectedList.remove(elementName);
    }

    public void renameElementFromSelectedList(List<String> selectedList, int elementIndex, String newElementName) {
       selectedList.set(elementIndex, newElementName);
    }

    public void replaceAllElementsFromSelectedList(List<String> selectedList, List<String> replacementList) {
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
