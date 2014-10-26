-- password is '4540' hashed con http://www.nitrxgen.net/hashgen/
CREATE USER 'root'@'localhost' IDENTIFIED BY PASSWORD '4540'; 

CREATE SCHEMA IF NOT EXISTS `booksmov_db`;

USE `booksmov_db`;

DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `Preferences`;
DROP TABLE IF EXISTS `Authors`;
DROP TABLE IF EXISTS `Actors`;
DROP TABLE IF EXISTS `Books`;
DROP TABLE IF EXISTS `Movies`;
DROP TABLE IF EXISTS `Directors`;

CREATE  TABLE `Preferences` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `language` VARCHAR(10) NULL,
  `country` VARCHAR(10) NULL,
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

CREATE  TABLE `Actors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `movie_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)  );

CREATE  TABLE `Authors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `book_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)  );
  
CREATE  TABLE `Directors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)  );
  
CREATE  TABLE `Books` (
  `isbn` VARCHAR(50) NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `rating` VARCHAR(10) NOT NULL,
  `alreadyUsed` BOOLEAN,
  `borrowable` BOOLEAN,
  `image` BLOB,
  `description` TEXT,
  PRIMARY KEY (`isbn`)  );
  
CREATE  TABLE `Movies` (
  `isan` VARCHAR(50) NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `rating` VARCHAR(10) NOT NULL,
  `alreadyUsed` BOOLEAN,
  `borrowable` BOOLEAN,
  `image` BLOB,
  `format` VARCHAR(20) NOT NULL,
  `director_id` INT NULL,
  PRIMARY KEY (`isan`)  );

  ALTER TABLE `Movies` ADD CONSTRAINT fk_director FOREIGN KEY (`director_id`)
  REFERENCES `Directors`(`id`);

  ALTER TABLE `Actors` ADD CONSTRAINT fk_movie FOREIGN KEY (`movie_id`)
  REFERENCES `Movies`(`isan`);
  
  ALTER TABLE `Authors` ADD CONSTRAINT fk_book FOREIGN KEY (`book_id`)
  REFERENCES `Books`(`isbn`);
  
insert into `Preferences` (language, country) VALUES ('es', 'AR');
insert into `Preferences` (language, country) VALUES ('es', 'ES');
insert into `Preferences` (language, country) VALUES ('en', 'US');
insert into `Preferences` (language, country) VALUES ('en', 'UK');

insert into `Users` (first_name, last_name, email, password, preference_id) VALUES ('Andres', 'Biasoli', 'andres@gmail.com', '123456', 1);
insert into `Users` (first_name, last_name, email, password, preference_id) VALUES ('Diego', 'Mornacco', 'diego@gmail.com', '123456', 2);
insert into `Users` (first_name, last_name, email, password, preference_id) VALUES ('John', 'Lennon', 'john@gmail.com', '123456', 3);
insert into `Users` (first_name, last_name, email, password, preference_id) VALUES ('Paul', 'McCartney', 'paul@gmail.com', '123456', 4);

GRANT ALL PRIVILEGES ON `booksmov_db`.* TO 'root'@'localhost'
  IDENTIFIED BY PASSWORD '4540';
