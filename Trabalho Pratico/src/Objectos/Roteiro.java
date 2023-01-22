package Objectos;
public class Roteiro
{
	private int cod_roteiro;
	private String cd_partida,cd_chegada;
	
	public Roteiro(int cod_roteiro, String cd_partida, String cd_chegada) {
		this.cod_roteiro = cod_roteiro;
		this.cd_partida = cd_partida;
		this.cd_chegada = cd_chegada;
	}

	public int getCod_roteiro() {
		return cod_roteiro;
	}

	public void setCod_roteiro(int cod_roteiro) {
		this.cod_roteiro = cod_roteiro;
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

	@Override
	public String toString() {
		return "Roteiro [cod_roteiro=" + cod_roteiro + ", cd_partida=" + cd_partida
				+ ", cd_chegada=" + cd_chegada + "]";
	}
}
