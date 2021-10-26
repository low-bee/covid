-- auto Generated on 2021-10-24
-- DROP TABLE IF EXISTS china_day_add;
use covid;
drop table if exists china_day_add;
CREATE TABLE china_day_add(
	localConfirmadd INT NOT NULL DEFAULT -1 COMMENT 'localConfirmadd',
	deadRate double NOT NULL COMMENT 'deadRate',
	healRate double NOT NULL DEFAULT 0.0 COMMENT 'healRate',
	`date` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'date',
	dead INT NOT NULL DEFAULT -1 COMMENT 'dead',
	heal INT NOT NULL DEFAULT -1 COMMENT 'heal',
	infect INT NOT NULL DEFAULT -1 COMMENT 'infect',
	localinfectionadd INT NOT NULL DEFAULT -1 COMMENT 'localinfectionadd',
	confirm INT NOT NULL DEFAULT -1 COMMENT 'confirm',
	suspect INT NOT NULL DEFAULT -1 COMMENT 'suspect',
	importedCase INT NOT NULL DEFAULT -1 COMMENT 'importedCase',
	y VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'y'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'china_day_add';
