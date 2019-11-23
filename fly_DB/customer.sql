/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : custmoer

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-11-23 22:50:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `fly_customer`
-- ----------------------------
DROP TABLE IF EXISTS `fly_customer`;
CREATE TABLE `fly_customer` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id' ,
`username`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账户' ,
`password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码' ,
`nick_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称' ,
`email`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱' ,
`status`  int(11) NULL DEFAULT 1 COMMENT '用户状态' ,
`vip_level_id`  int(11) NOT NULL DEFAULT 2 COMMENT '客户类别' ,
`add_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间' ,
PRIMARY KEY (`id`),
FOREIGN KEY (`vip_level_id`) REFERENCES `fly_level` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `fk_vip_level` (`vip_level_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户id'
AUTO_INCREMENT=7

;

-- ----------------------------
-- Records of fly_customer
-- ----------------------------
BEGIN;
INSERT INTO `fly_customer` VALUES ('6', 'admin', 'admin', '管理员', 'admin@neuedu.com', '1', '1', '2019-11-23 21:55:32');
COMMIT;

-- ----------------------------
-- Table structure for `fly_level`
-- ----------------------------
DROP TABLE IF EXISTS `fly_level`;
CREATE TABLE `fly_level` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '用户等级id' ,
`level_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '级别名字' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=8

;

-- ----------------------------
-- Records of fly_level
-- ----------------------------
BEGIN;
INSERT INTO `fly_level` VALUES ('1', '管理员'), ('2', '普通用户'), ('3', 'VIP1'), ('4', 'VIP2'), ('5', 'VIP3'), ('6', 'VIP4'), ('7', 'VIP5');
COMMIT;

-- ----------------------------
-- Auto increment value for `fly_customer`
-- ----------------------------
ALTER TABLE `fly_customer` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for `fly_level`
-- ----------------------------
ALTER TABLE `fly_level` AUTO_INCREMENT=8;
