
package Administrator;
import FirstPage.OpenPage;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane; 

public class Transactions extends javax.swing.JFrame {

    public Transactions() {
        initComponents();
        Connect();
    }
    Connection conn;
    PreparedStatement pat;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/shamsdemo","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
 private boolean validateInputs(String vehicleNo, String type, String employeeId, String buyerName, String buyerPhone,  String sellerName) {
        boolean isValid = true;
        if (vehicleNo.isEmpty() || type.isEmpty() || employeeId.isEmpty() || buyerName.isEmpty() || buyerPhone.isEmpty() || sellerName.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }



private int insertBuyerDetails(String regno, String buyerName, String buyerPhone) throws SQLException {
    String insertQuery = "INSERT INTO BUYER (VEHICLE_ID, NAME, PHONE) VALUES (?, ?, ?)";
    try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
        insertStmt.setString(1, regno);
        insertStmt.setString(2, buyerName);
        insertStmt.setString(3, buyerPhone);
        
        // Execute the insertion query
        insertStmt.executeUpdate();
        
        // Retrieve the auto-generated BUYER_ID
        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve auto-generated BUYER_ID");
            }
        }
    }
}



private void insertTransactionDetails(String employeeId, String buyerName, String sellerName, String regno, String transactionDate, double transactionPrice) throws SQLException {
    // Assuming that transaction price is included in the query
    String insertQuery = "INSERT INTO TRANSACTION (EMPLOYEE_ID, BUYER_ID, SELLER_ID, VEHICLE_ID, TRANSACTION_DATE, TRANSACTION_PRICE) VALUES (?, (SELECT BUYER_ID FROM BUYER WHERE NAME = ?), (SELECT RESELLER_ID FROM RESELLER WHERE NAME = ?), ?, ?, ?)";
    try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
        insertStmt.setString(1, employeeId);
        insertStmt.setString(2, buyerName); 
        insertStmt.setString(3, sellerName);
        insertStmt.setString(4, regno);
        insertStmt.setString(5, transactionDate);
        insertStmt.setDouble(6, transactionPrice); 
        
        insertStmt.executeUpdate();
        
        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int transactionId = generatedKeys.getInt(1);
                System.out.println("Inserted transaction with ID: " + transactionId);
                
                updateVehicleAfterTransaction(regno, transactionId);
            } else {
                throw new SQLException("Failed to retrieve auto-generated TRANSACTION_ID");
            }
        }
    } catch (SQLException ex) {
        // Print the SQL error message for debugging
        ex.printStackTrace();
        throw ex; // Rethrow the exception to handle it in the calling code
    }
}


private void updateVehicleAfterTransaction(String regno, int transactionId) throws SQLException {
    String updateQuery = "UPDATE VEHICLE SET TRANSACTION_ID = ?, STATUS = 'SOLD' WHERE VEHICLE_ID = ?";
    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
        updateStmt.setInt(1, transactionId);
        updateStmt.setString(2, regno);
        updateStmt.executeUpdate();
    }
}
private double getSellingPrice(String regno) throws SQLException {
    String getPriceQuery = "SELECT SELLING_PRICE FROM VEHICLE WHERE VEHICLE_ID = ?";
    try (PreparedStatement getPriceStmt = conn.prepareStatement(getPriceQuery)) {
        getPriceStmt.setString(1, regno);
        ResultSet rs = getPriceStmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("SELLING_PRICE");
        } else {
            throw new SQLException("Vehicle not found or no selling price available.");
        }
    }
}

