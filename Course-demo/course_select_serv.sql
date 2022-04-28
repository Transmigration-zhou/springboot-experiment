/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : course_select_serv

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 18/04/2022 09:30:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `credit` float NULL DEFAULT NULL COMMENT '课程学分',
  `type` int(11) NULL DEFAULT NULL COMMENT '课程类型：1-必修课，2-选修课',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for course_arrange
-- ----------------------------
DROP TABLE IF EXISTS `course_arrange`;
CREATE TABLE `course_arrange`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程安排主键',
  `course_id` int(11) NOT NULL COMMENT '课程ID',
  `teacher_id` int(11) NOT NULL COMMENT '教师ID',
  `course_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课时间',
  `course_place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课地点',
  `max_num` int(11) NULL DEFAULT NULL COMMENT '最大选课人数',
  `selected_num` int(11) NOT NULL DEFAULT 0 COMMENT '已选学生人数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `course_arrange_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `course_arrange_ibfk_3` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of course_arrange
-- ----------------------------

-- ----------------------------
-- Table structure for select_result
-- ----------------------------
DROP TABLE IF EXISTS `select_result`;
CREATE TABLE `select_result`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课结果主键',
  `course_arrange_id` int(11) NOT NULL COMMENT '课程安排ID',
  `student_id` int(11) NOT NULL COMMENT '选课学生ID',
  `select_time` datetime(0) NOT NULL COMMENT '选课时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_arrange_id`(`course_arrange_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `select_result_ibfk_1` FOREIGN KEY (`course_arrange_id`) REFERENCES `course_arrange` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `select_result_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of select_result
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名/昵称',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '用户类型：0-管理员，1-教师，2-学生',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
