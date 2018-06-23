-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 23, 2018 at 10:58 AM
-- Server version: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zoo`
--

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

CREATE TABLE `animal` (
  `animal_id` int(11) NOT NULL,
  `animal_name` varchar(30) NOT NULL,
  `animal_cage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `animal`
--

INSERT INTO `animal` (`animal_id`, `animal_name`, `animal_cage`) VALUES
(1, 'Rex', 1),
(2, 'Tuzik', 1),
(4, 'Pufik', 2);

-- --------------------------------------------------------

--
-- Table structure for table `cage`
--

CREATE TABLE `cage` (
  `cage_id` int(11) NOT NULL,
  `cage_type` enum('small','medium','large') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cage`
--

INSERT INTO `cage` (`cage_id`, `cage_type`) VALUES
(1, 'small'),
(2, 'large');

-- --------------------------------------------------------

--
-- Table structure for table `check`
--

CREATE TABLE `check` (
  `cage` int(11) NOT NULL,
  `overseer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `check`
--

INSERT INTO `check` (`cage`, `overseer`) VALUES
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `overseer`
--

CREATE TABLE `overseer` (
  `overseer_id` int(11) NOT NULL,
  `overseer_name` varchar(30) NOT NULL,
  `overseer_experience` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `overseer`
--

INSERT INTO `overseer` (`overseer_id`, `overseer_name`, `overseer_experience`) VALUES
(1, 'indiana jones', 16),
(2, 'maugli', 19);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`animal_id`),
  ADD KEY `animal_cage` (`animal_cage`);

--
-- Indexes for table `cage`
--
ALTER TABLE `cage`
  ADD PRIMARY KEY (`cage_id`);

--
-- Indexes for table `check`
--
ALTER TABLE `check`
  ADD KEY `cage` (`cage`),
  ADD KEY `overseer` (`overseer`);

--
-- Indexes for table `overseer`
--
ALTER TABLE `overseer`
  ADD PRIMARY KEY (`overseer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
  MODIFY `animal_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `cage`
--
ALTER TABLE `cage`
  MODIFY `cage_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `overseer`
--
ALTER TABLE `overseer`
  MODIFY `overseer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`animal_cage`) REFERENCES `cage` (`cage_id`);

--
-- Constraints for table `check`
--
ALTER TABLE `check`
  ADD CONSTRAINT `check_ibfk_1` FOREIGN KEY (`overseer`) REFERENCES `overseer` (`overseer_id`),
  ADD CONSTRAINT `check_ibfk_2` FOREIGN KEY (`cage`) REFERENCES `cage` (`cage_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
