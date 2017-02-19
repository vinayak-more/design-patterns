-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: form
-- ------------------------------------------------------
-- Server version	5.7.12-0ubuntu1.1

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

-- Table structure for table `email`
--
--DROP Database IF EXISTS form;

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_from` varchar(255) DEFAULT NULL,
  `email_to` varchar(255) DEFAULT NULL,
  `email_subject` varchar(750) DEFAULT NULL,
  `email_body` varchar(750) DEFAULT NULL,
  `email_text_type` varchar(750) DEFAULT NULL,
  `email_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (1,'vinayak','vinayak  ',' test  ',' test body ',' PLAIN_TEXT ','0000-00-00 00:00:00'),(2,'vinayak','vinayak  ',' test  ',' test body ',' PLAIN_TEXT ','0000-00-00 00:00:00'),(3,'vinayak','vinayak  ',' test  ',' test body ',' PLAIN_TEXT ','2015-09-11 13:13:00'),(4,'vinayak.more@infibeam.net','vinayak.more@infibeam.net','test mail','My first test mail','PLAIN_TEXT','2015-09-11 13:39:40'),(5,'vinayak.more@infibeam.net','vinayak.more@infibeam.net','test mail','My first test mail','PLAIN_TEXT','2015-09-11 13:41:57'),(6,'gaurav.shegokar@infibeam.net','gaurav.shegokar@infibeam.net','test','test','PLAIN_TEXT','2015-09-11 13:43:31'),(7,'g','pradip.borde@infibeam.net','test mail','test','PLAIN_TEXT','2015-09-11 13:46:44'),(8,'gaurav.shegokar@infibeam.net','pradip.borde@infibeam.net','test mail','test','PLAIN_TEXT','2015-09-11 13:47:06'),(9,'pradip.borde@infibeam.net','gaurav.shegokar@infibeam.net','test mail','test','PLAIN_TEXT','2015-09-11 13:47:54'),(10,'hiteshkumar.kabra@infibeam.net','hiteshkumar.kabra@infibeam.net','test','testing123','PLAIN_TEXT','2015-09-16 10:11:21'),(11,'pooja.matri@infibeam.net','hiteshkumar.kabra@infibeam.net','hahahahah','hahahahahahha','PLAIN_TEXT','2015-09-23 08:04:08'),(12,'hiteshkumar.kabra@infibeam.net','pooja.matri@infibeam.net','hahahahahahah','hhhahahhaahha','PLAIN_TEXT','2015-09-23 08:06:08');
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `user` varchar(20) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('Admin','passw0rd',NULL,''),('qwerty','111111',NULL,'');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(500) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `mobile_no` varchar(10) DEFAULT NULL,
  `address` varchar(1500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'vinayak','andherieast111@gmail.com','7208467350','mumbai'),(2,'vinayak','andherieast111@gmail.com','7208467350','mumbai'),(3,'vinayak','andherieast111@gmail.com','7208467350','mumbai'),(4,'Supriya Walkunde','supriya.ps29@gmail.com','7208467350','mumbai');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `name` varchar(30) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('vinayak','vinayak','vinayak','vinayak',NULL,'Male',1),('ankita','ankita','ankita@i.a','ankita','0010-01-01','Female',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-19 20:07:28
