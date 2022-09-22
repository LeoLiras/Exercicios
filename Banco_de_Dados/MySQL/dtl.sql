USE secao04;
# DTL

SELECT * FROM tipos_produto;

START TRANSACTION;
	INSERT INTO tipos_produto(descricao) VALUES ('Farmácia');
    INSERT INTO tipos_produto(descricao) VALUES ('Escritório');
COMMIT;

ROLLBACK;

UPDATE tipos_produto SET descricao = null WHERE codigo = 7;