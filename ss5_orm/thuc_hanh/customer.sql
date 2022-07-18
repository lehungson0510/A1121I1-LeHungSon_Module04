create database customer;
drop database customer;

DELIMITER //
CREATE PROCEDURE Insert_Customer(IN address_in VARCHAR(255), IN email_in VARCHAR(255), name_in varchar(255))
BEGIN
    INSERT INTO customer(address,email,`name`) VALUES (address_in,email_in,name_in);
END//
DELIMITER ;