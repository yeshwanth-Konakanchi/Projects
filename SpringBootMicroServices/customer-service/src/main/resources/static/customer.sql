CREATE TABLE `javabot`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `date_of_birth` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address_ln1` VARCHAR(45) NULL,
  `address_ln2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zip` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_id`));
