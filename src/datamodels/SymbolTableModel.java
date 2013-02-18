/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

/**
 *
 * @author charles
 */
public class SymbolTableModel {
    // Attributes
    public String token;         // keyword, op, ...
    public String tokenValue;    // token value
    public String datatype;      // token datatype
    public String scope;         // token scope
    
    // Constructor
    public SymbolTableModel(String token, String value, String datatype, String scope){
        this.token = token;
        this.tokenValue = value;
        this.datatype = datatype;
        this.scope = scope;
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
    public void setScope(String scope){
        this.scope = scope;
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
    public String getScope(){
        return this.scope;
    }
}
