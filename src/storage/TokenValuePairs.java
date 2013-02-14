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
            terms.put("#func", "keyword");
            terms.put("if", "keyword");
            terms.put("else", "keyword");
            terms.put("end", "keyword");
            terms.put("while", "keyword");
            
            terms.put("#int", "datatypes");
            terms.put("#char", "datatypes");
            terms.put("#boolean", "datatypes");
            
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
            terms.put("=", "assign");
                     
            terms.put("(", "open_par");
            terms.put(")", "close_par");
            terms.put("{", "open_br");
            terms.put("}", "close_br");
            terms.put(";", "semi");
            terms.put(",", "comma");
            terms.put("'", "appos");
            
            terms.put("#getInt", "input");
            terms.put("#getChar", "input");
            terms.put("#getBool", "input");
            terms.put("#puts", "output");
            
            terms.put("true", "boolean");
            terms.put("false", "boolean");
            terms.put("\"", "doub_q");
    }
    
    public String getType(String value){
        return this.terms.get(value);
    }
}
