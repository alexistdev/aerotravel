-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2021 at 03:22 AM
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
(5, 5, 1, 'xNPbCHAovV', '2021-02-27', '2021-02-22', 6, 1, 870000),
(6, 5, 2, 'ZC2txi7Hz8', '2021-02-24', '2021-02-22', 1, 2, 400000),
(7, 5, 1, '9cE4Tml8SO', '2021-02-23', '2021-02-22', 7, 2, 1015000),
(8, 5, 1, 'k4E2KzToOi', '2021-02-25', '2021-02-22', 4, 2, 600000),
(9, 5, 1, 'twV24KPYjD', '2021-02-27', '2021-02-22', 4, 2, 600000),
(10, 5, 1, '5NjcCgYdfk', '2021-02-27', '2021-02-22', 7, 2, 1015000),
(11, 5, 1, 'eNL3yJRC61', '2021-02-26', '2021-02-22', 19, 2, 2565000),
(12, 5, 1, 'FHOEqKi8uN', '2021-03-20', '2021-03-06', 4, 2, 600000),
(13, 5, 1, 'CN9ms5OJt1', '2021-03-24', '2021-03-21', 14, 2, 1960000),
(14, 5, 2, 'pa3wXk29Md', '2021-03-23', '2021-03-21', 2, 2, 800000),
(15, 14, 1, 'grypC5hcom', '2021-03-27', '2021-03-22', 5, 2, 750000),
(16, 14, 2, 'U9GCha5Quo', '2021-03-27', '2021-03-23', 2, 2, 800000),
(17, 14, 1, 'REGhrFYI7V', '2021-03-26', '2021-03-24', 15, 2, 2100000),
(18, 16, 1, '5tcUbGqQfs', '2021-03-26', '2021-03-24', 11, 2, 1540000),
(19, 16, 1, '1qYumgwNGO', '2021-03-27', '2021-03-24', 15, 2, 2100000);

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
  `like_destinasi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destinasi`
--

INSERT INTO `destinasi` (`id_destinasi`, `judul_destinasi`, `deskripsi`, `gambar1`, `gambar2`, `gambar3`, `gambar4`, `gambar5`, `like_destinasi`) VALUES
(1, 'Pulau Pahawang', 'Pulau Pahawang adalah desa dan pulau di kecamatan Marga Punduh, Kabupaten Pesawaran, Lampung, Indonesia.Pulau ini terletak lepas Teluk Punduh. memiliki sejuta pesona yang tidak kalah menarik dengan objek lainnya. Saat ini Pulau ini mulai sering dimasukkan dalam setiap penawaran paket wisata yang ada di Lampung.', 'pahawang1.jpg', 'pahawang2.jpg', 'pahawang3.jpg', 'pahawang4.jpg', '', 0),
(2, 'Tegal Mas', 'Pulau Tegal Mas merupakan sebuah kawasan wisata yang terletak di Pulau Tegal, Kecamatan Teluk Pandan, Kabupaten Pesawaran, Lampung. Banyak yang menyebutnya mirip dengan Maladewa, karena eksotisme alam & penginapan terapung yang ada di sekelilingnya', 'tegalmas1.jpg', 'tegalmas2.jpg', 'tegalmas3.jpg', 'tegalmas4.jpg', 'tegalmas5.jpg', 0),
(13, 'Teluk Kiluan', 'Teluk Kiluan adalah objek wisata pantai yang terletak di Bumi Sari Natar, Kabupaten Tanggamus Provinsi Lampung dengan potensi wisata bahari, dan terkenal dengan banyaknya lumba-lumba, ikan paus disekitaran Teluk Kiluan. Teluk Kiluan juga terkenal dengan keindahan alam dan surga bagi para pemancing handal', '779390969fc03e3784629153e1f55f6a.jpg', '2be6e0c718f6cced8237c11ade0b67e3.jpg', '26703c5f0688626ac009f3289246108a.jpg', NULL, NULL, 0);

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
(5, 5, 'Heinrich234', '4445', 'sidodadis24', '22558834'),
(12, 14, 'Alexsander Hendra Wijaya', '123456', 'sidodadis', '0856020130021'),
(13, 15, 'Samantha', NULL, NULL, '085602013002'),
(14, 16, 'wakandaw', NULL, NULL, '085602013022');

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
  `time` date NOT NULL,
  `status_pesan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inbox`
--

INSERT INTO `inbox` (`id_inbox`, `id_user`, `is_adm`, `judul`, `pesan`, `key_token`, `time`, `status_pesan`) VALUES
(10, 14, 0, 'adadaa', 'dadada', 'OwXStl5cD3GYUkyJAm14', '2021-03-24', 2),
(11, 16, 0, 'testing pesan', 'adadadadada', '6WSr1QGaqjExZ4KRMsvc', '2021-03-24', 1),
(12, 14, 0, 'Aku mencintaimu', 'aku sangat mencintaimu kekasihku', 'PjGKZy1O95t2vAJkoBg6', '2021-03-24', 1);

-- --------------------------------------------------------

--
-- Table structure for table `inboxbalas`
--

