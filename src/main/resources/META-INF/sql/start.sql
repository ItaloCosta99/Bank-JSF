INSERT INTO pessoa (ID, nome, cidade, email, cep, endereco, pais, usuario, telefone, data_nascimento, cargo_id)
VALUES 
(1, 'Murilo Azevedo', 'Rio de Janeiro', 'MuriloDiasAzevedo@armyspy.com', '25755-351', 'Vila de Secretario 18', 'Brazil', 'Cousine', '(24) 7129-8842', '1945-12-29', 2),
(2, 'Júlia Sousa', 'São Paulo', 'JuliaGoncalvesSousa@jourrapide.com', '08226-018', 'Rua Campos 1466', 'Brazil', 'Martled40', '(11) 3547-3065', '1940-10-02', 1),
(3, 'Livia Rocha', 'Paraná', 'LiviaSouzaRocha@superrito.com', '81935-330', 'Travessa Alaor Darci Conduta 1285', 'Brazil', 'Wastores', '(41) 7748-7353', '1948-12-23', 5);

INSERT INTO cargo (ID, Nome)
VALUES 
(1, 'Estagiario'),
(2, 'Tecnico'),
(3, 'Analista'),
(4, 'Coordenador'),
(5, 'Gerente');

INSERT INTO vencimentos (ID, Descricao, Valor, Tipo)
VALUES 
(1, 'Vencimento Basico Estagiario', 400, 'CREDITO'),
(2, 'Vencimento Basico Tecnico', 1000, 'CREDITO'),
(3, 'Vencimento Basico Analista', 2500, 'CREDITO'),
(4, 'Vencimento Basico Coordenador', 5000, 'CREDITO'),
(5, 'Vencimento Basico Gerente', 6500, 'CREDITO'),
(6, 'Gratificacao Coordenador', 500, 'CREDITO'),
(7, 'Gratificacao Gerente', 1000, 'CREDITO'),
(8, 'Plano de Saude', 350, 'DEBITO'),
(9, 'Previdencia', 11, 'DEBITO');


INSERT INTO cargo_vencimentos (ID, Cargo_ID, Vencimento_ID)
VALUES 
(1, 1, 1),
(2, 2, 2),
(3, 2, 9),
(4, 2, 8),
(5, 3, 3),
(6, 3, 9),
(7, 3, 8),
(8, 4, 4),
(9, 4, 9),
(10, 4, 8),
(11, 4, 6),
(12, 5, 5),
(13, 5, 9),
(14, 5, 8),
(15, 5, 7);