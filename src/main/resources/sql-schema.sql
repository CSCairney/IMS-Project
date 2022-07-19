CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims`;

DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `order_items`;

CREATE TABLE IF NOT EXISTS `ims`.`customer` (
	`customer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `customer_firstname` VARCHAR (20) NOT NULL,
    `customer_surname` VARCHAR (20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id` INT PRIMARY KEY AUTO_INCREMENT,
    `item_name` VARCHAR (100) NOT NULL,
    `item_price` DOUBLE NOT NULL
    );

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`order_id` INT PRIMARY KEY AUTO_INCREMENT,
    `fk_customer_id` INT NOT NULL,
    FOREIGN KEY (`fk_customer_id`) REFERENCES `customer`(`customer_id`) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
	`orderitem_id` INT PRIMARY KEY AUTO_INCREMENT,
    `fk_order_id` INT NOT NULL,
    `fk_item_id` INT NOT NULL,
    FOREIGN KEY (`fk_order_id`) REFERENCES `orders`(`order_id`) ON DELETE CASCADE,
    FOREIGN KEY (`fk_item_id`) REFERENCES `items`(`item_id`) ON DELETE CASCADE
    );
