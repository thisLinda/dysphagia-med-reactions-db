--Mild
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'xerostomia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'dysgeusia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('mild', 'gastroesophageal reflux');

--Moderate
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'dysphagia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'esophagitis');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'oral ulceration');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'glossitis');
INSERT INTO adverse_reactions (severity, reaction) VALUES('moderate', 'pneumonitis');

--Severe
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'bronchospasm');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'tardive dyskinesia');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'laryngospasm');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'laryngeal edema');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'esophageal ulceration');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'esophageal stricture');
INSERT INTO adverse_reactions (severity, reaction) VALUES('severe', 'esophageal stricture');

--AR Meds
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'bronchospasm'), (SELECT med_fk FROM medications WHERE brand_name = 'Haldol'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'bronchospasm'), (SELECT med_fk FROM medications WHERE brand_name = 'Gablofen'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'bronchospasm'), (SELECT med_fk FROM medications WHERE brand_name = 'Ditropan XL'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'bronchospasm'), (SELECT med_fk FROM medications WHERE brand_name = 'Celexa'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysgeusia'), (SELECT med_fk FROM medications WHERE brand_name = 'Pylera'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysgeusia'), (SELECT med_fk FROM medications WHERE brand_name = 'Fosamax'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysgeusia'), (SELECT med_fk FROM medications WHERE brand_name = 'Ditropan XL'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysgeusia'), (SELECT med_fk FROM medications WHERE brand_name = 'Celexa'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysgeusia'), (SELECT med_fk FROM medications WHERE brand_name = 'Protonix'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysphagia'), (SELECT med_fk FROM medications WHERE brand_name = 'Haldol'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysphagia'), (SELECT med_fk FROM medications WHERE brand_name = 'Pylera'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysphagia'), (SELECT med_fk FROM medications WHERE brand_name = 'Fosamax'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'dysphagia'), (SELECT med_fk FROM medications WHERE brand_name = 'Ditropan XL'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'esophageal stricture'), (SELECT med_fk FROM medications WHERE brand_name = 'Fosamax'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'esophageal ulceration'), (SELECT med_fk FROM medications WHERE brand_name = 'Pylera'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'esophageal ulceration'), (SELECT med_fk FROM medications WHERE brand_name = 'Fosamax'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'esophagitis'), (SELECT med_fk FROM medications WHERE brand_name = 'Pylera'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'esophagitis'), (SELECT med_fk FROM medications WHERE brand_name = 'Fosamax'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'esophagitis'), (SELECT med_fk FROM medications WHERE brand_name = 'Celexa'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'gastroesophageal reflux'), (SELECT med_fk FROM medications WHERE brand_name = 'Fosamax'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'gastroesophageal reflux'), (SELECT med_fk FROM medications WHERE brand_name = 'Ditropan XL'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'gastroesophageal reflux'), (SELECT med_fk FROM medications WHERE brand_name = 'Celexa'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'glossitis'), (SELECT med_fk FROM medications WHERE brand_name = 'Pylera'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'glossitis'), (SELECT med_fk FROM medications WHERE brand_name = 'Celexa'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'laryngeal edema'), (SELECT med_fk FROM medications WHERE brand_name = 'Haldol'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'laryngospasm'), (SELECT med_fk FROM medications WHERE brand_name = 'Haldol'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'pneumonitis'), (SELECT med_fk FROM medications WHERE brand_name = 'Celexa'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'tardive dyskinesia'), (SELECT med_fk FROM medications WHERE brand_name = 'Haldol'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'xerostomia'), (SELECT med_fk FROM medications WHERE brand_name = 'Haldol'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'xerostomia'), (SELECT med_fk FROM medications WHERE brand_name = 'Pylera'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'xerostomia'), (SELECT med_fk FROM medications WHERE brand_name = 'Neurontin'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'xerostomia'), (SELECT med_fk FROM medications WHERE brand_name = 'Gablofen'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'xerostomia'), (SELECT med_fk FROM medications WHERE brand_name = 'Ditropan'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'xerostomia'), (SELECT med_fk FROM medications WHERE brand_name = 'Celexa'));
INSERT INTO ar_meds (reaction_fk, med_fk) VALUES((SELECT reaction_pk FROM adverse_reactions WHERE reaction = 'xerostomia'), (SELECT med_fk FROM medications WHERE brand_name = 'Protonix'));

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
INSERT INTO user_meds (med_fk, user_fk);