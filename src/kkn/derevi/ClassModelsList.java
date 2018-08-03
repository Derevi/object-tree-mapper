package kkn.derevi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassModelsList {


    public static List<ClassModel> load(){
        List<ClassModel> classModels = new ArrayList<>();
        try(
                FileInputStream fis = new FileInputStream("classModels.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
        )
        {classModels = (List<ClassModel>) ois.readObject();

        }catch (IOException ioe){
            System.out.println("Error reading the file");
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            System.out.println("Error loading the class models from file");
            cnfe.printStackTrace();
        }
        return classModels;
    }

    public static void save(List<ClassModel> classModels){

        try (
                FileOutputStream fos = new FileOutputStream("ClassModels.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {oos.writeObject(classModels);}
        catch (IOException ioe){
            System.out.printf("Error, could not save classmodels");
            ioe.printStackTrace();
        }

    }

}
