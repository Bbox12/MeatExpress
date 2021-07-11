-- phpMyAdmin SQL Dump
-- version 4.0.10deb1ubuntu0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 11, 2021 at 07:41 PM
-- Server version: 5.5.62-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `meat`
--

-- --------------------------------------------------------

--
-- Table structure for table `address_proof_documents`
--

CREATE TABLE IF NOT EXISTS `address_proof_documents` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Document_Name` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `Sort_Order` int(2) NOT NULL,
  `Active` int(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Document_Name` (`Document_Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `admin_login_data`
--

CREATE TABLE IF NOT EXISTS `admin_login_data` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(200) NOT NULL,
  `LastName` varchar(200) NOT NULL,
  `Role` int(11) NOT NULL,
  `StaffID` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Photo` varchar(200) NOT NULL DEFAULT 'logo.png',
  `PhoneNo` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `loginDate` date NOT NULL,
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  `isStaff` tinyint(1) NOT NULL DEFAULT '0',
  `isOffice` tinyint(1) NOT NULL DEFAULT '0',
  `isVerified` tinyint(1) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `D_Date` date NOT NULL,
  `D_Time` time NOT NULL,
  `D_User` varchar(200) NOT NULL,
  `D_IP` varchar(200) NOT NULL,
  `Reference_Code` varchar(200) DEFAULT NULL,
  `AppInstallation_Date` date NOT NULL,
  `AppInstallation_Time` time NOT NULL,
  `FirebaseToken` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `User` varchar(200) NOT NULL,
  `Time` time NOT NULL,
  `IP` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `admin_login_data`
--

INSERT INTO `admin_login_data` (`ID`, `FirstName`, `LastName`, `Role`, `StaffID`, `Email`, `Photo`, `PhoneNo`, `Password`, `loginDate`, `isAdmin`, `isStaff`, `isOffice`, `isVerified`, `isDeleted`, `D_Date`, `D_Time`, `D_User`, `D_IP`, `Reference_Code`, `AppInstallation_Date`, `AppInstallation_Time`, `FirebaseToken`, `Date`, `User`, `Time`, `IP`) VALUES
(2, 'Admin', '123', 0, 'ADMIN123', 'admin@hmail.com', 'logo.png', '9999999999', '123456', '2019-10-26', 1, 0, 0, 1, 0, '0000-00-00', '00:00:00', '', '', NULL, '0000-00-00', '00:00:00', '', '0000-00-00', '', '00:00:00', ''),
(7, 'Parag', 'Deka', 2, 'Parag241', 'parag.moni44@gmsil.com', 'artboard.png', '7002608241', '123456', '0000-00-00', 0, 0, 1, 0, 0, '0000-00-00', '00:00:00', '', '', NULL, '0000-00-00', '00:00:00', '', '2020-02-18', 'ADMIN123', '17:11:41', '47.29.140.135');

-- --------------------------------------------------------

--
-- Table structure for table `app_importance_type`
--

CREATE TABLE IF NOT EXISTS `app_importance_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Importance_Type` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Importance_Type` (`Importance_Type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `app_importance_type_driver`
--

CREATE TABLE IF NOT EXISTS `app_importance_type_driver` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Importance_Type` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Importance_Type` (`Importance_Type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `app_version`
--

CREATE TABLE IF NOT EXISTS `app_version` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `Version` varchar(255) NOT NULL,
  `Importance` tinyint(4) NOT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `app_version`
--

INSERT INTO `app_version` (`ID`, `Version`, `Importance`, `Date`, `Time`, `User`, `IP`) VALUES
(1, '3', 1, '2018-03-14', '15:30:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `app_version_driver`
--

CREATE TABLE IF NOT EXISTS `app_version_driver` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `Version` varchar(255) NOT NULL,
  `Importance` tinyint(4) NOT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `back_office_users`
--

CREATE TABLE IF NOT EXISTS `back_office_users` (
  `User_ID` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Password` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `Name` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Email` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Phone` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `User_Level` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `Created_By` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`User_ID`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `banks`
--

CREATE TABLE IF NOT EXISTS `banks` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Bank` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `Sort_Order` int(3) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Bank` (`Bank`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE IF NOT EXISTS `bills` (
  `Bill_No` int(11) NOT NULL AUTO_INCREMENT,
  `Bill_Date` date NOT NULL,
  `Payment_Mode` int(11) NOT NULL,
  `Transaction_Number` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `Ride` int(11) NOT NULL,
  `Minimum_Fare` int(11) NOT NULL,
  `Ride_Fare` int(11) NOT NULL,
  `Total_Fare` int(11) NOT NULL,
  `Promo_Code` varchar(6) COLLATE latin1_general_ci DEFAULT NULL,
  `Discount_Amount` int(11) DEFAULT NULL,
  `Total_After_Discount` int(11) NOT NULL,
  `Tax_IDs` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Total_Tax_Amount` int(11) NOT NULL,
  `Gross_Amount` int(11) NOT NULL,
  `Hellocab_Share_On_Ride` int(11) NOT NULL,
  `Owner_Share_On_Ride` int(11) NOT NULL,
  `Remarks` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD1` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD2` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD3` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD4` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD5` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `User` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`Bill_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bill_payment_mode`
--

CREATE TABLE IF NOT EXISTS `bill_payment_mode` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Mode` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Mode` (`Mode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `book_ride`
--

CREATE TABLE IF NOT EXISTS `book_ride` (
  `ID` int(200) NOT NULL AUTO_INCREMENT,
  `Is_Running` tinyint(1) NOT NULL DEFAULT '0',
  `No_of_Seats` int(11) NOT NULL DEFAULT '0',
  `OTP` int(11) NOT NULL COMMENT 'Auto Generated',
  `IDDelivery` int(11) NOT NULL,
  `Unique_Ride_Code` varchar(255) NOT NULL COMMENT 'Auto Generated',
  `User_ID` int(11) NOT NULL,
  `Driver_ID` varchar(110) DEFAULT NULL,
  `Vehicle_ID` varchar(110) DEFAULT NULL,
  `uMobile` varchar(200) DEFAULT NULL,
  `From_Address` varchar(200) NOT NULL,
  `From_area` varchar(200) NOT NULL,
  `To_Address` varchar(500) NOT NULL,
  `From_Latitude` float(10,6) NOT NULL,
  `From_Longitude` float(10,6) NOT NULL,
  `To_Latitude` float(10,6) NOT NULL,
  `To_Longitude` float(10,6) NOT NULL,
  `Booking_Date` date DEFAULT NULL,
  `Booking_Time` time DEFAULT NULL,
  `Driver_Accepted_Date` date DEFAULT NULL,
  `Driver_Accepted_Time` time DEFAULT NULL,
  `ETR` varchar(200) NOT NULL,
  `Start_Date` date DEFAULT NULL,
  `Start_time` time DEFAULT NULL,
  `End_Date` date DEFAULT NULL,
  `End_time` time DEFAULT NULL,
  `Map_Snapshot` varchar(255) DEFAULT NULL,
  `Distance_Travel` float(10,2) DEFAULT NULL,
  `Cost` float(10,2) DEFAULT NULL,
  `pCost` float(10,2) NOT NULL DEFAULT '0.00',
  `User_Rating_By_Driver` float(10,1) DEFAULT '0.0',
  `Driver_Rating_By_User` float(10,1) DEFAULT '0.0',
  `User_Review` varchar(255) DEFAULT NULL,
  `Driver_Review` varchar(255) DEFAULT NULL,
  `is_Ride_Later` tinyint(1) NOT NULL DEFAULT '0',
  `Is_Roudtrip` tinyint(1) NOT NULL DEFAULT '0',
  `Return_date` date DEFAULT NULL,
  `Return_time` time DEFAULT NULL,
  `PaymentMode` int(11) NOT NULL,
  `PaymentVerified` int(11) NOT NULL DEFAULT '0',
  `Is_Paid` tinyint(1) NOT NULL DEFAULT '0',
  `Ride_Cancelled_by` tinyint(1) DEFAULT '0',
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(255) NOT NULL,
  `IP` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `book_ride`
--

INSERT INTO `book_ride` (`ID`, `Is_Running`, `No_of_Seats`, `OTP`, `IDDelivery`, `Unique_Ride_Code`, `User_ID`, `Driver_ID`, `Vehicle_ID`, `uMobile`, `From_Address`, `From_area`, `To_Address`, `From_Latitude`, `From_Longitude`, `To_Latitude`, `To_Longitude`, `Booking_Date`, `Booking_Time`, `Driver_Accepted_Date`, `Driver_Accepted_Time`, `ETR`, `Start_Date`, `Start_time`, `End_Date`, `End_time`, `Map_Snapshot`, `Distance_Travel`, `Cost`, `pCost`, `User_Rating_By_Driver`, `Driver_Rating_By_User`, `User_Review`, `Driver_Review`, `is_Ride_Later`, `Is_Roudtrip`, `Return_date`, `Return_time`, `PaymentMode`, `PaymentVerified`, `Is_Paid`, `Ride_Cancelled_by`, `Date`, `Time`, `User`, `IP`) VALUES
(1, 0, 0, 5479, 1, '13300494860227c7eced221.40667034', 16, NULL, NULL, NULL, 'House No: 29C| 29C Troupant Ave, Magaliessig, Sandton, 2191, South Africa| | Troupant Avenue| 2191', 'Sandton', '', -26.035559, 28.019775, 0.000000, 0.000000, '2021-02-09', '14:13:00', NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, 30.00, 190.00, 0.00, 0.0, 0.0, NULL, NULL, 0, 0, NULL, NULL, 1, 0, 0, 0, '2021-02-09', '14:13:00', '16', '10.140.50.81'),
(2, 0, 0, 6289, 2, '24012081060be120ce23cd9.17301639', 26, '1', 'TEST2', NULL, 'House No: 8| 8 Chestnut Cres, Marlboro Gardens, Sandton, 2063, South Africa| | Chestnut Crescent| 2063', 'Sandton', '', -26.091227, 28.094494, 0.000000, 0.000000, '2021-06-07', '14:33:00', NULL, NULL, '06-17-20213:00PM', NULL, NULL, '2021-06-08', '20:45:33', NULL, 0.00, 355.00, 0.00, 0.0, 0.0, NULL, NULL, 0, 0, NULL, NULL, 1, 0, 1, 0, '2021-06-07', '14:33:00', '26', 'fe80::38b4:d0ff:feed:70b8%dummy0'),
(3, 0, 0, 3678, 3, '135930121360bfb511bc9048.60955753', 37, '14', 'AX09BA1234', NULL, 'House No: null| Unnamed Road, Latakata, Guwahati, Meghalaya 781022, India| | Unnamed Road| 781022', 'Guwahati', '', 26.092981, 91.796753, 0.000000, 0.000000, '2021-06-08', '20:21:00', NULL, NULL, '', NULL, NULL, '2021-06-08', '20:45:17', NULL, 0.00, 300.00, 0.00, 0.0, 4.0, NULL, NULL, 0, 0, NULL, NULL, 1, 0, 1, 0, '2021-06-08', '20:21:00', '37', 'fe80::e566:b060:f74b:5c5f%wlan0'),
(4, 0, 0, 5157, 4, '8057049860bfbae5ec4429.06437602', 37, '14', 'AX09BA1234', NULL, 'House No: null| Unnamed Road, Latakata, Guwahati, Meghalaya 781022, India| | Unnamed Road| 781022', 'Guwahati', '', 26.093218, 91.796616, 0.000000, 0.000000, '2021-06-08', '20:45:00', NULL, NULL, '', NULL, NULL, '2021-06-08', '20:47:38', NULL, 0.00, 120.00, 0.00, 0.0, 0.0, NULL, NULL, 0, 0, NULL, NULL, 1, 0, 1, 0, '2021-06-08', '20:45:00', '37', 'fe80::e566:b060:f74b:5c5f%wlan0'),
(5, 0, 0, 1814, 0, '16403410060e2ee8c178693.97583761', 40, NULL, NULL, NULL, 'House No: 19| Swargapur, Latakata, Latakata, Guwahati, Meghalaya 781029, India| | null| 781029', 'Guwahati', '', 26.093338, 91.796616, 0.000000, 0.000000, '2021-07-05', '13:35:00', NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, 0.00, 195.00, 0.00, 0.0, 0.0, NULL, NULL, 0, 0, NULL, NULL, 1, 0, 0, 0, '2021-07-05', '13:35:00', '40', 'fe80::e566:b060:f74b:5c5f%wlan0');

-- --------------------------------------------------------

--
-- Table structure for table `brands`
--

CREATE TABLE IF NOT EXISTS `brands` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `canteen_AD`
--

CREATE TABLE IF NOT EXISTS `canteen_AD` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(200) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Photo` varchar(200) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  `User` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

--
-- Dumping data for table `canteen_AD`
--

INSERT INTO `canteen_AD` (`ID`, `Title`, `Description`, `Photo`, `isActive`, `User`, `Date`, `Time`) VALUES
(24, 'Eid Special', 'This is some eid special', 'Free Delivery (1).png', 0, 'admin123', '2020-06-11', '20:01:02'),
(26, 'Mid Month Promo', 'Huge Savings the Mid Month', 'Screenshot_20180128-185601.jpg', 0, 'Admin123', '2020-06-12', '18:06:10'),
(28, 'Qurbani 2020 Simplified', 'Watch this space...', 'Screenshot_20200620-220447_Phonto.jpg', 1, 'Admin123', '2020-06-21', '17:59:55'),
(55, 'TEST FOR LARGE IMAGE 3', '', 'blob', 1, 'ADMIN123', '2020-06-29', '12:37:31');

-- --------------------------------------------------------

--
-- Table structure for table `canteen_review`
--

CREATE TABLE IF NOT EXISTS `canteen_review` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `CanteenID` int(11) NOT NULL,
  `Review` varchar(200) NOT NULL,
  `Rating` float(10,2) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `checks`
--

CREATE TABLE IF NOT EXISTS `checks` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `BookingID` int(11) NOT NULL,
  `Filepath` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `checks`
--

INSERT INTO `checks` (`ID`, `UserID`, `BookingID`, `Filepath`, `Date`, `Time`) VALUES
(1, 24, 17, 'IMG-20200622-WA0000.jpg', '2020-06-23', '13:09:43'),
(2, 24, 17, 'IMG-20200622-WA0000.jpg', '2020-06-23', '13:09:47'),
(3, 24, 18, 'Screenshot_20200623-014741_Covered-19.jpg', '2020-06-23', '13:14:21'),
(4, 24, 18, 'Screenshot_20200623-014741_Covered-19.jpg', '2020-06-23', '13:14:31'),
(5, 23, 23, 'Screenshot 2020-05-27 at 12.37.34.png', '2020-06-25', '09:28:21'),
(6, 23, 23, 'Screenshot 2020-05-27 at 12.37.34.png', '2020-06-25', '09:28:25');

-- --------------------------------------------------------

--
-- Table structure for table `clusters`
--

CREATE TABLE IF NOT EXISTS `clusters` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `contactus`
--

CREATE TABLE IF NOT EXISTS `contactus` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUser` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Messages` mediumtext NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `contactus`
--

INSERT INTO `contactus` (`ID`, `IDUser`, `Email`, `Messages`, `Date`, `Time`) VALUES
(1, '2', 'p@g.com', 'test', '2020-06-10', '11:56:00'),
(2, '2', 'k@g.com', 'test', '2020-06-10', '12:03:00'),
(3, '24', 'p@g.con', 'hhhsjjs', '2020-06-16', '10:17:00'),
(4, '23', 'mhdptl@gmail.com', 'just wanted to know if youll deliver to PE', '2020-06-20', '20:33:00'),
(5, '7002508241', '', 'hhggh', '2020-06-21', '23:31:00'),
(6, '798715465', 'mhdptl@gmail.com', 'do you deliver to Marlboro Gardens', '2020-06-25', '09:24:00'),
(7, '7002608241', 'p@g.com', 'test for message go to mail', '2020-06-29', '19:42:00'),
(8, '7002608241', 'p@g.com', 'test for message go to mail', '2020-06-29', '19:43:00'),
(9, '7002608241', 'p@g.com', 'mail test', '2020-06-29', '19:46:00'),
(10, '7002608241', 'parag@gmail.com', 'test for mail', '2020-06-29', '19:48:00'),
(11, '7002608241', 'parag@gmail.com', '2ttghzjjjs', '2020-06-29', '19:51:00'),
(12, '7002608241', 'p@g.com', 'hdhjjjs', '2020-06-29', '19:54:00'),
(13, '9999999999', 'p@g.com', 'hshhhsnhd', '2020-06-29', '20:01:00'),
(14, '999998666', 'ggggyy@ggh.com', 'gghhhhjud', '2020-06-29', '20:02:00'),
(15, '24', '', 'hi', '2020-09-04', '21:17:00'),
(16, '24', '', 'hi', '2020-09-04', '21:19:00'),
(17, '24', '', 'hi', '2020-09-04', '21:23:00'),
(18, '24', '', 'hi', '2020-09-04', '21:23:00'),
(19, '24', '', 'hi', '2020-09-04', '21:23:00'),
(20, '24', '', 'hello', '2020-09-04', '21:49:00'),
(21, '24', 'p@g.com', 'hello', '2020-09-04', '21:50:00'),
(22, '24', 'p@g.com', 'hello', '2020-09-04', '21:51:00'),
(23, '24', 'p@g.com', 'hello', '2020-09-04', '21:52:00');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `iso_code_2` varchar(2) NOT NULL,
  `iso_code_3` varchar(3) NOT NULL,
  `address_format` text NOT NULL,
  `postcode_required` tinyint(1) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`country_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `current_locations`
--

CREATE TABLE IF NOT EXISTS `current_locations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Mobile` varchar(255) NOT NULL,
  `Lattitude` varchar(255) NOT NULL,
  `Longitude` varchar(255) NOT NULL,
  `Tracking_Type` varchar(11) DEFAULT NULL COMMENT 'OnRide, NoRide, Offline',
  `Date_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `current_locations_user_on_ride`
--

CREATE TABLE IF NOT EXISTS `current_locations_user_on_ride` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `Latitude` float(10,6) NOT NULL,
  `Longitude` float(10,6) NOT NULL,
  `SOS` tinyint(1) NOT NULL DEFAULT '0',
  `Tracking_Type` varchar(200) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `delievered`
--

CREATE TABLE IF NOT EXISTS `delievered` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OrderID` int(11) NOT NULL,
  `DriverID` int(11) NOT NULL DEFAULT '0',
  `Delivered` int(11) NOT NULL,
  `Acceptmessage` mediumtext NOT NULL,
  `Acceptdate` date NOT NULL,
  `Accepttime` time NOT NULL,
  `Confirmmessage` mediumtext NOT NULL,
  `Confirmdate` date NOT NULL,
  `Confirmtime` time NOT NULL,
  `Driveradddate` date NOT NULL,
  `Driveraddtime` time NOT NULL,
  `onthewaymessage` mediumtext NOT NULL,
  `onthewaydate` date NOT NULL,
  `onthewaytime` time NOT NULL,
  `Reason` mediumtext NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `delievered`
--

INSERT INTO `delievered` (`ID`, `OrderID`, `DriverID`, `Delivered`, `Acceptmessage`, `Acceptdate`, `Accepttime`, `Confirmmessage`, `Confirmdate`, `Confirmtime`, `Driveradddate`, `Driveraddtime`, `onthewaymessage`, `onthewaydate`, `onthewaytime`, `Reason`, `Date`, `Time`) VALUES
(1, 5479, 0, 2, '', '2021-06-07', '15:07:11', '', '2021-06-07', '15:07:20', '0000-00-00', '00:00:00', '', '0000-00-00', '00:00:00', '', '2021-02-09', '14:13:00'),
(2, 6289, 1, 5, '', '2021-06-07', '15:06:11', '', '2021-06-07', '15:06:48', '2021-06-07', '15:13:16', '', '0000-00-00', '00:00:00', '', '2021-06-07', '14:33:00'),
(3, 3678, 14, 5, '', '2021-06-08', '20:40:50', '', '2021-06-08', '20:41:10', '2021-06-08', '20:44:33', '', '2021-06-08', '20:44:48', '', '2021-06-08', '20:21:00'),
(4, 5157, 14, 5, '', '2021-06-08', '20:46:25', '', '2021-06-08', '20:46:42', '2021-06-08', '20:47:30', '', '0000-00-00', '00:00:00', '', '2021-06-08', '20:45:00'),
(5, 1814, 0, 0, '', '0000-00-00', '00:00:00', '', '0000-00-00', '00:00:00', '0000-00-00', '00:00:00', '', '0000-00-00', '00:00:00', '', '2021-07-05', '13:35:00');

-- --------------------------------------------------------

--
-- Table structure for table `dinner_booking`
--

CREATE TABLE IF NOT EXISTS `dinner_booking` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `CanteenID` int(11) NOT NULL,
  `No_of_persons` int(11) NOT NULL,
  `Booking_Date` date NOT NULL,
  `Booking_time` time NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `driver_details`
--

CREATE TABLE IF NOT EXISTS `driver_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Driver_OTP` int(11) DEFAULT NULL,
  `Owner_ID` int(11) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `Date_Of_Birth` date DEFAULT NULL,
  `Phone_No` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Identification_Mark` varchar(255) DEFAULT NULL,
  `Photo` varchar(255) DEFAULT 'profile_image.png',
  `Address` varchar(500) DEFAULT NULL,
  `Country` int(11) DEFAULT NULL,
  `State` int(11) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Pin` varchar(255) DEFAULT NULL,
  `Pancard_No` varchar(255) DEFAULT NULL,
  `Pancard_Photo` varchar(255) DEFAULT NULL,
  `Addressproof_Document` int(11) NOT NULL,
  `Addressproof_No` varchar(50) DEFAULT NULL,
  `Addressproof_Photo` varchar(255) DEFAULT NULL,
  `Driving_License_No` varchar(255) DEFAULT NULL,
  `Driving_License_Photo` varchar(255) DEFAULT NULL,
  `Valid_month` varchar(20) NOT NULL,
  `Valid_year` varchar(20) NOT NULL,
  `Aadhar_Card_No` varchar(255) DEFAULT NULL,
  `Aadhar_Card_Photo` varchar(255) DEFAULT NULL,
  `Cancel_Cheque_No` varchar(255) DEFAULT NULL,
  `Cancel_Cheque_Photo` varchar(255) DEFAULT NULL,
  `Bank_Name` int(11) DEFAULT NULL,
  `Branch_Name` varchar(255) DEFAULT NULL,
  `Bank_Account_Number` varchar(255) DEFAULT NULL,
  `IFSC_Code` varchar(50) DEFAULT NULL,
  `Verified_By` varchar(255) NOT NULL,
  `Verified_Date` date NOT NULL,
  `Verified_Remarks` varchar(255) DEFAULT NULL,
  `Rating` float(10,1) DEFAULT '0.0',
  `Is_Blocked` tinyint(1) NOT NULL DEFAULT '0',
  `App_Install_Date` date NOT NULL,
  `App_Install_Time` time NOT NULL,
  `Firebase_Token` varchar(255) DEFAULT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(255) NOT NULL,
  `IP` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Phone_No` (`Phone_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `eTez_AD`
--

CREATE TABLE IF NOT EXISTS `eTez_AD` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Photo` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `eTez_AD`
--

INSERT INTO `eTez_AD` (`ID`, `Photo`) VALUES
(1, '1.png'),
(2, '1.png'),
(3, '1.png');

-- --------------------------------------------------------

--
-- Table structure for table `faq`
--

CREATE TABLE IF NOT EXISTS `faq` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Category` int(11) NOT NULL,
  `FAQ_Topic_Name` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Description` longtext COLLATE latin1_general_ci,
  `Sort_Order` int(2) NOT NULL,
  `Title` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Meta_Tag_Keywords` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Meta_Tag_Description` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Facebook_OG_Tag` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Twitter_Tag` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Google_Analytics` longtext COLLATE latin1_general_ci,
  `Custom_Code` longtext COLLATE latin1_general_ci,
  `UD1` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD2` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD3` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD4` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD5` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `publish` varchar(1) COLLATE latin1_general_ci NOT NULL,
  `date` date NOT NULL,
  `time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `user` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(30) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `faq_category`
--

CREATE TABLE IF NOT EXISTS `faq_category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Parent` int(11) DEFAULT NULL,
  `FAQ_Category` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Description` text COLLATE latin1_general_ci,
  `Sort_Order` int(4) NOT NULL,
  `Publish` int(1) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `User` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `FAQ_Category` (`FAQ_Category`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE IF NOT EXISTS `foods` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDMenu` int(11) NOT NULL,
  `IDSubmenu` int(11) NOT NULL,
  `IDSubsubmenu` int(11) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `Weight` float(10,2) NOT NULL,
  `Unit` int(11) NOT NULL,
  `Description` mediumtext NOT NULL,
  `MRP` float(10,2) NOT NULL,
  `JalpanPrice` float(10,2) NOT NULL,
  `Discount` float(10,2) NOT NULL,
  `Photo` varchar(200) NOT NULL DEFAULT 'logo.png',
  `isOutOfStock` tinyint(4) NOT NULL DEFAULT '0',
  `Recomended` tinyint(1) NOT NULL DEFAULT '0',
  `Popular` tinyint(1) NOT NULL DEFAULT '0',
  `Rating` float(10,2) NOT NULL DEFAULT '0.00',
  `Available` tinyint(1) NOT NULL DEFAULT '1',
  `User` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`ID`, `IDMenu`, `IDSubmenu`, `IDSubsubmenu`, `Name`, `Weight`, `Unit`, `Description`, `MRP`, `JalpanPrice`, `Discount`, `Photo`, `isOutOfStock`, `Recomended`, `Popular`, `Rating`, `Available`, `User`, `Date`, `Time`) VALUES
(1, 1, 1, 15, 'Stewing Beef', 1.00, 10, '', 0.00, 120.00, 0.00, 'Stewing Beef_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '14:53:11'),
(2, 1, 1, 2, 'T-bone', 1.00, 0, '', 0.00, 150.00, 0.00, '_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '14:58:38'),
(3, 1, 1, 2, 'Minute Steak', 1.00, 0, '', 0.00, 150.00, 0.00, 'Minute Steak_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:07:32'),
(4, 1, 1, 2, 'Top side steak', 1.00, 0, '', 0.00, 135.00, 0.00, 'Top side steak_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:25:35'),
(5, 1, 1, 2, 'Rump steak', 1.00, 0, '', 0.00, 155.00, 0.00, 'Rump steak_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:28:30'),
(6, 1, 1, 2, 'Steak mince', 1.00, 0, '', 0.00, 140.00, 0.00, 'Steak mince_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:30:52'),
(7, 1, 1, 2, 'Fillet steak', 1.00, 0, '', 0.00, 300.00, 0.00, 'Fillet steak_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:32:45'),
(8, 1, 2, 1, 'Sausages (App 500g)', 0.00, 0, '', 0.00, 60.00, 0.00, 'Sausages_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:36:02'),
(9, 1, 2, 15, 'Viennas/ Russians', 1.00, 0, '', 0.00, 50.00, 0.00, 'Russians_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:41:15'),
(10, 1, 2, 6, 'Patties', 0.00, 0, '', 0.00, 65.00, 0.00, 'Patties_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:43:45'),
(11, 1, 2, 7, 'Lollies', 9.00, 0, '', 0.00, 75.00, 0.00, 'Lollies_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:45:29'),
(12, 1, 2, 8, 'Kebaabs', 12.00, 0, '', 0.00, 55.00, 0.00, 'Kebaabs_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:48:33'),
(13, 1, 2, 15, 'Polony (roll)', 0.00, 0, '', 0.00, 55.00, 0.00, 'Polony (roll)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-01', '15:54:25'),
(14, 2, 1, 3, 'Mutton mince', 1.00, 0, '', 0.00, 150.00, 0.00, 'Mutton mince_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:21:52'),
(15, 2, 1, 15, 'Curry Mutton', 1.00, 0, '', 0.00, 145.00, 0.00, 'Curry Mutton_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:23:50'),
(16, 2, 1, 15, 'Curry Mutton Supreme', 1.00, 0, '', 0.00, 155.00, 0.00, 'Curry Mutton Supreme_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:28:01'),
(17, 2, 1, 4, 'Shoulder Chops', 1.00, 0, '', 0.00, 175.00, 0.00, 'Shoulder Chops_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:30:06'),
(18, 2, 1, 4, 'Loin/ Rib chops', 1.00, 0, '', 0.00, 175.00, 0.00, 'Rib chops_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:31:28'),
(19, 2, 1, 15, 'Leg Mutton', 1.00, 0, '', 0.00, 180.00, 0.00, 'Leg Mutton_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:38:24'),
(20, 2, 1, 15, 'Whole/ Half lamb Cut, Sliced and packed in trays(POR)', 0.00, 0, '', 0.00, 0.00, 0.00, 'Half lamb Cut, Sliced and packed in trays(POR)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:40:23'),
(21, 2, 2, 1, 'Sausages (App 500g)', 0.00, 0, '', 0.00, 65.00, 0.00, 'Sausages (App 500g)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:43:06'),
(22, 2, 2, 6, 'Patties (6 pack)', 0.00, 0, '', 0.00, 75.00, 0.00, 'Patties (6 pack)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:44:04'),
(23, 2, 2, 7, 'Mutton Lollies (9 Pieces)', 0.00, 0, '', 0.00, 80.00, 0.00, 'Mutton Lollies (9 Pieces)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:46:23'),
(24, 2, 2, 8, 'Mutton Kebabs (12 Pieces)', 0.00, 0, '', 0.00, 60.00, 0.00, 'Mutton Kebabs (12 Pieces)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:48:53'),
(25, 2, 2, 15, 'Polony (roll)', 0.00, 0, '', 0.00, 60.00, 0.00, 'Polony (roll)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-03', '11:49:48'),
(26, 3, 1, 15, 'Cut and Washed', 0.00, 0, '', 0.00, 60.00, 0.00, 'Cut and Washed_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:11:46'),
(27, 3, 1, 15, 'Fresh Fillet', 1.00, 0, '', 0.00, 70.00, 0.00, 'Fresh Fillet_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:12:33'),
(28, 3, 1, 15, 'Cubed Fillet', 1.00, 0, '', 0.00, 75.00, 0.00, 'Cubed Fillet_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:19:44'),
(29, 3, 1, 15, 'Minced Fillet', 1.00, 0, '', 0.00, 75.00, 0.00, 'Minced Fillet_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:23:50'),
(30, 3, 1, 15, 'Drumsticks', 1.00, 0, '', 0.00, 70.00, 0.00, 'Drumsticks_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:25:40'),
(31, 3, 1, 15, 'Leg Quarters', 1.00, 0, '', 0.00, 70.00, 0.00, 'Leg Quarters_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:26:31'),
(32, 3, 1, 15, 'Wings (skin on)', 1.00, 0, '', 0.00, 60.00, 0.00, 'Wings (skin on)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:28:19'),
(33, 3, 1, 15, 'Wings (skin off)', 1.00, 0, '', 0.00, 65.00, 0.00, 'Wings (skin off)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:29:14'),
(34, 3, 2, 1, 'Sausages (App 500g)', 0.00, 0, '', 0.00, 60.00, 0.00, 'Sausages (App 500g)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:34:26'),
(35, 3, 2, 6, 'Patties (6 pack)', 0.00, 0, '', 0.00, 60.00, 0.00, 'Patties (6 pack)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:36:30'),
(36, 3, 2, 7, 'Lollies (9 pieces)', 0.00, 0, '', 0.00, 65.00, 0.00, 'Lollies (9 pieces)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:38:34'),
(37, 3, 2, 15, 'Crumbed strips (300g)', 0.00, 0, '', 0.00, 55.00, 0.00, 'Crumbed strips (300g)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:39:30'),
(38, 3, 2, 15, 'Crumbed pops (300g)', 0.00, 0, '', 0.00, 50.00, 0.00, 'Crumbed pops (300g)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:40:19'),
(39, 3, 2, 15, 'Crumbed patty (300g)', 0.00, 0, '', 0.00, 50.00, 0.00, 'Crumbed patty (300g)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:42:06'),
(40, 3, 2, 15, 'Polony (roll)', 0.00, 0, '', 0.00, 50.00, 0.00, 'Polony (roll)_p.png', 0, 0, 0, 0.00, 1, 'admin123', '2021-02-04', '11:44:42'),
(41, 1, 1, 2, 'TEST', 1.00, 10, '', 1200.00, 100.00, 0.00, 'logo.png', 0, 0, 0, 0.00, 1, 'ADMIN123', '2021-02-07', '18:30:41');

-- --------------------------------------------------------

--
-- Table structure for table `food_review`
--

CREATE TABLE IF NOT EXISTS `food_review` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `FoodID` int(11) NOT NULL,
  `Review` varchar(200) NOT NULL,
  `Rating` float(10,2) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `hellocab_elite_plans`
--

CREATE TABLE IF NOT EXISTS `hellocab_elite_plans` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Plan_Name` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Amount` int(4) NOT NULL,
  `Validity_in_Days` int(3) NOT NULL,
  `Description` longtext COLLATE latin1_general_ci,
  `Sort_Order` int(2) NOT NULL,
  `Title` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Meta_Tag_Keywords` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Meta_Tag_Description` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Facebook_OG_Tag` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Twitter_Tag` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Google_Analytics` longtext COLLATE latin1_general_ci,
  `Custom_Code` longtext COLLATE latin1_general_ci,
  `UD1` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD2` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD3` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD4` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD5` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `publish` varchar(1) COLLATE latin1_general_ci NOT NULL,
  `date` date NOT NULL,
  `time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `user` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(30) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `information`
--

CREATE TABLE IF NOT EXISTS `information` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Parent` int(11) DEFAULT NULL,
  `Link_Name` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Page_Content` longtext COLLATE latin1_general_ci,
  `Sort_Order` int(2) NOT NULL,
  `Title` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Meta_Tag_Keywords` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Meta_Tag_Description` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Facebook_OG_Tag` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Twitter_Tag` varchar(2000) COLLATE latin1_general_ci DEFAULT NULL,
  `Google_Analytics` longtext COLLATE latin1_general_ci,
  `Custom_Code` longtext COLLATE latin1_general_ci,
  `UD1` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD2` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD3` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD4` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `UD5` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `publish` varchar(1) COLLATE latin1_general_ci NOT NULL,
  `date` date NOT NULL,
  `time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `user` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(30) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `menu_type`
--

CREATE TABLE IF NOT EXISTS `menu_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `Photo` varchar(200) NOT NULL,
  `Specification` varchar(200) NOT NULL,
  `Description` mediumtext NOT NULL,
  `Colors` varchar(200) NOT NULL DEFAULT '000000',
  `isActive` tinyint(4) NOT NULL DEFAULT '1',
  `User` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `menu_type`
--

INSERT INTO `menu_type` (`ID`, `Name`, `Photo`, `Specification`, `Description`, `Colors`, `isActive`, `User`, `Date`, `Time`) VALUES
(1, 'BEEF', 'http://139.59.38.160/Meat/Dashboard/Menu/one-pieces-juicy-raw-beef-stone-cutting-board-black-wooden-table-background_91014-1566.jpg', 'This is a test of the Beef Primary Category', 'Best of all, they Deliver to your Door\r\n\r\nThey also keep a Delicious range of Ready to Eat and Ready to Bake Cakes, Biscuits, Croissants, Danish and so much more to tantalise your Taste Buds', '#f44336', 1, 'ADMIN123', '2020-06-12', '13:36:18'),
(2, 'MUTTON', 'http://139.59.38.160/Meat/Dashboard/Menu/raw-fresh-lamb-meat-ribs-seasonings-wooden-cutting-board_75517-372-2.jpg', 'Qurbani Like Never Before...', 'Contact us for all your Quality Lamb, Goat and Cattle. \r\nNo Compromise on Quality. Full Services Available including Meat Express Signature Service...Delivery to your Door', '#4caf50', 1, 'ADMIN123', '2020-06-12', '13:36:32'),
(3, 'CHICKEN', 'http://139.59.38.160/Meat/Dashboard/Menu/high-angle-raw-chicken-wooden-board-with-condiments_23-2148440849.jpg', 'Best in South Africa', 'Last Chance to get your Hands on some Delicious and Tender Baby Chickens...Perfect for Eid', '#ff5722', 1, 'Admin123', '2020-06-14', '09:11:39'),
(6, 'Country Chicken', '', '100%fresh', '', '000000', 0, '13:45:22', '2020-06-05', '00:00:00'),
(7, 'Spice', '', 'This is to test the spice category', 'jihdfjisdncidfjviojdfv', '000000', 0, '19:25:09', '2020-06-05', '00:00:00'),
(8, 'PROMOTION', 'http://139.59.38.160/Meat/Dashboard/Menu/IMG-20171030-WA0021.jpg', 'Saving you more', 'All Promo Products', '#ffeb3b', 1, 'ADMIN123', '2020-06-20', '17:52:57');

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE IF NOT EXISTS `notifications` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Subject` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Email_Description` text COLLATE latin1_general_ci NOT NULL,
  `Send_SMS` int(1) NOT NULL,
  `SMS_Text` varchar(500) COLLATE latin1_general_ci NOT NULL,
  `Send_To` int(11) NOT NULL,
  `Place_Filter` int(11) DEFAULT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `User` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `owner_details`
--

CREATE TABLE IF NOT EXISTS `owner_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Owner_OTP` int(11) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `Date_Of_Birth` date DEFAULT NULL,
  `Phone_No` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Photo` varchar(255) DEFAULT NULL,
  `Address` varchar(500) DEFAULT NULL,
  `Country` int(11) DEFAULT NULL,
  `State` int(11) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Pin` varchar(255) DEFAULT NULL,
  `Pancard_No` varchar(255) DEFAULT NULL,
  `Pancard_Photo` varchar(255) DEFAULT NULL,
  `Addressproof_Document` int(11) NOT NULL,
  `Addressproof_No` varchar(50) DEFAULT NULL,
  `Addressproof_Photo` varchar(255) DEFAULT NULL,
  `Aadhar_Card_No` varchar(255) DEFAULT NULL,
  `Aadhar_Card_Photo` varchar(255) DEFAULT NULL,
  `Cancel_Cheque_No` varchar(255) DEFAULT NULL,
  `Cancel_Cheque_Photo` varchar(255) DEFAULT NULL,
  `Bank_Name` int(11) NOT NULL,
  `Branch_Name` varchar(255) NOT NULL,
  `Bank_Account_Number` varchar(255) NOT NULL,
  `IFSC_Code` varchar(50) NOT NULL,
  `Verified_By` varchar(200) NOT NULL,
  `Verified_Date` date NOT NULL,
  `Verified_Remarks` varchar(255) DEFAULT NULL,
  `App_Install_Date` date DEFAULT NULL,
  `App_Install_Time` time DEFAULT NULL,
  `Firebase_Token` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `PackagingType`
--

CREATE TABLE IF NOT EXISTS `PackagingType` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `promo_codes`
--

CREATE TABLE IF NOT EXISTS `promo_codes` (
  `Promo_Code` varchar(6) COLLATE latin1_general_ci NOT NULL,
  `Promo_Type` int(11) NOT NULL,
  `Discount_Type` int(11) NOT NULL,
  `Discount_Value` int(3) NOT NULL,
  `Start_Date` date DEFAULT NULL,
  `End_Date` date DEFAULT NULL,
  `Drop_Location` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `App_Invitation` varchar(40) COLLATE latin1_general_ci DEFAULT NULL,
  `Applicable_Place` int(11) DEFAULT NULL,
  `Remarks` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `Status` int(1) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `User` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`Promo_Code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `promo_codes_type`
--

CREATE TABLE IF NOT EXISTS `promo_codes_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Type` (`Type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `promo_discount_type`
--

CREATE TABLE IF NOT EXISTS `promo_discount_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Type` (`Type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `push_message`
--

CREATE TABLE IF NOT EXISTS `push_message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `StaffID` int(11) NOT NULL,
  `Message` varchar(200) NOT NULL,
  `Photo` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(200) NOT NULL,
  `IP` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `push_message`
--

INSERT INTO `push_message` (`ID`, `StaffID`, `Message`, `Photo`, `Date`, `Time`, `User`, `IP`) VALUES
(20, 0, 'Hello', '', '2020-07-13', '17:11:09', 'ADMIN123', '27.56.52.44'),
(21, 0, 'Push notification from dashboard', 'doubt.png', '2020-07-13', '17:12:16', 'ADMIN123', '27.56.52.44'),
(22, 0, 'Reminder to cut ðŸ’…', '', '2020-07-20', '20:55:33', 'Admin123', '105.186.138.75'),
(23, 0, 'Eid Mubarak', 'Screenshot_20200717-104851_WhatsAppBusiness.jpg', '2020-07-20', '20:56:19', 'Admin123', '105.186.138.75'),
(24, 0, 'EID MUBARAK!!!', '', '2020-07-20', '20:57:04', 'Admin123', '105.186.138.75'),
(25, 0, 'Test for Messages if App is closed', '', '2020-07-20', '20:57:41', 'Admin123', '105.186.138.75'),
(26, 0, 'Test for message if you logged off', '', '2020-07-20', '20:58:21', 'Admin123', '105.186.138.75'),
(27, 0, 'Test for notification with pic', '20200719_102553.jpg', '2020-07-20', '21:06:51', 'Admin123', '105.186.138.75'),
(28, 0, 'Test 25 July 2020', 'Lite Africa_online_smaller.png', '2020-07-25', '10:23:19', 'admin123', '102.182.107.248'),
(29, 0, 'Test 2 for Oz and Afro', 'Moe_MRU.jpg', '2020-07-25', '10:24:39', 'admin123', '102.182.107.248'),
(30, 0, 'Test message', '', '2020-10-27', '13:15:54', 'ADMIN123', '223.238.104.177');

-- --------------------------------------------------------

--
-- Table structure for table `rating_remarks`
--

CREATE TABLE IF NOT EXISTS `rating_remarks` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Rating_limit` int(11) NOT NULL COMMENT '1 for low rating,2 for high rating',
  `Rating_comments` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(200) NOT NULL,
  `IP` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reason_cancel`
--

CREATE TABLE IF NOT EXISTS `reason_cancel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `first` varchar(200) NOT NULL,
  `second` varchar(200) NOT NULL,
  `third` varchar(200) NOT NULL,
  `fourth` varchar(200) NOT NULL,
  `fifth` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `recharge_point`
--

CREATE TABLE IF NOT EXISTS `recharge_point` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Phone_No` varchar(20) NOT NULL,
  `Latitude` float(10,6) NOT NULL,
  `Longitude` float(10,6) NOT NULL,
  `Verified_by` varchar(200) NOT NULL,
  `Verified_remarks` varchar(200) NOT NULL,
  `Verified_date` date NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(200) NOT NULL,
  `IP` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `setting_defaults`
--

CREATE TABLE IF NOT EXISTS `setting_defaults` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Discounts` float(10,2) NOT NULL,
  `MinimumOrderPrice` int(11) NOT NULL COMMENT 'Service shutdown',
  `MinimumOrderWeight` int(11) NOT NULL COMMENT 'on ride track driver and user',
  `MinimumDistance` int(11) NOT NULL,
  `MaximumDistance` int(11) NOT NULL COMMENT 'on ride track the user',
  `StartTime` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `EndTime` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `FreeDistance` int(11) NOT NULL,
  `PricePerKM` int(11) NOT NULL,
  `CancellationCharge` float(10,2) NOT NULL,
  `FacebookPage` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `InstagramPage` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `YoutubePlaylis` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `WhatsApp` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(200) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `setting_defaults`
--

INSERT INTO `setting_defaults` (`ID`, `Discounts`, `MinimumOrderPrice`, `MinimumOrderWeight`, `MinimumDistance`, `MaximumDistance`, `StartTime`, `EndTime`, `FreeDistance`, `PricePerKM`, `CancellationCharge`, `FacebookPage`, `InstagramPage`, `YoutubePlaylis`, `WhatsApp`, `Date`, `Time`, `User`, `IP`) VALUES
(1, 12.00, 200, 2, 3, 20, '09:44 AM', '08:44 PM', 0, 0, 50.00, '', '', '', '0', '2020-06-02', '11:44:54', 'ADMIN123', '157.42.231.61'),
(2, 12.00, 200, 2, 3, 20, '09:44 AM', '08:44 PM', 3, 5, 50.00, '', '', '', '0', '2020-06-02', '11:48:39', 'ADMIN123', '157.42.231.61'),
(3, 12.00, 200, 2, 3, 0, '09:44 AM', '08:44 PM', 3, 5, 50.00, '', '', '', '0', '2020-06-05', '20:05:43', '', '47.29.245.170'),
(4, 12.00, 200, 2, 3, 0, '09:44 AM', '08:44 PM', 3, 5, 50.00, '', '', '', '2147483647', '2020-06-18', '10:44:19', 'ADMIN123', '157.42.241.188'),
(5, 12.00, 200, 2, 3, 0, '09:44 AM', '08:44 PM', 3, 5, 50.00, '', '', '', '917002608241', '2020-06-18', '10:44:57', 'ADMIN123', '157.42.241.188'),
(6, 12.00, 200, 2, 3, 0, '', '', 3, 5, 50.00, '', '', '', '27798715465', '2020-06-19', '22:35:51', 'Admin123', '102.182.107.248'),
(7, 12.00, 200, 2, 3, 0, '', '', 3, 5, 50.00, 'https://www.facebook.com/MeatExpress/', '', '', '27798715465', '2020-06-29', '22:10:26', 'ADMIN123', '223.176.12.57'),
(8, 12.00, 200, 2, 3, 0, '', '', 3, 5, 50.00, 'https://www.facebook.com/MeatExpress/', 'https://www.instagram.com/meatexpress/', '', '27798715465', '2020-06-29', '22:12:50', 'ADMIN123', '223.176.12.57');

-- --------------------------------------------------------

--
-- Table structure for table `setting_operational_places`
--

CREATE TABLE IF NOT EXISTS `setting_operational_places` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Place` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Lattitude` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `Longitude` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `Remark` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `Status` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `User` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sms_codes_driver`
--

CREATE TABLE IF NOT EXISTS `sms_codes_driver` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Driver_Name` varchar(200) NOT NULL,
  `Phone_No` varchar(100) NOT NULL,
  `Driver_OTP` int(11) NOT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '0',
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sms_codes_owner`
--

CREATE TABLE IF NOT EXISTS `sms_codes_owner` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Owner_Name` varchar(200) NOT NULL,
  `Phone_No` varchar(100) NOT NULL,
  `Owner_OTP` int(11) NOT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '0',
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sms_codes_user`
--

CREATE TABLE IF NOT EXISTS `sms_codes_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Phone_no` varchar(100) NOT NULL,
  `User_OTP` int(11) NOT NULL,
  `Status` tinyint(1) NOT NULL DEFAULT '0',
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  `User_Name` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `splashtext`
--

CREATE TABLE IF NOT EXISTS `splashtext` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MainText` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `splashtext`
--

INSERT INTO `splashtext` (`ID`, `MainText`) VALUES
(1, 'Butchery with a Difference'),
(2, 'Avoid Queues, Traffic and Stress'),
(3, 'Delivery to your Door'),
(4, 'Wholesome Organic Halaal Meat');

-- --------------------------------------------------------

--
-- Table structure for table `states`
--

CREATE TABLE IF NOT EXISTS `states` (
  `zone_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `code` varchar(32) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`zone_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `store_order`
--

CREATE TABLE IF NOT EXISTS `store_order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `OrderID` int(11) NOT NULL,
  `CanteenID` int(11) NOT NULL,
  `FoodID` int(11) NOT NULL,
  `NoofItems` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `store_order`
--

INSERT INTO `store_order` (`ID`, `UserID`, `OrderID`, `CanteenID`, `FoodID`, `NoofItems`, `Date`, `Time`) VALUES
(1, 16, 5479, 1, 10, 1, '2021-02-09', '14:13:00'),
(2, 16, 5479, 1, 27, 1, '2021-02-09', '14:13:00'),
(3, 16, 5479, 1, 12, 1, '2021-02-09', '14:13:00'),
(4, 26, 6289, 1, 22, 1, '2021-06-07', '14:33:00'),
(5, 26, 6289, 1, 3, 1, '2021-06-07', '14:33:00'),
(6, 26, 6289, 1, 36, 2, '2021-06-07', '14:33:00'),
(7, 37, 3678, 1, 2, 1, '2021-06-08', '20:21:00'),
(8, 37, 3678, 1, 3, 1, '2021-06-08', '20:21:00'),
(9, 37, 5157, 1, 10, 1, '2021-06-08', '20:45:00'),
(10, 37, 5157, 1, 12, 1, '2021-06-08', '20:45:00'),
(11, 40, 1814, 1, 11, 1, '2021-07-05', '13:35:00'),
(12, 40, 1814, 1, 1, 1, '2021-07-05', '13:35:00');

-- --------------------------------------------------------

--
-- Table structure for table `submenu`
--

CREATE TABLE IF NOT EXISTS `submenu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Category` varchar(200) NOT NULL,
  `Photo` varchar(200) NOT NULL,
  `Specification` varchar(200) NOT NULL,
  `Description` mediumtext NOT NULL,
  `isActive` tinyint(4) NOT NULL DEFAULT '1',
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `submenu`
--

INSERT INTO `submenu` (`ID`, `Category`, `Photo`, `Specification`, `Description`, `isActive`, `Date`, `Time`) VALUES
(1, 'SAUSAGES AND WORS', 'likemeat-cSxpCQrRlo8-unsplash.jpg', 'A sausage is a cylindrical meat product usually made from ground.', 'Sausage making is a traditional food preservation technique. Sausages may be preserved by curing, drying (often in association with fermentation or culturing, which can contribute to preservation), smoking, or freezing.', 1, '2020-06-05', '18:55:02'),
(2, 'STEAK', '256x256bb.jpg', 'Nice and Fresh', '100% Fresh', 1, '2020-06-03', '13:06:27'),
(3, 'MINCE', 'Unknown-12.png', '100% Fresh', '100% Fresh', 1, '2020-06-03', '13:50:02'),
(4, 'CHOPS', 'lamb-loin-chops-1.jpg', '', '', 1, '0000-00-00', '00:00:00'),
(6, 'PATTIES', '730afaa855b709dd292854688040e10f.jpg', '100% Fresh', '100%Fresh', 1, '2020-06-03', '13:53:52'),
(7, 'LOLLIES', '834-8348393_chicken-meat.png', '', '', 1, '2020-04-13', '20:24:32'),
(8, 'KEBAABS', 'IMG_20190224_175257.jpg', 'Lamb, Mutton, Chicken', 'A dish consisting of small pieces of meat, tomatoes, onions, etc, threaded onto skewers and grilled, generally over charcoal', 1, '2020-06-03', '14:45:53'),
(9, 'Spices', 'silver-round-accessory-with-storage-227908.jpg', 'This is a test for spices', 'Blah blah blah', 0, '2020-06-05', '19:07:57'),
(10, 'FRESH MEAT', 'Rib Chops.jpg', 'Fresh Chicken, Mutton or Beef', 'Quality, Organic, Un-Stunned Freah Meat Cuts', 0, '2020-06-06', '17:06:10'),
(11, 'PROCESSED MEATS', 'redMeatTMAO-500479754-650x450.jpg', 'Chicken, Mutton or Beef', 'Made from 100% Meat and Fresh Spices, No Offal or Waste added', 0, '2020-06-08', '21:59:17'),
(12, 'PROCESSED MEATS', '1480151439723.jpg', 'Chicken, Mutton or Beef', 'Made from 100% Meat and Fresh Spices, No Offal or Waste added', 0, '2020-06-06', '17:10:00'),
(13, 'QURBANI', '1591599985093.jpg', 'Online Qurbani Offering', 'Offering Quality Lamb and Cattle, with Full Service, including Slaughtering, Cleaning, Slicing, Delivery and Distribution(if required)', 0, '2020-06-08', '21:03:35'),
(14, 'Test Secondary Category', 'meatImage.jpg', 'This is to see where specification populates', 'This is some description', 0, '2020-06-07', '09:47:29'),
(15, 'OTHER', '', 'Miscellaneous Products', 'Speciality Products that don''t fall into Fresh or Processed Meats', 1, '2020-06-12', '18:10:09');

-- --------------------------------------------------------

--
-- Table structure for table `subsubmenu`
--

CREATE TABLE IF NOT EXISTS `subsubmenu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `Photo` varchar(200) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `subsubmenu`
--

INSERT INTO `subsubmenu` (`ID`, `Name`, `Photo`, `isActive`, `Date`, `Time`) VALUES
(1, 'FRESH MEATS', 'fresh-uncooked-meat-wooden-board-with-knife-herbs_23-2148425558.jpg', 1, '2020-06-10', '21:31:08'),
(2, 'PROCESSED MEATS', 'top-view-selection-fresh-meat-table_23-2148439513.jpg', 1, '2020-06-10', '20:09:39'),
(3, 'QURBANI', 'Screenshot_20190812-064327_WhatsAppBusiness.jpg', 1, '2020-06-14', '09:04:44');

-- --------------------------------------------------------

--
-- Table structure for table `tax_definations`
--

CREATE TABLE IF NOT EXISTS `tax_definations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Tax_Name` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `Tax_Percentage` float NOT NULL,
  `Applicable` int(1) NOT NULL,
  `Sort_Order` int(3) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `user` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tez_Canteen`
--

CREATE TABLE IF NOT EXISTS `tez_Canteen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `Phone_No` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Aboutus` mediumtext NOT NULL,
  `Address` varchar(200) NOT NULL,
  `State` varchar(200) NOT NULL,
  `City` varchar(200) NOT NULL,
  `Pin_No` int(11) NOT NULL,
  `Latitude` float(10,6) NOT NULL,
  `Longitude` float(10,6) NOT NULL,
  `isActive` tinyint(4) NOT NULL DEFAULT '1',
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tez_Canteen`
--

INSERT INTO `tez_Canteen` (`ID`, `Name`, `Phone_No`, `Email`, `Aboutus`, `Address`, `State`, `City`, `Pin_No`, `Latitude`, `Longitude`, `isActive`, `Date`, `Time`) VALUES
(1, 'Meat express', '89898989', 'test@gmail.com', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', '1265  Church St,Wingate Park,Gauteng', 'Test', 'Test', 153, -26.195246, 28.034088, 1, '2020-06-05', '20:54:00');

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

CREATE TABLE IF NOT EXISTS `unit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `update_user_order`
--

CREATE TABLE IF NOT EXISTS `update_user_order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `OrderID` int(11) NOT NULL,
  `Gross` float(10,2) NOT NULL,
  `Discount` float(10,2) NOT NULL,
  `Packaging` float(10,2) NOT NULL,
  `Delievery` float(10,2) NOT NULL,
  `Total` float(10,2) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `update_user_order`
--

INSERT INTO `update_user_order` (`ID`, `UserID`, `OrderID`, `Gross`, `Discount`, `Packaging`, `Delievery`, `Total`, `Date`, `Time`) VALUES
(1, 16, 5479, 0.00, 0.00, 0.00, 0.00, 190.00, '2021-02-09', '14:13:00'),
(2, 26, 6289, 0.00, 0.00, 0.00, 0.00, 355.00, '2021-06-07', '14:33:00'),
(3, 37, 3678, 0.00, 0.00, 0.00, 0.00, 300.00, '2021-06-08', '20:21:00'),
(4, 37, 5157, 0.00, 0.00, 0.00, 0.00, 120.00, '2021-06-08', '20:45:00'),
(5, 40, 1814, 0.00, 0.00, 0.00, 0.00, 195.00, '2021-07-05', '13:35:00');

-- --------------------------------------------------------

--
-- Table structure for table `userlevelpermissions`
--

CREATE TABLE IF NOT EXISTS `userlevelpermissions` (
  `userlevelid` int(11) NOT NULL,
  `tablename` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `permission` int(11) NOT NULL,
  PRIMARY KEY (`userlevelid`,`tablename`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `userlevels`
--

CREATE TABLE IF NOT EXISTS `userlevels` (
  `userlevelid` int(11) NOT NULL,
  `userlevelname` varchar(255) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`userlevelid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users_emergency_contacts`
--

CREATE TABLE IF NOT EXISTS `users_emergency_contacts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `Contact_Name` varchar(255) NOT NULL,
  `Contact_Phone_No` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(255) NOT NULL,
  `IP` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE IF NOT EXISTS `user_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Password` varchar(200) NOT NULL,
  `Photo` varchar(255) DEFAULT 'profile_image.png',
  `Phone_No` varchar(20) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '1',
  `Address` varchar(500) DEFAULT NULL,
  `Country` varchar(200) DEFAULT 'South Africa',
  `State` varchar(200) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Pin` varchar(255) DEFAULT NULL,
  `Latitude` float(10,6) DEFAULT NULL,
  `Longitude` float(10,6) DEFAULT NULL,
  `Favorite_Home_Address` varchar(255) DEFAULT NULL,
  `Favourite_Work_Address` varchar(255) DEFAULT NULL,
  `Favourite_Other_Address` varchar(255) DEFAULT NULL,
  `isHome` int(11) NOT NULL DEFAULT '0',
  `HomeAddress` varchar(200) NOT NULL,
  `HomeHouseNo` varchar(200) NOT NULL,
  `HomeLandMark` varchar(200) NOT NULL,
  `HomeZip` varchar(200) NOT NULL,
  `isWork` tinyint(4) NOT NULL DEFAULT '0',
  `WorkAddress` varchar(200) NOT NULL,
  `WorkHouseNo` varchar(20) NOT NULL,
  `WorkLandMark` varchar(200) NOT NULL,
  `WorkZip` varchar(200) NOT NULL,
  `Rating` float(10,1) DEFAULT '0.0',
  `Is_Blocked` tinyint(1) NOT NULL DEFAULT '0',
  `Charge` int(11) NOT NULL DEFAULT '0',
  `Reference_Code` varchar(255) DEFAULT NULL,
  `User_Referrence_Code` varchar(20) DEFAULT NULL,
  `Firebase_Token` varchar(255) DEFAULT NULL,
  `Logout` tinyint(4) NOT NULL DEFAULT '0',
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`ID`, `Name`, `Email`, `Password`, `Photo`, `Phone_No`, `role`, `Address`, `Country`, `State`, `City`, `Pin`, `Latitude`, `Longitude`, `Favorite_Home_Address`, `Favourite_Work_Address`, `Favourite_Other_Address`, `isHome`, `HomeAddress`, `HomeHouseNo`, `HomeLandMark`, `HomeZip`, `isWork`, `WorkAddress`, `WorkHouseNo`, `WorkLandMark`, `WorkZip`, `Rating`, `Is_Blocked`, `Charge`, `Reference_Code`, `User_Referrence_Code`, `Firebase_Token`, `Logout`, `Date`, `Time`, `User`, `IP`) VALUES
(14, 'TEST2', NULL, '7c222fb2927d828af22f592134e8932480637c0d', 'Driver.png', '9999999999', 2, 'Test1', 'South Africa', 'Test1', 'Test1', '781029', NULL, NULL, NULL, NULL, NULL, 0, '', '', '', '', 0, '', '', '', '', 0.0, 0, 0, NULL, NULL, NULL, 0, '2020-06-13', '11:56:00', 'ADMIN123', '47.29.202.35'),
(41, 'MUHAMMAD.ESSA', NULL, '23264aa6268488c2909ef81ead49e09e248d5d91', 'Profile.png', '0827865662', 1, NULL, 'South Africa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '', '', '', '', 0, '', '', '', '', 0.0, 0, 0, NULL, NULL, 'cz4_jRt3TzeA-UboW0t8tK:APA91bGLMEvhyxBvthe2NIEBYU3DrK-8Fy_5UHN59esiWdFzu67GHj3yFbtImvrIUL597ALpdx7etWXr4CH1ba29PnbDzqxaUDl-xEeUypV27wRSFn985xXemg76d9SLNS6cMHwS2Uz7', 0, '2021-07-05', '19:36:00', NULL, NULL),
(42, 'MOHAMMAD', NULL, 'a4247f0ba89eac46040b554d7dde5f9f0069a7d7', 'Profile.png', '0823845032', 1, NULL, 'South Africa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '', '', '', '', 0, '', '', '', '', 0.0, 0, 0, NULL, NULL, 'eyI_cSQXRue5X0kvXonxrl:APA91bFT52sVURAPuZvzHug5U9gV_CNi99nZ-jnZEgk8p_bFZr-Q72qMDTxoWmZXfD0-os-Kl9L6T9deSzyYnDCsJP4Q40fKy3pnmndip5pM_7ey16zekpfHeNRFJbxjjn27Nr2m4h3w', 0, '2021-07-07', '18:04:00', NULL, NULL),
(25, 'PARAG', '', '7c222fb2927d828af22f592134e8932480637c0d', '1599244200.jpg', '8888888888', 3, 'Ganesh nagar', 'South Africa', 'Kamrup', 'guwahati', '7810', 0.000000, 0.000000, 'Optional(&quot;1 Stockton St||1 Stockton St|781029&quot;)', NULL, NULL, 0, '', '', '', '', 0, 'House No: 1600| 1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA| | Amphitheatre Parkway| 94043', '1600', 'Amphitheatre Parkway', '94043', 0.0, 0, 0, NULL, NULL, 'cK6iWRV8QJCXrLdGvAWihh:APA91bFZT6PicrUmqxsp0gBqr4KoN55UC932QNHeMGQlFTnPMkLhLDaWaN3nROQ5BeMFvmgJEBqsy46sE8GckUj96VwbWLyzF8L2ZBPUgMlja-3gP0x0RCRhXYmib9Otm0xxKCQKd-iF', 0, '2020-09-04', '21:03:00', NULL, NULL),
(40, 'PARAG', NULL, '7c222fb2927d828af22f592134e8932480637c0d', 'Profile.png', '7002608241', 1, NULL, 'South Africa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '', '', '', '', 0, '', '', '', '', 0.0, 0, 0, NULL, NULL, 'dUtCeOgUQU6EJxFClNJF2A:APA91bGbQ5thrWOT6yLrmEGCyjxtUn_iJpEcTSdgJA1rFLZYaQGiGNtV831gRhH5aNLs5dQnvETo2WaWTwUSpaJXgvIpEDfEMtFF5jhqXUcW-8bfDladPOmIxgoBQBWWVruFM5Ri6Vag', 1, '2021-07-05', '13:35:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_daily_rates`
--

CREATE TABLE IF NOT EXISTS `vehicle_daily_rates` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date_of_Rate` date NOT NULL,
  `Vehicle_Type` varchar(11) COLLATE latin1_general_ci NOT NULL,
  `Minimum_Fare` int(11) NOT NULL,
  `00-01_hr` int(11) NOT NULL,
  `01-02_hr` int(11) NOT NULL,
  `02-03_hr` int(11) NOT NULL,
  `03-04_hr` int(11) NOT NULL,
  `04-05_hr` int(11) NOT NULL,
  `05-06_hr` int(11) NOT NULL,
  `06-07_hr` int(11) NOT NULL,
  `07-08_hr` int(11) NOT NULL,
  `08-09_hr` int(11) NOT NULL,
  `09-10_hr` int(11) NOT NULL,
  `10-11_hr` int(11) NOT NULL,
  `11-12_hr` int(11) NOT NULL,
  `12-13_hr` int(11) NOT NULL,
  `13-14_hr` int(11) NOT NULL,
  `14-15_hr` int(11) NOT NULL,
  `15-16_hr` int(11) NOT NULL,
  `16-17_hr` int(11) NOT NULL,
  `17-18_hr` int(11) NOT NULL,
  `18-19_hr` int(11) NOT NULL,
  `19-20_hr` int(11) NOT NULL,
  `20-21_hr` int(11) NOT NULL,
  `21-22_hr` int(11) NOT NULL,
  `22-23_hr` int(11) NOT NULL,
  `23-00_hr` int(11) NOT NULL,
  `Remarks` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `Last_Modified_User` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Last_Modified_IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_detail`
--

CREATE TABLE IF NOT EXISTS `vehicle_detail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Minimum_Balance_Status` tinyint(1) NOT NULL DEFAULT '0',
  `Total_balance` float(10,2) NOT NULL DEFAULT '500.00',
  `Type` tinyint(4) NOT NULL DEFAULT '0',
  `Driver_ID` int(11) DEFAULT NULL,
  `Vehicle_No` varchar(255) NOT NULL,
  `Vehicle_Photo_1` varchar(255) DEFAULT 'vehicle.png',
  `Vehicle_Photo_2` varchar(255) DEFAULT NULL,
  `Registration_Certificate_No` varchar(255) DEFAULT NULL,
  `Registration_Certificate_Photo` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `vehicle_detail`
--

INSERT INTO `vehicle_detail` (`ID`, `Minimum_Balance_Status`, `Total_balance`, `Type`, `Driver_ID`, `Vehicle_No`, `Vehicle_Photo_1`, `Vehicle_Photo_2`, `Registration_Certificate_No`, `Registration_Certificate_Photo`, `Date`, `Time`, `User`, `IP`) VALUES
(1, 0, 500.00, 0, NULL, 'AX09BA1234', 'vehicle.png', NULL, 'ASBGGBVFFBVVB', NULL, NULL, NULL, NULL, NULL),
(2, 0, 500.00, 0, NULL, 'AX10MB5678', 'vehicle.png', NULL, 'ASBGGBVFFBVVB', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_manufacturer`
--

CREATE TABLE IF NOT EXISTS `vehicle_manufacturer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Vehicle_Company` varchar(255) NOT NULL,
  `Date` varchar(255) NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(255) NOT NULL,
  `IP` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Vehicle_Company` (`Vehicle_Company`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_models`
--

CREATE TABLE IF NOT EXISTS `vehicle_models` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Vehicle_Company` int(11) NOT NULL,
  `Vehicle_Model` varchar(200) NOT NULL,
  `Vehicle_Type` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(255) NOT NULL,
  `IP` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Vehicle_Model` (`Vehicle_Model`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Vehicle_Percentage_Master`
--

CREATE TABLE IF NOT EXISTS `Vehicle_Percentage_Master` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Vehicle_ID` int(11) NOT NULL,
  `Hellocab_Percentage_On_Ride` int(11) NOT NULL,
  `Owner_Percentage_On_Ride` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(255) NOT NULL,
  `IP` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_recharged`
--

CREATE TABLE IF NOT EXISTS `vehicle_recharged` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Vehicle_ID` int(11) NOT NULL,
  `Rechargepoint_ID` int(11) NOT NULL,
  `Ammount` float(10,2) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `User` varchar(200) NOT NULL,
  `IP` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_type_rate_master`
--

CREATE TABLE IF NOT EXISTS `vehicle_type_rate_master` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Vehicle_Type` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Vehicle_Security_Deposit` int(11) NOT NULL,
  `Vehicle_Minimum_Balance` int(11) NOT NULL,
  `Minimum_Fare` int(11) NOT NULL,
  `00-01_hr` int(11) NOT NULL,
  `01-02_hr` int(11) NOT NULL,
  `02-03_hr` int(11) NOT NULL,
  `03-04_hr` int(11) NOT NULL,
  `04-05_hr` int(11) NOT NULL,
  `05-06_hr` int(11) NOT NULL,
  `06-07_hr` int(11) NOT NULL,
  `07-08_hr` int(11) NOT NULL,
  `08-09_hr` int(11) NOT NULL,
  `09-10_hr` int(11) NOT NULL,
  `10-11_hr` int(11) NOT NULL,
  `11-12_hr` int(11) NOT NULL,
  `12-13_hr` int(11) NOT NULL,
  `13-14_hr` int(11) NOT NULL,
  `14-15_hr` int(11) NOT NULL,
  `15-16_hr` int(11) NOT NULL,
  `16-17_hr` int(11) NOT NULL,
  `17-18_hr` int(11) NOT NULL,
  `18-19_hr` int(11) NOT NULL,
  `19-20_hr` int(11) NOT NULL,
  `20-21_hr` int(11) NOT NULL,
  `21-22_hr` int(11) NOT NULL,
  `22-23_hr` int(11) NOT NULL,
  `23-00_hr` int(11) NOT NULL,
  `Remarks` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `Last_Modified_User` varchar(255) COLLATE latin1_general_ci NOT NULL,
  `Last_Modified_IP` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Vehicle_Type` (`Vehicle_Type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `visited_Canteen`
--

CREATE TABLE IF NOT EXISTS `visited_Canteen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `Canteen_ID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
