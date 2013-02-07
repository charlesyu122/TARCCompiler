/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import datamodels.ProductionModel;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public final class Production {
    
    // Attributes
    protected ArrayList<ProductionModel> productionTable;
    private ProductionModel productionModel;
    
    // Constructor
    public Production(){
        productionTable = new ArrayList<ProductionModel>();
        this.populateProductionTable();
    }
    
    // Populates grammar productions
    private void populateProductionTable(){
        
        productionModel = new ProductionModel();        
        productionModel.setTerminal("<PROGRAM>");
        productionModel.addProductions("<FUNCTION LIST>");
        productionModel.addProductions("<MAIN>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<MAIN>");
        productionModel.addProductions("#main(){<STATEMENT LIST>}");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<FUNCTION LIST>");
        productionModel.addProductions("<FUNCTION><FUNCTION LIST>");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<FUNCTION>");
        productionModel.addProductions("#<NAME>(<PARAMETER LIST>){<STATEMENT LIST>}");
        productionTable.add(productionModel);

        productionModel = new ProductionModel();
        productionModel.setTerminal("<PARAMETER LIST>");
        productionModel.addProductions("<PARAMETER><PARAMETER OPTION>");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<PARAMETER OPTION");
        productionModel.addProductions("PARAMETER LIST");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<PARAMETER>");
        productionModel.addProductions("<TYPE SPECIFIER>");
        productionModel.addProductions("<NAME>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<STATEMENT LIST>");
        productionModel.addProductions("<DECLARATION LIST>");
        productionModel.addProductions("<STATEMENT>");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<DECLARATION LIST>");
        productionModel.addProductions("<DECLARATION>");
        productionModel.addProductions("<DECLARATION LIST>");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<STATEMENT>");
        productionModel.addProductions("<OTHER STATEMENT><STATEMENT>");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);

        productionModel = new ProductionModel();
        productionModel.setTerminal("<OTHER STATEMENT>");
        productionModel.addProductions("<ITERATION STATEMENT>");
        productionModel.addProductions("<SELECTION STATEMENT>");
        productionModel.addProductions("<ASSIGNMENT STATEMENT>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ITERATION STATEMENT>");
        productionModel.addProductions("while(<ITERATION LIST>)<STATEMENT>end");
        productionModel.addProductions("<SELECTION STATEMENT><STATEMENT>");
        productionModel.addProductions("<ASSIGNMENT STATEMENT><STATEMENT>");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ITERATION LIST>");
        productionModel.addProductions("<CONDITIONAL LIST>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<CONDITIONAL LIST>");
        productionModel.addProductions("<CONDITION>");
        productionModel.addProductions("<CONDITION OPTION>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<CONDITIONAL OPTION>");
        productionModel.addProductions("<LOGICAL OPERATOR><CONDITIONAL LIST>");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<CONDITION>");
        productionModel.setTerminal("<CONDITION OPTION><RELATIONAL OPERATOR><CONDITION OPTION>");
        productionModel.addProductions("true");
        productionModel.addProductions("false");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<CONDITION OPTION>");
        productionModel.addProductions("<VALUE>");
        productionModel.addProductions("<NAME><UNARY OPERATOR>");
        productionModel.addProductions("<ARITHMETIC EXPRESSION>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<RELATIONAL OPERATOR>");
        productionModel.addProductions("<=");
        productionModel.addProductions("<");
        productionModel.addProductions(">");
        productionModel.addProductions(">=");
        productionModel.addProductions("==");
        productionModel.addProductions("!=");
        productionTable.add(productionModel);
        
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<LOGICAL OPERATOR>");
        productionModel.addProductions("&");
        productionModel.addProductions("|");
        productionModel.addProductions("!");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<VALUE>");
        productionModel.addProductions("'<LETTER>'");
        productionModel.addProductions("<DIGIT>");
        productionModel.addProductions("<NUM>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<NAME>");
        productionModel.addProductions("(<NAME OPTION>)<WORD>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<NAME OPTION>");
        productionModel.addProductions("<LETTER>");
        productionModel.addProductions("<WORD>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<WORD>");
        productionModel.addProductions("<LETTER><WORD>");
        productionModel.addProductions("<NUM><WORD>");
        productionModel.addProductions("epsilon");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ARITHMETIC EXPRESSION>");
        productionModel.addProductions("<ARITHMETIC OPTION><ARITHMETIC OPERATOR><ARITHMETIC CHOICE>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ARITHMETIC CHOICE>");
        productionModel.addProductions("<ARITHMETIC OPTION>");
        productionModel.addProductions("<ARITHMETIC EXPRESSION>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ARITHMETIC OPTION>");
        productionModel.addProductions("<NAME>");
        productionModel.addProductions("<NUM>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ARITHMETIC OPERATOR>");
        productionModel.addProductions("+");
        productionModel.addProductions("-");
        productionModel.addProductions("/");
        productionModel.addProductions("*");
        productionModel.addProductions("%");
        productionTable.add(productionModel);

        productionModel = new ProductionModel();
        productionModel.setTerminal("<ASSIGNMENT STATEMENT>");
        productionModel.addProductions("<NAME><ASSIGNMENT OPERATOR>(<ARITHMETIC OPTION>)");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ASSIGNMENT OPTION>");
        productionModel.addProductions("<VALUE>");
        productionModel.addProductions("ARITHMETIC EXPRESSION");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ASSIGNMENT OPERATOR>");
        productionModel.addProductions("=");
        productionModel.addProductions("*=");
        productionModel.addProductions("+=");
        productionModel.addProductions("-=");
        productionModel.addProductions("/=");
        productionModel.addProductions("%=");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<UNARY OPERATOR>");
        productionModel.addProductions("++");
        productionModel.addProductions("--");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<LETTER>");
        productionModel.addProductions("A");    productionModel.addProductions("a");
        productionModel.addProductions("B");    productionModel.addProductions("b");
        productionModel.addProductions("C");    productionModel.addProductions("c");
        productionModel.addProductions("D");    productionModel.addProductions("d");
        productionModel.addProductions("E");    productionModel.addProductions("e");
        productionModel.addProductions("F");    productionModel.addProductions("f");
        productionModel.addProductions("G");    productionModel.addProductions("g");
        productionModel.addProductions("H");    productionModel.addProductions("h");
        productionModel.addProductions("I");    productionModel.addProductions("i");
        productionModel.addProductions("J");    productionModel.addProductions("j");
        productionModel.addProductions("K");    productionModel.addProductions("k");
        productionModel.addProductions("L");    productionModel.addProductions("l");
        productionModel.addProductions("M");    productionModel.addProductions("m");
        productionModel.addProductions("N");    productionModel.addProductions("n");
        productionModel.addProductions("O");    productionModel.addProductions("o");
        productionModel.addProductions("P");    productionModel.addProductions("p");
        productionModel.addProductions("Q");    productionModel.addProductions("q");
        productionModel.addProductions("R");    productionModel.addProductions("r");
        productionModel.addProductions("S");    productionModel.addProductions("s");
        productionModel.addProductions("T");    productionModel.addProductions("t");
        productionModel.addProductions("U");    productionModel.addProductions("u");
        productionModel.addProductions("V");    productionModel.addProductions("v");
        productionModel.addProductions("W");    productionModel.addProductions("w");
        productionModel.addProductions("X");    productionModel.addProductions("x");
        productionModel.addProductions("Y");    productionModel.addProductions("y");
        productionModel.addProductions("Z");    productionModel.addProductions("z");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<DIGIT>");
        productionModel.addProductions("1");    productionModel.addProductions("6");
        productionModel.addProductions("2");    productionModel.addProductions("7");
        productionModel.addProductions("3");    productionModel.addProductions("8");
        productionModel.addProductions("4");    productionModel.addProductions("9");
        productionModel.addProductions("5");    productionModel.addProductions("0");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<ARRAY SPECIFIER>");
        productionModel.addProductions("#arr (<SPECIFIER TYPE>,<NUM>)");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<SPECIFIER TYPE>");
        productionModel.addProductions("#int");
        productionModel.addProductions("#char");
        productionModel.addProductions("#boolean");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<TYPE SPECIFIER>");
        productionModel.addProductions("#void");
        productionModel.addProductions("<SPECIFIER TYPE>");
        productionModel.addProductions("<ARRAY SPECIFIER>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<DECLARATION>");
        productionModel.addProductions("<TYPE SPECIFIER>");
        productionModel.addProductions("<NAME>");
        productionTable.add(productionModel);
    }
}
