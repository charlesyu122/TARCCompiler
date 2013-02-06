/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.Stack;

/**
 *
 * @author User
 */
public class ParserStack {
    Stack<String> stack;
    
    //<editor-fold defaultstate="collapsed" desc="Constructor and Mutators">
    public ParserStack(){
        this.stack = new Stack<String>();
    }
    
    public void setStack(Stack stack){
        this.stack = stack;
    }
    
    public Stack getStack(){
        return stack;
    }
    //</editor-fold>
    
    public void push(String val){
        stack.add(val);
    }
    
    public void pop(){
        stack.pop();
    }
    
    public void divide(){
        stack.pop();
        
        //divide a terminal into its subterminals
    }
}
