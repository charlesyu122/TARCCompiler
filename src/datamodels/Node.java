/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

import java.util.ArrayList;

/**
 *
 * @author charles_yu102
 */
public class Node {
    
    // Attributes
    private String data;
    private Node parent;
    private ArrayList<Node> children;
    
    // Constructor
    public Node(String data, Node parent){
        this.data = data;
        this.parent = parent;
        this.children = new ArrayList<Node>();
    }
    
    // Getters and Setters
    public String getNodeData(){
        return this.data;
    }
    
    public Node getNodeParent(){
        return this.parent;
    }
    
    public ArrayList<Node> getNodeChildren(){
        return this.children;
    }
    
    public int getNumOfChildren(){
        return this.children.size();
    }
    
    public void setNodeData(String data){
        this.data = data;
    }
    
    public void setNodeChildren(ArrayList<Node> children){
        this.children = children;
    }
    
    public int getIndexOfChild(String data){
        int ndx = -1; boolean found = false;
        for(int i=0; found == false && i<children.size(); i++){
            if(children.get(i).getNodeData().equals(data)){
                found = true;
                ndx = i;
            }
        }
        return ndx;
    }
    
    
}
