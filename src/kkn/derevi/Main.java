package kkn.derevi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static int m=10;
    public static void main(String[] args){

        int i,fact=1;
        int number=4;//It is the number to calculate factorial
        fact = factorial(number);
        System.out.println("Factorial of "+number+" is: "+fact);
        System.out.println(m);



    }



    static int factorial(int n){

        if (n == 0){
            return m;
            //14*24
        }

        else{
            m++;
            System.out.printf("%nm is: %d",m);
            n--;
            System.out.printf("%nn is: %d",n);
            return(factorial(n));
        }



    }

}
