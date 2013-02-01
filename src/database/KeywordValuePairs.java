/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.HashMap;
/**
 *
 * @author charles
 */
public class KeywordValuePairs {
    
    
    HashMap<String,String> terms; // contains value-keyword
    
    //constructor
    public KeywordValuePairs(){
        
            terms = new HashMap<String,String>();
            terms.put("#main", "keyword");
            terms.put("#void", "keyword");
            terms.put("#func", "keyword");
            terms.put("if", "keyword");
            terms.put("else", "keyword");
            terms.put("end", "keyword");
            
            terms.put("#int", "datatypes");
            terms.put("#char", "datatypes");
            terms.put("#bool", "datatypes");
            terms.put("#arr", "datatypes");
            
            terms.put("<", "relop");
            terms.put(">", "relop");
            terms.put("==", "relop");
            terms.put("<=", "relop");
            terms.put(">=", "relop");
            terms.put("!=", "relop");
            
            terms.put("&", "logop");
            terms.put("|", "logop");
            terms.put("!", "logop");
            
            terms.put("=", "assop");
            terms.put("++", "assop");
            terms.put("--", "assop");
                     
            terms.put("(", "otherop");
            terms.put(")", "otherop");
            terms.put("{", "otherop");
            terms.put("}", "otherop");
    }
    
    public String getType(String value){
        String type;
        type = this.terms.get(value).toString();
        return type;
    }
}
