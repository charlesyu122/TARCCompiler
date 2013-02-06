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
    ArrayList<ProductionModel> productionTable;
    ProductionModel productionModel;
    
    // Constructor
    public Production(){
        productionTable = new ArrayList<ProductionModel>();
        this.populateProductionTable();
    }
    
    // Populates grammar productions
    public void populateProductionTable(){
        
        productionModel = new ProductionModel();        
        productionModel.setTerminal("<PROGRAM>");
        productionModel.addProductions("<FUNCTION LIST>");
        productionModel.addProductions("<MAIN>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<MAIN>");
        productionModel.addProductions("#main(){<MAIN>}");
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
        productionModel.addProductions("<PARAMETER>");
        productionModel.addProductions("<PARAMETER>,<PARAMETER LIST>");
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
        productionModel.addProductions("<ITERATION STATEMENT><STATEMENT>");
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
        productionModel.addProductions("<CONDITION>");
        productionModel.addProductions("<LOGICAL OPERATOR>");
        productionModel.addProductions("<CONDITIONAL LIST>");
        productionTable.add(productionModel);
        
        productionModel = new ProductionModel();
        productionModel.setTerminal("<CONDITION>");
        productionModel.addProductions("<VALUE><RELATIONAL OPERATOR><VALUE>");
        productionModel.addProductions("<NAME><RELATIONAL OPERATOR><VALUE>");
        productionModel.addProductions("<VALUE><RELATIONAL OPERATOR>");
        productionModel.addProductions("<NAME><UNARY OPERATOR>");
        productionModel.addProductions("true");
        productionModel.addProductions("false");
        productionModel.addProductions("<ARITHMETIC EXPRESSION><RELATIONAL OPERATOR><VALUE>");
        productionModel.addProductions("<VALUE><RELATIONAL OPERATOR><ARITHMETIC EXPRESSION>");
        productionModel.addProductions("<ARITHMETIC EXPRESSION><RELATIONAL OPERATOR><NAME><UNARY OPERATOR>");
        productionModel.addProductions("<NAME><UNARY OPERATOR><RELATIONAL OPERATOR><ARITHMETIC EXPRESSION>");
        productionModel.addProductions("<ARITHMETIC EXPRESSION><RELATIONAL OPERATOR><ARITHMETIC EXPRESSION>");
        productionModel.addProductions("<NAME><UNARY OPERATOR><RELATIONAL OPERATOR><VALUES>");
        productionModel.addProductions("<VALUE><RELATIONAL OPERATOR><NAME><UNARY OPERATOR>");
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
        productionModel.addProductions("<NAME><ARITHMETIC OPERATOR><NAME>");
        productionModel.addProductions("<NAME><ARITHMETIC OPERATOR><NUM>");
        productionModel.addProductions("<NAME><ARITHMETIC OPERATOR><ARITHMETIC EXPRESSION>");
        productionModel.addProductions("<NUM><ARITHMETIC OPERATOR><NAME>");
        productionModel.addProductions("<NUM><ARITHMETIC OPERATOR><NUM>");
        productionModel.addProductions("<NAME><ARITHMETIC OPERATOR><ARITHMETIC EXPRESSION>");
        productionModel.addProductions("<NUM><ARITHMETIC OPERATOR><ARITHMETIC EXPRESSION>");
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
    }
}
