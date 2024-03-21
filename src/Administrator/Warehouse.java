
package Administrator;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import FirstPage.OpenPage;
public class Warehouse extends javax.swing.JFrame {

    
    public Warehouse() {
        initComponents();
        Connect();
        loadWarehouseDetails();
        Warehousetable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = Warehousetable.getSelectedRow();
                if (selectedRow != -1) {
                    displaySelectedWarehouse();
                }
            }
        });
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
    
    
    private void loadWarehouseDetails() {
    try {
        String query = "SELECT w.WAREHOUSE_ID, w.NAME, w.LOCATION, w.CAPACITY, COUNT(v.VEHICLE_ID) AS TOTAL " +
                       "FROM WAREHOUSE w " +
                       "LEFT JOIN VEHICLE v ON w.WAREHOUSE_ID = v.WAREHOUSE_ID AND V.STATUS='AVAILABLE'" +
                       "GROUP BY w.WAREHOUSE_ID, w.NAME, w.LOCATION, w.CAPACITY";
        pat = conn.prepareStatement(query);
        rs = pat.executeQuery();

        DefaultTableModel model = (DefaultTableModel) Warehousetable.getModel();
        model.setRowCount(0); // Clear existing data

        while (rs.next()) {
            // Add data to the table model
            model.addRow(new Object[]{rs.getInt("WAREHOUSE_ID"), rs.getString("NAME"), rs.getString("LOCATION"), rs.getInt("CAPACITY"), rs.getInt("TOTAL")});
        }
    } catch (SQLException ex) {
        Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    private void displaySelectedWarehouse() {
        int selectedRow = Warehousetable.getSelectedRow();
        if (selectedRow != -1) {
            warehouseid.setText(Warehousetable.getValueAt(selectedRow, 0).toString());
            name.setText(Warehousetable.getValueAt(selectedRow, 1).toString());
            location.setText(Warehousetable.getValueAt(selectedRow, 2).toString());
            capacity.setText(Warehousetable.getValueAt(selectedRow,3).toString());
        }
    }



    private void loadVehicleDetails(int warehouseId) {
        try {
            String query = "SELECT * FROM VEHICLE WHERE WAREHOUSE_ID = ? AND STATUS='AVAILABLE'";
            pat = conn.prepareStatement(query);
            pat.setInt(1, warehouseId);
            rs = pat.executeQuery();

            DefaultTableModel model = (DefaultTableModel) vehciletable.getModel();
            model.setRowCount(0); // Clear existing data

            while (rs.next()) {
                // Add data to the table model
                model.addRow(new Object[]{rs.getInt("VIN"), rs.getString("VEHICLE_ID"), rs.getString("company"), rs.getInt("YEAR")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void clearFields() {
        location.setText("");
        name.setText("");
        capacity.setText("");
        warehouseid.setText("");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        CurrentVehicle = new javax.swing.JLabel();
        BuyVehicle = new javax.swing.JLabel();
        Services = new javax.swing.JLabel();
        Staff = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        warehouse = new javax.swing.JLabel();
        client = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Warehousetable = new javax.swing.JTable();
        Insert = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Knowmore = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vehciletable = new javax.swing.JTable();
        location = new javax.swing.JTextField();
        capacity = new javax.swing.JTextField();
        warehouseid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        Dashboard.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome!");

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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ID.png"))); // NOI18N

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

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signout.png"))); // NOI18N
        jLabel21.setText("Sign Out");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
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
                                .addGap(0, 48, Short.MAX_VALUE))))
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Staff, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(Home)
                .addGap(39, 39, 39)
                .addComponent(CurrentVehicle)
                .addGap(49, 49, 49)
                .addComponent(BuyVehicle)
                .addGap(40, 40, 40)
                .addComponent(Services)
                .addGap(39, 39, 39)
                .addComponent(warehouse)
                .addGap(45, 45, 45)
                .addComponent(client)
                .addGap(29, 29, 29)
                .addComponent(Staff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Warehouse");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 142, 49));

        Warehousetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Warehouse ID", "Name", "Location", "Capacity", "Total "
            }
        ));
        jScrollPane1.setViewportView(Warehousetable);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 55, 609, 313));

        Insert.setBackground(new java.awt.Color(0, 0, 0));
        Insert.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Insert.setForeground(new java.awt.Color(255, 255, 255));
        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });
        jPanel6.add(Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, -1, 29));

        Update.setBackground(new java.awt.Color(0, 0, 0));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel6.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, -1, 29));

        Clear.setBackground(new java.awt.Color(0, 0, 0));
        Clear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });
        jPanel6.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, -1, 28));

        Knowmore.setBackground(new java.awt.Color(0, 0, 0));
        Knowmore.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Knowmore.setForeground(new java.awt.Color(255, 255, 255));
        Knowmore.setText("Know more");
        Knowmore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KnowmoreMouseClicked(evt);
            }
        });
        Knowmore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KnowmoreActionPerformed(evt);
            }
        });
        jPanel6.add(Knowmore, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 99, 33));

        vehciletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vehicle ID", "Reg No", "Company", "Year"
            }
        ));
        jScrollPane2.setViewportView(vehciletable);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 386, 860, 263));
        jPanel6.add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 157, 118, 30));
        jPanel6.add(capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 205, 118, 30));
        jPanel6.add(warehouseid, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 55, 118, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("ID");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 59, 30, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Location");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 161, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Capacity");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 209, -1, -1));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel6.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 103, 118, 29));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Name");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 106, -1, -1));

        delete.setBackground(new java.awt.Color(0, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel6.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, 30));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BGN2.jpg"))); // NOI18N
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 650));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:
         try {
        String query = "INSERT INTO WAREHOUSE (WAREHOUSE_ID,NAME,LOCATION, CAPACITY) VALUES (?,?,?,?)";
        pat = conn.prepareStatement(query);
        pat.setInt(1, Integer.parseInt(warehouseid.getText()));
        pat.setString(2, name.getText());
        pat.setString(3, location.getText());
        pat.setInt(4, Integer.parseInt(capacity.getText()));

        int insertedRows = pat.executeUpdate();
        if (insertedRows > 0) {
            JOptionPane.showMessageDialog(this, "Warehouse inserted successfully.");
            loadWarehouseDetails(); // Refresh table data
            clearFields(); // Clear input fields
        } else {
            JOptionPane.showMessageDialog(this, "Failed to insert warehouse.");
        }
    } catch (SQLException | NumberFormatException ex) {
        Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_InsertActionPerformed

    private void KnowmoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KnowmoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_KnowmoreMouseClicked

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        // TODO add your handling code here:
         int selectedRow = Warehousetable.getSelectedRow();
    if (selectedRow != -1) {
        try {
            String query = "UPDATE WAREHOUSE SET LOCATION = ?,NAME=?, CAPACITY = ? WHERE WAREHOUSE_ID = ?";
            pat = conn.prepareStatement(query);

            pat.setString(1, location.getText());
            pat.setString(2, name.getText());
            pat.setInt(3, Integer.parseInt(capacity.getText()));
            pat.setInt(4, Integer.parseInt(warehouseid.getText()));

            int updatedRows = pat.executeUpdate();
            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(this, "Warehouse updated successfully.");
                loadWarehouseDetails(); // Refresh table

                clearFields(); // Clear input fields
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update warehouse.");
                }
                } catch (SQLException | NumberFormatException ex) {
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_UpdateMouseClicked

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_ClearMouseClicked

    private void KnowmoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KnowmoreActionPerformed
        // TODO add your handling code here:
        int selectedRow = Warehousetable.getSelectedRow();
    if (selectedRow != -1) {
        int warehouseId = Integer.parseInt(Warehousetable.getValueAt(selectedRow, 0).toString());
        loadVehicleDetails(warehouseId);
    }
    }//GEN-LAST:event_KnowmoreActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        OpenPage open=new OpenPage();
        open.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        int selectedRow = Warehousetable.getSelectedRow();
    if (selectedRow != -1) {
        int confirmDelete = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this warehouse?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirmDelete == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM WAREHOUSE WHERE WAREHOUSE_ID = ?";
                pat = conn.prepareStatement(query);
                int warehouseId = Integer.parseInt(Warehousetable.getValueAt(selectedRow, 0).toString());
                pat.setInt(1, warehouseId);

                int deletedRows = pat.executeUpdate();
                if (deletedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Warehouse deleted successfully.");
                    loadWarehouseDetails(); // Refresh table
                    clearFields(); // Clear input fields
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete warehouse.");
                }
            } catch (SQLException | NumberFormatException ex) {
                Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a warehouse to delete.");
    }
        
    }//GEN-LAST:event_deleteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Warehouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Warehouse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuyVehicle;
    private javax.swing.JButton Clear;
    private javax.swing.JLabel CurrentVehicle;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JLabel Home;
    private javax.swing.JButton Insert;
    private javax.swing.JButton Knowmore;
    private javax.swing.JLabel Services;
    private javax.swing.JLabel Staff;
    private javax.swing.JButton Update;
    private javax.swing.JTable Warehousetable;
    private javax.swing.JTextField capacity;
    private javax.swing.JLabel client;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField location;
    private javax.swing.JTextField name;
    private javax.swing.JTable vehciletable;
    private javax.swing.JLabel warehouse;
    private javax.swing.JTextField warehouseid;
    // End of variables declaration//GEN-END:variables
}
