-- USER --
INSERT INTO `recruitms`.`user` VALUES ('1c83366e-1b20-4af1-a850-ff5c552b4092',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','1998-10-24','candidate01@mail.com','Candidate A','FEMALE','$2a$10$YkW5d.tCahn2wgnuqhLVz.0TqtT1nFvBYFQKO34iuLQeLu3jynQdW','CANDIDATE','c01'),
                          ('46dca789-177f-43bd-ae3b-155c479488f7',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','2002-10-24','shanie0000@mail.com','Shanie','FEMALE','$2a$10$/RxVvlk69z7ZB3.J1X61hehPaNPgI7aR9J7fchi9BhaGQcEb9mmkG','CANDIDATE','shanie'),
                          ('4b964aec-15bb-4d9a-aa6a-6411240ef435',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','1995-02-11','cwy0000@mail.com','Chong Wen Yao','MALE','$2a$10$AybvA1sh6xGEQHVNfLLaTOq.CofN/BlPzD2B/LuaSylSlGCRFPAoW','CANDIDATE','cwy'),
                          ('6bcf3e5e-19c5-40ac-b3c5-da6b6244e44a',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','1968-06-27','employer03@mail.com','Employer C','MALE','$2a$10$g9KdhAP6R31qui2WeQoHReiYB9gMdSPihzpL167mM2nPW9iEeJ2zm','EMPLOYER','e03'),
                          ('8b55c0be-8df3-4faf-be29-d70a45fd138c',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','2000-08-10','admin@mail.com','admin','MALE','$2a$10$IJ2HtFdxp62L6Wp1utbyB.xuliopAaM1njGePI9eWlE.oAtqDcKYe','ADMIN','admin'),
                          ('98ee3e65-6b36-47d9-b8a0-ba3c881ecd88',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','2000-06-26','chew0000@mail.com','Chew Jing Qiao','MALE','$2a$10$MyWX60w1p5NA2IjAcC0GBO.SQkcD5BRU2jMuKzMHGTVMh1vlWIWU2','CANDIDATE','cjq'),
                          ('bb78dfa2-2acd-40c7-9662-29dfc266a68d',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','2000-05-07','pinyuan.ng@sorotech-my.com','Employer Sorotech','MALE','$2a$10$XdRCaLmIx4EBahCp2DxSiOoP6KQgHFdm1xbPlW6HHtwe0TErqAk9W','EMPLOYER','e01'),
                          ('d686bbb6-76e7-4fe3-9286-e07d42c8f477',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','1988-11-17','employer02@mail.com','Employer B','MALE','$2a$10$aSBZ9FmCeL0Zud132rD/xeP/t6ZiX7urkE7hBB8QtGF1a9Kycsb8.','EMPLOYER','e02'),
                          ('dfd62c25-7dc0-4478-9464-6acced65b33c',NULL,'2022-07-13 15:09:13','2022-07-13 15:09:13',NULL,'ACTIVE','1988-10-24','candidate02@mail.com','Candidate B','MALE','$2a$10$yMxWvBR1QarXAt3I.KsHCOQPZ9i2DxEdB7T7m5ZCgNkHrqNIZX95a','CANDIDATE','c02');

-- ORGANIZATION --
INSERT INTO `recruitms`.`organization` VALUES ('54ce333b-e980-43bd-ac3b-9939f3fcf1ed','e01','2022-07-13 16:11:10','2022-07-13 16:11:10','e01','ACTIVE','1A-2-1 One Precinct, Lengkok Mayang Pasir, Bayan Baru, 11950, Pulau Pinang','A company that provided Smart Factory 4.0 Solution, including Manufacturing Execution Systems (MES) and so on.','info@sorotech-my.com','Soft Rock Technologies Sdn Bhd','60123842439','https://sorotech-my.com/','MYS','bb78dfa2-2acd-40c7-9662-29dfc266a68d'),
                                  ('15d196b4-0ffe-4856-b474-19cab46bbda6','e02','2022-07-13 16:11:10','2022-07-13 16:11:10','e02','ACTIVE','1, Jalan XX, Taman YY, 86000, Kluang, Johor','A company that doing mobiles application and publish to the app store.','companyB@mail.com','Company B','60123456789','https://www.companyB.com/','MYS','d686bbb6-76e7-4fe3-9286-e07d42c8f477'),
                                  ('7fe7b913-809f-4d6a-8897-6a7efb233f33','e03','2022-07-13 16:11:10','2022-07-13 16:11:10','e03','ACTIVE','6 Ubi Road, #05-08 Wintech Centre, Singapore 408726','Our mission is to provide employment services of the highest quality to our valued clients and we strive to conduct our business to help our clients achieve maximum productivity with the right talents. StaffKing focuses on providing excellent employment services to both large and small businesses across various industries.','info@staffking.com.sg','StaffKing','6588928103','https://www.staffking.com.sg/home','SGP','6bcf3e5e-19c5-40ac-b3c5-da6b6244e44a');

-- TAG --
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('1', 'ACTIVE', 'Software Engineer', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('2', 'ACTIVE', 'Internship', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('3', 'ACTIVE', 'Fresh Graduate', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('4', 'ACTIVE', 'Master', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('5', 'ACTIVE', 'Degree', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('6', 'ACTIVE', 'Foundation', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('7', 'ACTIVE', 'Foundation', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('8', 'ACTIVE', 'Cyber Security', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('9', 'ACTIVE', 'IT technician', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('10', 'ACTIVE', 'Support specialist', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('11', 'ACTIVE', 'Javascript', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('12', 'ACTIVE', 'Python', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('13', 'ACTIVE', 'Java', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('14', 'ACTIVE', 'C#', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('15', 'ACTIVE', 'php', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('16', 'ACTIVE', 'Android', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('17', 'ACTIVE', 'HTML', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('18', 'ACTIVE', 'jQuery', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('19', 'ACTIVE', 'C++', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('20', 'ACTIVE', 'CSS', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('21', 'ACTIVE', 'IOS', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('22', 'ACTIVE', 'mysql', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('23', 'ACTIVE', 'sql', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('24', 'ACTIVE', 'R', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('25', 'ACTIVE', 'node.js', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('26', 'ACTIVE', 'reactjs', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('27', 'ACTIVE', 'arrays', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('28', 'ACTIVE', 'C', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('29', 'ACTIVE', 'asp.net', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('30', 'ACTIVE', 'json', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('31', 'ACTIVE', 'ruby-on-rails', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('32', 'ACTIVE', '.net', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('33', 'ACTIVE', 'sql-server', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('34', 'ACTIVE', 'Web developer', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('35', 'ACTIVE', 'swift', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('36', 'ACTIVE', 'django', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('37', 'ACTIVE', 'Systems analyst', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('38', 'ACTIVE', 'angular', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('39', 'ACTIVE', 'User experience designer', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('40', 'ACTIVE', 'angularjs', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('41', 'ACTIVE', 'regex', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('42', 'ACTIVE', 'pandas', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('43', 'ACTIVE', 'ruby', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('44', 'ACTIVE', 'iphone', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('45', 'ACTIVE', 'ajax', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('46', 'ACTIVE', 'linux', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('47', 'ACTIVE', 'xml', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('48', 'ACTIVE', 'vba', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('49', 'ACTIVE', 'asp.net-mvc', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('50', 'ACTIVE', 'spring', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('51', 'ACTIVE', 'laravel', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('52', 'ACTIVE', 'typescript', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('53', 'ACTIVE', 'database', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('54', 'ACTIVE', 'wordpress', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('55', 'ACTIVE', 'Database administrators', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('56', 'ACTIVE', 'wpf', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('57', 'ACTIVE', 'mongodb', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('58', 'ACTIVE', 'windows', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('59', 'ACTIVE', 'postgresql', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('60', 'ACTIVE', 'xcode', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('61', 'ACTIVE', 'bash', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('62', 'ACTIVE', 'oracle', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('63', 'ACTIVE', 'git', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('64', 'ACTIVE', 'amazon-web-services', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('65', 'ACTIVE', 'vb.net', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('66', 'ACTIVE', 'multithreading', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('67', 'ACTIVE', 'flutter', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('68', 'ACTIVE', 'list', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('69', 'ACTIVE', 'firebase', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('70', 'ACTIVE', 'spring-boot', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('71', 'ACTIVE', 'eclipse', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('72', 'ACTIVE', 'dataframe', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('73', 'ACTIVE', 'azure', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('74', 'ACTIVE', 'react-native', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('75', 'ACTIVE', 'docker', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('76', 'ACTIVE', 'algorithm', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('77', 'ACTIVE', 'Data Scientist', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('78', 'ACTIVE', 'forms', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('79', 'ACTIVE', 'image', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('80', 'ACTIVE', 'visual-studio', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('81', 'ACTIVE', 'scala', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('82', 'ACTIVE', 'powershell', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('83', 'ACTIVE', 'function', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('84', 'ACTIVE', 'numpy', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('85', 'ACTIVE', 'twitter-bootstrap', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('86', 'ACTIVE', 'api', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('87', 'ACTIVE', 'selenium', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('88', 'ACTIVE', 'performance', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('89', 'ACTIVE', 'winforms', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('90', 'ACTIVE', 'python-2.7', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('91', 'ACTIVE', 'vue.js', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('92', 'ACTIVE', 'matlab', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('93', 'ACTIVE', 'sqlite', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('94', 'ACTIVE', 'hibernate', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('95', 'ACTIVE', 'apache', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('96', 'ACTIVE', 'loops', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('97', 'ACTIVE', 'entity-framework', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('98', 'ACTIVE', 'rest', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('99', 'ACTIVE', 'shell', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('100', 'ACTIVE', 'express', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('101', 'ACTIVE', 'android-studio', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('102', 'ACTIVE', 'facebook', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('103', 'ACTIVE', 'csv', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('104', 'ACTIVE', 'linq', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('105', 'ACTIVE', 'maven', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('106', 'ACTIVE', 'qt', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('107', 'ACTIVE', 'unit-testing', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('108', 'ACTIVE', 'swing', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('109', 'ACTIVE', 'file', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('110', 'ACTIVE', 'tensorflow', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('111', 'ACTIVE', 'class', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('112', 'ACTIVE', 'apache-spark', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('113', 'ACTIVE', 'kotlin', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('114', 'ACTIVE', 'date', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('115', 'ACTIVE', 'sorting', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('116', 'ACTIVE', 'dart', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('117', 'ACTIVE', '.htaccess', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('118', 'ACTIVE', 'dictionary', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('119', 'ACTIVE', 'symfony', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('120', 'ACTIVE', 'asp.net-core', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('121', 'ACTIVE', 'tsql', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('122', 'ACTIVE', 'google-chrome', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('123', 'ACTIVE', 'codeigniter', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('124', 'ACTIVE', 'opencv', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('125', 'ACTIVE', 'perl', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('126', 'ACTIVE', 'for-loop', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('127', 'ACTIVE', 'datetime', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('128', 'ACTIVE', 'unity3d', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('129', 'ACTIVE', 'matplotlib', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('130', 'ACTIVE', 'google-maps', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('131', 'ACTIVE', 'http', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('132', 'ACTIVE', 'validation', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('133', 'ACTIVE', 'sockets', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('134', 'ACTIVE', 'uitableview', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('135', 'ACTIVE', 'go', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('136', 'ACTIVE', 'object', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('137', 'ACTIVE', 'cordova', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('138', 'ACTIVE', 'web-services', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('139', 'ACTIVE', 'xaml', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('140', 'ACTIVE', 'oop', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('141', 'ACTIVE', 'android-layout', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('142', 'ACTIVE', 'if-statement', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('143', 'ACTIVE', 'email', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('144', 'ACTIVE', 'ubuntu', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('145', 'ACTIVE', 'spring-mvc', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('146', 'ACTIVE', 'ruby-on-rails-3', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('147', 'ACTIVE', 'ms-access', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('148', 'ACTIVE', 'c++11', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('149', 'ACTIVE', 'parsing', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('150', 'ACTIVE', 'elasticsearch', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('151', 'ACTIVE', 'authentication', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('152', 'ACTIVE', 'security', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('153', 'ACTIVE', 'user-interface', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('154', 'ACTIVE', 'pointers', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('155', 'ACTIVE', 'sql-server-2008', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('156', 'ACTIVE', 'templates', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('157', 'ACTIVE', 'batch-file', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('158', 'ACTIVE', 'jsp', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('159', 'ACTIVE', 'listview', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('160', 'ACTIVE', 'variables', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('161', 'ACTIVE', 'nginx', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('162', 'ACTIVE', 'github', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('163', 'ACTIVE', 'machine-learning', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('164', 'ACTIVE', 'flask', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('165', 'ACTIVE', 'wcf', 'Vacancy', '0');
INSERT INTO `recruitms`.`tag` (`tag_id`, `object_state`, `name`, `tag_type`, `total_used`) VALUES ('166', 'ACTIVE', 'debugging', 'Vacancy', '0');

-- VACANCY --
INSERT INTO `recruitms`.`vacancy` VALUES (1,'e01','2022-07-13 16:28:09','2022-07-13 16:28:09','e01','ACTIVE','You will be part of a growing team of Software Engineers that are developing new applications and supporting actual applications related to factory automation and the growing trend of Industry 4.0. You will be exposed to the niche and challenging Automation Solutions industry.\n\nWe have a structured internship program that requires a commitment of a minimum of 5 months. Please ensure your internship dates and latest CGPA are included in your resume.\n\nHighlights of SRT’s Internship Program:\n• Work From Home/ remotely, so we accept interns from anywhere in Malaysia!\n• Potential job offer for a full-time position for high performing candidates.\n• Structured internship program that provides guidance and mentorship.\n\nIn this role, you will:\n• Design and develop software applications based on given requirements and specifications including testing & commissioning and debugging of software applications.\n• Collaborate as a project team member on software design matters, identify issues, provide appropriate guidance and advice to ensure delivery of quality outcomes.\n• Capture and evaluate customer and internal requirements.\n• Identify and tailor suitable concepts in terms of function, technology, and effort.\n• Adhere to Good Software Design & Development Practice.\n• Develop and produce technical reports, process flow diagrams, design analysis and documentation in support of design and developments.\n\nYou have/ are:\n• A minimum CGPA of 3.3/4.0 or better.\n• Currently pursuing a Bachelor''s Degree in Computer Science/ Information Technology or Engineering (Computer Engineering, and Mechatronics) or equivalent.\n• Able to work independently and efficiently to meet deadlines.\n• Customer-oriented and committed to working systematically under tight schedules.\n• Strong people and communication skills.\n• Possess own laptop and strong internet connection to use for the internship period.\n\nExtra awesome if you have experience with:\n• Design & development of applications using .C#/.Net\n• Relational database (MSSQL and MySQL)\n• Web Development (ASP.NET MVC, PHP, and JavaScript)\n• SQL Server Reporting Services (SSRS)\n• Proficiency in Object Oriented Programming and MVC concepts\n\nAll applications will be treated in the strictest confidence and only shortlisted candidates will be contacted for an online interview.',1000,800,'Software Application Engineer (Internship)',20,'','MYS','54ce333b-e980-43bd-ac3b-9939f3fcf1ed'),
                                         (2,'e01','2022-07-13 16:39:33','2022-07-13 16:39:33','e01','ACTIVE','Job Description:\n • Analyse, design and develop e-Commerce or finance related applications. \n • Commitment and responsibility in the assigned project. \n • Coordinating with other teams on integrating with other applications. \n • Handling software releases, installations and upgrade processes. \n • Diagnosing issues and performing bug fixes/ software maintenance or configuration.  \n • Provides solutions/suggestions that fulfill the business needs. (new requests/issues handling) \n • Guides/train up juniors and ensure the juniors'' code changes follow the right design & standards.\n\nRequirements:\n • Candidate must possess at least a Diploma or Degree in Computer Science/Information Technology/ Software Engineering or equivalent. \n • Proven track record in developing e-Commerce project is required. \n • Development experience with MVC architecture. \n • Development experience with C#, ASP.NET, CSS, Javascript, AJAX & jQuery, React, Git & MS SQL Server. \n • Required language(s): English \n • Able to work independently as well as in a team to resolve customer problems. \n • At least 3 years of working experience in the related field for senior developers. ',6500,4000,'Senior Software Engineer (Asp.net/C#)',10,'','MYS','54ce333b-e980-43bd-ac3b-9939f3fcf1ed');

