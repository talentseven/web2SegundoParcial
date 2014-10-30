-- password is '4540' hashed con http://www.nitrxgen.net/hashgen/
CREATE USER 'root'@'localhost' IDENTIFIED BY PASSWORD '4540'; 

CREATE SCHEMA IF NOT EXISTS `booksmov_db`;

USE `booksmov_db`;

DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `Preferences`;
DROP TABLE IF EXISTS `Authors_books`;
DROP TABLE IF EXISTS `Actors_movies`;
DROP TABLE IF EXISTS `Authors`;
DROP TABLE IF EXISTS `Actors`;
DROP TABLE IF EXISTS `Books`;
DROP TABLE IF EXISTS `Movies`;
DROP TABLE IF EXISTS `Directors`;
DROP TABLE IF EXISTS `Loan_requests`;

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
  PRIMARY KEY (`id`)  );

CREATE  TABLE `Authors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)  );
  
CREATE  TABLE `Directors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)  );
  
CREATE  TABLE `Books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `rating` VARCHAR(10) NOT NULL,
  `already_used` BOOLEAN,
  `borrowable` BOOLEAN,
  `user_id` INT NOT NULL,
  `image` LONGBLOB,
  `description` TEXT,
  PRIMARY KEY (`id`)  );

CREATE  TABLE `Movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `rating` VARCHAR(10) NOT NULL,
  `already_used` BOOLEAN,
  `borrowable` BOOLEAN,
  `user_id` INT NOT NULL,
  `image` LONGBLOB,
  `format` VARCHAR(20) NOT NULL,
  `director_id` INT NULL,
  PRIMARY KEY (`id`)  );
  
  CREATE  TABLE `Authors_books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`id`)  );

  CREATE  TABLE `Actors_movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `actor_id` INT NOT NULL,
  `movie_id` INT NOT NULL,
  PRIMARY KEY (`id`)  );
  /*
  CREATE  TABLE `States` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)  );
  */
  CREATE  TABLE `Loan_requests` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `request_desc` VARCHAR(500) NOT NULL,
  `state` VARCHAR(20) NOT NULL,
  `requester` INT NOT NULL,
  `consignee` INT NOT NULL,
  `request_date` DATE NOT NULL,
  `response_date` DATE NULL,
  PRIMARY KEY (`id`)  );
  
  /*
  ALTER TABLE `Loan_requests` ADD CONSTRAINT fk_loan_product FOREIGN KEY (`product_id`)
  REFERENCES 
*/
  ALTER TABLE `Authors_books` ADD CONSTRAINT fk_book_author FOREIGN KEY (`book_id`)
  REFERENCES `Books`(`id`);

  ALTER TABLE `Authors_books` ADD CONSTRAINT fk_author_book FOREIGN KEY (`author_id`)
  REFERENCES `Authors`(`id`);
  
  ALTER TABLE `Actors_movies` ADD CONSTRAINT fk_movie_actor FOREIGN KEY (`movie_id`)
  REFERENCES `Movies`(`id`);

  ALTER TABLE `Actors_movies` ADD CONSTRAINT fk_actor_movie FOREIGN KEY (`actor_id`)
  REFERENCES `Actors`(`id`);

  ALTER TABLE `Movies` ADD CONSTRAINT fk_director FOREIGN KEY (`director_id`)
  REFERENCES `Directors`(`id`);
  
  ALTER TABLE `Movies` ADD CONSTRAINT fk_user_movie FOREIGN KEY (`user_id`)
  REFERENCES `Users`(`id_user`);
  
  ALTER TABLE `Books` ADD CONSTRAINT fk_user_book FOREIGN KEY (`user_id`)
  REFERENCES `Users`(`id_user`);
  
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
