/*
 * (C) 2015 Hazem A. A. Nomer. All rights reserved. 
 * Decode Turing Machine transition into 0's and 1's  
 */
package turingmachine;

import java.util.ArrayList;

/**
 *
 * @author HAZEM
 */
public class Decode {
    Transition [] ts ; 
    StringBuilder b = new StringBuilder ();  
    char [] alpha ;
    public Decode (Transition [] ts){
        this.ts = ts ; 
    }
    private void EncodeState (int state ){
        for(int i=0 ; i< state+1 ; i++ )
        {
            b.append("1");
        }    
    }
    private void EncodeAlphabet (char Alpha){
        for(int i=0; i< alpha.length; i++ ){
            if(Alpha == alpha[i]){
                for(int j=0; j <i; j++){
                    b.append("1"); 
                }
                break ; 
            }
        }
    }
    private void EncodeDirection (char direction){
        if(direction == 'L'){
            b.append("1"); 
        }
      else if(direction == 'R'){
            b.append("11"); 
      }
         else if(direction == 'Y'){
            b.append("111"); 
      }
       else if(direction == 'N'){
            b.append("1111"); 
      }
    }
    private void DecodeMachine (){
         int alphalen = 0; 
        for(int i=0 ; i < ts.length; i++){
            if(ts[i].getState() ==0){
             alphalen++ ; 
            }
            else {
                break ; 
            }
        }
        alpha = new char [alphalen]; 
        for(int i=0 ; i < alphalen; i++){
        alpha[i] = ts[i].getReadAlpabet() ; 
        }
        int states = ts.length / alphalen ; 
       
        for(int i=0 ; i < ts.length; i++){
             EncodeState(ts[i].getState()); 
             b.append("0"); 
             EncodeAlphabet(ts[i].getReadAlpabet());
             b.append("0"); 
             EncodeState(ts[i].getAction().getNextState()); 
             b.append("0"); 
             EncodeAlphabet(ts[i].getAction().getWriteAlphabet()); 
             b.append("0");
             EncodeDirection(ts[i].getAction().getDirection()); 
             if(i < ts.length-1)
             {
                 b.append(" 00 ");
             }
         }
    }
    public String getDecodedMachine(){
        DecodeMachine();
        return b.toString(); 
    }
}
