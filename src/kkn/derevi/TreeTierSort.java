package kkn.derevi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeTierSort implements ClassOrganizer {




    @Override
    public List<List<String>> connectedTreeMap(Map<String, List<String>> classMethodList, Map<String, List<String>> classDependencyList) {


        //one map for dependency
        //one map for methods


        //List<ClassModel.getMethods> = method list
        //List<ClassModel.getClassMethodDependency>


        //ClassModel = Classname + MethodList + DependencyList
        //for each tier{List @ index i=
        //if map key == methodDependency{remove class from tier, then



        List<String> methodList = new ArrayList<>();




        //Object test2 = (Object)test;

        List<List<String>> sortedTierMap = new ArrayList<>();
        //if method is ins etc? then remove
        //getMap
        //if Key is in V than







        }








       // tierMap.add(className);


        //when render method invoked
        //for each class name sort in to tiers
        //top tier is start
        //bottom tier is node
        //number of tiers is






        return sortedTierMap;


    }

    //returns list of tier
    /*
    list 1 =- tier 1     tier 1 = list of classObjects = start points
    list 2 = tier 2      tier 2 = list of class objects

   List N = tier N       Tier N = terminal ends

   Tier check for upgrade, there should be no "skipped tiers" promotion will occur from bottom up

    etc...


     */


}
