SET ECHO OFF

rem ====================================================================================================================================================================================================================================
rem CRIAR TRIGGERS

set serveroutput on;

CREATE OR REPLACE TRIGGER before_insert_cliente
BEFORE UPDATE OR INSERT ON Cliente
FOR EACH row
DECLARE newCont NCHAR; any_rows_found NUMBER ;

BEGIN
    
    select count(n_cont) into  any_rows_found from  cliente where n_cont=:new.n_cont;
    
    IF any_rows_found=1 then
        raise_application_error(-20000,'ERRO:Numero de Contribuinte ja existe');
        dbms_output.put_line('ERRO:Numero de Contribuinte ja existe');
    END IF;

END;
/
CREATE OR REPLACE TRIGGER before_insert_viagem
BEFORE UPDATE OR INSERT ON VIAGEM
FOR EACH row
DECLARE newPart DATE; newCheg DATE;newMarc DATE;

BEGIN
    
    IF :new.data_partida<:new.data_marcacao OR :new.data_marcacao>:new.data_chegada OR :new.data_partida>:new.data_chegada then
        raise_application_error(-20000,'ERRO:Verfique as datas de partida e entrada');
        dbms_output.put_line('ERRO:Verfique as datas de partida e entrada');
    ELSE
    	dbms_output.put_line('Viagem adicionada com sucesso');
    END IF;

END;
