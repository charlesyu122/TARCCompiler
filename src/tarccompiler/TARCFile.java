/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import java.io.File;
import javax.swing.JTextArea;

/**
 *
 * @author charles_yu102
 */
public class TARCFile {
    
    File file;
    JTextArea areaCode;
    
    // constructors
    public TARCFile(JTextArea area){
        this.areaCode = area;
    }
    public TARCFile(File file, JTextArea area){
        this.file = file;
        this.areaCode = area;
    }
    
    public void setFile(File file){
        this.file = file;
    }
    
    public void setCode(JTextArea area){
        this.areaCode = area;
    }
    
}
