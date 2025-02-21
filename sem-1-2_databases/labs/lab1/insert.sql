INSERT INTO person(person_name, person_gender, medical_id) VALUES 
	('Алекс', 'мужской', '12345'),
	('Майк', 'мужской', '54321'),
	('Дроджия', 'женский', '89654');
INSERT INTO medical_data VALUES 
	('12345', 'здоров', '120/79'),
	('54321', 'травмирован', '121/80'),
	('89654', 'мёртв', '135/80');
INSERT INTO person_locations VALUES
	('1', 'вакуум'),
	('2', 'нормальное'),
	('3', 'нормальное');
INSERT INTO session_in_vacuum(person_id, reason, session_date, session_interval) VALUES
	('1', 'эксперимент', '2025-02-21', '54 seconds'),
	('2', 'несчастный случай', '1999-01-23', '4 minutes 56 seconds'),
	('3', 'убийство', '2003-04-12', '3 hours 12 minutes 14 seconds');
INSERT INTO outcome VALUES 
	('1', 'здоров', TRUE, NULL, 'рекомпрессия'),
	('2', 'травмирован', TRUE, 'удалось спасти, но остался частично парализованным из-за воздушной эмболии', null),
	('3', 'мёртв', FALSE, 'летальный исход', NULL);
