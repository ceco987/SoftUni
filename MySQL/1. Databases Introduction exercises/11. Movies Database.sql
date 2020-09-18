CREATE SCHEMA `movies`;
USE `movies`;

CREATE TABLE `directors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `director_name` VARCHAR(200) NOT NULL,
  `notes` TEXT(200) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `genres` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `genre_name` VARCHAR(200) NOT NULL,
  `notes` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(200) NOT NULL,
  `notes` TEXT(200) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `director_id` INT NULL,
  `copyright_year` YEAR NULL,
  `length` DOUBLE(10,2) NULL,
  `genre_id` INT NULL,
  `category_id` INT NULL,
  `rating` DOUBLE(10,2) NULL,
  `notes` TEXT(200) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_movies_directors_idx` (`director_id` ASC) VISIBLE,
  INDEX `fk_movies_genres_idx` (`genre_id` ASC) VISIBLE,
  INDEX `fk_movies_categories_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies_directors`
    FOREIGN KEY (`director_id`)
    REFERENCES `directors` (`id`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  CONSTRAINT `fk_movies_genres`
    FOREIGN KEY (`genre_id`)
    REFERENCES `genres` (`id`)
	ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  CONSTRAINT `fk_movies_categories`
    FOREIGN KEY (`category_id`)
    REFERENCES `categories` (`id`)
	ON UPDATE NO ACTION
    ON DELETE NO ACTION
    );
    
INSERT INTO `directors`
(`id`, `director_name`, `notes`)
VALUES
(1,'Gencho','Toi obojava banichki s boza'),
(2,'Ivan','vankata brat'),
(3,'Stamat', 'Obiknoven programist'),
(4,'Pesho','The real OG'),
(5,'Tina','tina ot angliq');

INSERT INTO `genres`
(`id`, `genre_name`, `notes`)
VALUES
(1,'Action','Jackie Chan shit'),
(2,'Comedy','yes'),
(3,'Documentaries','National Geographic shit'),
(4,'Kids','Tom & Jerry mfka'),
(5,'Music','nqkakvi se kulchotqt');

INSERT INTO `categories`
(`id`, `category_name`, `notes`)
VALUES
(1,'Test', 'this is a test category'),
(2,'Paid', 'for paid channels'),
(3,'Free','non paid'),
(4,'Sport', 'for football fans'),
(5,'Yes','only use when no');

INSERT INTO `movies`
(`id`,`title`,`director_id`,`copyright_year`,`length`,`genre_id`,`category_id`,`rating`,`notes`)
VALUES
(1,'Real men die angry',1,1995,343,1,1,8.5,'This is a real story about real men'),
(2,'Real women die happy',2,1996,158,2,2,7.6,'This is a fake story as nobody is happy'),
(3,'Real Gs die young',3,1996,125,3,3,10,'Documentary on Tupacs life'),
(4,'Real dogs dont die',4,2012,210,4,4,9.7,'Dogs never die, they only make others happy'),
(5,'Corona Infection',5,2020,165,5,5,2.5,'true story');