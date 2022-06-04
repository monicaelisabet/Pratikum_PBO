-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 30, 2022 at 10:55 AM
-- Server version: 5.7.34
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_crud_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_pelanggan`
--

CREATE TABLE `tb_pelanggan` (
  `id` int(11) NOT NULL,
  `nama_pelanggan` varchar(100) NOT NULL,
  `telpon_pelanggan` varchar(100) NOT NULL,
  `alamat_pelanggan` varchar(100) NOT NULL,
  `status_pelanggan` varchar(100) NOT NULL,
  `paket_pelanggan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_pelanggan`
--

INSERT INTO `tb_pelanggan` (`id`, `nama_pelanggan`, `telpon_pelanggan`, `alamat_pelanggan`, `status_pelanggan`, `paket_pelanggan`) VALUES
(1, 'Koko', '0812312312', 'Klaster Bugenvil', 'Kontrak 2x (2 Pemilihan)', 'SILVER (App,Hosting Max 1000 User/Day) Rp.100.000'),
(2, 'Andy', '12312', 'Jl. Pemuda', 'Kontrak 3x (3 Pemilihan)', 'PLATINUM (App,Hosting Max 5000 User/Day,Teknisi,Support 7x24) Rp.300.000'),
(3, 'Nababan', '08000111222', 'Jl. Pemudi', 'Kontrak Selamanya', 'GOLD (App,Hosting Max 2000 User/Day, Teknisi) Rp.200.000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
