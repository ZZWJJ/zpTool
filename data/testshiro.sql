/*
MySQL Data Transfer
Source Host: localhost
Source Database: testshiro
Target Host: localhost
Target Database: testshiro
Date: 2019/3/12 10:01:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for company
-- ----------------------------
CREATE TABLE `company` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) DEFAULT NULL,
  `uname` varchar(10) DEFAULT NULL,
  `cname` varchar(30) DEFAULT NULL,
  `contactor` varchar(10) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `addinfo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
CREATE TABLE `dept` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(15) NOT NULL,
  `parent_id` int(10) NOT NULL,
  `key` varchar(10) NOT NULL,
  `level` int(10) NOT NULL,
  PRIMARY KEY (`id`,`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
CREATE TABLE `permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `perm_token` varchar(50) DEFAULT NULL,
  `perm_desc` varchar(50) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `level` int(10) DEFAULT NULL,
  `checked` int(1) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
CREATE TABLE `role` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(10) NOT NULL,
  `role_desc` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
CREATE TABLE `role_permission` (
  `role_id` int(10) NOT NULL,
  `perm_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `role_id` int(5) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `salt` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zph_com
-- ----------------------------
CREATE TABLE `zph_com` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `zphid` int(5) NOT NULL,
  `comid` int(5) NOT NULL,
  `isjoin` int(1) unsigned zerofill DEFAULT '0',
  `addinfo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zphinfo
-- ----------------------------
CREATE TABLE `zphinfo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `time` varchar(20) NOT NULL,
  `place` varchar(20) DEFAULT NULL,
  `state` int(1) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `company` VALUES ('15', '1', 'admin', '招聘', '朱凯', '15804248159', '无');
INSERT INTO `company` VALUES ('16', '1', 'admin', '测试2', '张宗炜', '15804248159', '无');
INSERT INTO `company` VALUES ('17', '1', 'admin', '测试3', '张宗炜', '15804248159', '无');
INSERT INTO `company` VALUES ('18', '3', '专员01', '测试4', '张宗炜', '15804248159', '无');
INSERT INTO `company` VALUES ('19', '9', 'admin', '招聘', '张宗炜', '15804248159', '啊撒大声地');
INSERT INTO `permission` VALUES ('1', 'system', '系统', '0', '0', null);
INSERT INTO `permission` VALUES ('2', 'systemUser', '管理员设置', '1', '1', null);
INSERT INTO `permission` VALUES ('3', 'userManager', '用户管理', '2', '2', null);
INSERT INTO `permission` VALUES ('4', 'userManagerAdd', '用户添加', '3', '3', null);
INSERT INTO `permission` VALUES ('5', 'userManagerUpdate', '用户更新', '3', '3', null);
INSERT INTO `permission` VALUES ('6', 'userManagerDelete', '用户删除', '3', '3', null);
INSERT INTO `permission` VALUES ('7', 'roleManager', '角色管理', '2', '2', null);
INSERT INTO `permission` VALUES ('8', 'roleManagerAdd', '角色添加', '7', '3', null);
INSERT INTO `permission` VALUES ('9', 'roleManagerUpdate', '角色更新', '7', '3', null);
INSERT INTO `permission` VALUES ('11', 'systemCom', '我的企业', '1', '1', null);
INSERT INTO `permission` VALUES ('12', 'comManagerAdd', '新增企业', '20', '3', null);
INSERT INTO `permission` VALUES ('13', 'roleManagerDelete', '角色删除', '7', '3', null);
INSERT INTO `permission` VALUES ('14', 'menuManager', '菜单管理', '2', '2', null);
INSERT INTO `permission` VALUES ('15', 'menuManagerAdd', '菜单增加', '14', '3', null);
INSERT INTO `permission` VALUES ('16', 'menuManagerUpdate', '菜单更新', '14', '3', null);
INSERT INTO `permission` VALUES ('17', 'menuManagerDelete', '菜单删除', '14', '3', null);
INSERT INTO `permission` VALUES ('18', 'comManagerUpdate', '企业更新', '20', '3', null);
INSERT INTO `permission` VALUES ('19', 'comManagerDelete', '企业删除', '20', '3', null);
INSERT INTO `permission` VALUES ('20', 'comManager', '我的企业管理', '11', '2', null);
INSERT INTO `permission` VALUES ('21', 'systemZph', '招聘会信息', '1', '1', null);
INSERT INTO `permission` VALUES ('22', 'zphManager', '招聘会信息管理', '21', '2', null);
INSERT INTO `permission` VALUES ('23', 'zphManagerAdd', '招聘会新增', '22', '3', null);
INSERT INTO `permission` VALUES ('24', 'zphManagerUpdate', '招聘会更新', '22', '3', null);
INSERT INTO `permission` VALUES ('25', 'zphManagerDelete', '招聘会删除', '22', '3', null);
INSERT INTO `permission` VALUES ('26', 'comManagerZphAdd', '招聘会增加', '20', '3', null);
INSERT INTO `permission` VALUES ('27', 'comManagerUserChange', '企业转移', '20', '3', null);
INSERT INTO `permission` VALUES ('29', 'deptManager', '部门管理', '2', '2', null);
INSERT INTO `permission` VALUES ('30', 'deptManagerAdd', '部门新增', '29', '3', null);
INSERT INTO `permission` VALUES ('31', 'deptManagerUpdate', '部门修改', '29', '3', null);
INSERT INTO `permission` VALUES ('32', 'deptManagerDelete', '部门删除', '29', '3', null);
INSERT INTO `permission` VALUES ('33', 'userManagerUpdatePassword', '密码重置', '3', '3', null);
INSERT INTO `role` VALUES ('1', 'admin', '管理员');
INSERT INTO `role` VALUES ('2', 'user', '普通用户');
INSERT INTO `role` VALUES ('8', 'test', '测试');
INSERT INTO `role_permission` VALUES ('8', '3');
INSERT INTO `role_permission` VALUES ('8', '4');
INSERT INTO `role_permission` VALUES ('8', '5');
INSERT INTO `role_permission` VALUES ('8', '6');
INSERT INTO `role_permission` VALUES ('8', '11');
INSERT INTO `role_permission` VALUES ('8', '20');
INSERT INTO `role_permission` VALUES ('8', '12');
INSERT INTO `role_permission` VALUES ('8', '18');
INSERT INTO `role_permission` VALUES ('8', '19');
INSERT INTO `role_permission` VALUES ('8', '26');
INSERT INTO `role_permission` VALUES ('8', '27');
INSERT INTO `role_permission` VALUES ('8', '21');
INSERT INTO `role_permission` VALUES ('8', '22');
INSERT INTO `role_permission` VALUES ('8', '23');
INSERT INTO `role_permission` VALUES ('8', '24');
INSERT INTO `role_permission` VALUES ('8', '25');
INSERT INTO `role_permission` VALUES ('2', '1');
INSERT INTO `role_permission` VALUES ('2', '2');
INSERT INTO `role_permission` VALUES ('2', '3');
INSERT INTO `role_permission` VALUES ('2', '4');
INSERT INTO `role_permission` VALUES ('2', '6');
INSERT INTO `role_permission` VALUES ('2', '11');
INSERT INTO `role_permission` VALUES ('2', '20');
INSERT INTO `role_permission` VALUES ('2', '12');
INSERT INTO `role_permission` VALUES ('2', '18');
INSERT INTO `role_permission` VALUES ('2', '19');
INSERT INTO `role_permission` VALUES ('2', '26');
INSERT INTO `role_permission` VALUES ('2', '27');
INSERT INTO `role_permission` VALUES ('2', '21');
INSERT INTO `role_permission` VALUES ('2', '22');
INSERT INTO `role_permission` VALUES ('2', '23');
INSERT INTO `role_permission` VALUES ('2', '24');
INSERT INTO `role_permission` VALUES ('2', '25');
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('1', '2');
INSERT INTO `role_permission` VALUES ('1', '3');
INSERT INTO `role_permission` VALUES ('1', '4');
INSERT INTO `role_permission` VALUES ('1', '5');
INSERT INTO `role_permission` VALUES ('1', '6');
INSERT INTO `role_permission` VALUES ('1', '33');
INSERT INTO `role_permission` VALUES ('1', '7');
INSERT INTO `role_permission` VALUES ('1', '8');
INSERT INTO `role_permission` VALUES ('1', '9');
INSERT INTO `role_permission` VALUES ('1', '13');
INSERT INTO `role_permission` VALUES ('1', '14');
INSERT INTO `role_permission` VALUES ('1', '15');
INSERT INTO `role_permission` VALUES ('1', '16');
INSERT INTO `role_permission` VALUES ('1', '17');
INSERT INTO `role_permission` VALUES ('1', '29');
INSERT INTO `role_permission` VALUES ('1', '30');
INSERT INTO `role_permission` VALUES ('1', '31');
INSERT INTO `role_permission` VALUES ('1', '32');
INSERT INTO `role_permission` VALUES ('1', '11');
INSERT INTO `role_permission` VALUES ('1', '20');
INSERT INTO `role_permission` VALUES ('1', '12');
INSERT INTO `role_permission` VALUES ('1', '18');
INSERT INTO `role_permission` VALUES ('1', '19');
INSERT INTO `role_permission` VALUES ('1', '26');
INSERT INTO `role_permission` VALUES ('1', '27');
INSERT INTO `role_permission` VALUES ('1', '21');
INSERT INTO `role_permission` VALUES ('1', '22');
INSERT INTO `role_permission` VALUES ('1', '23');
INSERT INTO `role_permission` VALUES ('1', '24');
INSERT INTO `role_permission` VALUES ('1', '25');
INSERT INTO `user` VALUES ('9', 'admin', '15804248159', '1', 'd9d57a90fa05c6fb432111048f6a9fa8', 'SXYnNsKpvyvo73bV5ANStQ==');
INSERT INTO `user` VALUES ('10', 'joke', '15804248159', '2', '431bccc7ac25b3618b0d572b7dd0da82', 'Nf/10+WhZWRbDY9O3I3NYQ==');
INSERT INTO `user` VALUES ('13', '张先生', '15804248159', '8', '31f0f264640a580b7d268b5d85443aae', 'UCk+lb8jLmNb7QQQ6s+Q0g==');
INSERT INTO `zph_com` VALUES ('32', '19', '15', '1', null);
INSERT INTO `zph_com` VALUES ('33', '18', '15', '0', null);
INSERT INTO `zph_com` VALUES ('34', '10', '15', '0', null);
INSERT INTO `zph_com` VALUES ('35', '17', '15', '0', null);
INSERT INTO `zph_com` VALUES ('36', '14', '15', '0', null);
INSERT INTO `zph_com` VALUES ('37', '11', '15', '0', null);
INSERT INTO `zph_com` VALUES ('38', '4', '15', '0', null);
INSERT INTO `zph_com` VALUES ('39', '20', '15', '1', null);
INSERT INTO `zph_com` VALUES ('40', '22', '15', '0', null);
INSERT INTO `zph_com` VALUES ('41', '23', '15', '0', null);
INSERT INTO `zph_com` VALUES ('42', '21', '15', '0', null);
INSERT INTO `zph_com` VALUES ('43', '23', '16', '0', null);
INSERT INTO `zph_com` VALUES ('44', '22', '16', '0', null);
INSERT INTO `zph_com` VALUES ('45', '17', '16', '0', null);
INSERT INTO `zph_com` VALUES ('46', '19', '17', '0', null);
INSERT INTO `zph_com` VALUES ('47', '18', '17', '0', null);
INSERT INTO `zph_com` VALUES ('48', '10', '17', '0', null);
INSERT INTO `zph_com` VALUES ('49', '21', '17', '0', null);
INSERT INTO `zph_com` VALUES ('50', '11', '17', '0', null);
INSERT INTO `zph_com` VALUES ('51', '20', '18', '0', null);
INSERT INTO `zph_com` VALUES ('52', '19', '18', '0', null);
INSERT INTO `zph_com` VALUES ('53', '23', '18', '0', null);
INSERT INTO `zph_com` VALUES ('54', '20', '19', '0', null);
INSERT INTO `zph_com` VALUES ('55', '19', '19', '0', null);
INSERT INTO `zphinfo` VALUES ('4', '测试4', '2021', '新龙广场', '0');
INSERT INTO `zphinfo` VALUES ('10', '测试5', '2024', '盐都开发区', '1');
INSERT INTO `zphinfo` VALUES ('11', '测试2', '2025', '万达', '0');
INSERT INTO `zphinfo` VALUES ('14', '测试6', '2019', '中南', '0');
INSERT INTO `zphinfo` VALUES ('17', '测试10', '2020', '新龙', '0');
INSERT INTO `zphinfo` VALUES ('18', '盐城国家高新区规上企业专场招聘会', '2029', '中南', '0');
INSERT INTO `zphinfo` VALUES ('19', '东进路人才市场', '2038', '新龙', '0');
INSERT INTO `zphinfo` VALUES ('20', '9月28日 盐城市第53届名企优才秋季大型招聘会通知', '2019-01-09', '万达广场', null);
INSERT INTO `zphinfo` VALUES ('21', '9月25日 盐城市第53届名企优才秋季大型招聘会通知', '2019-01-19', '中南城购物商城', null);
INSERT INTO `zphinfo` VALUES ('22', '盐都区2018韩资企业专场招聘会', '2019-01-31', '盐都区人力资源市场', null);
INSERT INTO `zphinfo` VALUES ('23', '9月26日 盐城市第53届名企优才秋季大型招聘会通知', '2019-01-26', '万达广场', null);
