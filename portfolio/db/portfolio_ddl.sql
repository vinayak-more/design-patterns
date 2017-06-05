CREATE USER 'portfolio'@'localhost' IDENTIFIED BY 'portfolio';

GRANT CREATE,DELETE,INSERT,SELECT,UPDATE ON portfolio.* TO 'portfolio'@'localhost';

CREATE TABLE user (
	user_id bigint(20) PRIMARY KEY AUTO_INCREMENT,
	username varchar(255) NOT NULL,
	password varchar(50) NOT NULL,
	INDEX username (`username`)
);

CREATE TABLE user_basic_details(
	rid bigint(20) PRIMARY KEY AUTO_INCREMENT,
	user_id bigint(20),
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	CONSTRAINT fk_user FOREIGN KEY (user_id)
  	REFERENCES user(user_id)
  	ON DELETE CASCADE
  	ON UPDATE CASCADE 
);

CREATE TABLE user_transaction(
	rid bigint(20) PRIMARY KEY AUTO_INCREMENT,
	user_id bigint(20),
	transaction_date timestamp,
	type varchar(10) NOT NULL,
	market varchar(10) NOT NULL,
	symbol varchar(20) NOT NULL,
	quantity int(10) NOT NULL,
	price_per_stock double(10,5),
	price_in_total double(15,5),
	create_datetime timestamp DEFAULT CURRENT_TIMESTAMP;
	last_mod_datetime timestamp DEFAULT CURRENT_TIMESTAMP;
	CONSTRAINT fk_user_transc FOREIGN KEY (user_id)
  	REFERENCES user(user_id)
  	ON DELETE CASCADE
  	ON UPDATE CASCADE 
);

CREATE TABLE user_folio(
	rid bigint(20) PRIMARY KEY AUTO_INCREMENT,
	user_id bigint(20),
	symbol varchar(20) NOT NULL,
	quantity int(10) NOT NULL,
	investment double(20,5),
	current_value double(20,5),
	change_value double(20,5),
	change_percent double(20,5),
	todays_gain double(20,5),
	last_updated timestamp,
	CONSTRAINT fk_user_folio FOREIGN KEY (user_id)
  	REFERENCES user(user_id)
  	ON DELETE CASCADE
  	ON UPDATE CASCADE 
);

alter table user_basic_details add column mobile varchar(20) default null ;