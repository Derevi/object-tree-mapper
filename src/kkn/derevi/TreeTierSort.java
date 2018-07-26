package kkn.derevi;

import java.util.*;

public class TreeTierSort implements ClassOrganizer {

    private int tier = 0;
    private int index;
    private boolean runOnce = true;
    private List<List<String>> tierList;
    private List<String> classList;

    public TreeTierSort() {
       tierList = new ArrayList<>();
       classList = new ArrayList<>();
    }

    @Override
    public List<List<String>> classDependencyTierSort(List<String> classList, Map<String, List<String>> dependencyMap) {

        classList = new ArrayList<>();
        List<String> dependencyList = dependencyListGenerator(dependencyMap);
        Queue<String> classQueue = new ArrayDeque<>(classList);

        if (dependencyMap.isEmpty()) {
            return tierList;
        } else if (tierList == null) {
            classList.removeAll(dependencyList);
            classQueue.addAll(classList);
            tierList.get(tier).addAll(classList);
            tier++;
            return classDependencyTierSort(classList, dependencyMap);
        } else if (dependencyMap.keySet().contains(classQueue.peek())) {
            tierList.get(tier).addAll(dependencyMap.get(classQueue.peek()));
            dependencyMap.remove(classQueue.poll());
            return classDependencyTierSort(classList, dependencyMap);
        } else if (!classQueue.isEmpty()) {
            classList.remove(classQueue.peek());
            return classDependencyTierSort(classList, dependencyMap);
        } else {
            classList.addAll(tierList.get(tier));
            tier++;
            return classDependencyTierSort(classList, dependencyMap);
        }
    }


    private List<String> dependencyListGenerator(Map<String, List<String>> dependencyMap) {
        Collection<List<String>> dependencyListCollection = new ArrayList<>(dependencyMap.values());
        List<String> dependencyList = new ArrayList<>();
        dependencyListCollection.forEach(dependencyList::addAll);
        return dependencyList;
    }
}


