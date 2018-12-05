/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : local

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 05/12/2018 20:55:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_db_info
-- ----------------------------
DROP TABLE IF EXISTS `system_db_info`;
CREATE TABLE `system_db_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `db_name` varchar(50) DEFAULT NULL COMMENT '数据库名',
  `ip` varchar(20) DEFAULT NULL COMMENT 'ip',
  `port` int(10) DEFAULT NULL COMMENT '端口',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
