-- Inserção de colaboradores
INSERT INTO tb_colaborador (data_inicio, user_name, nome, user_password, sistema_operacional)
VALUES
    ('2023-05-10', 'joaosilva', 'João Silva', 'senhaSegura123', 'WINDOWSPAG'),
    ('2023-06-12', 'mariasantos', 'Maria Santos', 'senhaForte456', 'WINDOWSCOMPASS'),
    ('2023-07-15', 'carlossouza', 'Carlos Souza', 'Carlos#789', 'UBUNTUIFOOD'),
    ('2023-08-20', 'fernandapereira', 'Fernanda Pereira', 'F3rn@nda!', 'UBUNTUPAG'),
    ('2023-09-01', 'lucasrodrigues', 'Lucas Rodrigues', 'luc@1234', 'WINDOWSCOMPASS'),
    ('2023-10-05', 'julianamendes', 'Juliana Mendes', 'juliPass321', 'UBUNTUIFOOD'),
    ('2023-11-08', 'paulomartins', 'Paulo Martins', 'pauloSecure@', 'UBUNTUPAG'),
    ('2023-12-12', 'anacosta', 'Ana Costa', 'AnaC0sta!', 'SEQUOIA'),
    ('2024-01-10', 'andrelima', 'André Lima', 'andre@2024', 'WINDOWSPAG'),
    ('2024-02-14', 'carolbarbosa', 'Carolina Barbosa', 'CarolPass123', 'UBUNTUCOMPASS'),
    ('2024-03-18', 'gustavooliveira', 'Gustavo Oliveira', 'gusta2024#', 'WINDOWSCOMPASS'),
    ('2024-04-20', 'alinefreitas', 'Aline Freitas', 'Aline!321', 'UBUNTUIFOOD'),
    ('2024-05-05', 'ricardotorres', 'Ricardo Torres', 'Ric@2024!', 'WINDOWSPAG'),
    ('2024-06-01', 'nataliasilva', 'Natália Silva', 'n@t@l1a', 'WINDOWSCOMPASS'),
    ('2024-06-20', 'robertosouza', 'Roberto Souza', 'R0b3rt0$', 'SEQUOIA'),
    ('2024-07-15', 'tatianacruz', 'Tatiana Cruz', 'TatiCruz@', 'UBUNTUIFOOD'),
    ('2024-08-01', 'leonardomelo', 'Leonardo Melo', 'leoMelo#', 'UBUNTUPAG'),
    ('2024-08-28', 'beatrizsouza', 'Beatriz Souza', 'btrz12345', 'UBUNTUCOMPASS'),
    ('2024-09-10', 'marcelopinto', 'Marcelo Pinto', 'marcel0@', 'WINDOWSCOMPASS'),
    ('2024-10-01', 'luanasilva', 'Luana Silva', 'Lu@naSilva', 'UBUNTUIFOOD');

