/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.secondsemesterproject;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DamageHistory extends javax.swing.JFrame {

    
     DefaultTableModel myOrdersTable = new DefaultTableModel();
     //myOrdersTable.addRow(new Object[]{reportID, reportTypeName, itemID, performedBy, timestamp, notes});
      String cols[] = {"Repaired ID" , "item ID","Repaired by", "Repaired Date", "Cost","Notes"};
      
    /**
     * Creates new form ReportsSummary
     * 
     * 
     * 
     */
    
     Connection con;
    
    
    
 private void loadReportsData() {
    String query = """
        SELECT dh.RepairID, dh.item_id, u.UserName AS RepairedBy, dh.RepairDate, dh.Cost, dh.Notes
        FROM DamageHistory dh
        JOIN Users u ON dh.RepairedBy = u.UserID
    """;
/*
    
    */
    try (
         PreparedStatement stmt = con.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        // Clear existing rows in the table model
    
        myOrdersTable.setRowCount(0);

        // Populate the table with data
        while (rs.next()) {
            int repairId = rs.getInt("RepairID");
            int item_id = rs.getInt("item_id");
            String repairedBy = rs.getString("RepairedBy");
            Date repairDate = rs.getDate("RepairDate");
            float cost = rs.getFloat("Cost");
            String notes = rs.getString("Notes");

            // Add data to the table model
            myOrdersTable.addRow(new Object[]{repairId, item_id, repairedBy, repairDate, cost, notes});
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to load reports: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
 
 
 /*
 private void populateDamageHistoryTable() {
    String query = """
        SELECT dh.RepairID, dh.DamageID, u.UserName AS RepairedBy, dh.RepairDate, dh.Cost, dh.Notes
        FROM DamageHistory dh
        JOIN Users u ON dh.RepairedBy = u.UserID
    """;

    try (PreparedStatement stmt = con.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        DefaultTableModel tableModel = (DefaultTableModel) damageHistoryTable.getModel();
        tableModel.setRowCount(0); // Clear existing rows

        while (rs.next()) {
            int repairId = rs.getInt("RepairID");
            int damageId = rs.getInt("DamageID");
            String repairedBy = rs.getString("RepairedBy");
            Date repairDate = rs.getDate("RepairDate");
            float cost = rs.getFloat("Cost");
            String notes = rs.getString("Notes");

            // Add data to the table model
            myOrdersTable.addRow(new Object[]{repairId, damageId, repairedBy, repairDate, cost, notes});
        }
    } catch (SQLException ex) {
        Logger.getLogger(DamageHistoryManager.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error loading damage history data!");
    }
}
 */
 
 
    
     private void deleteProductFromRequests(Object productName) {
        String mySQL = "DELETE * FROM reports WHERE item_name = ?";
        try {
            PreparedStatement statement = con.prepareStatement(mySQL); 
            
            statement.setObject(1, productName);
            statement.executeUpdate();
            
            
        }catch (SQLException ex) {
            
        } 

     }
    
    
    public DamageHistory() {
    
        
        initComponents();
        
           ctest cMngr = new ctest();
        
        try {
            con = cMngr.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DamageHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DamageHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     AvlblRequestsTbl.setModel(myOrdersTable);
        myOrdersTable.setColumnIdentifiers(cols);
        
         this.setLocationRelativeTo(null);
        loadReportsData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AvlblRequestsTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        jLabel15.setBackground(new java.awt.Color(222, 222, 222));
        jLabel15.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Damage History");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel9))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        AvlblRequestsTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(AvlblRequestsTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DamageHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DamageHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DamageHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DamageHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DamageHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AvlblRequestsTbl;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
