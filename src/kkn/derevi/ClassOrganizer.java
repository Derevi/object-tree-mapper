package kkn.derevi;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public interface ClassOrganizer {

    //Todo RENAME interface for improved readability

    public List<List<String>> classDependencyTierSort(Queue<String> classQueue, List<List<String>> tierlist, Map<String, List<String>>dependencyMap, boolean isNewList);
    public Map<String, List<List<String>>> mapTierTreeListByParentBranch(List<String> classList, Map<String, List<String>> dependencyMap);


}
