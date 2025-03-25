BEGIN;

CREATE TYPE gender AS ENUM ('мужской', 'женский');
CREATE TYPE locations AS ENUM ('вакуум', 'нормальное');
CREATE TYPE health_status AS ENUM ('мёртв', 'ранен', 'травмирован', 'здоров');

CREATE TABLE IF NOT EXISTS dublicates
(
	id SERIAL PRIMARY KEY,
	table_first TEXT,
	table_second TEXT,
	dublicate_first TEXT,
	dublicate_second TEXT,
	tables_key TEXT
);

INSERT INTO dublicates (table_first, table_second, dublicate_first, dublicate_second, tables_key)
VALUES
('person', 'medical_data', 'person_health_status', 'person_health_status', 'person_id');

CREATE FUNCTION update_dublicates() 
RETURNS TRIGGER AS $$
DECLARE 
	table_second_name TEXT;
	dublicate_second_name TEXT;
	dublicate_second_value TEXT;
	tables_key_name TEXT;
	tables_key_value TEXT;
	tables_key_type TEXT;
	dublicates_type TEXT;
BEGIN
	SELECT table_second, dublicate_second, tables_key
	INTO table_second_name, dublicate_second_name, tables_key_name
	FROM dublicates
	WHERE table_first = TG_TABLE_NAME AND dublicate_first = TG_ARGV[0];

	IF NOT FOUND THEN
		RETURN NEW;
	END IF;

	EXECUTE format('SELECT ($1).%I FROM (SELECT $1 AS new_record) AS subquery', tables_key_name) 
	INTO tables_key_value
	USING NEW;

	EXECUTE format('SELECT ($1).%I FROM (SELECT $1 AS new_record) AS subquery', dublicate_second_name)
	INTO dublicate_second_value
	USING NEW;

	EXECUTE format('SELECT pg_typeof(%I) FROM %I LIMIT 1', dublicate_second_name, table_second_name) 
    INTO dublicates_type;

	EXECUTE format('SELECT pg_typeof(%I) FROM %I LIMIT 1', tables_key_name, table_second_name) 
    INTO tables_key_type;

	EXECUTE format('UPDATE %I SET %I = $1::%s WHERE %I = $2::%s', table_second_name, dublicate_second_name, dublicates_type, tables_key_name, tables_key_type)
	USING dublicate_second_value, tables_key_value;

	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

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

CREATE TRIGGER sync_medical_data
AFTER UPDATE OF person_health_status ON medical_data
FOR EACH ROW
EXECUTE FUNCTION update_dublicates('person_health_status');

CREATE TRIGGER sync_person
AFTER UPDATE OF person_health_status ON person
FOR EACH ROW
EXECUTE FUNCTION update_dublicates('person_health_status');

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