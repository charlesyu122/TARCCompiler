/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import datamodels.LookUpTableModel;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LookUpTable {
    // Attributes
    ArrayList<LookUpTableModel> parserTable;
    
    // Constructor
    public LookUpTable(){
        this.parserTable = new ArrayList<LookUpTableModel>();
    }
    
    /*
     * FIRST is a function on each non-terminal
     * that tells us which terminals (tokens from the lexer) can appear 
     * as the first part of one of these non-terminals. 
     * Epsilon (neither a terminal nor a non-terminal) may also be 
     * included in this FIRST function
     */
    public void first(String begin){
    }
    
    /*
     * FOLLOW shows us the terminals that can come after a derived 
     * non-terminal. Note, this does not mean the last terminal derived 
     * from a non-terminal. It's the set of terminals that can come after it.
     */
    public void follow(String next){
    }
}
