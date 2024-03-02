
package Employee;

public class CurrentVehicle extends javax.swing.JFrame {

    public CurrentVehicle() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Heading = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Bike = new javax.swing.JPanel();
        biket = new javax.swing.JLabel();
        bikel = new javax.swing.JLabel();
        Car = new javax.swing.JPanel();
        cart = new javax.swing.JLabel();
        carl = new javax.swing.JLabel();
        Truck = new javax.swing.JPanel();
        truckt = new javax.swing.JLabel();
        truckl = new javax.swing.JLabel();
        Scooter = new javax.swing.JPanel();
        scootert = new javax.swing.JLabel();
        scooterl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));

        Dashboard.setBackground(new java.awt.Color(255, 102, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Home");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome!");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Current Vehicle");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buy Vehicle");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Services");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Employees");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DashUser.png"))); // NOI18N

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DashboardLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashboardLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1))
                            .addGroup(DashboardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DashboardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DashboardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        Heading.setBackground(new java.awt.Color(0, 51, 102));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Current Vehicle");

        Bike.setBackground(new java.awt.Color(255, 102, 51));
        Bike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BikeMouseClicked(evt);
            }
        });

        biket.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        biket.setText("BIKE");
        biket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                biketMouseClicked(evt);
            }
        });

        bikel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bike.png"))); // NOI18N
        bikel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bikelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BikeLayout = new javax.swing.GroupLayout(Bike);
        Bike.setLayout(BikeLayout);
        BikeLayout.setHorizontalGroup(
            BikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BikeLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(BikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bikel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BikeLayout.createSequentialGroup()
                        .addComponent(biket, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        BikeLayout.setVerticalGroup(
            BikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BikeLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(bikel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(biket)
                .addGap(30, 30, 30))
        );

        Car.setBackground(new java.awt.Color(255, 102, 51));
        Car.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarMouseClicked(evt);
            }
        });

        cart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cart.setText("CAR");
        cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartMouseClicked(evt);
            }
        });

        carl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/car.png"))); // NOI18N
        carl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carlMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CarLayout = new javax.swing.GroupLayout(Car);
        Car.setLayout(CarLayout);
        CarLayout.setHorizontalGroup(
            CarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cart, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(CarLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(carl)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        CarLayout.setVerticalGroup(
            CarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(carl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cart)
                .addGap(27, 27, 27))
        );

        Truck.setBackground(new java.awt.Color(255, 102, 51));
        Truck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TruckMouseClicked(evt);
            }
        });

        truckt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        truckt.setText("TRUCK");
        truckt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trucktMouseClicked(evt);
            }
        });

        truckl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/truck.png"))); // NOI18N
        truckl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trucklMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TruckLayout = new javax.swing.GroupLayout(Truck);
        Truck.setLayout(TruckLayout);
        TruckLayout.setHorizontalGroup(
            TruckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TruckLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(TruckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(truckl, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(truckt))
                .addGap(65, 65, 65))
        );
        TruckLayout.setVerticalGroup(
            TruckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TruckLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(truckl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(truckt)
                .addGap(30, 30, 30))
        );

        Scooter.setBackground(new java.awt.Color(255, 102, 51));
        Scooter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScooterMouseClicked(evt);
            }
        });

        scootert.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        scootert.setText("SCOOTER");
        scootert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scootertMouseClicked(evt);
            }
        });

        scooterl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/scooter.png"))); // NOI18N
        scooterl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scooterlMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ScooterLayout = new javax.swing.GroupLayout(Scooter);
        Scooter.setLayout(ScooterLayout);
        ScooterLayout.setHorizontalGroup(
            ScooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScooterLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(ScooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scootert, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scooterl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        ScooterLayout.setVerticalGroup(
            ScooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScooterLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(scooterl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(scootert)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout HeadingLayout = new javax.swing.GroupLayout(Heading);
        Heading.setLayout(HeadingLayout);
        HeadingLayout.setHorizontalGroup(
            HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bike, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(Car, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Scooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(HeadingLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeadingLayout.setVerticalGroup(
            HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadingLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(58, 58, 58)
                .addGroup(HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Bike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Car, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Truck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Scooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BikeMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the CurrentVehicle frame
    }//GEN-LAST:event_BikeMouseClicked

    private void CarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarMouseClicked
        
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_CarMouseClicked

    private void TruckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TruckMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_TruckMouseClicked

    private void ScooterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScooterMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the CurrentVehicle frame
    }//GEN-LAST:event_ScooterMouseClicked

    private void bikelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bikelMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the CurrentVehicle frame
    }//GEN-LAST:event_bikelMouseClicked

    private void biketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_biketMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the CurrentVehicle frame
    }//GEN-LAST:event_biketMouseClicked

    private void carlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carlMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_carlMouseClicked

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_cartMouseClicked

    private void trucklMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trucklMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_trucklMouseClicked

    private void trucktMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trucktMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_trucktMouseClicked

    private void scooterlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scooterlMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_scooterlMouseClicked

    private void scootertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scootertMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_scootertMouseClicked

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
            java.util.logging.Logger.getLogger(CurrentVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrentVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bike;
    private javax.swing.JPanel Car;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Heading;
    private javax.swing.JPanel Scooter;
    private javax.swing.JPanel Truck;
    private javax.swing.JLabel bikel;
    private javax.swing.JLabel biket;
    private javax.swing.JLabel carl;
    private javax.swing.JLabel cart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel scooterl;
    private javax.swing.JLabel scootert;
    private javax.swing.JLabel truckl;
    private javax.swing.JLabel truckt;
    // End of variables declaration//GEN-END:variables
}
