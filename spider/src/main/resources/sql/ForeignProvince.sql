-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS foreign_province;
use covid;
drop table if exists foreign_province;
CREATE TABLE foreign_province(
	`name` VARCHAR (50) NOT NULL COMMENT 'name',
	`date` VARCHAR (50) NOT NULL COMMENT 'date',
	nameMap VARCHAR (50) NOT NULL COMMENT 'nameMap',
	isUpdated TINYINT (3) NOT NULL COMMENT 'isUpdated',
	confirmAdd INT NOT NULL COMMENT 'confirmAdd',
	confirmAddCut INT NOT NULL COMMENT 'confirmAddCut',
	confirm INT NOT NULL COMMENT 'confirm',
	suspect INT NOT NULL COMMENT 'suspect',
	dead INT NOT NULL COMMENT 'dead',
	heal INT NOT NULL COMMENT 'heal',
	country VARCHAR (50) NOT NULL COMMENT 'country'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'foreign_province';
