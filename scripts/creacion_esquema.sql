-- password is '4540' hashed con http://www.nitrxgen.net/hashgen/
CREATE USER 'root'@'localhost' IDENTIFIED BY PASSWORD '4540'; 

DROP SCHEMA IF EXISTS `booksmov_db`;
CREATE SCHEMA IF NOT EXISTS `booksmov_db`;

USE `booksmov_db`;

DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `Preferences`;
DROP TABLE IF EXISTS `Authors`;
DROP TABLE IF EXISTS `Actors`;
DROP TABLE IF EXISTS `Books`;
DROP TABLE IF EXISTS `Movies`;
DROP TABLE IF EXISTS `Directors`;
DROP TABLE IF EXISTS `Products`;
DROP TABLE IF EXISTS `loans`;

CREATE  TABLE `Preferences` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `language` VARCHAR(10) NULL,
  `country` VARCHAR(10) NULL,
  PRIMARY KEY (`id`)  );

CREATE  TABLE `Users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `preference_id` INT NULL,
  PRIMARY KEY (`id_user`)  );
  
ALTER TABLE `Users` ADD CONSTRAINT fk_preferences FOREIGN KEY (`preference_id`) REFERENCES `Preferences`(`id`);

CREATE  TABLE `Actors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  `movie_id` INT NOT NULL,
  PRIMARY KEY (`id`)  );

CREATE  TABLE `Authors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`id`)  );
  
CREATE  TABLE `Directors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)  );

CREATE  TABLE `Products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `rating` VARCHAR(10) NOT NULL,
  `already_used` BOOLEAN,
  `borrowable` BOOLEAN,
  `user_id` INT NOT NULL,
  `image` LONGBLOB,
  PRIMARY KEY (`id`)  );
  
CREATE  TABLE `Books` (
  `id` INT NOT NULL,
  `description` TEXT,
  PRIMARY KEY (`id`)  );

CREATE  TABLE `Movies` (
  `id` INT NOT NULL,
  `format` VARCHAR(20) NOT NULL,
  `director_id` INT NULL,
  PRIMARY KEY (`id`)  );
  
 CREATE  TABLE `loans` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `request_desc` VARCHAR(500) NOT NULL,
  `state` VARCHAR(20) NOT NULL,
  `requester_id` INT NOT NULL,
  `consignee_id` INT NOT NULL,
  `request_date` DATE NOT NULL,
  `response_date` DATE NULL,
  `delivery_date` DATE NULL,
  PRIMARY KEY (`id`)  );
  
  
  ALTER TABLE `loans` ADD CONSTRAINT fk_loan_product FOREIGN KEY (`product_id`)
  REFERENCES `Products`(`id`);
  
  ALTER TABLE `loans` ADD CONSTRAINT fk_loan_requester FOREIGN KEY (`requester_id`)
  REFERENCES `Users`(`id_user`);
  
  ALTER TABLE `loans` ADD CONSTRAINT fk_loan_consignee FOREIGN KEY (`consignee_id`)
  REFERENCES `Users`(`id_user`);
	
  ALTER TABLE `Authors` ADD CONSTRAINT fk_author_book FOREIGN KEY (`book_id`)
  REFERENCES `Books`(`id`);
  
  ALTER TABLE `Actors` ADD CONSTRAINT fk_actor_movie FOREIGN KEY (`movie_id`)
  REFERENCES `Movies`(`id`);
  
  ALTER TABLE `Movies` ADD CONSTRAINT fk_director FOREIGN KEY (`director_id`)
  REFERENCES `Directors`(`id`);
   
  ALTER TABLE `Products` ADD CONSTRAINT fk_product_user FOREIGN KEY (`user_id`)
  REFERENCES `Users`(`id_user`);

  ALTER TABLE `Movies` ADD CONSTRAINT fk_product_movie FOREIGN KEY (`id`)
  REFERENCES `Products`(`id`);

  ALTER TABLE `Books` ADD CONSTRAINT fk_product_book FOREIGN KEY (`id`)
  REFERENCES `Products`(`id`);
  
insert into `Preferences` (language, country) VALUES ('es', 'AR');
insert into `Preferences` (language, country) VALUES ('es', 'ES');
insert into `Preferences` (language, country) VALUES ('en', 'US');
insert into `Preferences` (language, country) VALUES ('en', 'UK');

insert into `Users` (name, password, preference_id) VALUES ('Andres', '123456', 1);
insert into `Users` (name, password, preference_id) VALUES ('Diego', '123456', 2);
insert into `Users` (name, password, preference_id) VALUES ('John', '123456', 3);
insert into `Users` (name, password, preference_id) VALUES ('Paul', '123456', 4);


GRANT ALL PRIVILEGES ON `booksmov_db`.* TO 'root'@'localhost'
  IDENTIFIED BY PASSWORD '4540';
