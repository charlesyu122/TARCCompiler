/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

/**
 *
 * @author User
 */
public class LookUpTableModel {
    
    // Attributes
    private String terminal;
    private String nonTerminal;
    private String data;
            
    // Constructor
    public LookUpTableModel(String terminal, String nonTerminal, String data){
        this.terminal = terminal;   
        this.nonTerminal = nonTerminal;
        this.data = data;
    }
            
    // Setters and Getters
    public void setTerminal(String terminal){
        this.terminal = terminal;
    }
    
    public void setNonTerminal(String nonTerminal){
        this.nonTerminal = nonTerminal;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getTerminal(){
        return terminal;
    }
    
    public String getNonTerminal(){
        return nonTerminal;
    }
    
    public String getData(){
        return data;
    }
}
