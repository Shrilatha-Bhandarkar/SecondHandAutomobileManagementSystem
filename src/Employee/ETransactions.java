/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Employee;
import FirstPage.OpenPage;
import Administrator.Register;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane; 
public class ETransactions extends javax.swing.JFrame {

    public ETransactions() {
        initComponents();
        Connect();
    }
    Connection conn;
    PreparedStatement pat;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/shams","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
 private boolean validateInputs(String vehicleNo, String type, String employeeId, String buyerName, String buyerAddress, String buyerPhone, String buyerEmail, String sellerName) {
        boolean isValid = true;
        if (vehicleNo.isEmpty() || type.isEmpty() || employeeId.isEmpty() || buyerName.isEmpty() || buyerPhone.isEmpty() || sellerName.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }



private void insertBuyerDetails(int vehicleId,int buyerId, String buyerName, String buyerPhone) throws SQLException {
    String insertQuery = "INSERT INTO BUYER (BUYER_ID,VEHICLE_ID, NAME, PHONE) VALUES (?,?, ?, ?)";
    try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
        insertStmt.setInt(1, buyerId);
        insertStmt.setInt(2, vehicleId);
        insertStmt.setString(3, buyerName);
        insertStmt.setString(4, buyerPhone);
        insertStmt.executeUpdate();
    }
}

private void insertTransactionDetails(String employeeId, int buyerId, String sellerName, int vehicleId, String transactionDate) throws SQLException {
    // Assuming that transaction price will be calculated by the trigger, so it's not included in the query
    String insertQuery = "INSERT INTO TRANSACTION (EMPLOYEE_ID, BUYER_ID, SELLER_ID, VEHICLE_ID, TRANSACTION_DATE) VALUES (?, ?, (SELECT RESELLER_ID FROM RESELLER WHERE NAME = ?), ?, ?)";
    try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
        insertStmt.setString(1, employeeId);
        insertStmt.setInt(2, buyerId);
        insertStmt.setString(3, sellerName);
        insertStmt.setInt(4, vehicleId);
        insertStmt.setString(5, transactionDate);
        
        // Execute the insertion query
        insertStmt.executeUpdate();
        
        // Retrieve the auto-generated TRANSACTION_ID
        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int transactionId = generatedKeys.getInt(1);
                System.out.println("Inserted transaction with ID: " + transactionId);
                
                // Update the VEHICLE table with TRANSACTION_ID and ensure TRANSACTION_PRICE is calculated
                updateVehicleAfterTransaction(vehicleId, transactionId);
            } else {
                throw new SQLException("Failed to retrieve auto-generated TRANSACTION_ID");
            }
        }
    }
}

private void updateVehicleAfterTransaction(int vehicleId, int transactionId) throws SQLException {
    String updateQuery = "UPDATE VEHICLE SET TRANSACTION_ID = ?, STATUS = 'SOLD' WHERE VEHICLE_ID = ?";
    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
        updateStmt.setInt(1, transactionId);
        updateStmt.setInt(2, vehicleId);
        updateStmt.executeUpdate();
    }
}

