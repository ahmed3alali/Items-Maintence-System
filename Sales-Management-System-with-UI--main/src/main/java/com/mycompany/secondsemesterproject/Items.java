/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.secondsemesterproject;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Items extends javax.swing.JFrame {

    /**
     * Creates new form ItemCard
     */
    Connection con;

    public int userID;
public int UserRole;
    public Items() {
        initComponents();
        
        
        ctest cMngr = new ctest();
       

        try {
            con = cMngr.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setLocationRelativeTo(null);

     
        ConfirmButton.setEnabled(true);

        //generate the combobox
        populateConditionComboBox();
        populateCategoryComboBox();
        populateItemComboBox();
        
    }

    public Items(int userID, int UserRole) {
        initComponents();

        ctest cMngr = new ctest();
        this.userID = userID;
 this.UserRole = UserRole;
        try {
            con = cMngr.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setLocationRelativeTo(null);

      

        
        ConfirmButton.setEnabled(true);

        //generate the combobox
        populateConditionComboBox();
        populateCategoryComboBox();
        populateItemComboBox();
    }

    public class Stock extends Items {

        private int quantity;

        public int getQuantity() {
            return quantity;
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

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        SellingPrice = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        goHome = new javax.swing.JButton();
        goHome1 = new javax.swing.JButton();
        goHome2 = new javax.swing.JButton();
        conditionId = new javax.swing.JComboBox<>();
        WarrantyFLD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        categoryId = new javax.swing.JComboBox<>();
        DeleteButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        selectItem = new javax.swing.JComboBox<>();

        jLabel10.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Items Manager");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(599, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(51, 51, 51))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productName.setForeground(new java.awt.Color(18, 30, 49));

        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel5.setText("Condition");

        jLabel7.setText("TL");

        jLabel14.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel14.setText("Product Name");

        jLabel17.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel17.setText("Price");

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        goHome.setText("Go Home");
        goHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goHomeActionPerformed(evt);
            }
        });

        goHome1.setText("add category");
        goHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goHome1ActionPerformed(evt);
            }
        });

        goHome2.setText("Conditions");
        goHome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goHome2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(goHome2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goHome1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goHome, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(goHome, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(goHome1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(goHome2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Warranty (Months)");

        jLabel9.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        jLabel9.setText("Category");

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel4))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(WarrantyFLD)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(SellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(selectItem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(categoryId, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(conditionId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(productName, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                            .addGap(192, 192, 192))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(SellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(conditionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17)
                                        .addGap(23, 23, 23)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(WarrantyFLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addComponent(categoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ConfirmButton)
                            .addComponent(DeleteButton)
                            .addComponent(EditButton)
                            .addComponent(selectItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(174, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void createReport(int reportTypeID, Integer itemID, int performedBy, String notes) throws SQLException {
        String query = "INSERT INTO Reports (ReportTypeID, ItemID, PerformedBy, Timestamp, Notes) VALUES (?, ?, ?, GETDATE(), ?)";

        PreparedStatement stmt = con.prepareStatement(query);

        stmt.setInt(1, reportTypeID);

        stmt.setInt(2, itemID);

        stmt.setInt(3, performedBy);
        stmt.setString(4, notes);

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Report created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private int getItemId(String itemName) throws SQLException {
        String query = "SELECT ItemID FROM Items WHERE ItemName = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, itemName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("ItemID");
                } else {
                    throw new SQLException("Condition not found: " + itemName);
                }
            }
        }
    }

    //add item to the system
    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        String itemName = productName.getText();
        int price = Integer.parseInt(SellingPrice.getText());
        String warranty = WarrantyFLD.getText();

        
         // Check if the item name is unique
        if (!isItemNameUnique(itemName, -1)) {
            JOptionPane.showMessageDialog(this, "An item with this name already exists! Please choose a different name.");
            return;
        }
        
        
        // Get selected index from combo boxes
        int selectedConditionIndex = conditionId.getSelectedIndex();
        int selectedCategoryIndex = categoryId.getSelectedIndex();

        // Fetch IDs from the ArrayLists
        int conditionId = conditionIds.get(selectedConditionIndex);
        int categoryId = categoryIds.get(selectedCategoryIndex);

        // Insert the item into the Items table
        String query = "INSERT INTO Items (ItemName, CategoryID, ConditionID, Price, Warranty) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, itemName);
            statement.setInt(2, categoryId);
            statement.setInt(3, conditionId);
            statement.setInt(4, price);
            statement.setString(5, warranty);

            statement.executeUpdate();
            populateItemComboBox();
            clearFields();
            JOptionPane.showMessageDialog(this, "Item Added to the system!");
            int itemId = getItemId(itemName);
            createReport(4, itemId, userID, "item has been entered");

        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error adding item to the database!");
        }

    }//GEN-LAST:event_ConfirmButtonActionPerformed

    //Delete item
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed

        int selectedIndex = selectItem.getSelectedIndex(); // Get selected index
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to delete!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the item?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int itemId = itemIds.get(selectedIndex); // Get ItemID corresponding to the selected index
            boolean isUsed = false;
            StringBuilder usageMessage = new StringBuilder("The item is being used in the following tables:\n");

            // Check tables using isItemInTable
            if (isItemInTable(itemId, "Stock")) {
                isUsed = true;
                usageMessage.append("- Stock\n");
            }
            if (isItemInTable(itemId, "Damage")) {
                isUsed = true;
                usageMessage.append("- Damage\n");
            }
            if (isItemInTable(itemId, "BillDetails")) {
                isUsed = true;
                usageMessage.append("- BillDetails\n");
            }

            // If the item is used, show the message and return
            if (isUsed) {
                JOptionPane.showMessageDialog(this, usageMessage.toString());
                return;
            }

            // If the item is not used, delete it from the Items table
            String deleteQuery = "DELETE FROM Items WHERE ItemID = ?";
            try (PreparedStatement deleteStmt = con.prepareStatement(deleteQuery)) {
                deleteStmt.setInt(1, itemId);
                int rowsAffected = deleteStmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Item deleted successfully!");

                    populateItemComboBox();

                    createReport(2, itemId, userID, "item has been deleted");// Refresh the combo box
                } else {
                    JOptionPane.showMessageDialog(this, "Item ID not found in the Items table!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error deleting item!");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Item is not deleted!");

        }


    }//GEN-LAST:event_DeleteButtonActionPerformed

    //go back to the manager
    private void goHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goHomeActionPerformed
        // TODO add your handling code here:
        dispose();
        ManagerDasboard m = new ManagerDasboard(UserRole,userID);
        m.setVisible(true);
    }//GEN-LAST:event_goHomeActionPerformed

    // Flag to track edit mode
    private boolean isEditMode = false;

    //edit item
    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int selectedIndex = selectItem.getSelectedIndex(); // Get selected index
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to edit!");
            return;
        }

        int selectedItemId = itemIds.get(selectedIndex); // Get ItemID for the selected item

        if (!isEditMode) {
            // Enter edit mode
            loadItemDetails(selectedItemId); // Load details for editing
            isEditMode = true;
            EditButton.setText("Confirm Edit"); // Change button text to indicate confirmation
            ConfirmButton.setEnabled(false); // Disable Confirm button
            DeleteButton.setEnabled(false); // Disable Delete button
            selectItem.setEnabled(false); // Disable the selectItem combo box
        } else {
            // Confirm the edit
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to save changes?", "Confirm Edit", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Update the item in the database
                String itemName = productName.getText();
                
                
                 // Check if the item name is unique
        if (!isItemNameUnique(itemName, -1)) {
            JOptionPane.showMessageDialog(this, "An item with this name already exists! Please choose a different name.");
            return;
        }
                
                
                
                int price = Integer.parseInt(SellingPrice.getText());
                String warranty = WarrantyFLD.getText();
                int conditionIdValue = conditionIds.get(conditionId.getSelectedIndex()); // Get selected ConditionID
                int categoryIdValue = categoryIds.get(categoryId.getSelectedIndex()); // Get selected CategoryID

                String updateQuery = "UPDATE Items SET ItemName = ?, Price = ?, Warranty = ?, ConditionID = ?, CategoryID = ? WHERE ItemID = ?";
                try (PreparedStatement statement = con.prepareStatement(updateQuery)) {
                    statement.setString(1, itemName);
                    statement.setInt(2, price);
                    statement.setString(3, warranty);
                    statement.setInt(4, conditionIdValue);
                    statement.setInt(5, categoryIdValue);
                    statement.setInt(6, selectedItemId);

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Item updated successfully!");
                        createReport(20, selectedItemId,userID, "Item edited");
                        populateItemComboBox(); // Refresh the combo box
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to update the item!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Error updating item in the database!");
                }

            }
            // Exit edit mode
            isEditMode = false;
            EditButton.setText("Edit"); // Reset button text
            ConfirmButton.setEnabled(true); // Enable Confirm button
            DeleteButton.setEnabled(true); // Enable Delete button
            selectItem.setEnabled(true); // Re-enable the selectItem combo box
            clearFields();
        }


    }//GEN-LAST:event_EditButtonActionPerformed

    private void goHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goHome1ActionPerformed

        
        CategoryManager m = new CategoryManager();
        m.setVisible(true);
        

        // TODO add your handling code here:
    }//GEN-LAST:event_goHome1ActionPerformed

    private void goHome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goHome2ActionPerformed


