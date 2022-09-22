CREATE DATABASE secao04;

USE secao04;

CREATE TABLE tipos_produto(
	codigo INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE produtos(
	codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL,
    preco DECIMAL(8,2) NOT NULL,
    codigo_tipo INT NOT NULL,
    FOREIGN KEY (codigo_tipo) REFERENCES tipos_produto(codigo)
);

INSERT INTO tipos_produto(descricao) VALUES ('Computadores');
INSERT INTO tipos_produto(descricao) VALUES ('Impressoras');

INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Desktop', 1500, 1);
INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Laptop', 1200, 1);
INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Impressora a tinta', 1000, 2);
INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Impressora a lazer', 2000, 2);

# DQL

SELECT * FROM tipos_produto;
SELECT codigo, descricao FROM tipos_produto;
SELECT descricao FROM tipos_produto;
SELECT descricao, codigo FROM tipos_produto;
SELECT codigo, descricao, preco, codigo_tipo FROM produtos;

# ALIAS - Apelido

SELECT p.codigo AS 'Código', p.descricao AS descri, p.preco AS pre FROM produtos as p;

# DML 

-- insert 

INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES('Notebook', '1500', 1);

