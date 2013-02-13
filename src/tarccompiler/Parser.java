/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Token;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;
import storage.LookUpTable;
import storage.SymbolTable;
/**
 *
 * @author charles_yu102
 */
public class Parser {
    
    // Attributes
    private Stack<Token> tokens;
    private Stack<String> productions;
    private SymbolTable symbolTable;
    private LookUpTable lookUpTable;
    
    // Constructor
    public Parser(ArrayList<Token> tokens, SymbolTable table){
        this.tokens = new Stack<Token>();
        this.productions = new Stack<String>();
        
        this.tokens.addAll(tokens);
        Collections.reverse(this.tokens); //reverse the order for our stack
        this.symbolTable = table;
        this.lookUpTable = new LookUpTable();
        this.productions.push("PROGRAM");
        this.methodLLParser();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Debugging Methods">
    public void displayTokens(){
        System.out.println("Tokens received");
        for(int i=0; i < tokens.size(); i++){
            System.out.println("Token: "+tokens.get(i).getToken()+" TokenInfo: "+tokens.get(i).getTokenInfo());
        }
    }
    
    public void displaySymTable(){
        System.out.println("Symbol Table:");
        for(int i=0; i < symbolTable.table.size(); i++){
            System.out.println("Token: "+symbolTable.table.get(i).token+" Value: "+symbolTable.table.get(i).tokenValue+" DType: "+symbolTable.table.get(i).datatype);
        }
    }
    //</editor-fold>
    
    private void methodLLParser(){
        do
        {
            divide();
            System.out.println("productions: "+productions);
            System.out.println("productions_peek: "+productions.peek());
            //If peekedData is a terminal / epsilon, proceed to loop
            try
            {
                while(isTerminal(productions.peek()) || productions.peek().equals("epsilon")){
                    // Keep on popping production stack and token stack if both of them have the same top data
                    while(tokens.peek().getToken().equals(productions.peek())){
                        tokens.pop();
                        productions.pop();
                    }

                    if(productions.peek().equals("epsilon"))
                        productions.pop();  // Avoid redundancy due to peekedData with an epsilon production
                }
            }catch(Exception ex){ /*Peeking while stack is empty*/ }
        }while(!tokens.empty() && !productions.empty());
    }
    
    private void divide(){
        ArrayList<String> temp = new ArrayList<String>();
        String delims = "[(),;+-*/%&|!=]+{}";
        String data = lookUpTable.lookUp(productions.peek(), tokens.peek().getToken());
        productions.pop();
        // Parse tokens
        StringTokenizer st1 = new StringTokenizer(data, " ", false);
        while(st1.hasMoreTokens()){
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), delims, true);
            
            while(st2.hasMoreTokens())
                temp.add(st2.nextToken());
        }
        
        mergeDoubleDelim(temp);
        Collections.reverse(temp);
        productions.addAll(temp);
    }
    
    //Check if string is a terminal
    private Boolean isTerminal(String peekedData){
        Boolean isTerminal = false;
        
        for(String terminal : lookUpTable.terminals){
            if(peekedData.equals(terminal)){
                isTerminal = true;
                break;
            }
        }
        return isTerminal;
    }
    
    // Merge 2 delimiters
    private void mergeDoubleDelim(ArrayList<String> temp){
        for(int counter = 0; counter < temp.size() - 1; counter++){
            String curDelim = temp.get(counter + 1);
            String lastDelim = temp.get(counter);
            
            if(curDelim.equals("=") && (lastDelim.equals("=") || lastDelim.equals("!") ||lastDelim.equals("<") ||lastDelim.equals(">") )){
                temp.set(counter, lastDelim + curDelim);
                temp.remove((int)counter + 1);
            }else if((curDelim.equals("+") || curDelim.equals("-")) && curDelim.equals(lastDelim)){
                temp.set(counter, lastDelim + curDelim);
                temp.remove((int)counter + 1);
            }
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="Naming Conventions">
    //Check if string does not contain any alphabets
    private Boolean isNumeric(String numeric){
        try{ Integer.parseInt(numeric); return true; }catch(Exception ex){ return false; }
    }
    
    //Check if string does not contain any numbers
    private Boolean isAlphabet(String alphabet){
        return false;
    }
    
    //Check if naming convention is correct
    private Boolean namingConvention(String variable){
        String []specialCharacters = new String[]{"~", "!", "@", "#", "$", 
                                                  "%", "^", "&", "*", "(",
                                                  ")", "-", "=", "+", "*",
                                                  "/", "\\", "|", "?", ">",
                                                  "<", ".", ",", "{", "}",
                                                  "[", "]", ";", "`", "'",
                                                  ":", " "};
        Boolean isCorrect = false;
        char firstChar = variable.charAt(0);
        
        //The first character of the identifier must be a letter or underscore
        if(firstChar == '_' || !Character.isDigit(firstChar)){
            for(int counter = 0; counter < specialCharacters.length; counter++){
                if(variable.contains(specialCharacters[counter])){
                    isCorrect = false;
                    break;
                }
                else
                    isCorrect = true;
            }
        }
        
        return isCorrect;
    }
    //</editor-fold>
}
