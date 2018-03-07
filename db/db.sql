/*
Navicat MySQL Data Transfer

Source Server         : local_root
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : scmsdb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-03-05 17:47:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account_type`
-- ----------------------------
DROP TABLE IF EXISTS `ACCOUNT_TYPE`;
CREATE TABLE `ACCOUNT_TYPE` (
  `ACCOUNT_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_TYPE_CODE` varchar(20) NOT NULL,
  `ACCOUNT_TYPE_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ACCOUNT_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12322 DEFAULT CHARSET=utf8 COMMENT='ACCOUNT_TYPE';

-- ----------------------------
-- Records of account_type
-- ----------------------------
INSERT INTO `account_type` VALUES ('6', '1001', '天猫');
INSERT INTO `account_type` VALUES ('7', '1002', 'QQ');
INSERT INTO `account_type` VALUES ('8', '1003', '淘宝');
INSERT INTO `account_type` VALUES ('9', '1004', 'Google');
INSERT INTO `account_type` VALUES ('10', '1005', '百度');
INSERT INTO `account_type` VALUES ('11', '1006', 'CSDN');
INSERT INTO `account_type` VALUES ('12', '1007', '雅虎');
INSERT INTO `account_type` VALUES ('13', '1008', '微软');
INSERT INTO `account_type` VALUES ('14', '1009', '魅族');
INSERT INTO `account_type` VALUES ('15', '1010', '小米');
INSERT INTO `account_type` VALUES ('16', '1011', '华为');
INSERT INTO `account_type` VALUES ('17', '1012', '锤子');
INSERT INTO `account_type` VALUES ('18', '1013', '乐视');
INSERT INTO `account_type` VALUES ('19', '1014', '一加');
INSERT INTO `account_type` VALUES ('20', '1015', '酷派');
INSERT INTO `account_type` VALUES ('21', '1016', '360');
INSERT INTO `account_type` VALUES ('22', '1017', '中兴');
INSERT INTO `account_type` VALUES ('23', '1018', '阿里巴巴');
INSERT INTO `account_type` VALUES ('24', '1019', '京东');
INSERT INTO `account_type` VALUES ('25', '1020', '苏宁');
INSERT INTO `account_type` VALUES ('26', '1021', '国美');
INSERT INTO `account_type` VALUES ('27', '1022', '亚马逊');
INSERT INTO `account_type` VALUES ('28', '1023', '当当网');
INSERT INTO `account_type` VALUES ('29', '1024', '华硕');
INSERT INTO `account_type` VALUES ('30', '1025', '小天鹅');
INSERT INTO `account_type` VALUES ('31', '1026', '花生壳');
INSERT INTO `account_type` VALUES ('32', '1027', '迅雷');
INSERT INTO `account_type` VALUES ('33', '1028', '微博');
INSERT INTO `account_type` VALUES ('34', '1029', 'gitHub');
INSERT INTO `account_type` VALUES ('35', '1030', 'Facebook');
INSERT INTO `account_type` VALUES ('36', '1030', 'Facebook');
INSERT INTO `account_type` VALUES ('37', '1031', 'Email');
INSERT INTO `account_type` VALUES ('38', '1032', '其他');
INSERT INTO `account_type` VALUES ('39', '1033', '支付宝');
INSERT INTO `account_type` VALUES ('40', '1034', '12306');
INSERT INTO `account_type` VALUES ('41', '1035', '搬瓦工vps');
INSERT INTO `account_type` VALUES ('42', '1036', 'cnblog');
INSERT INTO `account_type` VALUES ('43', '1037', '拉钩网');
INSERT INTO `account_type` VALUES ('44', '1038', 'paypal');
INSERT INTO `account_type` VALUES ('45', '1039', '自定义12');
INSERT INTO `account_type` VALUES ('46', '1040', 'viishow_cn');
INSERT INTO `account_type` VALUES ('12321', '321321', '321321');




CREATE TABLE `ATTACHMENT` (

`FILE_ID` varchar(32) NOT NULL,

`FILE_NAME` varchar(1024) NULL,

`FILE_GROUP` varchar(1024) NULL,

`ORGN_NAME` varchar(1024) NULL,

`FILE_SIZE` varchar(1024) NULL,

`FILE_EXT` varchar(1024) NULL,

`FILE_PATH` varchar(1024) NULL,

PRIMARY KEY (`FILE_ID`) 

);



