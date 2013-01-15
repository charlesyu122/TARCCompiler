/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.util.Arrays;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author charles_yu102
 */
public class FileSelectorModel implements TreeModel{

    private FileNode root;
    
    public FileSelectorModel(String directory){
        root = new FileNode(directory);
    }
    
    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        FileNode parentNode = (FileNode) parent;
        return new FileNode(parentNode,parentNode.listFiles()[index].getName());
    }

    @Override
    public int getChildCount(Object parent) {
        FileNode parentNode = (FileNode) parent;
        if (parent == null || !parentNode.isDirectory() || parentNode.listFiles() == null) {
            return 0;
        }

        return parentNode.listFiles().length;
    }

    @Override
    public boolean isLeaf(Object node) {
        return (getChildCount(node) == 0);
    }

    @Override
    public void valueForPathChanged(TreePath tp, Object o) {
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        FileNode parentNode = (FileNode) parent;
        FileNode childNode = (FileNode) child;

        return Arrays.asList(parentNode.list()).indexOf(childNode.getName());
    }

    @Override
    public void addTreeModelListener(TreeModelListener tl) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener tl) {
    }
    
}
