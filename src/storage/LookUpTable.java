/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;


/**
 *
 * @author Fealrone Alajas
 */
public class LookUpTable {
    // Attributes
    private String[] terminals, nonTerminals;
    private String[][] table;
    
    // Constructor
    public LookUpTable(){
        this.initializeNonTerminals();
        this.initializeTerminals();
        this.populateLookUpTable();
        //this.displayLookUpTable();
        
    }
    
    //Look up our data in our LookUpTable
    public String lookUp(String terminal, String nonTerminal){
        int count_terminal, count_nonTerminal;
        
        //get the index for our given terminal and nonTerminal
        for(count_terminal = 0; count_terminal < this.terminals.length && terminal != this.terminals[count_terminal]; count_terminal++);
        for(count_nonTerminal = 0; count_nonTerminal < this.nonTerminals.length && nonTerminal != this.nonTerminals[count_nonTerminal]; count_nonTerminal++);
        
        return table[count_nonTerminal][count_terminal];
    }
    
    //Display our LookUpTable
    private void displayLookUpTable(){
        System.out.println("____________________________");
        for(int a = 0; a < this.nonTerminals.length; a++){
            for(int b = 0; b < this.terminals.length; b++){
                System.out.print(" "+table[a][b]);
            }
            System.out.println();
        }
        System.out.println("____________________________");
    }
    
    //Initialize our column header
    private void initializeTerminals(){
        terminals = new String[]{"id", "int", "char", "#main", "#func",
                                 "if", "else", "end", "while", "#int",
                                 "#char", "#boolean", "+", "-", "*",
                                 "/", "%", "<", ">", "<=", ">=", "==",
                                 "!=", "&", "|", "=", "(", ")", "{",
                                 "}", ";", ",", "'", "#getInt", "#getChar",
                                 "#getBoolean", "#puts", "true", "false"};
    }
    
    //Initialize our row header
    private void initializeNonTerminals(){
        nonTerminals = new String[]{"<PROGRAM>", "<MAIN>", "<FUNCTION LIST>",
                                    "<FUNCTION>", "<PARAMETER LIST>", 
                                    "<PARAMETER OPTION>", "<PARAMETER>", 
                                    "<DATATYPE>", "<STATEMENT LIST>", 
                                    "<DECLARATION LIST>", "<DECLARATION>",
                                    "<STATEMENT>", "<OTHER STATEMENT>", 
                                    "<ITERATION STATEMENT>", "<CONDITIONAL LIST>",
                                    "<CONDITIONAL OPTION>", "<CONDITION>", 
                                    "<VALUE>", "<BOOLEAN>", "<RELATIONAL OPERATOR>", 
                                    "<LOGICAL OPERATOR>", "<ASSIGNMENT STATEMENT>",
                                    "<ASSIGNMENT VALUE>", "<ARITHMETIC CHOICE>", 
                                    "<VARNUM>", "<ARITHMETIC OPEARTOR>", 
                                    "<IF ELSE STATEMENT>", "<ELSE PART>", 
                                    "<FUNCTION CALL>", "<CALL PARAM LIST>", 
                                    "<CALL PARAM OPTION>", "<INPUT>", "<OUTPUT>"};
    }
    
