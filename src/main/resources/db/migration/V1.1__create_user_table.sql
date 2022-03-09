CREATE TABLE before_user
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name  VARCHAR(20) NOT NULL
);

INSERT IGNORE INTO before_user
SET id         = 1,
    first_name = 'タロウ',
    last_name  = 'フクギン';

INSERT IGNORE INTO before_user
SET id         = 2,
    first_name = 'タロウ',
    last_name  = 'シンワギン';

INSERT IGNORE INTO before_user
SET id         = 3,
    first_name = 'タロウ',
    last_name  = 'クマギン';

CREATE TABLE after_user
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL
);
