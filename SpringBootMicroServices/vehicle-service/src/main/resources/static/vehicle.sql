CREATE TABLE `javabot`.`vehicle` (
  `vehicle_id` VARCHAR(25) NOT NULL,
  `vin` VARCHAR(45) NULL,
  `year` VARCHAR(45) NULL,
  `make` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  PRIMARY KEY (`vehicle_id`));