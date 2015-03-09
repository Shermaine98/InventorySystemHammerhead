CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Table structure for table `accessories_inventory`
--

DROP TABLE IF EXISTS `accessories_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accessories_inventory` (
  `category` varchar(45) NOT NULL,
  `accessoryDescription` varchar(45) NOT NULL,
  `drNumber` int(11) NOT NULL,
  `dateUpdated` date NOT NULL,
  `qty` int(11) NOT NULL,
  `unitMeasurement` varchar(45) NOT NULL,
  `approval` tinyint(1) NOT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`category`,`accessoryDescription`,`drNumber`,`dateUpdated`),
  KEY `FK_AItoSDR_idx` (`drNumber`),
  CONSTRAINT `FK_AItoSDR` FOREIGN KEY (`drNumber`) REFERENCES `supplier_delivery_receipt` (`drNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessories_inventory`
--

LOCK TABLES `accessories_inventory` WRITE;
/*!40000 ALTER TABLE `accessories_inventory` DISABLE KEYS */;
INSERT INTO `accessories_inventory` VALUES ('Shirt','Hashtags - S28',1,'2014-06-10',8000,'pcs',3,NULL);
/*!40000 ALTER TABLE `accessories_inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumption_report`
--

DROP TABLE IF EXISTS `consumption_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumption_report` (
  `productionNumber` int(11) NOT NULL AUTO_INCREMENT,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `qty` int(11) NOT NULL,
  `preparedBy` int(11) NOT NULL,
  `approvedBy` int(11) NOT NULL,
  `dateMade` date NOT NULL,
  PRIMARY KEY (`productionNumber`,`productID`,`size`,`color`),
  KEY `FK_CRtoProduct_idx` (`productID`,`size`,`color`),
  KEY `FK_CRtoUser_idx` (`preparedBy`),
  CONSTRAINT `FK_CRtoProduct` FOREIGN KEY (`productID`, `size`, `color`) REFERENCES `product` (`productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CRtoUser` FOREIGN KEY (`preparedBy`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumption_report`
--

LOCK TABLES `consumption_report` WRITE;
/*!40000 ALTER TABLE `consumption_report` DISABLE KEYS */;
INSERT INTO `consumption_report` VALUES (1,855,'S','Blue',1000,2,1,'2015-03-07');
/*!40000 ALTER TABLE `consumption_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cr_to_ai`
--

DROP TABLE IF EXISTS `cr_to_ai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cr_to_ai` (
  `category` varchar(45) NOT NULL,
  `accessoryDescription` varchar(45) NOT NULL,
  `drNumber` int(11) NOT NULL,
  `productionNumber` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `consumption` int(11) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `productionQty` int(11) NOT NULL,
  PRIMARY KEY (`category`,`accessoryDescription`,`drNumber`,`productionNumber`,`productID`,`size`,`color`),
  KEY `FK_toAI_idx` (`category`,`accessoryDescription`,`drNumber`),
  KEY `FK_toCR_idx` (`productionNumber`,`productID`,`size`,`color`),
  CONSTRAINT `FK_toAI` FOREIGN KEY (`category`, `accessoryDescription`, `drNumber`) REFERENCES `accessories_inventory` (`category`, `accessoryDescription`, `drNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_toCR` FOREIGN KEY (`productionNumber`, `productID`, `size`, `color`) REFERENCES `consumption_report` (`productionNumber`, `productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cr_to_ai`
--

LOCK TABLES `cr_to_ai` WRITE;
/*!40000 ALTER TABLE `cr_to_ai` DISABLE KEYS */;
INSERT INTO `cr_to_ai` VALUES ('Shirt','Hashtags - S28',1,1,855,'S','Blue',1,'pcs',2000);
/*!40000 ALTER TABLE `cr_to_ai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cr_to_pi`
--

DROP TABLE IF EXISTS `cr_to_pi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cr_to_pi` (
  `productionNumber` int(11) NOT NULL,
  `category` varchar(45) NOT NULL,
  `drNumber` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `consumption` int(11) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `productionQty` int(11) NOT NULL,
  PRIMARY KEY (`productionNumber`,`category`,`drNumber`,`productID`,`size`,`color`),
  KEY `FK_PItoCR_idx` (`productionNumber`,`productID`,`size`,`color`),
  CONSTRAINT `FK_PItoCR` FOREIGN KEY (`productionNumber`, `productID`, `size`, `color`) REFERENCES `consumption_report` (`productionNumber`, `productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_toPI` FOREIGN KEY (`productionNumber`, `category`, `drNumber`) REFERENCES `production_inventory` (`productionNumber`, `category`, `drNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cr_to_pi`
--

LOCK TABLES `cr_to_pi` WRITE;
/*!40000 ALTER TABLE `cr_to_pi` DISABLE KEYS */;
INSERT INTO `cr_to_pi` VALUES (1,'Shirt',2,855,'S','Blue',2,'pcs',5000);
/*!40000 ALTER TABLE `cr_to_pi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cutting_report`
--

DROP TABLE IF EXISTS `cutting_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cutting_report` (
  `productionNumber` int(11) NOT NULL,
  `category` varchar(45) NOT NULL,
  `drNumber` int(11) NOT NULL,
  `cuttingMaster` int(11) NOT NULL,
  `rawQty` int(11) NOT NULL,
  `calculatedQty` int(11) NOT NULL,
  `actualQty` int(11) NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`productionNumber`,`category`,`drNumber`),
  KEY `FK_CRtoSDR_idx` (`drNumber`),
  CONSTRAINT `FK_CRtoSDR` FOREIGN KEY (`drNumber`) REFERENCES `supplier_delivery_receipt` (`drNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cutting_report`
--

LOCK TABLES `cutting_report` WRITE;
/*!40000 ALTER TABLE `cutting_report` DISABLE KEYS */;
INSERT INTO `cutting_report` VALUES (1,'Shirt',2,1,1000,1200,1200,NULL);
/*!40000 ALTER TABLE `cutting_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_order`
--

DROP TABLE IF EXISTS `delivery_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_order` (
  `doNumber` int(11) NOT NULL AUTO_INCREMENT,
  `promo` int(11) NOT NULL,
  `dateMade` date NOT NULL,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `deliveryQty` int(11) NOT NULL,
  `approved` tinyint(1) NOT NULL,
  `preparedBy` int(11) NOT NULL,
  `approvedBy` int(11) NOT NULL,
  PRIMARY KEY (`doNumber`,`promo`,`dateMade`,`productID`,`size`,`color`),
  KEY `FK_DOtoPF_idx` (`promo`,`dateMade`,`productID`,`size`,`color`),
  KEY `FKDOtoUser_idx` (`preparedBy`),
  CONSTRAINT `FKDOtoUser` FOREIGN KEY (`preparedBy`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DOtoPF` FOREIGN KEY (`promo`, `dateMade`, `productID`, `size`, `color`) REFERENCES `picking_form` (`promo`, `dateMade`, `productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_order`
--

LOCK TABLES `delivery_order` WRITE;
/*!40000 ALTER TABLE `delivery_order` DISABLE KEYS */;
INSERT INTO `delivery_order` VALUES (1,3,'2015-03-21',855,'S','Blue',500,1,2,1);
/*!40000 ALTER TABLE `delivery_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_schedule`
--

DROP TABLE IF EXISTS `delivery_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_schedule` (
  `doNumber` int(11) NOT NULL,
  `promo` int(11) NOT NULL,
  `driver` int(11) NOT NULL,
  `dateMade` date NOT NULL,
  `boxQty` int(11) NOT NULL,
  `preparedBy` int(11) NOT NULL,
  PRIMARY KEY (`doNumber`,`promo`),
  KEY `FK_DStoUser_idx` (`driver`),
  KEY `FKDStoPromo_idx` (`promo`),
  CONSTRAINT `FKDStoPromo` FOREIGN KEY (`promo`) REFERENCES `promo` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DStoDO` FOREIGN KEY (`doNumber`, `promo`) REFERENCES `delivery_order` (`doNumber`, `promo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DStoUser` FOREIGN KEY (`driver`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_schedule`
--

LOCK TABLES `delivery_schedule` WRITE;
/*!40000 ALTER TABLE `delivery_schedule` DISABLE KEYS */;
INSERT INTO `delivery_schedule` VALUES (1,3,1,'2015-01-20',100,2);
/*!40000 ALTER TABLE `delivery_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_report`
--

DROP TABLE IF EXISTS `inventory_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_report` (
  `promo` int(11) NOT NULL,
  `dateMade` date NOT NULL,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `remainingQty` int(11) NOT NULL,
  `soldQty` int(11) NOT NULL,
  `pulledOutQty` int(11) NOT NULL,
  PRIMARY KEY (`promo`,`dateMade`,`productID`,`size`,`color`),
  KEY `FK_IRtoProduct_idx` (`productID`,`size`,`color`),
  CONSTRAINT `FK_IRtoProduct` FOREIGN KEY (`productID`, `size`, `color`) REFERENCES `product` (`productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_IRtoPromo` FOREIGN KEY (`promo`) REFERENCES `promo` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_report`
--

LOCK TABLES `inventory_report` WRITE;
/*!40000 ALTER TABLE `inventory_report` DISABLE KEYS */;
INSERT INTO `inventory_report` VALUES (3,'2015-03-21',855,'S','Blue',300,158,5);
/*!40000 ALTER TABLE `inventory_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picking_form`
--

DROP TABLE IF EXISTS `picking_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picking_form` (
  `promo` int(11) NOT NULL,
  `dateMade` date NOT NULL,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `madeBy` int(11) NOT NULL,
  `requestedQty` int(11) NOT NULL,
  PRIMARY KEY (`promo`,`dateMade`,`productID`,`size`,`color`),
  KEY `FK_PFtoUser_idx` (`madeBy`),
  CONSTRAINT `FK_PFtoIR` FOREIGN KEY (`promo`, `dateMade`, `productID`, `size`, `color`) REFERENCES `inventory_report` (`promo`, `dateMade`, `productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PFtoUser` FOREIGN KEY (`madeBy`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picking_form`
--

LOCK TABLES `picking_form` WRITE;
/*!40000 ALTER TABLE `picking_form` DISABLE KEYS */;
INSERT INTO `picking_form` VALUES (3,'2015-03-21',855,'S','Blue',2,5000);
/*!40000 ALTER TABLE `picking_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `productDescription` varchar(45) NOT NULL,
  `ageGroup` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `unitPrice` varchar(45) NOT NULL,
  PRIMARY KEY (`productID`,`size`,`color`),
  KEY `FK_productToSize_idx` (`size`),
  CONSTRAINT `FK_productToSize` FOREIGN KEY (`size`) REFERENCES `ref-size` (`sizeDescription`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=857 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (855,'S','Blue','Relaxed','Adult','F','270.00'),(856,'S','Red','Relaxed','Adult','F','270.00');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `production_inventory`
--

DROP TABLE IF EXISTS `production_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `production_inventory` (
  `productionNumber` int(11) NOT NULL,
  `category` varchar(45) NOT NULL,
  `drNumber` int(11) NOT NULL,
  `dateUpdated` date NOT NULL,
  `qty` int(11) NOT NULL,
  `unitMeasurement` varchar(45) NOT NULL,
  `approval` tinyint(1) NOT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`productionNumber`,`dateUpdated`,`drNumber`,`category`),
  KEY `FK_PItoSDR_idx` (`productionNumber`,`category`,`drNumber`),
  CONSTRAINT `FK_PItoSDR` FOREIGN KEY (`productionNumber`, `category`, `drNumber`) REFERENCES `cutting_report` (`productionNumber`, `category`, `drNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `production_inventory`
--

LOCK TABLES `production_inventory` WRITE;
/*!40000 ALTER TABLE `production_inventory` DISABLE KEYS */;
INSERT INTO `production_inventory` VALUES (1,'Shirt',2,'2015-03-09',1200,'pcs',1,NULL);
/*!40000 ALTER TABLE `production_inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promo`
--

DROP TABLE IF EXISTS `promo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promo` (
  `employeeID` int(11) NOT NULL AUTO_INCREMENT,
  `outlet` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`employeeID`,`outlet`),
  CONSTRAINT `FK_promoToUser` FOREIGN KEY (`employeeID`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promo`
--

LOCK TABLES `promo` WRITE;
/*!40000 ALTER TABLE `promo` DISABLE KEYS */;
INSERT INTO `promo` VALUES (3,'cash and carry','manila city'),(4,'cash and carry','manila city');
/*!40000 ALTER TABLE `promo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref-size`
--

DROP TABLE IF EXISTS `ref-size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref-size` (
  `sizeDescription` varchar(45) NOT NULL,
  PRIMARY KEY (`sizeDescription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref-size`
--

LOCK TABLES `ref-size` WRITE;
/*!40000 ALTER TABLE `ref-size` DISABLE KEYS */;
INSERT INTO `ref-size` VALUES ('29'),('30'),('31'),('32'),('33'),('34'),('36'),('38'),('L'),('M'),('S'),('XL'),('XS'),('XXXL');
/*!40000 ALTER TABLE `ref-size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref-status`
--

DROP TABLE IF EXISTS `ref-status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref-status` (
  `statusName` varchar(20) NOT NULL,
  PRIMARY KEY (`statusName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref-status`
--

LOCK TABLES `ref-status` WRITE;
/*!40000 ALTER TABLE `ref-status` DISABLE KEYS */;
INSERT INTO `ref-status` VALUES ('complete'),('in progress'),('incomplete'),('rejected');
/*!40000 ALTER TABLE `ref-status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref-subcon`
--

DROP TABLE IF EXISTS `ref-subcon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref-subcon` (
  `subconID` int(11) NOT NULL,
  `service` varchar(45) NOT NULL,
  `companyName` varchar(45) NOT NULL,
  `companyAddress` varchar(100) NOT NULL,
  `contactPerson` varchar(45) NOT NULL,
  `contactNumber` decimal(8,0) NOT NULL,
  PRIMARY KEY (`subconID`,`service`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref-subcon`
--

LOCK TABLES `ref-subcon` WRITE;
/*!40000 ALTER TABLE `ref-subcon` DISABLE KEYS */;
INSERT INTO `ref-subcon` VALUES (1,'Printing','Gembry Garments','none','Roland',4446083);
/*!40000 ALTER TABLE `ref-subcon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref-supplier`
--

DROP TABLE IF EXISTS `ref-supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref-supplier` (
  `supplierID` int(11) NOT NULL AUTO_INCREMENT,
  `itemDescription` varchar(45) NOT NULL,
  `companyName` varchar(45) NOT NULL,
  `companyAddress` varchar(100) NOT NULL,
  `contactPerson` varchar(45) NOT NULL,
  `contactNumber` decimal(11,0) NOT NULL,
  PRIMARY KEY (`supplierID`,`itemDescription`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref-supplier`
--

LOCK TABLES `ref-supplier` WRITE;
/*!40000 ALTER TABLE `ref-supplier` DISABLE KEYS */;
INSERT INTO `ref-supplier` VALUES (1,'Calendar','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S28','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S29','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S30','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S31','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S32','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S33','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S34','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S36','Cleveland Printing Company, Inc.','None','Wilma',3620645),(1,'Hashtags - S38','Cleveland Printing Company, Inc.','None','Wilma',3620645),(2,'Fabric - Cotton ','White Gold Manufacturing Corp.','None','Jimmy',4446491);
/*!40000 ALTER TABLE `ref-supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcon_delivery_receipt`
--

DROP TABLE IF EXISTS `subcon_delivery_receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcon_delivery_receipt` (
  `drNumber` int(11) NOT NULL AUTO_INCREMENT,
  `productionNumber` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `poNumber` int(11) NOT NULL,
  `dateReceived` date NOT NULL,
  `checkedBy` int(11) NOT NULL,
  `receivedBy` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `qty` int(11) NOT NULL,
  `comment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`drNumber`,`productionNumber`,`productID`,`size`,`color`,`poNumber`),
  KEY `FK_SDRtoSPO_idx` (`poNumber`,`productionNumber`,`productID`,`size`,`color`),
  KEY `FK_SDRtoStatus_idx` (`status`),
  KEY `FK_SubDRtoUser_idx` (`checkedBy`),
  CONSTRAINT `FK_SubDRtoSPO` FOREIGN KEY (`poNumber`, `productionNumber`, `productID`, `size`, `color`) REFERENCES `subcon_purchase_order` (`poNumber`, `productionNumber`, `productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SubDRtoStatus` FOREIGN KEY (`status`) REFERENCES `ref-status` (`statusName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SubDRtoUser` FOREIGN KEY (`checkedBy`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcon_delivery_receipt`
--

LOCK TABLES `subcon_delivery_receipt` WRITE;
/*!40000 ALTER TABLE `subcon_delivery_receipt` DISABLE KEYS */;
INSERT INTO `subcon_delivery_receipt` VALUES (1,1,855,'S','Blue',1,'2015-02-17',1,2,'complete',1000,NULL);
/*!40000 ALTER TABLE `subcon_delivery_receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcon_purchase_order`
--

DROP TABLE IF EXISTS `subcon_purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcon_purchase_order` (
  `poNumber` int(11) NOT NULL AUTO_INCREMENT,
  `productionNumber` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `subcon` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `service` varchar(45) NOT NULL,
  `unitPrice` double NOT NULL,
  `dateMade` date NOT NULL,
  `preparedBy` int(11) NOT NULL,
  `approvedBy` int(11) NOT NULL,
  `deliverySchedule` date NOT NULL,
  PRIMARY KEY (`poNumber`,`productionNumber`,`productID`,`size`,`color`),
  KEY `FK_SPOtoCR_idx` (`productionNumber`,`productID`,`size`,`color`),
  KEY `FK_SPOtoSubcon_idx` (`subcon`,`service`),
  KEY `FK_SPOtoUser_idx` (`preparedBy`),
  CONSTRAINT `FK_SPOtoCR` FOREIGN KEY (`productionNumber`, `productID`, `size`, `color`) REFERENCES `consumption_report` (`productionNumber`, `productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SPOtoSubcon` FOREIGN KEY (`subcon`, `service`) REFERENCES `ref-subcon` (`subconID`, `service`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SPOtoUser0` FOREIGN KEY (`preparedBy`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcon_purchase_order`
--

LOCK TABLES `subcon_purchase_order` WRITE;
/*!40000 ALTER TABLE `subcon_purchase_order` DISABLE KEYS */;
INSERT INTO `subcon_purchase_order` VALUES (1,1,855,'S','Blue',1,1000,'Printing',450,'2015-02-13',2,1,'2015-02-16');
/*!40000 ALTER TABLE `subcon_purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_delivery_receipt`
--

DROP TABLE IF EXISTS `supplier_delivery_receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_delivery_receipt` (
  `drNumber` int(11) NOT NULL AUTO_INCREMENT,
  `poNumber` int(11) NOT NULL,
  `itemDescription` varchar(45) NOT NULL,
  `dateReceived` date NOT NULL,
  `checkedBy` int(11) NOT NULL,
  `receivedBy` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `qty` int(11) NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`drNumber`,`poNumber`,`itemDescription`),
  KEY `FK_SDRtoSPO_idx` (`poNumber`,`itemDescription`),
  KEY `FK_SDRtoUser_idx` (`checkedBy`),
  KEY `FK_SDRtoStatus_idx` (`status`),
  CONSTRAINT `FK_SDRtoSPO` FOREIGN KEY (`poNumber`, `itemDescription`) REFERENCES `supplier_purchase_order` (`poNumber`, `itemDescription`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SDRtoStatus` FOREIGN KEY (`status`) REFERENCES `ref-status` (`statusName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SDRtoUser` FOREIGN KEY (`checkedBy`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_delivery_receipt`
--

LOCK TABLES `supplier_delivery_receipt` WRITE;
/*!40000 ALTER TABLE `supplier_delivery_receipt` DISABLE KEYS */;
INSERT INTO `supplier_delivery_receipt` VALUES (1,1,'Hashtags - S28','2014-06-30',1,2,'complete',8000,NULL),(1,1,'Hashtags - S33','2014-06-30',1,2,'incomplete',4000,'To be delivered on 2014-07-01'),(2,2,'Fabric - Cotton','2015-03-06',1,2,'complete',1000,NULL);
/*!40000 ALTER TABLE `supplier_delivery_receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_purchase_order`
--

DROP TABLE IF EXISTS `supplier_purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_purchase_order` (
  `poNumber` int(11) NOT NULL AUTO_INCREMENT,
  `itemDescription` varchar(45) NOT NULL,
  `supplier` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `qty` int(11) NOT NULL,
  `unitMeasurement` varchar(45) NOT NULL,
  `unitPrice` double NOT NULL,
  `VAT` double NOT NULL,
  `dateMade` date NOT NULL,
  `preparedBy` int(11) NOT NULL,
  `ApprovedBy` int(11) NOT NULL,
  `deliverySchedule` date NOT NULL,
  PRIMARY KEY (`poNumber`,`itemDescription`),
  KEY `FK_SPOtoSuppler_idx` (`supplier`,`itemDescription`),
  KEY `FK_SPOtoUser_idx` (`preparedBy`),
  CONSTRAINT `FK_SPOtoSuppler` FOREIGN KEY (`supplier`, `itemDescription`) REFERENCES `ref-supplier` (`supplierID`, `itemDescription`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SPOtoUser` FOREIGN KEY (`preparedBy`) REFERENCES `user` (`employeeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_purchase_order`
--

LOCK TABLES `supplier_purchase_order` WRITE;
/*!40000 ALTER TABLE `supplier_purchase_order` DISABLE KEYS */;
INSERT INTO `supplier_purchase_order` VALUES (1,'Hashtags - S28',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(1,'Hashtags - S29',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(1,'Hashtags - S30',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(1,'Hashtags - S31',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(1,'Hashtags - S32',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(1,'Hashtags - S33',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(1,'Hashtags - S34',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(1,'Hashtags - S36',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(1,'Hashtags - S38',1,'Accessories',8000,'pcs',85,0,'2014-06-25',1,1,'9999-10-10'),(2,'Fabric - Cotton',2,'Fabric',80,'yard',1000,0,'2014-06-25',1,1,'9999-10-10');
/*!40000 ALTER TABLE `supplier_purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `employeeID` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  `birthDate` date NOT NULL,
  `entryDate` date NOT NULL,
  `leftDate` date NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(8) NOT NULL,
  PRIMARY KEY (`employeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Yung','Benjamin','general manager','1990-10-10','2000-10-10','9999-10-10','benj','yung'),(2,'Cruz','Tess','production manager','1991-10-10','2000-10-10','9999-10-10','tess','cruz'),(3,'Lapidario','Marielle','promo','1996-05-10','2000-10-10','9999-10-10','maryeeell','3762539'),(4,'Sy','Shermaine','promo','1995-10-16','2000-10-10','9999-10-10','scs','sy');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse_inventory`
--

DROP TABLE IF EXISTS `warehouse_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse_inventory` (
  `drNumber` int(11) NOT NULL,
  `productionNumber` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `size` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `dateUpdated` date NOT NULL,
  `qty` int(11) NOT NULL,
  `approval` tinyint(1) NOT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`drNumber`,`productionNumber`,`productID`,`size`,`color`,`dateUpdated`),
  CONSTRAINT `FK_WItoSDR` FOREIGN KEY (`drNumber`, `productionNumber`, `productID`, `size`, `color`) REFERENCES `subcon_delivery_receipt` (`drNumber`, `productionNumber`, `productID`, `size`, `color`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse_inventory`
--

LOCK TABLES `warehouse_inventory` WRITE;
/*!40000 ALTER TABLE `warehouse_inventory` DISABLE KEYS */;
INSERT INTO `warehouse_inventory` VALUES (1,1,855,'S','Blue','2015-02-17',1000,1,NULL);
/*!40000 ALTER TABLE `warehouse_inventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-09 16:57:17