private void increaseTransactionCount(String employeeId) throws SQLException {
    String updateQuery = "UPDATE EMPLOYEE SET TRANSACTION_COUNT = TRANSACTION_COUNT + 1 WHERE EMPLOYEE_ID = ?";
    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
        updateStmt.setString(1, employeeId);
        updateStmt.executeUpdate();
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        typeselect = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Vehicleno = new javax.swing.JTextField();
        buyeraname = new javax.swing.JTextField();
        buyerid = new javax.swing.JTextField();
        buyerphone = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        employeeid = new javax.swing.JTextField();
        sellername = new javax.swing.JTextField();
        BuyButton = new javax.swing.JButton();
        get = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Dashboard1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Home1 = new javax.swing.JLabel();
        CurrentVehicle1 = new javax.swing.JLabel();
        BuyVehicle1 = new javax.swing.JLabel();
        Services1 = new javax.swing.JLabel();
        Warehouse1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        client1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Buy Vehicle");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Type of vehicle");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 127, 126, -1));

        typeselect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bike", "Car", "Scooter", "Truck" }));
        typeselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeselectActionPerformed(evt);
            }
        });
        jPanel6.add(typeselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 123, 88, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Buyer ID");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 236, 97, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Buyer name");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 288, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Buyer Phone No.");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 339, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Date");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 390, -1, -1));

        Price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Price.setText("Price");
        jPanel6.add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 442, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Vehicle No");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 185, 97, -1));

        Vehicleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiclenoActionPerformed(evt);
            }
        });
        jPanel6.add(Vehicleno, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 180, 203, 33));

        buyeraname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyeranameActionPerformed(evt);
            }
        });
        jPanel6.add(buyeraname, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 283, 203, 33));

        buyerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyeridActionPerformed(evt);
            }
        });
        jPanel6.add(buyerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 231, 203, 33));

        buyerphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyerphoneActionPerformed(evt);
            }
        });
        jPanel6.add(buyerphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 334, 203, 33));

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel6.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 385, 203, 33));

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel6.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 437, 203, 33));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Employee ID");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 493, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Seller Name");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 544, -1, -1));

        employeeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeidActionPerformed(evt);
            }
        });
        jPanel6.add(employeeid, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 488, 203, 33));

        sellername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellernameActionPerformed(evt);
            }
        });
        jPanel6.add(sellername, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 539, 203, 33));

        BuyButton.setBackground(new java.awt.Color(0, 0, 0));
        BuyButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BuyButton.setForeground(new java.awt.Color(255, 255, 255));
        BuyButton.setText("Buy");
        BuyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyButtonActionPerformed(evt);
            }
        });
        jPanel6.add(BuyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 601, 86, 36));

        get.setBackground(new java.awt.Color(0, 0, 0));
        get.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        get.setForeground(new java.awt.Color(255, 255, 255));
        get.setText("Get");
        get.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getMouseClicked(evt);
            }
        });
        get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getActionPerformed(evt);
            }
        });
        jPanel6.add(get, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 436, -1, 33));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BGN2.jpg"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 710));

        Dashboard1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Welcome!");

        Home1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Home1.setForeground(new java.awt.Color(255, 255, 255));
        Home1.setText("Home");
        Home1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home1MouseClicked(evt);
            }
        });

        CurrentVehicle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CurrentVehicle1.setForeground(new java.awt.Color(255, 255, 255));
        CurrentVehicle1.setText("Vehicle");
        CurrentVehicle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CurrentVehicle1MouseClicked(evt);
            }
        });

        BuyVehicle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BuyVehicle1.setForeground(new java.awt.Color(255, 255, 255));
        BuyVehicle1.setText("Transaction");
        BuyVehicle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuyVehicle1MouseClicked(evt);
            }
        });

        Services1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Services1.setForeground(new java.awt.Color(255, 255, 255));
        Services1.setText("Services");
        Services1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Services1MouseClicked(evt);
            }
        });

        Warehouse1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Warehouse1.setForeground(new java.awt.Color(255, 255, 255));
        Warehouse1.setText("Warehouse");
        Warehouse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Warehouse1MouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ID.png"))); // NOI18N

        client1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        client1.setForeground(new java.awt.Color(255, 255, 255));
        client1.setText("Client");
        client1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                client1MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signout.png"))); // NOI18N
        jLabel21.setText("Sign Out");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Dashboard1Layout = new javax.swing.GroupLayout(Dashboard1);
        Dashboard1.setLayout(Dashboard1Layout);
        Dashboard1Layout.setHorizontalGroup(
            Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard1Layout.createSequentialGroup()
                .addGroup(Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Dashboard1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentVehicle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Dashboard1Layout.createSequentialGroup()
                                .addGroup(Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BuyVehicle1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Services1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Warehouse1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Home1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(client1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(Dashboard1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addGroup(Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        Dashboard1Layout.setVerticalGroup(
            Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(45, 45, 45)
                .addComponent(Home1)
                .addGap(30, 30, 30)
                .addComponent(CurrentVehicle1)
                .addGap(49, 49, 49)
                .addComponent(BuyVehicle1)
                .addGap(50, 50, 50)
                .addComponent(Services1)
                .addGap(44, 44, 44)
                .addComponent(Warehouse1)
                .addGap(45, 45, 45)
                .addComponent(client1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeselectActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_typeselectActionPerformed

    private void VehiclenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiclenoActionPerformed
        // TODO add your handling code here:
        EVehicle currentVehicleFrame = new EVehicle();
        currentVehicleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_VehiclenoActionPerformed

    private void buyeranameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyeranameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyeranameActionPerformed

    private void buyeridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyeridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyeridActionPerformed

    private void buyerphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyerphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyerphoneActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void employeeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeidActionPerformed

    private void sellernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellernameActionPerformed

    private void BuyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyButtonActionPerformed
        // TODO add your handling code here:
        try {
            int vehicleNo = Integer.parseInt(Vehicleno.getText());
            int buyerId=Integer.parseInt(buyerid.getText());
            String vehicleType = typeselect.getSelectedItem().toString();
            String employeeId = employeeid.getText();
            String buyerName = buyeraname.getText();
            String buyerPhone = buyerphone.getText();
            String sellerName = sellername.getText();
            String transactionDate = date.getText();

            if (validateInputs(String.valueOf(vehicleNo), vehicleType, employeeId, buyerName, "", buyerPhone, "", sellerName)) {

                insertBuyerDetails(vehicleNo,buyerId, buyerName, buyerPhone);

                // Insert transaction details into the transaction table
                insertTransactionDetails(employeeId, buyerId, sellerName, vehicleNo, transactionDate);

                // Increase transaction_count in the employee table for the specific employee
                increaseTransactionCount(employeeId);

            } else {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_BuyButtonActionPerformed

    private void getMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getMouseClicked
        // TODO add your handling code here:
        try {
            int vehicleNo = Integer.parseInt(Vehicleno.getText());
            String getPriceQuery = "SELECT SELLING_PRICE FROM VEHICLE WHERE VEHICLE_ID = ?";
            try (PreparedStatement getPriceStmt = conn.prepareStatement(getPriceQuery)) {
                getPriceStmt.setInt(1, vehicleNo);
                ResultSet rs = getPriceStmt.executeQuery();

                if (rs.next()) {
                    double sellingPrice = rs.getDouble("SELLING_PRICE");
                    price.setText(String.valueOf(sellingPrice));
                } else {
                    JOptionPane.showMessageDialog(this, "Vehicle not found or no price available.", "Price Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid vehicle number format. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(ETransactions.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error retrieving price.", "Price Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_getMouseClicked

    private void getActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getActionPerformed
       

    }//GEN-LAST:event_getActionPerformed

    private void Home1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home1MouseClicked
        // TODO add your handling code here:
        EHome homeFrame = new EHome();
        homeFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Home1MouseClicked

    private void CurrentVehicle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentVehicle1MouseClicked
        // TODO add your handling code here:
        EVehicle currentVehicleFrame = new EVehicle();
        currentVehicleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_CurrentVehicle1MouseClicked

    private void BuyVehicle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuyVehicle1MouseClicked
        // TODO add your handling code here:
        ETransactions buyvehicleframe=new ETransactions();
        buyvehicleframe.setVisible(true);
        dispose();
    }//GEN-LAST:event_BuyVehicle1MouseClicked

    private void Services1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Services1MouseClicked
        // TODO add your handling code here:
        EServices servicesFrame = new EServices();
        servicesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Services1MouseClicked

    private void Warehouse1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Warehouse1MouseClicked
        // TODO add your handling code here:
        EWarehouse warehouseFrame = new EWarehouse();
        warehouseFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Warehouse1MouseClicked

    private void client1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client1MouseClicked
        // TODO add your handling code here:
        EClient clientFrame = new EClient();
        clientFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_client1MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        OpenPage open=new OpenPage();
        open.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ETransactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuyButton;
    private javax.swing.JLabel BuyVehicle1;
    private javax.swing.JLabel CurrentVehicle1;
    private javax.swing.JPanel Dashboard1;
    private javax.swing.JLabel Home1;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Services1;
    private javax.swing.JTextField Vehicleno;
    private javax.swing.JLabel Warehouse1;
    private javax.swing.JTextField buyeraname;
    private javax.swing.JTextField buyerid;
    private javax.swing.JTextField buyerphone;
    private javax.swing.JLabel client1;
    private javax.swing.JTextField date;
    private javax.swing.JTextField employeeid;
    private javax.swing.JButton get;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField price;
    private javax.swing.JTextField sellername;
    private javax.swing.JComboBox<String> typeselect;
    // End of variables declaration//GEN-END:variables
}
