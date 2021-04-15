-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2021 at 06:20 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `user_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `prefix` varchar(5) NOT NULL DEFAULT 'MCC',
  `address_id` int(3) NOT NULL,
  `street1` varchar(255) DEFAULT NULL,
  `street2` varchar(255) DEFAULT NULL,
  `village_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`prefix`, `address_id`, `street1`, `street2`, `village_id`) VALUES
('MCC', 1, 'Komplek Rs. Islam Blok J No.7 RT 003 RW 001', NULL, 5),
('MCC', 2, 'Dayung 3C No.13 RT 004 RW 006', NULL, 9),
('MCC', 3, 'Jend Sudirman No.1 RT 001 RW 003', NULL, 6),
('MCC', 4, 'H.Selong Gg.Marzuki RT 001 RW 001', NULL, 3),
('MCC', 5, 'Dsn. Kauman Lor No.15 RT 010 RW 001', NULL, 7),
('MCC', 6, 'Paus Komplek Benni No.15 RT 004 RW 004', NULL, 10),
('MCC', 7, 'Jatinegara No.230/125 RT 008 RW 002', NULL, 8),
('MCC', 8, 'Kaliurang km 10,5 Gadingan RT 003 RW 008', NULL, 12),
('MCC', 9, 'Dr. Susilo V No.80 RT 003 RW 005', NULL, 9),
('MCC', 10, 'Ancol Utara 1 No.78A RT 002 RW 007', NULL, 1),
('MCC', 12, 'Masda No 25 B RT 005 RW 009', NULL, 11),
('MCC', 13, 'KI Hajar Dewantara KP sukamantri RT 004 RW 001', NULL, 13),
('MCC', 14, 'bebas', 'bebas', 1),
('MCC', 15, NULL, NULL, 5),
('MCC', 16, 'bebas', 'bebas', 1),
('MCC', 17, 'bebas', 'bebas', 1),
('MCC', 18, 'bebas', 'bebas', 1);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `prefix` varchar(5) NOT NULL DEFAULT 'MCC',
  `contact_id` int(3) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `linkedin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`prefix`, `contact_id`, `phone`, `linkedin`) VALUES
('MCC', 1, '087708771440', 'linkedin.com/in/ikhsansyahbanu/'),
('MCC', 2, '08998463015', 'linkedin.com/in/ristia-panji/'),
('MCC', 3, '089565447621', 'linkedin.com/in/fadelmnst/'),
('MCC', 4, '081261119417', 'linkedin.com/in/rafimdifany/'),
('MCC', 5, '085730796818', 'linkedin.com/in/christina-regita-kumala-sari/'),
('MCC', 6, '082289756578', 'linkedin.com/in/yosie-fridolin/'),
('MCC', 7, '082214687574 ', 'linkedin.com/in/braja98/'),
('MCC', 8, '081392578786', 'linkedin.com/in/florentinavela/'),
('MCC', 9, '0895606123796', 'linkedin.com/in/jedwins/'),
('MCC', 10, '08561389666', 'linkedin.com/in/zahrazakiyahsalsabilakurnia/'),
('MCC', 12, '087782082058', 'linkedin/williamyangjaya'),
('MCC', 13, '089614533736', 'linkedin.com/in/arnumsari17/'),
('MCC', 14, '083749374', 'apaaja'),
('MCC', 15, '089614533736', 'linkedin/arnum'),
('MCC', 16, '083749374', 'apaaja'),
('MCC', 17, '083749374', 'apaaja'),
('MCC', 18, '083749374', 'apaaja');

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `district_id` int(3) NOT NULL,
  `kab` varchar(10) NOT NULL,
  `district_name` varchar(50) NOT NULL,
  `province_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`district_id`, `kab`, `district_name`, `province_id`) VALUES
