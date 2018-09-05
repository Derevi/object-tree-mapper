package kkn.derevi;

import java.util.List;

public class Insertor extends EditorTemplate implements Editor {


    public Insertor(List<ClassModel> classCatalog) {
        super(classCatalog);
    }

    /*

    @Override
    public List<Object> edit(List<Object> selectedList) {
        System.out.printf("input a name for a new item to be added:");
        prompter.requestSelection(newName, indexChoice);
        if(newName.equals("x")){return selectedList;}
        selectedList.add(newName);
        resetUserSelection();
        return edit(selectedList);
    }

    */

    //pull promper outside

    public List<ClassModel> edit(String Name){
        ClassModel classModel = new ClassModel(Name);
        classCatalog.add(classModel);
        return classCatalog;
    }

    public List<String> edit(List<String> List, String Name){
        List.add(Name);
        return List;
    }


}
