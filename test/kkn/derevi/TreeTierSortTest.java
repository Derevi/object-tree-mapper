package kkn.derevi;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TreeTierSortTest {
    ClassOrganizer classOrganizer;
    List<String> classList;
    Map<String, List<String>> dependencyMap;
    Map<String, List<List<String>>> tierListMap;



    //TODO finish Class generator and use dependencyMap and classList as test inputs


    @Before
    public void setUp() throws Exception {
        classOrganizer = new TreeTierSort();

        List<String> dependencyFor1 = new ArrayList<>();
        dependencyFor1.add("2");
        dependencyFor1.add("3");
        //dependencyFor1.add("");
        List<String> dependencyFor2 = new ArrayList<>();
        dependencyFor2.add("4");
        dependencyFor2.add("5");

        List<String> dependencyFor3 = new ArrayList<>();
        dependencyFor3.add("6");
        dependencyFor3.add("7");

        List<String> dependencyFor4 = new ArrayList<>();
        dependencyFor4.add("8");
        dependencyFor4.add("9");

        List<String> dependencyFor5 = new ArrayList<>();
        dependencyFor5.add("10");
        dependencyFor5.add("11");

        List<String> dependencyFor6 = new ArrayList<>();
        dependencyFor6.add("12");
        dependencyFor6.add("13");

        List<String> dependencyFor7 = new ArrayList<>();
        dependencyFor7.add("14");
        dependencyFor7.add("15");

        dependencyMap = new HashMap<>();

        dependencyMap.put("1", dependencyFor1);
        dependencyMap.put("2", dependencyFor2);
        dependencyMap.put("3", dependencyFor3);
        dependencyMap.put("4", dependencyFor4);
        dependencyMap.put("5", dependencyFor5);
        dependencyMap.put("6", dependencyFor6);
        dependencyMap.put("7", dependencyFor7);

        classList=new ArrayList<>();
        classList.addAll(dependencyMap.keySet());

        classList.addAll(dependencyFor1);
        classList.addAll(dependencyFor2);
        classList.addAll(dependencyFor3);
        classList.addAll(dependencyFor4);
        classList.addAll(dependencyFor5);
        classList.addAll(dependencyFor6);
        classList.addAll(dependencyFor7);
    }

    @Test
    public void inputDependencyReturnsMapOfTierList() {
        tierListMap = classOrganizer.mapTierTreeListByParentBranch(classList, dependencyMap);
        assertEquals("proper Map Size", 1, tierListMap.size());
        assertEquals("proper tierList size", 4, tierListMap.get("1").size());
    }


    @Test
    public void emptyInputReturnsEmptyMapOfTierList() {


        classList.clear();
        dependencyMap.clear();
        tierListMap = classOrganizer.mapTierTreeListByParentBranch(classList, dependencyMap);

        assertEquals(0, tierListMap.size());
    }



}