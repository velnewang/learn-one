-- create table
CREATE TABLE IF NOT EXISTS `shorturl`(
`id` BIGINT(1) UNSIGNED NOT NULL,
`url` VARCHAR(2048) NOT NULL,
`counts` INT(1) NOT NULL,
`create_time` TIMESTAMP(0) NOT NULL,
`last_time` TIMESTAMP(0) NOT NULL,
PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- insert data
INSERT INTO `shorturl`
(id, url, counts, create_time, last_time)
VALUES
(0, 'http://min/0UPPW/', 42, '1971-01-01 00:00:00', '2037-12-31 12:34:56'),
(134217727, 'http://max/9ZZZZ/', 42, '1971-01-01 00:00:00', '2037-12-31 12:34:56');
