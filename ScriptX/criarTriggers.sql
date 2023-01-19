drop trigger after_elimin_cliente;
drop trigger trigger_data_partida;

set serveroutput on format wrapped;

rem ====================================================================================================================================================================================================================================
rem CRIAR TRIGGERS

CREATE OR REPLACE TRIGGER after_elimin_cliente
AFTER DELETE 
ON cliente FOR EACH ROW
BEGIN
    DELETE FROM viagem v
    WHERE v.cod_cliente=Old.cliente.cod_cliente;
END;

/

CREATE OR REPLACE TRIGGER trigger_data_partida
BEFORE INSERT 
ON VIAGEM FOR EACH ROW
DECLARE data_part DATE; data_marc DATE;
BEGIN
    If data_part < data_marc THEN
        DBMS_OUTPUT.put_line('error X');
    END if;
END;

/