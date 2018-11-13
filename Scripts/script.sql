use apiary;
/
CREATE TABLE transaction(
 id INT AUTO_INCREMENT primary key NOT NULL,
 description VARCHAR(1000),
 quantity DECIMAL(15,2),
 price DECIMAL(15,2),
 transaction_type INT,
 transaction_date DATETIME
)
/
CREATE TABLE transaction_type (
 id INT AUTO_INCREMENT primary key NOT NULL,
 name VARCHAR(100) not null,
 symbol CHAR(1) not null
)
/
CREATE TABLE hive (
 id INT AUTO_INCREMENT primary key NOT NULL,
 identifier VARCHAR(100) not null,
 material VARCHAR(200),
 purchase_year YEAR,
 hive_type VARCHAR(100),
 description VARCHAR(100) 
)
/
CREATE TABLE family (
 id INT AUTO_INCREMENT primary key NOT NULL,
 race VARCHAR(100),
 queen_origin VARCHAR(100),
 queen_birth_year YEAR,
 hive_id INT,
 FOREIGN KEY (hive_id)
	REFERENCES hive(id)
)
/
CREATE TABLE inspection (
 id INT AUTO_INCREMENT primary key NOT NULL,
 inspection_date DATETIME,
 open_brood BOOLEAN,
 closed_brood BOOLEAN,
 queen_present BOOLEAN,
 number_of_frames INT,
 number_of_brood_frames INT,
 is_swarm_mood BOOLEAN,
 temperature DECIMAL (5,2),	
 notes VARCHAR(2000),
 hive_id INT, 
 FOREIGN KEY (hive_id)
	REFERENCES hive(id),
 status CHAR(1)
)
/

