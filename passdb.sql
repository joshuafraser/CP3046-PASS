-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2015 at 09:33 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `passdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendancesheet`
--

CREATE TABLE IF NOT EXISTS `attendancesheet` (
`sheetId` int(11) NOT NULL,
  `sessionId` int(11) NOT NULL,
  `sheetRecorded` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendancesheet`
--

INSERT INTO `attendancesheet` (`sheetId`, `sessionId`, `sheetRecorded`) VALUES
(4, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `campus`
--

CREATE TABLE IF NOT EXISTS `campus` (
`campusId` int(11) NOT NULL,
  `campusName` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `campus`
--

INSERT INTO `campus` (`campusId`, `campusName`) VALUES
(8, 'Townsville'),
(9, 'Test'),
(10, 'Test');

-- --------------------------------------------------------

--
-- Table structure for table `passattendance`
--

CREATE TABLE IF NOT EXISTS `passattendance` (
`attendId` int(11) NOT NULL,
  `stuId` int(11) NOT NULL,
  `sessionId` int(11) NOT NULL,
  `attendStatus` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `passattendance`
--

INSERT INTO `passattendance` (`attendId`, `stuId`, `sessionId`, `attendStatus`) VALUES
(2, 3, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `passstaff`
--

CREATE TABLE IF NOT EXISTS `passstaff` (
`staffId` int(11) NOT NULL,
  `staffFName` varchar(25) NOT NULL,
  `staffLName` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `passstaff`
--

INSERT INTO `passstaff` (`staffId`, `staffFName`, `staffLName`) VALUES
(7, 'testFName', 'testLName');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE IF NOT EXISTS `result` (
`resultId` int(11) NOT NULL,
  `stuId` int(11) NOT NULL,
  `subId` int(11) NOT NULL,
  `resultGrade` varchar(2) NOT NULL,
  `resultPercentage` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`resultId`, `stuId`, `subId`, `resultGrade`, `resultPercentage`) VALUES
(5, 3, 15, 'D', 80.5);

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE IF NOT EXISTS `semester` (
`semesterId` int(11) NOT NULL,
  `campusId` int(11) NOT NULL,
  `semesterName` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`semesterId`, `campusId`, `semesterName`) VALUES
(4, 8, 'S1 2015');

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE IF NOT EXISTS `session` (
`sessionId` int(11) NOT NULL,
  `subId` int(11) NOT NULL,
  `staffId` int(11) NOT NULL,
  `sessionName` varchar(20) NOT NULL,
  `sessionDate` varchar(20) NOT NULL,
  `weekId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`sessionId`, `subId`, `staffId`, `sessionName`, `sessionDate`, `weekId`) VALUES
(6, 15, 7, 'ammended', 'ammended', 5),
(7, 15, 7, 't', 't', 5);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
`stuId` int(11) NOT NULL,
  `stuFName` varchar(25) NOT NULL,
  `stuLName` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stuId`, `stuFName`, `stuLName`) VALUES
(3, 'ammended', 'ammended');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
`subId` int(11) NOT NULL,
  `semesterId` int(11) NOT NULL,
  `subCode` varchar(6) NOT NULL,
  `subName` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subId`, `semesterId`, `subCode`, `subName`) VALUES
(15, 4, 'CPtest', 'whatever'),
(16, 4, 'CPtest', 'whatever');

-- --------------------------------------------------------

--
-- Table structure for table `subjectenrol`
--

