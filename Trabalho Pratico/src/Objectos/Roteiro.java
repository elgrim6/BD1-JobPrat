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

	public String getCd_partida() {
		return cd_partida;
	}

	public String getCd_chegada() {
		return cd_chegada;
	}
}
