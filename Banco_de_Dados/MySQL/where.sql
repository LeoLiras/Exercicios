CREATE DATABASE secao05;
USE secao05;

CREATE TABLE tipos_produto(
	codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);

CREATE TABLE produtos(
	codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL,
    preco DECIMAL(8,2) NOT NULL,
    codigo_tipo INT NOT NULL,
    FOREIGN KEY(codigo_tipo) REFERENCES tipos_produto(codigo)
);

INSERT INTO tipos_produto(descricao) VALUES ('Computador');
INSERT INTO tipos_produto(descricao) VALUES ('Impressora');

INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Desktop', 1200, 1);
INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Laptop', 1800, 1);
INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Impressora Jato', 500, 2);
INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Impressora Lazer', 700, 2);

# WHERE 

SELECT * FROM produtos WHERE codigo_tipo = 2;

SELECT * FROM produtos WHERE codigo_tipo = 2 AND preco > 500;