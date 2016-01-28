/*
 * (C) 2015 Hazem A. A. Nomer. All rights reserved. 
 * Context Free Grammer (CFG) language decider using dynamic programming techinque
 * Can be used as language decider for compilers
 */
package CFLD;

import java.util.Scanner;

/**
 *
 * @author HAZEM
 */
public class Main {
     public static void main(String[] args)
     {
         Scanner input  = new Scanner(System.in);
         System.out.println("Number of Rules:");
         int nrules = input.nextInt() ; 
         Rule[] rules = new Rule[nrules]; 
         System.out.println("Good! It's time for the first rule S --> AB or S--> a ");
         rules [0]= new Rule ('S', input.next().charAt(0), input.next().charAt(0));
         for(int i=1; i < nrules; i++){
             System.out.println("Rule: "+ i);
             System.out.println("Put your rule as A--> AB or A--> a .. Remember eplison is \\0");
             rules [i]= new Rule (input.next().charAt(0), input.next().charAt(0), input.next().charAt(0));
         }
         System.out.println("Now enter a string:");
         String s= input.next(); 
         Decider d = new Decider(rules);
         boolean result = d.Decide(s); 
         if(result==true){
             System.out.println("String: "+ s + " is accpeted!");
         }
         else {
             System.out.println("String: "+ s + " is rejected!");
         }
         
     }
}
