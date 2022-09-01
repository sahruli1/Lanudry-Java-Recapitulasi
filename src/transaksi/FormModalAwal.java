/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;


public class FormModalAwal extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
   
    public FormModalAwal() {
        initComponents();
        datatable();
        tbl();
        autonumber();
        cari();
        kosong();
    }
    
    protected void kosong(){
        modalA.setText("");
        pengeluaran.setText("");
        pendapatan.setText("");
        total.setText("");
        keuntungan.setText("");
        
    }

        private void autonumber(){
         String ID = "MD000";
         int i = 0;
         try{
             
             Statement st = conn.createStatement();
             String sql = "select kd_modal from t_pendapatan";
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
             ID = rs.getString("kd_modal");
             
         }
             ID = ID.substring(2);
             i = Integer.parseInt(ID)+1;
             ID = "00" + i;
             ID = "MD" + ID.substring(ID.length()-3);
             kdmodal.setText(ID);
         }catch (SQLException e){
             System.out.println(e.getMessage());
         }
     }
        
        protected void datatable() {
        
        Object[] Baris = {"KODE","MODAL AWAL","PENGELUARAN","PEMASUKAN","TOTAL","KEUNTUNGAN/KERUGIAN","TANGGAL"};
        tabmode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabmode);
        String sql = "select * from t_pendapatan ";
        
        try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    String a = hasil.getString("kd_modal");
                    String b = hasil.getString("modal_awal");
                    String c = hasil.getString("pengeluaran");
                    String d = hasil.getString("pemasukan");
                    String e = hasil.getString("total");
                    String f = hasil.getString("laba_rugi");
                    String g = hasil.getString("tanggal");

                    String[] data={a,b,c,d,e,f,g};
                    tabmode.addRow(data);
                   tbl();
                }
            } catch (Exception e) {
        }
    }
    
    public void tbl(){
      
     DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
     centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
      
      
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer); 
        jTable1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
  }
    
     private void cari(){
        Object[] Baris = {"KODE","MODAL AWAL","PENGELUARAN","PEMASUKAN","TOTAL","KEUNTUNGAN/KERUGIAN","TANGGAL"};
        tabmode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabmode);
        
        String sql = "SELECT * FROM t_pendapatan WHERE kd_modal LIKE'" +tcari.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    String a = hasil.getString("kd_modal");
                    String b = hasil.getString("modal_awal");
                    String c = hasil.getString("pengeluaran");
                    String d = hasil.getString("pemasukan");
                    String e = hasil.getString("total");
                    String f = hasil.getString("laba_rugi");
                    String g = hasil.getString("tanggal");

                    String[] data={a,b,c,d,e,f,g};
                    tabmode.addRow(data);
                    tbl();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        modalA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pengeluaran = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pendapatan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        keuntungan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        uWPButton6 = new javaswingdev.uwp.UWPButton();
        uWPButton7 = new javaswingdev.uwp.UWPButton();
        uWPButton8 = new javaswingdev.uwp.UWPButton();
        tcari = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        uWPButton10 = new javaswingdev.uwp.UWPButton();
        kdmodal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel1.setkGradientFocus(1300);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Form Keuangan");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Modal Awal");

        modalA.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pengeluaran");

        pengeluaran.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pemasukan");

        pendapatan.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total");

        total.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Keuntungan/kerugian");

        keuntungan.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tanggal");

        tanggal.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        uWPButton6.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton6.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton6.setText("Tambah");
        uWPButton6.setBorderPainted(false);
        uWPButton6.setBorderSize(0);
        uWPButton6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton6ActionPerformed(evt);
            }
        });

        uWPButton7.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton7.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton7.setText("Ubah");
        uWPButton7.setBorderPainted(false);
        uWPButton7.setBorderSize(0);
        uWPButton7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton7ActionPerformed(evt);
            }
        });

        uWPButton8.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton8.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton8.setText("Hapus");
        uWPButton8.setBorderPainted(false);
        uWPButton8.setBorderSize(0);
        uWPButton8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton8ActionPerformed(evt);
            }
        });

        tcari.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tcari.setForeground(new java.awt.Color(255, 255, 255));
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cari Transaksi");

        uWPButton10.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton10.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton10.setText("Hitung");
        uWPButton10.setBorderPainted(false);
        uWPButton10.setBorderSize(0);
        uWPButton10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton10ActionPerformed(evt);
            }
        });

        kdmodal.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Kode Modal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uWPButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(uWPButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(uWPButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(kdmodal, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(total, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pendapatan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modalA, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pengeluaran, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(keuntungan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uWPButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kdmodal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modalA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uWPButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keuntungan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uWPButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uWPButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uWPButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int bar = jTable1.getSelectedRow();
        String a = tabmode.getValueAt(bar,0).toString();
        String b = tabmode.getValueAt(bar,1).toString();
        String c = tabmode.getValueAt(bar,2).toString();
        String d = tabmode.getValueAt(bar,3).toString();
        String e = tabmode.getValueAt(bar,4).toString();
        String f = tabmode.getValueAt(bar,5).toString();
        String g = tabmode.getValueAt(bar,6).toString();

        kdmodal.setText(a);
        modalA.setText(b);
        pengeluaran.setText(c);
        pendapatan.setText(d);
        total.setText(e);
        keuntungan.setText(f);
    }//GEN-LAST:event_jTable1MouseClicked

    private void uWPButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton6ActionPerformed
        String sql = "insert into t_pendapatan values  (?,?,?,?,?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        tanggal.setDateFormatString("dd/MM/yyyy");
        String strdate = dateFormat.format(tanggal.getDate());
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kdmodal.getText());
            stat.setString(2, modalA.getText());
            stat.setString(3, pengeluaran.getText());
            stat.setString(4, pendapatan.getText());
            stat.setString(5, total.getText());
            stat.setString(6, keuntungan.getText());
            stat.setString(7, strdate);

            stat.executeUpdate();
            datatable();
            tbl();
            autonumber();
            kosong();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }

    }//GEN-LAST:event_uWPButton6ActionPerformed

    private void uWPButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton7ActionPerformed
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tanggal.setDateFormatString("dd/MM/yyyy");
            String strdate = dateFormat.format(tanggal.getDate());
            String sql = "update t_pendapatan set kd_modal = ?, modal_awal =?,pengeluaran=?,pemasukan=?, total=?, laba_rugi=?, tanggal= ? where kd_modal='"+kdmodal.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kdmodal.getText());
            stat.setString(2, modalA.getText());
            stat.setString(3, pengeluaran.getText());
            stat.setString(4, pendapatan.getText());
            stat.setString(5, total.getText());
            stat.setString(6, keuntungan.getText());
            stat.setString(7, strdate);
            stat.executeUpdate();
            datatable();
            tbl();
            autonumber();
            kosong();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
         

           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }

    }//GEN-LAST:event_uWPButton7ActionPerformed

    private void uWPButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton8ActionPerformed
        int ok = JOptionPane.showConfirmDialog(this, "Hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0) {
            String sql = "delete from t_pendapatan where kd_modal = '"+kdmodal.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(this,"Data Berhasil Di Hapus");

                modalA.requestFocus();
                datatable();
                tbl();
                autonumber();
                cari();
                kosong();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Data Gagal Di Hapus"+e);
            }
        }
    }//GEN-LAST:event_uWPButton8ActionPerformed

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
    if (tcari.getText().isEmpty()) {
            datatable();
        }else{
            cari();
        }
     
    }//GEN-LAST:event_tcariKeyReleased

    private void uWPButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton10ActionPerformed
        try{
            String str = modalA.getText();
            
            if (str.length()==0) {
                JOptionPane.showMessageDialog(this,"Isi harga dan jumlah terlebih dahulu!","Notification",JOptionPane.WARNING_MESSAGE);
            }else{
                String modal2,pengeluaran2,pendapatan2,total2,keuntungan2,kerugian2;
                int modal1,pengeluaran1,pendapatan1,total1,keuntungan1,kerugian1;
                modal2 = modalA.getText();
                modal1 = Integer.parseInt(modal2);
                pengeluaran2 = pengeluaran.getText();
                pengeluaran1 = Integer.parseInt(pengeluaran2);
                pendapatan2  = pendapatan.getText();
                pendapatan1  = Integer.parseInt(pendapatan2);
               
                
                
                total1 = modal1-pengeluaran1+pendapatan1;
                total2 = String.valueOf(total1);
                total.setText(total2);
                keuntungan1 = total1-modal1;
                keuntungan2 = String.valueOf(keuntungan1);
                keuntungan.setText(keuntungan2);
               
                
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Inputan harus angka!","Notification",JOptionPane.WARNING_MESSAGE);
        }       
    }//GEN-LAST:event_uWPButton10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField kdmodal;
    private javax.swing.JTextField keuntungan;
    private javax.swing.JTextField modalA;
    private javax.swing.JTextField pendapatan;
    private javax.swing.JTextField pengeluaran;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField total;
    private javaswingdev.uwp.UWPButton uWPButton10;
    private javaswingdev.uwp.UWPButton uWPButton6;
    private javaswingdev.uwp.UWPButton uWPButton7;
    private javaswingdev.uwp.UWPButton uWPButton8;
    // End of variables declaration//GEN-END:variables
}
