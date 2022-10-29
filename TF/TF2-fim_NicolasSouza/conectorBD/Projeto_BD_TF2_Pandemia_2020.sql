-- ----------------     << PANDEMIA >>     --------------------
--
--                    SCRIPT DO TRABALHO FINAL
--
-- Data Criacao ...........: 20/11/2020
-- Autor(es) ..............: Vandor Rissoli
-- Banco de Dados .........: MySQL 8
-- Banco de Dados(nome) ...: pandemia
--
--
-- PROJETO => 01 Base de Dados
--         => 01 Tabela
-- ------------------------------------------------------------

-- BASE DE DADOS
CREATE DATABASE
 IF NOT EXISTS pandemia;

USE pandemia;


-- TABELA
CREATE TABLE pessoa (
  idPessoa INT                   NOT NULL AUTO_INCREMENT,
	nome     VARCHAR(90)           NOT NULL,
  saude    ENUM('T','F','C','S') NOT NULL,
	gestante ENUM('S','N','T')     DEFAULT NULL,
  idade    INT                   DEFAULT NULL,
 CONSTRAINT PESSOA_PK PRIMARY KEY (idPessoa)
)ENGINE InnoDB AUTO_INCREMENT = 101;



-- AJUDA COM LINGUAGEM SQL PARA MYSQL
-- ==================================

-- Instrucao que APAGA a estrutura de cadastrar PESSOA,
-- mas precisa retirar o indicador de comentario (--)
-- da linha abaixo
--   DROP TABLE pessoa;


-- Instrucao que INSERI UM cadastro de PESSOA,mas que
-- precisa retirar o indicador de comentario das linhas
--   INSERT PESSOA (nome, saude, gestante, idade) VALUES
--    ('Jose Carlos','T',null,12);


-- Instrucao que REMOVE todos os cadastros de PESSOA,mas
-- que precisa retirar o indicador de comentario da linha
--   DELETE FROM PESSOA;


-- Instrucao que RECUPERA todos os cadastros de PESSOA,
-- mas precisa retirar o indicador de comentario da Linha
--   SELECT * FROM PESSOA;


-- Instrucao que CONSULTA uma UNICA PESSOA cadastrada,
-- por seu numero IDENTIFICADOR, mas precisa retirar o
-- indicador de comentario das linhas e fornecer o
-- identificador desejado que como exemplo esta 102
--   SELECT * FROM PESSOA
--    WHERE idPessoa = 102;

