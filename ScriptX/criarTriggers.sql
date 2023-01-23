drop trigger after_elimin_cliente;
drop trigger trigger_data_partida;

set serveroutput on format wrapped;

rem ====================================================================================================================================================================================================================================
rem CRIAR TRIGGERS

set serveroutput on;

CREATE OR REPLACE TRIGGER before_insert_cliente
BEFORE UPDATE OR INSERT ON Cliente
FOR EACH row
DECLARE nCont NCHAR;

BEGIN
    SELECT o.n_cont
    INTO nCont
    FROM Cliente o
    WHERE o.cod_cliente = :new.cod_cliente;
    
    IF Select n_cont from cliente where n_cont=nCont !=null then
		dbms_output.put_line('ERRO:Numero de Contribuinte ja existe');
    //raise_application_error(-20002,('Data de entrega Invalida'));
    ELSE
    	dbms_output.put_line('Data de entrega foi alterada com sucesso.');
    
ELSE
    

END;/

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