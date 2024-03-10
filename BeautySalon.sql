CREATE SCHEMA BeautySalon;

CREATE TABLE customer(
CustomerPhoneNumber INT (10) NOT NULL,
CustomerName VARCHAR (100),
Service VARCHAR (100),
stylist VARCHAR (100),
timeDate VARCHAR (100),
CONSTRAINT phoneNum_PK PRIMARY KEY (CustomerPhoneNumber)
);

DELETE FROM customer;