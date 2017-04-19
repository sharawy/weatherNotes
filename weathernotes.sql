-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2017 at 10:52 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `weathernotes`
--

-- --------------------------------------------------------

--
-- Table structure for table `predefinednote`
--

CREATE TABLE `predefinednote` (
  `id` int(11) NOT NULL,
  `value` varchar(255) NOT NULL,
  `maxTemp` double  NULL,
  `minTemp` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `predefinednote`
--

INSERT INTO `predefinednote` (`id`, `value`, `maxTemp`, `minTemp`) VALUES
(1, 'pre note 1', 10, 0),
(2, 'pre note 2', 15, 10),
(3, 'pre note 3', 20, 15),
(4, 'pre note 4', NULL, 20);

-- --------------------------------------------------------

--
-- Table structure for table `systemnote`
--

CREATE TABLE `systemnote` (
  `id` int(11) NOT NULL,
  `value` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `systemnote`
--

INSERT INTO `systemnote` (`id`, `value`, `date`) VALUES
(1, 'System Note', '2017-04-19');

-- --------------------------------------------------------

--
-- Table structure for table `userroles`
--

CREATE TABLE `userroles` (
  `userRoleId` int(11) NOT NULL,
  `userRoleName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userroles`
--

INSERT INTO `userroles` (`userRoleId`, `userRoleName`) VALUES
(2, 'Admin'),
(1, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  `userRole_userRoleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `email`, `mobile`, `password`, `userName`, `userRole_userRoleId`) VALUES
(1, 'admin@weathernotes.com', '01096106414', '123456', 'admin', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `predefinednote`
--
ALTER TABLE `predefinednote`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `systemnote`
--
ALTER TABLE `systemnote`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `date` (`date`);

--
-- Indexes for table `userroles`
--
ALTER TABLE `userroles`
  ADD PRIMARY KEY (`userRoleId`),
  ADD UNIQUE KEY `userRoleName` (`userRoleName`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `FK4E39DE87D3E366B` (`userRole_userRoleId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `predefinednote`
--
ALTER TABLE `predefinednote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `systemnote`
--
ALTER TABLE `systemnote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK4E39DE87D3E366B` FOREIGN KEY (`userRole_userRoleId`) REFERENCES `userroles` (`userRoleId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
