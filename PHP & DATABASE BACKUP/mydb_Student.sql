-- MySQL dump 10.13  Distrib 5.6.24, for linux-glibc2.5 (x86_64)
--
-- Host: 176.31.28.220    Database: mydb
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `FName` varchar(45) NOT NULL DEFAULT '',
  `LName` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `Photo` blob,
  `School_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`School_id`,`FName`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  KEY `fk_Student_School1_idx` (`School_id`),
  CONSTRAINT `fk_Student_School1` FOREIGN KEY (`School_id`) REFERENCES `School` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (1,'caleb.kitchen@psu.edu','bananaboat','Caleb','Kitchen','484-941-1641','',2),(71,'3333','jeff','Jeff','222','111111111',NULL,1),(72,'JerryBill@psu.edu','jbilly','Jerry','Bill','777-888-9999',NULL,1),(73,'HannahT@psu.edu','busterz','Hannah','Tanning','610-600-9999',NULL,1),(74,'TimH@psu.edu','yellowisgr8','Tim','Hallz','888-888-8888',NULL,2),(76,'larryHarry@psu.edu','Larhar','Larry','Harry','433-3434-3434',NULL,2),(77,'oj@psu.edu','OlivesMANG','Olivia','Jones','1111111111',NULL,1),(109,'tyler.moser@psu.edu','abcdefgh','',NULL,NULL,NULL,1),(111,'dicbsojhd@jhh','fhhdbdhd','',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-08 10:04:32