private double getPurchasePrice(String regno) throws SQLException {
    String getPriceQuery = "SELECT PURCHASE_PRICE FROM VEHICLE WHERE VEHICLE_ID = ?";
    try (PreparedStatement getPriceStmt = conn.prepareStatement(getPriceQuery)) {
        getPriceStmt.setString(1,regno);
        ResultSet rs = getPriceStmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("PURCHASE_PRICE");
        } else {
            throw new SQLException("Vehicle not found or no purchase price available.");
        }
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        typeselect = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Vehicleno = new javax.swing.JTextField();
        buyeraname = new javax.swing.JTextField();
        buyerphone = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        employeeid = new javax.swing.JTextField();
        sellername = new javax.swing.JTextField();
        BuyButton = new javax.swing.JButton();
        getsel = new javax.swing.JButton();
        getprice = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        CurrentVehicle = new javax.swing.JLabel();
        BuyVehicle = new javax.swing.JLabel();
        Services = new javax.swing.JLabel();
        Staff = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        warehouse = new javax.swing.JLabel();
        client = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Current Vehicle");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buy Vehicle");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel2.setText("Type of vehicle");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 126, -1));

        typeselect.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeselect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bike", "Car", "Scooter", "Truck" }));
        typeselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeselectActionPerformed(evt);
            }
        });
        jPanel6.add(typeselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 88, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel4.setText("Buyer name");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel5.setText("Buyer Phone No.");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel6.setText("Date");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        Price.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        Price.setText("Price");
        jPanel6.add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 477, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel10.setText("Vehicle No");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 221, 97, -1));

        Vehicleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiclenoActionPerformed(evt);
            }
        });
        jPanel6.add(Vehicleno, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 216, 203, 33));

        buyeraname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyeranameActionPerformed(evt);
            }
        });
        jPanel6.add(buyeraname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 203, 33));

        buyerphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyerphoneActionPerformed(evt);
            }
        });
        jPanel6.add(buyerphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 203, 33));

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel6.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 421, 203, 33));

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel6.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 472, 203, 33));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel11.setText("Employee ID");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 528, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel12.setText("Seller Name");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 579, -1, -1));

        employeeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeidActionPerformed(evt);
            }
        });
        jPanel6.add(employeeid, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 523, 203, 33));

        sellername.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sellername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellernameActionPerformed(evt);
            }
        });
        jPanel6.add(sellername, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 574, 203, 33));

        BuyButton.setBackground(new java.awt.Color(0, 0, 0));
        BuyButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BuyButton.setForeground(new java.awt.Color(255, 255, 255));
        BuyButton.setText("Buy");
        BuyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyButtonActionPerformed(evt);
            }
        });
        jPanel6.add(BuyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 636, 86, 36));

        getsel.setBackground(new java.awt.Color(0, 0, 0));
        getsel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getsel.setForeground(new java.awt.Color(255, 255, 255));
        getsel.setText("Get");
        getsel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getselMouseClicked(evt);
            }
        });
        getsel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getselActionPerformed(evt);
            }
        });
        jPanel6.add(getsel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 70, 30));

        getprice.setBackground(new java.awt.Color(0, 0, 0));
        getprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getprice.setForeground(new java.awt.Color(255, 255, 255));
        getprice.setText("Get");
        getprice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getpriceMouseClicked(evt);
            }
        });
        getprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getpriceActionPerformed(evt);
            }
        });
        jPanel6.add(getprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 470, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BGN2.jpg"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 860, 740));

        Dashboard.setBackground(new java.awt.Color(0, 0, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Welcome!");

        Home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Home.setForeground(new java.awt.Color(255, 255, 255));
        Home.setText("Home");
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });

        CurrentVehicle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CurrentVehicle.setForeground(new java.awt.Color(255, 255, 255));
        CurrentVehicle.setText("Vehicle");
        CurrentVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CurrentVehicleMouseClicked(evt);
            }
        });

        BuyVehicle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BuyVehicle.setForeground(new java.awt.Color(255, 255, 255));
        BuyVehicle.setText("Transaction");
        BuyVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuyVehicleMouseClicked(evt);
            }
        });

        Services.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Services.setForeground(new java.awt.Color(255, 255, 255));
        Services.setText("Services");
        Services.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ServicesMouseClicked(evt);
            }
        });

        Staff.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Staff.setForeground(new java.awt.Color(255, 255, 255));
        Staff.setText("Staff");
        Staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StaffMouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ID.png"))); // NOI18N

        warehouse.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        warehouse.setForeground(new java.awt.Color(255, 255, 255));
        warehouse.setText("Warehouse");
        warehouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                warehouseMouseClicked(evt);
            }
        });

        client.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        client.setForeground(new java.awt.Color(255, 255, 255));
        client.setText("Client");
        client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signout.png"))); // NOI18N
        jLabel15.setText("Sign Out");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentVehicle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DashboardLayout.createSequentialGroup()
                                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BuyVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Services, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Staff, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(45, 45, 45)
                .addComponent(Home)
                .addGap(49, 49, 49)
                .addComponent(CurrentVehicle)
                .addGap(47, 47, 47)
                .addComponent(BuyVehicle)
                .addGap(41, 41, 41)
                .addComponent(Services)
                .addGap(38, 38, 38)
                .addComponent(warehouse)
                .addGap(45, 45, 45)
                .addComponent(client)
                .addGap(34, 34, 34)
                .addComponent(Staff)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VehiclenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiclenoActionPerformed
        // TODO add your handling code here:
        Vehicle currentVehicleFrame = new Vehicle();
        currentVehicleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_VehiclenoActionPerformed

    private void buyeranameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyeranameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyeranameActionPerformed

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
        
    try {
        String regno = Vehicleno.getText(); 
        String vehicleType = typeselect.getSelectedItem().toString();
        String employeeId = employeeid.getText();
        String buyerName = buyeraname.getText();
        String buyerPhone = buyerphone.getText();
        String sellerName = sellername.getText();
        String transactionDate = date.getText();

        if (validateInputs(regno, vehicleType, employeeId, buyerName, buyerPhone, sellerName)) {
            double sellingPrice = getSellingPrice(regno);
            double purchasePrice = getPurchasePrice(regno);
            double transactionPrice = sellingPrice - purchasePrice;
            
            insertBuyerDetails(regno, buyerName, buyerPhone);

            insertTransactionDetails(employeeId, buyerName, sellerName, regno, transactionDate, transactionPrice);

            JOptionPane.showMessageDialog(this, "Purchase successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all required fields.");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }


    }//GEN-LAST:event_BuyButtonActionPerformed

    private void typeselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeselectActionPerformed
        // TODO add your handling code here:

                                            
    }//GEN-LAST:event_typeselectActionPerformed

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        // TODO add your handling code here:
        Home homeFrame = new Home();
        homeFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_HomeMouseClicked

    private void CurrentVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentVehicleMouseClicked
        // TODO add your handling code here:
        Vehicle currentVehicleFrame = new Vehicle();
        currentVehicleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_CurrentVehicleMouseClicked

    private void BuyVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuyVehicleMouseClicked
        // TODO add your handling code here:
        Transactions buyvehicleframe=new Transactions();
        buyvehicleframe.setVisible(true);
        dispose();
    }//GEN-LAST:event_BuyVehicleMouseClicked

    private void ServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServicesMouseClicked
        // TODO add your handling code here:
        Services servicesFrame = new Services();
        servicesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_ServicesMouseClicked

    private void StaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StaffMouseClicked
        // TODO add your handling code here:
        Staff employeesFrame = new Staff();
        employeesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_StaffMouseClicked

    private void warehouseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warehouseMouseClicked
        // TODO add your handling code here:
        Warehouse WarehouseFrame = new Warehouse();
        WarehouseFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_warehouseMouseClicked

    private void clientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientMouseClicked
        // TODO add your handling code here:
        Client CustomerFrame = new Client();
        CustomerFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_clientMouseClicked

    private void getselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getselActionPerformed


    }//GEN-LAST:event_getselActionPerformed

    private void getselMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getselMouseClicked
        // TODO add your handling code here:
          try {
        String regno =Vehicleno.getText();
        String getNameQuery = "SELECT NAME FROM RESELLER WHERE VEHICLE_ID = ?";
        try (PreparedStatement getNameStmt = conn.prepareStatement(getNameQuery)) {
            getNameStmt.setString(1, regno);
            ResultSet rs = getNameStmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("NAME");
                // Assuming you have a field named "resellerName" where you want to display the name
                sellername.setText(name);
            } else {
                JOptionPane.showMessageDialog(this, "Vehicle not found or no reseller available.", "Reseller Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid vehicle number format. Please enter a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error retrieving reseller name.", "Reseller Error", JOptionPane.ERROR_MESSAGE);
    }
       
    }//GEN-LAST:event_getselMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        OpenPage open=new OpenPage();
        open.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void getpriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getpriceMouseClicked
        // TODO add your handling code here:
         try {
        String regno =Vehicleno.getText();
        String getPriceQuery = "SELECT SELLING_PRICE FROM VEHICLE WHERE VEHICLE_ID = ?";
        try (PreparedStatement getPriceStmt = conn.prepareStatement(getPriceQuery)) {
            getPriceStmt.setString(1, regno);
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
        Logger.getLogger(Transactions.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error retrieving price.", "Price Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_getpriceMouseClicked

    private void getpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getpriceActionPerformed
     

        // Your GUI components layout code
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuyButton;
    private javax.swing.JLabel BuyVehicle;
    private javax.swing.JLabel CurrentVehicle;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Services;
    private javax.swing.JLabel Staff;
    private javax.swing.JTextField Vehicleno;
    private javax.swing.JTextField buyeraname;
    private javax.swing.JTextField buyerphone;
    private javax.swing.JLabel client;
    private javax.swing.JTextField date;
    private javax.swing.JTextField employeeid;
    private javax.swing.JButton getprice;
    private javax.swing.JButton getsel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField price;
    private javax.swing.JTextField sellername;
    private javax.swing.JComboBox<String> typeselect;
    private javax.swing.JLabel warehouse;
    // End of variables declaration//GEN-END:variables
}
