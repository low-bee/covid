-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS province_data;
use covid;
drop table if exists province_data;
CREATE TABLE province_data(
	heal INT NOT NULL COMMENT 'heal',
	zero INT NOT NULL DEFAULT -1 COMMENT 'zero',
	nowConfirm INT NOT NULL DEFAULT -1 COMMENT 'nowConfirm',
	confirmAdd INT NOT NULL DEFAULT -1 COMMENT 'confirmAdd',
	dead INT NOT NULL DEFAULT -1 COMMENT 'dead'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'province_data';
