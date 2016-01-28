/*
 * (C) 2015 Hazem A. A. Nomer. All rights reserved. 
 * Context Free Grammer (CFG) language decider using dynamic programming techinque
 * Can be used as language decider for compilers
 * The dynamic programming algorithm. 
 * Note I used a percise notation of the algorithm for indices so the string actually starts at 1 (I shift the string and added 0 at the start of the string. 
 */
package CFLD;
public class Decider {
    Rule [] rules ; //CFG
    public Decider (Rule [] rules){
        this.rules = rules ; 
    }
    private boolean SearchForRule (Rule r) {
        for(int i=0; i< rules.length; i++){
            if((r.NonTerminal == rules[i].NonTerminal) && (r.FSymbol == rules[i].FSymbol) && (r.SSymbol == rules[i].SSymbol)){
                return true ; 
            }
        }
        return false ;
    }
    private char SearchForSymbol (char c) {
        for(int i=0; i< rules.length; i++){
            if(rules[i].FSymbol == c){
               return rules[i].NonTerminal ; 
            }
        }
        return '\0' ;
    }
    public boolean Decide (String in){
        Rule emptyRule = new Rule ('S', '\0');
        String input = "0"+ in; 
    
        char [] [] table = new char [input.length()+1][input.length()+1]; 
        if(input.isEmpty() && SearchForRule(emptyRule)){
            return true ; 
        }
        else {
            for (int i=1; i< input.length() ; i++){
                char symbol= SearchForSymbol(input.charAt(i)); 
                if( symbol != '\0')
                {
                   table[i][i]= symbol ; 
                  
                }
            }
            for(int l=2; l< input.length(); l++)
            {
                for(int i=1 ; i< input.length()-l+1 ;i++)
                {
            
                int j = i+l-1 ; 
                  
                for(int k =i; k<=j-1; k++){
                 
                    for(int r=0; r<rules.length ; r++){
                 
                        if(rules[r].IsUnitRule()==false){
                        
                            if(table[i][k] == rules[r].FSymbol && table[k+1][j] == rules[r].SSymbol){
                                table[i][j] = rules[r].NonTerminal ; 
                                
                            }
                        }
                    }
                }
                }
            }
            if(table[1][input.length()-1]=='S'){
                return true ; 
            }
        }
        return false ; 
    }
    
}
