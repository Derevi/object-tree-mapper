package kkn.derevi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassModelsCatalogGenerator {

    //todo add parameter allowing for save/load of newfile or one that already exists

    private List<ClassModel> classModelsCatalog;

    public  List<ClassModel> load(String fileName){
        classModelsCatalog = new ArrayList<>();
        try(
                FileInputStream fis = new FileInputStream(fileName + ".ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
        )
        {classModelsCatalog = (List<ClassModel>) ois.readObject();

        }catch (IOException ioe){
            System.out.println("Error reading the file");
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            System.out.println("Error loading the class models from file");
            cnfe.printStackTrace();
        }
        return classModelsCatalog;
    }

    public  void save(String fileName, List<ClassModel> classModelsCatalog){

        try (
                FileOutputStream fos = new FileOutputStream(fileName + ".ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {oos.writeObject(classModelsCatalog);}
        catch (IOException ioe){
            System.out.printf("Error, could not save classmodels");
            ioe.printStackTrace();
        }

    }

}
