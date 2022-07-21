create database product;
create database ss7;

use customer;

DELIMITER //
CREATE PROCEDURE Insert_Customer(IN name_in VARCHAR(255), IN email_in VARCHAR(255), IN address_in varchar(255))
BEGIN
    INSERT INTO customer(`name`, email, address) VALUES (name_in,email_in,address_in);
END;
// DELIMITER ;