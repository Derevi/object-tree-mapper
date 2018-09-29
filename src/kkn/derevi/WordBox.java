package kkn.derevi;

public class WordBox {

    int LENGTH;
    private static final int int WIDTH=3;
    ClassModel classModel;


    WordBox(ClassModel classModel){
        LENGTH = classModel.getClassName().length()+2;
        char[] AboveBorder = new char[LENGTH];
        arra.toString();
        String className ="|"+classModel.getClassName()+"|";
        char[] belowBorder = AboveBorder.clone();

        if(!isAParent()){
           int hookPosition= AboveBorder.length/2;
           AboveBorder[hookPosition] = '|';
        }

        if(hasAChilde()){
            int numOfKids = 5; //get map size
            int botHookPosition= belowBorder.length/2 -(2*;

            String botHooks = "|";
            botHooks.
            AboveBorder[botHookPosition] = '|';

            //cetnre bot hooks
        }



        //wordBoxConnectTo




        //draw dashes = to amount of char
        //draw || on either side of the word
        //draw dashes below word
        //draw | above save state connect parent
        //draw | below save state conect dependenciy

    }

    private boolean isAParent(){
        //todo check if it is a parent after sort
        return true;
    }

    private boolean hasAChilde(){
        //check if it has a dep after sort
        return true;
    }

}
