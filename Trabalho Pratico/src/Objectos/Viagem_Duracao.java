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

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public void setCod_viagem(int cod_viagem) {
		this.cod_viagem = cod_viagem;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public int getDuracao() {
		return duracao;
	}

	@Override
	public String toString() {
		return "Viagem_Duracao [cod_cliente=" + cod_cliente + ", cod_viagem=" + cod_viagem + ", duracao=" + duracao
				+ ", nome_cliente=" + nome_cliente + "]";
	}
	
}
