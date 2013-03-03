/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

/**
 *
 * @author charles_yu102
 */
public class Declaration {
    
    // Attributes
    private String datatype;
    private String variable;
    
    // Constructor
    public Declaration(String datatype, String var){
        this.datatype = datatype;
        this.variable = var;
    }
    
    // Getter
    public String getDatatype(){
        return this.datatype;
    }
    
    public String getVariable(){
        return this.variable;
    }
    
}
