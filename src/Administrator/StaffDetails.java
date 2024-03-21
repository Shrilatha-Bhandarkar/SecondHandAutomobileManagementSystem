/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrator;
import FirstPage.OpenPage;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StaffDetails extends javax.swing.JFrame {
    private String staffType; 
    
    public StaffDetails(String staffType) {
        initComponents();
        this.staffType = staffType; 
        Connect();
        loadEmployeeDetails(staffType);
        
         staff.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = staff.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) staff.getModel();
                
                
                empid.setText(model.getValueAt(selectedRow, 0).toString());
                name.setText(model.getValueAt(selectedRow, 1).toString());
                address.setText(model.getValueAt(selectedRow, 2).toString());
                email.setText(model.getValueAt(selectedRow, 3).toString());
                phone.setText(model.getValueAt(selectedRow, 4).toString());
                transactioncount.setText(model.getValueAt(selectedRow, 5).toString());
                
                
                // Load vehicle details for the selected employee
                loadVehicleDetails(empid.getText());
            }
        }
    }
});
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

      private void loadEmployeeDetails(String staffType) {
    try {
        String query = "SELECT * FROM employee WHERE role = ?";
        pat = conn.prepareStatement(query);
        pat.setString(1, staffType);
        rs = pat.executeQuery();

        DefaultTableModel model = (DefaultTableModel) staff.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            Object[] row = {
                    rs.getString("EMPLOYEE_ID"),
                    rs.getString("NAME"),
                    rs.getString("ADDRESS"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE"),
                    rs.getString("TRANSACTION_COUNT")
            };
            model.addRow(row);
        }

        // Add a list selection listener to the table
        ListSelectionModel selectionModel = staff.getSelectionModel();
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = staff.getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        String employeeId = (String) staff.getValueAt(selectedRow, 0);
                        String usernameValue = "";
                        String passwordValue = "";

                        String credentialsQuery = "SELECT USERNAME, PASSWORD FROM employee WHERE EMPLOYEE_ID = ?";
                        pat = conn.prepareStatement(credentialsQuery);
                        pat.setString(1, employeeId);
                        ResultSet credentialsResult = pat.executeQuery();

                        
                        if (credentialsResult.next()) {
                            usernameValue = credentialsResult.getString("USERNAME");
                            passwordValue = credentialsResult.getString("PASSWORD");
                        }

                        username.setText(usernameValue);
                        password.setText(passwordValue);
                    } catch (SQLException ex) {
                        ex.printStackTrace(); 
                    }
                }
            }
        });

    } catch (SQLException ex) {
        Logger.getLogger(StaffDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void loadVehicleDetails(String staffType) {
    try {
        String transactionQuery = "SELECT VEHICLE_ID FROM TRANSACTION WHERE EMPLOYEE_ID = ?";
        pat = conn.prepareStatement(transactionQuery);
        pat.setString(1, staffType);
        rs = pat.executeQuery();

        DefaultTableModel model = (DefaultTableModel) vehicle.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            String regNo = rs.getString("VEHICLE_ID");
            Object[] row = { regNo };
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(StaffDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void updateEmployee() {
    // Retrieve data from input fields
    String employeeIdValue = empid.getText();
    String nameValue = name.getText();
    String addressValue = address.getText();
    String emailValue = email.getText();
    String phoneValue = phone.getText();
    String transactionCountValue = transactioncount.getText();
    String user = username.getText();
    String pass = password.getText();
    
    try {
       
        String query = "UPDATE employee SET NAME=?, ADDRESS=?, EMAIL=?, PHONE=?, TRANSACTION_COUNT=?,USERNAME=?,PASSWORD=? WHERE EMPLOYEE_ID=?";
        pat = conn.prepareStatement(query);
        pat.setString(1, nameValue);
        pat.setString(2, addressValue);
        pat.setString(3, emailValue);
        pat.setString(4, phoneValue);
        pat.setString(5, transactionCountValue);
        pat.setString(6, user);
        pat.setString(7, pass);
        pat.setString(8, employeeIdValue);
        
        int rowsAffected = pat.executeUpdate();
        if (rowsAffected > 0) {
            loadEmployeeDetails(staffType);
            JOptionPane.showMessageDialog(this, "Updated successfully.");
        } else {
        }
    } catch (SQLException ex) {
        Logger.getLogger(StaffDetails.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void deleteEmployee() {
    String employeeIdValue = empid.getText();

    try {
        String query = "DELETE FROM employee WHERE EMPLOYEE_ID=?";
        pat = conn.prepareStatement(query);
        pat.setString(1, employeeIdValue);

        int rowsAffected = pat.executeUpdate();
       if (rowsAffected > 0) {
    loadEmployeeDetails(staffType);
        JOptionPane.showMessageDialog(this, "Employee deleted successfully.");
        } else {
          JOptionPane.showMessageDialog(this, "Failed to delete employee. Please try again.");
        }

    } catch (SQLException ex) {
        Logger.getLogger(StaffDetails.class.getName()).log(Level.SEVERE, null, ex);
      
    }
}

// Method to clear all input fields
private void clearFields() {
    // Clear all input fields
    empid.setText("");
    name.setText("");
    address.setText("");
    email.setText("");
    phone.setText("");
    transactioncount.setText("");
    username.setText("");
    password.setText("");
}
private void insertEmployee() {
    // Retrieve data from input fields
    String employeeIdValue = empid.getText();
    String nameValue = name.getText();
    String addressValue = address.getText();
    String emailValue = email.getText();
    String phoneValue = phone.getText();
    String transactionCountValue = transactioncount.getText();
    String usernameValue = username.getText();
    String passwordValue = password.getText();

    try {
        // Construct the SQL query for inserting employee details
        String query = "INSERT INTO EMPLOYEE (EMPLOYEE_ID, NAME, ADDRESS, EMAIL, PHONE, TRANSACTION_COUNT, ROLE, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pat = conn.prepareStatement(query);
        pat.setString(1, employeeIdValue);
        pat.setString(2, nameValue);
        pat.setString(3, addressValue);
        pat.setString(4, emailValue);
        pat.setString(5, phoneValue);
        pat.setString(6, transactionCountValue);
        pat.setString(7, staffType); // Use the provided staffType directly
        pat.setString(8, usernameValue);
        pat.setString(9, passwordValue);

        int rowsAffected = pat.executeUpdate();
        if (rowsAffected > 0) {
            loadEmployeeDetails(staffType);
            JOptionPane.showMessageDialog(this, "Employee inserted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to insert employee. Please try again.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(StaffDetails.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        staff = new javax.swing.JTable();
        empid = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        transactioncount = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        vehicle = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        Insert1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        employeebtnclicked = new javax.swing.JButton();
        adminbtnclick = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Home = new javax.swing.JLabel();
        CurrentVehicle = new javax.swing.JLabel();
        BuyVehicle = new javax.swing.JLabel();
        Services = new javax.swing.JLabel();
        Staff = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        warehouse = new javax.swing.JLabel();
        client = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setText("Staff");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        staff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Address", "Email", "Phone", "Transaction count"
            }
        ));
        jScrollPane1.setViewportView(staff);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 713, 299));
        jPanel6.add(empid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 192, 34));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel6.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 192, 34));
        jPanel6.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 192, 30));

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel6.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 192, 30));
        jPanel6.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 192, 32));

        transactioncount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactioncountActionPerformed(evt);
            }
        });
        jPanel6.add(transactioncount, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 192, 32));
        jPanel6.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 192, 30));
        jPanel6.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 570, 192, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Employee ID");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 120, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Name");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 60, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Address");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 68, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Email");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 68, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Phone");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Transaction count");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("User name");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 580, 86, -1));

        vehicle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Register No"
            }
        ));
        jScrollPane2.setViewportView(vehicle);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 126, 299));

        delete.setBackground(new java.awt.Color(0, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel6.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, 100, 40));

        update.setBackground(new java.awt.Color(0, 0, 0));
        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel6.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 690, 90, 40));

        clear.setBackground(new java.awt.Color(0, 0, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Clear");
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });
        jPanel6.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 690, 90, 40));

        Insert1.setBackground(new java.awt.Color(0, 0, 0));
        Insert1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Insert1.setForeground(new java.awt.Color(255, 255, 255));
        Insert1.setText("Insert");
        Insert1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Insert1MouseClicked(evt);
            }
        });
        jPanel6.add(Insert1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 690, 100, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Change Role to:-");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, -1, -1));

        employeebtnclicked.setBackground(new java.awt.Color(0, 0, 0));
        employeebtnclicked.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeebtnclicked.setForeground(new java.awt.Color(255, 255, 255));
        employeebtnclicked.setText("Employee");
        employeebtnclicked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeebtnclickedMouseClicked(evt);
            }
        });
        jPanel6.add(employeebtnclicked, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, -1, -1));

        adminbtnclick.setBackground(new java.awt.Color(0, 0, 0));
        adminbtnclick.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        adminbtnclick.setForeground(new java.awt.Color(255, 255, 255));
        adminbtnclick.setText("Admin");
        adminbtnclick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminbtnclickMouseClicked(evt);
            }
        });
        jPanel6.add(adminbtnclick, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 640, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/BGN3.jpg"))); // NOI18N
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 900, 720));

        Dashboard.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Welcome!");

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

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ID.png"))); // NOI18N

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signout.png"))); // NOI18N
        jLabel12.setText("Sign Out");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
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
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Staff, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
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
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void transactioncountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactioncountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactioncountActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

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

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        OpenPage open=new OpenPage();
        open.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
        updateEmployee();
    }//GEN-LAST:event_updateMouseClicked

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_clearMouseClicked

    private void Insert1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Insert1MouseClicked
        // TODO add your handling code here:
        insertEmployee();
    }//GEN-LAST:event_Insert1MouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        deleteEmployee();
    }//GEN-LAST:event_deleteMouseClicked

    private void adminbtnclickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminbtnclickMouseClicked
        // TODO add your handling code here:
        int selectedRow = staff.getSelectedRow();
    if (selectedRow != -1) {
        try {
            // Get the employee ID of the selected row
            String employeeId = (String) staff.getValueAt(selectedRow, 0);
            
            // Construct the SQL query to update the role to ADMIN
            String query = "UPDATE EMPLOYEE SET ROLE = 'ADMIN' WHERE EMPLOYEE_ID = ?";
            pat = conn.prepareStatement(query);
            pat.setString(1, employeeId);
            
            // Execute the update query
            int rowsAffected = pat.executeUpdate();
            if (rowsAffected > 0) {
                loadEmployeeDetails(staffType);
                JOptionPane.showMessageDialog(this, "Role updated to ADMIN successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update role to ADMIN.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDetails.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row first.");
    }
    }//GEN-LAST:event_adminbtnclickMouseClicked

    private void employeebtnclickedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeebtnclickedMouseClicked
        // TODO add your handling code here:
       int selectedRow = staff.getSelectedRow();
    if (selectedRow != -1) {
        try {
            // Get the employee ID of the selected row
            String employeeId = (String) staff.getValueAt(selectedRow, 0);
            
            // Construct the SQL query to update the role to EMPLOYEE
            String query = "UPDATE EMPLOYEE SET ROLE = 'EMPLOYEE' WHERE EMPLOYEE_ID = ?";
            pat = conn.prepareStatement(query);
            pat.setString(1, employeeId);
            
            // Execute the update query
            int rowsAffected = pat.executeUpdate();
            if (rowsAffected > 0) {
                // If update is successful, reload employee details
                loadEmployeeDetails(staffType);
                JOptionPane.showMessageDialog(this, "Role updated to EMPLOYEE successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update role to EMPLOYEE.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDetails.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row first.");
    }
    }//GEN-LAST:event_employeebtnclickedMouseClicked

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
            java.util.logging.Logger.getLogger(StaffDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            StaffDetails empDetails = new StaffDetails("Employee");
            empDetails.setVisible(true); // Make the frame visible
            
            StaffDetails adminDetails = new StaffDetails("Admin");
            adminDetails .setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuyVehicle;
    private javax.swing.JLabel CurrentVehicle;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JLabel Home;
    private javax.swing.JButton Insert1;
    private javax.swing.JLabel Services;
    private javax.swing.JLabel Staff;
    private javax.swing.JTextField address;
    private javax.swing.JButton adminbtnclick;
    private javax.swing.JButton clear;
    private javax.swing.JLabel client;
    private javax.swing.JButton delete;
    private javax.swing.JTextField email;
    private javax.swing.JTextField empid;
    private javax.swing.JButton employeebtnclicked;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JTextField phone;
    private javax.swing.JTable staff;
    private javax.swing.JTextField transactioncount;
    private javax.swing.JButton update;
    private javax.swing.JTextField username;
    private javax.swing.JTable vehicle;
    private javax.swing.JLabel warehouse;
    // End of variables declaration//GEN-END:variables
}
