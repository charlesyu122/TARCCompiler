/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Token;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import storage.LookUpTable;
/**
 *
 * @author charles_yu102
 */
public class Parser {
    
    // Attributes
    private Stack<Token> tokens;
    private Stack<String> productions;
    private LookUpTable lookUpTable;
    private Boolean errorDetected = false;
    private String errorMessage;
    
    // Constructor
    public Parser(ArrayList<Token> t){
        this.tokens = new Stack<Token>();
        this.productions = new Stack<String>();
        this.tokens.addAll(t);
        Collections.reverse(this.tokens); //reverse the order for our stack
        this.lookUpTable = new LookUpTable();
        this.productions.push("PROGRAM");
    }
    
    //<editor-fold defaultstate="collapsed" desc="Debugging Methods">
    public void displayTokenStack(){
        System.out.println("Input Stack: ");
        for(int i=tokens.size()-1; i >= 0; i--){
            System.out.println("Token: "+tokens.get(i).getToken()+"\t TokenInfo: "+tokens.get(i).getTokenInfo());
        }
    }
    //</editor-fold>
    
    public String methodLLParser(){
        this.displayTokenStack();
        do{
            System.out.println("input stack top: "+tokens.peek().getToken());
            System.out.println("productions: "+productions+"\n\n");
            if(!tokens.peek().getToken().equals(productions.peek())){
                if(productions.peek().equals("epsilon")){           // Peek of production stack is epsilon
                    productions.pop();
                } else{                                             // Peek of both stacks dont match
                    if(lookUpTable.isTerminal(productions.peek())){
                        errorDetected = true;
                        errorMessage = "Error found while parsing "+tokens.peek().getToken();
                    } else{
                        errorDetected = splitProductionTop();
                    }
                }
            } else {                                                // Peek of input stack is terminal and matches production stack
                tokens.pop();
                productions.pop();
            }
        }while(errorDetected == false && !tokens.empty());
        if(errorDetected == false){
            errorMessage = "Syntax check - Success!";
        }
        return errorMessage;
    }
    
    private boolean splitProductionTop(){
        boolean errorFound = false;
        String prod = lookUpTable.lookUp(productions.peek(), tokens.peek().getToken());
        if(prod.equals("null")){
            errorFound = true;
            errorMessage = "Error found while parsing "+tokens.peek().getToken();
        } else{
            productions.pop();
            // Check for exceptions
            prod = fixExceptions(prod);
            // Parse production
            String[] tNt = prod.split(" ");
            for(int i=tNt.length-1; i>=0 ; i--){
                productions.push(tNt[i]);
            }
        }
        return errorFound;
    }
    
    private String fixExceptions(String prod){
        String correctProd = "";
        // Try to split production
        String[] prods = prod.split("8");
        // Return based on exception
        if(prods.length == 1){
            correctProd = prods[0];
        } else{
            if(prods[0].equals("ASSIGNMENT_STATEMENT")){ // For OTHER_STATEMENT Exception
                if(tokens.get(tokens.size()-2).getToken().equals("=")){
                    correctProd = prods[0];
                } else{
                    correctProd = prods[1];
                }
            } else if(prods[0].equals("VALUE")){              // For ASSIGNMENT_VALUE Exception
                if(tokens.get(tokens.size()-2).getToken().equals(";")){
                    correctProd = prods[0];
                } else{
                    correctProd = prods[1];
                }
            }
        }
        return correctProd;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Naming Conventions">
    //Check if string does not contain any alphabets
    private Boolean isNumeric(String numeric){
        try{ 
            Integer.parseInt(numeric); 
            return true; 
        }catch(Exception ex){ 
            return false; 
        }
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
