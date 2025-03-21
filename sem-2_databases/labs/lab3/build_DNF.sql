BEGIN;

CREATE TYPE gender AS ENUM ('мужской', 'женский');
CREATE TYPE locations AS ENUM ('вакуум', 'нормальное');
CREATE TYPE health_status AS ENUM ('мёртв', 'ранен', 'травмирован', 'здоров');

CREATE TABLE IF NOT EXISTS person 
(
	person_id SERIAL PRIMARY KEY,
	person_name TEXT NOT NULL,
	person_gender gender NOT NULL,
	person_location locations NOT NULL,
	person_health_status health_status NOT NULL
);

CREATE TABLE IF NOT EXISTS medical_data 
(
	medical_id SERIAL PRIMARY KEY,
	person_id BIGINT UNIQUE REFERENCES person(person_id) ON DELETE CASCADE,
	person_health_status health_status NOT NULL,
	normal_pressure VARCHAR(8) NOT NULL
);

CREATE FUNCTION validate_pressure() 
RETURNS TRIGGER AS $$
BEGIN
	IF NEW.normal_pressure !~* '^[1-9][0-9]{0,3}/[1-9][0-9]{0,2}$' 
	THEN 
		RAISE EXCEPTION 'Неверный формат normal_pressure';
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER check_pressure BEFORE INSERT OR UPDATE ON medical_data
FOR EACH ROW EXECUTE FUNCTION validate_pressure();

CREATE TABLE IF NOT EXISTS session_in_vacuum (
	session_id SERIAL PRIMARY KEY,
	person_id INT NOT NULL REFERENCES person(person_id) ON DELETE CASCADE,
	reason TEXT,
	session_date DATE,
	session_interval INTERVAL	
);

CREATE TABLE IF NOT EXISTS outcome (
	session_id INT NOT NULL UNIQUE REFERENCES session_in_vacuum(session_id) ON DELETE CASCADE,
	person_status health_status NOT NULL,
	is_survived BOOLEAN NOT NULL,
	description TEXT,
	requirements TEXT
);

INSERT INTO person(person_name, person_gender, person_location, person_health_status) VALUES 
	('Алекс', 'мужской', 'вакуум', 'здоров'),
	('Майк', 'мужской', 'нормальное', 'травмирован'),
	('Дроджия', 'женский', 'нормальное', 'мёртв');
INSERT INTO medical_data VALUES 
	('12345', '1', 'здоров', '120/79'),
	('54321', '2', 'травмирован', '121/80'),
	('89654', '3', 'мёртв', '135/80');
INSERT INTO session_in_vacuum(person_id, reason, session_date, session_interval) VALUES
	('1', 'эксперимент', '2025-02-21', '54 seconds'),
	('2', 'несчастный случай', '1999-01-23', '4 minutes 56 seconds'),
	('3', 'убийство', '2003-04-12', '3 hours 12 minutes 14 seconds');
INSERT INTO outcome VALUES 
	('1', 'здоров', TRUE, NULL, 'рекомпрессия'),
	('2', 'травмирован', TRUE, 'удалось спасти, но остался частично парализованным из-за воздушной эмболии', null),
	('3', 'мёртв', FALSE, 'летальный исход', NULL);


END;