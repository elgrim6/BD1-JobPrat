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
	
	//METODO PARA CALCULAR O NUMERO TOTAL DE DIAS NA DATA DO TESTE
	public long calcularDias(String data)
	{
		short ano=Short.parseShort(data.substring(6,10));
		byte mes=Byte.parseByte(data.substring(3,5));
		byte dia=Byte.parseByte(data.substring(0,2));
		
		return (long)(ano*365+mes*30+dia);
	}
	
	//METODO PARA SABER SE O ANO EM QUE O TESTE FOI FEITO E BISSEXTO OU NAO
	public boolean calcularBissexto(short ano)
	{
		if((ano%4==0&&ano%100!=0)||(ano%400==0&&ano%100==0))
			return true;
		else
			return false;
		
	}

	//METODO PARA CALCULAR A DATA LIMITE DE UM MES
	public byte calcularDataLimite(byte mes,boolean bissexto)
	{
		if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
			return 31;
		else
		{
			if(mes==4||mes==6||mes==9||mes==11)
				return 30;
			else
			{
				if(mes==2&&bissexto==true)
					return 29;
				else
					return 28;
			}
		}
	}
	
}
