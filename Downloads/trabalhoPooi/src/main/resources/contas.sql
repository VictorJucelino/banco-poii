

INSERT INTO contas (id, numero, nome, tipo, saldo, limite, rendimento) VALUES
(1, 1001, 'Ana Silva', 'Corrente', 1500.0, 0.0, 0.0),
(2, 1002, 'Bruno Santos', 'Poupança', 2500.0, 0.0, 0.03),
(3, 1003, 'Carlos Oliveira', 'Especial', 3000.0, 500.0, 0.0),
(4, 1004, 'Diana Costa', 'Corrente', 1200.0, 0.0, 0.0),
(5, 1005, 'Eduardo Pereira', 'Poupança', 1800.0, 0.0, 0.02),
(6, 1006, 'Fernanda Almeida', 'Especial', 2200.0, 800.0, 0.0),
(7, 1007, 'Gabriel Souza', 'Corrente', 950.0, 0.0, 0.0),
(8, 1008, 'Helena Lima', 'Poupança', 1350.0, 0.0, 0.03),
(9, 1009, 'Igor Ferreira', 'Especial', 4000.0, 1000.0, 0.0),
(10, 1010, 'Juliana Barbosa', 'Corrente', 1900.0, 0.0, 0.0),
(11, 1011, 'Kleber Rocha', 'Poupança', 2200.0, 0.0, 0.02),
(12, 1012, 'Larissa Martins', 'Especial', 2500.0, 600.0, 0.0),
(13, 1013, 'Marcos Costa', 'Corrente', 1400.0, 0.0, 0.0),
(14, 1014, 'Natália Silva', 'Poupança', 3000.0, 0.0, 0.03),
(15, 1015, 'Otávio Lima', 'Especial', 3500.0, 700.0, 0.0),
(16, 1016, 'Paula Oliveira', 'Corrente', 2000.0, 0.0, 0.0),
(17, 1017, 'Quésia Santos', 'Poupança', 1600.0, 0.0, 0.02),
(18, 1018, 'Rafael Almeida', 'Especial', 2800.0, 800.0, 0.0),
(19, 1019, 'Sílvia Costa', 'Corrente', 2300.0, 0.0, 0.0),
(20, 1020, 'Tiago Ferreira', 'Poupança', 1900.0, 0.0, 0.03),
(21, 1021, 'Ursula Lima', 'Especial', 4100.0, 1200.0, 0.0),
(22, 1022, 'Vinícius Souza', 'Corrente', 1100.0, 0.0, 0.0),
(23, 1023, 'Wanda Barbosa', 'Poupança', 2700.0, 0.0, 0.02),
(24, 1024, 'Xuxa Almeida', 'Especial', 1500.0, 600.0, 0.0),
(25, 1025, 'Yara Silva', 'Corrente', 2600.0, 0.0, 0.0),
(26, 1026, 'Zé Roberto', 'Poupança', 2200.0, 0.0, 0.03),
(27, 1027, 'André Costa', 'Especial', 2300.0, 500.0, 0.0),
(28, 1028, 'Beatriz Rocha', 'Corrente', 1800.0, 0.0, 0.0),
(29, 1029, 'Cláudio Ferreira', 'Poupança', 1500.0, 0.0, 0.02),
(30, 1030, 'Daniele Lima', 'Especial', 3200.0, 900.0, 0.0);

INSERT INTO Extratos (ID_CONTA , DATA_HORA , tipo, quantia, saldo) VALUES 
(1001, '2024-12-01 10:00:00', 'Depósito', 500.00, 1500.00),
(1001, '2024-12-02 12:30:00', 'Saque', 200.00, 1300.00),
(1001, '2024-12-03 14:15:00', 'Pagamento', 300.00, 1000.00),
(1001, '2024-12-04 16:45:00', 'Transferência', 150.00, 850.00),
(1001, '2024-12-05 09:00:00', 'Depósito', 100.00, 950.00);
select * from extratos

