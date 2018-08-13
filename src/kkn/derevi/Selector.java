package kkn.derevi;

import java.util.List;

public class Selector {
    List<Object> listmodel;

    public Selector(List<Object> listmodel) {
        this.listmodel = listmodel;
    }

    public List<Object> getListModel(ClassModel classModel) {

        List<String> listOfStrings;
        if(userSelectsMethods){
            listmodel = classModel.getClassDependencies();
        }else if(userSeletsDependencies){
           listmodel = List.of(classModel.getClassMethods());

        }




        return listmodel;
    }


    public ClassModel getListModel(List<ClassModel> classCatalog){
        return classCatalog.get(1);///TODO prompt for index selection
    }

}


