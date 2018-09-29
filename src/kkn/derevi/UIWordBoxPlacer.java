package kkn.derevi;

import java.util.ArrayList;
import java.util.List;

public class UIWordBoxPlacer {
    List<ClassModel> classCatalog;


    UIWordBoxPlacer(List<ClassModel> classCatalog){
        this.classCatalog = classCatalog;
    }


    //Find tier woth most items and set draw table width to all classname width + 3*(size of list -2)
    //get height for drawer count tiers and + 4*(tier layers -2)
    //get midwordbox length/2 get max length/2 and subtract, this number is used to create an empty string
    //do same for each layer

}
