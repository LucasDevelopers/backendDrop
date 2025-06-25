CREATE TABLE company (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    corporate_reason VARCHAR(100) NOT NULL,
    fantasy_name     VARCHAR(100) NOT NULL,
    cnpj             VARCHAR(30) NOT NULL,
    ie               VARCHAR(30) NULL DEFAULT NULL,
    cellphone        VARCHAR(11) NOT NULL,
    telephone        VARCHAR(11) NULL DEFAULT NULL,
    adress           VARCHAR(60) NOT NULL,
    number           VARCHAR(10) NOT NULL,
    complement       VARCHAR(50) NULL DEFAULT NULL,
    neighborhood     VARCHAR(50) NULL DEFAULT NULL,
    zip_code         VARCHAR(10) NOT NULL,
    city             VARCHAR(50) NOT NULL,
    state            VARCHAR(2) NOT NULL,
    domain           VARCHAR(100) NULL DEFAULT NULL,
    log_active       CHAR(1) NOT NULL,

    type_company ENUM('fxAdmin', 'fxCompany') NOT NULL DEFAULT 'fxCompany',

    id_create BIGINT NOT NULL,
    date_create DATETIME NOT NULL,
    date_update DATETIME NULL DEFAULT NULL,
    id_update BIGINT NULL DEFAULT NULL,
    date_deletion DATETIME NULL DEFAULT NULL,
    id_deletion BIGINT NULL DEFAULT NULL
);
