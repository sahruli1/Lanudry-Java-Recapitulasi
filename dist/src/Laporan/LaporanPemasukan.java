/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laporan;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sahruli nur rizki
 */
public class LaporanPemasukan extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
    
    public LaporanPemasukan() {
        initComponents();
        datatable();
        tbl();
        cari();
        Locale locale = new Locale ("id","ID");
        Locale.setDefault(locale);
    }
    

    public void tbl(){
      
     DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
     centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
      
      
        t_regular.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(4).setCellRenderer(centerRenderer); 
        t_regular.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(10).setCellRenderer(centerRenderer); 
        t_regular.getColumnModel().getColumn(11).setCellRenderer(centerRenderer); 
        t_regular.getColumnModel().getColumn(12).setCellRenderer(centerRenderer); 
  }
    
    protected void datatable() {
        
        Object[] Baris = {"ID PELANGGAN","ID TRANSAKSI","NAMA","JENIS KELAMIN","NO TELPON","ALAMAT","BERAT","LAYANAN","TGL MASUK","HARGA","PEMBAYARAN","TRANSAKSI","TGL KELUAR"};
        tabmode = new DefaultTableModel(null, Baris);
        t_regular.setModel(tabmode);
        String sql = "select*from t_transaksi_cuci join t_pelanggan where t_transaksi_cuci.id_pelanggan = t_pelanggan.id_pelanggan and status_pembayaran = 'Lunas'";
        
        try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    Object[] o = new Object[14];
                    o [0] = hasil.getString("id_pelanggan");
                    o [1] = hasil.getString("id_transaksi_cuci");
                    o [2] = hasil.getString("nama");
                    o [3] = hasil.getString("jenis_kelamin");
                    o [4] = hasil.getString("no_telp");
                    o [5] = hasil.getString("alamat");
                    o [6] = hasil.getInt("berat");
                    o [7] = hasil.getString("layanan");
                    o [8] = hasil.getString("tanggal_masuk");
                    o [9] = hasil.getInt("harga");
                    o [10] = hasil.getString("status_pembayaran");
                    o [11] = hasil.getString("status_transaksi");
                    o [12] = hasil.getString("tanggal_keluar");

                  
                    tabmode.addRow(o);
                    tbl();
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void cari(){
        Object[] Baris ={"ID PELANGGAN","ID TRANSAKSI","NAMA","JENIS KELAMIN","NO TELPON","ALAMAT","BERAT","LAYANAN","TGL MASUK","HARGA","PEMBAYARAN","TRANSAKSI","TGL KELUAR"};
        tabmode = new DefaultTableModel(null, Baris);
        t_regular.setModel(tabmode);
        
        String sql = "select*from t_transaksi_cuci join t_pelanggan where t_transaksi_cuci.id_pelanggan = t_pelanggan.id_pelanggan and status_pembayaran = 'Lunas' and nama LIKE'" +tcari.getText()+"%'";
        try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    Object[] o = new Object[14];
                    o [0] = hasil.getString("id_pelanggan");
                    o [1] = hasil.getString("id_transaksi_cuci");
                    o [2] = hasil.getString("nama");
                    o [3] = hasil.getString("jenis_kelamin");
                    o [4] = hasil.getString("no_telp");
                    o [5] = hasil.getString("alamat");
                    o [6] = hasil.getInt("berat");
                    o [7] = hasil.getString("layanan");
                    o [8] = hasil.getString("tanggal_masuk");
                    o [9] = hasil.getInt("harga");
                    o [10] = hasil.getString("status_pembayaran");
                    o [11] = hasil.getString("status_transaksi");
                    o [12] = hasil.getString("tanggal_keluar");

                  
                    tabmode.addRow(o);
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
        jLabel13 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        uWPButton5 = new javaswingdev.uwp.UWPButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_regular = new javax.swing.JTable();
        tcari = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tanggal1 = new com.toedter.calendar.JDateChooser();

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel1.setkGradientFocus(1300);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Laporan Pemasukan");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tanggal");

        tanggal.setForeground(new java.awt.Color(255, 255, 255));

        uWPButton5.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton5.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton5.setText("Cetak Laporan");
        uWPButton5.setBorderPainted(false);
        uWPButton5.setBorderSize(0);
        uWPButton5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        uWPButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton5ActionPerformed(evt);
            }
        });

        t_regular.setBackground(new java.awt.Color(102, 102, 102));
        t_regular.setModel(new javax.swing.table.DefaultTableModel(
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
        t_regular.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                t_regularAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        t_regular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_regularMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_regular);

        tcari.setForeground(new java.awt.Color(255, 255, 255));
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cari Transaksi Pemasukan");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sampai");

        tanggal1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tanggal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void uWPButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton5ActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        tanggal.setDateFormatString("dd/MM/yyyy");
        String strdate = dateFormat.format(tanggal.getDate());
        String strdate1 = dateFormat.format(tanggal1.getDate());
        try{

            String namaFile = "src/Laporan/LaporanPemasukan.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            parameter.put("tanggal1",strdate);
            parameter.put("tanggal12",strdate1);
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter,conn);

            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_uWPButton5ActionPerformed

    private void t_regularAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_t_regularAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_t_regularAncestorAdded

    private void t_regularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_regularMouseClicked

    }//GEN-LAST:event_t_regularMouseClicked

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
      if (tcari.getText().isEmpty()) {
            datatable();
        }else{
            cari();
        }
        
    }//GEN-LAST:event_tcariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTable t_regular;
    private com.toedter.calendar.JDateChooser tanggal;
    private com.toedter.calendar.JDateChooser tanggal1;
    private javax.swing.JTextField tcari;
    private javaswingdev.uwp.UWPButton uWPButton5;
    // End of variables declaration//GEN-END:variables
}
