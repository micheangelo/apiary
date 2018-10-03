use apiary;

CREATE TABLE transaction(
 id INT AUTO_INCREMENT primary key NOT NULL,
 description varchar(1000),
 quantity decimal(15,2),
 price decimal(15,2),
 transactionType char(1),
 transactionDate datetime
);