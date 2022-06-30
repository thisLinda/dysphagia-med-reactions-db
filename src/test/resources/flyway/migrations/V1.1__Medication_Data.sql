--Mild
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'xerostomia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'dysgeusia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'gastroesophageal reflux');

--Moderate
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'dysphagia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'esophagitis');

--Severe
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'bronchospasm');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'tardive dyskinesia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'laryngospasm');

--AR Meds
INSERT INTO ar_meds (reaction_id, med_id) VALUES();

--Generics
INSERT INTO generics (generic_name) VALUES('haloperidol');
INSERT INTO generics (generic_name) VALUES('bismuth subcitrate potassium');
INSERT INTO generics (generic_name) VALUES('metronidazole');
INSERT INTO generics (generic_name) VALUES('tetracycline hydrochloride');
INSERT INTO generics (generic_name) VALUES('alendronate sodium');
INSERT INTO generics (generic_name) VALUES('gabapentin');
INSERT INTO generics (generic_name) VALUES('baclofen');
INSERT INTO generics (generic_name) VALUES('oxybutynin chloride');
INSERT INTO generics (generic_name) VALUES('warfarin sodium');
INSERT INTO generics (generic_name) VALUES('citalopram hydrobromide');
INSERT INTO generics (generic_name) VALUES('pantoprazole sodium');

--Medications
INSERT INTO medications (brand_name, has_reaction) VALUES('Haldol', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Pylera', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Fosamax', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Neurontin', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Gablofen', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Ditropan XL', true);
INSERT INTO medications (brand_name, has_reaction) VALUES('Coumadin', false);
INSERT INTO medications (brand_name, has_reaction) VALUES('Celexa', false);
INSERT INTO medications (brand_name, has_reaction) VALUES('Protonix', false);

--Users
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('ClaireRF', 50, '01/01/21', '02/02/21', 'I69.391', 'R13.12');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('JamesMF', 47, '03/03/21', '04/04/21', 'G20', 'R13.12');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('BriannaFW', 31, '05/05/21', '06/06/21', 'G31.83', 'R13.11');
INSERT INTO users (pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('Roger@', 39, '07/07/21', '08/08/21', 'K20.0', 'R13.14');

--User Meds
INSERT INTO user_meds (med_id, user_id);
