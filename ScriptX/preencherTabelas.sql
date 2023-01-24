SET ECHO OFF

ALTER SESSION SET NLS_DATE_FORMAT='YYYY.MM.DD';

rem ====================================================================================================================================================================================================================================
rem INSERINDO DADOS

INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Dylan Cassamo','dylancassamo@gmail.com',111111111,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Eugenio Refo Jr','eugeniorefojr@gmail.com',222222222,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Gilberto Botas Jr','gilbertbotasjr@gmail.com',333333333,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Lindsay Nhancale','lindsaynhancale@gmail.com',444444444,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Fred Cuambe','fredcuambe@gmail.com',555555555,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Bill Gray','billgray@gmail.com',666666666,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Edmilson Saiete','edmilsonsaiete@gmail.com',777777777,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Nadir Aboobacar','nadiraboobacar@gmail.com',888888888,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Edwin Cambe','edwincambe@gmail.com',999999999,'ACTIVO');
INSERT INTO cliente
    VALUES(id_cliente.NEXTVAL,'Sahba Samadi','sahbasamadi@gmail.com',110101010,'ACTIVO');

rem ====================================================================================================================================================================================================================================

INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Maputo');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Xai-Xai');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Inhambane');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Beira');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Chimoio');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Tete');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Quelimane');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Nampula');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Pemba');
INSERT INTO CIDADE
        VALUES(id_cidade.NEXTVAL,'Lichinga');

rem ====================================================================================================================================================================================================================================

INSERT INTO ligacao
        VALUES(1,2,560,216);
INSERT INTO ligacao
        VALUES(1,3,1200,480);
INSERT INTO ligacao
        VALUES(2,3,300,264);
INSERT INTO ligacao
        VALUES(3,4,600,662);
INSERT INTO ligacao
        VALUES(4,5,1000,200);
INSERT INTO ligacao
        VALUES(4,7,700,486);
INSERT INTO ligacao
        VALUES(5,6,550,388);
INSERT INTO ligacao
        VALUES(6,7,700,653);
INSERT INTO ligacao
        VALUES(7,8,800,548);
INSERT INTO ligacao
        VALUES(8,9,300,404);
INSERT INTO ligacao
        VALUES(9,10,500,826);
INSERT INTO ligacao
        VALUES(7,10,1200,785);

rem ====================================================================================================================================================================================================================================

INSERT INTO Roteiro
        VALUES(id_roteiro.NEXTVAL,'Maputo','Pemba');
INSERT INTO Roteiro
        VALUES(id_roteiro.NEXTVAL,'Maputo','Tete');
INSERT INTO Roteiro
        VALUES(id_roteiro.NEXTVAL,'Maputo','Lichinga');
INSERT INTO Roteiro
        VALUES(id_roteiro.NEXTVAL,'Pemba','Tete');
INSERT INTO Roteiro
        VALUES(id_roteiro.NEXTVAL,'Tete','Maputo');

rem ====================================================================================================================================================================================================================================

INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,1,1,'2021.04.14','2021.04.28','2021.01.31','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,2,2,'2023.01.01','2023.02.26','2022.12.20','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,2,3,'2021.03.28','2021.04.13','2021.02.20','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,3,4,'2024.12.19','2025.01.16','2021.10.25','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,3,5,'2020.07.30','2020.09.29','2020.04.30','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,4,5 ,'2024.01.04','2024.02.22','2022.12.02','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,4,1,'2019.06.04','2019.08.12','2019.04.20','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,4,1,'2022.06.04','2022.06.30','2022.04.25','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,5,2,'2022.06.04','2022.06.30','2022.04.12','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,6,2,'2022.12.04','2023.02.23','2022.07.01','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,7,3,'2021.09.24','2021.12.24','2021.05.26','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,8,4,'2018.06.04','2018.08.04','2018.05.16','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,9,4,'2018.06.04','2018.08.04','2018.05.16','PENDENTE');
INSERT INTO VIAGEM
    VALUES(id_viagem.NEXTVAL,10,4,'2018.06.04','2018.08.04','2018.05.16','PENDENTE');

rem ====================================================================================================================================================================================================================================

INSERT INTO CIDADE_ROTEIRO
    VALUES(1,1);
INSERT INTO CIDADE_ROTEIRO
    VALUES(1,2);
INSERT INTO CIDADE_ROTEIRO
    VALUES(1,3);
