/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

/**
 *
 * @author charles_yu102
 */
public class Token {
    
    // Attributes
    public String token;    // keyword, op, ...
    public String tokenVal; // token attribute
    
    // Constructor
    public Token(String token, String value){
        this.token = token;
        this.tokenVal = value;
    }
    
    // Setters
    public void setToken(String token){
        this.token = token;
    }
    
    public void setTokenValue(String val){
        this.tokenVal = val;
    }
    
    // Getters
    public String getToken(){
        return this.token;
    }
    
    public String getTokenValue(){
        return this.tokenVal;
    }
}
