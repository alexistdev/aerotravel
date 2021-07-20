-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 25, 2021 at 05:41 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aerotravelweb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`, `status`) VALUES
(1, 'admin', '$2y$10$jj3StaGg/XQZ8TGzR4FbuuWu2y.Fs1AVAr5ZuCMElDQD.RoPAaNS6', 1);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id_booking` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_paket` int(11) NOT NULL,
  `kode_booking` varchar(10) NOT NULL,
  `tanggal_wisata` date NOT NULL,
  `tanggal_dibuat` date NOT NULL,
  `jumlah_peserta` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id_booking`, `id_user`, `id_paket`, `kode_booking`, `tanggal_wisata`, `tanggal_dibuat`, `jumlah_peserta`, `status`, `total_harga`) VALUES
(5, 5, 1, 'xNPbCHAovV', '2021-02-27', '2021-02-22', 6, 2, 870000),
(6, 5, 2, 'ZC2txi7Hz8', '2021-02-24', '2021-02-22', 1, 2, 400000),
(7, 5, 1, '9cE4Tml8SO', '2021-02-23', '2021-02-22', 7, 2, 1015000),
(8, 5, 1, 'k4E2KzToOi', '2021-02-25', '2021-02-22', 4, 2, 600000),
(9, 5, 1, 'twV24KPYjD', '2021-02-27', '2021-02-22', 4, 2, 600000),
(10, 5, 1, '5NjcCgYdfk', '2021-02-27', '2021-02-22', 7, 2, 1015000),
(11, 5, 1, 'eNL3yJRC61', '2021-02-26', '2021-02-22', 19, 2, 2565000);

-- --------------------------------------------------------

--
-- Table structure for table `destinasi`
--

