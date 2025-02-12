-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Feb 2025 pada 18.47
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pemesanan_tiket_bioskop`
--

-- --------------------------------------------------------
CREATE TABLE admin (
  id int(32) NOT NULL,
  username varchar(32) NOT NULL,
  password varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table admin
--

INSERT INTO admin (id, username, password) VALUES
(1, 'saya', 'saya');

-- --------------------------------------------------------

--
-- Table structure for table data
--

CREATE TABLE data (
  id int(32) NOT NULL,
  f_name varchar(32) NOT NULL,
  f_harga int(8) NOT NULL,
  f_seat int(2) NOT NULL,
  sinopsis varchar(1000) NOT NULL,
  image_link varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Struktur dari tabel `data`
--

CREATE TABLE `data` (
  `id` int(32) NOT NULL,
  `f_name` varchar(32) NOT NULL,
  `f_harga` int(8) NOT NULL,
  `f_seat` int(2) NOT NULL,
  `sinopsis` varchar(1000) NOT NULL,
  `image_link` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `data`
--

INSERT INTO `data` (`id`, `f_name`, `f_harga`, `f_seat`, `sinopsis`, `image_link`) VALUES
(1, 'Avenger Endgame (2019)', 35000, 38, 'Avengers: Endgame (2019) adalah puncak dari perjalanan panjang para pahlawan Marvel. Setelah Thanos menghapus setengah dari kehidupan di alam semesta dengan Infinity Gauntlet, para Avengers yang tersisa—Iron Man, Captain America, Thor, Hulk, Black Widow, dan Hawkeye—berusaha mencari cara untuk mengembalikan semua yang hilang.\r\nDengan bantuan Ant-Man dan konsep Quantum Realm, mereka melakukan perjalanan waktu untuk mengumpulkan Infinity Stones sebelum Thanos mendapatkannya. Misi ini membawa mereka ke berbagai momen penting di masa lalu Marvel Cinematic Universe. Namun, Thanos dari masa lalu mengetahui rencana mereka dan terjadi pertarungan epik di akhir film.\r\nDengan pengorbanan besar dari Iron Man, yang menggunakan Infinity Stones untuk mengalahkan Thanos dan pasukannya, dunia akhirnya diselamatkan. Namun, kemenangan ini harus dibayar mahal dengan kehilangan beberapa pahlawan, termasuk Black Widow dan Iron Man. Film ini mengakhiri era para Avengers asli dan membuka jalan bagi generasi ', '../img/avenger.jpg'),
(2, 'Batman vs Superman', 40000, 44, 'Setelah pertempuran Superman dengan Zod di Man of Steel, banyak orang menyalahkan Superman atas kehancuran di Metropolis. Batman, yang merasa Superman adalah ancaman, memutuskan untuk menghentikannya. Sementara itu, Superman juga berusaha mencari tahu motif Batman yang semakin brutal.\r\nLex Luthor, seorang pengusaha jenius, memanipulasi Batman dan Superman untuk saling bertarung. Pertarungan sengit tak terhindarkan, tetapi mereka akhirnya menyadari bahwa mereka berdua adalah korban manipulasi Luthor. Mereka bersatu untuk mengalahkan Luthor dan Doomsday, monster ciptaan Luthor yang sangat kuat.\r\nWonder Woman ikut bergabung dalam pertarungan. Superman mengorbankan dirinya untuk mengalahkan Doomsday.', '../img/Dawn of Justice.png'),
(3, 'doctor strange movie', 30000, 45, 'Doctor Strange adalah film Marvel yang mengisahkan Dr. Stephen Strange, seorang ahli bedah jenius tetapi arogan, yang kehilangan kemampuannya setelah kecelakaan mobil tragis. Dalam pencariannya untuk kesembuhan, ia menemukan Kamar-Taj, tempat misterius yang mengajarkannya seni mistis. Dibimbing oleh Ancient One, Strange belajar sihir dan menjadi penyihir kuat yang melindungi dunia dari ancaman dimensi gelap, termasuk Kaecilius dan Dormammu. Dengan mengorbankan ego dan menerima takdir barunya, ia menjadi Sorcerer Supreme dan penjaga realitas dari ancaman magis.', '../img/doctor strange.png'),
(4, 'justice league advance', 35000, 45, 'Setelah kematian Superman, Batman merasa bersalah dan terdorong untuk membentuk tim superhero. Bersama Wonder Woman, Flash, Cyborg, dan Aquaman, mereka bersatu untuk menghadapi Steppenwolf, jenderal dari planet Apokolips, yang datang ke Bumi untuk mencari tiga Mother Box.\r\nSteppenwolf dan pasukannya, Parademons, menimbulkan kekacauan di seluruh dunia. Justice League harus bekerja sama untuk mengalahkan Steppenwolf dan mencegahnya mendapatkan Mother Box, yang dapat menghancurkan Bumi. Selain berjuang melawan musuh, mereka juga harus mengatasi perbedaan mereka dan belajar untuk bekerja sebagai tim.', '../img/justice league.png'),
(5, 'Spiderman', 25000, 45, 'Spider-Man bercerita tentang Peter Parker, seorang remaja biasa yang mendapat kekuatan super setelah digigit oleh laba-laba radioaktif. Dengan kemampuan barunya, seperti kekuatan luar biasa, kelincahan, dan kemampuan menempel di dinding, Peter awalnya menggunakan kekuatannya untuk keuntungan pribadi. Namun, setelah kematian tragis Paman Ben akibat kejahatan yang bisa dicegahnya, Peter menyadari bahwa \"dengan kekuatan besar datang tanggung jawab besar.\"\r\nIa pun memutuskan untuk menjadi pahlawan super bernama Spider-Man, melindungi kota dari berbagai ancaman dan musuh berbahaya seperti Green Goblin, Doctor Octopus, dan Venom, sambil berjuang menghadapi tantangan dalam kehidupan pribadinya.', '../img/spiderman.jpg');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `data`
--
ALTER TABLE `data`
  MODIFY `id` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
