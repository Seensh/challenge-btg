CREATE DATABASE banco_btg;
\c banco_btg;

CREATE TABLE cliente (
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(255)
);

CREATE TABLE pedido (
    id_pedido SERIAL PRIMARY KEY,
    id_cliente INT,
    data_inclusao DATE NOT NULL,
    data_alteracao DATE NOT NULL,
    valor_total DECIMAL(15, 2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE item (
    id_item SERIAL PRIMARY KEY,
    id_pedido INT,
    produto VARCHAR(255),
    quantidade INT,
    preco DECIMAL(10, 2),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido)
);
