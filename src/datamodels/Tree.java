/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

/**
 *
 * @author charles_yu102
 */
public class Tree {
    
    // Attribues
    private Node root;

    // Constructor
    public Tree() {
        root = new Node("PROGRAM", null);
    }
    
    // Getter
    public Node getRoot(){
        return this.root;
    }
    
}
