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
    // Attributes
    Stack<String> stack;
    
    // Constructor
    public ParserStack(){
        this.stack = new Stack<String>();
    }
    
    // Methods
    public void setStack(Stack stack){
        this.stack = stack;
    }
    
    public Stack getStack(){
        return stack;
    }
    
    public void push(String val){
        stack.add(val);
    }
    
    public void pop(){
        stack.pop();
    }
    
    public void divide(){
        stack.pop();
    }
}
