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


-- Dumping database structure for hbsds
CREATE DATABASE IF NOT EXISTS `hbsds` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hbsds`;

-- Dumping structure for table hbsds.alert
CREATE TABLE IF NOT EXISTS `alert` (
  `ID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `Title` varchar(1000) NOT NULL,
  `Message` varchar(2000) NOT NULL,
  `viewed` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table hbsds.alert: ~7 rows (approximately)
DELETE FROM `alert`;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` (`ID`, `Title`, `Message`, `viewed`) VALUES
	(1, 'HolidayRequest', 'leave request made by employee ID : 1 name : Admin Admin for reason : fever  from : 2022-04-23 to : 2022-04-24', 0),
	(2, 'HolidayRequest', 'leave request made by employee ID : 1 name : Admin Admin for reason : fever from : 2022-04-22 to : 2022-04-22', 0),
	(3, 'HolidayRequest', 'leave request made by employee ID : 2 name : Peter112 for reason : rse rgesr from : 2022-04-30 to : 2022-05-26', 0),
	(4, 'HolidayRequest', 'leave request made by employee ID : 2 name : Peter112 for reason : rthrth from : 2022-04-21 to : 2022-06-23', 0),
	(5, 'HolidayRequest', 'leave request made by employee ID : 2 name : Peter112 for reason : rdth rd h from : 2022-04-22 to : 2022-05-26', 0),
	(6, 'HolidayRequest', 'leave request made by employee ID : 2 name : Peter112121 for reason : family  from : 2022-04-29 to : 2022-05-17', 0),
	(7, 'HolidayRequest', 'leave request made by employee ID : 2 name : Peter112121 for reason : health from : 2022-04-28 to : 2022-05-27', 0);
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;

-- Dumping structure for table hbsds.department
CREATE TABLE IF NOT EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table hbsds.department: ~6 rows (approximately)
DELETE FROM `department`;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`, `name`) VALUES
	(1, 'Engineering'),
	(2, 'Plumbing'),
	(3, 'Roofing'),
	(4, 'Carpentry'),
	(5, 'Bricklaying'),
	(6, 'Office');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for table hbsds.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentid` int(11) NOT NULL DEFAULT 0,
  `roleid` int(11) NOT NULL DEFAULT 0,
  `totalholidays` int(11) NOT NULL DEFAULT 0,
  `holidaybal` int(11) NOT NULL DEFAULT 0,
  `reportingto` int(11) NOT NULL DEFAULT 0,
  `hod` int(11) NOT NULL DEFAULT 0,
  `firstname` varchar(50) NOT NULL DEFAULT '0',
  `lastname` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `employeetype` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  KEY `departmentid` (`departmentid`),
  KEY `reportingto` (`reportingto`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`departmentid`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`reportingto`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- Dumping data for table hbsds.employee: ~5 rows (approximately)
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `departmentid`, `roleid`, `totalholidays`, `holidaybal`, `reportingto`, `hod`, `firstname`, `lastname`, `email`, `employeetype`, `password`) VALUES
	(1, 1, 1, 30, 30, 1, 1, 'admin', 'admin', 'admin@admin.com', 'admin', 'admin'),
	(23, 1, 1, 30, 30, 23, 1, 'panday', 'panday', 'wajahat@gmail.com', 'staff', 'asdf'),
	(24, 1, 2, 30, 30, 23, 0, 'roja', 'roja', 'roja@gmail.com', 'staff', 'asdf'),
	(25, 1, 3, 30, 30, 23, 0, 'pandy', 'pandy', 'pandy@gmail.com', 'staff', 'asdf');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table hbsds.holiday
CREATE TABLE IF NOT EXISTS `holiday` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empid` int(11) NOT NULL,
  `assignedto` int(11) NOT NULL,
  `holidaydate` date NOT NULL,
  `requestdate` date NOT NULL,
  `reason` varchar(50) NOT NULL DEFAULT '',
  `status` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `FK_1` (`assignedto`),
  KEY `FK_2` (`empid`),
  CONSTRAINT `FK_1` FOREIGN KEY (`assignedto`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_2` FOREIGN KEY (`empid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- Dumping data for table hbsds.holiday: ~15 rows (approximately)
DELETE FROM `holiday`;
/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
INSERT INTO `holiday` (`id`, `empid`, `assignedto`, `holidaydate`, `requestdate`, `reason`, `status`) VALUES
	(8, 24, 23, '2022-07-18', '2022-07-13', 'visiting family', 'APPROVED'),
	(32, 24, 23, '2022-07-15', '2022-07-14', 'asdf', 'APPROVED'),
	(33, 24, 23, '2022-07-16', '2022-07-14', 'asdf', 'REJECTED'),
	(34, 24, 23, '2022-07-17', '2022-07-14', 'asdf', 'APPROVED'),
	(35, 24, 23, '2022-07-18', '2022-07-14', 'asdf', 'APPROVED'),
	(36, 24, 23, '2022-07-19', '2022-07-14', 'asdf', 'REJECTED'),
	(41, 23, 23, '2022-07-18', '2022-07-15', 'visiting family', 'RAISED'),
	(43, 23, 23, '2022-07-20', '2022-07-15', 'visiting family', 'RAISED'),
	(46, 23, 23, '2022-07-23', '2022-07-15', 'visiting family', 'RAISED'),
	(49, 23, 23, '2022-07-26', '2022-07-15', 'visiting family', 'RAISED'),
	(50, 23, 23, '2022-07-27', '2022-07-15', 'visiting family', 'RAISED'),
	(51, 23, 23, '2022-07-15', '2022-07-15', 'asdf', 'RAISED'),
	(52, 23, 23, '2022-07-16', '2022-07-15', 'asdf', 'RAISED'),
	(54, 23, 23, '2022-07-18', '2022-07-15', 'asdf', 'RAISED'),
	(55, 23, 23, '2022-07-19', '2022-07-15', 'asdf', 'RAISED');
/*!40000 ALTER TABLE `holiday` ENABLE KEYS */;

-- Dumping structure for table hbsds.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table hbsds.role: ~6 rows (approximately)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'Head'),
	(2, 'Deputy Head'),
	(3, 'Manager'),
	(4, 'Apprentice'),
	(5, 'Junior member'),
	(6, 'Senior member');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
