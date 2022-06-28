USE medication_db;
DROP TABLE IF EXISTS ar_meds;
DROP TABLE IF EXISTS generics;
DROP TABLE IF EXISTS user_meds;
DROP TABLE IF EXISTS medications;
DROP TABLE IF EXISTS adverse_reactions;
DROP TABLE IF EXISTS users;

CREATE TABLE adverse_reactions (
	reaction_id int NOT NULL AUTO_INCREMENT,
	severity varchar(40) NOT NULL,
	reaction varchar(40) NOT NULL,
	PRIMARY KEY (reaction_id)
);

CREATE TABLE medications (
	med_id int NOT NULL AUTO_INCREMENT,
	brand_name varchar(40) NOT NULL,
	has_reaction boolean,
	PRIMARY KEY (med_id)
);

CREATE TABLE users (
	user_id int NOT NULL AUTO_INCREMENT,
	pseudo_name varchar(40) NOT NULL,
	age int NOT NULL,
	date_of_eval date NOT NULL,
	date_of_discharge date NOT NULL,
	med_dx_icd varchar(40) NOT NULL,
	tx_dx_icd varchar(40) NOT NULL,
	PRIMARY KEY (user_id)
);

CREATE TABLE ar_meds (
	ar_meds_id int NOT NULL AUTO_INCREMENT,
	reaction_id int NOT NULL,
	med_id int NOT NULL,
	PRIMARY KEY (ar_meds_id),
	FOREIGN KEY (reaction_id) REFERENCES adverse_reactions (reaction_id)
);

CREATE TABLE user_meds (
	user_med_id int NOT NULL AUTO_INCREMENT,
	med_id int NOT NULL,
	user_id int NOT NULL,
	PRIMARY KEY (user_med_id),
	FOREIGN KEY (med_id) REFERENCES medications (med_id),
	FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE generics (
	generic_id int NOT NULL AUTO_INCREMENT,
	med_id int NOT NULL,
	generic_name varchar(40),
	PRIMARY KEY (generic_id),
	FOREIGN KEY (med_id) REFERENCES medications (med_id)
);