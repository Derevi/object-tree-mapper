package kkn.derevi;

import java.util.List;

public class Deletor extends EditorTemplate implements Editor {


    public Deletor(List<ClassModel> classCatalog) {
        super(classCatalog);
    }

    @Override
    public List<ClassModel> edit(String Name) {
        classCatalog.add(super.createNewClassModel(Name));
        return classCatalog;
    }

    @Override
    public List<String> edit(List<String> selectedList, String Name) {
        selectedList.remove(Name);
        return selectedList;
    }





    /*
    @Override
    public List<Object> edit(List<Object> selectedList) {
        this.selectedList = selectedList;
        System.out.printf("Select item that you wish to delete by typing its index:");
        prompter.requestSelection(newName, indexChoice);
        if(newName.equals("x")){return selectedList;}
        selectedList.remove(indexChoice);
        resetUserSelection();
        super.resetUserSelection();
        return edit(selectedList);

    }

    */


    }









