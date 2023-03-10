-- Bairros --
SELECT *
FROM BAIRROS
-------------------------------------------------------------------------------
SELECT *
FROM BAIRROS
WHERE IDBAIRRO = 1
-------------------------------------------------------------------------------
SELECT *
FROM BAIRROS
WHERE BAIRRO LIKE 1
-- Categorias --
SELECT *
FROM CATEGORIAS
-------------------------------------------------------------------------------
SELECT *
FROM CATEGORIAS
WHERE IDCATEGORIA = 1
-------------------------------------------------------------------------------
SELECT *
FROM CATEGORIAS
WHERE CATEGORIA LIKE 1
-- Cidades --
SELECT *
FROM CIDADES
-------------------------------------------------------------------------------
SELECT *
FROM CIDADES
WHERE IDCIDADE = 1
-------------------------------------------------------------------------------
SELECT *
FROM CIDADES
WHERE CIDADE LIKE 1
-- Unidades --
SELECT *
FROM UNIDADES
-------------------------------------------------------------------------------
SELECT *
FROM UNIDADES
WHERE IDUNIDADE = 1
-------------------------------------------------------------------------------
SELECT *
FROM UNIDADES
WHERE UNIDADE LIKE 1
-- Estados --
SELECT *
FROM ESTADOS
SELECT *
FROM ESTADOS
WHERE IDESTADO = 1
-------------------------------------------------------------------------------
SELECT *
FROM ESTADOS
WHERE ESTADO LIKE 1
-- Endereço --
SELECT E.IDENDERECO,
	E.ENDERECO,
	E.CEP,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDESTADO_PK,
	UF.ESTADO
FROM ENDERECOS E
	INNER JOIN CIDADES C ON C.IDCIDADE = E.IDCIDADE_PK
	INNER JOIN BAIRROS B ON B.IDBAIRRO = E.IDBAIRRO_PK
	INNER JOIN ESTADOS UF ON UF.IDESTADO = E.IDESTADO_PK
-------------------------------------------------------------------------------
SELECT E.IDENDERECO,
	E.ENDERECO,
	E.CEP,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDESTADO_PK,
	UF.ESTADO
FROM ENDERECOS E
	INNER JOIN CIDADES C ON C.IDCIDADE = E.IDCIDADE_PK
	INNER JOIN BAIRROS B ON B.IDBAIRRO = E.IDBAIRRO_PK
	INNER JOIN ESTADOS UF ON UF.IDESTADO = E.IDESTADO_PK
WHERE E.IDENDERECO = 1
-------------------------------------------------------------------------------
SELECT E.IDENDERECO,
	E.ENDERECO,
	E.CEP,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDESTADO_PK,
	UF.ESTADO
FROM ENDERECOS E
	INNER JOIN CIDADES C ON C.IDCIDADE = E.IDCIDADE_PK
	INNER JOIN BAIRROS B ON B.IDBAIRRO = E.IDBAIRRO_PK
	INNER JOIN ESTADOS UF ON UF.IDESTADO = E.IDESTADO_PK
WHERE E.ENDERECO LIKE 1
-- Produtos --
SELECT PROD.IDPRODUTO,
	PROD.PRODUTO,
	PROD.DESCRICAO,
	PROD.PRECO_UNITARIO,
	PROD.NCM,
	PROD.IDUNIDADE_PK,
	U.UNIDADE,
	U.ABREVIACAO,
	PROD.IDCATEGORIA_PK,
	C.CATEGORIA
FROM PRODUTOS PROD
	INNER JOIN UNIDADES U ON PROD.IDUNIDADE_PK = U.IDUNIDADE
	INNER JOIN CATEGORIAS C ON PROD.IDUNIDADE_PK = C.IDCATEGORIA
-------------------------------------------------------------------------------
SELECT PROD.IDPRODUTO,
	PROD.PRODUTO,
	PROD.DESCRICAO,
	PROD.PRECO_UNITARIO,
	PROD.NCM,
	PROD.IDUNIDADE_PK,
	U.UNIDADE,
	U.ABREVIACAO,
	PROD.IDCATEGORIA_PK,
	C.CATEGORIA
FROM PRODUTOS PROD
	INNER JOIN UNIDADES U ON PROD.IDUNIDADE_PK = U.IDUNIDADE
	INNER JOIN CATEGORIAS C ON PROD.IDUNIDADE_PK = C.IDCATEGORIA
