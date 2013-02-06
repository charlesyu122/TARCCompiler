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
    private ArrayList<String> productions;
    private String terminal;
    
    //<editor-fold defaultstate="collapsed" desc="Constructor and Mutators">
    public ProductionModel(){
        this.terminal = null;
        this.productions = new ArrayList<String>();
    }
    
    public void setTerminal(String terminal){
        this.terminal = terminal;
    }
    
    public void addProductions(String product){
        productions.add(product);
    }
    
    public ArrayList<String> getProduct(){
        return productions;
    }
    
    public String getTerminal(){
        return terminal;
    }
    //</editor-fold>
}
