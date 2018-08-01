package kkn.derevi;

import java.util.*;

public class TreeTierSort implements ClassOrganizer {

    private Map<String, List<String>> dependencyMap;


    public TreeTierSort() {

    }

    @Override
    public Map<String, List<List<String>>> mapTierTreeListByParentBranch(List<String> classList, Map<String, List<String>> dependencyMap) {
        this.dependencyMap = dependencyMap;


        List<String> dependencyList = dependencyListGenerator(dependencyMap);
        classList.removeAll(dependencyList);
        Map<String, List<List<String>>> tierListMap = new HashMap<>();
        classList.parallelStream().forEach(className -> {
            List<List<String>> tierList = new ArrayList<>();
            List<String> tierZero = new ArrayList<>();
            Queue<String> classQueue = new ArrayDeque<>();
            tierList.add(tierZero);
            tierZero.add(className);
            classQueue.addAll(tierZero);
            boolean isNewList = true;
            tierListMap.put(className, classDependencyTierSort(classQueue, tierList, dependencyMap, isNewList));
        });

        return tierListMap;
    }

    @Override
    public List<List<String>> classDependencyTierSort(Queue<String> classQueue, List<List<String>> tierlist, Map<String, List<String>> dependencyMap, boolean isNewList) {

        if (tierlist.size() == 1) {
            isNewList = true;
            tierlist.add(dependencyMap.get(classQueue.peek()));
            dependencyMap.remove(classQueue.poll());
            classQueue.addAll(tierlist.get((tierlist.size() - 1)));
            return classDependencyTierSort(classQueue, tierlist, dependencyMap, isNewList);
        }else if (dependencyMap.keySet().contains(classQueue.peek())) {
            if (isNewList) {
                tierlist.add(dependencyMap.get(classQueue.peek()));
                dependencyMap.remove(classQueue.poll());
                isNewList = false;
                return classDependencyTierSort(classQueue, tierlist, dependencyMap, isNewList);
            }
            tierlist.get(tierlist.size() - 1).addAll(dependencyMap.get(classQueue.peek()));
            dependencyMap.remove(classQueue.poll());
            return classDependencyTierSort(classQueue, tierlist, dependencyMap, isNewList);
        } else if (classQueue.isEmpty() && isNewList) {
            return tierlist;
        } else if (classQueue.isEmpty()) {
            classQueue.addAll(tierlist.get((tierlist.size() - 1)));
            isNewList = true;
            return classDependencyTierSort(classQueue, tierlist, dependencyMap, isNewList);
        } else {
            classQueue.poll();
            return classDependencyTierSort(classQueue, tierlist, dependencyMap, isNewList);
        }
    }


    private List<String> dependencyListGenerator(Map<String, List<String>> dependencyMap) {
        Collection<List<String>> dependencyListCollection = new ArrayList<>(dependencyMap.values());
        List<String> dependencyList = new ArrayList<>();
        dependencyListCollection.parallelStream().forEach(dependencyList::addAll);
        return dependencyList;
    }

}


