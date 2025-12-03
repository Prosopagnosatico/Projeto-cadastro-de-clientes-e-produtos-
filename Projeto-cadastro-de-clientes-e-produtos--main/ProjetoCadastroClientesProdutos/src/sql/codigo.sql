create database cliente_e_produto;
use cliente_e_produto;


CREATE TABLE vendas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomeProduto VARCHAR(200),
    precoProduto decimal(10,2),
    dataVenda date
);

CREATE TABLE usuario(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    idade int NOT NULL,
    email varchar(200) NOT NULL,
    telefone varchar(13) NOT NULL,
    genero varchar(9) NOT NULL,
    identificador varchar(18) UNIQUE KEY NOT NULL,
    senha varchar(12) NOT NULL,
);

CREATE TABLE clientes(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(200) NOT NULL,
    idade int NOT NULL,
    email varchar(200) NOT NULL,
    telefone varchar(13) NOT NULL,
    genero varchar(9) NOT NULL,
    identificador varchar(18) NOT NULL,
    observacao varchar(300),
    status varchar(11) NOT NULL,
    nivel varchar(20) NOT NULL,
    venda_id INT NOT NULL,
    FOREIGN KEY (venda_id) REFERENCES vendas(id)
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nomeProd VARCHAR(200) NOT NULL,
    precoUnitario double NOT NULL,
    precoLote double NOT NULL,
    custoProducao double NOT NULL,
    categoria varchar(50) NOT NULL,
    tamanhho double,
    fornecedores varchar(200) NOT NULL,
    descricao varchar(500) NOT NULL
);

CREATE TABLE estoque (
    id_prod int NOT NULL,
    qnt_prod int NOT NULL,
    dataEntrada date,
    dataSaida date
    FOREIGN KEY (id_prod) REFERENCES produtos(id)
);

CREATE TABLE promocao (
    precoPromo double,
    dataInicio date,
    dataFim date
);

CREATE TABLE enderecos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    rua VARCHAR(160),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(15),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
