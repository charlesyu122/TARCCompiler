/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tarccompiler;

import files.FileNode;
import files.FileSelectorModel;
import files.ReadFile;
import files.WriteFile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.TreePath;

/**
 *
 * @author charles_yu102
 */
public class CompilerGUI extends javax.swing.JFrame {

    // Attributes
    ArrayList<TARCFile> tarcFiles;
    
    /**
     * Creates new form CompilerGUI
     */
    public CompilerGUI() {
        initComponents();
        tarcFiles = new ArrayList<TARCFile>();
        tarcFiles.add(new TARCFile(taCode));
        // Initialize file tree
        initFileTree();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcOpenFile = new javax.swing.JFileChooser();
        fcSaveAs = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileTree = fileTree = new JTree(new FileSelectorModel("/Users/charles_yu102/Documents"));
        ;
        btnCompile = new javax.swing.JButton();
        btnOpenFile = new javax.swing.JButton();
        btnNewFile = new javax.swing.JButton();
        tpCode = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taCode = new javax.swing.JTextArea();
        labelStatus = new javax.swing.JLabel();
        tpOutput = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taOutput = new javax.swing.JTextArea();
        btnCloseFile = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        itemNewFile = new javax.swing.JMenuItem();
        itemOpenFile = new javax.swing.JMenuItem();
        itemSave = new javax.swing.JMenuItem();
        itemQuit = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TARC Compiler");
        setLocation(new java.awt.Point(200, 0));

        jScrollPane1.setViewportView(fileTree);

        btnCompile.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tarccompiler/resources/compile.png"))); // NOI18N
        btnCompile.setText("Compile Code");
        btnCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompileActionPerformed(evt);
            }
        });

        btnOpenFile.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnOpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tarccompiler/resources/open.png"))); // NOI18N
        btnOpenFile.setText("Open File");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });

        btnNewFile.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        btnNewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tarccompiler/resources/new.png"))); // NOI18N
        btnNewFile.setText("New File");
        btnNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFileActionPerformed(evt);
            }
        });

        taCode.setBackground(new java.awt.Color(51, 51, 51));
        taCode.setColumns(20);
        taCode.setForeground(new java.awt.Color(51, 204, 0));
        taCode.setRows(5);
        taCode.setTabSize(4);
        taCode.setCaretColor(new java.awt.Color(255, 255, 0));
        jScrollPane2.setViewportView(taCode);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        tpCode.addTab("[No Name]", jPanel3);

        labelStatus.setText("Status");

        taOutput.setColumns(20);
        taOutput.setForeground(new java.awt.Color(255, 0, 0));
        taOutput.setRows(5);
        jScrollPane4.setViewportView(taOutput);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );

        tpOutput.addTab("Output:", jPanel1);

        btnCloseFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tarccompiler/resources/close.png"))); // NOI18N
        btnCloseFile.setText("Close File");
        btnCloseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseFileActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tarccompiler/resources/save.png"))); // NOI18N
        btnSave.setText("Save Code");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        menuFile.setText("File");

        itemNewFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemNewFile.setText("New File");
        itemNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNewFileActionPerformed(evt);
            }
        });
        menuFile.add(itemNewFile);

        itemOpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itemOpenFile.setText("Open File...");
        itemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOpenFileActionPerformed(evt);
            }
        });
        menuFile.add(itemOpenFile);

        itemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSave.setText("Save");
        itemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSaveActionPerformed(evt);
            }
        });
        menuFile.add(itemSave);

        itemQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        itemQuit.setText("Quit");
        itemQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuitActionPerformed(evt);
            }
        });
        menuFile.add(itemQuit);

        menuBar.add(menuFile);

        menuAbout.setText("About");
        menuBar.add(menuAbout);

        menuHelp.setText("Help");
        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(btnNewFile)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnOpenFile)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnSave)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnCompile)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnCloseFile)
                .add(0, 0, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(tpOutput)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, tpCode))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(labelStatus)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnNewFile, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnOpenFile)
                    .add(btnCompile)
                    .add(btnCloseFile)
                    .add(btnSave))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(tpCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 442, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(tpOutput))
                    .add(layout.createSequentialGroup()
                        .add(15, 15, 15)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 564, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompileActionPerformed
        // TODO add your handling code here:
        
        // Instantiate classes for source code compilation here
    }//GEN-LAST:event_btnCompileActionPerformed

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter ft = new FileNameExtensionFilter("TARC Codes", "tarc");
        fcOpenFile.addChoosableFileFilter(ft);
        
        int returnVal = fcOpenFile.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            openFile(fcOpenFile.getSelectedFile());
        }
    }//GEN-LAST:event_btnOpenFileActionPerformed

    private void btnNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFileActionPerformed
        // TODO add your handling code here:
        newFile();
    }//GEN-LAST:event_btnNewFileActionPerformed

    private void itemNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNewFileActionPerformed
        // TODO add your handling code here:
        newFile();
    }//GEN-LAST:event_itemNewFileActionPerformed

    private void itemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOpenFileActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter ft = new FileNameExtensionFilter("TARC Codes", "tarc");
        fcOpenFile.addChoosableFileFilter(ft);
        
        int returnVal = fcOpenFile.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            openFile(fcOpenFile.getSelectedFile());
        }
    }//GEN-LAST:event_itemOpenFileActionPerformed

    private void btnCloseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseFileActionPerformed
        // TODO add your handling code here:
        // Get selected file and code
        int selectedTabIndex = tpCode.getSelectedIndex();
            if(tpCode.getTabCount()!=1){
            if(tarcFiles.get(selectedTabIndex).file == null && tarcFiles.get(selectedTabIndex).areaCode.getText().equals("")){ 
                // Empty file
            } else{
                // Prompt to save or not
                int save = JOptionPane.showConfirmDialog(null,"Do you want to save before closing?","Close TARC Code", JOptionPane.YES_NO_CANCEL_OPTION);
                if(save == JOptionPane.YES_OPTION){
                    saveFile();
                }
            }
           // Close file
           tpCode.remove(selectedTabIndex);
           tarcFiles.remove(selectedTabIndex);
        }
    }//GEN-LAST:event_btnCloseFileActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        saveFile();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void itemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSaveActionPerformed
        // TODO add your handling code here:
        saveFile();
    }//GEN-LAST:event_itemSaveActionPerformed

    private void itemQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuitActionPerformed
        // TODO add your handling code here:
        int quit = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit","Quit TARC Compiler", JOptionPane.YES_NO_CANCEL_OPTION);
        if(quit == JOptionPane.YES_OPTION){
            System.exit(1);
        }
    }//GEN-LAST:event_itemQuitActionPerformed

    // Methods
    
    private void initFileTree(){
        fileTree.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                int selRow = fileTree.getRowForLocation(me.getX(), me.getY());
                TreePath selPath = fileTree.getPathForLocation(me.getX(), me.getY());
                if(selRow != -1){
                    if(me.getClickCount() == 2){ // Double click
                        FileNode selectedNode = (FileNode) fileTree.getLastSelectedPathComponent();
                        File filepath = new File(selectedNode.getAbsolutePath());
                        if(isTarcCode(parseFileName(filepath.toString()))){
                            // open TARC file
                            openFile(filepath);
                        }else{
                            JOptionPane.showMessageDialog(null, "Can only open TARC Codes.");
                        }
                    }
                }
            }
            
        });
    }
    
    private String parseFileName(String file){
        String filename;
        String delim = "/";
        String[] files = file.split(delim);
        filename = files[files.length-1];
        return filename;
    }
    
    private Boolean isTarcCode(String filename){
        Boolean tarcCheck = false;
        String ext = filename.substring(filename.lastIndexOf('.')+1, filename.length());
        if(ext.equals("tarc")){
           tarcCheck = true;
        }
        return tarcCheck;
    }
    
    private JPanel createNewCodeArea(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextArea newCodeArea = new JTextArea();
        newCodeArea.setBackground(new Color(51,51,51));
        newCodeArea.setForeground(new Color(51,204,0));
        newCodeArea.setCaretColor(new Color(255,255,0));
        JScrollPane scroll = new JScrollPane(newCodeArea);
        panel.add(scroll, BorderLayout.CENTER);
        // Add textarea to list of tarc files
        this.tarcFiles.add(new TARCFile(newCodeArea));
        return panel;
    }
    
    private int checkOpenedFiles(File file){
        int index = -1;
        for(int i = 0; index == -1 && i<tarcFiles.size(); i++){
            if(tarcFiles.get(i).file != null && tarcFiles.get(i).file.toString().equals(file.toString())){
                index = i;
            }
        }
        return index;        
    }
    
    private void newFile(){
        if( tpCode.getTitleAt(tpCode.getTabCount()-1).equals("[No Name]") ){
            // No need to add tab
        }else {
            // Add a new tab
            JPanel panel = this.createNewCodeArea();
            tpCode.addTab("[No Name]", panel);
            tpCode.setSelectedIndex(tpCode.getTabCount()-1);
        }
    }
    
    private void openFile(File file){
            
        // Retrieve filename
        String filename = parseFileName(file.toString());
            
        // Check opened files
        int indexCheck = checkOpenedFiles(file);
        if(indexCheck == -1){
            // Adjust codes tabbed pane
            int position = tpCode.getSelectedIndex();
            if(tpCode.getTitleAt(position).equals("[No Name]")){
                tpCode.setTitleAt(position, filename);
            }else{
                // Open another tab
                JPanel panel = this.createNewCodeArea();
                tpCode.addTab(filename, panel);
                position = tpCode.getTabCount()-1;
                tpCode.setSelectedIndex(position);                
            }   
            // Display code in latest text area
            ReadFile rf = new ReadFile(file);
            this.tarcFiles.get(position).areaCode.setText(rf.read());
            this.tarcFiles.get(position).setFile(file);
        }else{
            tpCode.setSelectedIndex(indexCheck);
        }
    }
    
    private void saveFile(){
        // Get selected file and code
        int selectedIndex = tpCode.getSelectedIndex();
        File file = tarcFiles.get(selectedIndex).file;
        String code = tarcFiles.get(selectedIndex).areaCode.getText();
        
        if(file == null){ // For Save As
            FileFilter ft = new FileNameExtensionFilter("TARC Codes","tarc");
            fcSaveAs.addChoosableFileFilter(ft);
        
            int returnVal = fcSaveAs.showSaveDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                file = fcSaveAs.getSelectedFile();
            }
            // Display name
            tpCode.setTitleAt(selectedIndex, parseFileName(file.toString()));
        }
        WriteFile wf = new WriteFile(file,code);
        wf.write();
        JOptionPane.showMessageDialog(this, "Your code was successfully saved.");
    }
    
    // For debugging
    private void displayOpenedFiles(){
        System.out.println("File opened: "+tarcFiles.size());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompilerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompilerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompilerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompilerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompilerGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseFile;
    private javax.swing.JButton btnCompile;
    private javax.swing.JButton btnNewFile;
    private javax.swing.JButton btnOpenFile;
    private javax.swing.JButton btnSave;
    private javax.swing.JFileChooser fcOpenFile;
    private javax.swing.JFileChooser fcSaveAs;
    private javax.swing.JTree fileTree;
    private javax.swing.JMenuItem itemNewFile;
    private javax.swing.JMenuItem itemOpenFile;
    private javax.swing.JMenuItem itemQuit;
    private javax.swing.JMenuItem itemSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JTextArea taCode;
    private javax.swing.JTextArea taOutput;
    private javax.swing.JTabbedPane tpCode;
    private javax.swing.JTabbedPane tpOutput;
    // End of variables declaration//GEN-END:variables
}
