-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS foreign_country;
use covid;
drop table if exists foreign_country;
CREATE TABLE foreign_country(
	`name` VARCHAR (50) NOT NULL COMMENT 'name',
	continent VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'continent',
	y VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'y',
	`date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'date',
	isUpdated TINYINT (3) NOT NULL DEFAULT 0 COMMENT 'isUpdated',
	confirmAdd INT NOT NULL DEFAULT -1 COMMENT 'confirmAdd',
	confirmAddCut INT NOT NULL DEFAULT -1 COMMENT 'confirmAddCut',
	confirm INT NOT NULL DEFAULT -1 COMMENT 'confirm',
	suspect INT NOT NULL DEFAULT -1 COMMENT 'suspect',
	dead INT NOT NULL DEFAULT -1 COMMENT 'dead',
	heal INT NOT NULL DEFAULT -1 COMMENT 'heal',
	nowConfirm INT NOT NULL DEFAULT -1 COMMENT 'nowConfirm',
	confirmCompare INT NOT NULL DEFAULT -1 COMMENT 'confirmCompare',
	nowConfirmCompare INT NOT NULL DEFAULT -1 COMMENT 'nowConfirmCompare',
	healCompare INT NOT NULL DEFAULT -1 COMMENT 'healCompare',
	deadCompare INT NOT NULL DEFAULT -1 COMMENT 'deadCompare'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'foreign_country';
