/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Employee;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ERegister extends javax.swing.JFrame {

    
    public ERegister() {
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
            Logger.getLogger(ERegister.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            Logger.getLogger(ERegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Heading = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        Register = new javax.swing.JButton();
        Username = new javax.swing.JLabel();
        Passowrd = new javax.swing.JLabel();
        ERUsername = new javax.swing.JTextField();
        ERPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        veriuser = new javax.swing.JTextField();
        verify = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        veripass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Heading.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee Register");

        javax.swing.GroupLayout HeadingLayout = new javax.swing.GroupLayout(Heading);
        Heading.setLayout(HeadingLayout);
        HeadingLayout.setHorizontalGroup(
            HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadingLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeadingLayout.setVerticalGroup(
            HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadingLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(Heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 969, -1));

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel1.add(empid, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 183, 31));

        Register.setBackground(new java.awt.Color(0, 0, 0));
        Register.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        jPanel1.add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 485, 98, 31));

        Username.setBackground(new java.awt.Color(255, 255, 255));
        Username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Username.setText("User Name");
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, 31));

        Passowrd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Passowrd.setText("Password");
        jPanel1.add(Passowrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 70, -1));

        ERUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ERUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(ERUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 183, 31));

        ERPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ERPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(ERPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 183, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Go back to login");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 534, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Emp ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 31));
        jPanel1.add(veriuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 180, 30));

        verify.setBackground(new java.awt.Color(0, 0, 0));
        verify.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        verify.setForeground(new java.awt.Color(255, 255, 255));
        verify.setText("Verify");
        verify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verifyMouseClicked(evt);
            }
        });
        jPanel1.add(verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));
        jPanel1.add(veripass, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 170, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fin.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 970, 530));

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

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        // TODO add your handling code here:
        String eempid = empid.getText();
    String user = ERUsername.getText();
    String pass = new String(ERPassword.getPassword());

    try {
        pat = conn.prepareStatement("UPDATE employee SET username = ?, password = ? WHERE employee_id = ?");
        pat.setString(1, user);
        pat.setString(2, pass);
        pat.setString(3, eempid);

        int k = pat.executeUpdate();
        if (k == 1) {
            JOptionPane.showMessageDialog(this, "Update Successful");
            empid.setText("");
            ERUsername.setText("");
            ERPassword.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Update Failed");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ERegister.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_RegisterActionPerformed

    private void ERUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ERUsernameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ERUsernameActionPerformed

    private void ERPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ERPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ERPasswordActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        ELogin login = new ELogin();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void verifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifyMouseClicked
        // TODO add your handling code here:
        String eempid = empid.getText();
    String user = veriuser.getText();
    String pass = new String(veripass.getPassword());

    try {
        pat = conn.prepareStatement("SELECT * FROM employee WHERE employee_id = ? AND username = ? AND password = ?");
        pat.setString(1, eempid);
        pat.setString(2, user);
        pat.setString(3, pass);

        rs = pat.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Verification Successful");
            
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ERegister.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pat != null) pat.close();
        } catch (SQLException ex) {
            Logger.getLogger(ERegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    }//GEN-LAST:event_verifyMouseClicked

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
            java.util.logging.Logger.getLogger(ERegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ERegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ERegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ERegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ERegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ERPassword;
    private javax.swing.JTextField ERUsername;
    private javax.swing.JPanel Heading;
    private javax.swing.JLabel Passowrd;
    private javax.swing.JButton Register;
    private javax.swing.JLabel Username;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton verify;
    private javax.swing.JPasswordField veripass;
    private javax.swing.JTextField veriuser;
    // End of variables declaration//GEN-END:variables
}