-- Inserção de equipamentos
INSERT INTO tb_equipamento (tipo_equipamento, modelo, service_tag, contrato_leasing)
VALUES
    ('NOTEBOOK', 'Dell Latitude 5420', 'ST001', 1001),
    ('MACBOOK', 'MacBook Pro M1', 'ST002', 1002),
    ('MONITOR', 'Dell P2419H', 'ST003', 1003),
    ('TECLADO', 'Logitech K120', 'ST004', 1004),
    ('MOUSE', 'Logitech M185', 'ST005', 1005),
    ('HEADSET', 'Jabra Evolve 20', 'ST006', 1006),
    ('SUPORTE', 'Suporte Articulado', 'ST007', 1007),
    ('ADAPTADOR', 'USB-C para HDMI', 'ST008', 1008),
    ('CELULAR', 'iPhone 13', 'ST009', 1009),
    ('NOTEBOOK', 'Lenovo ThinkPad T14', 'ST010', 1010),
    ('MONITOR', 'Samsung 24"', 'ST011', 1011),
    ('MACBOOK', 'MacBook Air M2', 'ST012', 1012),
    ('MOUSE', 'Microsoft Bluetooth', 'ST013', 1013),
    ('TECLADO', 'Microsoft Wired Keyboard 600', 'ST014', 1014),
    ('HEADSET', 'Logitech H390', 'ST015', 1015),
    ('SUPORTE', 'Base Elevada para Notebook', 'ST016', 1016),
    ('ADAPTADOR', 'USB para Ethernet', 'ST017', 1017),
    ('CELULAR', 'Samsung Galaxy S22', 'ST018', 1018),
    ('NOTEBOOK', 'HP EliteBook 840', 'ST019', 1019),
    ('MONITOR', 'LG UltraWide', 'ST020', 1020),
    ('NOTEBOOK', 'Acer Aspire 5', 'ST021', 1021),
    ('NOTEBOOK', 'Asus ZenBook 14', 'ST022', 1022),
    ('NOTEBOOK', 'HP Pavilion 15', 'ST023', 1023),
    ('NOTEBOOK', 'Lenovo IdeaPad 3', 'ST024', 1024),
    ('NOTEBOOK', 'Dell Inspiron 15', 'ST025', 1025),
    ('NOTEBOOK', 'Acer Swift 3', 'ST026', 1026),
    ('NOTEBOOK', 'Asus VivoBook 15', 'ST027', 1027),
    ('NOTEBOOK', 'HP Envy 13', 'ST028', 1028),
    ('NOTEBOOK', 'Lenovo Yoga 7i', 'ST029', 1029),
    ('NOTEBOOK', 'Dell XPS 13', 'ST030', 1030);

-- Distribuição de equipamentos
UPDATE tb_equipamento SET colaborador_id = 1 WHERE id_equipamento IN (1, 3);
UPDATE tb_equipamento SET colaborador_id = 2 WHERE id_equipamento IN (10, 4);
UPDATE tb_equipamento SET colaborador_id = 3 WHERE id_equipamento IN (19, 5);
UPDATE tb_equipamento SET colaborador_id = 4 WHERE id_equipamento IN (21, 6);
UPDATE tb_equipamento SET colaborador_id = 5 WHERE id_equipamento IN (22, 7);
UPDATE tb_equipamento SET colaborador_id = 6 WHERE id_equipamento IN (23, 8);
UPDATE tb_equipamento SET colaborador_id = 7 WHERE id_equipamento IN (24, 9);
UPDATE tb_equipamento SET colaborador_id = 8 WHERE id_equipamento IN (2, 11);
UPDATE tb_equipamento SET colaborador_id = 9 WHERE id_equipamento IN (25, 13);
UPDATE tb_equipamento SET colaborador_id = 10 WHERE id_equipamento IN (26, 14);
UPDATE tb_equipamento SET colaborador_id = 11 WHERE id_equipamento IN (27, 15);
UPDATE tb_equipamento SET colaborador_id = 12 WHERE id_equipamento IN (28, 16);
UPDATE tb_equipamento SET colaborador_id = 13 WHERE id_equipamento IN (29, 17);
UPDATE tb_equipamento SET colaborador_id = 14 WHERE id_equipamento IN (30, 18);
UPDATE tb_equipamento SET colaborador_id = 15 WHERE id_equipamento IN (12, 20);
UPDATE tb_equipamento SET colaborador_id = 16 WHERE id_equipamento IN (4, 5);
UPDATE tb_equipamento SET colaborador_id = 17 WHERE id_equipamento IN (6, 7);
UPDATE tb_equipamento SET colaborador_id = 18 WHERE id_equipamento IN (8, 9);
UPDATE tb_equipamento SET colaborador_id = 19 WHERE id_equipamento IN (10, 11);
UPDATE tb_equipamento SET colaborador_id = 20 WHERE id_equipamento IN (12, 13);