CREATE TABLE IF NOT EXISTS `subjectenrol` (
`enrolId` int(11) NOT NULL,
  `subId` int(11) NOT NULL,
  `stuId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjectenrol`
--

INSERT INTO `subjectenrol` (`enrolId`, `subId`, `stuId`) VALUES
(6, 15, 3);

-- --------------------------------------------------------

--
-- Table structure for table `week`
--

CREATE TABLE IF NOT EXISTS `week` (
`weekId` int(11) NOT NULL,
  `semesterId` int(11) NOT NULL,
  `weekName` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `week`
--

INSERT INTO `week` (`weekId`, `semesterId`, `weekName`) VALUES
(5, 4, 'Week1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendancesheet`
--
ALTER TABLE `attendancesheet`
 ADD PRIMARY KEY (`sheetId`), ADD KEY `sessionId` (`sessionId`);

--
-- Indexes for table `campus`
--
ALTER TABLE `campus`
 ADD PRIMARY KEY (`campusId`);

--
-- Indexes for table `passattendance`
--
ALTER TABLE `passattendance`
 ADD PRIMARY KEY (`attendId`), ADD KEY `stuId` (`stuId`,`sessionId`), ADD KEY `sessionId` (`sessionId`);

--
-- Indexes for table `passstaff`
--
ALTER TABLE `passstaff`
 ADD PRIMARY KEY (`staffId`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
 ADD PRIMARY KEY (`resultId`), ADD KEY `subId` (`subId`), ADD KEY `stuId` (`stuId`,`subId`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
 ADD PRIMARY KEY (`semesterId`), ADD KEY `campusId` (`campusId`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
 ADD PRIMARY KEY (`sessionId`), ADD KEY `subId` (`subId`,`staffId`), ADD KEY `staffId` (`staffId`), ADD KEY `weekId` (`weekId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`stuId`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
 ADD PRIMARY KEY (`subId`), ADD KEY `semesterId` (`semesterId`);

--
-- Indexes for table `subjectenrol`
--
ALTER TABLE `subjectenrol`
 ADD PRIMARY KEY (`enrolId`), ADD KEY `subId` (`subId`,`stuId`), ADD KEY `stuId` (`stuId`);

--
-- Indexes for table `week`
--
ALTER TABLE `week`
 ADD PRIMARY KEY (`weekId`), ADD KEY `semesterId` (`semesterId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendancesheet`
--
ALTER TABLE `attendancesheet`
MODIFY `sheetId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `campus`
--
ALTER TABLE `campus`
MODIFY `campusId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `passattendance`
--
ALTER TABLE `passattendance`
MODIFY `attendId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `passstaff`
--
ALTER TABLE `passstaff`
MODIFY `staffId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
MODIFY `resultId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `semester`
--
ALTER TABLE `semester`
MODIFY `semesterId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
MODIFY `sessionId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
MODIFY `stuId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
MODIFY `subId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `subjectenrol`
--
ALTER TABLE `subjectenrol`
MODIFY `enrolId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `week`
--
ALTER TABLE `week`
MODIFY `weekId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendancesheet`
--
ALTER TABLE `attendancesheet`
ADD CONSTRAINT `attendancesheet_ibfk_1` FOREIGN KEY (`sessionId`) REFERENCES `session` (`sessionId`);

--
-- Constraints for table `passattendance`
--
ALTER TABLE `passattendance`
ADD CONSTRAINT `passattendance_ibfk_1` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`),
ADD CONSTRAINT `passattendance_ibfk_2` FOREIGN KEY (`sessionId`) REFERENCES `session` (`sessionId`);

--
-- Constraints for table `result`
--
ALTER TABLE `result`
ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`subId`) REFERENCES `subject` (`subId`),
ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`);

--
-- Constraints for table `semester`
--
ALTER TABLE `semester`
ADD CONSTRAINT `semester_ibfk_1` FOREIGN KEY (`campusId`) REFERENCES `campus` (`campusId`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
ADD CONSTRAINT `session_ibfk_1` FOREIGN KEY (`subId`) REFERENCES `subject` (`subId`),
ADD CONSTRAINT `session_ibfk_2` FOREIGN KEY (`staffId`) REFERENCES `passstaff` (`staffId`),
ADD CONSTRAINT `session_ibfk_3` FOREIGN KEY (`weekId`) REFERENCES `week` (`weekId`);

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`semesterId`) REFERENCES `semester` (`semesterId`);

--
-- Constraints for table `subjectenrol`
--
ALTER TABLE `subjectenrol`
ADD CONSTRAINT `subjectenrol_ibfk_1` FOREIGN KEY (`subId`) REFERENCES `subject` (`subId`),
ADD CONSTRAINT `subjectenrol_ibfk_2` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`);

--
-- Constraints for table `week`
--
ALTER TABLE `week`
ADD CONSTRAINT `week_ibfk_1` FOREIGN KEY (`semesterId`) REFERENCES `semester` (`semesterId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
