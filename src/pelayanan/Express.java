/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelayanan;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
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



public class Express extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
String playanan;
int harga;
int berat;
   
    public Express() {
        initComponents();
        datatable();
        tanggalNow();
        tbl();
        cari();
    }
    private void tanggalNow(){
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date_masuk.setDateFormatString("dd/MM/yyyy");
        date_masuk.setDate(date);
        date_keluar.setDateFormatString("dd/MM/yyyy");
        date_keluar.setDate(date);
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
        t_regular.getColumnModel().getColumn(13).setCellRenderer(centerRenderer);
        t_regular.getColumnModel().getColumn(14).setCellRenderer(centerRenderer); 
        t_regular.getColumnModel().getColumn(15).setCellRenderer(centerRenderer);
       
        
  }
    
    protected void datatable() {
        
        Object[] Baris = {"ID PELANGGAN","ID TRANSAKSI","NAMA","JENIS KELAMIN","NO TELPON","ALAMAT","BERAT","KETERANGAN","LAYANAN","TANGGAL MASUK","HARGA","PEMBAYARAN","JML BAYAR","KEMBALI","TRANSAKSI","TANGGAL KELUAR"};
        tabmode = new DefaultTableModel(null, Baris);
        t_regular.setModel(tabmode);
        String sql = "select*from t_transaksi_cuci join t_pelanggan where t_transaksi_cuci.id_pelanggan = t_pelanggan.id_pelanggan";
        
        try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    Object[] o = new Object[16];
                    o [0] = hasil.getString("id_pelanggan");
                    o [1] = hasil.getString("id_transaksi_cuci");
                    o [2] = hasil.getString("nama");
                    o [3] = hasil.getString("jenis_kelamin");
                    o [4] = hasil.getString("no_telp");
                    o [5] = hasil.getString("alamat");
                    o [6] = hasil.getInt("berat");
                    o [7] = hasil.getString("keterangan");
                    o [8] = hasil.getString("layanan");
                    o [9] = hasil.getString("tanggal_masuk");
                    o [10] = hasil.getInt("harga");
                    o [11] = hasil.getString("status_pembayaran");
                    o [12] = hasil.getInt("jml_bayar");
                    o [13] = hasil.getInt("kembali");
                    o [14] = hasil.getString("status_transaksi");
                    o [15] = hasil.getString("tanggal_keluar");

                  
                    tabmode.addRow(o);
                    tbl();
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
        }
    } 
    
    private void cari(){
        Object[] Baris = {"ID PELANGGAN","ID TRANSAKSI","NAMA","JENIS KELAMIN","NO TELPON","ALAMAT","BERAT","KETERANGAN","LAYANAN","TANGGAL MASUK","HARGA","PEMBAYARAN","JML BAYAR","KEMBALI","TRANSAKSI","TANGGAL KELUAR"};
        tabmode = new DefaultTableModel(null, Baris);
        t_regular.setModel(tabmode);
        
        String sql = "SELECT * from t_transaksi_cuci join t_pelanggan where t_transaksi_cuci.id_pelanggan = t_pelanggan.id_pelanggan and id_transaksi_cuci LIKE'"+txt_idpel1.getText()+"%'";
        try{
            java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    Object[] o = new Object[16];
                    o [0] = hasil.getString("id_pelanggan");
                    o [1] = hasil.getString("id_transaksi_cuci");
                    o [2] = hasil.getString("nama");
                    o [3] = hasil.getString("jenis_kelamin");
                    o [4] = hasil.getString("no_telp");
                    o [5] = hasil.getString("alamat");
                    o [6] = hasil.getInt("berat");
                    o [7] = hasil.getString("keterangan");
                    o [8] = hasil.getString("layanan");
                    o [9] = hasil.getString("tanggal_masuk");
                    o [10] = hasil.getInt("harga");
                    o [11] = hasil.getString("status_pembayaran");
                    o [12] = hasil.getInt("jml_bayar");
                    o [13] = hasil.getInt("kembali");
                    o [14] = hasil.getString("status_transaksi");
                    o [15] = hasil.getString("tanggal_keluar");


                  
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
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txt_Berat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_Harga = new javax.swing.JTextField();
        date_masuk = new com.toedter.calendar.JDateChooser();
        ComboStatusTransaksi = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        ComboStatusBayar = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_regular = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        date_keluar = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        uWPButton6 = new javaswingdev.uwp.UWPButton();
        uWPButton3 = new javaswingdev.uwp.UWPButton();
        uWPButton4 = new javaswingdev.uwp.UWPButton();
        jLabel16 = new javax.swing.JLabel();
        clayanan = new javax.swing.JComboBox<>();
        cblayanan = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txt_idpel1 = new javax.swing.JTextField();
        uWPButton7 = new javaswingdev.uwp.UWPButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ket = new javax.swing.JTextArea();
        txt_Berat1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_Berat2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel1.setkGradientFocus(1300);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 102));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(950, 527));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Data Cucian");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Berat (Kg)");

        txt_Berat.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tanggal Masuk");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total Harga (Rp)");

        txt_Harga.setEditable(false);
        txt_Harga.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        date_masuk.setForeground(new java.awt.Color(255, 255, 255));
        date_masuk.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        ComboStatusTransaksi.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        ComboStatusTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        ComboStatusTransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "On Process", "Selesai" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Status Transaksi");

        ComboStatusBayar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        ComboStatusBayar.setForeground(new java.awt.Color(255, 255, 255));
        ComboStatusBayar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Lunas", "Lunas" }));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status Pembayaran");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Controls");

        t_regular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
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
        t_regular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_regularMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_regular);

        txt_idpel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Id Transaksi");

        date_keluar.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tanggal Keluar");

        uWPButton6.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton6.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton6.setText("Ubah");
        uWPButton6.setBorderPainted(false);
        uWPButton6.setBorderSize(0);
        uWPButton6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton6ActionPerformed(evt);
            }
        });

        uWPButton3.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton3.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton3.setText("Hapus");
        uWPButton3.setBorderPainted(false);
        uWPButton3.setBorderSize(0);
        uWPButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton3ActionPerformed(evt);
            }
        });

        uWPButton4.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton4.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton4.setText("Hitung");
        uWPButton4.setBorderPainted(false);
        uWPButton4.setBorderSize(0);
        uWPButton4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Pelayanan");

        clayanan.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        clayanan.setForeground(new java.awt.Color(255, 255, 255));
        clayanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Layanan", "Reguler", "Express", "Kilat" }));
        clayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clayananActionPerformed(evt);
            }
        });

        cblayanan.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cblayanan.setForeground(new java.awt.Color(255, 255, 255));
        cblayanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-PILIH-", "Reguler", "Express", "Kilat" }));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Cari Transaksi");

        txt_idpel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_idpel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idpel1ActionPerformed(evt);
            }
        });
        txt_idpel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idpel1KeyReleased(evt);
            }
        });

        uWPButton7.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton7.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton7.setText("Cetak Struk");
        uWPButton7.setBorderPainted(false);
        uWPButton7.setBorderSize(0);
        uWPButton7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton7ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Keterangan");

        ket.setColumns(20);
        ket.setRows(5);
        jScrollPane2.setViewportView(ket);

        txt_Berat1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_Berat1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Berat1KeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Jumlah Bayar");

        txt_Berat2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Kembalian");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uWPButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(uWPButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txt_idpel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uWPButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(0, 82, Short.MAX_VALUE))
                                            .addComponent(txt_idpel, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(cblayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(txt_Berat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(date_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(txt_Berat1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20)
                                            .addComponent(txt_Berat2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ComboStatusTransaksi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ComboStatusBayar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane2)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(date_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(jLabel15)))
                                    .addComponent(clayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(ComboStatusBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel19))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel15))
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(date_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_Berat2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel16))
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_idpel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cblayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_Berat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_Berat1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ComboStatusTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel20))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(date_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uWPButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uWPButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_idpel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(uWPButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(2, 2, 2))
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_regularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_regularMouseClicked
        // TODO add your handling code here:
        int bar = t_regular.getSelectedRow();
      
        String b = tabmode.getValueAt(bar,1).toString();
       
        String g = tabmode.getValueAt(bar,6).toString();
        
        String h = tabmode.getValueAt(bar,7).toString();
        String i = tabmode.getValueAt(bar,8).toString();
        String j = tabmode.getValueAt(bar,10).toString();
        String k = tabmode.getValueAt(bar,11).toString();
        String l = tabmode.getValueAt(bar,12).toString();
        String m = tabmode.getValueAt(bar,13).toString();
        String n = tabmode.getValueAt(bar,14).toString();

            
       
            
      
        txt_idpel.setText(b);
        txt_Berat.setText(g);
        ket.setText(h);
        cblayanan.setSelectedItem(i);
        
      
        txt_Harga.setText(j);
        ComboStatusBayar.setSelectedItem(k);
        txt_Berat1.setText(l);
        txt_Berat2.setText(m);
        ComboStatusTransaksi.setSelectedItem(n);
      
       
        tbl();
        
    }//GEN-LAST:event_t_regularMouseClicked

    private void uWPButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton6ActionPerformed
        // TODO add your handling code here:
        if (ComboStatusBayar.getSelectedItem()=="Belum Lunas" && ComboStatusTransaksi.getSelectedItem()=="Selesai") {
        JOptionPane.showMessageDialog(this,"Tekan tombol update untuk ubah status lunas!","Notification",JOptionPane.WARNING_MESSAGE);    
    }else{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date_masuk.setDateFormatString("dd/MM/yyyy");
        date_keluar.setDateFormatString("dd/MM/yyyy");
        String strdate = dateFormat.format(date_masuk.getDate());
        String strdatek = dateFormat.format(date_keluar.getDate());
        String id_pel = txt_idpel.getText();
        String weight = txt_Berat.getText();
        String k_terangan = ket.getText();
        int berat = Integer.parseInt(weight);
        String cost = txt_Harga.getText();
        int harga = Integer.parseInt(cost);
        String jml = txt_Berat1.getText();
        int jmlh = Integer.parseInt(jml);
        String kem = txt_Berat2.getText();
        int kemb = Integer.parseInt(kem);
        
        String layanan = cblayanan.getSelectedItem().toString();
        String statusbayar = ComboStatusBayar.getSelectedItem().toString();
        String statustransaksi = ComboStatusTransaksi.getSelectedItem().toString();
            try {
               
                

                String query2 = "UPDATE t_transaksi_cuci SET berat=?, keterangan=?, layanan=?, tanggal_masuk=?, harga=?, status_pembayaran=?,jml_bayar=?, kembali=?, status_transaksi=?, tanggal_keluar = ? WHERE id_transaksi_cuci = ?";
                PreparedStatement statement2 = (PreparedStatement) conn.prepareStatement(query2);
                
                statement2.setInt(1, berat);
                statement2.setString(2, k_terangan);
                statement2.setString(3, layanan);
                statement2.setString(4, strdate);
                statement2.setInt(5, harga);
                statement2.setString(6, statusbayar);
                statement2.setInt(7, jmlh);
                statement2.setInt(8, kemb);
                statement2.setString(9, statustransaksi);
                statement2.setString(10, strdatek);
                statement2.setString(11, id_pel);
                
               
                statement2.executeUpdate();
                tbl();
                datatable();
                cari();
                JOptionPane.showMessageDialog(this, "Berhasil Menambahkan!", "Success", JOptionPane.PLAIN_MESSAGE);
             
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Gagal Menambahkan! " + ex, "Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_uWPButton6ActionPerformed

    private void uWPButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton3ActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(this, "Hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0) {
            String sql = "delete from t_transaksi_cuci where id_transaksi_cuci = '"+txt_idpel.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(this,"Data Berhasil Di Hapus");
                
                txt_idpel.requestFocus();
                datatable();
                tbl();
                cari();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Data Gagal Di Hapus"+e);
            }
        }
    }//GEN-LAST:event_uWPButton3ActionPerformed

    private void uWPButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton4ActionPerformed
        // TODO add your handling code here:
      if(cblayanan.getSelectedIndex()==1){
                
                String kg, cost;
                int berat, harga;
                kg = txt_Berat.getText();
                berat = Integer.parseInt(kg);
                harga = berat*6500;
                cost = String.valueOf(harga);
                txt_Harga.setText(cost);
      } else if(cblayanan.getSelectedIndex()==2){
                
                String kg, cost;
                int berat, harga;
                kg = txt_Berat.getText();
                berat = Integer.parseInt(kg);
                harga = berat*8000;
                cost = String.valueOf(harga);
                txt_Harga.setText(cost);
      }else if(cblayanan.getSelectedIndex()==3){
              
                String kg, cost;
                int berat, harga;
                kg = txt_Berat.getText();
                berat = Integer.parseInt(kg);
                harga = berat*10000;
                cost = String.valueOf(harga);
                txt_Harga.setText(cost);
      }
     
        /*try{
            String str = txt_Berat.getText();
            if (str.length()==0) {
                JOptionPane.showMessageDialog(this,"Isi berat terlebih dahulu!","Notification",JOptionPane.WARNING_MESSAGE);
            }else{
                String kg, cost;
                int berat, harga;
                kg = txt_Berat.getText();
                berat = Integer.parseInt(kg);
                harga = berat*10000;

                cost = String.valueOf(harga);
                txt_Harga.setText(cost);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Inputan harus angka!","Notification",JOptionPane.WARNING_MESSAGE);
        }*/
    }//GEN-LAST:event_uWPButton4ActionPerformed

    private void clayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clayananActionPerformed
        Object[] Baris = {"ID PELANGGAN","ID TRANSAKSI","NAMA","JENIS KELAMIN","NO TELPON","ALAMAT","BERAT","KETERANGAN","LAYANAN","TANGGAL MASUK","HARGA","PEMBAYARAN","JML BAYAR","KEMBALI","TRANSAKSI","TANGGAL KELUAR"};
        tabmode = new DefaultTableModel(null, Baris);
        t_regular.setModel(tabmode);
        String sql = "select*from t_transaksi_cuci join t_pelanggan where  t_transaksi_cuci.id_pelanggan = t_pelanggan.id_pelanggan and layanan like '%"+clayanan.getSelectedItem()+ "'";

        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                Object[] o = new Object[16];
                    o [0] = hasil.getString("id_pelanggan");
                    o [1] = hasil.getString("id_transaksi_cuci");
                    o [2] = hasil.getString("nama");
                    o [3] = hasil.getString("jenis_kelamin");
                    o [4] = hasil.getString("no_telp");
                    o [5] = hasil.getString("alamat");
                    o [6] = hasil.getInt("berat");
                    o [7] = hasil.getString("keterangan");
                    o [8] = hasil.getString("layanan");
                    o [9] = hasil.getString("tanggal_masuk");
                    o [10] = hasil.getInt("harga");
                    o [11] = hasil.getString("status_pembayaran");
                    o [12] = hasil.getInt("jml_bayar");
                    o [13] = hasil.getInt("kembali");
                    o [14] = hasil.getString("status_transaksi");
                    o [15] = hasil.getString("tanggal_keluar");

                tabmode.addRow(o);
                tbl();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_clayananActionPerformed

    private void txt_idpel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idpel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idpel1ActionPerformed

    private void uWPButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton7ActionPerformed
        try{

            String namaFile = "src/Laporan/struk.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            parameter.put("id_transaksi",txt_idpel1.getText());
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter,conn);

            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_uWPButton7ActionPerformed

    private void txt_idpel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idpel1KeyReleased
      if (txt_idpel1.getText().isEmpty()) {
            datatable();
        }else{
            cari();
            
        }
    }//GEN-LAST:event_txt_idpel1KeyReleased

    private void txt_Berat1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Berat1KeyReleased
         
        
          try{
             
                String kg, cost,jml;
                int berat, harga,jml1;
                
                kg = txt_Harga.getText();
                berat = Integer.parseInt(kg);
                jml = txt_Berat1.getText();
                jml1 = Integer.parseInt(jml);
                harga = jml1-berat;

                cost = String.valueOf(harga);
                txt_Berat2.setText(cost);
           
        }catch(NumberFormatException e){
           
        }
     
    }//GEN-LAST:event_txt_Berat1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboStatusBayar;
    private javax.swing.JComboBox<String> ComboStatusTransaksi;
    private javax.swing.JComboBox<String> cblayanan;
    private javax.swing.JComboBox<String> clayanan;
    private com.toedter.calendar.JDateChooser date_keluar;
    private com.toedter.calendar.JDateChooser date_masuk;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextArea ket;
    private javax.swing.JTable t_regular;
    private javax.swing.JTextField txt_Berat;
    private javax.swing.JTextField txt_Berat1;
    private javax.swing.JTextField txt_Berat2;
    private javax.swing.JTextField txt_Harga;
    public static final javax.swing.JTextField txt_idpel = new javax.swing.JTextField();
    private javax.swing.JTextField txt_idpel1;
    private javaswingdev.uwp.UWPButton uWPButton3;
    private javaswingdev.uwp.UWPButton uWPButton4;
    private javaswingdev.uwp.UWPButton uWPButton6;
    private javaswingdev.uwp.UWPButton uWPButton7;
    // End of variables declaration//GEN-END:variables
}
