
package Employee;
import FirstPage.OpenPage;
public class EServices extends javax.swing.JFrame {

    public EServices() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        totalservice = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        currentservice = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        servicedone = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Services");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 20, -1, -1));

        totalservice.setBackground(new java.awt.Color(255, 255, 255));
        totalservice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalserviceMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Total Services");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mainservices7289.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout totalserviceLayout = new javax.swing.GroupLayout(totalservice);
        totalservice.setLayout(totalserviceLayout);
        totalserviceLayout.setHorizontalGroup(
            totalserviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalserviceLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(totalserviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(totalserviceLayout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jLabel5)
                    .addContainerGap(90, Short.MAX_VALUE)))
        );
        totalserviceLayout.setVerticalGroup(
            totalserviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalserviceLayout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(32, 32, 32))
            .addGroup(totalserviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(totalserviceLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(66, 66, 66)))
        );

        jPanel6.add(totalservice, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 161, -1, -1));

        currentservice.setBackground(new java.awt.Color(255, 255, 255));
        currentservice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currentserviceMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Current service");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mainnnservice.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout currentserviceLayout = new javax.swing.GroupLayout(currentservice);
        currentservice.setLayout(currentserviceLayout);
        currentserviceLayout.setHorizontalGroup(
            currentserviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentserviceLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(currentserviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(currentserviceLayout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jLabel6)
                    .addContainerGap(84, Short.MAX_VALUE)))
        );
        currentserviceLayout.setVerticalGroup(
            currentserviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentserviceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(31, 31, 31))
            .addGroup(currentserviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(currentserviceLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(66, 66, 66)))
        );

        jPanel6.add(currentservice, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 161, -1, 211));

        servicedone.setBackground(new java.awt.Color(255, 255, 255));
        servicedone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servicedoneMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Service done");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mainssewerf.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout servicedoneLayout = new javax.swing.GroupLayout(servicedone);
        servicedone.setLayout(servicedoneLayout);
        servicedoneLayout.setHorizontalGroup(
            servicedoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicedoneLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(servicedoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(servicedoneLayout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(jLabel7)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );
        servicedoneLayout.setVerticalGroup(
            servicedoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, servicedoneLayout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(35, 35, 35))
            .addGroup(servicedoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(servicedoneLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(66, 66, 66)))
        );

        jPanel6.add(servicedone, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 161, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BG14.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 920, 670));

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
                .addGap(0, 32, Short.MAX_VALUE)
                .addGroup(Dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
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
                .addGap(40, 40, 40)
                .addComponent(CurrentVehicle1)
                .addGap(40, 40, 40)
                .addComponent(BuyVehicle1)
                .addGap(43, 43, 43)
                .addComponent(Services1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Warehouse1)
                .addGap(39, 39, 39)
                .addComponent(client1)
                .addGap(34, 34, 34)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void totalserviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalserviceMouseClicked
        // TODO add your handling code here:
        EServiceDetails serviceDetailsFrame = new EServiceDetails("Total Service");
        serviceDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_totalserviceMouseClicked

    private void currentserviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentserviceMouseClicked
        // TODO add your handling code here:
        EServiceDetails serviceDetailsFrame = new EServiceDetails("Current Service");
        serviceDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_currentserviceMouseClicked

    private void servicedoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicedoneMouseClicked
        // TODO add your handling code here:
        EServiceDetails serviceDetailsFrame = new EServiceDetails("Service Done");
        serviceDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_servicedoneMouseClicked

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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        EServiceDetails serviceDetailsFrame = new EServiceDetails("Total Service");
        serviceDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        EServiceDetails serviceDetailsFrame = new EServiceDetails("Current Service");
        serviceDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        EServiceDetails serviceDetailsFrame = new EServiceDetails("Service Done");
        serviceDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EServices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuyVehicle1;
    private javax.swing.JLabel CurrentVehicle1;
    private javax.swing.JPanel Dashboard1;
    private javax.swing.JLabel Home1;
    private javax.swing.JLabel Services1;
    private javax.swing.JLabel Warehouse1;
    private javax.swing.JLabel client1;
    private javax.swing.JPanel currentservice;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel servicedone;
    private javax.swing.JPanel totalservice;
    // End of variables declaration//GEN-END:variables
}
