
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
        jLabel9 = new javax.swing.JLabel();
        soldbike = new javax.swing.JPanel();
        biket1 = new javax.swing.JLabel();
        bikel1 = new javax.swing.JLabel();
        soldCar = new javax.swing.JPanel();
        soldcart = new javax.swing.JLabel();
        soldcar = new javax.swing.JLabel();
        soldtruck = new javax.swing.JPanel();
        truckt1 = new javax.swing.JLabel();
        truckl1 = new javax.swing.JLabel();
        soldscooter = new javax.swing.JPanel();
        scootert1 = new javax.swing.JLabel();
        scooterl1 = new javax.swing.JLabel();
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

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));

        Heading.setBackground(new java.awt.Color(0, 51, 102));
        Heading.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Current Vehicle");
        Heading.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        Bike.setBackground(new java.awt.Color(255, 255, 255));
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

        Heading.add(Bike, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 142, -1, -1));

        Car.setBackground(new java.awt.Color(255, 255, 255));
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

        Heading.add(Car, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 142, -1, 185));

        Truck.setBackground(new java.awt.Color(255, 255, 255));
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

        Heading.add(Truck, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 142, -1, 185));

        Scooter.setBackground(new java.awt.Color(255, 255, 255));
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

        Heading.add(Scooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 142, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sold Vehicle");
        Heading.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        soldbike.setBackground(new java.awt.Color(255, 255, 255));
        soldbike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soldbikeMouseClicked(evt);
            }
        });

        biket1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        biket1.setText("BIKE");
        biket1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                biket1MouseClicked(evt);
            }
        });

        bikel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bike.png"))); // NOI18N
        bikel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bikel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout soldbikeLayout = new javax.swing.GroupLayout(soldbike);
        soldbike.setLayout(soldbikeLayout);
        soldbikeLayout.setHorizontalGroup(
            soldbikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soldbikeLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(soldbikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bikel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soldbikeLayout.createSequentialGroup()
                        .addComponent(biket1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        soldbikeLayout.setVerticalGroup(
            soldbikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soldbikeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bikel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(biket1)
                .addGap(30, 30, 30))
        );

        Heading.add(soldbike, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 480, -1, 197));

        soldCar.setBackground(new java.awt.Color(255, 255, 255));
        soldCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soldCarMouseClicked(evt);
            }
        });

        soldcart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        soldcart.setText("CAR");
        soldcart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soldcartMouseClicked(evt);
            }
        });

        soldcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/car.png"))); // NOI18N
        soldcar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soldcarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout soldCarLayout = new javax.swing.GroupLayout(soldCar);
        soldCar.setLayout(soldCarLayout);
        soldCarLayout.setHorizontalGroup(
            soldCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soldCarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(soldcart, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(soldCarLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(soldcar)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        soldCarLayout.setVerticalGroup(
            soldCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soldCarLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(soldcar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(soldcart)
                .addGap(27, 27, 27))
        );

        Heading.add(soldCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 480, -1, -1));

        soldtruck.setBackground(new java.awt.Color(255, 255, 255));
        soldtruck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soldtruckMouseClicked(evt);
            }
        });

        truckt1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        truckt1.setText("TRUCK");
        truckt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                truckt1MouseClicked(evt);
            }
        });

        truckl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/truck.png"))); // NOI18N
        truckl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                truckl1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout soldtruckLayout = new javax.swing.GroupLayout(soldtruck);
        soldtruck.setLayout(soldtruckLayout);
        soldtruckLayout.setHorizontalGroup(
            soldtruckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soldtruckLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(soldtruckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(truckl1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(truckt1))
                .addGap(65, 65, 65))
        );
        soldtruckLayout.setVerticalGroup(
            soldtruckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soldtruckLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(truckl1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(truckt1)
                .addGap(30, 30, 30))
        );

        Heading.add(soldtruck, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 480, -1, 197));

        soldscooter.setBackground(new java.awt.Color(255, 255, 255));
        soldscooter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soldscooterMouseClicked(evt);
            }
        });

        scootert1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        scootert1.setText("SCOOTER");
        scootert1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scootert1MouseClicked(evt);
            }
        });

        scooterl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/scooter.png"))); // NOI18N
        scooterl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scooterl1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout soldscooterLayout = new javax.swing.GroupLayout(soldscooter);
        soldscooter.setLayout(soldscooterLayout);
        soldscooterLayout.setHorizontalGroup(
            soldscooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soldscooterLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(soldscooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scootert1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scooterl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        soldscooterLayout.setVerticalGroup(
            soldscooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soldscooterLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(scooterl1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scootert1)
                .addGap(28, 28, 28))
        );

        Heading.add(soldscooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 480, -1, 197));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BG14.png"))); // NOI18N
        Heading.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 720));

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
                .addComponent(Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void biket1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_biket1MouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_biket1MouseClicked

    private void bikel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bikel1MouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_bikel1MouseClicked

    private void soldbikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldbikeMouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_soldbikeMouseClicked

    private void soldcartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldcartMouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose();

    }//GEN-LAST:event_soldcartMouseClicked

    private void soldcarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldcarMouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_soldcarMouseClicked

    private void soldCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldCarMouseClicked

        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_soldCarMouseClicked

    private void truckt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_truckt1MouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_truckt1MouseClicked

    private void truckl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_truckl1MouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_truckl1MouseClicked

    private void soldtruckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldtruckMouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_soldtruckMouseClicked

    private void scootert1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scootert1MouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_scootert1MouseClicked

    private void scooterl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scooterl1MouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_scooterl1MouseClicked

    private void soldscooterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldscooterMouseClicked
        // TODO add your handling code here:
        ESoldVehicleDetails vehicleDetailsFrame = new ESoldVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_soldscooterMouseClicked

  
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
    private javax.swing.JLabel bikel1;
    private javax.swing.JLabel biket;
    private javax.swing.JLabel biket1;
    private javax.swing.JLabel carl;
    private javax.swing.JLabel cart;
    private javax.swing.JLabel client1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel scooterl;
    private javax.swing.JLabel scooterl1;
    private javax.swing.JLabel scootert;
    private javax.swing.JLabel scootert1;
    private javax.swing.JPanel soldCar;
    private javax.swing.JPanel soldbike;
    private javax.swing.JLabel soldcar;
    private javax.swing.JLabel soldcart;
    private javax.swing.JPanel soldscooter;
    private javax.swing.JPanel soldtruck;
    private javax.swing.JLabel truckl;
    private javax.swing.JLabel truckl1;
    private javax.swing.JLabel truckt;
    private javax.swing.JLabel truckt1;
    // End of variables declaration//GEN-END:variables
}
