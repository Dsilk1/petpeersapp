CREATE TABLE CUSTOMER(
CUSTOMER_ID INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(55) NOT NULL,
PHNUMER VARCHAR(55) NOT NULL,
MAILID VARCHAR(55) NOT NULL,
STATUS VARCHAR(55) NOT NULL);



CREATE TABLE  LEDGER(
CUSTOMER_ID INT(5) NOT NULL,
BALANCE DOUBLE,
MODIFEDAT DATETIME 
);

CREATE TABLE TRANSACTION(
transaction_id INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
CUSTOMER_ID INT(5) NOT NULL,
DESCRIPTION VARCHAR(55) NOT NULL,
AMOUNT DOUBLE,
CURRENTBALANCE DOUBLE,
PAYMENTTYPE VARCHAR(55) NOT NULL,
TRANSACTION_DATE DATETIME 
);