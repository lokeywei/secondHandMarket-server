/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.20 : Database - secondmarket
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`secondmarket` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `secondmarket`;

/*Table structure for table `t_goods` */

CREATE TABLE `t_goods` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_checked` int(11) DEFAULT NULL,
  `is_sell` int(11) DEFAULT NULL,
  `cate_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_goods` */

insert  into `t_goods`(`pk_id`,`name`,`image`,`price`,`des`,`user_id`,`is_checked`,`is_sell`,`cate_id`,`create_time`) values (1,'建伍CD机 建伍DP-1010CD播放机','upload/20180116/1516066181709.jpg',128,'机器成色还可以，外壳有轻微磕碰和磨痕，机器就是激光头不行了，不读碟了，其它功能全好，进出仓正常，光盘转动。故障机器售出不退款不退货，同意的可以拍。发德邦快递邮资到付。大约25元邮资。势必退货卖家承担往返邮资。',1,1,0,10,'2018-01-16 09:29:41');
insert  into `t_goods`(`pk_id`,`name`,`image`,`price`,`des`,`user_id`,`is_checked`,`is_sell`,`cate_id`,`create_time`) values (2,'先锋 pioneer 5.1声道家庭影院套装iii xv dv202型号','upload/20180116/1516067108267.jpg',800,'同城自提，不包邮本来就不赚钱，数字功放，可以砍刀，xvdv202型号',1,1,0,10,'2018-01-16 09:45:08');
insert  into `t_goods`(`pk_id`,`name`,`image`,`price`,`des`,`user_id`,`is_checked`,`is_sell`,`cate_id`,`create_time`) values (3,'JBL无线蓝牙运动耳机','upload/20180116/1516067255877.jpg',78,'JBL蓝牙耳机 JBL蓝牙耳机 JBL蓝牙耳机 JBL无线蓝牙运动耳机 JBL无线蓝牙运动耳机 JBL专业磁吸无线蓝牙跑步运动耳机 入耳式 JBL专业磁吸无线蓝牙跑步运动耳机 入耳式手机HIFI耳麦够激情够刺激，创新吸磁设计，潮流新宠，摆脱束缚，避免耳机缠绕困扰，运动无限，音乐不止！金属耳机，不一样的质感！性价比之选！',1,1,1,10,'2018-01-16 09:47:35');

/*Table structure for table `t_goods_bidding` */

CREATE TABLE `t_goods_bidding` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_goods_bidding` */

insert  into `t_goods_bidding`(`pk_id`,`user_id`,`goods_id`,`price`,`create_time`) values (3,1,3,78,NULL);

/*Table structure for table `t_goods_cate` */

CREATE TABLE `t_goods_cate` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_goods_cate` */

insert  into `t_goods_cate`(`pk_id`,`name`,`state`,`create_time`,`update_time`) values (4,'闲置数码',1,'2018-01-16 09:10:46','2018-01-16 09:10:46');
insert  into `t_goods_cate`(`pk_id`,`name`,`state`,`create_time`,`update_time`) values (5,'家具日用',1,'2018-01-16 09:11:24','2018-01-16 09:11:24');
insert  into `t_goods_cate`(`pk_id`,`name`,`state`,`create_time`,`update_time`) values (6,'鞋服配饰',1,'2018-01-16 09:12:11','2018-01-16 09:12:11');
insert  into `t_goods_cate`(`pk_id`,`name`,`state`,`create_time`,`update_time`) values (7,'书籍资料',1,'2018-01-16 09:12:34','2018-01-16 09:12:34');
insert  into `t_goods_cate`(`pk_id`,`name`,`state`,`create_time`,`update_time`) values (8,'珠宝收藏',1,'2018-01-16 09:13:04','2018-01-16 09:13:04');
insert  into `t_goods_cate`(`pk_id`,`name`,`state`,`create_time`,`update_time`) values (9,'游戏账号',1,'2018-01-16 09:13:15','2018-01-16 11:37:40');
insert  into `t_goods_cate`(`pk_id`,`name`,`state`,`create_time`,`update_time`) values (10,'影音家电',1,'2018-01-16 09:13:50','2018-01-16 11:37:38');

/*Table structure for table `t_manager` */

CREATE TABLE `t_manager` (
  `pk_id` int(11) DEFAULT NULL,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_manager` */

/*Table structure for table `t_user` */

CREATE TABLE `t_user` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `publish` int(11) DEFAULT '0',
  `buy` int(11) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`pk_id`,`account`,`password`,`name`,`avatar`,`state`,`publish`,`buy`,`create_time`) values (1,'15295532565','720814','lokey',NULL,1,1,0,'2018-01-16 09:16:22');

/*Table structure for table `t_user_login_log` */

CREATE TABLE `t_user_login_log` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_login_log` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
