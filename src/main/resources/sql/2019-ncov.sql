-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.27 - MySQL Community Server (GPL)
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for 2019-ncov
CREATE DATABASE IF NOT EXISTS `2019-ncov` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `2019-ncov`;

-- Dumping structure for table 2019-ncov.ncov_news
CREATE TABLE IF NOT EXISTS `ncov_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(80) NOT NULL COMMENT '新闻编号',
  `title` varchar(250) NOT NULL COMMENT '新闻标题名',
  `news_type` tinyint(2) NOT NULL COMMENT '新闻类型：1-国内新闻，2-国外新闻',
  `content` text NOT NULL COMMENT '新闻内容',
  `publish_time` datetime DEFAULT NULL COMMENT '新闻发布时间',
  `from_media` varchar(80) NOT NULL COMMENT '媒体',
  `from_url` varchar(300) NOT NULL COMMENT '源文链接',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `news_type` (`news_type`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- Dumping data for table 2019-ncov.ncov_news: ~5 rows (大约)
DELETE FROM `ncov_news`;
/*!40000 ALTER TABLE `ncov_news` DISABLE KEYS */;
INSERT INTO `ncov_news` (`id`, `code`, `title`, `news_type`, `content`, `publish_time`, `from_media`, `from_url`, `gmt_created`, `gmt_modified`) VALUES
	(1, '1233377913934233954', '华农：从穿山甲中分离出的毒株与新冠毒株相似度达99%', 1, '2月7日上午11时，华南农业大学针对新型冠状病毒肺炎疫情研究攻关情况举行了新闻发布会。<br/>记者在发布会上获悉，华南农业大学、岭南现代农业科学与技术广东省实验室教授沈永义、肖立华等科研人员，通过联合攻关，在新型冠状病毒潜在中间宿主的溯源上取得突破。他们的最新研究表明，穿山甲为新型冠状病毒的潜在中间宿主。', '2020-02-07 11:10:00', '澎湃新闻', 'https://www.thepaper.cn/newsDetail_forward_5835114', '2020-02-08 18:29:41', '2020-02-08 18:29:43'),
	(3, '1233377957934233954', '本地又有一名新冠病毒患者病危', 2, '本地又有一名新冠病毒患者病危，加上昨天公布的病危病例，目前有两名病患在加护病房接受治疗。另有一名患者康复出院，出院人数增加至两人。<br/>', '2020-02-07 17:26:00', '联合早报', 'https://www.zaobao.com.sg/realtime/singapore/story20200207-1027108', '2020-02-10 13:16:20', '2020-02-10 13:16:21'),
	(4, '1233377957934333954', '对韩采取入境管制措施的国家和地区增至62个', 2, '<p><span>韩联社首尔2月28日电 据韩国外交部28日消息，截至当天下午6时50分，因新型冠状病毒（COVID-19）疫情针对韩国采取入境管制措施的国家和地区增至62个。</span></p><p><span>截至当天，全球30个国家和地区对韩国采取全面或部分禁止入境措施，较前一天新增8个国家。加大对从韩国入境人员的检疫力度的国家和地区从前一天的21个增至32个。</span></p><p><span>中国有9个省市加强对来自韩国旅客的入境检疫，包括山东省、辽宁省、吉林省、黑龙江省、福建省、广东省、山西省、四川省和上海市。越南宣布29日起暂停韩国人免签证入境。</span></p>', '2020-02-28 21:44:00', '韩联社', 'https://cn.yna.co.kr/view/ACK20200228006400881', '2020-02-28 21:06:35', NULL),
	(5, '1233378491676295170', '日本首相顾问：需5万亿日元额外支出应对疫情', 2, '<p><span>日本首相安倍晋三的一名顾问指出，日本应当再编制一项规模至少5万亿日元（628.56亿新元）的经济一揽子计划，用以应对2019冠状病毒疾病（COVID-19）疫情的巨大冲击。</span></p>', '2020-02-28 20:09:00', '联合早报', 'https://www.zaobao.com.sg/realtime/world/story20200228-1032877', '2020-02-28 21:08:42', NULL),
	(6, '1237977488038625281', '汤姆・汉克斯与妻子同在澳大利亚感染新冠肺炎', 2, '<p><span style="text-align: justify;">好莱坞著名影星汤姆・汉克斯（Tom Hanks）3月11日在推特（Twitter）表示，他与妻子丽塔（Rita Wilson）在澳大利亚感染了新型冠状病毒肺炎（COVID-19）。</span></p><p><span style="text-align: justify;">截至3月11日，澳大利亚有超过120宗新冠肺炎的确诊病例。</span></p>', '2020-03-12 09:48:00', '多维新闻', 'https://www.dwnews.com/%E5%85%A8%E7%90%83/60171866/%E6%96%B0%E5%86%A0%E8%82%BA%E7%82%8E%E6%B1%A4%E5%A7%86%E6%B1%89%E5%85%8B%E6%96%AF%E4%B8%8E%E5%A6%BB%E5%AD%90%E5%90%8C%E5%9C%A8%E6%BE%B3%E5%A4%A7%E5%88%A9%E4%BA%9A%E6%84%9F%E6%9F%93%E6%96%B0%E5%86%A0%E8%82%BA%E7%82%8E', '2020-03-12 13:43:28', NULL);
/*!40000 ALTER TABLE `ncov_news` ENABLE KEYS */;

-- Dumping structure for table 2019-ncov.ncov_permission
CREATE TABLE IF NOT EXISTS `ncov_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(80) NOT NULL COMMENT '权限编号',
  `name` varchar(50) NOT NULL COMMENT '权限名',
  `description` varchar(200) DEFAULT NULL COMMENT '权限说明',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- Dumping data for table 2019-ncov.ncov_permission: ~0 rows (大约)
