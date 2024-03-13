
package Employee;
import FirstPage.OpenPage;
public class EVehicle extends javax.swing.JFrame {

    public EVehicle() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
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

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));

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
                .addGroup(HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(HeadingLayout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel8))
                    .addGroup(HeadingLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Bike, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(Car, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(Truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Scooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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
                .addContainerGap(418, Short.MAX_VALUE))
        );

        Dashboard1.setBackground(new java.awt.Color(255, 102, 51));

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

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DashUser.png"))); // NOI18N

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
                                .addGap(0, 36, Short.MAX_VALUE))))
                    .addGroup(Dashboard1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(Dashboard1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(49, 49, 49)
                .addComponent(CurrentVehicle1)
                .addGap(47, 47, 47)
                .addComponent(BuyVehicle1)
                .addGap(53, 53, 53)
                .addComponent(Services1)
                .addGap(35, 35, 35)
                .addComponent(Warehouse1)
                .addGap(47, 47, 47)
                .addComponent(client1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(Dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void biketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_biketMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the Vehicle frame
    }//GEN-LAST:event_biketMouseClicked

    private void bikelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bikelMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the Vehicle frame
    }//GEN-LAST:event_bikelMouseClicked

    private void BikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BikeMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the Vehicle frame
    }//GEN-LAST:event_BikeMouseClicked

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_cartMouseClicked

    private void carlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carlMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_carlMouseClicked

    private void CarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarMouseClicked

        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_CarMouseClicked

    private void trucktMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trucktMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_trucktMouseClicked

    private void trucklMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trucklMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_trucklMouseClicked

    private void TruckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TruckMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_TruckMouseClicked

    private void scootertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scootertMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_scootertMouseClicked

    private void scooterlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scooterlMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_scooterlMouseClicked

    private void ScooterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScooterMouseClicked
        // TODO add your handling code here:
        EVehicleDetails vehicleDetailsFrame = new EVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the Vehicle frame
    }//GEN-LAST:event_ScooterMouseClicked

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
                new EVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bike;
    private javax.swing.JLabel BuyVehicle1;
    private javax.swing.JPanel Car;
    private javax.swing.JLabel CurrentVehicle1;
    private javax.swing.JPanel Dashboard1;
    private javax.swing.JPanel Heading;
    private javax.swing.JLabel Home1;
    private javax.swing.JPanel Scooter;
    private javax.swing.JLabel Services1;
    private javax.swing.JPanel Truck;
    private javax.swing.JLabel Warehouse1;
    private javax.swing.JLabel bikel;
    private javax.swing.JLabel biket;
    private javax.swing.JLabel carl;
    private javax.swing.JLabel cart;
    private javax.swing.JLabel client1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel scooterl;
    private javax.swing.JLabel scootert;
    private javax.swing.JLabel truckl;
    private javax.swing.JLabel truckt;
    // End of variables declaration//GEN-END:variables
}
