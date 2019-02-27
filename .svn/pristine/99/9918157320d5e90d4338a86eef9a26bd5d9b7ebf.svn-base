/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.3.13
 Source Server Type    : MySQL
 Source Server Version : 50615
 Source Host           : 192.168.3.13:3306
 Source Schema         : zbxc

 Target Server Type    : MySQL
 Target Server Version : 50615
 File Encoding         : 65001

 Date: 08/08/2018 22:54:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id,自动递增',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登录名',
  `pass_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `last_login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后一次的登录时间',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态,1可用,0不可用',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后一次的登录ip',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '修改人id',
  `type` int(11) NULL DEFAULT NULL COMMENT '数据字典中的账号类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'admin', 'f6fdffe48c908deb0f4c3bd36c032e72', 1, '系统超级管理员', NULL, NULL, NULL, '2018-08-08 21:51:03', 1, '192.168.1.195', '2018-08-01 23:51:17', NULL, 1, NULL, 13);
INSERT INTO `account` VALUES (2, 'test', 'f6fdffe48c908deb0f4c3bd36c032e72', 5, '测试', NULL, NULL, NULL, '2018-08-08 14:51:51', 1, '192.168.1.170', '2018-08-04 04:41:53', NULL, 1, NULL, 13);

-- ----------------------------
-- Table structure for db_log
-- ----------------------------
DROP TABLE IF EXISTS `db_log`;
CREATE TABLE `db_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自动递增',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `log` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作日志',
  `type` int(11) NULL DEFAULT NULL COMMENT '数据库操作日志类型在数据字典中的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dictionaries
-- ----------------------------
DROP TABLE IF EXISTS `dictionaries`;
CREATE TABLE `dictionaries`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自动递增',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'value',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'key',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '排序码',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父节点',
  `level` int(11) NULL DEFAULT NULL COMMENT '级别',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '修改人id',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态:0不可用,1可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dictionaries
-- ----------------------------
INSERT INTO `dictionaries` VALUES (1, '后台服务', 'SERVICE', 1, 0, 1, '2018-08-03 21:43:54', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (2, '菜单服务', 'SERVICE_MENU', 2, 1, 2, '2018-08-03 21:43:58', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (3, '组织管理服务', 'SERVICE_ROLE', 3, 1, 2, '2018-08-03 21:44:27', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (4, '数据库操作日志类型', 'DB_LOG_TYPE', 2, 0, 1, '2018-08-05 13:58:38', 1, '2018-08-08 22:01:54', 1, 0);
INSERT INTO `dictionaries` VALUES (5, '菜单操作日志', 'DB_LOG_MENU', 1, 4, 2, '2018-08-03 22:07:02', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (6, '组织管理操作日志', 'DB_LOG_ROLE', 2, 4, 2, '2018-08-03 22:07:05', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (7, '数据字典服务', 'SERVICE_DICTIONARIES', 4, 1, 2, '2018-08-05 13:48:53', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (8, '数据字典操作日志', 'DB_LOG_DICTIONARIES', 3, 4, 2, '2018-08-05 13:50:48', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (9, '无后台服务', 'SERVICE_NULL', 1, 1, 2, '2018-08-05 14:21:44', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (10, '数据库操作日志服务', 'SERVICE_DB_LOG', 5, 1, 2, '2018-08-06 23:24:27', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (11, '管理员服务', 'SERVICE_ADMIN', 6, 1, 2, '2018-08-08 15:15:35', 1, '2018-08-08 15:15:54', 1, 1);
INSERT INTO `dictionaries` VALUES (12, '账户类型', 'ACCOUNT_TYPE', 3, 0, 1, '2018-08-08 16:14:03', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (13, '系统管理员', 'ACCOUNT_ADMIN', 1, 19, 2, '2018-08-08 16:14:41', 1, NULL, NULL, 1);
INSERT INTO `dictionaries` VALUES (14, '普通用户', 'ACCOUNT_USER', 2, 19, 2, '2018-08-08 16:15:10', 1, NULL, NULL, 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id,主键自动递增',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单转跳url',
  `parent_id` int(11) NOT NULL COMMENT '上级菜单id',
  `menu_order` int(11) NULL DEFAULT NULL COMMENT '菜单排序码',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '修改人id',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '修改人id',
  `service_id` int(11) NULL DEFAULT NULL COMMENT '后台服务在数据字典中的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '后台管理', '#', 0, 10, 'icon-desktop', '2018-08-01 23:50:37', '2018-08-08 15:27:21', 1, 1, 9);
INSERT INTO `menu` VALUES (2, '菜单管理', 'menu/menu_list.html', 1, 1, 'icon-desktop', '2018-08-01 23:50:48', '0000-00-00 00:00:00', 1, NULL, 2);
INSERT INTO `menu` VALUES (3, '组织管理', 'role/role_list.html', 1, 2, NULL, '2018-08-02 00:16:53', '2018-08-03 00:44:44', 1, 1, 3);
INSERT INTO `menu` VALUES (4, '数据字典管理', 'dictionaries/zd_list.html', 1, 3, NULL, '2018-08-02 11:50:57', '2018-08-05 15:05:40', 1, 1, 7);
INSERT INTO `menu` VALUES (5, '管理员管理', 'admin/admin_list.html', 1, 4, NULL, '2018-08-02 13:28:40', '2018-08-08 22:06:35', 1, 1, 11);
INSERT INTO `menu` VALUES (6, '数据库操作日志', 'db_log/db_log.html', 1, 5, NULL, '2018-08-07 10:35:38', NULL, 1, NULL, 10);
INSERT INTO `menu` VALUES (7, '系统管理', '#', 0, 1, NULL, '2018-08-08 15:27:07', NULL, 1, NULL, NULL);
INSERT INTO `menu` VALUES (8, '网站设置', 'system/system_web.html', 7, 1, NULL, '2018-08-08 15:28:39', '2018-08-08 17:06:32', 1, 1, 9);
INSERT INTO `menu` VALUES (9, '短信设置', '#', 7, 2, NULL, '2018-08-08 15:29:41', NULL, 1, NULL, 9);
INSERT INTO `menu` VALUES (14, 'test', 'sds', 1, 13, NULL, '2018-08-08 22:07:57', NULL, 1, NULL, 9);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id,主键,制动递增',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `rights` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色权限',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父id',
  `insert_rights` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加权限',
  `delete_rights` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除权限',
  `select_rights` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查询权限',
  `update_rights` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改权限',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间\r\n',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '修改人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态:0不可用,1可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '系统管理员', NULL, 0, '1', '1', '1', '1', 1, '2018-08-03 09:28:10', NULL, NULL, 1);
INSERT INTO `role` VALUES (2, '系统超级管理员', NULL, 1, '6', '', '102', '102', 1, '2018-08-03 23:23:33', 1, '2018-08-06 09:16:59', 1);
INSERT INTO `role` VALUES (3, '系统管理员', NULL, 1, '', '', '', '', 1, '2018-08-03 23:26:47', NULL, NULL, 1);
INSERT INTO `role` VALUES (4, '医生组', NULL, 0, '', '', '', '', 1, '2018-08-03 23:28:46', NULL, NULL, 1);
INSERT INTO `role` VALUES (5, 'test', '102', 1, '486', '', '486', '486', 1, '2018-08-04 04:39:37', 1, '2018-08-08 14:52:23', 1);

SET FOREIGN_KEY_CHECKS = 1;
