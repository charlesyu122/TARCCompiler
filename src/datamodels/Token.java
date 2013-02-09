// Data Structure to be passed to the Parser
package datamodels;

/**
 *
 * @author charles_yu102
 */
public class Token { 
    
    // Attributes
    String token;     // identifier
    String tokenInfo; // index pointer to the symbol table if token is id
                      // token value if token is int or char;
    
    // Constructors
    public Token(){}
    public Token(String token, String info){
        this.token = token;
        this.tokenInfo = info;
    }
    
    // Setters
    public void setToken(String token){
        this.token = token;
    }
    
    public void setTokenInfo(String info){
        this.tokenInfo = info;
    }
    
    // Getters
    public String getToken(){
        return this.token;
    }
    
    public String getTokenInfo(){
        return this.tokenInfo;
    }
}
