package kkn.derevi;

import java.util.*;

public class TreeTierSort implements ClassOrganizer {

    private List<String> classList;
    private Map<String, List<String>> dependencyMap;


    public TreeTierSort(List<String> classList, Map<String, List<String>> dependencyMap) {
        this.classList = classList;
        this.dependencyMap = dependencyMap;
    }

    public Map<String, List<List<String>>> parallelSort(List<String> classList, Map<String, List<String>> dependencyMap) {
        this.classList = new ArrayList<>(classList);

        List<String> dependencyList = dependencyListGenerator(dependencyMap);
        classList.removeAll(dependencyList);
        Map<String, List<List<String>>> tierListMap = new HashMap<>();
        classList.parallelStream().forEach(className -> {
            List<List<String>> tierList = new ArrayList<>();
            tierList.get(0).add(className);
            tierListMap.put(className, classDependencyTierSort(tierList, 0, 0));
        });
        return tierListMap;
    }


    @Override
    public List<List<String>> classDependencyTierSort(List<List<String>> tierList, int tier, int tierIndex) {

        String tierListElement = tierList.get(tier).get(tierIndex);

        if ((tier + tierIndex)== 0) {
            tierList.get(tier+1).addAll(dependencyMap.get(tierListElement));
            dependencyMap.remove(tierListElement);
            return classDependencyTierSort(tierList, tier++, tierIndex);
        } else if (dependencyMap.keySet().contains(tierListElement)) {
            tierList.get(tier + 1).addAll(dependencyMap.get(tierListElement));
            dependencyMap.remove(tierListElement);
            return classDependencyTierSort(tierList, tier, tierIndex++);
        }else if(tierList.get(tier).isEmpty()){
         return tierList;
        }else if (tierList.get(tier).size()==tierIndex) {
            return classDependencyTierSort(tierList, tier++, 0);
        }else {
            return classDependencyTierSort(tierList, tier, tierIndex++);
        }
    }

    private List<String> dependencyListGenerator(Map<String, List<String>> dependencyMap) {
        Collection<List<String>> dependencyListCollection = new ArrayList<>(dependencyMap.values());
        List<String> dependencyList = new ArrayList<>();
        dependencyListCollection.parallelStream().forEach(dependencyList::addAll);
        return dependencyList;
    }
}