(1, 'Kota', 'Bandung', 4),
(2, 'Kota', 'Bekasi', 4),
(3, 'Kab.', 'Bekasi', 4),
(4, 'Kota', 'Jakarta Barat', 3),
(5, 'Kota', 'Jakarta Timur', 3),
(6, 'Kota', 'Jakarta Utara', 3),
(7, 'Kota', 'Palembang', 7),
(8, 'Kota', 'Pekanbaru', 6),
(9, 'Kab.', 'Semarang', 5),
(10, 'Kab.', 'Sleman', 2),
(11, 'Kab.', 'Tangerang', 1);

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE `education` (
  `prefix` varchar(5) NOT NULL DEFAULT 'MCC',
  `education_id` int(3) NOT NULL,
  `degree` enum('D3','D4','S1','S2','S3') DEFAULT NULL,
  `major_id` int(2) NOT NULL,
  `university_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `education`
--

INSERT INTO `education` (`prefix`, `education_id`, `degree`, `major_id`, `university_id`) VALUES
('MCC', 1, 'S1', 13, 5),
('MCC', 2, 'S1', 10, 7),
('MCC', 3, 'S1', 9, 13),
('MCC', 4, 'S1', 13, 2),
('MCC', 5, 'S1', 13, 9),
('MCC', 6, 'D4', 13, 3),
('MCC', 7, 'S1', 8, 12),
('MCC', 8, 'S1', 11, 6),
('MCC', 9, 'S1', 12, 1),
('MCC', 10, 'D4', 14, 4),
('MCC', 12, 'S1', 8, 8),
('MCC', 13, 'S1', 8, 11),
('MCC', 14, 'S1', 8, 8),
('MCC', 15, NULL, 10, 2),
('MCC', 16, 'S1', 8, 8),
('MCC', 17, 'S1', 8, 8),
('MCC', 18, 'S1', 8, 8);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `prefix` varchar(5) NOT NULL DEFAULT 'MCC',
  `employee_id` int(3) NOT NULL,
  `employee_name` varchar(50) NOT NULL,
  `birth_date` date NOT NULL,
  `gender` enum('Laki-laki','Perempuan') NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`prefix`, `employee_id`, `employee_name`, `birth_date`, `gender`, `email`) VALUES
('MCC', 1, 'Ikhsan Nur Syahbanu', '1997-12-28', 'Laki-laki', 'ikhsan.syahbanu@mii.co.id'),
('MCC', 2, 'Ristia Muhamamd Panji Winarrman', '1998-10-05', 'Laki-laki', 'ristiapanji@gmail.com'),
('MCC', 3, 'Fadel Muhammad Nasution', '1992-02-29', 'Laki-laki', 'fadelmn21@gmail.com'),
('MCC', 4, 'Rafi Mufadhal Difany', '1998-05-08', 'Laki-laki', 'rafimdifany@gmail.com'),
('MCC', 5, 'Christina Regita Kumala Sari', '1997-04-24', 'Perempuan', 'christinaregita24@gmail.com'),
('MCC', 6, 'Yosie Fridolin', '1998-06-01', 'Perempuan', 'yosiefridolin01@gmail.com'),
('MCC', 7, 'Jaka Brajadenta', '1998-04-04', 'Laki-laki', 'jakabrajadenta@gmail.com'),
('MCC', 8, 'Florentina Vela Nindyasari', '1998-07-20', 'Perempuan', 'florentinavela.n@gmail.com'),
('MCC', 9, 'Jarister Edwins Silalahi', '1998-03-25', 'Laki-laki', 'jarister.silalahi@ms.mii.co.id'),
('MCC', 10, 'Zahra Zakiyah Salsabila Kurnia', '1997-09-27', 'Perempuan', 'zahrazakiyah@gmail.com'),
('MCC', 12, 'William Yangjaya', '1997-03-01', 'Laki-laki', 'william.yangjaya@ms.mii.co.id'),
('MCC', 13, 'Arnum Sari Khoirunnisa', '1998-04-17', 'Perempuan', 'arnum.khoirunnisa@ms.mii.co.id'),
('MCC', 14, 'Percobaan', '1997-09-27', 'Perempuan', 'abc@abc.com'),
('MCC', 15, 'Arnum Sari Khoi', '1999-10-10', 'Perempuan', 'arnumsari17@gmail.com'),
('MCC', 16, 'Zaaaaki', '2000-08-08', 'Perempuan', 'auauau@hehe.com'),
('MCC', 17, 'Percobaan3', '1997-09-27', 'Perempuan', 'zzz@gmail.com'),
('MCC', 18, 'Percobaan3', '1997-09-27', 'Perempuan', 'hehe@gmail.com'),
('MCC', 19, 'Admin', '2021-04-01', 'Laki-laki', 'admin@admin.com'),
('MCC', 20, 'Trainer', '2021-04-02', 'Perempuan', 'trainer@trainer.com'),
('MCC', 21, 'Trainee', '2021-04-03', 'Laki-laki', 'trainee@trainee.com'),
('MCC', 22, 'syalala', '2021-04-02', 'Laki-laki', 'lala@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `major`
--

CREATE TABLE `major` (
  `major_id` int(2) NOT NULL,
  `major_name` varchar(50) NOT NULL,
  `count` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `major`
--

INSERT INTO `major` (`major_id`, `major_name`, `count`) VALUES
(8, 'Fisika', 3),
(9, 'Matematika', 1),
(10, 'Sistem Informasi', 1),
(11, 'Teknik Fisika', 1),
(12, 'Teknik Geofisika', 1),
(13, 'Teknik Informatika', 5),
(14, 'Teknik Telekomunikasi', 1);

-- --------------------------------------------------------

--
-- Table structure for table `privileges`
--

CREATE TABLE `privileges` (
  `privilege_id` int(3) NOT NULL,
  `privilege_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `privileges`
--

INSERT INTO `privileges` (`privilege_id`, `privilege_name`) VALUES
(1, 'create'),
(2, 'read'),
(3, 'update'),
(4, 'delete');

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `province_id` int(2) NOT NULL,
  `province_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`province_id`, `province_name`) VALUES
(1, 'Banten'),
(2, 'DIY'),
(3, 'DKI Jakarta'),
(4, 'Jawa Barat'),
(5, 'Jawa Tengah'),
(6, 'Riau'),
(7, 'Sumatera Selatan');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(3) NOT NULL,
  `role_name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'admin'),