ConditionManager m = new ConditionManager();
m.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_goHome2ActionPerformed

    //check on the form data


    //check the type
    private boolean containsNumber(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    //load item's data into the form
    private void loadItemDetails(int itemId) {
        String query = "SELECT ItemName, Price, Warranty, ConditionID, CategoryID FROM Items WHERE ItemID = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, itemId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String itemName = resultSet.getString("ItemName");
                    int price = resultSet.getInt("Price");
                    String warranty = resultSet.getString("Warranty");
                    int conditionIdValue = resultSet.getInt("ConditionID");
                    int categoryIdValue = resultSet.getInt("CategoryID");

                    // Populate fields
                    productName.setText(itemName);
                    SellingPrice.setText(String.valueOf(price));
                    WarrantyFLD.setText(warranty);

                    // Set combo box selections
                    conditionId.setSelectedIndex(conditionIds.indexOf(conditionIdValue));
                    categoryId.setSelectedIndex(categoryIds.indexOf(categoryIdValue));

                    // Disable delete and confirm buttons
                    ConfirmButton.setEnabled(false);
                    DeleteButton.setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading item details!");
        }
    }
    
    
       //check item uniqueness
    private boolean isItemNameUnique(String itemName, int excludedItemId) {
        String query = "SELECT COUNT(*) AS Count FROM Items WHERE ItemName = ? AND ItemID != ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, itemName);
            stmt.setInt(2, excludedItemId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Count") == 0; // True if no duplicates found
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error checking item uniqueness!");
        }
        return false; // Assume not unique if an error occurs

    }

    //check if item is in the table
    private boolean isItemInTable(int itemId, String tableName) {
        String query = "SELECT COUNT(*) AS Count FROM " + tableName + " WHERE ItemID = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, itemId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("Count") > 0; // Return true if the count is greater than 0
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, "Error checking table: " + tableName, ex);
        }
        return false; // Return false if an exception occurs or no rows are found
    }

    private ArrayList<Integer> conditionIds = new ArrayList<>();
    private ArrayList<Integer> categoryIds = new ArrayList<>();
    private ArrayList<Integer> itemIds = new ArrayList<>();

    //get the data and linke them to the arraylist
    private void populateComboBoxWithIds(String query, javax.swing.JComboBox<String> comboBox, ArrayList<Integer> idList, String columnName) {
        comboBox.removeAllItems(); // Clear the combo box
        idList.clear(); // Clear the ID list

        try (PreparedStatement statement = con.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID"); // ID column (e.g., CategoryID, ConditionID)
                String name = resultSet.getString(columnName); // Name column (e.g., CategoryName, ConditionName)

                idList.add(id); // Store the ID in the ArrayList
                comboBox.addItem(name); // Add the name to the combo box
            }
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error populating combo box!");
        }
    }

    //show condition
    private void populateConditionComboBox() {
        String query = "SELECT ConditionID AS ID, ConditionName FROM Conditions";
        populateComboBoxWithIds(query, conditionId, conditionIds, "ConditionName");
    }

    //show category
    private void populateCategoryComboBox() {
        String query = "SELECT CategoryID AS ID, CategoryName FROM Categories";
        populateComboBoxWithIds(query, categoryId, categoryIds, "CategoryName");
    }

    //clear the text fields:
    private void clearFields() {
        productName.setText(""); // Clear product name
        SellingPrice.setText(""); // Clear selling price
        WarrantyFLD.setText(""); // Clear warranty field
    }

    //show items
    private void populateItemComboBox() {
        String query = "SELECT ItemID AS ID, ItemName FROM Items";
        populateComboBoxWithIds(query, selectItem, itemIds, "ItemName");
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

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Items s = new Items();
                s.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField SellingPrice;
    private javax.swing.JTextField WarrantyFLD;
    private javax.swing.JComboBox<String> categoryId;
    private javax.swing.JComboBox<String> conditionId;
    private javax.swing.JButton goHome;
    private javax.swing.JButton goHome1;
    private javax.swing.JButton goHome2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField productName;
    private javax.swing.JComboBox<String> selectItem;
    // End of variables declaration//GEN-END:variables
}
