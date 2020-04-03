﻿# Host: localhost  (Version 5.7.17)
# Date: 2018-07-25 10:09:18
# Generator: MySQL-Front 6.0  (Build 1.164)


#
# Structure for table "beginning_cash"
#

DROP TABLE IF EXISTS `beginning_cash`;
CREATE TABLE `beginning_cash` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "beginning_cash"
#

INSERT INTO `beginning_cash` VALUES (1,'2017-12-31',50000.00);

#
# Structure for table "contesttable"
#

DROP TABLE IF EXISTS `contesttable`;
CREATE TABLE `contesttable` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "contesttable"
#


#
# Structure for table "counter"
#

DROP TABLE IF EXISTS `counter`;
CREATE TABLE `counter` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "counter"
#

INSERT INTO `counter` VALUES (1,'1','1'),(2,'2','1'),(3,'3','1'),(4,'4','1'),(5,'5','1'),(6,'6','1'),(7,'7','1'),(8,'8','1');

#
# Structure for table "customer_master"
#

DROP TABLE IF EXISTS `customer_master`;
CREATE TABLE `customer_master` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `address` varchar(5000) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT '0.00',
  `gstNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "customer_master"
#

INSERT INTO `customer_master` VALUES (1,'N/A','N/A','N/A',0.00,'N/A'),(2,'Sandeep Das','8087455225','Hadapsar',341.00,'IO745841IJ'),(3,'Manish Khalde','N/A','N/A',2920.00,'N/A');

#
# Structure for table "customer_partial_payment"
#

DROP TABLE IF EXISTS `customer_partial_payment`;
CREATE TABLE `customer_partial_payment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `paidAmount` decimal(10,2) DEFAULT NULL,
  `paymentMode` varchar(255) DEFAULT NULL,
  `chequeOrCardNumber` varchar(255) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `chequeDate` date DEFAULT NULL,
  `chequeClearanceDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `customer_partial_payment_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer_master` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "customer_partial_payment"
#

INSERT INTO `customer_partial_payment` VALUES (1,'2018-04-27',1,975.00,'Cash','N/A','N/A',NULL,NULL,'1'),(2,'2018-04-28',2,100.00,'Cash','N/A','N/A',NULL,NULL,'1'),(3,'2018-04-28',3,900.00,'Cash','N/A','N/A',NULL,NULL,'1'),(4,'2018-04-28',1,24.00,'Cash','N/A','N/A',NULL,NULL,'1'),(5,'2018-06-01',1,300.00,'Cash','N/A','N/A',NULL,NULL,'1'),(6,'2018-07-06',1,21.00,'Cash','N/A','N/A',NULL,NULL,'1');

#
# Structure for table "employee_master"
#

DROP TABLE IF EXISTS `employee_master`;
CREATE TABLE `employee_master` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `address` varchar(5000) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "employee_master"
#

INSERT INTO `employee_master` VALUES (1,'Kaushik Das','8087990544','1557, Shukrawar Peth,\nLaxminarayan Market,\nFlat No 23,\nPune 2','admin','admin',8500.00,'1');

#
# Structure for table "expenses"
#

DROP TABLE IF EXISTS `expenses`;
CREATE TABLE `expenses` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "expenses"
#

INSERT INTO `expenses` VALUES (1,'2017-12-31',0.00,NULL),(2,'2018-04-24',0.00,'Stock Purchased with bill Id: 1'),(3,'2018-04-28',20.00,'Amount paid to customer: Manish Khalde'),(4,'2018-04-28',0.00,'Stock Purchased with bill Id: 2'),(5,'2018-06-01',3000.00,'Stock Purchased with bill Id: 3'),(6,'2018-06-01',5000.00,'Stock Purchased with bill Id: 4'),(7,'2018-07-06',80.00,'Stock Purchased with bill Id: 5');

#
# Structure for table "item_master"
#

DROP TABLE IF EXISTS `item_master`;
CREATE TABLE `item_master` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `hsnCode` varchar(255) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `gstPercent` decimal(10,2) DEFAULT NULL,
  `sellingPrice` decimal(10,2) DEFAULT NULL,
  `sellingGstPercent` decimal(10,2) DEFAULT NULL,
  `finalSellingPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "item_master"
