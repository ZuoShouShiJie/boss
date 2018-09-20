CREATE TABLE `boss_employee` (
  `id` int(11) NOT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  `english_name` varchar(60) DEFAULT NULL,
  `nick_name` varchar(60) DEFAULT NULL,
  `age` varchar(3) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `boss_menu` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `module_code` varchar(10) DEFAULT NULL,
  `parent_code` varchar(10) DEFAULT NULL,
  `level` varchar(3) DEFAULT NULL,
  `sort` varchar(3) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `boss_operator` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `first_login_time` timestamp NULL DEFAULT NULL,
  `last_login_time` timestamp NULL DEFAULT NULL,
  `last_login_ip` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `boss_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(45) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `boss_role_menu` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `boss_employee` (
  `id` int(11) NOT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  `english_name` varchar(60) DEFAULT NULL,
  `nick_name` varchar(60) DEFAULT NULL,
  `age` varchar(3) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `boss_menu` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `module_code` varchar(10) DEFAULT NULL,
  `parent_code` varchar(10) DEFAULT NULL,
  `level` varchar(3) DEFAULT NULL,
  `sort` varchar(3) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `boss_operator` (
  `id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `first_login_time` timestamp NULL DEFAULT NULL,
  `last_login_time` timestamp NULL DEFAULT NULL,
  `last_login_ip` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `boss_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(45) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `boss_role_menu` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `boss_operator_role` (
  `id` int(11) NOT NULL,
  `operator_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

