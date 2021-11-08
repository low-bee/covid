-- auto Generated on 2021-10-31
-- DROP TABLE IF EXISTS french_covid_hospital_data;
CREATE TABLE french_covid_hospital_data(
	department INT NOT NULL AUTO_INCREMENT COMMENT '地区',
	sex INT NOT NULL DEFAULT -1 COMMENT 'sex',
	`date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'date',
	hospitalized INT NOT NULL DEFAULT -1 COMMENT 'Number of people currently hospitalized',
	resuscitation INT NOT NULL DEFAULT -1 COMMENT 'Number of people currently in resuscitation or critical care',
	returnHome INT NOT NULL DEFAULT -1 COMMENT 'Total amount of patient that returned home',
	dc INT NOT NULL DEFAULT -1 COMMENT 'Total amount of deaths at the hospital',
	ssrOrUSLD INT NOT NULL DEFAULT -1 COMMENT '当前在ssr或者USLD服务中的人数（重症）',
	hospconv INT NOT NULL DEFAULT -1 COMMENT '常规医院服务中的人数',
	otherService INT NOT NULL DEFAULT -1 COMMENT '接受其他类型服务人数'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'french_covid_hospital_data';
