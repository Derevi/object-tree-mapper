package kkn.derevi;

import java.util.List;

public class Replacer extends EditorTemplate implements Editor {



    public Replacer(Prompter prompter) {
        super(prompter);
    }

    @Override
    public List<Object> edit(List<Object> selectedList) {
        System.out.printf("Select item that you wish to rename by typing its index:");
        prompter.requestSelection(newName, indexChoice);
        if(newName.equals("x")){return selectedList;}
        selectedList.set(indexChoice, newName);
        return edit(selectedList);
    }

}

