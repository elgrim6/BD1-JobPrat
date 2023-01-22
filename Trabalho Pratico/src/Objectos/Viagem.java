package Objectos;

import java.util.Date;

import Database.Queries;

public class Viagem
{
	private int cod_viagem,cod_cliente,cod_roteiro;
	private Date data_partida,data_chegada,data_marcacao;
	
	public Viagem(int cod_viagem, int cod_cliente, int cod_roteiro, Date data_partida, Date data_chegada,
			Date data_marcacao) {
		this.cod_viagem = cod_viagem;
		this.cod_cliente = cod_cliente;
		this.cod_roteiro = cod_roteiro;
		this.data_partida = data_partida;
		this.data_chegada = data_chegada;
		this.data_marcacao = data_marcacao;
	}

	public int getCod_viagem() {
		return cod_viagem;
	}

	public void setCod_viagem(int cod_viagem) {
		this.cod_viagem = cod_viagem;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public int getCod_roteiro() {
		return cod_roteiro;
	}

	public void setCod_roteiro(int cod_roteiro) {
		this.cod_roteiro = cod_roteiro;
	}

	public Date getData_partida() {
		return data_partida;
	}

	public void setData_partida(Date data_partida) {
		this.data_partida = data_partida;
	}

	public Date getData_chegada() {
		return data_chegada;
	}

	public void setData_chegada(Date data_chegada) {
		this.data_chegada = data_chegada;
	}

	public Date getData_marcacao() {
		return data_marcacao;
	}

	public void setData_marcacao(Date data_marcacao) {
		this.data_marcacao = data_marcacao;
	}
	
	//metodo para buscar o preco da viagem
	public float getPreco()
	{
		Queries q=new Queries();
		
		return q.getPrecoViagem(cod_viagem);
	}

	@Override
	public String toString() {
		return "Viagem [cod_viagem=" + cod_viagem + ", cod_cliente=" + cod_cliente + ", cod_roteiro=" + cod_roteiro
				+ ", data_partida=" + data_partida + ", data_chegada=" + data_chegada + ", data_marcacao="
				+ data_marcacao + "]";
	}
}
