package Objectos;
public class Roteiro
{
	private int cod_roteiro;
	private float preco;
	private String cd_partida,cd_chegada,descricao;
	
	public Roteiro(int cod_roteiro, float preco, String cd_partida, String cd_chegada, String descricao) {
		this.cod_roteiro = cod_roteiro;
		this.preco = preco;
		this.cd_partida = cd_partida;
		this.cd_chegada = cd_chegada;
		this.descricao = descricao;
	}

	public int getCod_roteiro() {
		return cod_roteiro;
	}

	public void setCod_roteiro(int cod_roteiro) {
		this.cod_roteiro = cod_roteiro;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getCd_partida() {
		return cd_partida;
	}

	public void setCd_partida(String cd_partida) {
		this.cd_partida = cd_partida;
	}

	public String getCd_chegada() {
		return cd_chegada;
	}

	public void setCd_chegada(String cd_chegada) {
		this.cd_chegada = cd_chegada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Roteiro [cod_roteiro=" + cod_roteiro + ", preco=" + preco + ", cd_partida=" + cd_partida
				+ ", cd_chegada=" + cd_chegada + ", descricao=" + descricao + "]";
	}
}
