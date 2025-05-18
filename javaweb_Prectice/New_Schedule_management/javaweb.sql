/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 24/06/2024 21:04:48
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_schedule
-- ----------------------------
DROP TABLE IF EXISTS `sys_schedule`;
CREATE TABLE `sys_schedule`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `completed` int(1) NULL DEFAULT NULL COMMENT '是否完成0，1',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_schedule
-- ----------------------------
INSERT INTO `sys_schedule` VALUES (20, 2, '测试修改', 1);
INSERT INTO `sys_schedule` VALUES (22, 2, '测试修改', 1);
INSERT INTO `sys_schedule` VALUES (27, 0, '123', 0);
INSERT INTO `sys_schedule` VALUES (28, 0, '测试update', 0);
INSERT INTO `sys_schedule` VALUES (29, 0, NULL, 0);
INSERT INTO `sys_schedule` VALUES (30, 0, '测试', 0);
INSERT INTO `sys_schedule` VALUES (31, 0, NULL, 0);
INSERT INTO `sys_schedule` VALUES (33, 0, '测试完成', 0);
INSERT INTO `sys_schedule` VALUES (34, 0, NULL, 0);
INSERT INTO `sys_schedule` VALUES (35, 0, '测试1111', 0);
INSERT INTO `sys_schedule` VALUES (36, 0, '测试', 0);
INSERT INTO `sys_schedule` VALUES (43, 0, '测试', 0);
INSERT INTO `sys_schedule` VALUES (44, 12, '测试修改', 0);
INSERT INTO `sys_schedule` VALUES (45, 12343, '12', 0);
INSERT INTO `sys_schedule` VALUES (46, 12343, '12', 123);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `sys_user` VALUES (2, 'lisi', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `sys_user` VALUES (3, '\"lihua\"', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `sys_user` VALUES (7, 'wangwu', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `sys_user` VALUES (8, 'zhaozili', '508df4cb2f4d8f80519256258cfb975f');

SET FOREIGN_KEY_CHECKS = 1;
