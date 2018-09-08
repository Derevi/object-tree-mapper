package kkn.derevi;

import java.util.List;
import java.util.Map;

public class UMLEditorMenu {
    Prompter prompter;
    Map<String, Editor> commands;
    List<ClassModel> classCatalog;
    ClassModel classModel;

    public UMLEditorMenu(List<ClassModel> classCatalog) {
        this.classCatalog = classCatalog;
        this.prompter = new Prompter();
        CommandMapper commandMapper = new CommandMapper(classCatalog);
        commands= commandMapper.getCommandMap();
    }

    public void menu(){

        //loader / start menu

        String optionSelection = prompter.promptForString();
        if(optionSelection.equals("x")){return;}
        int indexSelection = Integer.parseInt(optionSelection);
        catalogEditMenu();
        optionSelection = prompter.promptForString();
        classModelEditMenu();

    }

    public void editClassCatalog(String name){
        System.out.println("edit class catalog");
        int commandIndex = prompter.promptForIndex(); //if equals x exit
        if (name.equals("x")) {return;}
        commands.get(commandIndex).edit(name);
        editClassCatalog(name);

    }
    public void catalogEditMenu(){
        printMenuEachEdit();
        String name = prompter.promptForString();
        if (name.equals("x")) {
            return;
        }
        editClassCatalog(name);
        catalogEditMenu();

    }

    public void classModelEditMenu(){
        printMenuEachEdit();
        String name = prompter.promptForString();
        if (name.equals("x")) {
            return;
        }
        editClassCatalog(name);
        catalogEditMenu();
    }

    public ClassModel getClassModel() {
        int indexChoice =prompter.promptForIndex();
        return classCatalog.get(indexChoice);
    }

    public void editClassModel(){
        System.out.println("Select methods or dependency list from class Model");
        List<String> selectedList = seletClassModelSubList(prompter.promptForIndex());
        commands.get(prompter.promptForIndex()).edit(selectedList, prompter.promptForString());
    }

    public List<String> seletClassModelSubList(int choice) {
        if (choice == 1) {
            return classModel.getClassMethods();
        } else {
            return classModel.getClassDependencies();
        }
    }

    public void printMenuEachEdit(){
        printAllClassModels();
        printAllCommands();
    }

    public void printAllCommands(){
        commands.keySet().forEach(System.out::println);
    }

    public void printAllClassModels(){
        classCatalog.forEach(System.out::println);
    }
}
