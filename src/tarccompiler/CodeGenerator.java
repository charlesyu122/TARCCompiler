/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Token;
import java.util.ArrayList;
import storage.SymbolTable;

/**
 *
 * @author charles_yu102
 */
public class CodeGenerator {
    
    // Attributes
    String javaCode;
    SymbolTable symbolTable;
    ArrayList<Token> tokens;
    ArrayList<String> lexemes;
    
    // Constructor
    public CodeGenerator(ArrayList<Token> tokens, SymbolTable symbolTbl){
        this.tokens = tokens;
        this.symbolTable = symbolTbl;
        this.lexemes = new ArrayList<String>();
        this.adjustLexemes();
        //this.displayLexemes();
        this.translateToJava();
    }
    
    // Methods
    //<editor-fold defaultstate="collapsed" desc="Debugging Methods">
    public void displayLexemes(){
        System.out.println("CODE GENERATOR ");
        for(int i=0; i < this.lexemes.size(); i++){
            System.out.println(lexemes.get(i));
        }
    }
    //</editor-fold>
    
    public void adjustLexemes(){
        for(int i=0; i<this.tokens.size(); i++){
            Token curToken = this.tokens.get(i);
            String curLexeme = curToken.getToken();
            // if lexeme is an int, charm string or id get token info
            if(curLexeme.equals("int") || curLexeme.equals("char") || curLexeme.equals("string") || curLexeme.equals("id")){           
                this.lexemes.add(curToken.getTokenInfo());
            } else{ // keyword
                this.lexemes.add(curLexeme);
            }
        }
    }
    
    public void translateToJava(){
        this.javaCode = "public class TARCCode{";
        for(int i=0; i<this.lexemes.size(); i++){
            String curLexeme = lexemes.get(i);
            // Convert to java
            if(curLexeme.equals("|")){
                javaCode+=" || ";
            } else if(curLexeme.equals("&")){
                javaCode+=" && ";
            } else if(curLexeme.equals("&")){
                javaCode+=" && ";
            } else if(curLexeme.equals("end")){
                javaCode+="\n} \n";
            } else if(curLexeme.equals("#func")){
                javaCode+="\npublic void ";
            } else if(curLexeme.equals("#main")){
                javaCode += "\npublic static void main(String[] args)";
                i += 2;
            } else if(curLexeme.equals("#int") || curLexeme.equals("#char") || curLexeme.equals("#boolean")){
                javaCode += curLexeme.substring(1)+" ";
            } else if(curLexeme.equals("#puts")){
                javaCode += "System.out.print";
            } else if(curLexeme.equals("else")){
                javaCode += "\n } else{ \n";
            } else if(curLexeme.equals(")")){
                boolean check = false;
                for(int j=i; check == false && j>0; j--){
                    if(lexemes.get(j).equals("(")){
                        check = true;
                        if(lexemes.get(j-1).equals("if") && lexemes.get(j-1).equals("while")){
                            javaCode += "){ \n";
                        } else{
                            javaCode += curLexeme+" ";
                        }
                    }
                } 
            } else if(curLexeme.charAt(0) == '#'){
                javaCode += curLexeme.substring(1) + " ";
            } else{
                javaCode += " "+curLexeme+" ";
            }
        }
        this.javaCode += "}";
        System.out.println ("Java Code: \n" + javaCode);
    }
    
    
}
