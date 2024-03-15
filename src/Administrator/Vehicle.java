
package Administrator;
import FirstPage.OpenPage;
public class Vehicle extends javax.swing.JFrame {

    public Vehicle() {
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
        soldCar = new javax.swing.JPanel();
        soldcart = new javax.swing.JLabel();
        soldcar = new javax.swing.JLabel();
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
        Car = new javax.swing.JPanel();
        cart1 = new javax.swing.JLabel();
        carl1 = new javax.swing.JLabel();
        soldtruck = new javax.swing.JPanel();
        truckt1 = new javax.swing.JLabel();
        truckl1 = new javax.swing.JLabel();
        soldscooter = new javax.swing.JPanel();
        scootert1 = new javax.swing.JLabel();
        scooterl1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));

        Heading.setBackground(new java.awt.Color(0, 51, 102));
        Heading.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Current Vehicle");
        Heading.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BikeLayout.setVerticalGroup(
            BikeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BikeLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(bikel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(biket)
                .addGap(30, 30, 30))
        );

        Heading.add(Bike, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 126, 209, -1));

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

        Heading.add(soldCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 439, -1, -1));

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
                .addContainerGap(81, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(truckt)
                .addGap(30, 30, 30))
        );

        Heading.add(Truck, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 126, -1, -1));

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
                .addContainerGap(65, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(scootert)
                .addGap(28, 28, 28))
        );

        Heading.add(Scooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 126, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 255, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sold Vehicle");
        Heading.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

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
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(bikel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(biket1)
                .addGap(30, 30, 30))
        );

        Heading.add(soldbike, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 439, -1, -1));

        Car.setBackground(new java.awt.Color(255, 255, 255));
        Car.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarMouseClicked(evt);
            }
        });

        cart1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cart1.setText("CAR");
        cart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart1MouseClicked(evt);
            }
        });

        carl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/car.png"))); // NOI18N
        carl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carl1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CarLayout = new javax.swing.GroupLayout(Car);
        Car.setLayout(CarLayout);
        CarLayout.setHorizontalGroup(
            CarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cart1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(CarLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(carl1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CarLayout.setVerticalGroup(
            CarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(carl1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cart1)
                .addGap(27, 27, 27))
        );

        Heading.add(Car, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 126, 204, 197));

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

        Heading.add(soldtruck, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 439, -1, 197));

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

        Heading.add(soldscooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 439, -1, 197));
        Heading.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -5, 960, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BG14.png"))); // NOI18N
        Heading.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 980, 690));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Heading.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 50));

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
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 672, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BikeMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the Vehicle frame
    }//GEN-LAST:event_BikeMouseClicked

    private void soldCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldCarMouseClicked
        
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_soldCarMouseClicked

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
        dispose(); // Close the Vehicle frame
    }//GEN-LAST:event_ScooterMouseClicked

    private void bikelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bikelMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the Vehicle frame
    }//GEN-LAST:event_bikelMouseClicked

    private void biketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_biketMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); // Close the Vehicle frame
    }//GEN-LAST:event_biketMouseClicked

    private void soldcarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldcarMouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_soldcarMouseClicked

    private void soldcartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldcartMouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
        
    }//GEN-LAST:event_soldcartMouseClicked

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

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        OpenPage open=new OpenPage();
        open.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void biket1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_biket1MouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_biket1MouseClicked

    private void bikel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bikel1MouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_bikel1MouseClicked

    private void soldbikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldbikeMouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Bike");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_soldbikeMouseClicked

    private void cart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart1MouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_cart1MouseClicked

    private void carl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carl1MouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_carl1MouseClicked

    private void CarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarMouseClicked
        // TODO add your handling code here:
        VehicleDetails vehicleDetailsFrame = new VehicleDetails("Car");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_CarMouseClicked

    private void truckt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_truckt1MouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_truckt1MouseClicked

    private void truckl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_truckl1MouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_truckl1MouseClicked

    private void soldtruckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldtruckMouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Truck");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_soldtruckMouseClicked

    private void scootert1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scootert1MouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_scootert1MouseClicked

    private void scooterl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scooterl1MouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_scooterl1MouseClicked

    private void soldscooterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldscooterMouseClicked
        // TODO add your handling code here:
        SoldVehicleDetails vehicleDetailsFrame = new SoldVehicleDetails("Scooter");
        vehicleDetailsFrame.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_soldscooterMouseClicked

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
            java.util.logging.Logger.getLogger(Vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bike;
    private javax.swing.JLabel BuyVehicle;
    private javax.swing.JPanel Car;
    private javax.swing.JLabel CurrentVehicle;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Heading;
    private javax.swing.JLabel Home;
    private javax.swing.JPanel Scooter;
    private javax.swing.JLabel Services;
    private javax.swing.JLabel Staff;
    private javax.swing.JPanel Truck;
    private javax.swing.JLabel bikel;
    private javax.swing.JLabel bikel1;
    private javax.swing.JLabel biket;
    private javax.swing.JLabel biket1;
    private javax.swing.JLabel carl1;
    private javax.swing.JLabel cart1;
    private javax.swing.JLabel client;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JLabel warehouse;
    // End of variables declaration//GEN-END:variables
}
