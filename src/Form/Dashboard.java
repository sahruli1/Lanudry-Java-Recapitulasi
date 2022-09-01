
package Form;

import Laporan.LaporanDataPelanggan;
import Laporan.LaporanLabaRugi;
import Laporan.LaporanPemasukan;
import Laporan.LaporanPengeluaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import koneksi.koneksi;
import pelanggan.data_pelanggan;
import pelayanan.CucianBelumSelesai;
import pelayanan.CucianSelesai;
import pelayanan.Express;
import transaksi.FormModalAwal;
import transaksi.Transaksi_pengeluaran;


public class Dashboard extends javax.swing.JFrame {
boolean a = false;
private Connection conn = new koneksi().connect();


    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        count();
        sum();
        sum1();
        cuciselesai();
        cuciproses();
        tanggalrt();
        sum2();
        sum3();
        b3.setVisible(false);
        b2.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);
        b7.setVisible(false);
        b8.setVisible(false);
        b9.setVisible(false);
     
        
        
    }

    public void tanggalrt(){
        java.util.Date tgl = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String tanggal = dateFormat.format(tgl);
        tglskrng.setText(tanggal);
    }
    
    public void count(){
    
    try{
        String sql = "select COUNT(*) AS id_pelanggan FROM t_pelanggan";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            
            int count = rs.getInt("id_pelanggan");
            jLabel3.setText(String.valueOf(count));
        }
        
    }catch (Exception e){
        
    }
}
   
  public void sum(){
    
    try{
        String sql = "select sum(harga) AS harga from t_transaksi_cuci where status_pembayaran = 'Lunas'";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            
            int sum = rs.getInt("harga");
            jLabel6.setText(String.valueOf(sum));
        }
        
    }catch (Exception e){
        
    }
}
  
  
  public void sum2(){
    
    try{
        String sql = "select sum(harga) AS harga from t_transaksi_cuci where status_pembayaran = 'Lunas' and tanggal_keluar = '"+tglskrng.getText()+"'";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            
            int sum = rs.getInt("harga");
            jLabel21.setText(String.valueOf(sum));
        }
        
    }catch (Exception e){
        
    }
}
  

public void cuciselesai(){
    
    try{
        String sql = "select COUNT(status_transaksi) AS status_transaksi from t_transaksi_cuci WHERE status_transaksi = 'Selesai'";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            
            int sum = rs.getInt("status_transaksi");
            jLabel8.setText(String.valueOf(sum));
        }
        
    }catch (Exception e){
        
    }
}  

public void cuciproses(){
    
    try{
        String sql = "select COUNT(status_transaksi) AS status_transaksi from t_transaksi_cuci WHERE status_transaksi = 'On Process'";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            
            int sum = rs.getInt("status_transaksi");
            jLabel10.setText(String.valueOf(sum));
        }
        
    }catch (Exception e){
        
    }
}

public void sum1(){
    
    try{
        String sql = "select sum(total) AS total from t_pengeluaran";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            
            int sum = rs.getInt("total");
            tluar.setText(String.valueOf(sum));
        }
        
    }catch (Exception e){
        
    }
}
   
