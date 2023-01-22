package Objectos;

public class Cliente 
{
	private int cod_cliente,n_cont;
	private String nome,email,status;
	
	public Cliente(int cod_cliente, String nome, String email, int n_cont, String status) {
		this.cod_cliente = cod_cliente;
		this.n_cont = n_cont;
		this.nome = nome;
		this.email = email;
		this.status=status;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public int getN_cont() {
		return n_cont;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}
}
