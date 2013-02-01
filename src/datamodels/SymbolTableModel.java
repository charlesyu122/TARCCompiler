/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

/**
 *
 * @author charles
 */
public class SymbolTable {
    // Attributes
    private String token;    // keyword, op, ...
    private String tokenValue;    // token value
    private String datatype; // token datatype
    
    // Constructor
    public SymbolTable(String token, String value, String datatype){
        this.token = token;
        this.tokenValue = value;
        this.datatype = datatype;
    }
    
    // Setters
    public void setToken(String token){
        this.token = token;
    }
    
    public void setTokenValue(String val){
        this.tokenValue = val;
    }
    public void setDatatype(String datatype){
        this.datatype = datatype;
    }
    
    // Getters
    public String getToken(){
        return this.token;
    }
    
    public String getTokenValue(){
        return this.tokenValue;
    }
    
    public String getDatatype(){
        return this.datatype;
    }
}
