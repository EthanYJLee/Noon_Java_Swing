-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: noon
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `complete`
--

DROP TABLE IF EXISTS `complete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complete` (
  `completeno` int NOT NULL AUTO_INCREMENT,
  `completetime` datetime DEFAULT NULL,
  `accepttime` datetime DEFAULT NULL,
  `staff_id` varchar(30) NOT NULL,
  `shop_shopcode` int NOT NULL,
  PRIMARY KEY (`completeno`,`staff_id`,`shop_shopcode`),
  UNIQUE KEY `no_UNIQUE` (`completeno`),
  KEY `fk_complete_staff1_idx` (`staff_id`),
  KEY `fk_complete_shop1_idx` (`shop_shopcode`),
  CONSTRAINT `fk_complete_shop1` FOREIGN KEY (`shop_shopcode`) REFERENCES `shop` (`shopcode`),
  CONSTRAINT `fk_complete_staff1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complete`
--

LOCK TABLES `complete` WRITE;
/*!40000 ALTER TABLE `complete` DISABLE KEYS */;
/*!40000 ALTER TABLE `complete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `executive`
--

DROP TABLE IF EXISTS `executive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `executive` (
  `id` varchar(30) NOT NULL,
  `pw` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `employeeno` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `executive`
--

LOCK TABLES `executive` WRITE;
/*!40000 ALTER TABLE `executive` DISABLE KEYS */;
/*!40000 ALTER TABLE `executive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hire`
--

DROP TABLE IF EXISTS `hire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hire` (
  `hireno` int NOT NULL AUTO_INCREMENT,
  `updatedate` date DEFAULT NULL,
  `registerdate` date DEFAULT NULL,
  `deletedate` date DEFAULT NULL,
  `shop_shopcode` int NOT NULL,
  `staff_id` varchar(30) NOT NULL,
  `manager_id` varchar(30) NOT NULL,
  PRIMARY KEY (`hireno`,`shop_shopcode`,`staff_id`,`manager_id`),
  UNIQUE KEY `registerno_UNIQUE` (`hireno`),
  KEY `fk_register_shop1_idx` (`shop_shopcode`),
  KEY `fk_register_staff1_idx` (`staff_id`),
  KEY `fk_hire_manager1_idx` (`manager_id`),
  CONSTRAINT `fk_hire_manager1` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`),
  CONSTRAINT `fk_register_shop1` FOREIGN KEY (`shop_shopcode`) REFERENCES `shop` (`shopcode`),
  CONSTRAINT `fk_register_staff1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hire`
--

LOCK TABLES `hire` WRITE;
/*!40000 ALTER TABLE `hire` DISABLE KEYS */;
/*!40000 ALTER TABLE `hire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manage`
--

DROP TABLE IF EXISTS `manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage` (
  `manageno` int NOT NULL AUTO_INCREMENT,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `shop_shopcode` int NOT NULL,
  `manager_id` varchar(30) NOT NULL,
  PRIMARY KEY (`manageno`,`shop_shopcode`,`manager_id`),
  UNIQUE KEY `manageno_UNIQUE` (`manageno`),
  KEY `fk_manage_shop1_idx` (`shop_shopcode`),
  KEY `fk_manage_manager1_idx` (`manager_id`),
  CONSTRAINT `fk_manage_manager1` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`),
  CONSTRAINT `fk_manage_shop1` FOREIGN KEY (`shop_shopcode`) REFERENCES `shop` (`shopcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage`
--

LOCK TABLES `manage` WRITE;
/*!40000 ALTER TABLE `manage` DISABLE KEYS */;
/*!40000 ALTER TABLE `manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `id` varchar(30) NOT NULL,
  `pw` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `employeeno` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(30) NOT NULL,
  `pw` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `initdate` date DEFAULT NULL,
  `updatedate` date DEFAULT NULL,
  `deletedate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `name` varchar(30) NOT NULL,
  `category` varchar(45) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `photo` mediumblob,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderno` int NOT NULL AUTO_INCREMENT,
  `ordertime` datetime DEFAULT NULL,
  `refundtime` datetime DEFAULT NULL,
  `hotice` tinyint DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `forheretogo` tinyint DEFAULT NULL,
  `shot` int DEFAULT NULL,
  `syrup` int DEFAULT NULL,
  `water` varchar(20) DEFAULT NULL,
  `indiprice` int DEFAULT NULL,
  `customerno` int DEFAULT NULL,
  `member_id` varchar(30) NOT NULL,
  `set_setno` int NOT NULL,
  `set_menu_name` varchar(30) NOT NULL,
  `shop_shopcode` int NOT NULL,
  `staff_id` varchar(30) NOT NULL,
  `complete_completeno` int NOT NULL,
  `complete_staff_id` varchar(30) NOT NULL,
  `complete_shop_shopcode` int NOT NULL,
  `point_pointno` int NOT NULL,
  `point_member_id` varchar(30) NOT NULL,
  PRIMARY KEY (`orderno`,`member_id`,`set_setno`,`set_menu_name`,`shop_shopcode`,`staff_id`,`complete_completeno`,`complete_staff_id`,`complete_shop_shopcode`,`point_pointno`,`point_member_id`),
  UNIQUE KEY `no_UNIQUE` (`orderno`),
  KEY `fk_order_member1_idx` (`member_id`),
  KEY `fk_order_set1_idx` (`set_setno`,`set_menu_name`),
  KEY `fk_order_shop1_idx` (`shop_shopcode`),
  KEY `fk_order_staff1_idx` (`staff_id`),
  KEY `fk_order_complete1_idx` (`complete_completeno`,`complete_staff_id`,`complete_shop_shopcode`),
  KEY `fk_order_point1_idx` (`point_pointno`,`point_member_id`),
  CONSTRAINT `fk_order_complete1` FOREIGN KEY (`complete_completeno`, `complete_staff_id`, `complete_shop_shopcode`) REFERENCES `complete` (`completeno`, `staff_id`, `shop_shopcode`),
  CONSTRAINT `fk_order_member1` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `fk_order_point1` FOREIGN KEY (`point_pointno`, `point_member_id`) REFERENCES `point` (`pointno`, `member_id`),
  CONSTRAINT `fk_order_set1` FOREIGN KEY (`set_setno`, `set_menu_name`) REFERENCES `set` (`setno`, `menu_name`),
  CONSTRAINT `fk_order_shop1` FOREIGN KEY (`shop_shopcode`) REFERENCES `shop` (`shopcode`),
  CONSTRAINT `fk_order_staff1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `point`
--

DROP TABLE IF EXISTS `point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `point` (
  `pointno` int NOT NULL AUTO_INCREMENT,
  `pointdate` date DEFAULT NULL,
  `pointcash` int DEFAULT NULL,
  `member_id` varchar(30) NOT NULL,
  PRIMARY KEY (`pointno`,`member_id`),
  UNIQUE KEY `pointno_UNIQUE` (`pointno`),
  KEY `fk_point_member_idx` (`member_id`),
  CONSTRAINT `fk_point_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `point`
--

LOCK TABLES `point` WRITE;
/*!40000 ALTER TABLE `point` DISABLE KEYS */;
/*!40000 ALTER TABLE `point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `set`
--

DROP TABLE IF EXISTS `set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `set` (
  `setno` int NOT NULL AUTO_INCREMENT,
  `initdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `pricenow` int DEFAULT NULL,
  `photonow` mediumblob,
  `menu_name` varchar(30) NOT NULL,
  `shop_shopcode` int NOT NULL,
  PRIMARY KEY (`setno`,`menu_name`,`shop_shopcode`),
  UNIQUE KEY `setno_UNIQUE` (`setno`),
  KEY `fk_set_menu1_idx` (`menu_name`),
  KEY `fk_set_shop1_idx` (`shop_shopcode`),
  CONSTRAINT `fk_set_menu1` FOREIGN KEY (`menu_name`) REFERENCES `menu` (`name`),
  CONSTRAINT `fk_set_shop1` FOREIGN KEY (`shop_shopcode`) REFERENCES `shop` (`shopcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `set`
--

LOCK TABLES `set` WRITE;
/*!40000 ALTER TABLE `set` DISABLE KEYS */;
/*!40000 ALTER TABLE `set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `shopcode` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `town` varchar(20) DEFAULT NULL,
  `village` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `opentime` time DEFAULT NULL,
  `closetime` time DEFAULT NULL,
  PRIMARY KEY (`shopcode`),
  UNIQUE KEY `shopcode_UNIQUE` (`shopcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopregister`
--

DROP TABLE IF EXISTS `shopregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopregister` (
  `shopregisterno` int NOT NULL AUTO_INCREMENT,
  `registerdate` date DEFAULT NULL,
  `updatedate` date DEFAULT NULL,
  `deletedate` date DEFAULT NULL,
  `shop_shopcode` int NOT NULL,
  `executive_id` varchar(30) NOT NULL,
  PRIMARY KEY (`shopregisterno`,`shop_shopcode`,`executive_id`),
  UNIQUE KEY `shopregisterno_UNIQUE` (`shopregisterno`),
  KEY `fk_shopregister_shop1_idx` (`shop_shopcode`),
  KEY `fk_shopregister_executive1_idx` (`executive_id`),
  CONSTRAINT `fk_shopregister_executive1` FOREIGN KEY (`executive_id`) REFERENCES `executive` (`id`),
  CONSTRAINT `fk_shopregister_shop1` FOREIGN KEY (`shop_shopcode`) REFERENCES `shop` (`shopcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopregister`
--

LOCK TABLES `shopregister` WRITE;
/*!40000 ALTER TABLE `shopregister` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopregister` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` varchar(30) NOT NULL,
  `pw` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `debitno` int DEFAULT NULL,
  `photo` mediumblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-08 14:45:30
