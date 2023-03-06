CREATE DATABASE DB_VENDA;
USE DB_VENDA;
/* CREATE TABLE */
CREATE TABLE BAIRROS (
  IDBAIRRO BIGINT NOT NULL IDENTITY,
  BAIRRO VARCHAR(60) NOT NULL,
  PRIMARY KEY(IDBAIRRO)
);
CREATE TABLE CATEGORIAS (
  IDCATEGORIA BIGINT NOT NULL IDENTITY,
  CATEGORIA VARCHAR(100) NOT NULL,
  PRIMARY KEY(IDCATEGORIA)
);
CREATE TABLE CIDADES (
  IDCIDADE BIGINT NOT NULL IDENTITY,
  CIDADE VARCHAR(100) NOT NULL,
  PRIMARY KEY(IDCIDADE)
);
CREATE TABLE ENDERECOS (
  IDENDERECO BIGINT NOT NULL IDENTITY,
  IDCIDADE_PK BIGINT NOT NULL,
  IDBAIRRO_PK BIGINT NOT NULL,
  IDESTADO_PK BIGINT NOT NULL,
  ENDERECO VARCHAR(250) NOT NULL,
  CEP VARCHAR(20) NOT NULL,
  PRIMARY KEY(IDENDERECO),
  INDEX ENDERECO_FKIndex1(IDBAIRRO_PK),
  INDEX ENDERECO_FKIndex2(IDCIDADE_PK),
  INDEX ENDERECO_FKIndex3(IDESTADO_PK)
);
CREATE TABLE ESTADOS (
  IDESTADO BIGINT NOT NULL IDENTITY,
  ESTADO VARCHAR(100) NOT NULL,
  PRIMARY KEY(IDESTADO)
);
CREATE TABLE PESSOAS (
  IDPESSOA BIGINT NOT NULL IDENTITY,
  IDENDERECO_PK BIGINT NOT NULL,
  PRIMEIRONOME VARCHAR(120) NOT NULL,
  SEGUNDONOME VARCHAR(120) NOT NULL,
  CPF VARCHAR(20) NOT NULL,
  EMAIL VARCHAR(255) NOT NULL,
  COMPLEMENTO VARCHAR(100) NOT NULL,
  NUMERO BIGINT NOT NULL,
  PRIMARY KEY(IDPESSOA),
  INDEX PESSOAS_FKIndex1(IDENDERECO_PK)
);
CREATE TABLE PRODUTOS (
  IDPRODUTO BIGINT NOT NULL IDENTITY,
  IDUNIDADE_PK BIGINT NOT NULL,
  IDCATEGORIA_PK BIGINT NOT NULL,
  PRODUTO VARCHAR(120) NOT NULL,
  DESCRICAO VARCHAR(250) NOT NULL,
  PRECO_UNITARIO FLOAT NOT NULL,
  NCM VARCHAR(20) NOT NULL,
  PRIMARY KEY(IDPRODUTO),
  INDEX PRODUTOS_FKIndex1(IDCATEGORIA_PK),
  INDEX PRODUTOS_FKIndex2(IDUNIDADE_PK)
);
CREATE TABLE UNIDADES (
  IDUNIDADE BIGINT NOT NULL IDENTITY,
  UNIDADE VARCHAR(100) NOT NULL,
  ABREVIACAO VARCHAR(8) NOT NULL,
  PRIMARY KEY(IDUNIDADE)
);
CREATE TABLE VENDAS (
  IDPESSOA_PK BIGINT NOT NULL,
  IDPRODUTO_PK BIGINT NOT NULL,
  IDVENDA BIGINT NOT NULL IDENTITY,
  PRECO_TOTAL FLOAT NOT NULL,
  DESCONTO FLOAT NOT NULL,
  FORMAPAGAMENTO VARCHAR(100) NOT NULL,
  PAGAMENTO FLOAT NOT NULL,
  DATAPAGAMENTO DATETIME NULL,
  TROCO FLOAT NOT NULL,
  QUANTIDADE BIGINT NOT NULL,
  PRIMARY KEY(IDPESSOA_PK, IDPRODUTO_PK),
  INDEX PESSOAS_has_PRODUTOS_FKIndex1(IDPESSOA_PK),
  INDEX PESSOAS_has_PRODUTOS_FKIndex2(IDPRODUTO_PK)
);
/* COMANDOS DE INSERT */
-- BAIRROS
INSERT INTO BAIRROS (BAIRRO)
VALUES ('FRARON');
INSERT INTO BAIRROS (BAIRRO)
VALUES ('CENTRO');
-- CIDADES
INSERT INTO CIDADES (CIDADE)
VALUES ('PATO BRANCO');
INSERT INTO CIDADES (CIDADE)
VALUES ('FRANCISCO BELTRÃO');
-- ESTADOS
INSERT INTO ESTADOS (ESTADO)
VALUES ('PARANÁ');
INSERT INTO ESTADOS (ESTADO)
VALUES ('SÃO PAULO');
-- ENDEREÇOS
INSERT INTO ENDERECOS (
    IDCIDADE_PK,
    IDBAIRRO_PK,
    IDESTADO_PK,
    ENDERECO,
    CEP
  )
VALUES (
    1,
    1,
    1,
    'Rua Silvestre Ambrosio Franchin',
    '85503374'
  );
-- PESSOAS
INSERT INTO PESSOAS (
    IDENDERECO_PK,
    PRIMEIRONOME,
    SEGUNDONOME,
    CPF,
    EMAIL,
    COMPLEMENTO,
    NUMERO
  )
VALUES (
    1,
    'MARIO',
    'SOUZA',
    '905.087.550-50',
    'MARIOS@EMAIL.COM',
    'CASA',
    150
  );
-- PRODUTOS
INSERT INTO PRODUTOS (
    IDUNIDADE_PK,
    IDCATEGORIA_PK,
    PRODUTO,
    DESCRICAO,
    PRECO_UNITARIO,
    NCM
  )
VALUES (
    2,
    1,
    'ÁGUA MINERAL',
    'ÁGUA MINERAL 500ML',
    6,
    '2201.10.00'
  );
-- UNIDADES
INSERT INTO UNIDADES (UNIDADE, ABREVIACAO)
VALUES ('KILOGRAMA', 'KG');
INSERT INTO UNIDADES (UNIDADE, ABREVIACAO)
VALUES ('MILIGRAMA', 'ML');
INSERT INTO UNIDADES (UNIDADE, ABREVIACAO)
VALUES ('LITRO', 'L');
-- CATEGORIAS
INSERT INTO CATEGORIAS (CATEGORIA)
VALUES ('BEBIDA');
INSERT INTO CATEGORIAS (CATEGORIA)
VALUES ('ALIMENTO');
INSERT INTO CATEGORIAS (CATEGORIA)
VALUES ('DIVERSOS');
INSERT INTO CATEGORIAS (CATEGORIA)
VALUES ('DOCES');
-- VENDAS
INSERT INTO VENDAS (
    IDPESSOA_PK,
    IDPRODUTO_PK,
    PRECO_TOTAL,
    DESCONTO,
    FORMAPAGAMENTO,
    PAGAMENTO,
    DATAPAGAMENTO,
    TROCO
  )
VALUES (
    1,
    1,
    18,
    0,
    'DINHEIRO',
    20,
    GETDATE(),
    2
  )