
package Administrator;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
        Connect();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Heading = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        AAddress = new javax.swing.JTextField();
        AEmail = new javax.swing.JTextField();
        AContact = new javax.swing.JTextField();
        Register = new javax.swing.JButton();
        Fname = new javax.swing.JLabel();
        Lname = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        Contact = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Passowrd = new javax.swing.JLabel();
        ARUsername = new javax.swing.JTextField();
        ARPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        AName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Phone Number");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Heading.setBackground(new java.awt.Color(0, 0, 0));
        Heading.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin  Register");

        javax.swing.GroupLayout HeadingLayout = new javax.swing.GroupLayout(Heading);
        Heading.setLayout(HeadingLayout);
        HeadingLayout.setHorizontalGroup(
            HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeadingLayout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
        );
        HeadingLayout.setVerticalGroup(
            HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeadingLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(Heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1002, -1));

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel1.add(empid, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 137, 230, 31));

        AAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AAddressActionPerformed(evt);
            }
        });
        jPanel1.add(AAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 230, 31));

        AEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEmailActionPerformed(evt);
            }
        });
        jPanel1.add(AEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 230, 31));

        AContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AContactActionPerformed(evt);
            }
        });
        jPanel1.add(AContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 230, 31));

        Register.setBackground(new java.awt.Color(0, 0, 0));
        Register.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        jPanel1.add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 548, 100, 40));

        Fname.setBackground(new java.awt.Color(255, 255, 255));
        Fname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Fname.setText("Name");
        jPanel1.add(Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 80, 31));

        Lname.setBackground(new java.awt.Color(255, 255, 255));
        Lname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Lname.setText("Address");
        jPanel1.add(Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 80, 31));

        Address.setBackground(new java.awt.Color(255, 255, 255));
        Address.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Address.setText("Email");
        jPanel1.add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 70, 31));

        Contact.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Contact.setText("Contact");
        jPanel1.add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 70, 31));

        Username.setBackground(new java.awt.Color(255, 255, 255));
        Username.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Username.setText("User Name");
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 90, 31));

        Passowrd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Passowrd.setText("Password");
        jPanel1.add(Passowrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 90, -1));

        ARUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(ARUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 434, 230, 31));

        ARPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(ARPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 500, 230, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Go back to login");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, -1, -1));

        AName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANameActionPerformed(evt);
            }
        });
        jPanel1.add(AName, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 195, 230, 31));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Emp ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 60, 31));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fin.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1000, 580));

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

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void ARUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ARUsernameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ARUsernameActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        // TODO add your handling code here:
        int em_pid = Integer.parseInt(empid.getText());
        String name=AName.getText();
        String address=AAddress.getText();
        String email=AEmail.getText();
        String contact=AContact.getText();
        String role = "Admin";
        int transaction=0;
        String user=ARUsername.getText();
        String pass=new String(ARPassword.getPassword());
        
        try {
            pat = conn.prepareStatement("INSERT INTO employee (EMPLOYEE_ID, NAME,ADDRESS, EMAIL,PHONE,TRANSACTION_COUNT,ROLE,USERNAME,PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
           pat.setInt(1, em_pid);
            pat.setString(2, name);
            pat.setString(3, address);
            pat.setString(4, email);
            pat.setString(5, contact);
            pat.setInt(6, transaction);
            pat.setString(7, role);
            pat.setString(8, user);
            pat.setString(9, pass);

             int k = pat.executeUpdate();
            if (k == 1) {
              JOptionPane.showMessageDialog(this, "Registration Successful");
                empid.setText("");
                AAddress.setText("");
                AEmail.setText("");
                 AContact.setText("");
                ARUsername.setText("");
                ARPassword.setText("");
            } else {
              JOptionPane.showMessageDialog(this, "Registration Failed");
            }
        } catch (SQLException ex) {
         Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_RegisterActionPerformed

    private void AContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AContactActionPerformed

    private void ARPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ARPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ARPasswordActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void AAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AAddressActionPerformed

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void AEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AEmailActionPerformed

    private void ANameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANameActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AAddress;
    private javax.swing.JTextField AContact;
    private javax.swing.JTextField AEmail;
    private javax.swing.JTextField AName;
    private javax.swing.JPasswordField ARPassword;
    private javax.swing.JTextField ARUsername;
    private javax.swing.JLabel Address;
    private javax.swing.JLabel Contact;
    private javax.swing.JLabel Fname;
    private javax.swing.JPanel Heading;
    private javax.swing.JLabel Lname;
    private javax.swing.JLabel Passowrd;
    private javax.swing.JButton Register;
    private javax.swing.JLabel Username;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
