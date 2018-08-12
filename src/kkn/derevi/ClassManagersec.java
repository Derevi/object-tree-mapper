package kkn.derevi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassManagersec {
    Prompter prompt;

    public void runManager(){

        System.out.printf("pelase make a selection ");
        Editor editor;
        //edit/add//replace
        //edit
        List<? extends ClassModel>



        Map<String, Editor> commandMap = new HashMap<>();
        CommandManager commandManager = new CommandManager();
        commandManager.commandEditorMapGenerator(commandMap);
        commandMap.get("replace ").editSelectItem(List, UserPrompt);

    }
}