DELETE FROM `ncov_permission`;
/*!40000 ALTER TABLE `ncov_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `ncov_permission` ENABLE KEYS */;

-- Dumping structure for table 2019-ncov.ncov_production_info
CREATE TABLE IF NOT EXISTS `ncov_production_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(80) NOT NULL COMMENT '编号',
  `version` varchar(50) DEFAULT NULL COMMENT '版本号',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `description` varchar(500) DEFAULT NULL COMMENT '发布说明',
  `sort` int(3) DEFAULT NULL COMMENT '排序字段',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='项目信息表';

-- Dumping data for table 2019-ncov.ncov_production_info: ~4 rows (大约)
DELETE FROM `ncov_production_info`;
/*!40000 ALTER TABLE `ncov_production_info` DISABLE KEYS */;
INSERT INTO `ncov_production_info` (`id`, `code`, `version`, `publish_time`, `description`, `sort`, `gmt_created`, `gmt_modified`) VALUES
	(1, '1231374535025754214', 'v-1.0.0', '2020-02-07 13:25:11', '首个版本发布<br/>完成首页主架构搭建', 1, '2020-02-10 13:25:13', '2020-02-10 13:25:14'),
	(2, '1231374535025754212', 'v-1.0.1', '2020-02-08 13:27:36', '完成首页文案优化<br/>完成关于我们菜单页面搭建', 2, '2020-02-10 13:27:55', '2020-02-10 13:27:56'),
	(3, '1231374535025754224', 'v-1.0.2', '2020-02-08 00:28:24', '重构html页面及页面滚动条优化<br/>更新关于我们菜单导航栏文案', 3, '2020-02-10 13:28:22', '2020-02-10 13:28:23'),
	(4, '1231374535025754314', 'v-1.0.3', '2020-02-08 00:00:00', '增加实时数据平台链接<br/>版本更新迭代后台动态生成', 4, '2020-02-10 13:28:52', '2020-02-10 13:28:51'),
	(5, '1231374535025754326', 'v-1.0.4', '2020-04-25 12:38:06', '增加用户、权限及角色表，动态获取用户账号及权限信息', 5, '2020-04-25 12:38:14', NULL);
/*!40000 ALTER TABLE `ncov_production_info` ENABLE KEYS */;

-- Dumping structure for table 2019-ncov.ncov_real_time_data
CREATE TABLE IF NOT EXISTS `ncov_real_time_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(80) NOT NULL COMMENT '实时数据编号',
  `data_type` tinyint(2) NOT NULL COMMENT '数据类型：1-国内，2-国外',
  `confirmed` bigint(20) NOT NULL COMMENT '确诊',
  `suspected` bigint(20) DEFAULT NULL COMMENT '疑似',
  `healed` bigint(20) NOT NULL COMMENT '治愈',
  `dead` bigint(20) NOT NULL COMMENT '死亡',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `data_type` (`data_type`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='实时数据表';

-- Dumping data for table 2019-ncov.ncov_real_time_data: ~13 rows (大约)
DELETE FROM `ncov_real_time_data`;
/*!40000 ALTER TABLE `ncov_real_time_data` DISABLE KEYS */;
INSERT INTO `ncov_real_time_data` (`id`, `code`, `data_type`, `confirmed`, `suspected`, `healed`, `dead`, `publish_time`, `gmt_created`, `gmt_modified`) VALUES
	(1, '1233374535025754111', 1, 34622, 27657, 2114, 723, '2020-02-08 13:42:00', '2020-02-09 13:53:44', '2020-02-10 13:53:45'),
	(2, '1233374535025754112', 1, 40235, 23589, 3359, 909, '2020-02-10 13:43:00', '2020-02-10 14:32:58', '2020-02-10 14:32:59'),
	(3, '1233374535025754113', 2, 278, NULL, 26, 1, '2020-02-08 13:36:00', '2020-02-10 14:31:04', '2020-02-10 14:31:05'),
	(4, '1233374535025754214', 1, 40235, 23589, 3386, 909, '2020-02-10 15:55:00', '2020-02-10 15:57:55', '2020-02-10 15:57:58'),
	(5, '1233374535025754115', 2, 319, NULL, 31, 1, '2020-02-10 16:01:00', '2020-02-10 16:03:01', '2020-02-10 16:03:05'),
	(6, '1233374535025754116', 1, 70637, 7264, 10866, 1772, '2020-02-17 10:43:00', '2020-02-17 10:46:45', NULL),
	(7, '1233374535025754117', 2, 694, NULL, 95, 3, '2020-02-17 10:43:00', '2020-02-17 11:02:47', NULL),
	(8, '1233374535025754114', 1, 78962, 2308, 36439, 2791, '2020-02-28 20:45:00', '2020-02-28 20:52:59', NULL),
	(9, '1233374933308473346', 2, 4425, 4838, 337, 76, '2020-02-28 20:37:00', '2020-02-28 20:54:34', NULL),
	(10, '1234291222277324802', 1, 80174, 715, 44518, 2915, '2020-02-29 09:29:00', '2020-03-02 09:35:34', NULL),
	(11, '1234295790093017090', 2, 8293, NULL, 540, 122, '2020-03-02 09:40:00', '2020-03-02 09:53:43', NULL),
	(13, '1237977971906117634', 1, 80980, 14916, 62891, 3173, '2020-03-12 13:22:00', '2020-03-12 13:45:24', NULL),
	(14, '1237978190777483266', 2, 37196, NULL, 5329, 1443, '2020-03-12 13:22:00', '2020-03-12 13:46:16', NULL);
/*!40000 ALTER TABLE `ncov_real_time_data` ENABLE KEYS */;

-- Dumping structure for table 2019-ncov.ncov_role
CREATE TABLE IF NOT EXISTS `ncov_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(80) NOT NULL COMMENT '角色编号',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `description` varchar(200) DEFAULT NULL COMMENT '角色说明',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- Dumping data for table 2019-ncov.ncov_role: ~2 rows (大约)
DELETE FROM `ncov_role`;
/*!40000 ALTER TABLE `ncov_role` DISABLE KEYS */;
INSERT INTO `ncov_role` (`id`, `code`, `name`, `description`, `gmt_created`, `gmt_modified`) VALUES
	(1, '1253887280544743425', 'ROLE_USER', '普通用户角色', '2020-04-25 11:21:41', NULL),
	(2, '1253887417023279105', 'ROLE_ADMIN', '超级管理员角色', '2020-04-25 11:21:58', NULL);
/*!40000 ALTER TABLE `ncov_role` ENABLE KEYS */;

-- Dumping structure for table 2019-ncov.ncov_role_permission
CREATE TABLE IF NOT EXISTS `ncov_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色主键',
  `role_code` varchar(80) NOT NULL COMMENT '角色编号',
  `permission_id` bigint(20) NOT NULL COMMENT '权限主键',
  `permission_code` varchar(80) NOT NULL COMMENT '权限编号',
  `gmt_created` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `role_code` (`role_code`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  KEY `permission_code` (`permission_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表（关联角色和权限）';

-- Dumping data for table 2019-ncov.ncov_role_permission: ~0 rows (大约)
DELETE FROM `ncov_role_permission`;
/*!40000 ALTER TABLE `ncov_role_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `ncov_role_permission` ENABLE KEYS */;

-- Dumping structure for table 2019-ncov.ncov_user
CREATE TABLE IF NOT EXISTS `ncov_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(80) NOT NULL COMMENT '用户编号',
  `account` varchar(50) NOT NULL COMMENT '用户账号',
  `nickname` varchar(100) NOT NULL COMMENT '用户昵称',
  `password` varchar(150) NOT NULL COMMENT '用户密码',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  UNIQUE KEY `name` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- Dumping data for table 2019-ncov.ncov_user: ~2 rows (大约)
DELETE FROM `ncov_user`;
/*!40000 ALTER TABLE `ncov_user` DISABLE KEYS */;
INSERT INTO `ncov_user` (`id`, `code`, `account`, `nickname`, `password`, `gmt_created`, `gmt_modified`) VALUES
	(1, '1253887544475553793', 'admin', '超级管理员', '$2a$10$OCu8Bbm5f8h.TdMyBHUtKuij8rGB8iu0qgZUjlvqFlDuYcru.JE3.', '2020-04-25 11:24:57', NULL),
	(2, '1253887747643424769', 'woodwhales', 'woodwhales', '$2a$10$3Rsjzi7x8jgUkebqRtU/recNfesKAnpAb2oiCtjFLynbMn7c7BmZa', '2020-04-25 11:25:38', NULL);
/*!40000 ALTER TABLE `ncov_user` ENABLE KEYS */;

-- Dumping structure for table 2019-ncov.ncov_user_permission
CREATE TABLE IF NOT EXISTS `ncov_user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `user_code` varchar(80) NOT NULL COMMENT '用户编号',
  `permission_id` bigint(20) NOT NULL COMMENT '权限主键',
  `permission_code` varchar(80) NOT NULL COMMENT '权限编号',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `user_code` (`user_code`),
  KEY `permission_id` (`permission_id`),
  KEY `permission_code` (`permission_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表（关联用户和权限）';

-- Dumping data for table 2019-ncov.ncov_user_permission: ~0 rows (大约)
DELETE FROM `ncov_user_permission`;
/*!40000 ALTER TABLE `ncov_user_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `ncov_user_permission` ENABLE KEYS */;

-- Dumping structure for table 2019-ncov.ncov_user_role
CREATE TABLE IF NOT EXISTS `ncov_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `user_code` varchar(80) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色主键',
  `role_code` varchar(80) NOT NULL COMMENT '角色编号',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `user_code` (`user_code`),
  KEY `role_id` (`role_id`),
  KEY `role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色表（关联用户和角色）';

-- Dumping data for table 2019-ncov.ncov_user_role: ~3 rows (大约)
DELETE FROM `ncov_user_role`;
/*!40000 ALTER TABLE `ncov_user_role` DISABLE KEYS */;
INSERT INTO `ncov_user_role` (`id`, `user_id`, `user_code`, `role_id`, `role_code`, `gmt_created`, `gmt_modified`) VALUES
	(1, 1, '1253887544475553793', 2, '1253887417023279105', '2020-04-25 11:57:31', NULL),
	(2, 1, '1253887544475553793', 1, '1253887280544743425', '2020-04-25 11:57:56', NULL),
	(3, 2, '1253887747643424769', 1, '1253887280544743425', '2020-04-25 11:58:41', NULL);
/*!40000 ALTER TABLE `ncov_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
