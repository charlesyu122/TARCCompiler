/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Node;
import datamodels.Tree;
import storage.LookUpTable;
import java.util.ArrayList;

/**
 *
 * @author charles_yu102
 */
public class ASTConstruction {
    
    // Attributes
    Tree parserTree;
    LookUpTable table;
    // Constructor
    public ASTConstruction(Tree parserT){
        this.parserTree = parserT;
        this.table = new LookUpTable();
    }
     
    //methods
    
    public Tree minimizeTree(Node n){
        Tree minTree = this.parserTree;
        
        //epsiolon is an exception because it is not a nonterminal
        ArrayList<Node> temp = n.getNodeChildren();
        if(n.getNodeData().equals("epsilon")){
            n.setNodeData("~");
        }
        
        //if the data of the node is a nonterminal change to ~
        for(int i = 0; i < table.nonTerminals.length -1; i++){
            if(n.getNodeData().equals(table.nonTerminals[i])){
                n.setNodeData("~");
            }             
        }
        
        //tree traversal prefix notation
        for(Node new_n : temp){
            minimizeTree(new_n);          
        }
       
        return minTree;
    }
    
    //display the tree
    public void showTree(Node n){
        Tree minTree = this.parserTree;
        
        System.out.print("\nParent: " + n.getNodeData());
        ArrayList<Node> temp = n.getNodeChildren();
        
        //tree traversal prefix notation
        for(Node new_n : temp){
            showTree(new_n);
        }
    }
}