INSERT INTO CIDADE_ROTEIRO
    VALUES(1,5);
INSERT INTO CIDADE_ROTEIRO
    VALUES(2,1);
INSERT INTO CIDADE_ROTEIRO
    VALUES(2,2);
INSERT INTO CIDADE_ROTEIRO
    VALUES(2,5);
INSERT INTO CIDADE_ROTEIRO
    VALUES(3,1);
INSERT INTO CIDADE_ROTEIRO
    VALUES(3,2);
INSERT INTO CIDADE_ROTEIRO
    VALUES(3,3);
INSERT INTO CIDADE_ROTEIRO
    VALUES(3,5);
INSERT INTO CIDADE_ROTEIRO
    VALUES(4,1);
INSERT INTO CIDADE_ROTEIRO
    VALUES(4,2);
INSERT INTO CIDADE_ROTEIRO
    VALUES(4,3);
INSERT INTO CIDADE_ROTEIRO
    VALUES(4,5);
INSERT INTO CIDADE_ROTEIRO
    VALUES(5,5);
INSERT INTO CIDADE_ROTEIRO
    VALUES(6,2);
INSERT INTO CIDADE_ROTEIRO
    VALUES(6,4);
INSERT INTO CIDADE_ROTEIRO
    VALUES(6,5);
INSERT INTO CIDADE_ROTEIRO
    VALUES(7,1);
INSERT INTO CIDADE_ROTEIRO
    VALUES(7,2);
INSERT INTO CIDADE_ROTEIRO
    VALUES(7,3);
INSERT INTO CIDADE_ROTEIRO
    VALUES(7,4);
INSERT INTO CIDADE_ROTEIRO
    VALUES(8,1);
INSERT INTO CIDADE_ROTEIRO
    VALUES(8,4);
INSERT INTO CIDADE_ROTEIRO
    VALUES(9,1);
INSERT INTO CIDADE_ROTEIRO
    VALUES(9,4);
INSERT INTO CIDADE_ROTEIRO
    VALUES(10,3);

rem ====================================================================================================================================================================================================================================

INSERT INTO viagem_cidade
    VALUES(1,1);
INSERT INTO viagem_cidade
    VALUES(1,2);
INSERT INTO viagem_cidade
    VALUES(1,3);
INSERT INTO viagem_cidade
    VALUES(1,4);
INSERT INTO viagem_cidade
    VALUES(1,7);
INSERT INTO viagem_cidade
    VALUES(1,8);
INSERT INTO viagem_cidade
    VALUES(1,9);
INSERT INTO viagem_cidade
    VALUES(2,1);
INSERT INTO viagem_cidade
    VALUES(2,2);
INSERT INTO viagem_cidade
    VALUES(2,3);
INSERT INTO viagem_cidade
    VALUES(2,4);
INSERT INTO viagem_cidade
    VALUES(2,7);
INSERT INTO viagem_cidade
    VALUES(2,6);
INSERT INTO viagem_cidade
    VALUES(3,1);
INSERT INTO viagem_cidade
    VALUES(3,3);
INSERT INTO viagem_cidade
    VALUES(3,4);
INSERT INTO viagem_cidade
    VALUES(3,7);
INSERT INTO viagem_cidade
    VALUES(3,10);
INSERT INTO viagem_cidade
    VALUES(4,9);
INSERT INTO viagem_cidade
    VALUES(4,8);
INSERT INTO viagem_cidade
    VALUES(4,7);
INSERT INTO viagem_cidade
    VALUES(4,6);
INSERT INTO viagem_cidade
    VALUES(5,6);
INSERT INTO viagem_cidade
    VALUES(5,5);
INSERT INTO viagem_cidade
    VALUES(5,4);
INSERT INTO viagem_cidade
    VALUES(5,3);
INSERT INTO viagem_cidade
    VALUES(5,2);
INSERT INTO viagem_cidade
    VALUES(5,1);
INSERT INTO viagem_cidade
    VALUES(6,6);
INSERT INTO viagem_cidade
    VALUES(6,5);
INSERT INTO viagem_cidade
    VALUES(6,4);
INSERT INTO viagem_cidade
    VALUES(6,3);
INSERT INTO viagem_cidade
    VALUES(6,2);
INSERT INTO viagem_cidade
    VALUES(6,1);
INSERT INTO viagem_cidade
    VALUES(7,1);
INSERT INTO viagem_cidade
    VALUES(7,2);
