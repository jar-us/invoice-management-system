CREATE TABLE `invoice` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `invoice_number` VARCHAR(20),
  `invoiced_date` DATE,
  `invoiced_time` VARCHAR(20),
  `due_date` DATE,
  `enable_auto_alerts` BOOLEAN DEFAULT 'disable',
  `total_amount` DECIMAL,
  `merchant_id` INT(10),
  `invoice_state_id` INT(10),
  `payment_mode_id` INT(10),
  `customer_id` INT(10),
`shipping_address_id` INT(10)
);

CREATE TABLE `invoice_item` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `invoice_id` INT(10),
  `item_id` INT(10)
);

CREATE TABLE `item` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20),
  `description` VARCHAR(20),
  `price` DECIMAL
);

CREATE TABLE `shipping_address` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `customer` INT(10)
);


CREATE TABLE `customer` (
  `id` INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `first_name` VARCHAR(20),
  `last_name` VARCHAR(20),
  `street` VARCHAR(20),
  `city_id` INT(10),
  `state_id` INT(10),
  `country_id` INT(10)
);

CREATE TABLE `shop` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20),
  `street` VARCHAR(20),
  `merchant_id` INT(10),
  `city_id` INT(10),
  `state_id` INT(10),
  `country_id` INT(10)
);

CREATE TABLE `invoice_state` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `state` VARCHAR(20)
);

CREATE TABLE `merchant` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `first_name` VARCHAR(20),
  `last_name` VARCHAR(20)
);

CREATE TABLE `tax` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20),
  `percent` DECIMAL
);

CREATE TABLE `invoice_tax` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `invoice_id` INT(10),
  `tax_id` INT(10)
);


CREATE TABLE `invoice_discount` (
    `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
    `invoice_id` INT(10),
    `discount_id` INT(10)
);

CREATE TABLE `discount` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20),
  `percent` DECIMAL
);

CREATE TABLE `country` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20)
);

CREATE TABLE `state` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20)
);

CREATE TABLE `city` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20)
);

CREATE TABLE `email` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `email_address` VARCHAR(20),
  `merchant_id` INT(10),
  `customer_id` INT(10)
);

CREATE TABLE `phone` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `phone_number` VARCHAR(20),
  `merchant_id` INT(10),
  `customer_id` INT(10)
);

CREATE TABLE `invoice_payment_mode` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `invoice_id` INT(10),
  `payment_mode_id` INT(10)
);

CREATE TABLE `payment_mode` (
  `id` INT(10) PRIMARY KEY AUTO_INCREMENT,
  `mode` VARCHAR(20)
);


-- add FOREIGN KEY --

ALTER TABLE customer ADD CONSTRAINT fk_customer_state FOREIGN KEY(state_id) REFERENCES state(id);
ALTER TABLE customer ADD CONSTRAINT fk_customer_city FOREIGN KEY(city_id) REFERENCES city(id);
ALTER TABLE customer ADD CONSTRAINT fk_customer_country FOREIGN KEY(country_id) REFERENCES country(id);

ALTER TABLE email ADD CONSTRAINT fk_email_customer FOREIGN KEY(customer_id) REFERENCES customer(id);
ALTER TABLE email ADD CONSTRAINT fk_email_merchant FOREIGN KEY(merchant_id) REFERENCES merchant(id);

ALTER TABLE phone ADD CONSTRAINT fk_phone_customer FOREIGN KEY(customer_id) REFERENCES customer(id);
ALTER TABLE phone ADD CONSTRAINT fk_phone_merchant FOREIGN KEY(merchant_id) REFERENCES merchant(id);

ALTER TABLE shop ADD CONSTRAINT fk_shop_city FOREIGN KEY(city_id) REFERENCES city(id);
ALTER TABLE shop ADD CONSTRAINT fk_shop_state FOREIGN KEY(state_id) REFERENCES state(id);
ALTER TABLE shop ADD CONSTRAINT fk_shop_country FOREIGN KEY(country_id) REFERENCES country(id);
ALTER TABLE shop ADD CONSTRAINT fk_shop_merchant FOREIGN KEY(merchant_id) REFERENCES merchant(id);

ALTER TABLE invoice_payment_mode ADD CONSTRAINT fk_invoice_payment_mode_payment_mode FOREIGN KEY(payment_mode_id) REFERENCES payment_mode(id);
ALTER TABLE invoice_payment_mode ADD CONSTRAINT fk_invoice_payment_mode_invoice FOREIGN KEY(invoice_id) REFERENCES invoice(id);

ALTER TABLE invoice_item ADD CONSTRAINT fk_invoice_item_item FOREIGN KEY(item_id) REFERENCES item(id);
ALTER TABLE invoice_item ADD CONSTRAINT fk_invoice_item_invoice FOREIGN KEY(invoice_id) REFERENCES invoice(id);

ALTER TABLE invoice_tax ADD CONSTRAINT fk_invoice_tax_tax FOREIGN KEY(tax_id) REFERENCES tax(id);
ALTER TABLE invoice_tax ADD CONSTRAINT fk_invoice_tax_invoice FOREIGN KEY(invoice_id) REFERENCES invoice(id);

ALTER TABLE invoice_discount ADD CONSTRAINT fk_invoice_discount_discount FOREIGN KEY(discount_id) REFERENCES discount(id);
ALTER TABLE invoice_discount ADD CONSTRAINT fk_invoice_discount_invoice FOREIGN KEY(invoice_id) REFERENCES invoice(id);

ALTER TABLE invoice ADD CONSTRAINT fk_invoice_merchant FOREIGN KEY(merchant_id) REFERENCES merchant(id);
ALTER TABLE invoice ADD CONSTRAINT fk_invoice_invoice_state FOREIGN KEY(invoice_state_id) REFERENCES invoice_state(id);
ALTER TABLE invoice ADD CONSTRAINT fk_invoice_customer FOREIGN KEY(customer_id) REFERENCES customer(id);
ALTER TABLE invoice ADD CONSTRAINT fk_invoice_shipping_address FOREIGN KEY(shipping_address_id) REFERENCES shipping_address(id);

-- add data


