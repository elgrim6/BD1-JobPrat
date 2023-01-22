package Objectos;

public class Cliente_Datas
{
	private int cod_cliente,cod_viagem;
	private String nome,data_partida,data_chegada,data_marcacao;
	
	public Cliente_Datas(int cod_cliente, String nome, int cod_viagem, String data_partida, String data_chegada, String data_marcacao) {
		super();
		this.cod_cliente = cod_cliente;
		this.nome = nome;
		this.cod_viagem=cod_viagem;
		this.data_partida = data_partida;
		this.data_chegada = data_chegada;
		this.data_marcacao = data_marcacao;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public String getNome() {
		return nome;
	}

	public int getCod_viagem() {
		return cod_viagem;
	}
	
	public String getData_partida() {
		return data_partida;
	}

	public String getData_chegada() {
		return data_chegada;
	}

	public String getData_marcacao() {
		return data_marcacao;
	}
}
