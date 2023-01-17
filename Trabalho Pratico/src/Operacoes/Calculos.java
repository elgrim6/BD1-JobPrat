package Operacoes;
import java.util.ArrayList;
import Database.Queries;
import Objectos.Viagem;

public class Calculos
{
	public Calculos() {}
	
	//metodo para calcular o lucro da empresa
	public float calcularLucro()
	{
		float lucro=0;
		
		Queries q=new Queries();
		ArrayList<Object> array=q.todasViagens();
		
		for(int a=0;a<array.size();a++)
		{
			lucro+=((Viagem) array.get(a)).getPreco();
		}
		
		return lucro;
	}
}
