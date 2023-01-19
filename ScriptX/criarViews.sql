

CREATE OR REPLACE VIEW viagem_duracao
    AS
        select cod_viagem,(data_chegada-data_partida) "duracao (Dias)"
        from viagem;

CREATE OR REPLACE VIEW cidade_quant
    AS
        select cidade.nome_cidade, count (viagem_cidade.cod_cidade) nrviagens 
        from cidade, viagem_cidade 
        where cidade.cod_cidade = viagem_cidade.cod_cidade 
        group by cidade.nome_cidade;
        
CREATE OR REPLACE VIEW nome_preco
    AS
        select cliente.cod_cliente,cliente.nome,roteiro.preco
        from cliente, viagem, roteiro
        where cliente.cod_cliente=viagem.cod_cliente AND viagem.cod_roteiro=roteiro.cod_roteiro;
        
CREATE OR REPLACE VIEW cliente_datas
    AS
        SELECT c.cod_cliente,c.nome,v.data_partida,v.data_chegada,v.data_marcacao
        FROM cliente c,viagem v
        WHERE c.cod_cliente=v.cod_cliente;