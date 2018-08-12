package kkn.derevi;

import java.util.List;

public class Insertor extends EditorTemplate implements Editor {





    public Insertor(Prompter prompter) {
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

    }
}
