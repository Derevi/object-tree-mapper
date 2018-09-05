package kkn.derevi;

import java.util.List;
import java.util.Map;

public class EditorTemplate {

    //Prompter prompter;
   // List<Object> selectedList;
    int indexChoice;
    String newName;
    List<ClassModel> classCatalog;


    public EditorTemplate(List<ClassModel> classCatalog) {
        this.classCatalog = classCatalog;
    }

    protected ClassModel createNewClassModel(String Name){
        ClassModel classModel = new ClassModel(Name);
        return classModel;
    }


    public void resetUserSelection(){
        newName= "";
        indexChoice = (Integer)null;
    }

    private List<ClassModel> delete(int index){
        classCatalog.remove(index);
        return classCatalog;
    }



}

