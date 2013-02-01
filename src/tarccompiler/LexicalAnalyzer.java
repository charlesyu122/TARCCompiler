/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Token;
import java.util.ArrayList;
import java.util.StringTokenizer;
import storage.SymbolTable;
import storage.TokenValuePairs;

/**
 *
 * @author charles_yu102
 */
public class LexicalAnalyzer {
    
    // Attributes
    private TokenValuePairs tvp;
    private String sourceCode;
    ArrayList<String> lexemes;     // Parsed from the source code
    ArrayList<Token> tokens;       // List of tokens to be given to the parser
    SymbolTable symbolTable;
       
    // Constructor
    public LexicalAnalyzer(String sourceCode, SymbolTable symbolTable){
       this.tvp = new TokenValuePairs();
       this.sourceCode = sourceCode;
       this.lexemes = new ArrayList<String>();
       this.tokens = new ArrayList<Token>();
       this.symbolTable = symbolTable;
    }
    
    // Methods
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
    
    public ArrayList<Token> getTokensFormSymbolTable(){
        // Check every lexeme type
        for(int i=0; i<this.lexemes.size(); i++){
            String curLexeme = lexemes.get(i);
            Token container = new Token();
            String type = tvp.getType(curLexeme);
            if(type != null) {                           // Keyword
                container.setToken(type);      
            } else if(isNumeric(curLexeme)){             // Digit
                container.setToken("num");
                container.setTokenPtr(Integer.parseInt(curLexeme));
            } else{                                      // Identifier
                symbolTable.insert("id", curLexeme);
                container.setToken("id");
                container.setTokenPtr(symbolTable.getLast());
            }
            this.tokens.add(container);
        }
        return this.tokens;
    }

    private boolean isNumeric(String lexeme){
        try{
            Integer num = Integer.parseInt(lexeme);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
