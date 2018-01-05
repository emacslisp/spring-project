create database if not exists `springtutorial`;
USE `springtutorial`;

CREATE TABLE `offers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(60) NOT NULL,
  `text` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `offers` WRITE;

INSERT INTO `offers` VALUES (1,'Bob','bob@nowhereatall.com','I will write Java for you'),(2,'Mike','mike@nowhereatall.com','Web design, very cheap'),(3,'Sue','sue@nowhereatall.com','PHP coding');

UNLOCK TABLES;
