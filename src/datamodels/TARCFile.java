/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

import java.io.File;
import javax.swing.JTextArea;

/**
 *
 * @author charles_yu102
 */
public class TARCFile {
    
    private File file;
    private JTextArea areaCode;
    
    // constructors
    public TARCFile(JTextArea area){
        this.areaCode = area;
    }
    public TARCFile(File file, JTextArea area){
        this.file = file;
        this.areaCode = area;
    }
    
    // Setters and Getters
    public void setFile(File file){
        this.file = file;
    }
    
    public void setCode(JTextArea area){
        this.areaCode = area;
    }
    
    public File getFile(){
        return this.file;
    }
    
    public JTextArea getCode(){
        return this.areaCode;
    }
    
}
