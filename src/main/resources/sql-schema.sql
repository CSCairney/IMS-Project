drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers`(
`customer_id` INT PRIMARY KEY AUTO_INCREMENT,
`customer_firstname` VARCHAR(40) NOT NULL,
`customer_surname` VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS `ims`.`items`(
`item_id` INT PRIMARY KEY AUTO_INCREMENT,
`item_name` VARCHAR(20) NOT NULL,
`item_price` DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS `ims`.`orders`(
`order_id` INT PRIMARY KEY AUTO_INCREMENT,
`fk_customer_id` INT NOT NULL,
FOREIGN KEY (`fk_customer_id`) REFERENCES `customers`(`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items`(
`orderitem_id` INT PRIMARY KEY AUTO_INCREMENT,
`fk_order_id` INT NOT NULL,
`fk_item_id` INT NOT NULL,
`order_cost` INT NOT NULL,
FOREIGN KEY (`fk_order_id`) REFERENCES `orders`(`order_id`),
FOREIGN KEY (`fk_item_id`) REFERENCES `items`(`item_id`)
);