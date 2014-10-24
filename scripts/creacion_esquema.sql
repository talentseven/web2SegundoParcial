-- password is '4540' hashed con http://www.nitrxgen.net/hashgen/
CREATE USER 'root'@'localhost' IDENTIFIED BY PASSWORD '4540'; 

CREATE SCHEMA IF NOT EXISTS `booksmov_db`;

USE `booksmov_db`;

DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `Preferences`;

CREATE  TABLE `Preferences` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `language` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`)  );

CREATE  TABLE `Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `preference_id` INT NULL,
  PRIMARY KEY (`id`)  );
  
ALTER TABLE `Users` ADD CONSTRAINT fk_preferences FOREIGN KEY (`preference_id`) REFERENCES `Preferences`(`id`);
  
insert into `Preferences` (language) VALUES ('es-AR');
insert into `Preferences` (language) VALUES ('es-ES');
insert into `Preferences` (language) VALUES ('en-US');
insert into `Preferences` (language) VALUES ('en-UK');

insert into `Users` (first_name, last_name, email, password, preference_id) VALUES ('Andres', 'Biasoli', 'andres@gmail.com', '123456', 1);
insert into `Users` (first_name, last_name, email, password, preference_id) VALUES ('Diego', 'Mornacco', 'diego@gmail.com', '123456', 2);
insert into `Users` (first_name, last_name, email, password, preference_id) VALUES ('John', 'Lennon', 'john@gmail.com', '123456', 3);
insert into `Users` (first_name, last_name, email, password, preference_id) VALUES ('Paul', 'McCartney', 'paul@gmail.com', '123456', 4);

GRANT ALL PRIVILEGES ON `booksmov_db`.* TO 'root'@'localhost'
  IDENTIFIED BY PASSWORD '4540';