    //Populate data for our LookUpTable
    private void populateLookUpTable(){
        table = new String[][]{
                        //<PROGRAM>
                        {null, null, null, "<MAIN>", "<FUNCTION LIST><MAIN>", 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //MAIN
                        {null, null, null, "#main(){<STATEMENT LIST>}", null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //FUNCTION LIST
                        {null, null, null, null, "<FUNCTION><FUNCTION LIST>",
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //FUNCTION
                        {null, null, null, null, "#func id(<PARAMETER LIST>){<STATEMENT LIST>}",
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //PARAMETER LIST
                        {null, null, null, null, null,
                         null, null, null, null, "<PARAMETER><PARAMETER OPTION>", 
                         "<PARAMETER><PARAMETER OPTION>", "<PARAMETER><PARAMETER OPTION>", null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, "epsilon", null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //PARAMETER OPTION
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, "epsilon", null, null, 
                         null, ",<PARAMETER><PARAMETER OPTION>", null, null, null,
                         null, null, null, null},
                        
                        //PARAMETER
                        {null, null, null, null, null,
                         null, null, null, null, "<DATATYPE> id", 
                         "<DATATYPE> id", "<DATATYPE> id", null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null},
                        
                        //DATATYPE
                        {null, null, null, null, null,
                         null, null, null, null, "#int", 
                         "#char", "#boolean", null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null},
                        
                        //STATEMENT LIST
                        {"<STATEMENT>", null, null, null, null,
                         "<STATEMENT>", null, null, "<STATEMENT>", "<DECLARATION LIST><STATEMENT>", 
                         "<DECLARATION LIST><STATEMENT>", "<DECLARATION LIST><STATEMENT>", null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, "epsilon", 
                         null, null, null, "<STATEMENT>", "<STATEMENT>", 
                         "<STATEMENT>", "<STATEMENT>", null, null},
                        
                        //DECLARATION LIST
                        {null, null, null, null, null,
                         null, null, null, null, "<DECLARATION><DECLARATION LIST>", 
                         "<DECLARATION><DECLARATION LIST>", "<DECLARATION><DECLARATION LIST>", null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //DECLARATION
                        {null, null, null, null, null,
                         null, null, null, null, "<DATATYPE> id;", 
                         "<DATATYPE> id;", "<DATATYPE> id;", null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null},
                        
                        //STATEMENT
                        {"<OTHER STATEMENT><STATEMENT>", null, null, null, null,
                         "<OTHER STATEMENT><STATEMENT>", null, null, "<OTHER STATEMENT><STATEMENT>", null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, "epsilon", 
                         null, null, null, "<OTHER STATEMENT><STATEMENT>", "<OTHER STATEMENT><STATEMENT>", 
                         "<OTHER STATEMENT><STATEMENT>", "<OTHER STATEMENT><STATEMENT>", null, null},
                        
                        //OTHER STATEMENT
                        {"<ASSIGNMENT STATEMENT>|<FUNCTION CALL>", null, null, null, null,
                         "<IF ELSE STATEMENT>", null, null, "<ITERATION STATEMENT>", null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, "<INPUT>", "<INPUT>", 
                         "<INPUT>", "<OUTPUT>", null, null},
                        
                        //ITERATION STATEMENT
                        {null, null, null, null, null,
                         null, null, null, "while(<CONDITION LIST>)<STATEMENT>end", null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //CONDITIONAL LIST
                        {"<CONDITION><CONDITIONAL OPTION>", null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, "<CONDITION><CONDITIONAL OPTION>", "<CONDITION><CONDITIONAL OPTION>"},
                        
                        //CONDITIONAL OPTION
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, "<LOGICAL OPERATOR><CONDITION><CONDITIONAL OPTION>", "<LOGICAL OPERATOR><CONDITION><CONDITIONAL OPTION>", 
                         null, null, "epsilon", null, null, 
                         null, null, null, null, null, 
                         null, null, null, null},
                        
                        //CONDITION
                        {"id<RELATIONAL OPERATOR><VALUE>", null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, "<BOOLEAN>", "<BOOLEAN>"},
                        
                        //VALUE
                        {"id", "int", null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, "'char'", null, null, 
                         null, null, null, null},
                        
                        //BOOLEAN
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, "true", "false"},
                        
                        //RELATIONAL OPERATOR
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, "<", ">", "<=", 
                         ">=", "==", "!=", null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null},
                        
                        //LOGICAL OPERATOR
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, "&", "|",
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null},
                        
                        //ASSIGNMENT STATEMENT
                        {"id=<ASSIGNMENT VALUE>;", null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null},
                        
                        //ASSIGNMENT VALUE
                        {"<VALUE>|<VARNUM><ARITHMETIC CHOICE>", "<VALUE>|<VARNUM><ARITHMETIC CHOICE>", null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, "VALUE", null, null, 
                         null, null, null, null},
                        
                        //ARITHMETIC CHOICE
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, "<ARITHMETIC OPERATOR><VARNUM><ARITHMETIC CHOICE>", "<ARITHMETIC OPERATOR><VARNUM><ARITHMETIC CHOICE>", "<ARITHMETIC OPERATOR><VARNUM><ARITHMETIC CHOICE>", 
                         "<ARITHMETIC OPERATOR><VARNUM><ARITHMETIC CHOICE>", "<ARITHMETIC OPERATOR><VARNUM><ARITHMETIC CHOICE>", null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         "epsilon", null, null, null, null, 
                         null, null, null, null},
                        
                        //VARNUM
                        {"id", "int", null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //ARITHMETIC OPERATOR
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, "+", "-", "*",
                         "/", "%", null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //IF ELSE STATEMENT
                        {null, null, null, null, null,
                         "if(<CONDITION LIST>)<STATEMENT><ELSE PART>end", null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //ELSE PART
                        {null, null, null, null, null,
                         null, "else<STATEMENT>", "epsilon", null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //FUNCTION CALL
                        {"id(<CALL PARAM LIST>);", null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null},
                        
                        //CALL PARAM LIST
                        {"<VALUE><CALL PARAM OPTION>", "<VALUE><CALL PARAM OPTION>", null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, "epsilon", null, null, 
                         null, null, "<VALUE><CALL PARAM OPTION>", null, null,
                         null, null, null, null},
                        
                        //CALL PARAM OPTION
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, "epsilon", null, null, 
                         null, ",<VALUE><CALL PARAM OPTION>", null, null, null,
                         null, null, null, null},
                        
                        //INPUT
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, "#getInt(id);", "#getChar(id);",
                         "#getBoolean(id);", null, null, null},
                        
                        //OUTPUT
                        {null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null,
                         null, null, null, null, null, 
                         null, null, null, null, null,
                         null, "#puts(id);", null, null},
                    };
    }
}
