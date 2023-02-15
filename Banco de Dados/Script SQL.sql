-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE turismologo (
id_turismologo INTEGER PRIMARY KEY,
nome VARCHAR(50),
cpf VARCHAR(14),
data_nasc VARCHAR(10),
endereco VARCHAR(500),
telefone VARCHAR(15)
)

CREATE TABLE turista (
id_turista INTEGER PRIMARY KEY,
nome VARCHAR(50),
cpf VARCHAR(14),
data_nasc VARCHAR(10),
endereco VARCHAR(500),
telefone VARCHAR(15)
)

CREATE TABLE cidade (
id_cidade INTEGER PRIMARY KEY,
nome VARCHAR(50),
coordenadas VARCHAR(20)
)

CREATE TABLE hotel (
id_hotel INTEGER PRIMARY KEY,
id_cidade INTEGER,
endereco VARCHAR(500),
telefone VARCHAR(15),
nome VARCHAR(50),
FOREIGN KEY(id_cidade) REFERENCES cidade (id_cidade)
)

CREATE TABLE ponto_turistico (
id_ponto_turistico INTEGER PRIMARY KEY,
id_cidade INTEGER,
nome VARCHAR(50),
descricao VARCHAR(200),
telefone VARCHAR(15),
endereco VARCHAR(500),
FOREIGN KEY(id_cidade) REFERENCES cidade (id_cidade)
)

CREATE TABLE atracao (
id_atracao INTEGER PRIMARY KEY,
id_cidade INTEGER,
nome VARCHAR(50),
tipo VARCHAR(50),
descricao VARCHAR(200),
telefone VARCHAR(15),
endereco VARCHAR(500),
FOREIGN KEY(id_cidade) REFERENCES cidade (id_cidade)
)

CREATE TABLE roteiro (
id_roteiro INTEGER PRIMARY KEY,
id_turismologo INTEGER,
id_turista INTEGER,
id_cidade INTEGER,
id_ponto_turistico INTEGER,
id_atracao INTEGER,
id_hotel INTEGER,
valor DECIMAL(10),
FOREIGN KEY(id_turismologo) REFERENCES turismologo (id_turismologo),
FOREIGN KEY(id_turista) REFERENCES turista (id_turista),
FOREIGN KEY(id_cidade) REFERENCES cidade (id_cidade)
)