public void sum3(){
    
    try{
        String sql = "select sum(total) AS total from t_pengeluaran where tanggal = '"+tglskrng.getText()+"'";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            
            int sum = rs.getInt("total");
            tluar1.setText(String.valueOf(sum));
        }
        
    }catch (Exception e){
        
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        PanelHome = new keeptoo.KGradientPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        b3 = new javax.swing.JLabel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel13 = new javax.swing.JLabel();
        b5 = new javax.swing.JLabel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jLabel14 = new javax.swing.JLabel();
        b9 = new javax.swing.JLabel();
        kGradientPanel11 = new keeptoo.KGradientPanel();
        jLabel22 = new javax.swing.JLabel();
        b6 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel12 = new javax.swing.JLabel();
        b2 = new javax.swing.JLabel();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jLabel18 = new javax.swing.JLabel();
        b4 = new javax.swing.JLabel();
        kGradientPanel12 = new keeptoo.KGradientPanel();
        jLabel25 = new javax.swing.JLabel();
        b8 = new javax.swing.JLabel();
        PanelButton = new javax.swing.JPanel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jLabel29 = new javax.swing.JLabel();
        b1 = new javax.swing.JLabel();
        uWPButton11 = new javaswingdev.uwp.UWPButton();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        b7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(51, 204, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Laundry || Kerjakan Apa Yang Harus Di kerjakan");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        panelMenu.setBackground(new java.awt.Color(255, 153, 153));
        panelMenu.setLayout(new java.awt.BorderLayout());

        PanelHome.setkEndColor(new java.awt.Color(0, 51, 51));
        PanelHome.setkGradientFocus(1300);
        PanelHome.setkStartColor(new java.awt.Color(0, 102, 102));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 51, 51));

        jLabel4.setBackground(new java.awt.Color(153, 255, 153));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah Pelanggan");
        jLabel4.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel4ComponentAdded(evt);
            }
        });
        jLabel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel3.setBackground(new java.awt.Color(153, 255, 153));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel3ComponentAdded(evt);
            }
        });
        jLabel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_50px.png"))); // NOI18N

        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(b3)))
                .addGap(1, 1, 1)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        kGradientPanel6.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel6.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel6MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 255, 153));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cucian Selesai");
        jLabel7.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel7ComponentAdded(evt);
            }
        });
        jLabel7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel7AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_paper_plane_50px.png"))); // NOI18N

        jLabel8.setBackground(new java.awt.Color(153, 255, 153));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel8ComponentAdded(evt);
            }
        });
        jLabel8.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel8AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(b5)))
                .addGap(1, 1, 1)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        kGradientPanel8.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel8.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel8MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_washing_machine_50px.png"))); // NOI18N

        jLabel9.setBackground(new java.awt.Color(153, 255, 153));
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cucian Belum Selesai");
        jLabel9.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel9ComponentAdded(evt);
            }
        });
        jLabel9.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel9AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel10.setBackground(new java.awt.Color(153, 255, 153));
        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel10ComponentAdded(evt);
            }
        });
        jLabel10.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel10AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        b9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel8Layout = new javax.swing.GroupLayout(kGradientPanel8);
        kGradientPanel8.setLayout(kGradientPanel8Layout);
        kGradientPanel8Layout.setHorizontalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        kGradientPanel8Layout.setVerticalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel8Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(b9)))
                .addGap(1, 1, 1)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        kGradientPanel11.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel11.setkStartColor(new java.awt.Color(0, 51, 51));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_euro_money_50px.png"))); // NOI18N

        jLabel20.setBackground(new java.awt.Color(153, 255, 153));
        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Pendapatan Harian");
        jLabel20.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel20ComponentAdded(evt);
            }
        });
        jLabel20.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel20AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel21.setBackground(new java.awt.Color(153, 255, 153));
        jLabel21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel21ComponentAdded(evt);
            }
        });
        jLabel21.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel21AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel23.setBackground(new java.awt.Color(153, 255, 153));
        jLabel23.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Rp");
        jLabel23.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel23ComponentAdded(evt);
            }
        });
        jLabel23.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel23AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel11Layout = new javax.swing.GroupLayout(kGradientPanel11);
        kGradientPanel11.setLayout(kGradientPanel11Layout);
        kGradientPanel11Layout.setHorizontalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(137, Short.MAX_VALUE))
                    .addGroup(kGradientPanel11Layout.createSequentialGroup()
                        .addGroup(kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        kGradientPanel11Layout.setVerticalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel11Layout.createSequentialGroup()
                .addGroup(kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel11Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(b6)))
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 51));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_euro_money_50px.png"))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(153, 255, 153));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Pendapatan");
        jLabel5.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel5ComponentAdded(evt);
            }
        });
        jLabel5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel5AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel15.setBackground(new java.awt.Color(153, 255, 153));
        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Rp");
        jLabel15.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel15ComponentAdded(evt);
            }
        });
        jLabel15.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel15AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel6.setBackground(new java.awt.Color(153, 255, 153));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel6ComponentAdded(evt);
            }
        });
        jLabel6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel6AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(148, Short.MAX_VALUE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(b2)))
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel10.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel10.setkStartColor(new java.awt.Color(0, 51, 51));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_cash_in_hand_50px.png"))); // NOI18N

        jLabel16.setBackground(new java.awt.Color(153, 255, 153));
        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Total Pengeluaran");
        jLabel16.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel16ComponentAdded(evt);
            }
        });
        jLabel16.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel16AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        tluar.setBackground(new java.awt.Color(153, 255, 153));
        tluar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tluar.setForeground(new java.awt.Color(255, 255, 255));
        tluar.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tluarComponentAdded(evt);
            }
        });
        tluar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tluarAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel17.setBackground(new java.awt.Color(153, 255, 153));
        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Rp");
        jLabel17.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel17ComponentAdded(evt);
            }
        });
        jLabel17.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel17AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel10Layout = new javax.swing.GroupLayout(kGradientPanel10);
        kGradientPanel10.setLayout(kGradientPanel10Layout);
        kGradientPanel10Layout.setHorizontalGroup(
            kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel10Layout.createSequentialGroup()
                        .addGroup(kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(kGradientPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, 0)
                        .addComponent(tluar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        kGradientPanel10Layout.setVerticalGroup(
            kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel10Layout.createSequentialGroup()
                .addGroup(kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel10Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(b4)))
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tluar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel12.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel12.setkStartColor(new java.awt.Color(0, 51, 51));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_cash_in_hand_50px.png"))); // NOI18N

        jLabel26.setBackground(new java.awt.Color(153, 255, 153));
        jLabel26.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Pengeluaran Harian");
        jLabel26.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel26ComponentAdded(evt);
            }
        });
        jLabel26.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel26AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        tluar1.setBackground(new java.awt.Color(153, 255, 153));
        tluar1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tluar1.setForeground(new java.awt.Color(255, 255, 255));
        tluar1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tluar1ComponentAdded(evt);
            }
        });
        tluar1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tluar1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel27.setBackground(new java.awt.Color(153, 255, 153));
        jLabel27.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Rp");
        jLabel27.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel27ComponentAdded(evt);
            }
        });
        jLabel27.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel27AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel12Layout = new javax.swing.GroupLayout(kGradientPanel12);
        kGradientPanel12.setLayout(kGradientPanel12Layout);
        kGradientPanel12Layout.setHorizontalGroup(
            kGradientPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, 0)
                        .addComponent(tluar1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(185, Short.MAX_VALUE))
                    .addGroup(kGradientPanel12Layout.createSequentialGroup()
                        .addGroup(kGradientPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        kGradientPanel12Layout.setVerticalGroup(
            kGradientPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel12Layout.createSequentialGroup()
                .addGroup(kGradientPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel12Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(b8)))
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tluar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelHomeLayout = new javax.swing.GroupLayout(PanelHome);
        PanelHome.setLayout(PanelHomeLayout);
        PanelHomeLayout.setHorizontalGroup(
            PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHomeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        PanelHomeLayout.setVerticalGroup(
            PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHomeLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(PanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMenu.add(PanelHome, java.awt.BorderLayout.CENTER);

        PanelButton.setBackground(new java.awt.Color(39, 55, 47));
        PanelButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        PanelButton.setMinimumSize(new java.awt.Dimension(0, 0));

        kGradientPanel7.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel7.setkGradientFocus(1000);
        kGradientPanel7.setkStartColor(new java.awt.Color(0, 51, 51));

        uWPButton3.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton3.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton3.setText("Halaman Awal");
        uWPButton3.setBorderPainted(false);
        uWPButton3.setBorderSize(0);
        uWPButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton3ActionPerformed(evt);
            }
        });

        uWPButton6.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton6.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton6.setText("Data Pelanggan");
        uWPButton6.setBorderPainted(false);
        uWPButton6.setBorderSize(0);
        uWPButton6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton6ActionPerformed(evt);
            }
        });

        uWPButton4.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton4.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton4.setText("Transaksi Cucian");
        uWPButton4.setBorderPainted(false);
        uWPButton4.setBorderSize(0);
        uWPButton4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton4ActionPerformed(evt);
            }
        });

        uWPButton5.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton5.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton5.setText("Transaksi Pengeluaran");
        uWPButton5.setBorderPainted(false);
        uWPButton5.setBorderSize(0);
        uWPButton5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton5ActionPerformed(evt);
            }
        });

        uWPButton8.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton8.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton8.setText("Transaksi Keuangan");
        uWPButton8.setBorderPainted(false);
        uWPButton8.setBorderSize(0);
        uWPButton8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton8ActionPerformed(evt);
            }
        });

        uWPButton9.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton9.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton9.setText("Laporan Pengeluaran");
        uWPButton9.setBorderPainted(false);
        uWPButton9.setBorderSize(0);
        uWPButton9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton9ActionPerformed(evt);
            }
        });

        uWPButton7.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton7.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton7.setText("Laporan Pemasukan");
        uWPButton7.setBorderPainted(false);
        uWPButton7.setBorderSize(0);
        uWPButton7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton7ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_shutdown_32px.png"))); // NOI18N
        jLabel29.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel29AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        uWPButton10.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton10.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton10.setText("Laporan Keuangan");
        uWPButton10.setBorderPainted(false);
        uWPButton10.setBorderSize(0);
        uWPButton10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton10ActionPerformed(evt);
            }
        });

        uWPButton12.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton12.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton12.setText("Data Pengguna");
        uWPButton12.setBorderPainted(false);
        uWPButton12.setBorderSize(0);
        uWPButton12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton12ActionPerformed(evt);
            }
        });

        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });

        uWPButton13.setBackground(new java.awt.Color(102, 102, 102));
        uWPButton13.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton13.setText("Laporan Data Pelanggan");
        uWPButton13.setBorderPainted(false);
        uWPButton13.setBorderSize(0);
        uWPButton13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        uWPButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel7Layout = new javax.swing.GroupLayout(kGradientPanel7);
        kGradientPanel7.setLayout(kGradientPanel7Layout);
        kGradientPanel7Layout.setHorizontalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel7Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(uWPButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        kGradientPanel7Layout.setVerticalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addComponent(uWPButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uWPButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b1)
                .addGap(0, 0, 0)
                .addComponent(jLabel29))
        );

        javax.swing.GroupLayout PanelButtonLayout = new javax.swing.GroupLayout(PanelButton);
        PanelButton.setLayout(PanelButtonLayout);
        PanelButtonLayout.setHorizontalGroup(
            PanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelButtonLayout.setVerticalGroup(
            PanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        uWPButton11.setBackground(new java.awt.Color(0, 51, 51));
        uWPButton11.setForeground(new java.awt.Color(251, 251, 251));
        uWPButton11.setBorderPainted(false);
        uWPButton11.setBorderSize(0);
        uWPButton11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        uWPButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uWPButton11MouseClicked(evt);
            }
        });
        uWPButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uWPButton11ActionPerformed(evt);
            }
        });

        kGradientPanel5.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel5.setkGradientFocus(1200);
        kGradientPanel5.setkStartColor(new java.awt.Color(0, 51, 51));

        tglskrng.setBackground(new java.awt.Color(153, 255, 153));
        tglskrng.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tglskrng.setForeground(new java.awt.Color(255, 255, 255));
        tglskrng.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tglskrngComponentAdded(evt);
            }
        });
        tglskrng.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tglskrngAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel24.setBackground(new java.awt.Color(153, 255, 153));
        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tanggal :");
        jLabel24.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel24ComponentAdded(evt);
            }
        });
        jLabel24.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel24AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/XOsX2.gif"))); // NOI18N
        b7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b7MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/laundry.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addGap(436, 436, 436)
                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tglskrng, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglskrng, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(b7))
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(uWPButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uWPButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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
 
    private void uWPButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton3ActionPerformed
     
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

      

        panelMenu.add(PanelHome);
        panelMenu.repaint();
        panelMenu.revalidate();
        count();
        sum();
        sum1();
        cuciselesai();
        cuciproses();
        sum2();
        sum3();
    }//GEN-LAST:event_uWPButton3ActionPerformed

    private void uWPButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton5ActionPerformed
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new Transaksi_pengeluaran());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton5ActionPerformed

    private void uWPButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton4ActionPerformed
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new Express());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton4ActionPerformed

    private void uWPButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton6ActionPerformed
        // TODO add your handling code here:
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new data_pelanggan());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton6ActionPerformed

    private void uWPButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton7ActionPerformed
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new LaporanPemasukan());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton7ActionPerformed

    private void uWPButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton8ActionPerformed
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new FormModalAwal());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton8ActionPerformed

    private void uWPButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton9ActionPerformed
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new LaporanPengeluaran());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton9ActionPerformed

    private void uWPButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton11ActionPerformed
        // TODO add your handling code here:

        /* if (uWPButton11.isEnabled()) {
            PanelButton.setVisible(false);
            uWPButton11.setVisible(false);
        } else {
            uWPButton11.setVisible(false);
        }*/

    }//GEN-LAST:event_uWPButton11ActionPerformed

    private void uWPButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uWPButton11MouseClicked
        if(a==true){
            PanelButton.setVisible(a);
            SwingUtilities.updateComponentTreeUI(this);
            //create methode change image

            a=false;
        }
        else{
            PanelButton.setVisible(a);
            SwingUtilities.updateComponentTreeUI(this);
            a=true;
        }

    }//GEN-LAST:event_uWPButton11MouseClicked

    private void jLabel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3AncestorAdded

    private void jLabel3ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel3ComponentAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel3ComponentAdded

    private void jLabel4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4AncestorAdded

    private void jLabel4ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel4ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4ComponentAdded

    private void jLabel5ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel5ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5ComponentAdded

    private void jLabel5AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel5AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5AncestorAdded

    private void jLabel6ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel6ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6ComponentAdded

    private void jLabel6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel6AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6AncestorAdded

    private void jLabel7ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel7ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7ComponentAdded

    private void jLabel7AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel7AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7AncestorAdded

    private void jLabel8ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel8ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8ComponentAdded

    private void jLabel8AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel8AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8AncestorAdded

    private void jLabel9ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel9ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9ComponentAdded

    private void jLabel9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel9AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9AncestorAdded

    private void jLabel10ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel10ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10ComponentAdded

    private void jLabel10AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel10AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10AncestorAdded

    private void jLabel15ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel15ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15ComponentAdded

    private void jLabel15AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel15AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15AncestorAdded

    private void jLabel16ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel16ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16ComponentAdded

    private void jLabel16AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel16AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16AncestorAdded

    private void tluarComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tluarComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tluarComponentAdded

    private void tluarAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tluarAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tluarAncestorAdded

    private void jLabel17ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel17ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17ComponentAdded

    private void jLabel17AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel17AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17AncestorAdded

    private void tglskrngComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tglskrngComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tglskrngComponentAdded

    private void tglskrngAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tglskrngAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tglskrngAncestorAdded

    private void jLabel20ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel20ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20ComponentAdded

    private void jLabel20AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel20AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20AncestorAdded

    private void jLabel21ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel21ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21ComponentAdded

    private void jLabel21AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel21AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21AncestorAdded

    private void jLabel23ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel23ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23ComponentAdded

    private void jLabel23AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel23AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23AncestorAdded

    private void jLabel24ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel24ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24ComponentAdded

    private void jLabel24AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel24AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24AncestorAdded

    private void jLabel26ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel26ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26ComponentAdded

    private void jLabel26AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel26AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26AncestorAdded

    private void jLabel27ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel27ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27ComponentAdded

    private void jLabel27AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel27AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27AncestorAdded

    private void tluar1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tluar1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tluar1ComponentAdded

    private void tluar1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tluar1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tluar1AncestorAdded

    private void kGradientPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel6MouseClicked
      new CucianSelesai().show();
    }//GEN-LAST:event_kGradientPanel6MouseClicked

    private void kGradientPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel8MouseClicked
       new CucianBelumSelesai().show();
    }//GEN-LAST:event_kGradientPanel8MouseClicked

    private void jLabel29AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel29AncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel29AncestorAdded

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
      int ok = JOptionPane.showConfirmDialog(this, "Yakin Ingin Keluar?"," ",JOptionPane.OK_CANCEL_OPTION);
      if(ok==0){
      new Login().setVisible(true);
      this.dispose();    
      }
      
      
    }//GEN-LAST:event_jLabel29MouseClicked

    private void uWPButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton10ActionPerformed
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new LaporanLabaRugi());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton10ActionPerformed

    private void uWPButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton12ActionPerformed
        panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new Admin());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton12ActionPerformed

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
 b3.setVisible(true);
 b1.setVisible(false);
    }//GEN-LAST:event_b1MouseClicked

    private void b3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseClicked
 b2.setVisible(true);
 b3.setVisible(false);
    }//GEN-LAST:event_b3MouseClicked

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
 b4.setVisible(true);
 b2.setVisible(false);
    }//GEN-LAST:event_b2MouseClicked

    private void b4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseClicked
 b5.setVisible(true);
 b4.setVisible(false);       
    }//GEN-LAST:event_b4MouseClicked

    private void b5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseClicked
 b6.setVisible(true);
 b5.setVisible(false);  
    }//GEN-LAST:event_b5MouseClicked

    private void b6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b6MouseClicked
 b8.setVisible(true);
 b6.setVisible(false);  
    }//GEN-LAST:event_b6MouseClicked

    private void b7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b7MouseClicked
 b1.setVisible(true);
 b7.setVisible(false); 
    }//GEN-LAST:event_b7MouseClicked

    private void b8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b8MouseClicked
 b9.setVisible(true);
 b8.setVisible(false);  
    }//GEN-LAST:event_b8MouseClicked

    private void b9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MouseClicked
