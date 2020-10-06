/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 5.7.18-log : Database - excise
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`excise` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `excise`;

/*Table structure for table `t_downloadlist` */

DROP TABLE IF EXISTS `t_downloadlist`;

CREATE TABLE `t_downloadlist` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `images` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `size` float DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_downloadlist` */

insert  into `t_downloadlist`(`id`,`name`,`images`,`description`,`size`,`star`,`time`) values 
(1,'核心词汇真题.doc','../images/word.jpg','通过核心词汇而出的500真题通过核心词汇而出的500真题通过核心词汇而出的500真题通过核心词汇而出的500真题通过核心词汇而出的500真题',0.5,1,'2020-09-04'),
(2,'wtu.docx','../images/word.jpg','wtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docxwtu.docx',0.25,3,'2020-09-17'),
(3,'web应用开发教案.docx','../images/word.jpg','web应用开发教案web应用开发教案web应用开发教案web应用开发教案web应用开发教案web应用开发教案web应用开发教案web应用开发教案web应用开发教案web应用开发教案web应用开发教案',5,5,'2020-09-28');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`userName`,`password`,`name`) values 
('abbbbb','123456','李四'),
('accccc','123456','张三'),
('admin','123456','管理员'),
('useradmin','123456','超级用户');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
