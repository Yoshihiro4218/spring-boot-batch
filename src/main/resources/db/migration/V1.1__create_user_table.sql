CREATE TABLE before_user
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name  VARCHAR(20) NOT NULL
);

INSERT IGNORE INTO before_user
SET id         = 1,
    first_name = 'スズハ',
    last_name  = 'アマネ';

INSERT IGNORE INTO before_user
SET id         = 2,
    first_name = 'モエカ',
    last_name  = 'キリュウ';

INSERT IGNORE INTO before_user
SET id         = 3,
    first_name = 'ルカ',
    last_name  = 'ウルシバラ';

INSERT IGNORE INTO before_user
SET id         = 4,
    first_name = 'ルミホ',
    last_name  = 'アキハ';

CREATE TABLE after_user
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL
);
