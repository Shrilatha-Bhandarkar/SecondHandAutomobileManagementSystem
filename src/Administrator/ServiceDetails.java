
package Administrator;
import FirstPage.OpenPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class ServiceDetails extends javax.swing.JFrame {
    private String serviceType; 

    public ServiceDetails(String serviceType) {
        initComponents();
        this.serviceType= serviceType;
        Connect();
        loadData(serviceType);
        


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
    private void loadData(String serviceType) {
    try {
        String query = "";

        switch (serviceType) {
            case "Total Service":
                query = "SELECT * FROM service";
                break;
            case "Current Service":
                query = "SELECT * FROM service WHERE status = 'PROGRESS'";
                break;
            case "Service Done":
                query = "SELECT * FROM service WHERE status = 'DONE'";
                break;
        }

        if (!query.isEmpty()) {
            pat = conn.prepareStatement(query);
            rs = pat.executeQuery();

            DefaultTableModel model = (DefaultTableModel) servicestable.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[8]; // Assuming there are 8 columns in the services table
                row[0] = rs.getInt("SERVICE_ID");
                row[1] = rs.getString("VEHICLE_ID");
                row[2] = rs.getInt("SERVICE_PROVIDER_ID");
                row[3] = rs.getDate("DUE_DATE");
                row[4] = rs.getDate("DATE");
                row[5] = rs.getString("SERVICE_TYPE");
                row[6] = rs.getBigDecimal("COST");
                row[7] = rs.getString("STATUS");
                model.addRow(row);
            }
            
            // Add ListSelectionListener to the table
            servicestable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = servicestable.getSelectedRow();
                        if (selectedRow != -1) { // If a row is selected
                            // Get the data from the selected row
                            Object serviceId = servicestable.getValueAt(selectedRow, 0);
                            Object regNo = servicestable.getValueAt(selectedRow, 1);
                            Object providerId = servicestable.getValueAt(selectedRow, 2);
                            Object dueDate = servicestable.getValueAt(selectedRow, 3); 
                            Object dateIn = servicestable.getValueAt(selectedRow, 4); 
                            Object serviceType = servicestable.getValueAt(selectedRow, 5);
                            Object costValue = servicestable.getValueAt(selectedRow, 6);
                            Object statusValue = servicestable.getValueAt(selectedRow, 7);
                            
                            // Set the data to corresponding text fields or other components
                            service_id.setText(serviceId.toString());
                            regno.setText(regNo.toString());
                            provider_id.setText(providerId.toString());
                            duedate.setText(dueDate.toString());
                            datein.setText(dateIn.toString());
                            type.setText(serviceType.toString());
                            cost.setText(costValue.toString());
                            status.setText(statusValue.toString());
                        }
                    }
                }
            });
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceDetails.class.getName()).log(Level.SEVERE, "Error retrieving service data", ex);
    }
}


   
   private void clearFields() {
        provider_id.setText("");
        service_id.setText("");
        regno.setText("");
        type.setText("");
        cost.setText("");
        datein.setText("");
        duedate.setText("");
        status.setText("");
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
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        servicestable = new javax.swing.JTable();
        service_id = new javax.swing.JTextField();
        provider_id = new javax.swing.JTextField();
        regno = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        datein = new javax.swing.JTextField();
        duedate = new javax.swing.JTextField();
        cost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        get = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signout.png"))); // NOI18N
        jLabel10.setText("Sign Out");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
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
                                    .addComponent(warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Staff, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(Home)
                .addGap(41, 41, 41)
                .addComponent(CurrentVehicle)
                .addGap(42, 42, 42)
                .addComponent(BuyVehicle)
                .addGap(35, 35, 35)
                .addComponent(Services)
                .addGap(48, 48, 48)
                .addComponent(warehouse)
                .addGap(40, 40, 40)
                .addComponent(client)
                .addGap(35, 35, 35)
                .addComponent(Staff)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        servicestable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Service_ID", "Reg No", "ServiceProviderID", "DueDate", "Date In", "Service_Type", "Cost", "Status"
            }
        ));
        jScrollPane1.setViewportView(servicestable);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 22, 884, 315));
        jPanel6.add(service_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 138, 32));
        jPanel6.add(provider_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 138, 32));
        jPanel6.add(regno, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 355, 138, 32));
        jPanel6.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 413, 138, 32));
        jPanel6.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 531, 138, 32));
        jPanel6.add(datein, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 471, 138, 32));
        jPanel6.add(duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 138, 32));
        jPanel6.add(cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 138, 32));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Service ID");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 115, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Reg No");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Date In");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 476, 115, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Service Type");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 418, 115, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Service Providers ID");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Cost");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Due Date");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setText("Status");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 536, -1, -1));

        insert.setBackground(new java.awt.Color(0, 0, 0));
        insert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        insert.setForeground(new java.awt.Color(255, 255, 255));
        insert.setText("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jPanel6.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 583, 90, 40));

        Update.setBackground(new java.awt.Color(0, 0, 0));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel6.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 583, 90, 40));

        Delete.setBackground(new java.awt.Color(0, 0, 0));
        Delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel6.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 583, 80, 40));

        Clear.setBackground(new java.awt.Color(0, 0, 0));
        Clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        jPanel6.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 583, 80, 40));

        get.setBackground(new java.awt.Color(0, 0, 0));
        get.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        get.setForeground(new java.awt.Color(255, 255, 255));
        get.setText("Get");
        get.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getMouseClicked(evt);
            }
        });
        jPanel6.add(get, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 60, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fin.jpg"))); // NOI18N
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 940, 650));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:int selectedRow = servicestable.getSelectedRow();
        int selectedRow = servicestable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                String query = "UPDATE service SET SERVICE_PROVIDER_ID = ?, VEHICLE_ID = ?,  DUE_DATE = ?,DATE = ?,  SERVICE_TYPE = ?, COST = ?,STATUS = ? WHERE SERVICE_ID = ?";
                pat = conn.prepareStatement(query);

                pat.setString(1, provider_id.getText());
                pat.setString(2, regno.getText());
                pat.setString(3, duedate.getText());
                pat.setString(4, datein.getText());
                pat.setString(5, type.getText());
                pat.setString(6, cost.getText());
                pat.setString(7, status.getText());
                pat.setInt(8, Integer.parseInt(servicestable.getValueAt(selectedRow, 0).toString()));

                int updatedRows = pat.executeUpdate();
                if (updatedRows > 0) {
                    loadData(serviceType);
                    clearFields();
                    JOptionPane.showMessageDialog(this, "Updated successfully.");
                } else {
                    System.out.println("Failed to update data.");
                }
                
            } catch (SQLException | NumberFormatException ex) {
                Logger.getLogger(ServiceDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = servicestable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                String query = "DELETE FROM service WHERE SERVICE_ID = ?";
                pat = conn.prepareStatement(query);
                pat.setInt(1, Integer.parseInt(servicestable.getValueAt(selectedRow, 0).toString()));

                int deletedRows = pat.executeUpdate();
                if (deletedRows > 0) {
                    // Refresh table data
                    loadData(serviceType);
                    clearFields();
                    JOptionPane.showMessageDialog(this, "Deleted successfully.");
                } else {
                    System.out.println("Failed to delete data.");
                }
            } catch (SQLException | NumberFormatException ex) {
                Logger.getLogger(ServiceDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_ClearActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        try {
        String query = "INSERT INTO service (SERVICE_PROVIDER_ID, VEHICLE_ID, DUE_DATE, DATE, SERVICE_TYPE, COST, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        pat = conn.prepareStatement(query);
        
        pat.setString(1, provider_id.getText());
        pat.setString(2, regno.getText());
        pat.setString(3, duedate.getText());
        pat.setString(4, datein.getText());
        pat.setString(5, type.getText());
        pat.setString(6, cost.getText());
        pat.setString(7, status.getText());
        
        int insertedRows = pat.executeUpdate();
        
        if (insertedRows > 0) {
            loadData(serviceType);
            clearFields();
            JOptionPane.showMessageDialog(this, "Inserted successfully.");
        } else {
            System.out.println("Failed to insert data.");
        }
    } catch (SQLException | NumberFormatException ex) {
        Logger.getLogger(ServiceDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_insertActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        OpenPage open=new OpenPage();
        open.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void getMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getMouseClicked
        // TODO add your handling code here:
     String serviceProviderId = provider_id.getText();

    if (!serviceProviderId.isEmpty()) {
        try {
            String query = "SELECT SERVICE_TYPE FROM SERVICE_PROVIDER WHERE SERVICE_PROVIDER_ID = ?";
            pat = conn.prepareStatement(query);
            pat.setString(1, serviceProviderId);
            rs = pat.executeQuery();
            
            if (rs.next()) {
                String serviceType = rs.getString("SERVICE_TYPE");
                
                type.setText(serviceType);  
            } else {
                JOptionPane.showMessageDialog(this, "No service type found for the provided service provider ID.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetails.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please enter a service provider ID.");
    }
    }//GEN-LAST:event_getMouseClicked

  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            ServiceDetails totalDetails = new ServiceDetails("Total Services");
            totalDetails.setVisible(true); // Make the frame visible
            
            ServiceDetails currentDetails = new ServiceDetails("Current Service");
            currentDetails.setVisible(true);
            
            ServiceDetails doneDetails = new ServiceDetails("Service Done");
            doneDetails.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuyVehicle;
    private javax.swing.JButton Clear;
    private javax.swing.JLabel CurrentVehicle;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JButton Delete;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel Services;
    private javax.swing.JLabel Staff;
    private javax.swing.JButton Update;
    private javax.swing.JLabel client;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField datein;
    private javax.swing.JTextField duedate;
    private javax.swing.JButton get;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField provider_id;
    private javax.swing.JTextField regno;
    private javax.swing.JTextField service_id;
    private javax.swing.JTable servicestable;
    private javax.swing.JTextField status;
    private javax.swing.JTextField type;
    private javax.swing.JLabel warehouse;
    // End of variables declaration//GEN-END:variables
}
