package kkn.derevi;

import java.util.*;

public class TreeTierSort implements ClassOrganizer {

    private int tier = 0;
    private int index;
    private boolean runOnce = true;


    public TreeTierSort() {
    }

    @Override
    public List<List<String>> classDependencyTierSort(List<String> classListPerTierSort, Map<String, List<String>> dependencyMap) {

        List<String> classList = new ArrayList<>();
        if(runOnce){classList.addAll(classListPerTierSort); runOnce=false;}
        List<String> dependencyList = dependencyListGenerator(dependencyMap);
        List<List<String>> tierList = new ArrayList<>();
        index = classListPerTierSort.size();

        if (classList.size() == 0) {
            tier++;
            tierList.add(tier, classListPerTierSort);
            tier = 0;
            runOnce = true;
            return tierList;
        } else if (index == 0) {
            tierList.add(tier, classListPerTierSort);
            classListPerTierSort.clear();
            classListPerTierSort.addAll(classList);
            return classDependencyTierSort(classListPerTierSort, dependencyMap);
        } else if (!(dependencyList.contains(classListPerTierSort.get(index)))) {
            return classDependencyTierSort(listWithRemovedElement(classList), mapWithRemovedKey(dependencyMap, classListPerTierSort.get(index)));
        } else if (dependencyList.contains(classListPerTierSort.get(index))) {
            return classDependencyTierSort(listWithRemovedElement(classListPerTierSort), dependencyMap);
        } else {
            return classDependencyTierSort(listWithRemovedElement(classList), dependencyMap);
        }


    }

    private List<String> listWithRemovedElement(List<String> list) {
        list.remove(index);
        return list;
    }

    private Map<String, List<String>> mapWithRemovedKey(Map<String, List<String>> map, String key) {
        map.remove(key);
        return map;
    }

    private List<String> dependencyListGenerator(Map<String, List<String>> dependencyMap) {
        Collection<List<String>> dependencyListCollection = new ArrayList<>(dependencyMap.values());
        List<String> dependencyList = new ArrayList<>();
        dependencyListCollection.forEach(dependencyList::addAll);
        return dependencyList;
    }
}





