
/*
 Recursive sort (list, int)
list of all classes
m=size of list
n= size of listlist
k=size of all list
t= tier
subindex
index

 if(subindex==0){
 create new storagelist
 add to listlist
 subIndex= size of curent all list
 return sort(k)
 }

 if(k==0)
 return listlist

  elseif(allist element at subindex Key!=Value alllist)
  subindex--
    (if no list create a new one)
  add element to list
  remove element for alllist
  add list to listlist

  return sort(, k-1)

 elseif(listKey=Value)
  add element to list
  remove element for alllist
  return sort(, k-1)

  elseif(value=key)
  create new list at tier ++
  add value to list
  return sort(listlist k-1)

  else
  sub++
  return sort(k+1)

        */


package kkn.derevi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TreeTierSort implements ClassOrganizer {

    private int tier = 0;





    @Override
    public List<List<String>> classDependencyTierSort(Collection<String> classListCollection, List<String> classList, int classListSize, int tier, int index) {
/*
 Recursive sort (list, int)
list of all classes
m=size of list
n= size of listlist
k=size of all list
t= tier
subindex
index

 if(subindex==0){
 */
////////////////////GOES BEFORE METHOD///////////////////////

        List<String> methodList = new ArrayList<>();
        List<String> dependencyList = new ArrayList<>();
        classList = new ArrayList<>();
        List<List<String>> tierList = new ArrayList<>();
        // int tier= 0;
        //

        classListSize=classList.size();

        classListCollection = new ArrayList<>(classList);
////////////////////GOES BEFORE METHOD///////////////////////
 //
        //int index = classListCollection.size();

        if(classListCollection.size()==0){
            tier++;
            tierList.add(tier, classList);
            return tierList;
        }

        if(index==0){

            tierList.add(tier, classList);
            //tier++;
            //index=classListCollection.size();
            classList.clear();
            classList.addAll(classListCollection);
            return classDependencyTierSort(classListCollection, classList, classListSize=classList.size(), tier++, index=classListCollection.size());


        } else if(!(classListCollection.contains(classList.get(index)))){
            classListCollection.remove(classList.get(index));
            //index--;
            return classDependencyTierSort(classListCollection, classList, classListSize-1, tier, index--);

           /* elseif(allist element at subindex Key!=Value alllist)
            index--
            add element to classList
            remove element from classListCollection
            return sort(classList classListSize--)
                    */
        }else if (classListCollection.contains(classList.get(index))){
            classList.remove(index);
            return classDependencyTierSort(classListCollection, classList, classListSize, tier, index--);

            /*


 elseif(listKey=Value)
 subindex --

  return sort(classList, classListSize)
*/
        }else{
            classListCollection.remove(classList.get(index));
            index--;
            return classDependencyTierSort(classListCollection, classList, classListSize, tier, index--);
            //create terminal tier
            //add to terminal tier
            //remove from list
            //return

        }








/*
  elseif(value=key)
  create new list at tier ++
  add value to list
  return sort(listlist k-1)

  else
  sub++
  return sort(k+1)

        */


        //List<List<String>> sortedTierMap = new ArrayList<>();
        //return sortedTierMap;



    }
}

