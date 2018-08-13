package kkn.derevi;

import java.util.List;

public class Deletor extends EditorTemplate implements Editor {


    public Deletor(Prompter prompter) {
        super(prompter);
    }

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


    }









