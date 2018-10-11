use apiary;
/
CREATE TABLE transaction(
 id INT AUTO_INCREMENT primary key NOT NULL,
 description VARCHAR(1000),
 quantity DECIMAL(15,2),
 price DECIMAL(15,2),
 transactionType CHAR(1),
 transactionDate DATETIME
)
/
CREATE TABLE transaction_types (
 id INT AUTO_INCREMENT primary key NOT NULL,
 name VARCHAR(100) not null,
 symbol CHAR(1) not null
)
/
CREATE TABLE hive (
 id INT AUTO_INCREMENT primary key NOT NULL,
 identifier VARCHAR(100) not null,
 material VARCHAR(200),
 purchaseYear YEAR,
 hiveType VARCHAR(100),
 description VARCHAR(100) 
)
/
CREATE TABLE family (
 id INT AUTO_INCREMENT primary key NOT NULL,
 race VARCHAR(100),
 queenOrigin VARCHAR(100),
 queenBirthYear YEAR,
 hiveId INT,
 FOREIGN KEY (hiveId)
	REFERENCES hive(id)
)
/