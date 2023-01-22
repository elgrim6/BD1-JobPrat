package Objectos;

public class Viagem_Duracao
{
	private int cod_cliente,cod_viagem,duracao;
	private String nome_cliente;

	public Viagem_Duracao(int cod_cliente, String nome_cliente,int cod_viagem, int duracao) {
		super();
		this.cod_cliente=cod_cliente;
		this.nome_cliente=nome_cliente;
		this.cod_viagem = cod_viagem;
		this.duracao = duracao;
	}

	public int getCod_viagem() {
		return cod_viagem;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public int getDuracao() {
		return duracao;
	}
}
