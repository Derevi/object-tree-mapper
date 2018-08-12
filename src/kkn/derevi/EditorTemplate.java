package kkn.derevi;

import java.util.List;
import java.util.Map;

public class EditorTemplate {

    Prompter prompter;
    List<Object> selectedList;
    int indexChoice;
    String newName;


    public EditorTemplate(Prompter prompter) {
        this.prompter = prompter;


    }



    public List<String> selectList(ClassModel classModel){
        List<String> selectedList;
        String choice = prompter.promptForString();
        if(choice.equals(1)){selectedList = classModel.getClassMethods();
        return selectedList;}
        else if (choice.equals(2)){selectedList = classModel.getClassDependencies();
        return selectedList;}
        else {
            System.out.printf("Enter 1 or 2");
            return selectList(classModel);}

    }

    public void continueListEdit(){

    }
    public List<ClassModel> returnClassCatalog(String input, List<ClassModel> classCatalog){
        if(input.equals("x")||input.equals("l")){return classCatalog;
        }
        return classCatalog;
    }



}

