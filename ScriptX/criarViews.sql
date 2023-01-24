
SET ECHO OFF
CREATE OR REPLACE VIEW viagem_duracao
    AS
        select v.cod_cliente,c.nome,v.cod_viagem,(v.data_chegada-v.data_partida) duracao
		from viagem v,cliente c
		where c.cod_cliente=v.cod_cliente and v.status!='CANCELADA';

CREATE OR REPLACE VIEW cidade_quant
    AS
        select cidade.nome_cidade, count (viagem_cidade.cod_cidade) nrviagens 
        from cidade, viagem_cidade , viagem
        where cidade.cod_cidade = viagem_cidade.cod_cidade AND viagem.cod_viagem=viagem_cidade.cod_viagem AND viagem.status='TERMINADA'
        group by cidade.nome_cidade;
        
CREATE OR REPLACE VIEW nome_preco
    AS
        select cliente.cod_cliente,cliente.nome,roteiro.cod_roteiro
        from cliente, viagem, roteiro
        where cliente.cod_cliente=viagem.cod_cliente AND viagem.cod_roteiro=roteiro.cod_roteiro AND viagem.status!='CANCELADA';
        
CREATE OR REPLACE VIEW cliente_datas
    AS
        SELECT c.cod_cliente,c.nome,v.cod_viagem,v.data_partida,v.data_chegada,v.data_marcacao
        FROM cliente c,viagem v
        WHERE c.cod_cliente=v.cod_cliente AND v.status!='DECORRENDO';