INSERT INTO viagem_cidade
    VALUES(7,3);
INSERT INTO viagem_cidade
    VALUES(7,4);
INSERT INTO viagem_cidade
    VALUES(7,7);
INSERT INTO viagem_cidade
    VALUES(7,8);
INSERT INTO viagem_cidade
    VALUES(7,9);
INSERT INTO viagem_cidade
    VALUES(8,1);
INSERT INTO viagem_cidade
    VALUES(8,2);
INSERT INTO viagem_cidade
    VALUES(8,3);
INSERT INTO viagem_cidade
    VALUES(8,4);
INSERT INTO viagem_cidade
    VALUES(8,7);
INSERT INTO viagem_cidade
    VALUES(8,8);
INSERT INTO viagem_cidade
    VALUES(8,9);
INSERT INTO viagem_cidade
    VALUES(9,1);
INSERT INTO viagem_cidade
    VALUES(9,2);
INSERT INTO viagem_cidade
    VALUES(9,3);
INSERT INTO viagem_cidade
    VALUES(9,4);
INSERT INTO viagem_cidade
    VALUES(9,7);
INSERT INTO viagem_cidade
    VALUES(9,6);
INSERT INTO viagem_cidade
    VALUES(10,1);
INSERT INTO viagem_cidade
    VALUES(10,2);
INSERT INTO viagem_cidade
    VALUES(10,3);
INSERT INTO viagem_cidade
    VALUES(10,4);
INSERT INTO viagem_cidade
    VALUES(10,7);
INSERT INTO viagem_cidade
    VALUES(10,6);
INSERT INTO viagem_cidade
    VALUES(11,1);
INSERT INTO viagem_cidade
    VALUES(11,3);
INSERT INTO viagem_cidade
    VALUES(11,4);
INSERT INTO viagem_cidade
    VALUES(11,7);
INSERT INTO viagem_cidade
    VALUES(11,10);
INSERT INTO viagem_cidade
    VALUES(12,9);
INSERT INTO viagem_cidade
    VALUES(12,8);
INSERT INTO viagem_cidade
    VALUES(12,7);
INSERT INTO viagem_cidade
    VALUES(12,6);
INSERT INTO viagem_cidade
    VALUES(13,9);
INSERT INTO viagem_cidade
    VALUES(13,8);
INSERT INTO viagem_cidade
    VALUES(13,7);
INSERT INTO viagem_cidade
    VALUES(13,6);
INSERT INTO viagem_cidade
    VALUES(14,9);
INSERT INTO viagem_cidade
    VALUES(14,8);
INSERT INTO viagem_cidade
    VALUES(14,7);
INSERT INTO viagem_cidade
    VALUES(14,6);

rem ====================================================================================================================================================================================================================================

INSERT INTO ligacao_roteiro
    VALUES(1,1,2);
INSERT INTO ligacao_roteiro
    VALUES(1,2,3);
INSERT INTO ligacao_roteiro
    VALUES(1,3,4);
INSERT INTO ligacao_roteiro
    VALUES(1,4,7);
INSERT INTO ligacao_roteiro
    VALUES(1,7,8);

INSERT INTO ligacao_roteiro
    VALUES(2,1,2);
INSERT INTO ligacao_roteiro
    VALUES(2,2,3);
INSERT INTO ligacao_roteiro
    VALUES(2,3,4);
INSERT INTO ligacao_roteiro
    VALUES(2,4,7);
INSERT INTO ligacao_roteiro
    VALUES(2,6,7);

INSERT INTO ligacao_roteiro
    VALUES(3,1,3);
INSERT INTO ligacao_roteiro
    VALUES(3,3,4);
INSERT INTO ligacao_roteiro
    VALUES(3,4,7);
INSERT INTO ligacao_roteiro
    VALUES(3,7,10);

INSERT INTO ligacao_roteiro
    VALUES(4,6,7);
INSERT INTO ligacao_roteiro
    VALUES(4,7,8);
INSERT INTO ligacao_roteiro
    VALUES(4,8,9);

INSERT INTO ligacao_roteiro
    VALUES(5,1,2);
INSERT INTO ligacao_roteiro
    VALUES(5,2,3);
INSERT INTO ligacao_roteiro
    VALUES(5,3,4);
INSERT INTO ligacao_roteiro
    VALUES(5,4,5);
INSERT INTO ligacao_roteiro
    VALUES(5,5,6);


COMMIT;

SET ECHO ON
/