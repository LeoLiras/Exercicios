USE secao04;
# DML
-- insert
INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Notebook', 1500, 1);
INSERT INTO produtos VALUES (NULL, 'Macbook pro', 5000, 1);

INSERT INTO tipos_produto(descricao) VALUES ('Apple');
INSERT INTO produtos(descricao, preco, codigo_tipo) VALUES ('Macbook Air', 5200, 3);

SELECT * FROM produtos;

-- update
UPDATE produtos set codigo_tipo = 3 WHERE codigo = 6;
UPDATE produtos set descricao = 'Impr. Lazer', preco = 3000 WHERE codigo = 4;

#NUNCA ESQUECER DO WHERE

DELETE FROM produtos WHERE codigo = 4;

#NUNCA ESQUECER DO WHERE