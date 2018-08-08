package kkn.derevi;

public class UMLDiagramApp {

    public static void main(String[] args){

       if(args.length==0){
            System.out.println("Usage: java UMLDiagramApp <option>");
            System.err.println("An UI option is required");
            System.exit(1);
        }

        while (args[0].equals("-t") ||args[0].equals("terminal")) {
           //todo code is only place holder for now, will edit once UI is completed

           ClassModelsManager classModelsManager = new ClassModelsManager();
           classModelsManager.run();
        }

        //todo GUI
        //todo implement user input dialogue
        //todo refactor sort algorithm



    }
}
