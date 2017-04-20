-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: 192.168.56.101    Database: callcenter_crm
-- ------------------------------------------------------
-- Server version	5.5.54-0+deb8u1

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
-- Table structure for table `campaigns`
--

DROP TABLE IF EXISTS `campaigns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campaigns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `date_create` mediumtext NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaigns`
--

LOCK TABLES `campaigns` WRITE;
/*!40000 ALTER TABLE `campaigns` DISABLE KEYS */;
INSERT INTO `campaigns` VALUES (2,'kompany 2','1491782400','START'),(3,'kompany 3','1491782400','STOP'),(4,'kompany 4 ','1491782400','STOP'),(5,'kompany 22','1491782400','STOP'),(6,'ffff','1492436563001','STOP'),(7,'fgfghfgh','1492436974225','STOP'),(8,'wwwwwww','1492437197536','STOP'),(9,'asdasdasd','1492499512776','STOP'),(13,'erertt rtytyrt','1492508146722','STOP'),(14,'gfhg fghfgh','1492508337562','STOP'),(15,'wer wer wer','1492508441025','START'),(16,'fgfgfgfg','1492514711467','START'),(17,'sads asd d asdas','1492515058808','START');
/*!40000 ALTER TABLE `campaigns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(255) NOT NULL,
  `contact_person` varchar(150) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Roga i kopita','Ivanov Ivan','09777777','ivanov@gmail.com','cherkassy'),(2,'Rastrub','Petrov','098888555','petrov@ya.ru','drabiv'),(3,'langeron','Vasya','078868666','v@at.ua','shpola'),(4,'vinoil','viktor','06000000','viktor@ukr.net','cherkassy'),(5,'werwer1111','rwe were','666666','rwe@ddd.com','ddddd'),(6,'ewewe','werwerwer','444444','eeee@www.ww','wewewe'),(7,'fsdfsdf','sdfsdf','555555','rrr@wwew','wqweqweqw'),(8,'атб','пупкін степан','097847747474','pupkins@ya.ru','Berdichiv'),(9,'rtrh','errt','erhrtrte','erhrt@gmail.com','rerttheht'),(11,'ererer555','errere','erere','erre@ff.fff','erere'),(12,'53','tttt','t5tt556','ttt@gmail.com','ffff');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dialedlist`
--

DROP TABLE IF EXISTS `dialedlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dialedlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(255) NOT NULL,
  `contact_person` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `time_to_call` mediumtext NOT NULL,
  `company_name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dialedlist`
--

LOCK TABLES `dialedlist` WRITE;
/*!40000 ALTER TABLE `dialedlist` DISABLE KEYS */;
INSERT INTO `dialedlist` VALUES (1,'kaka bubu','bober','555555','1491955200','oop'),(2,'chupakabra','bursuk','423423423','1491955200','oop');
/*!40000 ALTER TABLE `dialedlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diallist`
--

DROP TABLE IF EXISTS `diallist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diallist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(255) NOT NULL,
  `contact_person` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `campaign_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diallist`
--

LOCK TABLES `diallist` WRITE;
/*!40000 ALTER TABLE `diallist` DISABLE KEYS */;
INSERT INTO `diallist` VALUES (1,'Roga i kopita','Ivanov Ivan','09777777',1,17),(2,'Rastrub','Petrov','098888555',2,17),(3,'Roga i kopita','Ivanov Ivan','09777777',1,3),(4,'Roga i kopita','Ivanov Ivan','09777777',1,6),(5,'Rastrub','Petrov','098888555',2,6),(6,'langeron','Vasya','078868666',3,6),(7,'vinoil','viktor','06000000',4,6),(8,'werwer1111','rwe were','666666',5,6),(9,'ewewe','werwerwer','444444',6,6),(10,'fsdfsdf','sdfsdf','555555',7,6);
/*!40000 ALTER TABLE `diallist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notes`
--

DROP TABLE IF EXISTS `notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(150) NOT NULL,
  `description` text NOT NULL,
  `date` mediumtext NOT NULL,
  `user_name` varchar(150) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notes`
--

LOCK TABLES `notes` WRITE;
/*!40000 ALTER TABLE `notes` DISABLE KEYS */;
INSERT INTO `notes` VALUES (1,'sel','sel sel','1490832000','pupkin',1),(4,'bbb','dfd','1490832000','ivanich',2),(6,'sel 333 ','ds asdad','1490832000','karpatich',2),(7,'sel 333 ','ds asdad','1490832000','karpatich',3),(8,'sdfdf','dfgdfg','1490832000','pupkin',1),(9,'dsdfd','sdfsdf','1490832000','pupkin',1),(10,'dsdfd','erter','1490832000','pupkin',1),(11,'dfgdfgdf','dfgdfgdfgd','1490832000','pupkin',1),(12,'wewe','werwerwer','1490832000','pupkin',1),(15,'3234234','234234234','1492182844384','pupkin',1),(16,'pup','df  sdd sd двітв івдллаа і івдлаівода іваа од','1492182908691','pupkin',1),(17,'4322 44ewr  we rr wr','werrw rw wwe we w\nwe wr we ww\nw eerrww','1492412877578','pupkin',1);
/*!40000 ALTER TABLE `notes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `login` varchar(150) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(150) NOT NULL,
  `extension` varchar(20) NOT NULL,
  `role` varchar(20) DEFAULT 'OPERATOR',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Бобер11','bober','q1w2e3r4','bober@gmail.com','100','OPERATOR'),(2,'Бурсук','bursuk','qa6yo9km','bursuk@gmail.com','101','OPERATOR'),(3,'Бобер2','bober','q1w2e3r4','bober@gmail.com','102','OPERATOR'),(4,'Бурсук3','bober','q1w2e3r4','bober@gmail.com','103','OPERATOR'),(5,'Бобер4','bober','q1w2e3r4','bober@gmail.com','106','OPERATOR'),(6,'слон5','bober','q1w2e3r4','bober@gmail.com','107','OPERATOR'),(7,'Бобер67777','bober','q1w2e3r4','bober@gmail.com','108','OPERATOR'),(11,'t89_new','bober','q1w2e3r4','bober@gmail.com','109','ADMINISTRATOR'),(12,'ssasa89','bober','q1w2e3r4','bober@gmail.com','1009','OPERATOR'),(13,'444489','bober','q1w2e3r4','bober@gmail.com','10011','OPERATOR'),(14,'66668944','bober','q1w2e3r4','bober@gmail.com','1002','OPERATOR'),(15,'43534587','bober','q1w2e3r4','bober@gmail.com','1003','OPERATOR'),(20,'Бобер87','bober','q1w2e3r4','bober@gmail.com','1007','OPERATOR'),(21,'Бобер6776','bober','q1w2e3r4','bober@gmail.com','1008','ADMINISTRATOR'),(22,'fgdg','dfgdfgdf','dfgdfgdfgdfg','petrovich@gmail.com','43545345345','ADMINISTRATOR');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_campaign_assigned`
--

DROP TABLE IF EXISTS `users_campaign_assigned`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_campaign_assigned` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_extension` varchar(20) NOT NULL,
  `campaign_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_campaign_assigned`
--

LOCK TABLES `users_campaign_assigned` WRITE;
/*!40000 ALTER TABLE `users_campaign_assigned` DISABLE KEYS */;
INSERT INTO `users_campaign_assigned` VALUES (1,'100',16),(2,'101',16),(3,'102',16),(5,'100',17),(36,'100',2),(37,'101',2),(38,'102',2),(40,'100',6);
/*!40000 ALTER TABLE `users_campaign_assigned` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_status`
--

DROP TABLE IF EXISTS `users_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_status` (
  `extension` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_status`
--

LOCK TABLES `users_status` WRITE;
/*!40000 ALTER TABLE `users_status` DISABLE KEYS */;
INSERT INTO `users_status` VALUES ('100','READY'),('101','READY');
/*!40000 ALTER TABLE `users_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-20 17:02:02
