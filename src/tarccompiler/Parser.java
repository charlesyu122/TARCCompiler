/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import datamodels.Token;
import java.util.ArrayList;
/**
 *
 * @author charles_yu102
 */
public class Parser {
    
    Parser(ArrayList<Token> tokens){
      for(int i=0; i<tokens.size(); i++){
            System.out.println("Lexeme "+(i+1)+": "+tokens.get(i));
        }  
    }
    
}