WHERE PROD.IDPRODUTO = 1
-------------------------------------------------------------------------------
SELECT PROD.IDPRODUTO,
	PROD.PRODUTO,
	PROD.DESCRICAO,
	PROD.PRECO_UNITARIO,
	PROD.NCM,
	PROD.IDUNIDADE_PK,
	U.UNIDADE,
	U.ABREVIACAO,
	PROD.IDCATEGORIA_PK,
	C.CATEGORIA
FROM PRODUTOS PROD
	INNER JOIN UNIDADES U ON PROD.IDUNIDADE_PK = U.IDUNIDADE
	INNER JOIN CATEGORIAS C ON PROD.IDUNIDADE_PK = C.IDCATEGORIA
WHERE PROD.PRODUTO = 1
-- Pessoas --
SELECT P.IDPESSOA,
	P.PRIMEIRONOME,
	P.SEGUNDONOME,
	P.CPF,
	P.EMAIL,
	P.NUMERO,
	P.COMPLEMENTO,
	P.IDENDERECO_PK,
	E.CEP,
	E.ENDERECO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDESTADO_PK,
	UF.ESTADO
FROM PESSOAS P
	INNER JOIN ENDERECOS E ON P.IDENDERECO_PK = E.IDENDERECO
	INNER JOIN CIDADES C ON E.IDCIDADE_PK = C.IDCIDADE
	INNER JOIN BAIRROS B ON E.IDCIDADE_PK = B.IDBAIRRO
	INNER JOIN ESTADOS UF ON E.IDCIDADE_PK = UF.IDESTADO
-------------------------------------------------------------------------------
SELECT P.IDPESSOA,
	P.PRIMEIRONOME,
	P.SEGUNDONOME,
	P.CPF,
	P.EMAIL,
	P.NUMERO,
	P.COMPLEMENTO,
	P.IDENDERECO_PK,
	E.CEP,
	E.ENDERECO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDESTADO_PK,
	UF.ESTADO
FROM PESSOAS P
	INNER JOIN ENDERECOS E ON P.IDENDERECO_PK = E.IDENDERECO
	INNER JOIN CIDADES C ON E.IDCIDADE_PK = C.IDCIDADE
	INNER JOIN BAIRROS B ON E.IDCIDADE_PK = B.IDBAIRRO
	INNER JOIN ESTADOS UF ON E.IDCIDADE_PK = UF.IDESTADO
WHERE IDPESSOA = 1
-------------------------------------------------------------------------------
SELECT P.IDPESSOA,
	P.PRIMEIRONOME,
	P.SEGUNDONOME,
	P.CPF,
	P.EMAIL,
	P.NUMERO,
	P.COMPLEMENTO,
	P.IDENDERECO_PK,
	E.CEP,
	E.ENDERECO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDESTADO_PK,
	UF.ESTADO
FROM PESSOAS P
	INNER JOIN ENDERECOS E ON P.IDENDERECO_PK = E.IDENDERECO
	INNER JOIN CIDADES C ON E.IDCIDADE_PK = C.IDCIDADE
	INNER JOIN BAIRROS B ON E.IDCIDADE_PK = B.IDBAIRRO
	INNER JOIN ESTADOS UF ON E.IDCIDADE_PK = UF.IDESTADO
WHERE PRIMEIRONOME LIKE 1
-- Vendas --
SELECT V.IDVENDA,
	V.IDPESSOA_PK,
	V.IDPRODUTO_PK,
	V.PRECO_TOTAL,
	V.FORMAPAGAMENTO,
	V.PAGAMENTO,
	V.TROCO,
	V.DESCONTO,
	V.DATAPAGAMENTO,
	PE.PRIMEIRONOME,
	PE.SEGUNDONOME,
	PE.CPF,
	PE.EMAIL,
	PE.COMPLEMENTO,
	PE.NUMERO,
	PE.IDENDERECO_PK,
	PROD.PRODUTO,
	PROD.DESCRICAO,
	PROD.PRECO_UNITARIO,
	PROD.NCM,
	PROD.IDUNIDADE_PK,
	PROD.IDCATEGORIA_PK,
	E.CEP,
	E.ENDERECO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDESTADO_PK,
	UF.ESTADO,
	CAT.CATEGORIA,
	U.UNIDADE,
	U.ABREVIACAO
