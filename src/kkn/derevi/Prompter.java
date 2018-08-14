package kkn.derevi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompter {

    BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));


    public String promptForString() {
        String input = "";
        try{

             input = inputReader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
            promptForString();
        }
        if(input.isEmpty()) {return promptForString();}
        return input;

    }

    public int promptForIndex() {
        Integer input = null;
        try{
            input = Integer.parseInt(inputReader.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
            promptForIndex();
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            promptForIndex();
        }
        if(input ==null) {return promptForIndex();}
        return input;

    }

    private int promptForIndex(String integer) {
        Integer input = null;
        try{


            input = Integer.parseInt(integer);

        }

        catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        if(input ==null) {return promptForIndex();}
        return input;

    }

    public void requestSelectionAndName(String newName, int indexChoice) {
        String userIndex = promptForString();
        if (userIndex.equals("x")) {return;};
        indexChoice = promptForIndex(userIndex);
        System.out.printf("Please type in the new name:");
        String input = promptForString();
        if (input.equals("x")) {return;};
            return;


    }

    public void requestSelection(String userInput, int indexChoice) {

        String userIndex = promptForString();
        if (userIndex.equals("x")) {return;};
        int indexChoices = promptForIndex(userIndex);

        return;


    }

    public void requestSelection(int indexChoice) {

        String userIndex = promptForString();
        if (userIndex.equals("x")) {return;};
        int indexChoices = promptForIndex(userIndex);

        return;


    }






}
