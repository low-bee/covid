-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS wom_world;
use covid;
drop table if exists wom_world;
CREATE TABLE wom_world(
	pubDate VARCHAR (50) NOT NULL COMMENT 'pubDate',
	y VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'y',
	`date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'date',
	nowConfirm INT NOT NULL DEFAULT -1 COMMENT 'nowConfirm',
	nowConfirmAdd INT NOT NULL DEFAULT -1 COMMENT 'nowConfirmAdd',
	confirm INT NOT NULL DEFAULT -1 COMMENT 'confirm',
	confirmAdd INT NOT NULL DEFAULT -1 COMMENT 'confirmAdd',
	heal INT NOT NULL DEFAULT -1 COMMENT 'heal',
	healAdd INT NOT NULL DEFAULT -1 COMMENT 'healAdd',
	dead INT NOT NULL DEFAULT -1 COMMENT 'dead',
	deadAdd INT NOT NULL DEFAULT -1 COMMENT 'deadAdd',
	deathrate INT NOT NULL DEFAULT -1 COMMENT 'deathrate',
	curerate INT NOT NULL DEFAULT -1 COMMENT 'curerate',
	lastUpdateTime VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lastUpdateTime'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'wom_world';
