/*
 * (C) 2015 Hazem A. A. Nomer. All rights reserved. 
 * Turing Machine Controller Class
 */
package turingmachine;

/**
 *
 * @author HAZEM
 */
public class Controller {
 
    private Transition[] Transitions; 
    private int  CurrentState = 0 ; 
    private int  alphalength ; 
    private boolean acceptance ; 
    public Controller(Transition [] Trans, int intial , int alphalength) {
        this.Transitions = Trans ; 
        this.CurrentState = intial ; 
        this.alphalength = alphalength ; 
        
    }
    public String ExecuteOverInput(String Input){
        StringBuilder b = new StringBuilder (); 
        b.append(Input);
        for(int i=0; i< Input.length();i++){
             for(int j=CurrentState*alphalength; j < (CurrentState*alphalength)+alphalength; j++)
             {
              if(Transitions[j].getReadAlpabet() == Input.charAt(i)){
                  //write to input tape
                b.setCharAt(i, Transitions[j].getAction().getWriteAlphabet());
                CurrentState = Transitions[j].getAction().getNextState(); 
                System.out.println("TAPE: "+b.toString() + "\t Current State: "+ CurrentState);
                if(Transitions[j].getAction().getDirection()=='L'){
                     i-- ; break; 
                }
                else if (Transitions[j].getAction().getDirection()=='Y'){
                    acceptance = true; 
                 // System.out.println(Transitions[j].getAction().getDirection());
                    return b.toString() ; 
                }
                else if(Transitions[j].getAction().getDirection()=='N'){
                    acceptance = false; 
                    return b.toString() ; 
                }
                else {
                 //  i++; 
                    break; 
                }
              }   
             }
        }
        return b.toString(); 
    }
}
