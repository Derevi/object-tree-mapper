package kkn.derevi;

import java.util.ArrayList;
import java.util.List;

public class ClassCatalog {

    List<ClassModel> classModelsCatalog;

    public ClassCatalog(List<ClassModel> classModelsCatalog) {
        this.classModelsCatalog = classModelsCatalog;
    }

    public void addToClassCatalog(ClassModel classModel){
        classModelsCatalog.add(classModel);

    }

    public List<ClassModel> getClassModelsCatalog(){
        return classModelsCatalog;
    }

    public List<String> classNamesList(){
        List<String> classNamesList = new ArrayList<>();
        classModelsCatalog.forEach(classModel -> {
            classNamesList.add(classModel.getClassName());
        });

        return classNamesList;
    }

}
