package kkn.derevi;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args){

        String[][] test = new String[5][5];
        List<String> listt = new ArrayList<>(5);
        List<List<String>> asfe= new ArrayList<>(5);
        System.out.printf(test[1][3]);



        Map<String, List<String>> testMap = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add("1");list1.add("2");list1.add("3");list1.add("4");
        List<String> list2 = new ArrayList<>();
        list2.add("5");list2.add("6");list2.add("7");list2.add("8");
        List<String> list3 = new ArrayList<>();
        list3.add("9");list3.add("10");list3.add("11");
        List<String> list4 = new ArrayList<>();
        list4.add("12");list4.add("13");

       // sortlist(list1, 3);

        testMap.put("list1",list1);
        testMap.put("list2",list2);
        testMap.put("list3",list3);
        testMap.put("list4",list4);

        Collection<List<String>> testMapListCollection = new ArrayList<>(testMap.values());
        List<String> testMapList = new ArrayList<>();

        List<String> list5 = new ArrayList<>();

        testMapListCollection.forEach(testMapList::addAll);



        ClassOrganizer classOrganizer;
        List<String> classList;
        Map<String, List<String>> dependencyMap;
        Map<String, List<List<String>>> tierListMap;
        List<List<String>> tierList;

            List<String> dependencyFor1 = new ArrayList<>();
            dependencyFor1.add("2");
            dependencyFor1.add("3");
            dependencyFor1.add("");
            List<String> dependencyFor2 = new ArrayList<>();
            dependencyFor2.add("4");
            dependencyFor2.add("5");
            dependencyFor2.add("6");
            List<String> dependencyFor3 = new ArrayList<>();
            dependencyFor3.add("7");
            dependencyFor3.add("8");
            dependencyFor3.add("9");
            List<String> dependencyFor10 = new ArrayList<>();
            dependencyFor3.add("4");
            dependencyFor3.add("11");
            dependencyFor3.add("12");
            List<String> dependencyFor13 = new ArrayList<>();
            dependencyFor3.add("3");


            classList = new ArrayList<>();
            classList.addAll(dependencyFor1);
            classList.addAll(dependencyFor2);
            classList.addAll(dependencyFor3);
            classList.addAll(dependencyFor10);
            classList.addAll(dependencyFor13);
            classList.add("1");
            classList.add("10");
            classList.add("13");

            dependencyMap = new HashMap<>();


            dependencyMap.put("1", dependencyFor1);
            dependencyMap.put("2", dependencyFor2);
            dependencyMap.put("3", dependencyFor3);
            dependencyMap.put("10", dependencyFor10);
            dependencyMap.put("13", dependencyFor13);
            List<List<String>> asdf = new ArrayList<>();
        list1.clear();
            asdf.add(list1);
            asdf.get(0).add("1");
            classDependencyTierSort(dependencyMap,asdf,0,0);


           // classOrganizer = new TreeTierSort(dependencyMap, classList);
            //classOrganizer.mapTierTreeListByParentBranch(classList, dependencyMap);
           // tierListMap = new HashMap<>(classOrganizer.mapTierTreeListByParentBranch(classList, dependencyMap));
        System.out.printf("end");



    }

    public static List<List<String>> sortlist(List<String> list, int index) {
        List<List<String>> listlist = new ArrayList<>();
        listlist.add(list);


        if (list.size() > 0) {
            listlist.get(0).add(list.get(index));
            //list.remove(index);
            return sortlist(list, index--);

        } else {
            return listlist;
        }

    }

    public static List<List<String>> classDependencyTierSort(Map<String, List<String>> dependencyMap, List<List<String>> tierList, int tier, int tierIndex) {

        String tierListElement = tierList.get(tier).get(tierIndex);
        int nextTier = tier +1;



        if ((tier + tierIndex)== 0) {
            tierList.get(nextTier).addAll(dependencyMap.get(tierListElement));
            dependencyMap.remove(tierListElement);
            return classDependencyTierSort(dependencyMap, tierList, tier++, tierIndex);
        } else if (dependencyMap.keySet().contains(tierListElement)) {
            tierList.get(nextTier).addAll(dependencyMap.get(tierListElement));
            dependencyMap.remove(tierListElement);
            return classDependencyTierSort(dependencyMap, tierList, tier, tierIndex++);
        }else if(tierList.get(tier).isEmpty()){
            return tierList;
        }else if (tierList.get(tier).size()==tierIndex) {
            return classDependencyTierSort(dependencyMap, tierList, tier++, 0);
        }else {
            return classDependencyTierSort(dependencyMap, tierList, tier, tierIndex++);
        }
    }
}






//Todo class generator, user input, prompt
//TODO text based drawer, this is a terminal app.
//TODO test classes
