package kkn.derevi;

public class Prompts {

    Prompter prompter;

    public Prompts(){
        prompter = new Prompter();
    }

    public void menuFlow(){
        prompter.promptForIndex();
        prompter.promptForString();
        //delete passes empty string
        //add

    }
}
