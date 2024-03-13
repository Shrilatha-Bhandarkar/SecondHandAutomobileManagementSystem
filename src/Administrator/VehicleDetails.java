package Administrator;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane; 
import FirstPage.OpenPage;

public class VehicleDetails extends javax.swing.JFrame {
    private String vehicleType; 
    
    public VehicleDetails(String vehicleType) {
        initComponents();
        this.vehicleType = vehicleType; 
        Connect(); // Connect to the database
        loadData(vehicleType); // Load data into the table
        TableDetails.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fetchSelectedRowData(); // Call method to display selected row data
            }

            // Other mouse listener methods
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

    }
    
    Connection conn;
    PreparedStatement pat;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/shams","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loadData(String vehicleType) {
    try {
        String sql = "SELECT V.VEHICLE_ID, V.MODEL, V.COMPANY, V.MILEAGE, V.COLOUR, V.YEAR, V.SELLING_PRICE,R.NAME AS SELLER_NAME, R.PHONE AS SELLER_PHONE " +
                     "FROM VEHICLE V " +
                     "JOIN RESELLER R ON V.VEHICLE_ID = R.VEHICLE_ID " +
                     "WHERE V.TYPE = ?";
        pat = conn.prepareStatement(sql);
        pat.setString(1, vehicleType);
        rs = pat.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) TableDetails.getModel();
        model.setRowCount(0); // Clear the existing table data
        
        while(rs.next()){
            Object[] row = new Object[10]; // 10 columns are selected from the database
            row[0] = rs.getInt("VEHICLE_ID");
            row[1] = rs.getString("MODEL");
            row[2] = rs.getString("COMPANY");
            row[3] = rs.getInt("MILEAGE");
            row[4] = rs.getString("COLOUR");
            row[5] = rs.getInt("YEAR");
            row[6] = rs.getBigDecimal("SELLING_PRICE");
            row[7] = rs.getString("SELLER_PHONE");
            row[8] = rs.getString("SELLER_NAME"); // Seller Name
             // Seller Phone
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(VehicleDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
}

  private void fetchSelectedRowData() {
    int row = TableDetails.getSelectedRow();
    if (row != -1) {
        try {
            // Get data from the selected row
            int vehicleId = Integer.parseInt(TableDetails.getValueAt(row, 0).toString());
            String model = TableDetails.getValueAt(row, 1).toString();
            String company = TableDetails.getValueAt(row, 2).toString();
            int mileage = Integer.parseInt(TableDetails.getValueAt(row, 3).toString());
            String color = TableDetails.getValueAt(row, 4).toString();
            int year = Integer.parseInt(TableDetails.getValueAt(row, 5).toString());
            BigDecimal price = (BigDecimal) TableDetails.getValueAt(row, 6);
            
            // Set the data to the text fields
            modelfield.setText(model);
            companyfield.setText(company);
            mileagefield.setText(String.valueOf(mileage));
            colorfield.setText(color);
            yearfield.setText(String.valueOf(year));
            sprice.setText(price.toString());
            veh_id.setText(String.valueOf(vehicleId));
            
            // Retrieve additional data from the database
            String vehicleQuery = "SELECT VIN, PURCHASE_PRICE, WAREHOUSE_ID FROM VEHICLE WHERE VEHICLE_ID = ?";
            pat = conn.prepareStatement(vehicleQuery);
            pat.setInt(1, vehicleId);
            ResultSet vehicleResult = pat.executeQuery();
            
            if (vehicleResult.next()) {
                String vinValue = vehicleResult.getString("VIN");
                BigDecimal purchasePrice = vehicleResult.getBigDecimal("PURCHASE_PRICE");
                int warehouseIdValue = vehicleResult.getInt("WAREHOUSE_ID");
                
                vin.setText(vinValue);
                pprice.setText(purchasePrice.toString());
                warehouseid.setText(String.valueOf(warehouseIdValue));
            }
            
            String sellerQuery = "SELECT RESELLER_ID, NAME, PHONE FROM RESELLER WHERE VEHICLE_ID = ?";
            pat = conn.prepareStatement(sellerQuery);
            pat.setInt(1, vehicleId);
            ResultSet sellerResult = pat.executeQuery();
            
            if (sellerResult.next()) {
                int sellerId = sellerResult.getInt("RESELLER_ID");
                String sellerName = sellerResult.getString("NAME");
                String sellerPhone = sellerResult.getString("PHONE");
                
                sellerid.setText(String.valueOf(sellerId));
                sellername.setText(sellerName);
                sellerphone.setText(sellerPhone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

// Inside the constructor or initialization method where you set up the MouseListener

   private void insertData() {
    try {
        // Insert data into VEHICLE table
        String insertVehicleQuery = "INSERT INTO VEHICLE (VEHICLE_ID, COMPANY, TYPE, MILEAGE, COLOUR, VIN, MODEL, YEAR, STATUS, PURCHASE_PRICE, SELLING_PRICE, WAREHOUSE_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pat = conn.prepareStatement(insertVehicleQuery);
        pat.setInt(1, Integer.parseInt(veh_id.getText()));
        pat.setString(2, companyfield.getText());
        pat.setString(3, vehicleType);
        pat.setInt(4, Integer.parseInt(mileagefield.getText()));
        pat.setString(5, colorfield.getText());
        pat.setString(6, vin.getText());
        pat.setString(7, modelfield.getText());
        pat.setInt(8, Integer.parseInt(yearfield.getText()));
        pat.setString(9, "AVAILABLE");
        pat.setBigDecimal(10, new BigDecimal(pprice.getText()));
        pat.setBigDecimal(11, new BigDecimal(sprice.getText()));
        pat.setInt(12, Integer.parseInt(warehouseid.getText()));

        pat.executeUpdate();

        // Insert data into RESELLER table
        String insertResellerQuery = "INSERT INTO RESELLER (RESELLER_ID, VEHICLE_ID, NAME, PHONE) VALUES (?, ?, ?, ?)";
        pat = conn.prepareStatement(insertResellerQuery);
        pat.setInt(1, Integer.parseInt(sellerid.getText())); // Convert text to int
        pat.setInt(2, Integer.parseInt(veh_id.getText()));
        pat.setString(3, sellername.getText());
        pat.setString(4, sellerphone.getText());

        int rowsAffected = pat.executeUpdate();

        if (rowsAffected > 0) {
         JOptionPane.showMessageDialog(null, "Data inserted into RESELLER successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to insert data into RESELLER!");
        }

        JOptionPane.showMessageDialog(null, "Data inserted successfully!");
        
        // Reload table data
        loadData(vehicleType);
    } catch (SQLException ex) {
        ex.printStackTrace(); // Print the stack trace of the exception
        JOptionPane.showMessageDialog(null, "Error: Failed to insert data. See console for details.");
    }
}
private void updateData() {
    try {
        // Update data in VEHICLE table
        String updateVehicleQuery = "UPDATE VEHICLE SET VIN=?, COMPANY=?, MODEL=?, MILEAGE=?, COLOUR=?, YEAR=?, PURCHASE_PRICE=? WHERE VEHICLE_ID=?";
        pat = conn.prepareStatement(updateVehicleQuery);
        pat.setString(1, vin.getText());
        pat.setString(2, companyfield.getText());
        pat.setString(3, modelfield.getText());
        pat.setInt(4, Integer.parseInt(mileagefield.getText()));
        pat.setString(5, colorfield.getText());
        pat.setInt(6, Integer.parseInt(yearfield.getText()));
        pat.setBigDecimal(7, new BigDecimal(pprice.getText()));
        pat.setInt(8, Integer.parseInt(veh_id.getText()));
        
        pat.executeUpdate();
        
        // Update data in RESELLER table
        String updateResellerQuery = "UPDATE RESELLER SET NAME=?, PHONE=? WHERE VEHICLE_ID=?";
        pat = conn.prepareStatement(updateResellerQuery);
        pat.setString(1, sellername.getText());
        pat.setString(2, sellerphone.getText());
        pat.setInt(3, Integer.parseInt(veh_id.getText()));
        
        pat.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Data updated successfully!");
        
        // Reload data into the table after updating
        loadData(vehicleType);
    } catch (SQLException ex) {
        Logger.getLogger(VehicleDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// Method to delete data from both VEHICLE and RESELLER tables
private void deleteData() {
    try {
        int vehicleId = Integer.parseInt(veh_id.getText());
        
        // Delete data from RESELLER table
        String deleteResellerQuery = "DELETE FROM RESELLER WHERE VEHICLE_ID=?";
        pat = conn.prepareStatement(deleteResellerQuery);
        pat.setInt(1, vehicleId);
        pat.executeUpdate();
        
        // Delete data from VEHICLE table
        String deleteVehicleQuery = "DELETE FROM VEHICLE WHERE VEHICLE_ID=?";
        pat = conn.prepareStatement(deleteVehicleQuery);
        pat.setInt(1, vehicleId);
        pat.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Data deleted successfully!");
        loadData(vehicleType);
    } catch (SQLException ex) {
        Logger.getLogger(VehicleDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// Method to clear fields in the form
private void clearFields() {
    companyfield.setText("");
    mileagefield.setText("");
    colorfield.setText("");
    vin.setText("");
    modelfield.setText("");
    yearfield.setText("");
    pprice.setText("");
    sprice.setText("");
    veh_id.setText("");
    sellername.setText("");
    sellerphone.setText("");
    warehouseid.setText("");
    sellerid.setText("");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        vin = new javax.swing.JTextField();
        modelfield = new javax.swing.JTextField();
        companyfield = new javax.swing.JTextField();
        mileagefield = new javax.swing.JTextField();
        yearfield = new javax.swing.JTextField();
        sprice = new javax.swing.JTextField();
        pprice = new javax.swing.JTextField();
        colorfield = new javax.swing.JTextField();
        insertbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        sellername = new javax.swing.JTextField();
        sellerphone = new javax.swing.JTextField();
        warehouseid = new javax.swing.JTextField();
        veh_id = new javax.swing.JTextField();
        sellerid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDetails = new javax.swing.JTable();
        executesearch = new javax.swing.JTextField();
        combosearch = new javax.swing.JComboBox<>();
        searchbutton = new javax.swing.JButton();
        Dashboard2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        Home2 = new javax.swing.JLabel();
        CurrentVehicle2 = new javax.swing.JLabel();
        BuyVehicle2 = new javax.swing.JLabel();
        Services2 = new javax.swing.JLabel();
        Staff2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        warehouse2 = new javax.swing.JLabel();
        client2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registration ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Model");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mileage");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Company");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Colour");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Year");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Purchase Price");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Selling Price");

        vin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vinActionPerformed(evt);
            }
        });

        companyfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyfieldActionPerformed(evt);
            }
        });

        pprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppriceActionPerformed(evt);
            }
        });

        colorfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorfieldActionPerformed(evt);
            }
        });

        insertbutton.setBackground(new java.awt.Color(0, 0, 51));
        insertbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        insertbutton.setForeground(new java.awt.Color(255, 255, 255));
        insertbutton.setText("Insert");
        insertbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertbuttonMouseClicked(evt);
            }
        });
        insertbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbuttonActionPerformed(evt);
            }
        });

        updatebutton.setBackground(new java.awt.Color(0, 0, 51));
        updatebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updatebutton.setForeground(new java.awt.Color(255, 255, 255));
        updatebutton.setText("Update");
        updatebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebuttonMouseClicked(evt);
            }
        });
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        clearbutton.setBackground(new java.awt.Color(0, 0, 51));
        clearbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearbutton.setForeground(new java.awt.Color(255, 255, 255));
        clearbutton.setText("Clear");
        clearbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearbuttonMouseClicked(evt);
            }
        });
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        deletebutton.setBackground(new java.awt.Color(0, 0, 51));
        deletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletebutton.setForeground(new java.awt.Color(255, 255, 255));
        deletebutton.setText("Delete");
        deletebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletebuttonMouseClicked(evt);
            }
        });
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        sellername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellernameActionPerformed(evt);
            }
        });

        sellerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selleridActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Seller Name");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Seller Phone");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Warehouse ID");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Seller ID");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Vehicle ID");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(sellername, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(colorfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(vin)
                                        .addComponent(companyfield, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pprice, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sellerid, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sellerphone, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sprice, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mileagefield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(310, 310, 310))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(modelfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(warehouseid, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(veh_id, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(vin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modelfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mileagefield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(companyfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(colorfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sprice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(pprice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sellerphone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sellername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellerid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warehouseid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(veh_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        TableDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vehicle ID", "Model", "Company", "Mileage", "Colour", "Year", "Price", "Contact", "Seller"
            }
        ));
        TableDetails.getTableHeader().setReorderingAllowed(false);
        TableDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDetails);

        executesearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executesearchActionPerformed(evt);
            }
        });

        combosearch.setBackground(new java.awt.Color(255, 102, 51));
        combosearch.setForeground(new java.awt.Color(255, 255, 255));
        combosearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seller", "Model", "Company", "Mileage", "Colour", "Year", "Reg ID", "Contact" }));
        combosearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosearchActionPerformed(evt);
            }
        });

        searchbutton.setText("Search");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(combosearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(executesearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchbutton)
                .addGap(147, 147, 147))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combosearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(executesearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchbutton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Dashboard2.setBackground(new java.awt.Color(255, 102, 51));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Welcome!");

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

        Staff2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Staff2.setForeground(new java.awt.Color(255, 255, 255));
        Staff2.setText("Staff");
        Staff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Staff2MouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DashUser.png"))); // NOI18N

        warehouse2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        warehouse2.setForeground(new java.awt.Color(255, 255, 255));
        warehouse2.setText("Warehouse");
        warehouse2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                warehouse2MouseClicked(evt);
            }
        });

        client2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        client2.setForeground(new java.awt.Color(255, 255, 255));
        client2.setText("Client");
        client2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                client2MouseClicked(evt);
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
                                    .addComponent(Home2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(warehouse2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(client2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 36, Short.MAX_VALUE))))
                    .addGroup(Dashboard2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dashboard2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(Dashboard2Layout.createSequentialGroup()
                .addGroup(Dashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Dashboard2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Staff2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Dashboard2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Dashboard2Layout.setVerticalGroup(
            Dashboard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(45, 45, 45)
                .addComponent(Home2)
                .addGap(49, 49, 49)
                .addComponent(CurrentVehicle2)
                .addGap(47, 47, 47)
                .addComponent(BuyVehicle2)
                .addGap(41, 41, 41)
                .addComponent(Services2)
                .addGap(38, 38, 38)
                .addComponent(warehouse2)
                .addGap(45, 45, 45)
                .addComponent(client2)
                .addGap(34, 34, 34)
                .addComponent(Staff2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vinActionPerformed

    private void companyfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyfieldActionPerformed

    private void ppriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppriceActionPerformed

    private void colorfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorfieldActionPerformed

    private void insertbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertbuttonActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void insertbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertbuttonMouseClicked
        // TODO add your handling code here:
        insertData();
    }//GEN-LAST:event_insertbuttonMouseClicked

    private void updatebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebuttonMouseClicked
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_updatebuttonMouseClicked

    private void clearbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbuttonMouseClicked
        // TODO add your handling code here:
        clearFields();
        
    }//GEN-LAST:event_clearbuttonMouseClicked

    private void deletebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletebuttonMouseClicked
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_deletebuttonMouseClicked

    private void TableDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDetailsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableDetailsMouseClicked

    private void executesearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executesearchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_executesearchActionPerformed

    private void combosearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combosearchActionPerformed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void sellernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellernameActionPerformed

    private void selleridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selleridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selleridActionPerformed

    private void Home2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home2MouseClicked
        // TODO add your handling code here:
        Home homeFrame = new Home();
        homeFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Home2MouseClicked

    private void CurrentVehicle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentVehicle2MouseClicked
        // TODO add your handling code here:
        Vehicle currentVehicleFrame = new Vehicle();
        currentVehicleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_CurrentVehicle2MouseClicked

    private void BuyVehicle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuyVehicle2MouseClicked
        // TODO add your handling code here:
        Transactions buyvehicleframe=new Transactions();
        buyvehicleframe.setVisible(true);
        dispose();
    }//GEN-LAST:event_BuyVehicle2MouseClicked

    private void Services2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Services2MouseClicked
        // TODO add your handling code here:
        Services servicesFrame = new Services();
        servicesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Services2MouseClicked

    private void Staff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Staff2MouseClicked
        // TODO add your handling code here:
        Staff employeesFrame = new Staff();
        employeesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_Staff2MouseClicked

    private void warehouse2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warehouse2MouseClicked
        // TODO add your handling code here:
        Warehouse WarehouseFrame = new Warehouse();
        WarehouseFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_warehouse2MouseClicked

    private void client2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client2MouseClicked
        // TODO add your handling code here:
        Client CustomerFrame = new Client();
        CustomerFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_client2MouseClicked

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
            java.util.logging.Logger.getLogger(VehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            VehicleDetails carDetails = new VehicleDetails("Car");
            carDetails.setVisible(true); // Make the frame visible
            
            VehicleDetails bikeDetails = new VehicleDetails("Bike");
            bikeDetails.setVisible(true); // Make the frame visible
            
            VehicleDetails scooterDetails = new VehicleDetails("Scooter");
            scooterDetails.setVisible(true); // Make the frame visible
            
            VehicleDetails truckDetails = new VehicleDetails("Truck");
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
    private javax.swing.JLabel Staff2;
    private javax.swing.JTable TableDetails;
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel client2;
    private javax.swing.JTextField colorfield;
    private javax.swing.JComboBox<String> combosearch;
    private javax.swing.JTextField companyfield;
    private javax.swing.JButton deletebutton;
    private javax.swing.JTextField executesearch;
    private javax.swing.JButton insertbutton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mileagefield;
    private javax.swing.JTextField modelfield;
    private javax.swing.JTextField pprice;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField sellerid;
    private javax.swing.JTextField sellername;
    private javax.swing.JTextField sellerphone;
    private javax.swing.JTextField sprice;
    private javax.swing.JButton updatebutton;
    private javax.swing.JTextField veh_id;
    private javax.swing.JTextField vin;
    private javax.swing.JLabel warehouse2;
    private javax.swing.JTextField warehouseid;
    private javax.swing.JTextField yearfield;
    // End of variables declaration//GEN-END:variables
}
