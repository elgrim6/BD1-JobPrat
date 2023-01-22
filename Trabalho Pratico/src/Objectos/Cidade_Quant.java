package Objectos;

public class Cidade_Quant 
{
	private String nome_cidade;
	private int nr_viagens;
	
	public Cidade_Quant(String nome_cidade, int nr_viagens) {
		super();
		this.nome_cidade = nome_cidade;
		this.nr_viagens = nr_viagens;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public int getNr_viagens() {
		return nr_viagens;
	}
}
