CREATE TABLE `invoice` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`invoice_number` VARCHAR(10),
	`invoiced_date` DATE,
	`invoiced_time` TIME,
	`due_date` DATE,
	`enable_auto_alerts` BOOLEAN DEFAULT 'disable',
	PRIMARY KEY (`id`)
);

CREATE TABLE `merchant` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(10),
	`last_name` VARCHAR(10),
	PRIMARY KEY (`id`)
);

CREATE TABLE `customer` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(10),
	`last_name` VARCHAR(10),
	PRIMARY KEY (`id`)
);

CREATE TABLE `discount` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(10),
	`percent` DECIMAL(10) DEFAULT '0.0'
);

CREATE TABLE `tax` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(10),
	`percent` DECIMAL(10) DEFAULT '0.0'
);

CREATE TABLE `shop` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(10)
);

CREATE TABLE `item` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(10),
	`description` VARCHAR(50),
	`price` DECIMAL(10)
);
