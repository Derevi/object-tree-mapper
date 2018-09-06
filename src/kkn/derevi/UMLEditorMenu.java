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
        printMenuEachEdit();
        editClassCatalog();

        printMenuEachEdit();
        editClassModel();
    }

    public void editClassCatalog(){
        System.out.println("edit class catalog");
        int commandIndex = prompter.promptForIndex(); //if equals x exit
        String name = prompter.promptForString(); //if equals x exit
        commands.get(commandIndex).edit(name);

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