b7.setVisible(true);
b9.setVisible(false);  
    }//GEN-LAST:event_b9MouseClicked

    private void uWPButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uWPButton13ActionPerformed
      panelMenu.removeAll();
        panelMenu.repaint();
        panelMenu.revalidate();

        //

        panelMenu.add(new LaporanDataPelanggan());
        panelMenu.repaint();
        panelMenu.revalidate();
    }//GEN-LAST:event_uWPButton13ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButton;
    private keeptoo.KGradientPanel PanelHome;
    private javax.swing.JLabel b1;
    private javax.swing.JLabel b2;
    private javax.swing.JLabel b3;
    private javax.swing.JLabel b4;
    private javax.swing.JLabel b5;
    private javax.swing.JLabel b6;
    private javax.swing.JLabel b7;
    private javax.swing.JLabel b8;
    private javax.swing.JLabel b9;
    private javax.swing.JLabel jLabel1;
    public static final javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    public static final javax.swing.JLabel jLabel15 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel16 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel17 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel18;
    public static final javax.swing.JLabel jLabel20 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel21 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel22;
    public static final javax.swing.JLabel jLabel23 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel24 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel25;
    public static final javax.swing.JLabel jLabel26 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel27 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel29;
    public static final javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
    public static final javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel11;
    private keeptoo.KGradientPanel kGradientPanel12;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private javax.swing.JPanel panelMenu;
    public static final javax.swing.JLabel tglskrng = new javax.swing.JLabel();
    public static final javax.swing.JLabel tluar = new javax.swing.JLabel();
    public static final javax.swing.JLabel tluar1 = new javax.swing.JLabel();
    public static final javaswingdev.uwp.UWPButton uWPButton10 = new javaswingdev.uwp.UWPButton();
    private javaswingdev.uwp.UWPButton uWPButton11;
    public static final javaswingdev.uwp.UWPButton uWPButton12 = new javaswingdev.uwp.UWPButton();
    public static final javaswingdev.uwp.UWPButton uWPButton13 = new javaswingdev.uwp.UWPButton();
    public static final javaswingdev.uwp.UWPButton uWPButton3 = new javaswingdev.uwp.UWPButton();
    public static final javaswingdev.uwp.UWPButton uWPButton4 = new javaswingdev.uwp.UWPButton();
    public static final javaswingdev.uwp.UWPButton uWPButton5 = new javaswingdev.uwp.UWPButton();
    public static final javaswingdev.uwp.UWPButton uWPButton6 = new javaswingdev.uwp.UWPButton();
    public static final javaswingdev.uwp.UWPButton uWPButton7 = new javaswingdev.uwp.UWPButton();
    public static final javaswingdev.uwp.UWPButton uWPButton8 = new javaswingdev.uwp.UWPButton();
    public static final javaswingdev.uwp.UWPButton uWPButton9 = new javaswingdev.uwp.UWPButton();
    // End of variables declaration//GEN-END:variables

    

    

    
}
