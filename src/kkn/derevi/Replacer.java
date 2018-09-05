package kkn.derevi;

import java.util.List;

public class Replacer extends EditorTemplate implements Editor {


//uncessary class?
    public Replacer(List<ClassModel> classCatalog) {
        super(classCatalog);
    }

    @Override
    public List<ClassModel> edit(String Name) {
        delete(classCatalog.get());
        classCatalog.add(super.createNewClassModel(Name));
        return classCatalog;
    }

    @Override
    public List<String> edit(List<String> selectedList, String Name) {
        selectedList = delete(selectedList,Name);
        selectedList.add(Name);
        return selectedList;
    }
/*
    @Override
    public List<Object> edit(List<Object> selectedList) {
        System.out.printf("Select item that you wish to rename by typing its index:");
        prompter.requestSelectionAndName(newName, indexChoice);
        if(newName.equals("x")){return selectedList;}
        selectedList.set(indexChoice, newName);
        resetUserSelection();
        return edit(selectedList);
    }
    */

private List<ClassModel> delete(ClassModel classModel){
    if(classCatalog.contains(classCatalog)){
        classCatalog.remove(classModel);
    }
    return classCatalog;
}

    private List<String> delete(List<String> selectedList, String name){
        if(selectedList.contains(name)){
            selectedList.remove(name);
        }
        return selectedList;
    }



}

