--Adverse Reactions
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(400, 'mild', 'xerostomia');
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(401, 'mild', 'dysgeusia');
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(402, 'severe', 'bronchospasm');
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(403, 'moderate', 'dysphagia');
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(404, 'mild', 'gastroesophageal reflux');
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(405, 'moderate', 'esophagitis');
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(406, 'severe', 'tardive dyskinesia');
INSERT INTO adverse_reactions (reaction_id, severity, reaction) VALUES(407, 'severe', 'laryngospasm');

--AR Meds
INSERT INTO ar_meds (ar_meds_id, reaction_id, med_id) VALUES();

--Generics
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(300, 200, 'haloperidol');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(301, 201, 'bismuth subcitrate potassium');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(302, 201, 'metronidazole');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(303, 201, 'tetracycline hydrochloride');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(304, 202, 'alendronate sodium');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(305, 203, 'gabapentin');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(306, 204, 'baclofen');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(307, 205, 'oxybutynin chloride');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(308, 206, 'warfarin sodium');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(308, 207, 'citalopram hydrobromide');
INSERT INTO generics (generic_id, med_id, generic_name) VALUES(308, 208, 'pantoprazole sodium');

--Medications
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(200, 'Haldol', true);
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(201, 'Pylera', true);
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(202, 'Fosamax', true);
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(203, 'Neurontin', true);
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(204, 'Gablofen', true);
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(205, 'Ditropan XL', true);
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(206, 'Coumadin', false);
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(207, 'Celexa', false);
INSERT INTO medications (med_id, brand_name, has_reaction) VALUES(208, 'Protonix', false);

--Users
INSERT INTO users (user_id, pseudo_id, pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('ClaireRF', 50, '01/01/21', '02/02/21', 'I69.391', 'R13.12');
INSERT INTO users (user_id, pseudo_id, pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('JamesMF', 47, '03/03/21', '04/04/21', 'G20', 'R13.12');
INSERT INTO users (user_id, pseudo_id, pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('BriannaFW', 31, '05/05/21', '06/06/21', 'G31.83', 'R13.11');
INSERT INTO users (user_id, pseudo_id, pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd) VALUES('Roger@', 39, '07/07/21', '08/08/21', 'K20.0', 'R13.14');

--User Meds
INSERT INTO user_meds (user_med_id, med_id, user_id);
