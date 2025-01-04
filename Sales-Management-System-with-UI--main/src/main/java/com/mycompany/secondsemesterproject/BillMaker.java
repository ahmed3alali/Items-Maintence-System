/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.secondsemesterproject;

import com.mycompany.secondsemesterproject.ctest;
import java.awt.Color;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public class BillMaker extends javax.swing.JFrame {

    /**
     * Creates new form Requester
     */
    DefaultTableModel myTable = new DefaultTableModel();
    String cols[] = {"Customer Name", " Item Name", "Country", "Address", "quantity", "report ID", "item ID", "total", "date of purchase"};
    Connection con;

    private ArrayList<Integer> stockIds = new ArrayList<>();
    private ArrayList<Integer> countryIds = new ArrayList<>();

    //show stock items
    public void PopulateWithDatabase() {
        ProductWanted.removeAllItems(); // Clear the combo box
        stockIds.clear(); // Clear the ID list

//      String query = "SELECT ItemID AS ID, ItemName FROM Items";
        String query = "SELECT s.StockID AS ID, i.ItemName FROM Stock s JOIN Items i ON i.ItemID = s.ItemID";

        try (PreparedStatement statement = con.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID"); // ID column (e.g., CategoryID, ConditionID)
                String name = resultSet.getString("ItemName"); // Name column (e.g., CategoryName, ConditionName)

                stockIds.add(id); // Store the ID in the ArrayList
                ProductWanted.addItem(name); // Add the name to the combo box
            }
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error populating combo box!");
        }
    }

    //show countries
    public void PopulateCountryWithDatabase() {
        countries.removeAllItems(); // Clear the combo box
        countryIds.clear(); // Clear the ID list

        String query = "SELECT CountryID AS ID, CountryName FROM Countries";
        try (PreparedStatement statement = con.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID"); // ID column
                String name = resultSet.getString("CountryName"); // Name column

                countryIds.add(id); // Store the ID in the ArrayList
                countries.addItem(name); // Add the name to the combo box
            }
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error populating combo box!");
        }
    }
    
    
    
    public int userid;
    
    public int userrole;
    
      public BillMaker() {
      
      
              initComponents();
              
                this.setLocationRelativeTo(null);
        ctest cMngr = new ctest();
        
        
     

        try {
            con = cMngr.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BillMaker.class.getName()).log(Level.SEVERE, null, ex);
        }

        PopulateWithDatabase();
        PopulateCountryWithDatabase();
        jTable1.setModel(myTable);
        myTable.setColumnIdentifiers(cols);

        try {
            updateJTable();
        } catch (SQLException ex) {
            Logger.getLogger(BillMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        OnlyNumbersError.setVisible(false);

              
              
      }
    

    public BillMaker(int userid, int userrole) {

        initComponents();

        this.setLocationRelativeTo(null);
        ctest cMngr = new ctest();
        
        
        this.userid = userid;
        this.userrole = userrole;

        try {
            con = cMngr.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BillMaker.class.getName()).log(Level.SEVERE, null, ex);
        }

        PopulateWithDatabase();
        PopulateCountryWithDatabase();
        jTable1.setModel(myTable);
        myTable.setColumnIdentifiers(cols);

        try {
            updateJTable();
        } catch (SQLException ex) {
            Logger.getLogger(BillMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        OnlyNumbersError.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ProductWanted = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        OnlyNumbersError = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quantityfld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cust_name = new javax.swing.JTextField();
        countries = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        MakeBill1 = new javax.swing.JButton();
        MakeBill = new javax.swing.JButton();

        jLabel24.setText("jLabel20");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel4.setText("Customer Name");

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 45)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("New Bill");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(448, 448, 448)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(449, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        OnlyNumbersError.setForeground(new java.awt.Color(153, 0, 0));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel5.setText("Country");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel7.setText("Stock");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel8.setText("Address");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel9.setText("Quantity");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel10.setText("Phone Number");

        addressArea.setColumns(20);
        addressArea.setRows(5);
        jScrollPane2.setViewportView(addressArea);

        MakeBill1.setText("exit");
        MakeBill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeBill1ActionPerformed(evt);
            }
        });

        MakeBill.setText("Generate Bill");
        MakeBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(167, 167, 167)
                                        .addComponent(OnlyNumbersError))
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(countries, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ProductWanted, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(37, 37, 37)))))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityfld)
                            .addComponent(PhoneNumber))
                        .addGap(244, 244, 244))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MakeBill, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(617, Short.MAX_VALUE)
                    .addComponent(MakeBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(310, 310, 310)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ProductWanted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(quantityfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(countries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OnlyNumbersError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)))
                .addComponent(MakeBill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(243, 243, 243)
                    .addComponent(MakeBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(380, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //update the table
    private void updateJTable() throws SQLException {
        // Clear the current rows in the table
        myTable.setRowCount(0);

        // Call the stored procedure
        String query = "{CALL GetBillDetails}";

        try (PreparedStatement stmt = con.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Retrieve values from the result set
                String customerName = rs.getString("CustomerName");
                String itemName = rs.getString("ItemName");
                String countryName = rs.getString("CountryName");
                String address = rs.getString("Address");
                int quantity = rs.getInt("Quantity");
                int reportId = rs.getInt("ReportID");
                int itemId = rs.getInt("ItemID");
                double totalCost = rs.getDouble("TotalCost");
                Date dateOfPurchase = rs.getDate("DateOfPurchase");

                // Add the data as a new row in the table model
                myTable.addRow(new Object[]{
                    customerName,
                    itemName,
                    countryName,
                    address,
                    quantity,
                    reportId,
                    itemId,
                    totalCost,
                    dateOfPurchase
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillMaker.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error updating table data!");
        }
    }

    
        
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

    
    
    //create the bill
    private void MakeBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeBillActionPerformed
        // Validate inputs
        if (!validateFields()) {
            return;
        }

        // Confirm the action
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to create this bill?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Process the bill
            int stockId = stockIds.get(ProductWanted.getSelectedIndex());
            int quantity = Integer.parseInt(quantityfld.getText().trim());
            int countryId = countryIds.get(countries.getSelectedIndex());
            String locationId = createLocation(countryId); // Create location and get its ID
            int itemId = processStock(stockId, quantity); // Deduct stock and get ItemID
            if (itemId == 0) {
                JOptionPane.showMessageDialog(this, "There is not enough quantity in the stock!");
                return;
            }
            int billId = createBill(); // Create a new bill and get the BillID
            createBillDetails(itemId, quantity, locationId, billId); // Add to BillDetails

            // Feedback to user
            JOptionPane.showMessageDialog(this, "Bill created successfully!");
            createReport(7, itemId, userid, "bill has been generated");
            
            updateJTable();
            PopulateWithDatabase(); // Refresh combo box
        } catch (SQLException ex) {
            Logger.getLogger(BillMaker.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error creating bill!");
        }
    }//GEN-LAST:event_MakeBillActionPerformed

    private void MakeBill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeBill1ActionPerformed

        dispose();
        
        ManagerDasboard m = new ManagerDasboard(userrole, userid);
        
        m.setVisible(true);
       
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_MakeBill1ActionPerformed

    //validate the form fileds
    private boolean validateFields() {
        String customerName = cust_name.getText().trim();
        String phoneNumber = PhoneNumber.getText().trim();
        String quantityText = quantityfld.getText().trim();
        String address = addressArea.getText().trim();

        if (customerName.isEmpty() || phoneNumber.isEmpty() || quantityText.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return false;
        }

        if (!quantityText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity!");
            return false;
        }

        if (ProductWanted.getSelectedIndex() == -1 || countries.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product and country!");
            return false;
        }

        return true;
    }

    //create location
    private String createLocation(int countryId) throws SQLException {
        String address = addressArea.getText().trim();
        String locationQuery = "INSERT INTO Locations (LocationName, Address, CountryID) OUTPUT INSERTED.LocationID VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(locationQuery)) {
            stmt.setString(1, "Customer Address"); // A placeholder or dynamic name
            stmt.setString(2, address);
            stmt.setInt(3, countryId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("LocationID");
                } else {
                    throw new SQLException("Failed to create location!");
                }
            }
        }
    }

    //check on stock's quantity
    private int processStock(int stockId, int quantity) throws SQLException {
        String stockQuery = "SELECT Quantity, ItemID FROM Stock WHERE StockID = ?";
        int availableQuantity;
        int itemId;
        try (PreparedStatement stmt = con.prepareStatement(stockQuery)) {
            stmt.setInt(1, stockId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    availableQuantity = rs.getInt("Quantity");
                    itemId = rs.getInt("ItemID");
                    if (quantity > availableQuantity) {
                        return 0;
                    }
                } else {
                    throw new SQLException("Selected stock item not found!");
                }
            }
        }

        // Update or delete stock
        int remainingQuantity = availableQuantity - quantity;
        if (remainingQuantity > 0) {
            String updateStockQuery = "UPDATE Stock SET Quantity = ? WHERE StockID = ?";
            try (PreparedStatement stmt = con.prepareStatement(updateStockQuery)) {
                stmt.setInt(1, remainingQuantity);
                stmt.setInt(2, stockId);
                stmt.executeUpdate();
            }
        } else {
            String deleteStockQuery = "DELETE FROM Stock WHERE StockID = ?";
            try (PreparedStatement stmt = con.prepareStatement(deleteStockQuery)) {
                stmt.setInt(1, stockId);
                stmt.executeUpdate();
            }
            ProductWanted.removeItemAt(ProductWanted.getSelectedIndex()); // Remove from combo box
        }

        return itemId;
    }

    //craete bill's details
    private void createBillDetails(int itemId, int quantity, String locationId, int billId) throws SQLException {
        double totalCost = calculateTotalCost(itemId, quantity);
        String billDetailsQuery = "INSERT INTO BillDetails (BillID, CustomerName, CustomerContact, LocationID, ItemID, Quantity, TotalCost) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(billDetailsQuery)) {
            stmt.setInt(1, billId);
            stmt.setString(2, cust_name.getText().trim());
            stmt.setString(3, PhoneNumber.getText().trim());
            stmt.setString(4, locationId);
            stmt.setInt(5, itemId);
            stmt.setInt(6, quantity);
            stmt.setDouble(7, totalCost);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to create bill details!");
            }
        }
    }

    //create bill
    private int createBill() throws SQLException {
        String billQuery = "INSERT INTO Bills (Date) OUTPUT INSERTED.BillID VALUES (GETDATE())";
        try (PreparedStatement stmt = con.prepareStatement(billQuery)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("BillID");
                } else {
                    throw new SQLException("Failed to create bill!");
                }
            }
        }
    }

    //calculate the total cost
    private double calculateTotalCost(int itemId, int quantity) throws SQLException {
        String query = "SELECT Price FROM Items WHERE ItemID = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, itemId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("Price") * quantity;
                } else {
                    throw new SQLException("Item not found!");
                }
            }
        }
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
            java.util.logging.Logger.getLogger(BillMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillMaker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MakeBill;
    private javax.swing.JButton MakeBill1;
    private javax.swing.JLabel OnlyNumbersError;
    private javax.swing.JTextField PhoneNumber;
    private javax.swing.JComboBox<String> ProductWanted;
    private javax.swing.JTextArea addressArea;
    private javax.swing.JComboBox<String> countries;
    private javax.swing.JTextField cust_name;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField quantityfld;
    // End of variables declaration//GEN-END:variables
}