#

INSERT INTO `item_master` VALUES (2,'Aashirwad Aata','JI74580',96.90,0.00,120.00,0.00,120.00),(3,'Kohinoor Basmati Rice','PO78450',99.37,5.00,140.00,5.00,147.00),(4,'Parle - G','N/A',10.00,0.00,12.00,0.00,12.00),(5,'Lambhorgini Car','MHIJGH',100.00,0.00,150.00,0.00,150.00),(6,'Pichkari','564564',10.00,0.00,50.00,0.00,50.00),(7,'Paneer','kjj',10.00,5.00,20.00,5.00,21.00);

#
# Structure for table "item_availability"
#

DROP TABLE IF EXISTS `item_availability`;
CREATE TABLE `item_availability` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) DEFAULT NULL,
  `availability` decimal(10,3) DEFAULT NULL,
  `threshold` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `item_availability_ibfk_1` FOREIGN KEY (`itemId`) REFERENCES `item_master` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "item_availability"
#

INSERT INTO `item_availability` VALUES (1,2,20.800,6.450),(2,3,51.510,20.128),(3,4,23.000,6.250),(4,5,98.000,25.000),(5,6,500.000,125.000),(6,7,9.000,2.500);

#
# Structure for table "store_details"
#

DROP TABLE IF EXISTS `store_details`;
CREATE TABLE `store_details` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(5000) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gstNumber` varchar(255) DEFAULT NULL,
  `photo` longblob,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "store_details"
#

INSERT INTO `store_details` VALUES (1,'BK Enterprises','224, Raviwar Peth\t','Pune','Maharashtra','411002','7276305351','N/A','N/A','HJB7451521',X'FFD8FFE000104A46494600010101006000600000FFDB0043000201010201010202020202020202030503030303030604040305070607070706070708090B0908080A0807070A0D0A0A0B0C0C0C0C07090E0F0D0C0E0B0C0C0CFFDB004301020202030303060303060C0807080C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0C0CFFC0001108012F011903012200021101031101FFC4001F0000010501010101010100000000000000000102030405060708090A0BFFC400B5100002010303020403050504040000017D01020300041105122131410613516107227114328191A1082342B1C11552D1F02433627282090A161718191A25262728292A3435363738393A434445464748494A535455565758595A636465666768696A737475767778797A838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE1E2E3E4E5E6E7E8E9EAF1F2F3F4F5F6F7F8F9FAFFC4001F0100030101010101010101010000000000000102030405060708090A0BFFC400B51100020102040403040705040400010277000102031104052131061241510761711322328108144291A1B1C109233352F0156272D10A162434E125F11718191A262728292A35363738393A434445464748494A535455565758595A636465666768696A737475767778797A82838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE2E3E4E5E6E7E8E9EAF2F3F4F5F6F7F8F9FAFFDA000C03010002110311003F00FDFCA28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28AE6BE3078B35EF02FC33D6357F0C7852EFC71AF5841E6D96836D7F6F6336A6F903CB49AE196146C1241919578C6466803A5A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2800A28A2803FFD9');

#
# Structure for table "sale_master"
#

DROP TABLE IF EXISTS `sale_master`;
CREATE TABLE `sale_master` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `storeId` int(11) DEFAULT NULL,
  `counterId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `billAmount` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `finalBillAmount` decimal(10,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `storeId` (`storeId`),
  KEY `counterId` (`counterId`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `sale_master_ibfk_1` FOREIGN KEY (`storeId`) REFERENCES `store_details` (`Id`),
  CONSTRAINT `sale_master_ibfk_2` FOREIGN KEY (`counterId`) REFERENCES `counter` (`Id`),
  CONSTRAINT `sale_master_ibfk_3` FOREIGN KEY (`customerId`) REFERENCES `customer_master` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "sale_master"
#

INSERT INTO `sale_master` VALUES (1,'2018-04-27',1,1,1,561.00,0.00,561.00,'1','GST Taken','N/A'),(2,'2018-04-28',1,5,2,387.00,0.00,387.00,'1','GST Taken','N/A'),(3,'2018-04-28',1,1,3,3915.00,15.00,3900.00,'1','GST Taken','N/A'),(4,'2018-04-28',1,1,1,24.00,0.00,24.00,'1','GST Taken','N/A'),(5,'2018-06-01',1,1,1,300.00,0.00,300.00,'1','GST Taken','N/A'),(6,'2018-06-01',1,1,1,21.00,0.00,21.00,'1','GST Taken','N/A');

#
# Structure for table "sale_return"
#

DROP TABLE IF EXISTS `sale_return`;
CREATE TABLE `sale_return` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `billId` int(11) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `billId` (`billId`),
  CONSTRAINT `sale_return_ibfk_1` FOREIGN KEY (`billId`) REFERENCES `sale_master` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sale_return"
#


#
# Structure for table "sale_return_details"
#

DROP TABLE IF EXISTS `sale_return_details`;
CREATE TABLE `sale_return_details` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `returnId` int(10) DEFAULT NULL,
  `itemId` int(11) DEFAULT NULL,
  `quantity` decimal(10,3) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `gstPercent` decimal(10,2) DEFAULT NULL,
  `gstAmount` decimal(10,2) DEFAULT NULL,
  `finalTotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `returnId` (`returnId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `sale_return_details_ibfk_1` FOREIGN KEY (`returnId`) REFERENCES `sale_return` (`Id`),
  CONSTRAINT `sale_return_details_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `item_master` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sale_return_details"
#


#
# Structure for table "sale_details"
#

DROP TABLE IF EXISTS `sale_details`;
CREATE TABLE `sale_details` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `saleId` int(11) DEFAULT NULL,
  `itemId` int(11) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `gstPercent` decimal(10,2) DEFAULT '0.00',
  `sellingPrice` decimal(10,2) DEFAULT '0.00',
  `quantity` decimal(10,3) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `saleId` (`saleId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `sale_details_ibfk_1` FOREIGN KEY (`saleId`) REFERENCES `sale_master` (`Id`),
  CONSTRAINT `sale_details_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `item_master` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "sale_details"
#

INSERT INTO `sale_details` VALUES (1,1,2,120.00,0.00,120.00,1.000,120.00),(5,2,2,120.00,0.00,120.00,2.000,240.00),(6,1,3,140.00,5.00,147.00,3.000,441.00),(7,3,3,140.00,5.00,147.00,25.000,3675.00),(9,3,2,120.00,0.00,120.00,2.000,240.00),(10,4,4,12.00,0.00,12.00,2.000,24.00),(11,5,5,150.00,0.00,150.00,2.000,300.00),(12,6,7,20.00,5.00,21.00,1.000,21.00);

#
# Structure for table "vendor_master"
#

DROP TABLE IF EXISTS `vendor_master`;
CREATE TABLE `vendor_master` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `address` varchar(5000) DEFAULT NULL,
  `registration` varchar(255) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT '0.00',
  `gstNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "vendor_master"
#

INSERT INTO `vendor_master` VALUES (1,'N/A','N/A','N/A','N/A',0.00,'N/A'),(2,'Rohit Provision Store','020-5247852','414, Somwar Peth,\nPune: 411011','N/A',11170.00,'LK7845120IJ89'),(3,'Vishal Mishra Enterprises','020-24415120','Khadki','N/A',7000.00,'NJH787450UI');

#
# Structure for table "vendor_bill_master"
#

DROP TABLE IF EXISTS `vendor_bill_master`;
CREATE TABLE `vendor_bill_master` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `storeId` int(11) DEFAULT NULL,
  `vendorId` int(11) DEFAULT NULL,
  `challan` varchar(255) DEFAULT NULL,
  `billAmount` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `finalBillAmount` decimal(10,2) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `storeId` (`storeId`),
  KEY `vendorId` (`vendorId`),
  CONSTRAINT `vendor_bill_master_ibfk_1` FOREIGN KEY (`storeId`) REFERENCES `store_details` (`Id`),
  CONSTRAINT `vendor_bill_master_ibfk_2` FOREIGN KEY (`vendorId`) REFERENCES `vendor_master` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "vendor_bill_master"
#

INSERT INTO `vendor_bill_master` VALUES (1,'2018-04-25',1,2,'HU78450',10900.00,0.00,10900.00,'GST Taken','Manish Khalde'),(2,'2018-04-28',1,2,'N/A',250.00,0.00,250.00,'GST Not Taken','N/A'),(3,'2018-06-01',1,3,'HY74510',10000.00,0.00,10000.00,'GST Not Taken','N/A'),(4,'2018-06-01',1,3,'5654564',5000.00,0.00,5000.00,'GST Not Taken','N/A'),(5,'2018-07-06',1,2,'585CH',105.00,5.00,100.00,'GST Taken','N/A');

#
# Structure for table "purchase_return"
#

DROP TABLE IF EXISTS `purchase_return`;
CREATE TABLE `purchase_return` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `billId` int(11) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `billId` (`billId`),
  CONSTRAINT `purchase_return_ibfk_1` FOREIGN KEY (`billId`) REFERENCES `vendor_bill_master` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "purchase_return"
#


#
# Structure for table "purchase_return_details"
#

DROP TABLE IF EXISTS `purchase_return_details`;
CREATE TABLE `purchase_return_details` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `returnId` int(11) DEFAULT NULL,
  `itemId` int(10) DEFAULT NULL,
  `quantity` decimal(10,3) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `gstPercent` decimal(10,2) DEFAULT NULL,
  `gstAmount` decimal(10,2) DEFAULT NULL,
  `finalTotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `returnId` (`returnId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `purchase_return_details_ibfk_1` FOREIGN KEY (`returnId`) REFERENCES `purchase_return` (`Id`),
  CONSTRAINT `purchase_return_details_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `item_master` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "purchase_return_details"
#


#
# Structure for table "stock_details"
#

DROP TABLE IF EXISTS `stock_details`;
CREATE TABLE `stock_details` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `billId` int(11) DEFAULT NULL,
  `itemId` int(11) DEFAULT NULL,
  `quantity` decimal(10,3) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `gstPercent` decimal(10,2) DEFAULT NULL,
  `gstAmount` decimal(10,2) DEFAULT NULL,
  `finalTotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `billId` (`billId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `stock_details_ibfk_1` FOREIGN KEY (`billId`) REFERENCES `vendor_bill_master` (`Id`),
  CONSTRAINT `stock_details_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `item_master` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "stock_details"
#

INSERT INTO `stock_details` VALUES (1,1,2,25.800,96.90,0.00,0.00,2500.00),(2,1,3,80.510,99.37,5.00,400.00,8400.00),(3,2,4,25.000,10.00,0.00,0.00,250.00),(4,3,5,100.000,100.00,0.00,0.00,10000.00),(5,4,6,500.000,10.00,0.00,0.00,5000.00),(6,5,7,10.000,10.00,5.00,5.00,105.00);

#
# Structure for table "vendor_partial_payment"
#

DROP TABLE IF EXISTS `vendor_partial_payment`;
CREATE TABLE `vendor_partial_payment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `vendorId` int(11) DEFAULT NULL,
  `paidAmount` decimal(10,2) DEFAULT '0.00',
  `paymentMode` varchar(255) DEFAULT NULL,
  `chequeDate` date DEFAULT NULL,
  `chequeClearanceDate` date DEFAULT NULL,
  `chequeCardNumber` varchar(255) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `vendorId` (`vendorId`),
  CONSTRAINT `vendor_partial_payment_ibfk_1` FOREIGN KEY (`vendorId`) REFERENCES `vendor_master` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

#
# Data for table "vendor_partial_payment"
#

INSERT INTO `vendor_partial_payment` VALUES (1,'2018-04-25',2,5000.00,'Cheque','2018-04-25','2018-04-25','54712','Bank Of Maharashtra','2'),(2,'2018-04-28',2,0.00,'Cash',NULL,NULL,'N/A','N/A','1'),(3,'2018-06-01',3,3000.00,'Cash',NULL,NULL,'N/A','N/A','1'),(4,'2018-06-01',3,5000.00,'Cash',NULL,NULL,'N/A','N/A','1'),(5,'2018-07-06',2,80.00,'Cash',NULL,NULL,'N/A','N/A','1');
