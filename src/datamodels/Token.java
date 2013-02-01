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
    public String token;    // identifier
    public Integer tokenPtr; // pointer to the symbol table
    
    // Constructors
    public Token(){}
    public Token(String token, Integer pointer){
        this.token = token;
        this.tokenPtr = pointer;
    }
}
