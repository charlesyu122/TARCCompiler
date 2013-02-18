/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Node;
import java.util.ArrayList;
import storage.LookUpTable;

/**
 *
 * @author charles_yu102
 */
public class ASTConstruction {
    
    // Attributes
    LookUpTable table;
    
    // Constructor
    public ASTConstruction(){
        this.table = new LookUpTable();
    }
     
    // Methods
    
    public void minimizeTree(Node n){ 
        // epsilon is an exception because it is not a nonterminal
        ArrayList<Node> temp = n.getNodeChildren();
        if(n.getNodeData().equals("epsilon")){
            n.setNodeData("~");
        }
        
        // if the data of the node is a nonterminal change to ~
        boolean check = false;
        for(int i = 0; check == false && i < table.nonTerminals.length; i++){
            if(n.getNodeData().equals(table.nonTerminals[i])){
                n.setNodeData("~");
                check = true;
            }             
        }
        
        // tree traversal prefix notation
        for(Node new_n : temp){
            minimizeTree(new_n);          
        }
    }
    
    // Display the tree
    public void showTree(Node n){    
        System.out.print("\nParent: " + n.getNodeData());
        ArrayList<Node> temp = n.getNodeChildren();
        
        // tree traversal prefix notation
        for(Node new_n : temp){
            showTree(new_n);
        }
    }
}
