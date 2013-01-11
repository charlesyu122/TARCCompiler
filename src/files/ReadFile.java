/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charles_yu102
 */
public class ReadFile {
    File file;
    
    //constructor
    public ReadFile(File file){
        this.file = file;
    }
    
    public String read(){
        String content = "";
        try{
            BufferedReader in = new BufferedReader(new FileReader(file));
            String s = in.readLine();
            while(s!=null){
                content += s + "\n";
                s = in.readLine();
            }
            in.close();
        }catch(IOException ex){
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
    
}
