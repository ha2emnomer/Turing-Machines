/*
 * (C) 2015 Hazem A. A. Nomer. All rights reserved. 
 * Turing Machine Transition Class
 */
package turingmachine;



/**
 *
 * @author HAZEM
 */
public class Transition {
   private final int  State  ; 
   private final char  ReadAlphabet ; 
  private final Action act;

    public Transition(int State , char Read , char Write , char Direct , int NextState) {
       this.State = State ; 
       this.ReadAlphabet = Read ; 
       act = new Action (Write , Direct , NextState); 
    } 
    public char getReadAlpabet(){
        return ReadAlphabet ; 
    
    }
     public int getState(){
        return State ; 
    }
    public Action getAction() {
        return act; 
    }
   
}
