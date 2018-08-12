package kkn.derevi;

import java.util.ArrayList;
import java.util.List;

public class ClassCatalogEditor  implements Editor {
    @Override
    public void edit(String choice) {

        Prompter prompter = new Prompter();

        switch (choice) {
            case "newClass":
                newClassName = inputReader.readLine(); //prompt user class name
                ClassModel newClassModel = new ClassModel(newClassName);
                classModelsCatalog.add(newClassModel);
                break;

            case "renameClassModel":
                newClassName = inputReader.readLine();
                renameClassName(selectedClassModel, newClassName);
                break;
            case "deleteClassModel":
                deleteClassModel(selectedClassModel);
                break;
            case "editClassModelList":
                selectedClassModel = classModelSelector(selectedClassModelIndex);
                EditorForClassMethodsAndDependencies editorForClassMethodsAndDependencies =
                        new EditorForClassMethodsAndDependencies();
                editorForClassMethodsAndDependencies.editClassModelList(selectedClassModel, sele);
                break;

            case "render":

                if (classModelsCatalog.isEmpty()) {
                    System.out.printf("The catalouge is empty, there is nothing to render, please add");
                    break;
                }
                ClassMethodsAndDependenciesAssembler classMethodsAndDependenciesAssembler = new ClassMethodsAndDependenciesAssembler(classModelsCatalog);
                classMethodsAndDependenciesAssembler.getAllClassesAndDependencies();
                classMethodsAndDependenciesAssembler.getAllClassesAndMethods();
                List<String> allClasses = new ArrayList<>();
                allClasses.addAll(classMethodsAndDependenciesAssembler.getAllClassesAndMethods().keySet());
                //new sorter interface

                //treesort and drawer
                break;

            case "exitEditor":
                continueEditing = false;
                break;
            default:
                System.out.printf("enter command again");
                break;


        }
}
