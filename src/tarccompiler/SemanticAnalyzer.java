/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.SymbolTableModel;
import datamodels.Tree;
import storage.SymbolTable;

/**
 *
 * @author charles_yu102
 */
public class SemanticAnalyzer {
    
    // Attributes
    private Tree astTree;
    private SymbolTable symbolTable;
    
    // Constructor
    public SemanticAnalyzer(Tree tree, SymbolTable symTbl){
        this.astTree = tree;
        this.symbolTable = symTbl;
        displaySymbolTable();
    }
    
    // Methods
    //<editor-fold defaultstate="collapsed" desc="Debugging Methods">
    private void displaySymbolTable(){
        System.out.println("\n\nSymbol Table:");
        System.out.println("token \t\t tokenVal \t\t datatype \t\t scope");
        for(int i=0; i<symbolTable.table.size(); i++){
            SymbolTableModel temp = symbolTable.table.get(i);
            System.out.println(temp.token+" \t\t "+temp.tokenValue+" \t\t "+temp.datatype+" \t\t "+temp.scope);
        }
    }
    //</editor-fold>
}
