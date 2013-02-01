/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

/**
 *
 * @author charles_yu102
 */
public class LexicalAnalyzer {
    private String sourceCode;
    
    LexicalAnalyzer(String sourceCode)
    {
       this.sourceCode = sourceCode;
    }
    
    void getLexemes(){
       
        String delims = "[ \t\n]+";
        StringBuilder t = new StringBuilder();
        String []container = this.sourceCode.split(delims);       
        for(int i = 0; i < container.length ;i++){
            t.append(container[i]);
            System.out.println("Lexeme " + i + ":" + container[i]);
            
        }
        System.out.println("String " + t);
        for(int i = 0; i < t.length() ;i++){
            //t.append(container[i]);
            //System.out.println("t[ " + i + "]: " + t.charAt(i));
            
        }
    }
}
