/*
 * This is a simple Turing Machine implementation. There are three classes Controller, Action and Transition.
 * To build a Turing Machine you simply create an object of a Controller whic takes three params: array of "Transitions", intial state and internal alpahabet length. 
 * Each transition takes 5 elements: current state, the current symbol on tape, next state, symbol to write on tape and the head direction. 
 * For each state there are "alphabet length" trasitions which makes a total of (no of states * length of alphabet) transitions.
 * To see tape contents exaclty step by step over a certain string call ExecuteOverInput() 
 (C) 2015 Hazem A. A. Nomer. All rights reserved. 
*/
package turingmachine;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HAZEM
 */
public class TuringMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input  = new Scanner(System.in); 
        System.out.println("Enter internal alphabet count:");
        int Ialphabet = input.nextInt(); //internal alphabet 
        char [] alphabet = new char[Ialphabet]; 
        for(int i=0; i< Ialphabet; i++){
            alphabet[i]= input.next().charAt(0);
        }
        System.out.println("Enter number of states:");
        int states = input.nextInt(); 
        System.out.println("Now the transitions: in the form of (State , symbol on tape) ===> (Next state , write symbol on tape, head direction)");
        Transition[] ts = new Transition[states*Ialphabet];  
        int TransitionNumbers =0; 
        for(int i=0; i< states; i++){
            System.out.println("Transitions of state: " + i);
            for(int j=0; j<Ialphabet; j++){
                
                System.out.println("alphabet:"+alphabet[j] );
                int nstate=-1;
                
                while(nstate >= states || nstate < 0){
                    System.out.println("Next state(int): between 0 and "+ (states-1));
                    nstate = input.nextInt(); 
                }
                 char writealpha = '\0'; 
               while(SearchArray(alphabet, writealpha) == -1){
                    System.out.println("write symbol on tape:");
                    writealpha = input.next().charAt(0); 
                   
               }
                char direction = '\0' ; 
                while (direction != 'R' && direction != 'L' && direction != 'Y' && direction != 'N'){
                    System.out.println("Head direction: R , L , Y , N");
                     direction =  input.next().charAt(0);
                }
                ts[TransitionNumbers++]= new Transition(i,alphabet[j], writealpha , direction,nstate); 
            }
        }
        System.out.println("The machine will be decoded now..");
        Decode dec = new Decode(ts); 
        System.out.println(dec.getDecodedMachine());
        System.out.println("done! Now enter tape contents");
        String tape = input.next() ; 
        Controller TM = new Controller (ts,0,Ialphabet); 
        System.out.println(TM.ExecuteOverInput(tape));
        
    }
    public static int SearchArray(char[] Array, char key){
        for(int i=0; i< Array.length ; i++){
            if(Array[i]==key){
                return i ; 
            }
        }
        return -1; 
    }
}
