/*
 * (C) 2015 Hazem A. A. Nomer. All rights reserved. 
 * Context Free Grammer (CFG) language decider using dynamic programming techinque
 * Can be used as language decider for compilers
 * Rule Clas
 */
package CFLD;

/**
 *
 * @author HAZEM
 */
public class Rule {
    char NonTerminal; 
    char FSymbol ; 
    char SSymbol ; 
    public Rule (char NonTerminal , char FSymbol , char SSymbol){
        this.NonTerminal = NonTerminal ; 
        this.FSymbol = FSymbol ; 
        this.SSymbol = SSymbol ; 
    }
     public Rule (char NonTerminal , char FSymbol){
        this.NonTerminal = NonTerminal ; 
        this.FSymbol = FSymbol ; 
        
    }
     public boolean IsUnitRule () {
         if(SSymbol == '\0'){
             return true ; 
         }
        return false ; 
     }
}
