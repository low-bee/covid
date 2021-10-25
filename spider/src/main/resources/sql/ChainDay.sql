-- auto Generated on 2021-10-24
-- DROP TABLE IF EXISTS chain_day;
use covid;
drop table if exists chain_day;
CREATE TABLE chain_day(
	nowConfirm INT NOT NULL AUTO_INCREMENT COMMENT 'nowConfirm',
	y VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'y',
	confirm INT NOT NULL DEFAULT -1 COMMENT 'confirm',
	deadRate VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'deadRate',
	`date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'date',
	localConfirm INT NOT NULL DEFAULT -1 COMMENT 'localConfirm',
	localConfirmH5 INT NOT NULL DEFAULT -1 COMMENT 'localConfirmH5',
	nowSevere INT NOT NULL DEFAULT -1 COMMENT 'nowSevere',
	noInfect INT NOT NULL DEFAULT -1 COMMENT 'noInfect',
	suspect INT NOT NULL DEFAULT -1 COMMENT 'suspect',
	heal INT NOT NULL DEFAULT -1 COMMENT 'heal',
	importedCase INT NOT NULL DEFAULT -1 COMMENT 'importedCase',
	healRate VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'healRate',
	noInfectH5 INT NOT NULL DEFAULT -1 COMMENT 'noInfectH5',
	localAccConfirm INT NOT NULL DEFAULT -1 COMMENT 'localAccConfirm',
	dead INT NOT NULL DEFAULT -1 COMMENT 'dead',
	PRIMARY KEY (nowConfirm)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'chain_day';
