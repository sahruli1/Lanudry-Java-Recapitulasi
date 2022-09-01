
package pelayanan;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;


public class CucianBelumSelesai extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
    
    public CucianBelumSelesai() {
        initComponents();
        datatable();
        tbl();
        setLocationRelativeTo(this);
    }

    protected void datatable() {
        
        Object[] Baris = {"ID PELANGGAN","ID TRANSAKSI","NAMA","NO TELPON","BERAT","LAYANAN","TANGGAL MASUK","HARGA","PEMBAYARAN","TRANSAKSI","TANGGAL KELUAR"};
        tabmode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabmode);
        String sql = "select*from t_transaksi_cuci join t_pelanggan where t_transaksi_cuci.id_pelanggan = t_pelanggan.id_pelanggan and status_transaksi = 'On Process'";
        
        try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    Object[] o = new Object[14];
                    o [0] = hasil.getString("id_pelanggan");
                    o [1] = hasil.getString("id_transaksi_cuci");
                    o [2] = hasil.getString("nama");
                    o [3] = hasil.getString("no_telp");                   
                    o [4] = hasil.getInt("berat");
                    o [5] = hasil.getString("layanan");
                    o [6] = hasil.getString("tanggal_masuk");
                    o [7] = hasil.getInt("harga");
                    o [8] = hasil.getString("status_pembayaran");
                    o [9] = hasil.getString("status_transaksi");
                    o [10] = hasil.getString("tanggal_keluar");

                  
                    tabmode.addRow(o);
                    
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
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
        jTable1.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(10).setCellRenderer(centerRenderer); 
         
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        uWPButton6 = new javaswingdev.uwp.UWPButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(597, 438));

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
        jScrollPane1.setViewportView(jTable1);

        uWPButton6.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton6.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton6.setText("Belum Selesai");
        uWPButton6.setBorderPainted(false);
        uWPButton6.setBorderSize(0);
        uWPButton6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        uWPButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(uWPButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(uWPButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uWPButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton6ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_uWPButton6ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CucianBelumSelesai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javaswingdev.uwp.UWPButton uWPButton6;
    // End of variables declaration//GEN-END:variables
}
