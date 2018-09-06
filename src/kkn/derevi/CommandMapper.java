package kkn.derevi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandMapper {

    Map<String, Editor> commandMap;
    List<ClassModel> classCatalog;

    public CommandMapper(List<ClassModel> classCatalog) {
        this.classCatalog = classCatalog;
    }

    public Map<String, Editor> getCommandMap(){
        commandMap = new HashMap<>();
        Editor insertor = new Insertor(classCatalog);
        Editor deletor = new Deletor(classCatalog);
        commandMap.put("insert", insertor);
        commandMap.put("delete", deletor);
        return commandMap;

    }
}
