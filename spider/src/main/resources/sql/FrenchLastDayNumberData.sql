-- auto Generated on 2021-10-31
-- DROP TABLE IF EXISTS french_last_day_number_data;
CREATE TABLE french_last_day_number_data(
	`date` VARCHAR (50) NOT NULL COMMENT 'date',
	regionName VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'Region name',
	regionNumber INT (11) NOT NULL DEFAULT -1 COMMENT 'Region number',
	lastDayIntensiveNumber INT (11) NOT NULL DEFAULT -1 COMMENT 'Number of new intensive care admissions in the last 24 hours',
	PRIMARY KEY (`date`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'french_last_day_number_data';
