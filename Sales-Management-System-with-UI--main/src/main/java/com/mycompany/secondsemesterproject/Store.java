/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.secondsemesterproject;

import java.awt.Color;
import static java.lang.Math.random;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Store extends javax.swing.JFrame {

    DefaultTableModel myTable = new DefaultTableModel();

    String cols[] = {"Stock ID", "Item Name", "Item Id", "Quantity", "Location Id", "Last Updated"};

    Connection conn;

    private ArrayList<Integer> itemIds = new ArrayList<>();
    private ArrayList<Integer> locationsIds = new ArrayList<>();

    //show items
    public void PopulateItemsWithDatabase() {
        ProductsInSstm.removeAllItems(); // Clear the combo box
        itemIds.clear(); // Clear the ID list

        String query = "SELECT ItemID AS ID, ItemName FROM Items";
        try (PreparedStatement statement = conn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID"); // ID column (e.g., CategoryID, ConditionID)
                String name = resultSet.getString("ItemName"); // Name column (e.g., CategoryName, ConditionName)

                itemIds.add(id); // Store the ID in the ArrayList
                ProductsInSstm.addItem(name); // Add the name to the combo box
            }
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error populating combo box!");
        }
    }

    //show locatioans
    public void PopulateLocationsWithDatabase() {
        LocationId.removeAllItems(); // Clear the combo box
        locationsIds.clear(); // Clear the ID list

        String query = "SELECT LocationID AS ID, LocationName FROM Locations";
        try (PreparedStatement statement = conn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID"); // ID column (e.g., CategoryID, ConditionID)
                String name = resultSet.getString("LocationName"); // Name column (e.g., CategoryName, ConditionName)

                locationsIds.add(id); // Store the ID in the ArrayList
                LocationId.addItem(name); // Add the name to the combo box
            }
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error populating combo box!");
        }
    }

    //show stock data in the dable
    public void populateTable() {
        // Clear the table model before populating it
        myTable.setRowCount(0);

        try {
            // Corrected query: Removed stray comma and ensured proper joins
            String query = "SELECT s.StockID, i.ItemName, s.ItemID, s.Quantity, s.LocationID, s.LastUpdated "
                    + "FROM Stock s JOIN Items i ON i.ItemID = s.ItemID";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int stockId = resultSet.getInt("StockID");
                String itemName = resultSet.getString("ItemName");
                int itemId = resultSet.getInt("ItemID");
                int quantity = resultSet.getInt("Quantity");
                int locationId = resultSet.getInt("LocationID");
                String lastUpdated = resultSet.getString("LastUpdated"); // Use String for datetime

                myTable.addRow(new Object[]{stockId, itemName, itemId, quantity, locationId, lastUpdated});
            }

            System.out.println("Table populated successfully.");
        } catch (SQLException ex) {
            System.out.println("Error populating table: " + ex.getMessage());
        }
    }
    
    
    public int userID;
    public int userRole;

    /**
     * Creates new form System1
     */
    
    
    
    public Store(){
    
    initComponents();
    
    

      
        ctest cMngr = new ctest();

        try {
            conn = cMngr.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }

    

        this.setLocationRelativeTo(null);

        jTable1.setModel(myTable);
        myTable.setColumnIdentifiers(cols);

        PopulateItemsWithDatabase();
        PopulateLocationsWithDatabase();
        populateTable();
        
    
    }
    
    
    
    public Store(int userID, int userRole) {
        initComponents();
    
        ctest cMngr = new ctest();

        try {
            conn = cMngr.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }


        this.setLocationRelativeTo(null);

        jTable1.setModel(myTable);
        myTable.setColumnIdentifiers(cols);

        PopulateItemsWithDatabase();
        PopulateLocationsWithDatabase();
        populateTable();
        
        
        this.userID = userID;
        this.userRole = userRole;
        
        
        if (userRole==3) {
            
            ProductsInSstm.setEnabled(false);
                    LocationId.setEnabled(false);
                    QuantityFLD.setEnabled(false);
                            AddTOSTOCK.setEnabled(false);
                            DeleteBtn.setEnabled(false);
            
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        QuantityFLD = new javax.swing.JTextField();
        DeleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ProductsInSstm = new javax.swing.JComboBox<>();
        AddTOSTOCK = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LocationId = new javax.swing.JComboBox<>();
        goTobil_btn = new javax.swing.JButton();
        back_home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Stock Management System");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(jLabel8)
                .addContainerGap(864, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(449, 449, 449))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        QuantityFLD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(71, 6, 56), 3, true));

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        ProductsInSstm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsInSstmActionPerformed(evt);
            }
        });

        AddTOSTOCK.setText("Add to My Avaliable Stock");
        AddTOSTOCK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTOSTOCKActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(71, 6, 56));

        jLabel12.setBackground(new java.awt.Color(121, 158, 81));
        jLabel12.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(71, 6, 56));
        jLabel12.setText("Product ");

        jLabel14.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(71, 6, 56));
        jLabel14.setText("Enter Quantity");

        jLabel15.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(71, 6, 56));
        jLabel15.setText("Location");

        jLabel16.setBackground(new java.awt.Color(121, 158, 81));
        jLabel16.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(71, 6, 56));
        jLabel16.setText("Stock List");

        goTobil_btn.setText("Add Bill");
        goTobil_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goTobil_btnActionPerformed(evt);
            }
        });

        back_home.setText("Back Home");
        back_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel15))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(37, 37, 37)
                                .addComponent(ProductsInSstm, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(LocationId, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel14)
                        .addGap(39, 39, 39)
                        .addComponent(QuantityFLD, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(goTobil_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AddTOSTOCK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(back_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(150, 150, 150))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(362, 362, 362))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(ProductsInSstm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(LocationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(QuantityFLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(back_home, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(goTobil_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AddTOSTOCK, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(DeleteBtn)
                        .addGap(29, 29, 29))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Delte item from the stock
    private void deleteSelectedRow() {
        int itemId =0;
        // Get the selected row index
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item from stock?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                // Get the ID of the selected stock (assuming the first column is StockID)
                String stockId_s = jTable1.getValueAt(selectedRow, 0).toString();
                int stockId = Integer.parseInt(stockId_s);

                // Get the associated ItemID
                String itemIdQuery = "SELECT ItemID FROM Stock WHERE StockID = ?";
                try (PreparedStatement itemIdStmt = conn.prepareStatement(itemIdQuery)) {
                    itemIdStmt.setInt(1, stockId);
                    try (ResultSet rs = itemIdStmt.executeQuery()) {
                        if (rs.next()) {
                             itemId = rs.getInt("ItemID");

                            // Check if the ItemID exists in the Damage table
                            String damageCheckQuery = "SELECT COUNT(*) AS Count FROM Damage WHERE ItemID = ?";
                            try (PreparedStatement damageStmt = conn.prepareStatement(damageCheckQuery)) {
                                damageStmt.setInt(1, itemId);
                                try (ResultSet damageRs = damageStmt.executeQuery()) {
                                    if (damageRs.next() && damageRs.getInt("Count") > 0) {
                                        // Item exists in the Damage table
                                        JOptionPane.showMessageDialog(null, "This item is associated with the Damage table and cannot be deleted.");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error checking item associations.");
                    return;
                }

                // Proceed with deletion if the item is not in the Damage table
                String deleteQuery = "DELETE FROM Stock WHERE StockID = ?";
                try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
                    stmt.setInt(1, stockId);
                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected > 0) {
                        // Remove the row from the JTable model
                        myTable.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Item deleted successfully.");
                        createReport(6, itemId, userID, "item removed from stock");
                    } else {
                        JOptionPane.showMessageDialog(null, "Item not found in the database.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error deleting item from the database.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        }
    }

    // Delete button
    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed

        deleteSelectedRow();

    }//GEN-LAST:event_DeleteBtnActionPerformed

    //check the form fields


    
    
    
     public void createReport(int reportTypeID, Integer itemID, int performedBy, String notes) throws SQLException {
        String query = "INSERT INTO Reports (ReportTypeID, ItemID, PerformedBy, Timestamp, Notes) VALUES (?, ?, ?, GETDATE(), ?)";

        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, reportTypeID);

        stmt.setInt(2, itemID);

        stmt.setInt(3, performedBy);
        stmt.setString(4, notes);

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Report created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    
    //add item into the stock (note: location is overlapping)
    private void AddTOSTOCKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTOSTOCKActionPerformed
        // TODO add your handling code here:
        int selectedIndex = ProductsInSstm.getSelectedIndex(); // Get selected index
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to add to stock!");
            return;
        }

        int itemId = itemIds.get(selectedIndex); // Get the ItemID corresponding to the selected index
        int LocationID = locationsIds.get(selectedIndex);
        // Get the quantity from the quantity field
        String quantityText = QuantityFLD.getText();
        if (quantityText.isEmpty() || !quantityText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity!");
            return;
        }
        int quantity = Integer.parseInt(quantityText);

        // Check if the item is already in stock
        String checkQuery = "SELECT Quantity FROM Stock WHERE ItemID = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, itemId);
            try (ResultSet resultSet = checkStmt.executeQuery()) {
                if (resultSet.next()) {
                    // Item exists in stock, update quantity
                    int currentQuantity = resultSet.getInt("Quantity");
                    int newQuantity = currentQuantity + quantity;

                    String updateQuery = "UPDATE Stock SET Quantity = ?, LastUpdated = GETDATE() WHERE ItemID = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setInt(1, newQuantity);
                        updateStmt.setInt(2, itemId);
                        int rowsAffected = updateStmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(this, "Stock updated successfully!");
                            createReport(1, itemId, userID, "new quantity added to stock");
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to update stock!");
                        }
                    }
                } else {
                    // Item does not exist in stock, insert new record
                    String insertQuery = "INSERT INTO Stock (ItemID, Quantity, LocationID, LastUpdated) VALUES (?, ?, ?, GETDATE())";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                        insertStmt.setInt(1, itemId);
                        insertStmt.setInt(2, quantity);
                        insertStmt.setInt(3, LocationID); // Set the appropriate LocationID
                        int rowsAffected = insertStmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(this, "Item added to stock successfully!");
                            createReport(1, itemId, ERROR, "new item added to stock");
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to add item to stock!");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error adding item to stock!");
        }

        // Refresh the stock table
        populateTable();
    }//GEN-LAST:event_AddTOSTOCKActionPerformed

    private void ProductsInSstmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsInSstmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductsInSstmActionPerformed

    private void goTobil_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goTobil_btnActionPerformed

dispose();
        BillMaker m = new BillMaker(userID,userRole);
        m.setVisible(true);
        
        

        // TODO add your handling code here:
    }//GEN-LAST:event_goTobil_btnActionPerformed

    private void back_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_homeActionPerformed


dispose();

        if (userRole==1) {
            
            ManagerDasboard m = new ManagerDasboard(userRole, userID);
            m.setVisible(true);
            
        } else {
        
            DealerDasboard m = new DealerDasboard(userID, userRole);
        m.setVisible(true);
        }



        // TODO add your handling code here:
    }//GEN-LAST:event_back_homeActionPerformed

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
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Store().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTOSTOCK;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JComboBox<String> LocationId;
    private javax.swing.JComboBox<String> ProductsInSstm;
    private javax.swing.JTextField QuantityFLD;
    private javax.swing.JButton back_home;
    private javax.swing.JButton goTobil_btn;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
