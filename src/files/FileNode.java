/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.File;

/**
 *
 * @author charles_yu102
 */
public class FileNode extends File{
    
    public FileNode(String directory){
        super(directory);
    }
    
    public FileNode(FileNode parent, String child){
        super(parent, child);
    }
    
    @Override
    public String toString(){
        return getName();
    }
}
