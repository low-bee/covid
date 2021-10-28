-- auto Generated on 2021-10-24
-- DROP TABLE IF EXISTS chain_day;
use covid;
CREATE TABLE  IF NOT EXISTS china_day
(
    nowConfirm      INT         NOT NULL COMMENT 'nowConfirm',
    y               VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'y',
    confirm         INT         NOT NULL DEFAULT -1 COMMENT 'confirm',
    deadRate        VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'deadRate',
    `date`          VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'date',
    localConfirm    INT         NOT NULL DEFAULT -1 COMMENT 'localConfirm',
    localConfirmH5  INT         NOT NULL DEFAULT -1 COMMENT 'localConfirmH5',
    nowSevere       INT         NOT NULL DEFAULT -1 COMMENT 'nowSevere',
    noInfect        INT         NOT NULL DEFAULT -1 COMMENT 'noInfect',
    suspect         INT         NOT NULL DEFAULT -1 COMMENT 'suspect',
    heal            INT         NOT NULL DEFAULT -1 COMMENT 'heal',
    importedCase    INT         NOT NULL DEFAULT -1 COMMENT 'importedCase',
    healRate        VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'healRate',
    noInfectH5      INT         NOT NULL DEFAULT -1 COMMENT 'noInfectH5',
    localAccConfirm INT         NOT NULL DEFAULT -1 COMMENT 'localAccConfirm',
    dead            INT         NOT NULL DEFAULT -1 COMMENT 'dead'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'chain_day';

-- auto Generated on 2021-10-24
-- DROP TABLE IF EXISTS china_day_add;
CREATE TABLE  IF NOT EXISTS china_day_add
(
    localConfirmadd   INT         NOT NULL DEFAULT -1 COMMENT 'localConfirmadd',
    deadRate          double      NOT NULL COMMENT 'deadRate',
    healRate          double      NOT NULL DEFAULT 0.0 COMMENT 'healRate',
    `date`            VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'date',
    dead              INT         NOT NULL DEFAULT -1 COMMENT 'dead',
    heal              INT         NOT NULL DEFAULT -1 COMMENT 'heal',
    infect            INT         NOT NULL DEFAULT -1 COMMENT 'infect',
    localinfectionadd INT         NOT NULL DEFAULT -1 COMMENT 'localinfectionadd',
    confirm           INT         NOT NULL DEFAULT -1 COMMENT 'confirm',
    suspect           INT         NOT NULL DEFAULT -1 COMMENT 'suspect',
    importedCase      INT         NOT NULL DEFAULT -1 COMMENT 'importedCase',
    y                 VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'y'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'china_day_add';

-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS foreign_country;
CREATE TABLE  IF NOT EXISTS foreign_country
(
    `name`            VARCHAR(50) NOT NULL COMMENT 'name',
    continent         VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'continent',
    y                 VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'y',
    `date`            VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'date',
    isUpdated         TINYINT (3) NOT NULL DEFAULT 0 COMMENT 'isUpdated',
    confirmAdd        INT         NOT NULL DEFAULT -1 COMMENT 'confirmAdd',
    confirmAddCut     INT         NOT NULL DEFAULT -1 COMMENT 'confirmAddCut',
    confirm           INT         NOT NULL DEFAULT -1 COMMENT 'confirm',
    suspect           INT         NOT NULL DEFAULT -1 COMMENT 'suspect',
    dead              INT         NOT NULL DEFAULT -1 COMMENT 'dead',
    heal              INT         NOT NULL DEFAULT -1 COMMENT 'heal',
    nowConfirm        INT         NOT NULL DEFAULT -1 COMMENT 'nowConfirm',
    confirmCompare    INT         NOT NULL DEFAULT -1 COMMENT 'confirmCompare',
    nowConfirmCompare INT         NOT NULL DEFAULT -1 COMMENT 'nowConfirmCompare',
    healCompare       INT         NOT NULL DEFAULT -1 COMMENT 'healCompare',
    deadCompare       INT         NOT NULL DEFAULT -1 COMMENT 'deadCompare'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'foreign_country';

-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS foreign_province;
CREATE TABLE  IF NOT EXISTS foreign_province
(
    `name`        VARCHAR(50) NOT NULL COMMENT 'name',
    `date`        VARCHAR(50) NOT NULL COMMENT 'date',
    nameMap       VARCHAR(50) NOT NULL COMMENT 'nameMap',
    isUpdated     TINYINT (3) NOT NULL COMMENT 'isUpdated',
    confirmAdd    INT         NOT NULL COMMENT 'confirmAdd',
    confirmAddCut INT         NOT NULL COMMENT 'confirmAddCut',
    confirm       INT         NOT NULL COMMENT 'confirm',
    suspect       INT         NOT NULL COMMENT 'suspect',
    dead          INT         NOT NULL COMMENT 'dead',
    heal          INT         NOT NULL COMMENT 'heal',
    country       VARCHAR(50) NOT NULL COMMENT 'country'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'foreign_province';

-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS province_data;
CREATE TABLE  IF NOT EXISTS province_data
(
    heal       INT NOT NULL COMMENT 'heal',
    zero       INT NOT NULL DEFAULT -1 COMMENT 'zero',
    nowConfirm INT NOT NULL DEFAULT -1 COMMENT 'nowConfirm',
    confirmAdd INT NOT NULL DEFAULT -1 COMMENT 'confirmAdd',
    dead       INT NOT NULL DEFAULT -1 COMMENT 'dead'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'province_data';

-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS wom_aboard;

CREATE TABLE  IF NOT EXISTS wom_aboard
(
    continent         VARCHAR(50) NOT NULL COMMENT 'continent',
    `name`            VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'name',
    confirm           INT         NOT NULL DEFAULT -1 COMMENT 'confirm',
    confirmAdd        INT         NOT NULL DEFAULT -1 COMMENT 'confirmAdd',
    dead              INT         NOT NULL DEFAULT -1 COMMENT 'dead',
    deadCompare       INT         NOT NULL DEFAULT -1 COMMENT 'deadCompare',
    heal              INT         NOT NULL DEFAULT -1 COMMENT 'heal',
    healCompare       INT         NOT NULL DEFAULT -1 COMMENT 'healCompare',
    pubDate           VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'pubDate',
    y                 VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'y',
    `date`            VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'date',
    nowConfirm        INT         NOT NULL DEFAULT -1 COMMENT 'nowConfirm',
    nowConfirmCompare INT         NOT NULL DEFAULT -1 COMMENT 'nowConfirmCompare',
    confirmAddCut     INT         NOT NULL DEFAULT -1 COMMENT 'confirmAddCut',
    suspect           INT         NOT NULL DEFAULT -1 COMMENT 'suspect',
    confirmCompare    INT         NOT NULL DEFAULT -1 COMMENT 'confirmCompare'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'wom_aboard';

-- auto Generated on 2021-10-25
-- DROP TABLE IF EXISTS wom_world;
CREATE TABLE  IF NOT EXISTS wom_world
(
    pubDate        VARCHAR(50) NOT NULL COMMENT 'pubDate',
    y              VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'y',
    `date`         VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'date',
    nowConfirm     INT         NOT NULL DEFAULT -1 COMMENT 'nowConfirm',
    nowConfirmAdd  INT         NOT NULL DEFAULT -1 COMMENT 'nowConfirmAdd',
    confirm        INT         NOT NULL DEFAULT -1 COMMENT 'confirm',
    confirmAdd     INT         NOT NULL DEFAULT -1 COMMENT 'confirmAdd',
    heal           INT         NOT NULL DEFAULT -1 COMMENT 'heal',
    healAdd        INT         NOT NULL DEFAULT -1 COMMENT 'healAdd',
    dead           INT         NOT NULL DEFAULT -1 COMMENT 'dead',
    deadAdd        INT         NOT NULL DEFAULT -1 COMMENT 'deadAdd',
    deathrate      INT         NOT NULL DEFAULT -1 COMMENT 'deathrate',
    curerate       INT         NOT NULL DEFAULT -1 COMMENT 'curerate',
    lastUpdateTime VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'lastUpdateTime'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'wom_world';

-- auto Generated on 2021-10-28
-- DROP TABLE IF EXISTS covid19_deaths;
CREATE TABLE IF NOT EXISTS covid19_deaths(
	dataAsOf VARCHAR (50)  DEFAULT '' COMMENT 'dataAsOf',
	startDate VARCHAR (50)DEFAULT '' COMMENT 'startDate',
	endDate VARCHAR (50)  COMMENT 'endDate',
	`group` VARCHAR (50)  DEFAULT '' COMMENT 'group',
	`state` VARCHAR (50) DEFAULT '' COMMENT 'state',
	sex VARCHAR (50)  DEFAULT '' COMMENT 'sex',
	ageGroup VARCHAR (50) DEFAULT '' COMMENT 'ageGroup',
	covid19Deaths INT  DEFAULT -1 COMMENT 'covid19Deaths',
	totalDeaths INT  DEFAULT -1 COMMENT 'totalDeaths',
	pneumoniaDeaths INT DEFAULT -1 COMMENT 'pneumoniaDeaths',
	pneumoniaAndCovid19Deaths INT DEFAULT -1 COMMENT 'pneumoniaAndCovid19Deaths',
	influenzaDeaths INT DEFAULT -1 COMMENT 'influenzaDeaths',
	pneumoniaInfluenzaOrCovid INT DEFAULT -1 COMMENT 'pneumoniaInfluenzaOrCovid'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'covid19_deaths';
