-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2019 at 12:15 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `udara`
--

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `PAYMENT_ID` int(11) NOT NULL,
  `ORDER_ID` int(11) NOT NULL,
  `PAYMENT_METHOD` varchar(20) NOT NULL,
  `TRANSACTION_ID` int(11) NOT NULL,
  `PAYMENT_STATUS` varchar(10) NOT NULL,
  `PAYMENT_CREATE_AT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`PAYMENT_ID`, `ORDER_ID`, `PAYMENT_METHOD`, `TRANSACTION_ID`, `PAYMENT_STATUS`, `PAYMENT_CREATE_AT`) VALUES
(12, 10, 'visa', 2323, 'complete', '2019-05-18 16:50:07'),
(13, 10, 'visa', 2323, 'complete', '2019-05-18 16:52:12'),
(14, 10, 'visa', 2323, 'complete', '2019-05-18 16:56:11'),
(17, 65, 'visa', 5, 'complete', '2019-05-19 06:11:09'),
(18, 65, 'visa', 6, 'complete', '2019-05-19 06:12:53'),
(19, 65, 'visa', 7, 'complete', '2019-05-19 06:16:37'),
(21, 165, 'visa', 9, 'complete', '2019-05-19 06:20:41');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`PAYMENT_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `PAYMENT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
