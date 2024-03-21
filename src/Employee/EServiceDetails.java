/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Employee;
import FirstPage.OpenPage;
import Administrator.Register;
import Administrator.ServiceDetails;
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

public class EServiceDetails extends javax.swing.JFrame {
     private String serviceType;
    public EServiceDetails(String serviceType) {
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
        Clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Dashboard1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Home1 = new javax.swing.JLabel();
        CurrentVehicle1 = new javax.swing.JLabel();
        BuyVehicle1 = new javax.swing.JLabel();
        Services1 = new javax.swing.JLabel();
        Warehouse1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        client1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

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
        jPanel6.add(service_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 138, 32));
        jPanel6.add(provider_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 413, 138, 32));
        jPanel6.add(regno, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 355, 138, 32));
        jPanel6.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 413, 138, 32));
        jPanel6.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 531, 138, 32));
        jPanel6.add(datein, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 471, 138, 32));
        jPanel6.add(duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 138, 32));
        jPanel6.add(cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 531, 138, 32));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Service ID");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 360, 115, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Reg No");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 360, 115, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Date In");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 476, 115, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Service Type");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 418, 115, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Service Providers ID");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 418, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Cost");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 536, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Due Date");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 474, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        jPanel6.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 613, -1, 32));

        Update.setBackground(new java.awt.Color(0, 0, 0));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel6.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 613, -1, 32));

        Clear.setBackground(new java.awt.Color(0, 0, 0));
        Clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        jPanel6.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 613, -1, 32));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fin.jpg"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 660));

        Dashboard1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Welcome!");

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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ID.png"))); // NOI18N

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
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        Dashboard1Layout.setVerticalGroup(
            Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(45, 45, 45)
                .addComponent(Home1)
                .addGap(49, 49, 49)
                .addComponent(CurrentVehicle1)
                .addGap(47, 47, 47)
                .addComponent(BuyVehicle1)
                .addGap(36, 36, 36)
                .addComponent(Services1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Warehouse1)
                .addGap(31, 31, 31)
                .addComponent(client1)
                .addGap(50, 50, 50)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_ClearActionPerformed

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
            java.util.logging.Logger.getLogger(EServiceDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EServiceDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EServiceDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EServiceDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            EServiceDetails totalDetails = new EServiceDetails("Total Services");
            totalDetails.setVisible(true); // Make the frame visible
            
            EServiceDetails currentDetails = new EServiceDetails("Current Service");
            currentDetails.setVisible(true);
            
            EServiceDetails doneDetails = new EServiceDetails("Service Done");
            doneDetails.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuyVehicle1;
    private javax.swing.JButton Clear;
    private javax.swing.JLabel CurrentVehicle1;
    private javax.swing.JPanel Dashboard1;
    private javax.swing.JLabel Home1;
    private javax.swing.JLabel Services1;
    private javax.swing.JButton Update;
    private javax.swing.JLabel Warehouse1;
    private javax.swing.JLabel client1;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField datein;
    private javax.swing.JTextField duedate;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
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
    // End of variables declaration//GEN-END:variables
}
