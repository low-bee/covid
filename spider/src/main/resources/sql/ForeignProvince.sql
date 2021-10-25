-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS foreign_province;
use covid;
drop table if exists foreign_province;
CREATE TABLE foreign_province(
	`name` VARCHAR (50) NOT NULL COMMENT 'name',
	`date` VARCHAR (50) NOT NULL COMMENT 'date',
	name_map VARCHAR (50) NOT NULL COMMENT 'nameMap',
	is_updated TINYINT (3) NOT NULL COMMENT 'isUpdated',
	confirm_add INT NOT NULL COMMENT 'confirmAdd',
	confirm_add_cut INT NOT NULL COMMENT 'confirmAddCut',
	confirm INT NOT NULL COMMENT 'confirm',
	suspect INT NOT NULL COMMENT 'suspect',
	dead INT NOT NULL COMMENT 'dead',
	heal INT NOT NULL COMMENT 'heal'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'foreign_province';
