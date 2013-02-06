/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ProductionModel {
    
    // Attributes
    private ArrayList<String> productions;
    private String terminal;
    
    // Constructor
    public ProductionModel(){
        this.terminal = null;
        this.productions = new ArrayList<String>();
    }
    
    // Methods
    public void setTerminal(String terminal){
        this.terminal = terminal;
    }
    
    public String getTerminal(){
        return terminal;
    }
    
    public void addProductions(String product){
        productions.add(product);
    }
    
    public ArrayList<String> getProduction(){
        return productions;
    }
}
