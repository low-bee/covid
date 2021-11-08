-- auto Generated on 2021-10-28
-- DROP TABLE IF EXISTS w_h_o_covid19;
CREATE TABLE IF NOT EXISTS who_ovid19(
	dateReported VARCHAR (50) NOT NULL COMMENT 'dateReported',
	countryCode VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'countryCode',
	country VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'country',
	wHORegion VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'wHORegion',
	newCases INT NOT NULL DEFAULT -1 COMMENT 'newCases',
	cumulativeCases INT NOT NULL DEFAULT -1 COMMENT 'cumulativeCases',
	newDeaths INT NOT NULL DEFAULT -1 COMMENT 'newDeaths',
	cumulativeDeaths INT NOT NULL DEFAULT -1 COMMENT 'cumulativeDeaths',
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'who_covid19';
