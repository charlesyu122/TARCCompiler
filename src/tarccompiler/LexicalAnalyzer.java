/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Token;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author charles_yu102
 */
public class LexicalAnalyzer {
    
    // Attributes
    private String sourceCode;
    ArrayList<String> lexemes;
    ArrayList<Token> tokens;
    
    // Constructor
    public LexicalAnalyzer(String sourceCode){
       this.sourceCode = sourceCode;
       this.lexemes = new ArrayList<String>();
       this.tokens = new ArrayList<Token>();
    }
    
    public void getLexemes(){
        
        // Remove spaces from source code
        String spaceDelims = "[ \t\n]+";
        String[] codes = this.sourceCode.split(spaceDelims);
        
        // Parse source code
        String delims = "[(),;+-*/%&|!<>=]+";
        for(int i=0; i<codes.length; i++){
            StringTokenizer st = new StringTokenizer(codes[i], delims, true);
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                if(!lexemes.isEmpty() && checkDoubleDelim(word)){
                    lexemes.set(lexemes.size()-1, lexemes.get(lexemes.size()-1) + word);
                }else{
                    lexemes.add(word);
                }                
            }
        }
        
        // Display obtained lexemes to check
        this.displayLexemes();
        
        // Sample on how to add
        Token temp = new Token("keyword", "#void");
        this.tokens.add(temp);
    }
    
    public Boolean checkDoubleDelim(String curDelim){
        Boolean check = false;
        String lastDelim = lexemes.get(lexemes.size()-1);
        if(curDelim.equals("=") && (lastDelim.equals("=") || lastDelim.equals("!") ||lastDelim.equals("<") ||lastDelim.equals(">") )){
            check = true;
        }else if((curDelim.equals("+") || curDelim.equals("-")) && curDelim.equals(lastDelim)){
            check = true;
        }
        return check;
    }
    
    private void displayLexemes(){
        for(int i=0; i<this.lexemes.size(); i++){
            System.out.println("Lexeme "+(i+1)+": "+lexemes.get(i));
        }
    }

}
