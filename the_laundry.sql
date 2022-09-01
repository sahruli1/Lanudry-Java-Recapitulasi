-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2022 at 05:37 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `the_laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `jabatan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `nama`, `username`, `password`, `jabatan`) VALUES
(1, 'Muslihati', 'pemilik', 'pemilik', 'pemilik'),
(2, 'rasya', 'karyawan', 'karyawan', 'karyawan'),
(3, 'Alwi Rahmat', 'admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `t_pelanggan`
--

CREATE TABLE `t_pelanggan` (
  `id_pelanggan` varchar(30) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(11) NOT NULL,
  `no_telp` varchar(100) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_pelanggan`
--

INSERT INTO `t_pelanggan` (`id_pelanggan`, `nama`, `jenis_kelamin`, `no_telp`, `alamat`) VALUES
('ID001', 'Winda', 'Perempuan', '08121807885', 'Cipayung'),
('ID002', 'Dika', 'Laki-Laki', '08967856432', 'Cipayung'),
('ID003', 'Intan', 'Perempuan', '087877654321', 'Citayam'),
('ID004', 'Nanang', 'Laki-Laki', '-', 'Jembatan Serong'),
('ID005', 'Yuni', 'Perempuan', '-', 'Bulak Timur'),
('ID006', 'Sahruli', 'Laki-Laki', '081278876543', 'Cipayung'),
('ID007', 'Jaka', 'Laki-Laki', '08963453321', 'Depok'),
('ID008', 'Jaki', 'Laki-Laki', '08127654321', 'Citayam'),
('ID009', 'Awal', 'Laki-Laki', '08967564321', 'Citayam'),
('ID010', 'Jarot', 'Laki-Laki', '0887721342', 'Depok');

--
-- Triggers `t_pelanggan`
--
DELIMITER $$
CREATE TRIGGER `insertmultiple` AFTER INSERT ON `t_pelanggan` FOR EACH ROW BEGIN
INSERT INTO t_transaksi_cuci(id_pelanggan)
VALUES (new.id_pelanggan);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `t_pendapatan`
--

CREATE TABLE `t_pendapatan` (
  `kd_modal` varchar(30) NOT NULL,
  `modal_awal` int(100) NOT NULL,
  `pengeluaran` int(100) NOT NULL,
  `pemasukan` int(100) NOT NULL,
  `total` int(100) NOT NULL,
  `laba_rugi` int(100) NOT NULL,
  `tanggal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_pendapatan`
--

INSERT INTO `t_pendapatan` (`kd_modal`, `modal_awal`, `pengeluaran`, `pemasukan`, `total`, `laba_rugi`, `tanggal`) VALUES
('MD001', 1000000, 141000, 321000, 1180000, 180000, '27/08/2022'),
('MD002', 1000000, 160000, 300000, 1140000, 140000, '29/08/2022');

-- --------------------------------------------------------

--
-- Table structure for table `t_pengeluaran`
--

CREATE TABLE `t_pengeluaran` (
  `kd_pengeluaran` varchar(30) NOT NULL,
  `nama_pengeluaran` varchar(225) NOT NULL,
  `harga` int(30) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `total` int(30) NOT NULL,
  `tanggal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_pengeluaran`
--

INSERT INTO `t_pengeluaran` (`kd_pengeluaran`, `nama_pengeluaran`, `harga`, `jumlah`, `total`, `tanggal`) VALUES
('KD001', 'Beli Pewangi', 15000, 3, 45000, '27/08/2022'),
('KD002', 'Beli Pelastik Laundry', 40000, 1, 40000, '27/08/2022'),
('KD003', 'Beli Solasi', 6000, 1, 6000, '27/08/2022'),
('KD005', 'Beli Sabun Laundry', 40000, 4, 160000, '29/08/2022'),
('KD006', 'Beli Pelastik Laundry', 15000, 2, 30000, '29/08/2022');

-- --------------------------------------------------------

--
-- Table structure for table `t_transaksi_cuci`
--

CREATE TABLE `t_transaksi_cuci` (
  `id_transaksi_cuci` int(30) NOT NULL,
  `berat` int(30) NOT NULL,
  `keterangan` varchar(225) NOT NULL,
  `layanan` varchar(100) NOT NULL,
  `tanggal_masuk` varchar(30) NOT NULL,
  `harga` int(30) NOT NULL,
  `status_pembayaran` varchar(11) NOT NULL,
  `jml_bayar` int(30) NOT NULL,
  `kembali` int(30) NOT NULL,
  `status_transaksi` varchar(11) NOT NULL,
  `tanggal_keluar` varchar(30) NOT NULL,
  `id_pelanggan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_transaksi_cuci`
--

INSERT INTO `t_transaksi_cuci` (`id_transaksi_cuci`, `berat`, `keterangan`, `layanan`, `tanggal_masuk`, `harga`, `status_pembayaran`, `jml_bayar`, `kembali`, `status_transaksi`, `tanggal_keluar`, `id_pelanggan`) VALUES
(48, 6, 'Baju 5, Celana 5, Kerudung 2', 'Reguler', '27/08/2022', 39000, 'Lunas', 50000, 11000, 'Selesai', '27/08/2022', 'ID001'),
(49, 4, 'Sprei, 4 Baju', 'Reguler', '27/08/2022', 26000, 'Lunas', 30000, 4000, 'Selesai', '27/08/2022', 'ID002'),
(50, 7, 'Baju 10, Celana Levis 3, Handuk 1', 'Express', '27/08/2022', 56000, 'Lunas', 100000, 44000, 'Selesai', '27/08/2022', 'ID003'),
(51, 20, 'Kemeja 10, Sarung 10, Kaos 29, Celana 10', 'Reguler', '27/08/2022', 130000, 'Lunas', 150000, 20000, 'Selesai', '27/08/2022', 'ID004'),
(52, 7, 'Baju 7, Celana 5', 'Kilat', '27/08/2022', 70000, 'Lunas', 100000, 30000, 'Selesai', '27/08/2022', 'ID005'),
(54, 8, 'Baju 5, Celana 5', 'Reguler', '29/08/2022', 52000, 'Lunas', 100000, 48000, 'Selesai', '29/08/2022', 'ID006'),
(58, 5, 'Baju 5, Celana 7', 'Express', '29/08/2022', 40000, 'Lunas', 50000, 10000, 'Selesai', '29/08/2022', 'ID008'),
(59, 0, '', '', '', 0, '', 0, 0, '', '', 'ID009'),
(60, 7, 'Baju 5, Celana 3', 'Reguler', '29/08/2022', 45500, 'Lunas', 50000, 4500, 'Selesai', '29/08/2022', 'ID010');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indexes for table `t_pelanggan`
--
ALTER TABLE `t_pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `t_pendapatan`
--
ALTER TABLE `t_pendapatan`
  ADD PRIMARY KEY (`kd_modal`);

--
-- Indexes for table `t_pengeluaran`
--
ALTER TABLE `t_pengeluaran`
  ADD PRIMARY KEY (`kd_pengeluaran`);

--
-- Indexes for table `t_transaksi_cuci`
--
ALTER TABLE `t_transaksi_cuci`
  ADD PRIMARY KEY (`id_transaksi_cuci`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `layanan` (`layanan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id_pengguna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `t_transaksi_cuci`
--
ALTER TABLE `t_transaksi_cuci`
  MODIFY `id_transaksi_cuci` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_transaksi_cuci`
--
ALTER TABLE `t_transaksi_cuci`
  ADD CONSTRAINT `t_transaksi_cuci_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `t_pelanggan` (`id_pelanggan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
