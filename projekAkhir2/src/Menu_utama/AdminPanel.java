/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_utama;

import java.awt.Color;
import javax.swing.JFrame;
import projek_latih2.admin;
import Database.Database;
import Method.JOption;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author asus
 */
public class AdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminPanel
     */
    private final JFrame frame;
    Database db = new Database();
    private final Home home = new Home();
    public AdminPanel(JFrame frame) {
        this.frame = frame;
        initComponents();
        
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
        
        jPanel1.setOpaque(false);
        jPanel1.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        custom1 = new palette.PanelCustom();
        tx_username = new javax.swing.JTextField();
        tx_pass = new javax.swing.JTextField();
        lb_labelbiasa = new javax.swing.JLabel();
        bt_loginuser = new javax.swing.JLabel();
        bt_login = new rojerusan.RSMaterialButtonRectangle();
        lb_Fieldusername = new javax.swing.JLabel();
        lb_Fieldpass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.CardLayout());

        custom1.setBackground(new java.awt.Color(1, 4, 32));
        custom1.setRoundBottomLeft(20);
        custom1.setRoundBottomRight(20);
        custom1.setRoundTopLeft(20);
        custom1.setRoundTopright(20);
        custom1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tx_username.setBackground(new java.awt.Color(217, 217, 217));
        tx_username.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        tx_username.setText("Username");
        tx_username.setToolTipText("");
        tx_username.setBorder(null);
        tx_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tx_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tx_usernameFocusLost(evt);
            }
        });
        tx_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_usernameActionPerformed(evt);
            }
        });
        custom1.add(tx_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 250, 30));

        tx_pass.setBackground(new java.awt.Color(217, 217, 217));
        tx_pass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        tx_pass.setText("Password");
        tx_pass.setBorder(null);
        tx_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tx_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tx_passFocusLost(evt);
            }
        });
        custom1.add(tx_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 250, 30));

        lb_labelbiasa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lb_labelbiasa.setForeground(new java.awt.Color(255, 255, 255));
        lb_labelbiasa.setText("Please login ");
        custom1.add(lb_labelbiasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 112, -1, -1));

        bt_loginuser.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        bt_loginuser.setForeground(new java.awt.Color(217, 217, 217));
        bt_loginuser.setText("Login as user");
        bt_loginuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_loginuserMouseClicked(evt);
            }
        });
        custom1.add(bt_loginuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        bt_login.setBackground(new java.awt.Color(217, 217, 217));
        bt_login.setForeground(new java.awt.Color(0, 0, 0));
        bt_login.setText("LOGIN");
        bt_login.setToolTipText("");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        custom1.add(bt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 240, 50));

        lb_Fieldusername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/textFieldicon.png"))); // NOI18N
        custom1.add(lb_Fieldusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        lb_Fieldpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/textFieldicon.png"))); // NOI18N
        custom1.add(lb_Fieldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Cancel_3.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        custom1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, -1));

        jPanel1.add(custom1, "card2");

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loginuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_loginuserMouseClicked
       jPanel1.removeAll();
       jPanel1.add(new LoginPanel(frame));
       jPanel1.repaint();
       jPanel1.revalidate();
    }//GEN-LAST:event_bt_loginuserMouseClicked

    private void tx_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tx_usernameFocusGained
        String username = tx_username.getText();
        if(username.equals("Username")){
            tx_username.setText("");
        }
    }//GEN-LAST:event_tx_usernameFocusGained

    private void tx_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tx_usernameFocusLost
        String username=tx_username.getText();
        if(username.equals("") || username.equals("Username")){
            tx_username.setText("Username");
        }
    }//GEN-LAST:event_tx_usernameFocusLost

    private void tx_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tx_passFocusGained
        String pass = tx_pass.getText();
        if(pass.equals("Password")){
            tx_pass.setText("");
        }
    }//GEN-LAST:event_tx_passFocusGained

    private void tx_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tx_passFocusLost
        String pass=tx_pass.getText();
        if(pass.equals("") || pass.equals("Password")){
            tx_pass.setText("Password");
        }
    }//GEN-LAST:event_tx_passFocusLost

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        
        /*
        Dipake ketika password is incorrect / misal nama tidak ditemukan
        
        JOption msg = new JOption();
        msg.warning(this, "Sorry, username or password is incorrect");
        */
        
        if (db.loginDB(tx_username.getText(), tx_pass.getText()) == 1){
            try {
                admin frameadmin = new admin(home);
                frameadmin.setVisible(true);
                frameadmin.revalidate();
                
                frame.dispose();
                
                frame.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (db.loginDB(tx_username.getText(), tx_pass.getText()) == 0){
            JOption msg = new JOption();
            msg.warning(this, "Sorry, admin or password is incorrect");
        }

        
    }//GEN-LAST:event_bt_loginActionPerformed

    private void tx_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_usernameActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        frame.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle bt_login;
    private javax.swing.JLabel bt_loginuser;
    private palette.PanelCustom custom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_Fieldpass;
    private javax.swing.JLabel lb_Fieldusername;
    private javax.swing.JLabel lb_labelbiasa;
    private javax.swing.JTextField tx_pass;
    private javax.swing.JTextField tx_username;
    // End of variables declaration//GEN-END:variables
}
