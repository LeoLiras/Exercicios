# Dados de teste - DML
-- Tipos

INSERT INTO tipos_produtos (tipo) VALUES ('Remédios');
INSERT INTO tipos_produtos (tipo) VALUES ('Cosméticos');
INSERT INTO tipos_produtos (tipo) VALUES ('Diversos');

INSERT INTO fabricantes (nome) VALUES ('Roche');
INSERT INTO fabricantes (nome) VALUES ('Vitallis');
INSERT INTO fabricantes (nome) VALUES ('Palmolive');

INSERT INTO medicos(nome) VALUES ('Bruce Wayne');
INSERT INTO medicos(nome) VALUES ('Selina Kyle');
INSERT INTO medicos(nome) VALUES ('Barbara Gordon');

INSERT INTO clientes(nome, endereco, telefone, cep, localidade, cpf) VALUES ('Felicity Smoak', 'Rua da paz 123', '12345-67', '123456', 'Santos', '123456789');
INSERT INTO clientes(nome, endereco, telefone, cep, localidade, cpf) VALUES ('John Snow', 'Rua da neve 123', '234142-1247', '11242146', 'Winterfel', '124124');
INSERT INTO clientes(nome, endereco, telefone, cep, localidade, cpf) VALUES ('Ned Stark', 'Rua da neve 11233', '121214124-2467', '5364346', 'Winterfel', '56757659');

-- Produtos

INSERT INTO produtos (nome, designacao, composicao, preco_venda, id_tipo_produto, id_fabricante) VALUES ('Dipirona', 'Dores em geral', 'Metilpropileno', 21.99, 1, 1);
INSERT INTO produtos (nome, designacao, composicao, preco_venda, id_tipo_produto, id_fabricante) VALUES ('Sabonete', 'Limpeza', 'n sei', 3.55, 2, 2);
INSERT INTO produtos (nome, designacao, composicao, preco_venda, id_tipo_produto, id_fabricante) VALUES ('Protetor Solar', 'Proteção', 'Sei lá', 10.99, 2, 1);

-- Compras

INSERT INTO compras (id_cliente, data_compra) VALUES (1, '2019-05-18');
INSERT INTO compras (id_cliente, data_compra) VALUES (2, '2019-05-28');
INSERT INTO compras (id_cliente, data_compra) VALUES (1, '2019-05-30');

-- Produtos_compra

INSERT INTO produtos_compra (id_compra, id_produto, quantidade) VALUES (1, 2, 1);
INSERT INTO produtos_compra (id_compra, id_produto, quantidade) VALUES (2, 2, 3);
INSERT INTO produtos_compra (id_compra, id_produto, quantidade) VALUES (1, 3, 1);

-- Receitas
INSERT INTO	 receitas_medica (id_produto_compra, id_medico, receita) VALUES (1, 1, 'receita1.pdf');
INSERT INTO	 receitas_medica (id_produto_compra, id_medico, receita) VALUES (3, 2, 'receita2.pdf');