FROM VENDAS V
	INNER JOIN PESSOAS PE ON V.IDPESSOA_PK = PE.IDPESSOA
	INNER JOIN PRODUTOS PROD ON V.IDPRODUTO_PK = PROD.IDPRODUTO
	INNER JOIN UNIDADES U ON PROD.IDUNIDADE_PK = U.IDUNIDADE
	INNER JOIN CATEGORIAS CAT ON PROD.IDUNIDADE_PK = CAT.IDCATEGORIA
	INNER JOIN ENDERECOS E ON PE.IDENDERECO_PK = E.IDENDERECO
	INNER JOIN CIDADES C ON E.IDCIDADE_PK = C.IDCIDADE
	INNER JOIN BAIRROS B ON E.IDCIDADE_PK = B.IDBAIRRO
	INNER JOIN ESTADOS UF ON E.IDCIDADE_PK = UF.IDESTADO
-------------------------------------------------------------------------------
SELECT V.IDVENDA,
	V.IDPESSOA_PK,
	V.IDPRODUTO_PK,
	V.PRECO_TOTAL,
	V.FORMAPAGAMENTO,
	V.PAGAMENTO,
	V.TROCO,
	V.DESCONTO,
	V.DATAPAGAMENTO,
	PE.PRIMEIRONOME,
	PE.SEGUNDONOME,
	PE.CPF,
	PE.EMAIL,
	PE.COMPLEMENTO,
	PE.NUMERO,
	PE.IDENDERECO_PK,
	PROD.PRODUTO,
	PROD.DESCRICAO,
	PROD.PRECO_UNITARIO,
	PROD.NCM,
	PROD.IDUNIDADE_PK,
	PROD.IDCATEGORIA_PK,
	E.CEP,
	E.ENDERECO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDESTADO_PK,
	UF.ESTADO,
	CAT.CATEGORIA,
	U.UNIDADE,
	U.ABREVIACAO
FROM VENDAS V
	INNER JOIN PESSOAS PE ON V.IDPESSOA_PK = PE.IDPESSOA
	INNER JOIN PRODUTOS PROD ON V.IDPRODUTO_PK = PROD.IDPRODUTO
	INNER JOIN UNIDADES U ON PROD.IDUNIDADE_PK = U.IDUNIDADE
	INNER JOIN CATEGORIAS CAT ON PROD.IDUNIDADE_PK = CAT.IDCATEGORIA
	INNER JOIN ENDERECOS E ON PE.IDENDERECO_PK = E.IDENDERECO
	INNER JOIN CIDADES C ON E.IDCIDADE_PK = C.IDCIDADE
	INNER JOIN BAIRROS B ON E.IDCIDADE_PK = B.IDBAIRRO
	INNER JOIN ESTADOS UF ON E.IDCIDADE_PK = UF.IDESTADO
WHERE V.IDVENDA = 1
-------------------------------------------------------------------------------
SELECT V.IDVENDA,
	V.IDPESSOA_PK,
	V.IDPRODUTO_PK,
	V.PRECO_TOTAL,
	V.FORMAPAGAMENTO,
	V.PAGAMENTO,
	V.TROCO,
	V.DESCONTO,
	V.DATAPAGAMENTO,
	PE.PRIMEIRONOME,
	PE.SEGUNDONOME,
	PE.CPF,
	PE.EMAIL,
	PE.COMPLEMENTO,
	PE.NUMERO,
	PE.IDENDERECO_PK,
	PROD.PRODUTO,
	PROD.DESCRICAO,
	PROD.PRECO_UNITARIO,
	PROD.NCM,
	PROD.IDUNIDADE_PK,
	PROD.IDCATEGORIA_PK,
	E.CEP,
	E.ENDERECO,
	E.IDCIDADE_PK,
	C.CIDADE,
	E.IDBAIRRO_PK,
	B.BAIRRO,
	E.IDESTADO_PK,
	UF.ESTADO,
	CAT.CATEGORIA,
	U.UNIDADE,
	U.ABREVIACAO
FROM VENDAS V
	INNER JOIN PESSOAS PE ON V.IDPESSOA_PK = PE.IDPESSOA
	INNER JOIN PRODUTOS PROD ON V.IDPRODUTO_PK = PROD.IDPRODUTO
	INNER JOIN UNIDADES U ON PROD.IDUNIDADE_PK = U.IDUNIDADE
	INNER JOIN CATEGORIAS CAT ON PROD.IDUNIDADE_PK = CAT.IDCATEGORIA
	INNER JOIN ENDERECOS E ON PE.IDENDERECO_PK = E.IDENDERECO
	INNER JOIN CIDADES C ON E.IDCIDADE_PK = C.IDCIDADE
	INNER JOIN BAIRROS B ON E.IDCIDADE_PK = B.IDBAIRRO
	INNER JOIN ESTADOS UF ON E.IDCIDADE_PK = UF.IDESTADO
WHERE PROD.PRODUTO LIKE 1
-------------------------------------------------------------------------------