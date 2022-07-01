-- Mild
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'dysgeusia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'gastroesophageal reflux');
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'xerostomia');

-- Moderate
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'dysphagia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'esophagitis');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'glossitis');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'oral ulceration');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'pneumonitis');

-- Severe
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'bronchospasm');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'esophageal stricture');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'esophageal stricture');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'esophageal ulceration');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'laryngospasm');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'tardive dyskinesia');

-- Medications
INSERT INTO medications (brand_name, has_reaction) VALUES('Haldol', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Pylera', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Fosamax', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Neurontin', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Gablofen', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Ditropan XL', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Coumadin', false);
INSERT INTO medications (brand_name, has_reaction) VALUES('Celexa', false);
INSERT INTO medications (brand_name, has_reaction) VALUES('Protonix', false);

-- Generics
INSERT INTO generics (generic_name, med_fk) VALUES('haloperidol', 1);
INSERT INTO generics (generic_name, med_fk) VALUES('bismuth subcitrate potassium', 2);
INSERT INTO generics (generic_name, med_fk) VALUES('alendronate sodium', 3);
INSERT INTO generics (generic_name, med_fk) VALUES('gabapentin', 4);
INSERT INTO generics (generic_name, med_fk) VALUES('baclofen', 5);
INSERT INTO generics (generic_name, med_fk) VALUES('oxybutynin chloride', 7);
INSERT INTO generics (generic_name, med_fk) VALUES('warfarin sodium', 9);
INSERT INTO generics (generic_name, med_fk) VALUES('citalopram hydrobromide', 8);
INSERT INTO generics (generic_name, med_fk) VALUES('pantoprazole sodium', 9);

-- AR Meds
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES(1,1);
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES(2,2);
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES(3,3);
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES(4,4);
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES(5,5);
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES(6,6);

-- Users
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('ClaireRF', 50, '01/01/21', '02/02/21', 'I69.391', 'R13.12');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('JamesMF', 47, '03/03/21', '04/04/21', 'G20', 'R13.12');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('BriannaFW', 31, '05/05/21', '06/06/21', 'G31.83', 'R13.11');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('Roger@', 39, '07/07/21', '08/08/21', 'K20.0', 'R13.14');

-- User Meds
INSERT INTO user_meds (med_fk, user_fk) VALUES(1,1);
INSERT INTO user_meds (med_fk, user_fk) VALUES(2,2);
INSERT INTO user_meds (med_fk, user_fk) VALUES(3,3);
INSERT INTO user_meds (med_fk, user_fk) VALUES(4,4);