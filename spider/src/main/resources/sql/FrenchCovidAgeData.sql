-- auto Generated on 2021-10-31
-- DROP TABLE IF EXISTS french_covid_age_data;
CREATE TABLE french_covid_age_data(
	region VARCHAR (50) NOT NULL COMMENT 'Region',
	ageGroup VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'Age group',
	dateOfNotice VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'Date of notice',
	currHospitalized VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'Number of people currently hospitalized',
	resuscitation VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'Number of people currently in resuscitation or critical care',
	returnHome VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'Total amount of patient that returned home',
	totalDeaths VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'Total amout of deaths',
	ssrUsld VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'ssr_usld 当前处在ssr和usld状态中的人（重症）',
	hospconv INT NOT NULL DEFAULT -1 COMMENT '常规医院服务中的人数',
	otherService INT (11) NOT NULL DEFAULT -1 COMMENT '接受其他类型服务人数'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'french_covid_age_data';
