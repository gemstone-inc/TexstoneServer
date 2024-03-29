/*
SQLyog Community v9.10 Beta1
MySQL - 5.5.11 : Database - glyphmaster_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`texstone_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `texstone_db`;


/*Table structure for table `admin_user` */

DROP TABLE IF EXISTS `ADMIN_USER`;

CREATE TABLE `ADMIN_USER` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USER_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into ADMIN_USER(USER_NAME, PASSWORD) values ('admin', 'e1ab07562f4b25ca2062b6f9c58bf16e');


/*Table structure for table `stage` */

DROP TABLE IF EXISTS `DATA_VERSION`;

CREATE TABLE `DATA_VERSION` (
  `VERSION_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RELEASE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY(`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Table structure for table `category` */

DROP TABLE IF EXISTS `CATEGORY`;

CREATE TABLE `CATEGORY` (
     `CATEGORY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
     `CATEGORY_NAME` varchar(60),
     `IMAGE_FILE_PATH` varchar(100),
     `IMAGE_FILE_SIZE` int(11),
     `IMAGE_OVER_FILE_PATH` varchar(100),
     `IMAGE_OVER_FILE_SIZE` int(11),
     `DATA_VERSION_ID` bigint(20) DEFAULT NULL,
     PRIMARY KEY(`CATEGORY_ID`),
     FOREIGN KEY(`DATA_VERSION_ID`) REFERENCES DATA_VERSION(`VERSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*Table structure for table `article` */

DROP TABLE IF EXISTS `ARTICLE`;

CREATE TABLE `ARTICLE` (
   `ARTICLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
   `REF_CATEGORY_ID` bigint(20),
   `DATA_VERSION_ID` bigint(20) DEFAULT NULL,
   `RATING` bigint(20),
   `TITLE` VARCHAR(90),
   `TITLE_FURIGANA` VARCHAR(90),
   `TAG` VARCHAR(40),
   `BODY` TEXT(1000),
   PRIMARY KEY(`ARTICLE_ID`),
   FOREIGN KEY(`REF_CATEGORY_ID`) REFERENCES CATEGORY(`CATEGORY_ID`) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY(`DATA_VERSION_ID`) REFERENCES DATA_VERSION(`VERSION_ID`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;




