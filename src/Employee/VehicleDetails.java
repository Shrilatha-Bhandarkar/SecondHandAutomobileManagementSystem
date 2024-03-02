package Employee;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane; 


public class VehicleDetails extends javax.swing.JFrame {
    private String vehicleType; 

    public VehicleDetails(String vehicleType) {
        initComponents();
        this.vehicleType = vehicleType; 
        Connect(); // Connect to the database
        loadData(); // Load data into the table
        TableDetails.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displaySelectedRowData(); // Call method to display selected row data
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
            conn=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","shriBH7497@");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void loadData() {
    // Query to retrieve data for the selected vehicle type
    String query = "SELECT * FROM vehicle WHERE type = ?";

    try {
        // Create a PreparedStatement
        pat = conn.prepareStatement(query);
        // Set the vehicle type parameter
        pat.setString(1, vehicleType);
        // Execute the query
        rs = pat.executeQuery();

        // Set the ResultSet to the table
        DefaultTableModel model = (DefaultTableModel) TableDetails.getModel();
        model.setRowCount(0); // Clear existing data
        while (rs.next()) {
            // Extract data from the ResultSet and add it to the table
            model.addRow(new Object[]{rs.getString("Seller"), rs.getString("Model"), rs.getString("Brand"), rs.getString("Mileage"), rs.getString("Colour"), rs.getInt("Year"), rs.getString("ID"), rs.getString("Phone")});
        }
    } catch (SQLException ex) {
        // Handle SQL exception
        ex.printStackTrace();
    }
}
    
    private void displaySelectedRowData() {
        int selectedRowIndex = TableDetails.getSelectedRow();
        if (selectedRowIndex != -1) { // Check if a row is selected
            sellerfield.setText(TableDetails.getValueAt(selectedRowIndex, 0).toString());
            modelfield.setText(TableDetails.getValueAt(selectedRowIndex, 1).toString());
            companyfield.setText(TableDetails.getValueAt(selectedRowIndex, 2).toString());
            mileagefield.setText(TableDetails.getValueAt(selectedRowIndex, 3).toString());
            colorfield.setText(TableDetails.getValueAt(selectedRowIndex, 4).toString());
            yearfield.setText(TableDetails.getValueAt(selectedRowIndex, 5).toString());
            idfield.setText(TableDetails.getValueAt(selectedRowIndex, 6).toString());
            phonefield.setText(TableDetails.getValueAt(selectedRowIndex, 7).toString());
        }
    }

