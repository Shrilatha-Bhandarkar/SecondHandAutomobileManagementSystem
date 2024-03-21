
package Administrator;
import FirstPage.OpenPage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class ClientDetails extends javax.swing.JFrame {
    private String clientType; 

    public ClientDetails(String clientType) {
        initComponents();
        this.clientType= clientType;
        Connect();
        displayClientData(clientType);
        
        clienttable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = clienttable.getSelectedRow();
                    if (selectedRow != -1) { // If a row is selected
                        DefaultTableModel model = (DefaultTableModel) clienttable.getModel();
                        // Populate the text fields with the data of the selected row
                        clientid.setText(model.getValueAt(selectedRow, 0).toString());
                        name.setText(model.getValueAt(selectedRow, 1).toString());
                        phone.setText(model.getValueAt(selectedRow, 2).toString());
                        idortype.setText(model.getValueAt(selectedRow,3).toString());
                    }
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
    private void displayClientData(String clientType) {
    try {
        String query;
        switch (clientType) {
            case "Buyer":
                query = "SELECT Buyer_id, NAME, PHONE, VEHICLE_ID FROM buyer";
                break;
            case "Reseller":
                query = "SELECT reseller_id, NAME, PHONE, VEHICLE_ID FROM reseller";
                break;
            case "ServiceProviders":
                query = "SELECT SERVICE_PROVIDER_ID, NAME, PHONE, SERVICE_TYPE FROM service_provider";
                break;
            default:
                query = "";
                break;
        }
        pat = conn.prepareStatement(query);
        rs = pat.executeQuery();

        DefaultTableModel model = (DefaultTableModel) clienttable.getModel();
        model.setRowCount(0); // Clear existing rows

        while (rs.next()) {
            Object[] row = new Object[4]; // Assuming there are 4 columns in each table
            row[0] = rs.getObject(1); // Buyer_id or reseller_id
            row[1] = rs.getObject(2); // NAME
            row[2] = rs.getObject(3); // PHONE
            row[3] = rs.getObject(4); // VEHICLE_ID or SERVICE_TYPE
            model.addRow(row);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ClientDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
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
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clienttable = new javax.swing.JTable();
        clientid = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        idortype = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signout.png"))); // NOI18N
        jLabel6.setText("Sign Out");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
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
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Staff, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clienttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Phone No", "VehcileID/TYPE"
            }
        ));
        jScrollPane1.setViewportView(clienttable);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 25, 871, 285));

        clientid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientidActionPerformed(evt);
            }
        });
        jPanel6.add(clientid, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 328, 269, 36));
        jPanel6.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 376, 269, 34));

        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        jPanel6.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 435, 269, 33));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Client ID");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 333, 80, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Name");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 380, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Phone");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 438, 62, -1));

        Insert.setBackground(new java.awt.Color(0, 0, 0));
        Insert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Insert.setForeground(new java.awt.Color(255, 255, 255));
        Insert.setText("Insert");
        Insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InsertMouseClicked(evt);
            }
        });
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });
        jPanel6.add(Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 84, 34));

        update.setBackground(new java.awt.Color(0, 0, 0));
        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel6.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, -1, 34));

        Clear.setBackground(new java.awt.Color(0, 0, 0));
        Clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });
        jPanel6.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, -1, 34));

        idortype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idortypeActionPerformed(evt);
            }
        });
        jPanel6.add(idortype, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 496, 269, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Type/Reg no");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 498, -1, -1));

        delete.setBackground(new java.awt.Color(0, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel6.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, 80, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fin.jpg"))); // NOI18N
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 890, 730));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void clientidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientidActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:                                      
    // TODO add your handling code here:
     try {
        String query;
        switch (clientType) {
            case "Buyer":
                query = "INSERT INTO buyer (Buyer_id, NAME, PHONE, VEHICLE_ID) VALUES (?, ?, ?, ?)";
                break;
            case "Reseller":
                query = "INSERT INTO reseller (reseller_id, NAME, PHONE, VEHICLE_ID) VALUES (?, ?, ?, ?)";
                break;
            case "ServiceProviders":
                query = "INSERT INTO service_provider (SERVICE_PROVIDER_ID, NAME, PHONE, SERVICE_TYPE) VALUES (?, ?, ?, ?)";
                break;
            default:
                return; // Return if clientType is not recognized
        }
        pat = conn.prepareStatement(query);
        pat.setInt(1, Integer.parseInt(clientid.getText()));
        pat.setString(2, name.getText());
        pat.setString(3, phone.getText());
        if ("Buyer".equals(clientType) || "Reseller".equals(clientType)) {
            pat.setInt(4, Integer.parseInt(idortype.getText())); // VEHICLE_ID
        } else {
            pat.setString(4, idortype.getText()); // SERVICE_TYPE
        }

        int insertedRows = pat.executeUpdate();
        if (insertedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data inserted successfully.");
            displayClientData(clientType); // Refresh table data
        } else {
            JOptionPane.showMessageDialog(this, "Failed to insert data.");
        }
    } catch (SQLException | NumberFormatException ex) {
        Logger.getLogger(ClientDetails.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }

    }//GEN-LAST:event_InsertActionPerformed

    private void InsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_InsertMouseClicked
   private void clearFields() {
    clientid.setText("");
    name.setText("");
    phone.setText("");
    idortype.setText("");
    // Add any other fields you want to clear
  }
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
       try {
        String query;
        switch (clientType) {
            case "Buyer":
                query = "UPDATE buyer SET NAME = ?, PHONE = ?, VEHICLE_ID = ? WHERE Buyer_id = ?";
                break;
            case "Reseller":
                query = "UPDATE reseller SET NAME = ?, PHONE = ?, VEHICLE_ID = ? WHERE reseller_id = ?";
                break;
            case "ServiceProviders":
                query = "UPDATE service_provider SET NAME = ?, PHONE = ?, SERVICE_TYPE = ? WHERE SERVICE_PROVIDER_ID = ?";
                break;
            default:
                return; // Return if clientType is not recognized
        }
        pat = conn.prepareStatement(query);
        pat.setString(1, name.getText());
        pat.setString(2, phone.getText());
        if ("Buyer".equals(clientType) || "Reseller".equals(clientType)) {
            pat.setInt(3, Integer.parseInt(idortype.getText())); // VEHICLE_ID
        } else {
            pat.setString(3, idortype.getText()); // SERVICE_TYPE
        }
        pat.setInt(4, Integer.parseInt(clientid.getText()));

        int updatedRows = pat.executeUpdate();
        if (updatedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data updated successfully.");
            displayClientData(clientType); // Refresh table data
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update data.");
        }
    } catch (SQLException | NumberFormatException ex) {
        Logger.getLogger(ClientDetails.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_updateActionPerformed

    private void idortypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idortypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idortypeActionPerformed

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        // TODO add your handling code here:
        clientid.setText("");
        name.setText("");
        phone.setText("");
        idortype.setText("");
    }//GEN-LAST:event_ClearMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        OpenPage open=new OpenPage();
        open.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:                                       
    try {
        String query;
        switch (clientType) {
            case "Buyer":
                query = "DELETE FROM buyer WHERE Buyer_id = ?";
                break;
            case "Reseller":
                query = "DELETE FROM reseller WHERE reseller_id = ?";
                break;
            case "ServiceProviders":
                query = "DELETE FROM service_provider WHERE SERVICE_PROVIDER_ID = ?";
                break;
            default:
                return; 
        }
        pat = conn.prepareStatement(query);
        pat.setInt(1, Integer.parseInt(clientid.getText()));

        int deletedRows = pat.executeUpdate();
        if (deletedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data deleted successfully.");
            displayClientData(clientType); 
            clearFields(); 
            JOptionPane.showMessageDialog(this, "Failed to delete data.");
        }
    } catch (SQLException | NumberFormatException ex) {
        Logger.getLogger(ClientDetails.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_deleteMouseClicked

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
            java.util.logging.Logger.getLogger(ClientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            ClientDetails buyerDetails = new ClientDetails("Buyer");
            buyerDetails.setVisible(true); // Make the frame visible
            
            ClientDetails resellerDetails = new ClientDetails("Reseller");
            resellerDetails .setVisible(true); 
            
            ClientDetails serviceproviderDetails = new ClientDetails("ServiceProviders");
            serviceproviderDetails .setVisible(true);
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
    private javax.swing.JLabel Services;
    private javax.swing.JLabel Staff;
    private javax.swing.JLabel client;
    private javax.swing.JTextField clientid;
    private javax.swing.JTable clienttable;
    private javax.swing.JButton delete;
    private javax.swing.JTextField idortype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JButton update;
    private javax.swing.JLabel warehouse;
    // End of variables declaration//GEN-END:variables
}
