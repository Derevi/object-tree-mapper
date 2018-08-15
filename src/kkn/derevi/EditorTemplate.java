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


    public void resetUserSelection(){
        newName= "";
        indexChoice = (Integer)null;
    }



}

