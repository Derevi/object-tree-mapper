package kkn.derevi;

import java.util.List;

public class Selector extends EditorTemplate implements  Editor{
    List<String> listmodel;


    public Selector(Prompter prompter,) {
        super(prompter);
    }

    @Override
    public List<ClassModel> edit(List<ClassModel> classCatalog) {
        classCatalogs = classCatalog;
        String selection = prompter.promptForString();
        ClassModel classModel = new ClassModel(selection);
        classCatalog.add(classModel);
        super.continueedit();
        return classCatalog;
    }

    @Override
    public void edit(ClassModel classModel) {



        listmodel = classCatalogs.get(1).getClassDependencies();
        listmodel = classCatalogs.get(2).getClassMethods();

    }
}
