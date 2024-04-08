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


-- Dumping database structure for hbs
CREATE DATABASE IF NOT EXISTS `hbs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hbs`;

-- Dumping structure for table hbs.tbl_department
CREATE TABLE IF NOT EXISTS `tbl_department` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table hbs.tbl_department: ~5 rows (approximately)
DELETE FROM `tbl_department`;
/*!40000 ALTER TABLE `tbl_department` DISABLE KEYS */;
INSERT INTO `tbl_department` (`d_id`, `d_name`) VALUES
	(1, 'Engineering'),
	(2, 'Plumbing'),
	(3, 'Roofing'),
	(4, 'Carpentry'),
	(5, 'Bricklaying'),
	(6, 'Office');
/*!40000 ALTER TABLE `tbl_department` ENABLE KEYS */;

-- Dumping structure for table hbs.tbl_holiday
CREATE TABLE IF NOT EXISTS `tbl_holiday` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `h_sdate` varchar(500) NOT NULL,
  `h_edate` varchar(500) NOT NULL,
  `s_id` int(11) DEFAULT NULL,
  `h_status` varchar(50) NOT NULL DEFAULT 'pending',
  PRIMARY KEY (`h_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `tbl_holiday_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `tbl_staff` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table hbs.tbl_holiday: ~0 rows (approximately)
DELETE FROM `tbl_holiday`;
/*!40000 ALTER TABLE `tbl_holiday` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_holiday` ENABLE KEYS */;

-- Dumping structure for table hbs.tbl_roles
CREATE TABLE IF NOT EXISTS `tbl_roles` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table hbs.tbl_roles: ~6 rows (approximately)
DELETE FROM `tbl_roles`;
/*!40000 ALTER TABLE `tbl_roles` DISABLE KEYS */;
INSERT INTO `tbl_roles` (`r_id`, `r_name`) VALUES
	(1, 'Head'),
	(2, 'Deputy Head\r'),
	(3, 'Manager'),
	(4, 'Apprentice'),
	(5, 'Junior member'),
	(6, ' Senior member');
/*!40000 ALTER TABLE `tbl_roles` ENABLE KEYS */;

-- Dumping structure for table hbs.tbl_staff
CREATE TABLE IF NOT EXISTS `tbl_staff` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(500) NOT NULL,
  `password` varchar(5000) NOT NULL,
  `fname` varchar(500) NOT NULL,
  `join_date` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `leave_limit` int(11) NOT NULL DEFAULT 30,
  `is_admin` int(11) NOT NULL DEFAULT 0,
  `r_id` int(11) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `r_id` (`r_id`),
  KEY `d_id` (`d_id`),
  CONSTRAINT `tbl_staff_ibfk_1` FOREIGN KEY (`r_id`) REFERENCES `tbl_roles` (`r_id`),
  CONSTRAINT `tbl_staff_ibfk_2` FOREIGN KEY (`d_id`) REFERENCES `tbl_department` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=774 DEFAULT CHARSET=utf8;

-- Dumping data for table hbs.tbl_staff: ~2 rows (approximately)
DELETE FROM `tbl_staff`;
/*!40000 ALTER TABLE `tbl_staff` DISABLE KEYS */;
INSERT INTO `tbl_staff` (`s_id`, `username`, `password`, `fname`, `join_date`, `department`, `role`, `leave_limit`, `is_admin`, `r_id`, `d_id`) VALUES
	(2, 'admin', 'admin', 'Admin', '', '', '', 0, 1, NULL, NULL),
	(772, 'ali', 'ali', 'ali', '2022-04-21', 'Engineering', 'Head', 30, 0, NULL, NULL),
	(773, 'demo', 'demo', 'ali', '2022-04-22', 'Engineering', 'Head', 30, 0, NULL, NULL);
/*!40000 ALTER TABLE `tbl_staff` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
