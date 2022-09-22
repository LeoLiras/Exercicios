# DDL
-- create

CREATE DATABASE praticadql;
USE praticadql;

CREATE TABLE pessoas(
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO pessoas(nome) VALUES ('Felicity Jones');
SELECT * FROM pessoas;

-- Alter
 ALTER TABLE pessoas ADD ano_nascimento INT;

-- Drop

DROP TABLE pessoas;