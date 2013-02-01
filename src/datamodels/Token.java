// Data Structure to be passed to the Parser
package datamodels;

/**
 *
 * @author charles_yu102
 */
public class Token { 
    
    // Attributes
    String token;     // identifier
    Integer tokenPtr; // index pointer to the symbol table
    
    // Constructors
    public Token(){}
    public Token(String token, Integer pointer){
        this.token = token;
        this.tokenPtr = pointer;
    }
    
    // Setters
    public void setToken(String token){
        this.token = token;
    }
    
    public void setTokenPtr(int ptr){
        this.tokenPtr = ptr;
    }
    
    // Getters
    public String getToken(){
        return this.token;
    }
    
    public Integer getTokenPtr(){
        return this.tokenPtr;
    }
}
