create database cliente_e_produto;
use cliente_e_produto;


CREATE TABLE vendas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomeProduto VARCHAR(200),
    precoProduto decimal(10,2),
    dataVenda date
);
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    idade int,
    email varchar(200),
    telefone varchar(11),
    genero varchar(10),
    identificador varchar(18),
    venda_id INT,
    FOREIGN KEY (venda_id) REFERENCES vendas(id)
);
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomeProd VARCHAR(200),
    precoUnitario double,
    precoLote double,
    custoProducao double,
    categoria varchar(50),
    tamanhho double ,
    fornecedores varchar(200),
    descricao varchar(500)
);
CREATE TABLE estoque (
    qnt_prod int,
    dataEntrada date,
    dataSaida date
);
CREATE TABLE promocao (
    precoPromo double,
    dataInicio date,
    dataFim date
);
CREATE TABLE enderecos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    rua VARCHAR(150),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    numero VARCHAR(10),
    cep VARCHAR(15),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
