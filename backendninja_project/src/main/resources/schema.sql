CREATE TABLE contact (
	id INT NOT NULL AUTO_INCREMENT,
	firstname VARCHAR(150) NULL,
	lastname VARCHAR(150) NULL,
	telephone VARCHAR(15) NULL,
	city VARCHAR( 80 ) NULL,
	PRIMARY KEY (id)
);


CREATE TABLE user (
	username VARCHAR(45) NOT NULL ,
	password VARCHAR(60) NOT NULL,
	enabled BOOLEAN NOT NULL,
	PRIMARY KEY (username)
);


CREATE TABLE user_role (
	userroleid INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(45) NOT NULL,
	role VARCHAR(45) NOT NULL,
	PRIMARY KEY (userroleid)
);