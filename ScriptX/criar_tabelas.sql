SET ECHO OFF

rem ====================================================================================================================================================================================================================================
rem ELIMINAR TABELAS EXISTENTES

drop table viagem_cidade;
drop table viagem;
drop table ligacao;
drop table Cidade_Roteiro;
drop table Cidade;
drop table cliente;
drop table Roteiro;

rem ====================================================================================================================================================================================================================================
rem CRIAR TABELAS

create table cliente (
    cod_cliente         NUMBER(7) NOT NULL CHECK(cod_cliente>=0),
    nome                VARCHAR2(30) NOT NULL CHECK(LENGTH(nome)>7),
    email               VARCHAR2(30) NOT NULL CHECK(email LIKE '%@%' AND email LIKE '%.%'),
    n_cont              NCHAR(9) NOT NULL UNIQUE CHECK(n_cont>=0 AND LENGTH(n_cont)=9),
    status_cliente       VARCHAR2,NOT NULL CHECK(status_cliente=='ACTIVO' OR status_cliente=='INACTIVO'),
    PRIMARY KEY (cod_cliente)
);
CREATE TABLE cidade (
    cod_cidade          NUMBER(7) NOT NULL CHECK(cod_cidade>=0),
    nome_cidade         VARCHAR2(20) NOT NULL CHECK(nome_cidade!=' '),
    PRIMARY KEY (cod_cidade)
);
CREATE TABLE CIDADE_ROTEIRO (
        cod_cidade      NUMBER(7) NOT NULL,
        cod_roteiro     NUMBER(7) NOT NULL,
        PRIMARY KEY (cod_cidade,cod_roteiro)
);
CREATE TABLE ROTEIRO (
    cod_roteiro         NUMBER(7) NOT NULL CHECK(cod_roteiro>=0),
    preco               NUMBER(8,2) NOT NULL CHECK(preco>=0),
    cd_partida          VARCHAR2(20) NOT NULL CHECK(cd_partida!=' '),
    cd_chegada          VARCHAR2(20) NOT NULL CHECK(cd_chegada!=' '),
    descricao           VARCHAR2(73) NOT NULL CHECK(descricao!=' '),
    PRIMARY KEY (cod_roteiro)
);
CREATE TABLE VIAGEM_CIDADE (
    cod_viagem          NUMBER (7) NOT NULL,
    cod_cidade          NUMBER (7) NOT NULL,
    PRIMARY KEY (cod_viagem,cod_cidade)
);
CREATE TABLE VIAGEM (
    cod_viagem          NUMBER(7) NOT NULL,
	cod_cliente         NUMBER(7) NOT NULL,
	cod_roteiro         Number(7) NOT NULL, 
    data_partida	    DATE NULL,
	data_chegada        DATE NULL,
	data_marcacao       DATE NULL,
    PRIMARY KEY (cod_viagem)
);
CREATE TABLE LIGACAO(
	cod_cidade          NUMBER(7) NOT NULL,
	cod_cidade1         NUMBER(7) NOT NULL,
	custo               NUMBER(8,2) NOT NULL CHECK(custo>=0),
	distancia           NUMBER(6,2) NOT NULL CHECK(distancia>=0),
    PRIMARY KEY (cod_cidade,cod_cidade1)
);

rem CHAVES ESTRANGEIRAS

ALTER TABLE VIAGEM
	ADD (FOREIGN KEY (cod_cliente) REFERENCES CLIENTE);
ALTER TABLE VIAGEM
	ADD (FOREIGN KEY (cod_roteiro) REFERENCES ROTEIRO);
		
ALTER TABLE LIGACAO
	ADD (FOREIGN KEY (cod_cidade) REFERENCES CIDADE);
ALTER TABLE LIGACAO
	ADD (FOREIGN KEY (cod_cidade1) REFERENCES CIDADE);	

ALTER TABLE CIDADE_ROTEIRO
        ADD (FOREIGN KEY (cod_cidade) REFERENCES CIDADE);
ALTER TABLE CIDADE_ROTEIRO
        ADD (FOREIGN KEY (cod_roteiro) REFERENCES ROTEIRO);

ALTER TABLE VIAGEM_CIDADE
        ADD (FOREIGN KEY (cod_viagem) REFERENCES VIAGEM);
ALTER TABLE VIAGEM_CIDADE
        ADD (FOREIGN KEY (cod_cidade) REFERENCES CIDADE);

rem ====================================================================================================================================================================================================================================
rem ELIMINAR SEQUENCIAS EXISTENTES

drop sequence id_cliente;
drop sequence id_cidade;
drop sequence id_roteiro;
drop sequence id_viagem;

rem ====================================================================================================================================================================================================================================
rem CRIAR SEQUENCIAS

CREATE SEQUENCE id_cliente
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999
NOCYCLE
NOCACHE;

CREATE SEQUENCE id_cidade
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999
NOCYCLE
NOCACHE;

CREATE SEQUENCE id_roteiro
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999
NOCYCLE
NOCACHE;

CREATE SEQUENCE id_viagem
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999
NOCYCLE
NOCACHE;

COMMIT;

SET ECHO ON
/