/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import datamodels.SymbolTableModel;
import java.util.ArrayList;

/**
 *
 * @author charles_yu102
 */
public class SymbolTable {
    
    // Attributes
    public ArrayList<SymbolTableModel> table;
    int last;
    
    // Constructor
    public SymbolTable(){
        this.table = new ArrayList<SymbolTableModel>();
        this.last = -1;
    }
    
    // Methods
    public int lookUp(String tokenVal){
        int index = -1;
        for(int i=0, check=0; check == 0 && i<this.table.size(); i++){
            if(this.table.get(i).tokenValue.equals(tokenVal)){
                check = 1;
                index = i;
            }
        }
        return index;
    }
    
    public void insert(String token, String tokenVal){
        SymbolTableModel row = new SymbolTableModel(token, tokenVal, "");
        this.table.add(row);
        this.last++;
    }
    
    public int getLast(){
        return this.last;
    }
}
