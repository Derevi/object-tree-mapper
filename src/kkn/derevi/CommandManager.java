package kkn.derevi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {

   private final Map<String, Editor> commandMap =new HashMap<>();

    public Map<String, Editor> commandEditorMapGenerator (){
        List<Selector> li;
        if (!(commandMap.size()== li.size())){
            System.out.printf("Command not in map, please add new commands to commandMap in this class...Exiting");
            System.exit(0);
        }








        Prompter prompter = new Prompter();
        Editor replacer = new Replacer();
        Editor inserter = new Insertor();
        Editor deletor= new Deletor();
        List<String> selectedList = new ArrayList<>();
        Editor editor;






        commandMap.put("Replace", );
        commandMap.put("insert", inserter);
        commandMap.put("delete", deletor);

        commandMap.get("Replace/Rename item").editSelectItem(selectedList, prompter);
        commandMap.size();

        return commandMap;
    }

    public void commandSelector(){

    }

    public static void adtomap(String commandName){
        List<String>
        return commandMap;

    }


}
