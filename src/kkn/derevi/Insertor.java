package kkn.derevi;

import java.util.List;

public class Insertor extends EditorTemplate implements Editor {


    public Insertor(Prompter prompter) {
        super(prompter);
    }

    @Override
    public List<Object> edit(List<Object> selectedList) {
        System.out.printf("input a name for a new item to be added:");
        prompter.requestSelection(newName, indexChoice);
        if(newName.equals("x")){return selectedList;}
        selectedList.add(newName);
        resetUserSelection();
        return edit(selectedList);
    }

}
