/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.HashMap;
/**
 *
 * @author charles
 */
public class TokenValuePairs {
    
    // Attributes
    HashMap<String,String> terms; // contains value-keyword
    
    // Constructor
    public TokenValuePairs(){
        
            terms = new HashMap<String,String>();
            terms.put("#main", "keyword");
            terms.put("#void", "keyword");
            terms.put("#func", "keyword");
            terms.put("if", "keyword");
            terms.put("else", "keyword");
            terms.put("end", "keyword");
            terms.put("while", "keyword");
            terms.put("null", "keyword");
            
            terms.put("#int", "datatypes");
            terms.put("#char", "datatypes");
            terms.put("#bool", "datatypes");
            terms.put("#arr", "datatypes");
            
            terms.put("+", "arth_op");
            terms.put("-", "arth_op");
            terms.put("*", "arth_op");
            terms.put("/", "arth_op");
            terms.put("%", "arth_op");
            
            terms.put("<", "rel_op");
            terms.put(">", "rel_op");
            terms.put("==", "rel_op");
            terms.put("!=", "rel_op");
            terms.put("<=", "rel_op");
            terms.put(">=", "rel_op");
            
            terms.put("&", "log_op");
            terms.put("|", "log_op");
            terms.put("!", "log_op");
            
            terms.put("=", "assign");
            terms.put("++", "un_op");
            terms.put("--", "un_op");
                     
            terms.put("(", "open_par");
            terms.put(")", "close_par");
            terms.put("{", "open_br");
            terms.put("}", "close_br");
            terms.put(";", "semi");
            terms.put(",", "comma");
            
            terms.put("//", "comment");
    }
    
    public String getType(String value){
        return this.terms.get(value);
    }
}