CREATE TABLE `inboxbalas` (
  `id_balas` int(11) NOT NULL,
  `is_admin` int(11) NOT NULL,
  `key_token` varchar(100) NOT NULL,
  `pesan` text NOT NULL,
  `time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inboxbalas`
--

INSERT INTO `inboxbalas` (`id_balas`, `is_admin`, `key_token`, `pesan`, `time`) VALUES
(1, 1, '8', 'adadadaaaaaaaaaaaaaaaaaaaaaaaa', '0000-00-00'),
(2, 2, '8', 'Take me to your leader! Switzerland is small and neutral! We are more like Germany, ambitious and misunderstood!', '0000-00-00'),
(3, 1, '8', 'cupcake yang kecil , dimana , dimana', '0000-00-00'),
(4, 1, '0', 'testing pesan', '0000-00-00'),
(5, 1, '0', 'mengapa?', '2021-03-23'),
(6, 1, '0', 'wakanda', '2021-03-23'),
(7, 1, '0', 'wakandadadadada', '2021-03-24'),
(8, 1, '0', 'adadadada', '2021-03-24'),
(9, 1, 'OwXStl5cD3GYUkyJAm14', 'dadada', '2021-03-24'),
(10, 1, '6WSr1QGaqjExZ4KRMsvc', 'adadadadada', '2021-03-24'),
(11, 2, 'OwXStl5cD3GYUkyJAm14', 'ini balasan admin yang sangat panjang sekali bagaimana mungkin\n', '2021-03-24'),
(12, 1, 'OwXStl5cD3GYUkyJAm14', 'ini balasanku', '2021-03-24'),
(13, 1, 'PjGKZy1O95t2vAJkoBg6', 'aku sangat mencintaimu kekasihku', '2021-03-24'),
(14, 2, 'PjGKZy1O95t2vAJkoBg6', 'apakah benar itu kakanda', '2021-03-24'),
(15, 1, 'PjGKZy1O95t2vAJkoBg6', 'Mengapa bisa seperti itu', '2021-03-24'),
(16, 1, '6WSr1QGaqjExZ4KRMsvc', 'aduh admin jangan begitu', '2021-03-24'),
(17, 2, 'PjGKZy1O95t2vAJkoBg6', 'apa iya sih begitu', '2021-03-25'),
(18, 2, 'PjGKZy1O95t2vAJkoBg6', 'wah repot dunk', '2021-03-25');

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
-- Table structure for table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Table structure for table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin DEFAULT NULL,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Table structure for table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Table structure for table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Table structure for table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Table structure for table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Table structure for table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

-- --------------------------------------------------------

--
-- Table structure for table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Table structure for table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Table structure for table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin DEFAULT NULL,
  `data_sql` longtext COLLATE utf8_bin DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Table structure for table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

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
(5, '12dea96fec20593566ab75692c9949596833adc9', 'user@gmail.com', 1, 'LQuhl04Hvw'),
(14, '1bff10ca1e9743c39dc90a14fb165f6b6e9dcb4b', 'alexistdev@gmail.com', 1, '0J9EQb2KZS'),
(15, '1bff10ca1e9743c39dc90a14fb165f6b6e9dcb4b', 'samantha@gmail.com', 1, NULL),
(16, '1bff10ca1e9743c39dc90a14fb165f6b6e9dcb4b', 'wakanda@gmail.com', 1, '1cYCRybKSl');

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
  ADD PRIMARY KEY (`id_fasilitas`),
  ADD KEY `id_destinasi` (`id_destinasi`);

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
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `id_destinasi` (`id_destinasi`);

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
-- Indexes for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indexes for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indexes for table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indexes for table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indexes for table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indexes for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indexes for table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indexes for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indexes for table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indexes for table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indexes for table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indexes for table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indexes for table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

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
  MODIFY `id_booking` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `destinasi`
--
ALTER TABLE `destinasi`
  MODIFY `id_destinasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `destinasi_like`
--
ALTER TABLE `destinasi_like`
  MODIFY `id_like` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `detail_user`
--
ALTER TABLE `detail_user`
  MODIFY `id_detail_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `fasilitas_include`
--
ALTER TABLE `fasilitas_include`
  MODIFY `id_fasilitas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT for table `harga`
--
ALTER TABLE `harga`
  MODIFY `id_harga` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `inbox`
--
ALTER TABLE `inbox`
  MODIFY `id_inbox` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `inboxbalas`
--
ALTER TABLE `inboxbalas`
  MODIFY `id_balas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

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
-- AUTO_INCREMENT for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

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
-- Constraints for table `fasilitas_include`
--
ALTER TABLE `fasilitas_include`
  ADD CONSTRAINT `fasilitas_include_ibfk_1` FOREIGN KEY (`id_destinasi`) REFERENCES `destinasi` (`id_destinasi`) ON DELETE CASCADE ON UPDATE NO ACTION;

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
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`id_destinasi`) REFERENCES `destinasi` (`id_destinasi`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `paket`
--
ALTER TABLE `paket`
  ADD CONSTRAINT `paket_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
