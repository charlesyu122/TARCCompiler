/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Token;
import java.util.ArrayList;
import storage.LookUpTable;
import storage.SymbolTable;
/**
 *
 * @author charles_yu102
 */
public class Parser {
    
    // Attributes
    ArrayList<Token> tokens;
    SymbolTable symbolTable;
    LookUpTable lookUpTable;
    
    // Constructor
    public Parser(ArrayList<Token> tokens, SymbolTable table){
      this.tokens = tokens;  
      this.symbolTable = table;
      this.lookUpTable = new LookUpTable();
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
    
    public void functionList(){
    }
}
