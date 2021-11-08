-- auto Generated on 2021-10-28
-- DROP TABLE IF EXISTS covid19_deaths;
CREATE TABLE covid19_deaths(
	dataAsOf VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'dataAsOf',
	startDate VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'startDate',
	endDate VARCHAR (50) NOT NULL COMMENT 'endDate',
	`group` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'group',
	`state` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'state',
	sex VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'sex',
	ageGroup VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'ageGroup',
	covid19Deaths INT NOT NULL DEFAULT -1 COMMENT 'covid19Deaths',
	totalDeaths INT NOT NULL DEFAULT -1 COMMENT 'totalDeaths',
	pneumoniaDeaths INT NOT NULL DEFAULT -1 COMMENT 'pneumoniaDeaths',
	pneumoniaAndCovid19Deaths INT NOT NULL DEFAULT -1 COMMENT 'pneumoniaAndCovid19Deaths',
	influenzaDeaths INT NOT NULL DEFAULT -1 COMMENT 'influenzaDeaths',
	pneumoniaInfluenzaOrCovid INT NOT NULL DEFAULT -1 COMMENT 'pneumoniaInfluenzaOrCovid',
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'covid19_deaths';
