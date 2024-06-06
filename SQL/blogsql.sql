/*
 Navicat Premium Dump SQL

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : blogsql

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 06/06/2024 08:59:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bloginfo
-- ----------------------------
DROP TABLE IF EXISTS `bloginfo`;
CREATE TABLE `bloginfo`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date` date NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bloginfo
-- ----------------------------
INSERT INTO `bloginfo` VALUES ('test', 'testinfo', 'test', '2024-06-05');
INSERT INTO `bloginfo` VALUES ('3123', '233', '11', '2024-06-06');
INSERT INTO `bloginfo` VALUES ('1312323', '222222', '111', '2024-06-06');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '123456');
INSERT INTO `user` VALUES (2, 'lisi', '123456');
INSERT INTO `user` VALUES (5, 'admin', '123456');
INSERT INTO `user` VALUES (6, 'admin', 'admin');
INSERT INTO `user` VALUES (7, 'admin', 'admin');
INSERT INTO `user` VALUES (8, 'admin', 'admin');
INSERT INTO `user` VALUES (9, '21312323', '11111');

SET FOREIGN_KEY_CHECKS = 1;
