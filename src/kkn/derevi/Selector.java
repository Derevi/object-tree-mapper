package kkn.derevi;

import java.util.ArrayList;
import java.util.List;

public class Selector {
    List<Object> listmodel;
    Prompter prompter;
    int indexChoice;

    public Selector(List<Object> listmodel, Prompter prompter) {
        this.prompter = prompter;
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

    public List<ClassModel> createClassCatalog(ClassModelsCatalogGenerator generator){
        prompter.requestSelection(indexChoice);
        if(indexChoice ==1){
            //check name
            generator.load();
        }
        if(indexChoice ==2){
            listmodel = new ArrayList<>();
            return listmodel;
        }

        else{
            System.out.printf("Please enter only 1 or 2 to either load a class catalog or create a new one respectively");
            return createClassCatalog(generator);
        }
    }

}


