DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS lenda;
DROP TABLE IF EXISTS profesor;
DROP TABLE IF EXISTS profesor_lenda;
DROP TABLE IF EXISTS nota;

CREATE TABLE IF NOT EXISTS user(
	id int primary key AUTO_INCREMENT,
	salted_hash varchar(256),
	salted varchar(100)
);

ALTER TABLE user add column username varchar(100);
ALTER TABLE user modify column username varchar(100) after id;


CREATE TABLE IF NOT EXISTS student(
	id int primary key AUTO_INCREMENT,
	emri varchar(50),
	mbiemri varchar(50),
	studentId varchar(14),
	mosha int
);

CREATE TABLE IF NOT EXISTS lenda (
	id int primary key AUTO_INCREMENT,
	emri varchar(50),
	credits int
);

CREATE TABLE IF NOT EXISTS profesor (
	id int primary key AUTO_INCREMENT,
	emri varchar(50),
	titulli varchar(50)
);

CREATE TABLE IF NOT EXISTS profesor_lenda(
	id int primary key AUTO_INCREMENT,
	profesor_id int,
	lenda_id int,
	FOREIGN KEY (lenda_id) REFERENCES lenda (id),
	FOREIGN KEY (profesor_id) REFERENCES profesor (id)
);

CREATE TABLE IF NOT EXISTS nota(
	id int primary key AUTO_INCREMENT,
	student_id int,
	nota int,
	lenda_id int,
	profesor_id int,
	FOREIGN KEY (student_id) REFERENCES student (id),
	FOREIGN KEY (lenda_id) REFERENCES lenda (id),
	FOREIGN KEY (profesor_id) REFERENCES profesor (id)
);
