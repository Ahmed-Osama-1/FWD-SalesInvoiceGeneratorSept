
package AppProject.view;

import AppProject.controller.AppControllerSept;
import AppProject.model.HeaderModelSept;
import AppProject.model.InvoiceSept;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;


public class AppFrameSept extends javax.swing.JFrame {

    public AppFrameSept() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(listener);
        newInvButton = new javax.swing.JButton();
        newInvButton.addActionListener(listener);
        delInvButton = new javax.swing.JButton();
        delInvButton.addActionListener(listener);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        linesTable = new javax.swing.JTable();
        custNameLabel = new javax.swing.JLabel();
        invNumLabel = new javax.swing.JLabel();
        invDateLabel = new javax.swing.JLabel();
        invTotalLabel = new javax.swing.JLabel();
        delLineButton = new javax.swing.JButton();
        delLineButton.addActionListener(listener);

        newLineButton = new javax.swing.JButton();
        newLineButton.addActionListener(listener);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(listener);

        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(invoicesTable);

        newInvButton.setText("New Invoice");
        newInvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInvButtonActionPerformed(evt);
            }
        });

        delInvButton.setText("Delete Invoice");

        jLabel1.setText("Invoice Num");

        jLabel2.setText("Customer Name");

        jLabel3.setText("Invoice Date");

        jLabel4.setText("Invoice Total");

        linesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(linesTable);

        custNameLabel.setText(".");

        invNumLabel.setText(".");

        invDateLabel.setText(".");

        invTotalLabel.setText(".");

        delLineButton.setText("Delete Line");

        newLineButton.setText("New Line");
        newLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLineButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        loadMenuItem.setText("Load Files");
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save Data");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(newInvButton)
                        .addGap(116, 116, 116)
                        .addComponent(delInvButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invTotalLabel)
                                    .addComponent(invDateLabel)
                                    .addComponent(invNumLabel)
                                    .addComponent(custNameLabel))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(newLineButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delLineButton)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invNumLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(custNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(invDateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newInvButton)
                    .addComponent(delInvButton)
                    .addComponent(newLineButton)
                    .addComponent(delLineButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newLineButtonActionPerformed
     
    }//GEN-LAST:event_newLineButtonActionPerformed

    private void newInvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInvButtonActionPerformed
        
    }//GEN-LAST:event_newInvButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AppFrameSept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrameSept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrameSept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrameSept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppFrameSept frame = new AppFrameSept();
                frame.setVisible(true);
                frame.listener.loadFiles("InvoiceHeaderSept.csv", "InvoiceLineSept.csv");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel custNameLabel;
    private javax.swing.JButton delInvButton;
    private javax.swing.JButton delLineButton;
    private javax.swing.JLabel invDateLabel;
    private javax.swing.JLabel invNumLabel;
    private javax.swing.JLabel invTotalLabel;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable linesTable;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JButton newInvButton;
    private javax.swing.JButton newLineButton;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    
    
    
 private AppControllerSept listener = new AppControllerSept(this);
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private ArrayList<InvoiceSept> invoices;
    private HeaderModelSept headerTableModel;

    public ArrayList<InvoiceSept> getInvoices() {
        if (invoices == null) {
            invoices = new ArrayList<>();
        }
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceSept> invoices) {
        this.invoices = invoices;
    }

    public HeaderModelSept getHeaderTableModel() {
        return headerTableModel;
    }

    public void setHeaderTableModel(HeaderModelSept headerTableModel) {
        this.headerTableModel = headerTableModel;
    }

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public JTable getLinesTable() {
        return linesTable;
    }

    public JLabel getCustNameLabel() {
        return custNameLabel;
    }

    public JLabel getInvDateLabel() {
        return invDateLabel;
    }

    public JLabel getInvNumLabel() {
        return invNumLabel;
    }

    public JLabel getInvTotalLabel() {
        return invTotalLabel;
    }

    public AppControllerSept getListener() {
        return listener;
    }
    
    
    
    
}