(2, 'trainer'),
(3, 'trainee');

-- --------------------------------------------------------

--
-- Table structure for table `role_privileges`
--

CREATE TABLE `role_privileges` (
  `privilege_id` int(3) NOT NULL,
  `role_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role_privileges`
--

INSERT INTO `role_privileges` (`privilege_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(1, 3),
(2, 3),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `subdistrict`
--

CREATE TABLE `subdistrict` (
  `subdistrict_id` int(4) NOT NULL,
  `subdistrict_name` varchar(50) NOT NULL,
  `district_id` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subdistrict`
--

INSERT INTO `subdistrict` (`subdistrict_id`, `subdistrict_name`, `district_id`) VALUES
(1, 'Batununggal', 1),
(2, 'Bekasi Utara', 2),
(3, 'Cakung', 5),
(4, 'Cengkareng', 4),
(5, 'Grogol Petamburan', 4),
(6, 'Kalidoni', 7),
(7, 'Karang Bahagia', 3),
(8, 'Kelapa Dua', 11),
(9, 'Ngaglik', 10),
(10, 'Pabelan', 9),
(11, 'Penjaringan', 6),
(12, 'Regol', 1),
(13, 'Rumbai', 8);

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

CREATE TABLE `university` (
  `university_id` int(2) NOT NULL,
  `university_name` varchar(50) NOT NULL,
  `counts` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `university`
--

INSERT INTO `university` (`university_id`, `university_name`, `counts`) VALUES
(1, 'Institut Teknologi Bandung', 1),
(2, 'Institut Teknologi PLN', 1),
(3, 'Politeknik Caltex Riau', 1),
(4, 'Politeknik Negeri Bandung', 1),
(5, 'Universitas Amikom Yogyakarta', 1),
(6, 'Universitas Gadjah Mada', 1),
(7, 'Universitas Gunadarma', 1),
(8, 'Universitas Indonesia', 1),
(9, 'Universitas Kristen Satya Wacana', 1),
(10, 'Universitas Muhammadiyah Jakarta', 1),
(11, 'Universitas Negeri Yogyakarta', 1),
(12, 'Universitas Pendidikan Indonesia', 1),
(13, 'Universitas Sriwijaya', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(3) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `user_password`) VALUES
(1, 'ikhsan_1', 'ikhsan123'),
(2, 'panji_2', 'panji123'),
(3, 'fadel_3', 'fadel123'),
(4, 'rafi_4', 'rafi123'),
(5, 'regita_5', 'regita123'),
(6, 'yosie_6', 'yosie123'),
(7, 'jaka_7', 'jaka123'),
(8, 'vela_8', 'vela123'),
(9, 'edwin_9', 'edwin123'),
(10, 'zaki_10', 'zaki123'),
(12, 'wiliam_12', 'wiliam123'),
(13, 'arnum_13', 'arnum123'),
(14, 'percobaan', 'percobaan123'),
(16, 'percobaan2', 'percobaan123'),
(17, 'percobaan3', '$2a$10$Nm.aKewc.vHARTLlMtR.6.7ZUORA8ARZ/oatl4kuHCEDTKEPspQTu'),
(18, 'percobaan4', '$2a$10$3Io0XxcCg9tUg3rSpfp8..RpFF2cW.NMtD6PZb87J8DA4chdCWVQ2'),
(19, 'admin', '$2b$10$tbNjkxK3kO3Jacsbm0eLYe5mgAXje/HH4qWAQMkGoux1nSNGhnYpe'),
(20, 'trainer', '$2b$10$qcLiKWoFyRXGBOPSDY2XfOQxe6cKJd3mxcU.etsy6pBiHJm30YEeG'),
(21, 'trainee', '$2b$10$wNmN5vN/jjHmJdknupurkugFqcUcSqV9pgXOZXiwMYWGIuuGczIwS');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(3) NOT NULL,
  `role_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(2, 2),
(3, 1),
(4, 2),
(4, 1),
(5, 1),
(6, 2),
(7, 1),
(7, 2),
(8, 2),
(9, 1),
(10, 2),
(12, 2),
(13, 1),
(1, 1),
(1, 2),
(14, 3),
(16, 3),
(17, 3),
(18, 3),
(19, 1),
(20, 2),
(21, 3);

-- --------------------------------------------------------

--
-- Table structure for table `village`
--

CREATE TABLE `village` (
  `village_id` int(5) NOT NULL,
  `village_name` varchar(50) NOT NULL,
  `zip_code` varchar(5) NOT NULL,
  `subdistrict_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `village`
--

INSERT INTO `village` (`village_id`, `village_name`, `zip_code`, `subdistrict_id`) VALUES
(1, 'Balonggede', '40215', 12),
(2, 'Cakung Barat', '13910', 3),
(3, 'Durikosambi', '11750', 4),
(4, 'Grogol', '11450', 5),
(5, 'Harapan Jaya', '17124', 2),
(6, 'Kalidoni', '30119', 6),
(7, 'Kauman', '50771', 10),
(8, 'Kebonwaru', '40272', 1),
(9, 'Kelapa Dua', '15811', 8),
(10, 'Limbungan Baru', '28261', 13),
(11, 'Pejagalan', '14450', 11),
(12, 'Sinduharjo', '55581', 9),
(13, 'Sukaraya', '17530', 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`),
  ADD UNIQUE KEY `prefix` (`prefix`,`address_id`),
  ADD KEY `village_id` (`village_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contact_id`),
  ADD UNIQUE KEY `prefix` (`prefix`,`contact_id`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`district_id`),
  ADD KEY `province_id` (`province_id`);

--
-- Indexes for table `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`education_id`),
  ADD UNIQUE KEY `prefix` (`prefix`,`education_id`),
  ADD KEY `major_id` (`major_id`),
  ADD KEY `education_id` (`education_id`),
  ADD KEY `university_id` (`university_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD UNIQUE KEY `prefix` (`prefix`,`employee_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `major`
--
ALTER TABLE `major`
  ADD PRIMARY KEY (`major_id`);

--
-- Indexes for table `privileges`
--
ALTER TABLE `privileges`
  ADD PRIMARY KEY (`privilege_id`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`province_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `role_privileges`
--
ALTER TABLE `role_privileges`
  ADD KEY `fk_privilege_k` (`privilege_id`),
  ADD KEY `fk_role_k` (`role_id`);

--
-- Indexes for table `subdistrict`
--
ALTER TABLE `subdistrict`
  ADD PRIMARY KEY (`subdistrict_id`),
  ADD KEY `district_id` (`district_id`);

--
-- Indexes for table `university`
--
ALTER TABLE `university`
  ADD PRIMARY KEY (`university_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_name` (`user_name`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `fk_users` (`user_id`),
  ADD KEY `fk_role` (`role_id`);

--
-- Indexes for table `village`
--
ALTER TABLE `village`
  ADD PRIMARY KEY (`village_id`),
  ADD KEY `subdistrict_id` (`subdistrict_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `address_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `contact_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `district`
--
ALTER TABLE `district`
  MODIFY `district_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `education`
--
ALTER TABLE `education`
  MODIFY `education_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `major`
--
ALTER TABLE `major`
  MODIFY `major_id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `province_id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `subdistrict`
--
ALTER TABLE `subdistrict`
  MODIFY `subdistrict_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `university`
--
ALTER TABLE `university`
  MODIFY `university_id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `village`
--
ALTER TABLE `village`
  MODIFY `village_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `addess_aid_fk` FOREIGN KEY (`address_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `village_vid_fk` FOREIGN KEY (`village_id`) REFERENCES `village` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_cid_fk` FOREIGN KEY (`contact_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `province_pid_fk` FOREIGN KEY (`province_id`) REFERENCES `province` (`province_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `education`
--
ALTER TABLE `education`
  ADD CONSTRAINT `education_eid_fk` FOREIGN KEY (`education_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `major_mid_fk` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `university_uid_fk` FOREIGN KEY (`university_id`) REFERENCES `university` (`university_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `role_privileges`
--
ALTER TABLE `role_privileges`
  ADD CONSTRAINT `fk_privilege` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`privilege_id`),
  ADD CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `subdistrict`
--
ALTER TABLE `subdistrict`
  ADD CONSTRAINT `district_did_fk` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `employee` (`employee_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `village`
--
ALTER TABLE `village`
  ADD CONSTRAINT `subdistrict_sid_fk` FOREIGN KEY (`subdistrict_id`) REFERENCES `subdistrict` (`subdistrict_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