    private void insertData() {
        String query = "INSERT INTO vehicle (Seller, Model, Brand, Mileage, Colour, Year, ID, Phone, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pat = conn.prepareStatement(query);
            pat.setString(1, sellerfield.getText());
            pat.setString(2, modelfield.getText());
            pat.setString(3, companyfield.getText());
            pat.setString(4, mileagefield.getText());
            pat.setString(5, colorfield.getText());
            pat.setString(6, yearfield.getText());
            pat.setString(7, idfield.getText());
            pat.setString(8, phonefield.getText());
            pat.setString(9, vehicleType);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data inserted successfully.");
            loadData(); // Refresh the table after insertion
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateData() {
        int selectedRowIndex = TableDetails.getSelectedRow();
        if (selectedRowIndex != -1) { // Check if a row is selected
            String query = "UPDATE vehicle SET Seller=?, Model=?, Brand=?, Mileage=?, Colour=?, Year=?, ID=?, Phone=? WHERE ID=?";
            try {
                pat = conn.prepareStatement(query);
                pat.setString(1, sellerfield.getText());
                pat.setString(2, modelfield.getText());
                pat.setString(3, companyfield.getText());
                pat.setString(4, mileagefield.getText());
                pat.setString(5, colorfield.getText());
                pat.setString(6, yearfield.getText());
                pat.setString(7, idfield.getText());
                pat.setString(8, phonefield.getText());
                pat.setString(9, TableDetails.getValueAt(selectedRowIndex, 6).toString()); // Get the ID from the selected row
                pat.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data updated successfully.");
                loadData(); // Refresh the table after update
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
        }
    }

    private void deleteData() {
        int selectedRowIndex = TableDetails.getSelectedRow();
        if (selectedRowIndex != -1) { // Check if a row is selected
            String id = TableDetails.getValueAt(selectedRowIndex, 6).toString(); // Get the ID from the selected row
            String query = "DELETE FROM vehicle WHERE ID=?";
            try {
                pat = conn.prepareStatement(query);
                pat.setString(1, id);
                pat.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data deleted successfully.");
                loadData(); // Refresh the table after deletion
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

    private void clearFields() {
        sellerfield.setText("");
        modelfield.setText("");
        companyfield.setText("");
        mileagefield.setText("");
        colorfield.setText("");
        yearfield.setText("");
        idfield.setText("");
        phonefield.setText("");
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        CurrentVehicle = new javax.swing.JLabel();
        BuyVehicle = new javax.swing.JLabel();
        Services = new javax.swing.JLabel();
        Employees = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDetails = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sellerfield = new javax.swing.JTextField();
        modelfield = new javax.swing.JTextField();
        companyfield = new javax.swing.JTextField();
        mileagefield = new javax.swing.JTextField();
        yearfield = new javax.swing.JTextField();
        phonefield = new javax.swing.JTextField();
        idfield = new javax.swing.JTextField();
        colorfield = new javax.swing.JTextField();
        insertbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));

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
        CurrentVehicle.setText("Current Vehicle");
        CurrentVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CurrentVehicleMouseClicked(evt);
            }
        });

        BuyVehicle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BuyVehicle.setForeground(new java.awt.Color(255, 255, 255));
        BuyVehicle.setText("Buy Vehicle");
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

        Employees.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Employees.setForeground(new java.awt.Color(255, 255, 255));
        Employees.setText("Employees");
        Employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeesMouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/DashUser.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentVehicle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BuyVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Services, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Employees, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 27, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
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
                .addGap(53, 53, 53)
                .addComponent(Services)
                .addGap(46, 46, 46)
                .addComponent(Employees)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));

        TableDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Seller", "Model", "Company", "Mileage", "Colour", "Year", "Reg ID", "Contact"
            }
        ));
        TableDetails.getTableHeader().setReorderingAllowed(false);
        TableDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDetails);

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seller");

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
        jLabel8.setText("RegID");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact");

        sellerfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellerfieldActionPerformed(evt);
            }
        });

        companyfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyfieldActionPerformed(evt);
            }
        });

        idfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfieldActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sellerfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(colorfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(companyfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modelfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mileagefield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearfield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phonefield, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sellerfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mileagefield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(colorfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonefield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(297, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(669, 669, 669))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        CurrentVehicle currentVehicleFrame = new CurrentVehicle();
        currentVehicleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_CurrentVehicleMouseClicked

    private void BuyVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuyVehicleMouseClicked
        // TODO add your handling code here:
        BuyVehicle buyVehicleFrame = new BuyVehicle();
        buyVehicleFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_BuyVehicleMouseClicked

    private void ServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServicesMouseClicked
        // TODO add your handling code here:
        Services servicesFrame = new Services();
        servicesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_ServicesMouseClicked

    private void EmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeesMouseClicked
        // TODO add your handling code here:
        Employees employeesFrame = new Employees();
        employeesFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_EmployeesMouseClicked

    private void sellerfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellerfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellerfieldActionPerformed

    private void companyfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyfieldActionPerformed

    private void idfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfieldActionPerformed

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
    private javax.swing.JLabel BuyVehicle;
    private javax.swing.JLabel CurrentVehicle;
    private javax.swing.JLabel Employees;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel Services;
    private javax.swing.JTable TableDetails;
    private javax.swing.JButton clearbutton;
    private javax.swing.JTextField colorfield;
    private javax.swing.JTextField companyfield;
    private javax.swing.JButton deletebutton;
    private javax.swing.JTextField idfield;
    private javax.swing.JButton insertbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mileagefield;
    private javax.swing.JTextField modelfield;
    private javax.swing.JTextField phonefield;
    private javax.swing.JTextField sellerfield;
    private javax.swing.JButton updatebutton;
    private javax.swing.JTextField yearfield;
    // End of variables declaration//GEN-END:variables
}
