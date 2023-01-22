package Objectos;
public class Cidade
{
	private int cod_cidade;
	private String nome_cidade;
	
	public Cidade(int cod_cidade, String nome_cidade) {
		this.cod_cidade = cod_cidade;
		this.nome_cidade = nome_cidade;
	}
	
	public int getCod_cidade() {
		return cod_cidade;
	}
	
	public String getNome_cidade() {
		return nome_cidade;
	}
	
	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}
}
