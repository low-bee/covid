-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS wom_aboard;
use covid;
drop table if exists wom_aboard;
CREATE TABLE wom_aboard(
	continent VARCHAR (50) NOT NULL COMMENT 'continent',
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
	confirm INT NOT NULL DEFAULT -1 COMMENT 'confirm',
	confirmAdd INT NOT NULL DEFAULT -1 COMMENT 'confirmAdd',
	dead INT NOT NULL DEFAULT -1 COMMENT 'dead',
	deadCompare INT NOT NULL DEFAULT -1 COMMENT 'deadCompare',
	heal INT NOT NULL DEFAULT -1 COMMENT 'heal',
	healCompare INT NOT NULL DEFAULT -1 COMMENT 'healCompare',
	pubDate VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'pubDate',
	y VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'y',
	`date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'date',
	nowConfirm INT NOT NULL DEFAULT -1 COMMENT 'nowConfirm',
	nowConfirmCompare INT NOT NULL DEFAULT -1 COMMENT 'nowConfirmCompare',
	confirmAddCut INT NOT NULL DEFAULT -1 COMMENT 'confirmAddCut',
	suspect INT NOT NULL DEFAULT -1 COMMENT 'suspect',
	confirmCompare INT NOT NULL DEFAULT -1 COMMENT 'confirmCompare'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'wom_aboard';
