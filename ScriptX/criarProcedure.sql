CREATE OR REPLACE Procedure statusViagem
   ( cod IN NUMBER )

IS
   partida DATE;chegada DATE;stats VARCHAR2(10);

BEGIN
    select data_partida INTO partida from viagem where cod_viagem=cod;
    select data_chegada INTO chegada from viagem where cod_viagem=cod;
    select status INTO stats from viagem where cod_viagem=cod;
    
    if(stats!='CANCELADA') then
        if(partida>SYSDATE)then
             UPDATE viagem SET status='PENDENTE' where cod_viagem=cod;
        elsif(chegada>SYSDATE) then
            UPDATE viagem SET status='DECORRENDO' where cod_viagem=cod;
        else
            UPDATE viagem SET status='TERMINADA' where cod_viagem=cod;
        end if;
    end if;

   commit;
END;