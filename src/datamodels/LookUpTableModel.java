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
    private String terminal, nonTerminal, data;
            
    public LookUpTableModel(String terminal, String nonTerminal, String data){
        //both were found at the header part of our grass.
        this.terminal = terminal;   
        this.nonTerminal = nonTerminal;
        this.data = data;
    }
            
    //<editor-fold defaultstate="fold" desc="Mutators">
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
    //</editor-fold>  
}
