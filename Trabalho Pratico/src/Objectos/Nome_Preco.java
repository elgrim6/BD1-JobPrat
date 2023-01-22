package Objectos;
import Database.Queries;

public class Nome_Preco
{
	private int cod_cliente,cod_roteiro;
	private String nome;
	private float preco;
	private Queries q;
	
	public Nome_Preco(int cod_cliente, String nome, int cod_roteiro) {
		super();
		q=new Queries();
		this.cod_cliente = cod_cliente;
		this.nome = nome;
		this.cod_roteiro = cod_roteiro;
		this.preco=q.precoRoteiro(cod_roteiro);
	}

	public int getCod_cliente() {
		return cod_cliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCod_roteiro() {
		return cod_roteiro;
	}

	public float getPreco() {
		return preco;
	}

}
