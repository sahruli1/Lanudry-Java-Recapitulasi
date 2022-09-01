
package Form;

import static Form.Dashboard.uWPButton10;
import static Form.Dashboard.uWPButton12;
import static Form.Dashboard.uWPButton13;
import static Form.Dashboard.uWPButton4;
import static Form.Dashboard.uWPButton5;
import static Form.Dashboard.uWPButton6;
import static Form.Dashboard.uWPButton7;
import static Form.Dashboard.uWPButton8;
import static Form.Dashboard.uWPButton9;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import koneksi.koneksi;


public class Login extends javax.swing.JFrame {
Dashboard a;

    
    public Login() {
        initComponents();
         setLocationRelativeTo(this);
         a= new Dashboard();
         a.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        ey1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uWPButton3 = new javaswingdev.uwp.UWPButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_clothes_line_120px.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_clothes_line_120px.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel1.setkGradientFocus(1300);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Silahkan Masukan Username dan Pasword Anda");
        kGradientPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 34));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        user.setBackground(new java.awt.Color(51, 255, 153));
        user.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 153)));
        user.setOpaque(false);
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        kGradientPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 192, 30));

        pw.setBackground(new java.awt.Color(51, 255, 153));
        pw.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        pw.setForeground(new java.awt.Color(255, 255, 255));
        pw.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 153)));
        pw.setOpaque(false);
        kGradientPanel1.add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 192, 30));

        ey1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ey1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_blind_15px.png"))); // NOI18N
        ey1.setDoubleBuffered(true);
        ey1.setFocusTraversalPolicyProvider(true);
        ey1.setIconTextGap(5);
        ey1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ey1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ey1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ey1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ey1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ey1MouseReleased(evt);
            }
        });
        ey1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ey1PropertyChange(evt);
            }
        });
        kGradientPanel1.add(ey1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 20, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        uWPButton3.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton3.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton3.setText("Login");
        uWPButton3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        uWPButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton3ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(uWPButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 190, 28));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_shutdown_32px.png"))); // NOI18N
        jLabel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 40, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void jLabel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel3AncestorAdded
        // TODO add your handling code here:
    
    }//GEN-LAST:event_jLabel3AncestorAdded

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      int ok = JOptionPane.showConfirmDialog(this, "Yakin Ingin Keluar?","",JOptionPane.OK_CANCEL_OPTION);
      if(ok==0){
      System.exit(0);  
      }
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void ey1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ey1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ey1MouseClicked

    private void ey1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ey1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ey1MouseEntered

    private void ey1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ey1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ey1MouseExited

    private void ey1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ey1MousePressed
        // TODO add your handling code here:
     
        ey1.setVisible(false);
        pw.setEchoChar((char)0);
    }//GEN-LAST:event_ey1MousePressed

    private void ey1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ey1MouseReleased
        // TODO add your handling code here:
        
        ey1.setVisible(true);
        pw.setEchoChar('*');
    }//GEN-LAST:event_ey1MouseReleased

    private void ey1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ey1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_ey1PropertyChange

    private void uWPButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton3ActionPerformed
    if(user.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Username Tidak Boleh Kosong","Gagal Login",JOptionPane.WARNING_MESSAGE);
    }else if(pw.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Password Tidak Boleh Kosong","Gagal Login",JOptionPane.WARNING_MESSAGE);
    }else
        try {
            Connection conn = new koneksi().connect();
            Statement stat = conn.createStatement();
            
            //sql utk login
                ResultSet rs = stat.executeQuery ("select * from pengguna  where username ='"+user.getText()+"'"
                +"and password='"+pw.getText()+"'");
              
             
            rs.last();
            
            
            if (rs.getRow()==1) {
               
                
                String ak = rs.getString("jabatan");
                if(ak.equals("pemilik")) {
                    JOptionPane.showMessageDialog(null,"Login Berhasil Sebagai Pemilik");
                    a.setVisible(true);
                    uWPButton9.setVisible(true);
                    uWPButton7.setVisible(true);
                    uWPButton4.setVisible(true);
                    uWPButton8.setVisible(true);
                    uWPButton10.setVisible(true);
                    uWPButton12.setVisible(false);
                    uWPButton6.setVisible(false);
                    uWPButton4.setVisible(false);
                    uWPButton5.setVisible(false);
                    uWPButton13.setVisible(true);
                    
                    
                }else{ if(ak.equals("karyawan")) {
                    JOptionPane.showMessageDialog(null,"Login Berhasil Sebagai karyawan");
                    a.setVisible(true);
                    uWPButton9.setVisible(false);
                    uWPButton7.setVisible(false);
                    uWPButton8.setVisible(false);
                    uWPButton10.setVisible(false);
                    uWPButton12.setVisible(false);
                    uWPButton6.setVisible(true);
                    uWPButton4.setVisible(true);
                    uWPButton5.setVisible(true);
                    uWPButton13.setVisible(false);
                    
                    
                }else{ if(ak.equals("admin")) {
                    JOptionPane.showMessageDialog(null,"Login Berhasil Sebagai admin");
                    a.setVisible(true);
                    uWPButton9.setVisible(false);
                    uWPButton7.setVisible(false);
                    uWPButton8.setVisible(false);
                    uWPButton10.setVisible(false);
                    uWPButton12.setVisible(true);
                    uWPButton6.setVisible(true);
                    uWPButton4.setVisible(true);
                    uWPButton5.setVisible(true);
                    uWPButton13.setVisible(false);
                }
                }
                }
                this.dispose();
            }else {
                   JOptionPane.showMessageDialog(this,"Ada Kesalahan Pada Username/Password","Gagal Login",JOptionPane.ERROR_MESSAGE);
                   user.setText("");
                   pw.setText("");
                
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_uWPButton3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ey1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPasswordField pw;
    private javaswingdev.uwp.UWPButton uWPButton3;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