CREATE TABLE `destinasi` (
  `id_destinasi` int(11) NOT NULL,
  `judul_destinasi` varchar(50) NOT NULL,
  `deskripsi` text NOT NULL,
  `gambar1` varchar(50) DEFAULT NULL,
  `gambar2` varchar(50) DEFAULT NULL,
  `gambar3` varchar(50) DEFAULT NULL,
  `gambar4` varchar(50) DEFAULT NULL,
  `gambar5` varchar(50) DEFAULT NULL,
  `like_destinasi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destinasi`
--

INSERT INTO `destinasi` (`id_destinasi`, `judul_destinasi`, `deskripsi`, `gambar1`, `gambar2`, `gambar3`, `gambar4`, `gambar5`, `like_destinasi`) VALUES
(1, 'Pulau Pahawang', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 'pahawang1.jpg', 'pahawang2.jpg', 'pahawang3.jpg', 'pahawang4.jpg', '', 15),
(2, 'Tegal Mas', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 'tegalmas1.jpg', 'tegalmas2.jpg', 'tegalmas3.jpg', 'tegalmas4.jpg', 'tegalmas5.jpg', 25);

-- --------------------------------------------------------

--
-- Table structure for table `destinasi_like`
--

CREATE TABLE `destinasi_like` (
  `id_like` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_destinasi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `detail_user`
--

CREATE TABLE `detail_user` (
  `id_detail_user` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `nama_lengkap` varchar(128) NOT NULL,
  `no_ktp` varchar(50) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `no_telp` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_user`
--

INSERT INTO `detail_user` (`id_detail_user`, `id_user`, `nama_lengkap`, `no_ktp`, `alamat`, `no_telp`) VALUES
(5, 5, 'Heinrich234', '4445', 'sidodadis24', '22558834');

-- --------------------------------------------------------

--
-- Table structure for table `fasilitas_include`
--

CREATE TABLE `fasilitas_include` (
  `id_fasilitas` int(11) NOT NULL,
  `id_destinasi` int(11) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `nama_fasilitas` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fasilitas_include`
--

INSERT INTO `fasilitas_include` (`id_fasilitas`, `id_destinasi`, `type`, `nama_fasilitas`) VALUES
(1, 1, 1, 'Kapal Ekplore Pulau'),
(2, 1, 1, 'Makan 1 x Prasmanan'),
(3, 1, 1, 'Asuransi Kecelakaan ( Selama di Perahu )'),
(4, 1, 1, 'Air Mineral'),
(5, 1, 1, 'Alat Snorkeling ( Mask, SnorkeL )'),
(6, 1, 1, 'Life Jacket ( Pelampung )'),
(7, 1, 1, 'Tiket Masuk Pulau'),
(8, 1, 1, 'Tiket Snorkeling'),
(9, 1, 1, 'P3K'),
(10, 1, 1, 'Tour Guide'),
(11, 1, 1, 'Dokumentasi Underwater'),
(12, 1, 1, 'Dokumentasi Upwater'),
(13, 1, 1, 'Dokumentasi Drone ( Premium )'),
(14, 1, 1, 'Video Clip Perjalanan Trip ( Premium )'),
(15, 1, 1, 'Free Banner Kegiatan ( Min 30 Orang )'),
(16, 1, 1, 'Parkir Kendaraan ( Bus/Elf Only )'),
(17, 1, 2, 'Kapal Ekplore Pulau ( 2 Hari )'),
(18, 1, 2, 'Penginapan Sesuai Paket'),
(19, 1, 2, 'Makan 4 Kali ( Prasmanan )'),
(20, 1, 2, 'Air Mineral'),
(21, 1, 2, 'Alat Snorkeling ( Mask'),
(22, 1, 2, 'Life Jacket ( Pelampung )'),
(23, 1, 2, 'Tiket Masuk Pulau'),
(24, 1, 2, 'Tiket Snorkeling'),
(25, 1, 2, 'P3K'),
(26, 1, 2, 'Tour Guide'),
(27, 1, 2, 'Dokumentasi Underwater'),
(28, 1, 2, 'Dokumentasi Upwater ( SLR/Miroles )'),
(29, 1, 2, 'Free Fotographer'),
(30, 1, 2, 'Free Kain Tapis Untuk Foto'),
(31, 1, 2, 'Parkir Kendaraan'),
(32, 1, 2, 'Ruang Ganti'),
(33, 1, 2, 'Kamar Bilas'),
(34, 2, 1, 'Kapal Ekplore Pulau'),
(35, 2, 1, 'Makan 1 x Nasi Box ( Standar Paket )'),
(36, 2, 1, 'Makan 1 x Prasmanan'),
(37, 2, 1, 'Air Mineral'),
(38, 2, 1, 'Alat Snorkeling ( Mask'),
(39, 2, 1, 'Life Jacket ( Pelampung )'),
(40, 2, 1, 'Tiket Masuk Pulau Tegal Mas / Mahitam / Kelagian'),
(41, 2, 1, 'Tiket Snorkeling'),
(42, 2, 1, 'P3K'),
(43, 2, 1, 'Tour Guide'),
(44, 2, 1, 'Dokumentasi Underwater'),
(45, 2, 1, 'Dokumentasi Upwater'),
(46, 2, 1, 'Dokumentasi Drone'),
(47, 2, 1, 'Video Clip Trip 1-5 Menit'),
(48, 2, 1, 'Free Banner Kegiatan ( Min 30 Orang )'),
(49, 2, 1, 'Parkir Kendaraan ( Bus/Elf Only )'),
(50, 2, 1, 'Ruang Ganti ( di Tegal Mas )'),
(51, 2, 1, 'Kamar Bilas ( di Tegal Mas )'),
(52, 2, 1, 'Asuransi Kecelakaan ( Selama di Perahu )'),
(53, 2, 2, 'Kapal Penyebrangan Tegal Mas PP'),
(54, 2, 2, 'Kapal Ekplore Pulau Mahitam / Kelagian'),
(55, 2, 2, 'Penginapan Sesuai Paket'),
(56, 2, 2, 'Makan 3 Kali ( Siang'),
(57, 2, 2, 'Air Mineral'),
(58, 2, 2, 'Alat Snorkeling ( Mask'),
(59, 2, 2, 'Life Jacket ( Pelampung )'),
(60, 2, 2, 'Tiket Masuk Pulau Mahitam/Pasir Timbu/Kelagian'),
(61, 2, 2, 'Tiket Snorkeling & Underwater View'),
(62, 2, 2, 'P3K'),
(63, 2, 2, 'Tour Guide'),
(64, 2, 2, 'Dokumentasi Underwater'),
(65, 2, 2, 'Dokumentasi Upwater'),
(66, 2, 2, 'Parkir Kendaraan'),
(67, 2, 2, 'Ruang Ganti'),
(68, 2, 2, 'Kamar Bilas'),
(69, 2, 2, 'Free Fotographer ( Selain High Season )'),
(70, 2, 2, 'Free Kain Tapis Untuk Foto ( Di Pinjamkan )'),
(71, 2, 2, 'Free Masker ( Jika Masih Tersedia )'),
(72, 2, 2, 'Free ATV Motor ( Di Pulau Mahitam ) 2 Unit');

-- --------------------------------------------------------

--
-- Table structure for table `harga`
--

CREATE TABLE `harga` (
  `id_harga` int(11) NOT NULL,
  `id_paket` int(11) NOT NULL,
  `minimal_peserta` int(11) DEFAULT NULL,
  `maksimal_peserta` int(11) DEFAULT NULL,
  `harga_premium` int(11) DEFAULT NULL,
  `harga_standar` int(11) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `harga`
--

INSERT INTO `harga` (`id_harga`, `id_paket`, `minimal_peserta`, `maksimal_peserta`, `harga_premium`, `harga_standar`, `keterangan`) VALUES
(1, 1, 1, 5, NULL, 150000, '1-5 Orang'),
(2, 1, 6, 10, NULL, 145000, '6 – 10 Orang'),
(3, 1, 11, 15, NULL, 140000, '11 – 15 Orang'),
(4, 1, 16, 1000, NULL, 135000, '16 Orang / Dst'),
(5, 2, 1, 2, NULL, 400000, '1-2 Orang');

-- --------------------------------------------------------

--
-- Table structure for table `inbox`
--

CREATE TABLE `inbox` (
  `id_inbox` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `is_adm` int(11) NOT NULL,
  `judul` varchar(80) NOT NULL,
  `pesan` text NOT NULL,
  `key_token` varchar(100) NOT NULL,
  `time` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inbox`
--

INSERT INTO `inbox` (`id_inbox`, `id_user`, `is_adm`, `judul`, `pesan`, `key_token`, `time`, `status`) VALUES
(3, 5, 0, 'ini testing judul', 'lorem ipssum', '8c8d357b5e872bbacd45197626bd5759', 1609353632, 1);

-- --------------------------------------------------------

--
-- Table structure for table `inboxbalas`
--

CREATE TABLE `inboxbalas` (
  `id_balas` int(11) NOT NULL,
  `is_admin` int(11) NOT NULL,
  `key_token` int(100) NOT NULL,
  `pesan` text NOT NULL,
  `time` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inboxbalas`
--

INSERT INTO `inboxbalas` (`id_balas`, `is_admin`, `key_token`, `pesan`, `time`) VALUES
(1, 1, 8, 'adadadaaaaaaaaaaaaaaaaaaaaaaaa', 1609391729),
(2, 2, 8, 'Take me to your leader! Switzerland is small and neutral! We are more like Germany, ambitious and misunderstood!', 1609392886),
(3, 1, 8, 'cupcake yang kecil , dimana , dimana', 1609393384);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` int(11) NOT NULL,
  `id_destinasi` int(11) NOT NULL,
  `type` int(11) NOT NULL COMMENT '1 = 1 day\r\n2 =  2 day',
  `waktu` varchar(50) NOT NULL,
  `keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `id_destinasi`, `type`, `waktu`, `keterangan`) VALUES
(1, 1, 1, '08:00 - 09:00', 'Pembagian alat snorkling dan persiapan keberangktan'),
(2, 1, 1, '09:00 - 10:00', 'Perjalanan menuju Cukuh Bedil'),
(3, 1, 1, '09:45 - 11:15', 'Snorkling di Spot Cukuh Bedil'),
(4, 1, 1, '11:15 - 11:30', 'Perjalanan Menuju Pulau Pahawang Besar'),
(5, 1, 1, '11:30 - 13:00', 'ISHOMA di Pulau Pahawang Besar'),
(6, 1, 1, '13:00 - 13:15', 'Perjalanan menuju Spot Taman Nemo'),
(7, 1, 1, '13:15 - 14:00', 'Snorkling di spot Taman Nemo'),
(8, 1, 1, '14:00 - 14:15', 'perjalanan menuju Pulau Pahawang Kecil'),
(9, 1, 1, '14:15 - 15:15', 'Water Sport + bersantai (Foto-foto) di pulau Pahawang Kecil'),
(10, 1, 1, '15:15- 15:30', 'Perjalanan menuju pulau kelagian kecil'),
(11, 1, 1, '15:30:16:00', 'Bersantai di pulau kelagian kecil'),
(12, 1, 1, '16:00 : 16:30', 'Perjalanan pulang ke dermaga ketapang'),
(13, 1, 1, '16:30 - 17:00', 'Salin foto dan sayonara'),
(14, 2, 1, '07:00 - 08:00', 'Kedatangan Peserta'),
(15, 2, 1, '08:00 - 09:00', 'Briefiung dan Pembagian Alat'),
(16, 2, 1, '09:00 - 10:00', 'Perjalanan Menuju Pulau Tegal Mas'),
(17, 2, 1, '10:00 - 12:00', 'Hopping Island Tegal Mas ( Kepiting Resort, Lombok Mas , Lombok Laut, Dll. )'),
(18, 2, 1, '12:00 - 13:30', 'Isoma ( Free Time )'),
(19, 2, 1, '13:30 - 14:00', 'Snorkeling & Water Sport Tegal Mas'),
(20, 2, 1, '14:00 - 15:00', 'Menuju Pulau Mahitam / Pulau Kelagian'),
(21, 2, 1, '15:00 - 16:30', 'Snorkeling di Kelagian / Hopping Island Pulau Mahitam'),
(22, 2, 1, '16:30 - 17:00', 'Perjalanan Kembali ke Dermaga Ketapang'),
(23, 1, 2, '08:00 - 09:00', '[Hari1] Briefing dan Pembagian Alat Snorkeling'),
(24, 1, 2, '09:00 - 10:00', '[Hari1] Perjalanan ke Cukuh Bedil'),
(25, 1, 2, '10:00 – 11:30', '[Hari1] Snorkeling Cukuh Bedil “ Welcome To Pahawang “'),
(26, 1, 2, '11:30 – 13:00', '[Hari1] Check In Villa dan Ishoma ( 1 )'),
(27, 1, 2, '13:00 - 15:00', '[Hari1] Hopping Island dan Water Sprot di Pulau Pahawang Kecil'),
(28, 1, 2, '15:00 – 17:00', '[Hari1] Snorkeling Taman Nemo'),
(29, 1, 2, '17:00 – 17:30', '[Hari1] Kembali ke Penginapan'),
(30, 1, 2, '17:30 – 19:00', '[Hari1] BMakan Malam ( 3 )'),
(31, 1, 2, '19:00 – 22:00', '[Hari1] Free Time ( BBQ Jika Memesan )'),
(32, 1, 2, '-', '============================================='),
(33, 1, 2, '04:30 - 07:00', '[Hari2] Bangun pagi, Sholat, dan persiapan Hunting Sunrise Depan Villa'),
(34, 1, 2, '07:00 - 08:30', '[Hari2] Sarapan Pagi + Olah Raga (4)'),
(35, 1, 2, '08:30 - 09:30', '[Hari2] Perjalanan Pulang'),
(36, 1, 2, '09:30 - 11:00', '[Hari2] Snorkeling Penggetahan'),
(37, 1, 2, '11:00 - 13:00', '[Hari2] Isoma di Penggetahan'),
(38, 1, 2, '13:00 - 15:00', '[Hari2] Menuju Pulau Kelagian Besar/Kecil'),
(39, 1, 2, '15:00 - 15:30', '[Hari2] Kembali Ke Dermaga Ketapang'),
(40, 1, 2, '16:00 - 17:00', '[Hari2] Salin dan Bilas di Dermaga'),
(41, 2, 2, '07:00 - 08:00', '[Hari1] Kedatangan Peserta'),
(42, 2, 2, '08:00 - 09:00', '[Hari1] Briefiung dan Pembagian Alat'),
(43, 2, 2, '09:00 - 10:00', '[Hari1] Perjalanan Menuju Pulau Tegal Mas'),
(44, 2, 2, '10:00 - 11:00', '[Hari1] Hopping Island di Tegal Mas / Stay di Saung Pantai (Menunggu Jadwal Check In )'),
(45, 2, 2, '11:00 - 13:30', '[Hari1] Check In Pulau Tegal Mas ( Isoma )'),
(46, 2, 2, '13:30 - 14:00', '[Hari1] Hopping Island Tegal Mas'),
(47, 2, 2, '14:00 - 15:00', '[Hari1] Menuju Pulau Mahitam / Kelagian Besar'),
(48, 2, 2, '15:00 - 17:00', '[Hari1] Snorkeling & Water Sport ATV Motor Sport di Pulau Mahitam / Kelagian Besar'),
(49, 2, 2, '17:00 - 18:00', '[Hari1] Back To Villa dan Mandi'),
(50, 2, 2, '18:00 - 19:00', '[Hari1] Makan Malam'),
(51, 2, 2, '19:00 - ', '[Hari1] Free Time'),
(52, 2, 2, '-', '============================================='),
(53, 2, 2, '05:00 - 07:00', '[Hari2] MCK dan Menikmati Sunrise'),
(54, 2, 2, '07:00 - 08:00', '[Hari2] Sarapan Pagi dan Olahraga'),
(55, 2, 2, '08:00 - 10:00', '[Hari2] Snorkeling di Tegal Mas'),
(56, 2, 2, '10:00 - 11:00', '[Hari2] Persiapan Check Out'),
(57, 2, 2, '11:00 - 12:00', '[Hari2] Kembali ke Dermaga , Sayonara');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL,
  `status` tinyint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`, `status`) VALUES
(1, 'Open', 1),
(2, 'Privat', 1);

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `id_paket` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `id_kategori` int(11) NOT NULL COMMENT '1 = open\r\n2 = private',
  `judul_paket` varchar(80) NOT NULL,
  `deksripsi` text NOT NULL,
  `status_paket` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paket`
--

INSERT INTO `paket` (`id_paket`, `type`, `id_kategori`, `judul_paket`, `deksripsi`, `status_paket`) VALUES
(1, 1, 1, '1 DAY PAHAWANG NEW NORMAL 2020', 'Open Trip', 1),
(2, 1, 1, '2 DAY PAHAWANG NEW NORMAL 2020', 'Privat', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(128) NOT NULL,
  `status` int(11) NOT NULL,
  `token` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `password`, `email`, `status`, `token`) VALUES
(5, '12dea96fec20593566ab75692c9949596833adc9', 'user@gmail.com', 1, 'eBwcdDlMyN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id_booking`);

--
-- Indexes for table `destinasi`
--
ALTER TABLE `destinasi`
  ADD PRIMARY KEY (`id_destinasi`);

--
-- Indexes for table `destinasi_like`
--
ALTER TABLE `destinasi_like`
  ADD PRIMARY KEY (`id_like`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_destinasi` (`id_destinasi`);

--
-- Indexes for table `detail_user`
--
ALTER TABLE `detail_user`
  ADD PRIMARY KEY (`id_detail_user`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `fasilitas_include`
--
ALTER TABLE `fasilitas_include`
  ADD PRIMARY KEY (`id_fasilitas`);

--
-- Indexes for table `harga`
--
ALTER TABLE `harga`
  ADD PRIMARY KEY (`id_harga`),
  ADD KEY `harga_ibfk_1` (`id_paket`);

--
-- Indexes for table `inbox`
--
ALTER TABLE `inbox`
  ADD PRIMARY KEY (`id_inbox`),
  ADD KEY `inbox_ibfk_1` (`id_user`);

--
-- Indexes for table `inboxbalas`
--
ALTER TABLE `inboxbalas`
  ADD PRIMARY KEY (`id_balas`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id_booking` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `destinasi`
--
ALTER TABLE `destinasi`
  MODIFY `id_destinasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `destinasi_like`
--
ALTER TABLE `destinasi_like`
  MODIFY `id_like` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `detail_user`
--
ALTER TABLE `detail_user`
  MODIFY `id_detail_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `fasilitas_include`
--
ALTER TABLE `fasilitas_include`
  MODIFY `id_fasilitas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT for table `harga`
--
ALTER TABLE `harga`
  MODIFY `id_harga` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `inbox`
--
ALTER TABLE `inbox`
  MODIFY `id_inbox` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `inboxbalas`
--
ALTER TABLE `inboxbalas`
  MODIFY `id_balas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `paket`
--
ALTER TABLE `paket`
  MODIFY `id_paket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `destinasi_like`
--
ALTER TABLE `destinasi_like`
  ADD CONSTRAINT `destinasi_like_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `destinasi_like_ibfk_2` FOREIGN KEY (`id_destinasi`) REFERENCES `destinasi` (`id_destinasi`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `detail_user`
--
ALTER TABLE `detail_user`
  ADD CONSTRAINT `detail_user_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `harga`
--
ALTER TABLE `harga`
  ADD CONSTRAINT `harga_ibfk_1` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id_paket`) ON DELETE CASCADE;

--
-- Constraints for table `inbox`
--
ALTER TABLE `inbox`
  ADD CONSTRAINT `inbox_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `paket`
--
ALTER TABLE `paket`
  ADD CONSTRAINT `paket_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
