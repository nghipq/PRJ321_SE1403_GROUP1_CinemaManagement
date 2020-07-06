-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 06, 2020 at 09:12 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `group1`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bId` int(11) NOT NULL,
  `cusId` int(11) DEFAULT NULL,
  `sId` int(11) DEFAULT NULL,
  `dateBuy` datetime NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `billdetail`
--

CREATE TABLE `billdetail` (
  `tId` int(11) DEFAULT NULL,
  `bId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `cateId` int(11) NOT NULL,
  `cateName` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL,
  `description` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `categoryinfilm`
--

CREATE TABLE `categoryinfilm` (
  `fId` int(11) NOT NULL,
  `cateId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `cusId` int(11) NOT NULL,
  `levelAccount` int(11) NOT NULL,
  `totalPrice` int(11) NOT NULL,
  `totalTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

CREATE TABLE `films` (
  `fId` int(11) NOT NULL,
  `fName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `pId` int(11) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `limitAge` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `releaseDate` datetime NOT NULL,
  `airDate` datetime NOT NULL,
  `endDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `formality`
--

CREATE TABLE `formality` (
  `fmId` int(11) NOT NULL,
  `fmName` varchar(5) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `ticketPrice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `graphic`
--

CREATE TABLE `graphic` (
  `gId` int(11) NOT NULL,
  `fId` int(11) DEFAULT NULL,
  `dateUpdate` datetime NOT NULL,
  `path` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nationality`
--

CREATE TABLE `nationality` (
  `nId` int(11) NOT NULL,
  `nName` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `pId` int(11) NOT NULL,
  `dName` varchar(25) COLLATE utf8_vietnamese_ci NOT NULL,
  `nId` int(11) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `birthday` datetime NOT NULL,
  `description` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `rId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `personinfilm`
--

CREATE TABLE `personinfilm` (
  `fId` int(11) NOT NULL,
  `pId` int(11) DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `producers`
--

CREATE TABLE `producers` (
  `pId` int(11) NOT NULL,
  `pName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `nId` int(11) DEFAULT NULL,
  `description` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `birthday` datetime NOT NULL,
  `address` varchar(500) COLLATE utf8_vietnamese_ci NOT NULL,
  `phoneNumber` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `rId` int(11) NOT NULL,
  `rName` varchar(25) COLLATE utf8_vietnamese_ci NOT NULL,
  `rDescription` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `rId` int(11) NOT NULL,
  `seatNumber` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `rStatus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roomseat`
--

CREATE TABLE `roomseat` (
  `seatId` int(11) NOT NULL,
  `rId` int(11) DEFAULT NULL,
  `seatName` varchar(2) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `scheId` int(11) NOT NULL,
  `sesId` int(11) DEFAULT NULL,
  `fmId` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `sesId` int(11) NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `sId` int(11) NOT NULL,
  `levelStaff` int(11) NOT NULL,
  `CMND` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `tId` int(11) NOT NULL,
  `scheId` int(11) DEFAULT NULL,
  `seatId` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `updatehistory`
--

CREATE TABLE `updatehistory` (
  `upId` int(11) NOT NULL,
  `fId` int(11) DEFAULT NULL,
  `sId` int(11) DEFAULT NULL,
  `content` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uId` int(11) NOT NULL,
  `username` varchar(25) COLLATE utf8_vietnamese_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `birthday` datetime NOT NULL,
  `nId` int(11) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `address` varchar(500) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `regisDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `permission` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bId`),
  ADD KEY `cusId` (`cusId`),
  ADD KEY `sId` (`sId`);

--
-- Indexes for table `billdetail`
--
ALTER TABLE `billdetail`
  ADD KEY `tId` (`tId`),
  ADD KEY `bId` (`bId`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`cateId`);

--
-- Indexes for table `categoryinfilm`
--
ALTER TABLE `categoryinfilm`
  ADD PRIMARY KEY (`fId`),
  ADD KEY `cateId` (`cateId`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`cusId`);

--
-- Indexes for table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`fId`),
  ADD KEY `pId` (`pId`);

--
-- Indexes for table `formality`
--
ALTER TABLE `formality`
  ADD PRIMARY KEY (`fmId`);

--
-- Indexes for table `graphic`
--
ALTER TABLE `graphic`
  ADD PRIMARY KEY (`gId`),
  ADD KEY `fId` (`fId`);

--
-- Indexes for table `nationality`
--
ALTER TABLE `nationality`
  ADD PRIMARY KEY (`nId`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`pId`),
  ADD KEY `nId` (`nId`),
  ADD KEY `rId` (`rId`);

--
-- Indexes for table `personinfilm`
--
ALTER TABLE `personinfilm`
  ADD PRIMARY KEY (`fId`),
  ADD KEY `pId` (`pId`);

--
-- Indexes for table `producers`
--
ALTER TABLE `producers`
  ADD PRIMARY KEY (`pId`),
  ADD KEY `nId` (`nId`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`rId`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`rId`);

--
-- Indexes for table `roomseat`
--
ALTER TABLE `roomseat`
  ADD PRIMARY KEY (`seatId`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`scheId`),
  ADD KEY `sesId` (`sesId`),
  ADD KEY `fmId` (`fmId`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`sesId`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`sId`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`tId`),
  ADD KEY `scheId` (`scheId`),
  ADD KEY `seatId` (`seatId`);

--
-- Indexes for table `updatehistory`
--
ALTER TABLE `updatehistory`
  ADD PRIMARY KEY (`upId`),
  ADD KEY `fId` (`fId`),
  ADD KEY `sId` (`sId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uId`),
  ADD KEY `nId` (`nId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `bId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `cateId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `fId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `formality`
--
ALTER TABLE `formality`
  MODIFY `fmId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `graphic`
--
ALTER TABLE `graphic`
  MODIFY `gId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nationality`
--
ALTER TABLE `nationality`
  MODIFY `nId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `pId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `producers`
--
ALTER TABLE `producers`
  MODIFY `pId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `rId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `rId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roomseat`
--
ALTER TABLE `roomseat`
  MODIFY `seatId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `scheId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
  MODIFY `sesId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `tId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `updatehistory`
--
ALTER TABLE `updatehistory`
  MODIFY `upId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`cusId`) REFERENCES `customers` (`cusId`),
  ADD CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`sId`) REFERENCES `staff` (`sId`);

--
-- Constraints for table `billdetail`
--
ALTER TABLE `billdetail`
  ADD CONSTRAINT `billdetail_ibfk_1` FOREIGN KEY (`tId`) REFERENCES `ticket` (`tId`),
  ADD CONSTRAINT `billdetail_ibfk_2` FOREIGN KEY (`bId`) REFERENCES `staff` (`sId`);

--
-- Constraints for table `categoryinfilm`
--
ALTER TABLE `categoryinfilm`
  ADD CONSTRAINT `categoryinfilm_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `films` (`fId`),
  ADD CONSTRAINT `categoryinfilm_ibfk_2` FOREIGN KEY (`cateId`) REFERENCES `categories` (`cateId`);

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`cusId`) REFERENCES `user` (`uId`);

--
-- Constraints for table `films`
--
ALTER TABLE `films`
  ADD CONSTRAINT `films_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `producers` (`pId`);

--
-- Constraints for table `graphic`
--
ALTER TABLE `graphic`
  ADD CONSTRAINT `graphic_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `films` (`fId`);

--
-- Constraints for table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`nId`) REFERENCES `nationality` (`nId`),
  ADD CONSTRAINT `person_ibfk_2` FOREIGN KEY (`rId`) REFERENCES `role` (`rId`);

--
-- Constraints for table `personinfilm`
--
ALTER TABLE `personinfilm`
  ADD CONSTRAINT `personinfilm_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `films` (`fId`),
  ADD CONSTRAINT `personinfilm_ibfk_2` FOREIGN KEY (`pId`) REFERENCES `person` (`pId`);

--
-- Constraints for table `producers`
--
ALTER TABLE `producers`
  ADD CONSTRAINT `producers_ibfk_1` FOREIGN KEY (`nId`) REFERENCES `nationality` (`nId`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`sesId`) REFERENCES `session` (`sesId`),
  ADD CONSTRAINT `schedule_ibfk_2` FOREIGN KEY (`fmId`) REFERENCES `formality` (`fmId`);

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `user` (`uId`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`scheId`) REFERENCES `schedule` (`scheId`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`seatId`) REFERENCES `roomseat` (`seatId`);

--
-- Constraints for table `updatehistory`
--
ALTER TABLE `updatehistory`
  ADD CONSTRAINT `updatehistory_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `films` (`fId`),
  ADD CONSTRAINT `updatehistory_ibfk_2` FOREIGN KEY (`sId`) REFERENCES `staff` (`sId`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`nId`) REFERENCES `nationality` (`nId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
