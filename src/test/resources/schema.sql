USE medication_db;

DROP TABLE IF EXISTS generics;
DROP TABLE IF EXISTS user_meds_list;
DROP TABLE IF EXISTS med_adverse_reactions;
DROP TABLE IF EXISTS adverse_reactions;
DROP TABLE IF EXISTS medications;
DROP TABLE IF EXISTS users;

CREATE TABLE adverse_reactions (
	reaction_pk int NOT NULL AUTO_INCREMENT,
	severity enum('SEVERE', 'MODERATE', 'MILD') NOT NULL,
	reaction varchar(40) NOT NULL,
	PRIMARY KEY (reaction_pk)
);

CREATE TABLE medications (
	med_pk int NOT NULL AUTO_INCREMENT,
	brand_name varchar(40) NOT NULL,
	has_reaction boolean,
	PRIMARY KEY (med_pk)
);

CREATE TABLE users (
	user_pk int NOT NULL AUTO_INCREMENT,
	pseudo_name varchar(40) NOT NULL,
	age int NOT NULL,
	date_of_eval varchar(40) NOT NULL,
	date_of_discharge varchar(40),
	med_dx_icd varchar(40) NOT NULL,
	tx_dx_icd varchar(40) NOT NULL,
	PRIMARY KEY (user_pk)
);

CREATE TABLE med_adverse_reactions (
	med_adverse_reaction_pk int NOT NULL AUTO_INCREMENT,
	med_fk int NOT NULL,
	reaction_fk int NOT NULL,
	PRIMARY KEY (med_adverse_reaction_pk),
	FOREIGN KEY (med_fk) REFERENCES medications (med_pk) ON DELETE CASCADE,
	FOREIGN KEY (reaction_fk) REFERENCES adverse_reactions (reaction_pk) ON DELETE CASCADE
);

CREATE TABLE user_meds_list (
	user_meds_list_pk int NOT NULL AUTO_INCREMENT,
	med_fk int NOT NULL,
	user_fk int NOT NULL,
	PRIMARY KEY (user_meds_list_pk),
	FOREIGN KEY (user_fk) REFERENCES users (user_pk),
	FOREIGN KEY (med_fk) REFERENCES medications (med_pk)
);

CREATE TABLE generics (
	generic_pk int NOT NULL AUTO_INCREMENT,
	med_fk int NOT NULL,
	generic_name varchar(40),
	PRIMARY KEY (generic_pk),
	FOREIGN KEY (med_fk) REFERENCES medications (med_pk)
);