/*
 * (C) 2015 Hazem A. A. Nomer. All rights reserved. 
 * Action is the actual transition of the machine, Action is (Write Symbol , Direction of the head, NextState) 
 */
package turingmachine;

/**
 *
 * @author HAZEM
 */
public class Action {
   private final char  WriteAlphabet ; 
   private final char  Direction ; 
   private final int NextState ;  
   public Action(char Write, char Direction , int NextState){
       this.WriteAlphabet = Write ; 
       this.Direction = Direction ; 
       this.NextState = NextState ; 
       
   }
   public char getWriteAlphabet() {
       return WriteAlphabet; 
   }
   public char getDirection() {
       return Direction; 
   }
    public int getNextState() {
       return NextState; 
   }
}
