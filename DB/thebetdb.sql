-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema thebetdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `thebetdb` ;

-- -----------------------------------------------------
-- Schema thebetdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `thebetdb` DEFAULT CHARACTER SET utf8 ;
USE `thebetdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(45) NULL,
  `enabled` TINYINT(4) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bet` ;

CREATE TABLE IF NOT EXISTS `bet` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `wager_date` DATE NULL,
  `deadline_date` DATE NULL,
  `wager` VARCHAR(1000) NULL,
  `completed` TINYINT(2) NULL,
  `bettor_id` INT NOT NULL,
  `bettee_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bet_user_idx` (`bettor_id` ASC),
  INDEX `fk_bet_user1_idx` (`bettee_id` ASC),
  CONSTRAINT `fk_bet_user`
    FOREIGN KEY (`bettor_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bet_user1`
    FOREIGN KEY (`bettee_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS thebetuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'thebetuser'@'localhost' IDENTIFIED BY 'thebetuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'thebetuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `thebetdb`;
INSERT INTO `user` (`id`, `name`, `username`, `password`, `email`, `enabled`, `role`) VALUES (1, 'Will Slaunwhite', 'willslaunwhite', 'will', NULL, NULL, 'admin');
INSERT INTO `user` (`id`, `name`, `username`, `password`, `email`, `enabled`, `role`) VALUES (2, 'Tyler Posey', 'tylerposey', 'tyler', NULL, NULL, 'user');
INSERT INTO `user` (`id`, `name`, `username`, `password`, `email`, `enabled`, `role`) VALUES (DEFAULT, 'Eric Sheeder', 'ericsheeder', 'eric', NULL, NULL, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bet`
-- -----------------------------------------------------
START TRANSACTION;
USE `thebetdb`;
INSERT INTO `bet` (`id`, `name`, `wager_date`, `deadline_date`, `wager`, `completed`, `bettor_id`, `bettee_id`) VALUES (DEFAULT, 'Fast Food Bet', '2021-06-01', '2021-07-01', 'See who can go the longest without ordering fast food. Whoever loses owes the other $100', 0, 3, 1);

COMMIT;

