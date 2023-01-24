package Operacoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Validacoes
{
	Calculos c;
	
	public Validacoes()
	{
		c=new Calculos();
	}
	
	//METODO PARA VALIDAR DATA
	public boolean validarData(short ano,byte mes,byte dia)
	{
		boolean bissexto;
		boolean passou=false;
		
		bissexto=c.calcularBissexto(ano);
		
		passou=validarMesDia(mes,dia,bissexto);
		
		return passou;
	}
	
	//METODO PARA COMPARAR AS DUAS DATAS
	public String validarDuasDatas(String data1,String data2)
	{
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date d1=null;
		Date d2=null;
		String datamaior="";
		
		try
		{
			d1 = sdformat.parse(data1);
			d2 = sdformat.parse(data2);
		}
		catch(ParseException r) {}
	    
	    if(d1.compareTo(d2) > 0)
	    {
	    	datamaior=data1;
	    }
	    else 
	    {
	    	if(d1.compareTo(d2) < 0)
	    	{
	    		datamaior=data2;
	    	}
	    	else 
	    	{
	    		if(d1.compareTo(d2) == 0)
	    		{
	    			datamaior="";
	    		}
	    	}
	    }
	    
	    return datamaior;
	}
	
	//METODO PARA VALIDAR MES
	public boolean validarMesDia(byte mes,byte dia,boolean bissexto)
	{
		if(dia<=c.calcularDataLimite(mes,bissexto))
			return true;
		else
			return false;
	}
	
}
