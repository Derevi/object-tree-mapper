package kkn.derevi;

import java.util.*;

public class Main {
    public static int m=10;
    public static void main(String[] args){

        int i,fact=1;
        int number=4;//It is the number to calculate factorial
        fact = factorial(number);
        System.out.println("Factorial of "+number+" is: "+fact);
        System.out.println(m);



        Map<String, List<String>> testMap = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add("1");list1.add("2");list1.add("3");list1.add("4");
        List<String> list2 = new ArrayList<>();
        list2.add("5");list2.add("6");list2.add("7");list2.add("8");
        List<String> list3 = new ArrayList<>();
        list3.add("9");list3.add("10");list3.add("11");
        List<String> list4 = new ArrayList<>();
        list4.add("12");list4.add("13");

        testMap.put("list1",list1);
        testMap.put("list2",list2);
        testMap.put("list3",list3);
        testMap.put("list4",list4);

        Collection<List<String>> testMapListCollection = new ArrayList<>(testMap.values());
        List<String> testMapList = new ArrayList<>();

        List<String> list5 = new ArrayList<>();

        testMapListCollection.forEach(testMapList::addAll);

        mapWithRemovedKey(testMap, "list2");






    }

    static private Map<String, List<String>> mapWithRemovedKey(Map<String, List<String>> map, String key){
        map.remove(key);
        return map;
    }



    static int factorial(int n){

        if (n == 0){
            return m;
            //14*24
        }

        else{
            m++;
            System.out.printf("%nm is: %d",m);
            n--;
            System.out.printf("%nn is: %d",n);
            return(factorial(n));
        }



    }

}
