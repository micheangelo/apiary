use apiary;

CREATE TABLE cost(
 id INT AUTO_INCREMENT primary key NOT NULL,
 description varchar(1000),
 amount int,
 price decimal(15,2)
);