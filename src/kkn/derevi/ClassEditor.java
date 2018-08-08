package kkn.derevi;

import java.util.List;

public class ClassEditor {

    private ClassModel classModel;
    private List<String> methodsList;
    private List<String> dependencyList;
    private List<ClassModel> classModelsCatalog;


    public ClassEditor(ClassModel classModel) {
        this.classModel = classModel;
        classModelsCatalog;

    }


    public void editClassName(String renamedClass) {
        classModel.setClassName(renamedClass);
    }

    public void deleteClassModel(ClassModel classModel) {
        classModel = null; //deleted by garbage collector
    }

    public List<String> addElementToClassModel(String dependency, List<String> selectedListFromClassModel) {
        selectedListFromClassModel.add(dependency);

        return  selectedListFromClassModel;
    }

    public List<String> removeElementFromClassModel(String dependency, List<String> selectedListFromClassModel){
        selectedListFromClassModel.remove(dependency);
        return selectedListFromClassModel;
    }

    public List<String> replaceElementFromClassModel(int index, String newName, List<String> selectedListFromClassModel){
        if (newName == null) {
            selectedListFromClassModel.remove(newName);
            return methodsList;
        }
        selectedListFromClassModel.set(index, newName);
        return selectedListFromClassModel;
    }


}
