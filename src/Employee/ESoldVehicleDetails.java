
package Employee;

import Administrator.Register;
import FirstPage.OpenPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ESoldVehicleDetails extends javax.swing.JFrame {
    private String vehicleType;
    
    public ESoldVehicleDetails(String vehicleType) {
        initComponents();
        this.vehicleType = vehicleType; 
        Connect(); // Connect to the database
        loadData(vehicleType); // Load data into the table
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
    
   private void loadData(String vehicleType) {
    try {
        String sql = "SELECT * FROM SoldVehicleDetails WHERE TYPE = ? ";
        pat = conn.prepareStatement(sql);
        pat.setString(1, vehicleType);
        rs = pat.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) soldtable.getModel();
        model.setRowCount(0); 
        
        while(rs.next()){
            Object[] row = new Object[9]; 
            row[0] = rs.getInt("VIN");
            row[1] = rs.getString("VEHICLE_ID");
            row[2] = rs.getString("MODEL");
            row[3] = rs.getString("COMPANY");
            row[4] = rs.getDate("TRANSACTION_DATE");
            row[5] = rs.getInt("EMPLOYEE_ID");
            row[6] = rs.getString("RESELLER_NAME");
            row[7] = rs.getString("BUYER_NAME");
            row[8] = rs.getBigDecimal("TRANSACTION_PRICE");
            
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EVehicleDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        soldtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Dashboard2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Home2 = new javax.swing.JLabel();
        CurrentVehicle2 = new javax.swing.JLabel();
        BuyVehicle2 = new javax.swing.JLabel();
        Services2 = new javax.swing.JLabel();
        Warehouse3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        client2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        soldtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vehicle ID", "Reg No", "Model", "Company", "Date", "Employee", "Reseller Name", "Buyer Name", "Profit"
            }
        ));
        jScrollPane1.setViewportView(soldtable);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 72, 840, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BG14.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 670));

        Dashboard2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome!");

        Home2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Home2.setForeground(new java.awt.Color(255, 255, 255));
        Home2.setText("Home");
        Home2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home2MouseClicked(evt);
            }
        });

        CurrentVehicle2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CurrentVehicle2.setForeground(new java.awt.Color(255, 255, 255));
        CurrentVehicle2.setText("Vehicle");
        CurrentVehicle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CurrentVehicle2MouseClicked(evt);
            }
        });

        BuyVehicle2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BuyVehicle2.setForeground(new java.awt.Color(255, 255, 255));
        BuyVehicle2.setText("Transaction");
        BuyVehicle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuyVehicle2MouseClicked(evt);
            }
        });

        Services2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Services2.setForeground(new java.awt.Color(255, 255, 255));
        Services2.setText("Services");
        Services2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Services2MouseClicked(evt);
            }
        });

        Warehouse3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Warehouse3.setForeground(new java.awt.Color(255, 255, 255));
        Warehouse3.setText("Warehouse");
        Warehouse3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Warehouse3MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ID.png"))); // NOI18N

        client2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        client2.setForeground(new java.awt.Color(255, 255, 255));
        client2.setText("Client");
        client2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                client2MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signout.png"))); // NOI18N
        jLabel24.setText("Sign Out");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Dashboard2Layout = new javax.swing.GroupLayout(Dashboard2);
        Dashboard2.setLayout(Dashboard2Layout);
        Dashboard2Layout.setHorizontalGroup(
            Dashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard2Layout.createSequentialGroup()
                .addGroup(Dashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Dashboard2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Dashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentVehicle2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Dashboard2Layout.createSequentialGroup()
                                .addGroup(Dashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BuyVehicle2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Services2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Warehouse3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Home2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(client2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 27, Short.MAX_VALUE))))
                    .addGroup(Dashboard2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Dashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard2Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        Dashboard2Layout.setVerticalGroup(
            Dashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(45, 45, 45)
                .addComponent(Home2)
                .addGap(38, 38, 38)
                .addComponent(CurrentVehicle2)
                .addGap(46, 46, 46)
                .addComponent(BuyVehicle2)
                .addGap(45, 45, 45)
                .addComponent(Services2)
                .addGap(41, 41, 41)
                .addComponent(Warehouse3)
                .addGap(44, 44, 44)
                .addComponent(client2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Home2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home2MouseClicked
        // TODO add your handling code here:
        EHome homeFrame = new EHome();
        homeFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Home2MouseClicked

    private void CurrentVehicle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentVehicle2MouseClicked
        // TODO add your handling code here:
        EVehicle currentVehicleFrame = new EVehicle();
        currentVehicleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_CurrentVehicle2MouseClicked

    private void BuyVehicle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuyVehicle2MouseClicked
        // TODO add your handling code here:
        ETransactions buyvehicleframe=new ETransactions();
        buyvehicleframe.setVisible(true);
        dispose();
    }//GEN-LAST:event_BuyVehicle2MouseClicked

    private void Services2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Services2MouseClicked
        // TODO add your handling code here:
        EServices servicesFrame = new EServices();
        servicesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Services2MouseClicked

    private void Warehouse3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Warehouse3MouseClicked
        // TODO add your handling code here:
        EWarehouse warehouseFrame = new EWarehouse();
        warehouseFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Warehouse3MouseClicked

    private void client2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client2MouseClicked
        // TODO add your handling code here:
        EClient clientFrame = new EClient();
        clientFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_client2MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        OpenPage open=new OpenPage();
        open.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

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
            java.util.logging.Logger.getLogger(ESoldVehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ESoldVehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ESoldVehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ESoldVehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               ESoldVehicleDetails carDetails = new ESoldVehicleDetails("Car");
            carDetails.setVisible(true); // Make the frame visible
            
            ESoldVehicleDetails bikeDetails = new ESoldVehicleDetails("Bike");
            bikeDetails.setVisible(true); // Make the frame visible
            
            ESoldVehicleDetails scooterDetails = new ESoldVehicleDetails("Scooter");
            scooterDetails.setVisible(true); // Make the frame visible
            
           ESoldVehicleDetails truckDetails = new ESoldVehicleDetails("Truck");
            truckDetails.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuyVehicle2;
    private javax.swing.JLabel CurrentVehicle2;
    private javax.swing.JPanel Dashboard2;
    private javax.swing.JLabel Home2;
    private javax.swing.JLabel Services2;
    private javax.swing.JLabel Warehouse3;
    private javax.swing.JLabel client2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable soldtable;
    // End of variables declaration//GEN-END:variables
}
