-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.11-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for holidaybooking
CREATE DATABASE IF NOT EXISTS `holidaybooking` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `holidaybooking`;

-- Dumping structure for table holidaybooking.alert
CREATE TABLE IF NOT EXISTS `alert` (
  `ID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `Title` varchar(1000) NOT NULL,
  `Message` varchar(2000) NOT NULL,
  `viewed` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table holidaybooking.alert: ~5 rows (approximately)
DELETE FROM `alert`;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` (`ID`, `Title`, `Message`, `viewed`) VALUES
	(1, 'HolidayRequest', 'leave request made by employee ID : 1 name : Admin Admin for reason : fever  from : 2022-04-23 to : 2022-04-24', 0),
	(2, 'HolidayRequest', 'leave request made by employee ID : 1 name : Admin Admin for reason : fever from : 2022-04-22 to : 2022-04-22', 0),
	(3, 'HolidayRequest', 'leave request made by employee ID : 2 name : Peter112 for reason : rse rgesr from : 2022-04-30 to : 2022-05-26', 0),
	(4, 'HolidayRequest', 'leave request made by employee ID : 2 name : Peter112 for reason : rthrth from : 2022-04-21 to : 2022-06-23', 0),
	(5, 'HolidayRequest', 'leave request made by employee ID : 2 name : Peter112 for reason : rdth rd h from : 2022-04-22 to : 2022-05-26', 0);
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;

-- Dumping structure for table holidaybooking.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `Email` varchar(2000) NOT NULL,
  `JoinDate` bigint(20) NOT NULL,
  `Department` varchar(1000) NOT NULL,
  `Role` varchar(1000) NOT NULL,
  `NumberOfAllowedLeaves` int(10) NOT NULL,
  `ID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `password` varchar(1000) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table holidaybooking.employee: ~4 rows (approximately)
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`Email`, `JoinDate`, `Department`, `Role`, `NumberOfAllowedLeaves`, `ID`, `password`) VALUES
	('admin@gmail.com', 20220100, 'Admin', 'Admin', 30, 1, '12345'),
	('peter@gmail.com', 1650582000000, 'Office', 'Head', 30, 2, '12345'),
	('pandey@gmail.com', 1650582000000, 'Office', 'Head', 30, 6, '12345'),
	('go@gmail.com', 1651186800000, 'Office', 'Head', 30, 7, '12345');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table holidaybooking.hoildayrequest
CREATE TABLE IF NOT EXISTS `hoildayrequest` (
  `ToDate` bigint(20) NOT NULL,
  `FromDate` bigint(20) NOT NULL,
  `Reason` varchar(2000) NOT NULL,
  `EmployeeID` int(20) unsigned NOT NULL,
  `ID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `Status` varchar(100) NOT NULL,
  `NumberOfDate` int(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `madeby` (`EmployeeID`),
  CONSTRAINT `madeby` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table holidaybooking.hoildayrequest: ~12 rows (approximately)
DELETE FROM `hoildayrequest`;
/*!40000 ALTER TABLE `hoildayrequest` DISABLE KEYS */;
INSERT INTO `hoildayrequest` (`ToDate`, `FromDate`, `Reason`, `EmployeeID`, `ID`, `Status`, `NumberOfDate`) VALUES
	(1650841200000, 1650668400000, 'aadadad', 1, 9, 'Reject', 3),
	(1650927600000, 1650668400000, 'fever ', 1, 10, 'Accept', 4),
	(1650668400000, 1650495600000, 'fever ', 1, 11, 'Pending', 3),
	(1650754800000, 1650668400000, 'fever ', 1, 12, 'Pending', 2),
	(1650754800000, 1650668400000, 'fever ', 1, 13, 'Pending', 2),
	(1650582000000, 1650582000000, 'fever', 1, 14, 'Reject', 1),
	(1651100400000, 1650841200000, 'aadadad', 1, 15, 'Reject', 4),
	(1651100400000, 1650841200000, 'aadadad', 1, 16, 'Accept', 4),
	(1651100400000, 1650841200000, 'aadadad', 1, 17, 'Accept', 4),
	(1653519600000, 1651273200000, 'rse rgesr', 2, 18, 'Pending', 27),
	(1655938800000, 1650495600000, 'rthrth', 2, 19, 'Pending', 64),
	(1653519600000, 1650582000000, 'rdth rd h', 2, 20, 'Reject', 35);
/*!40000 ALTER TABLE `hoildayrequest` ENABLE KEYS */;

-- Dumping structure for table holidaybooking.leaveslog
CREATE TABLE IF NOT EXISTS `leaveslog` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EmployeesID` int(20) unsigned NOT NULL,
  `Date` bigint(20) NOT NULL,
  `LeavesLeft` int(200) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `hasA` (`EmployeesID`),
  CONSTRAINT `hasA` FOREIGN KEY (`EmployeesID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table holidaybooking.leaveslog: ~3 rows (approximately)
DELETE FROM `leaveslog`;
/*!40000 ALTER TABLE `leaveslog` DISABLE KEYS */;
INSERT INTO `leaveslog` (`ID`, `EmployeesID`, `Date`, `LeavesLeft`) VALUES
	(1, 1, 1650927600000, 26),
	(2, 1, 1651100400000, 22),
	(3, 1, 1651100400000, 22);
/*!40000 ALTER TABLE `leaveslog` ENABLE KEYS */;

-- Dumping structure for table holidaybooking.person
CREATE TABLE IF NOT EXISTS `person` (
  `EmployeeID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(1000) NOT NULL,
  `Address` varchar(2000) NOT NULL,
  `PostCode` varchar(100) NOT NULL,
  `PhoneNumber` bigint(20) NOT NULL,
  `DateOFBirth` bigint(20) NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  CONSTRAINT `IsAPerson` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table holidaybooking.person: ~4 rows (approximately)
DELETE FROM `person`;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`EmployeeID`, `Name`, `Address`, `PostCode`, `PhoneNumber`, `DateOFBirth`) VALUES
	(1, 'Admin Admin', 'Head Office of Straight Walls LTD', 'RH23ER', 769774237, 19820100),
	(2, 'Peter112121', 'some', 'peter@gmail.com', 12345678, 1539644400000),
	(6, 'pandeysdfds', 'Norwich', 'E7', 7448861439, 1628636400000),
	(7, 'gosdsd', 'Norwich', 'E7', 7448861439, 1641945600000);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
