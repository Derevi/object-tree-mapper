package kkn.derevi;

import java.util.List;

public interface ClassOrganizer {

    public List<List<String>> connectedTreeMap(List<String> classList);


    //todo: comparator, interface
    //todo: organize all methods (key), based on number of values, he highes will be above the lesser
    //todo: the method with the greatest amounts of dependencies will be at the top and organized by lesser dependencies at the bottom
    //todo: arrange so no lines overlap
    //todo: generally class will have less branches on top and more on bottom
    //todo: ap will generated key=classname value=tier, and location from the left
    //use upward flow of methods. IF A depends on B then the flow will be A<--B
    //lable classes from righ to left with number
    //make the tier represent connection .. based on push or pull
    //push defined as having the key as the method
    //pull defined as having the the method in the value
    //extend map class to have



}
