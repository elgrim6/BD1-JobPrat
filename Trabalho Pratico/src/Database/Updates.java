package Database;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import Objectos.*;
import Operacoes.Validacoes;

public class Updates 
{
	private Queries q;
	private Validacoes val;
	
	public Updates()
	{
		q=new Queries();
		val=new Validacoes();
	}
	
	//metodo para alterar estado da conta de um cliente
	public static void alterarEstado(String x, int cod)
	{
		String sql="UPDATE Cliente SET status_cliente='"+x+"' where cod_cliente="+cod;
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			ps.executeQuery(sql);
		}
		catch(SQLException s)
		{
			JOptionPane.showMessageDialog(null,s.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//metodo para alterar dados do cliente
	public static boolean alterarCliente(int cod_cliente,String nome,String email,String n_cont,String status_c)
	{
		
		String sql="UPDATE cliente SET nome='"+nome+"', email='"+email+"', "
				+ "n_cont='"+n_cont+"',status_cliente='"+status_c+"'\n"
				+"WHERE cod_cliente="+cod_cliente;
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			ps.executeQuery(sql);
		}
		catch(SQLException s)
		{
			JOptionPane.showMessageDialog(null,s.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	//metodo para alterar dados do cliente
	public static boolean alterarViagem(int cod_viagem,int cod_cliente,int cod_roteiro,String data_partida, String data_chegada,String data_marcacao)
	{
		String sql="UPDATE viagem SET cod_cliente="+cod_cliente+", cod_roteiro="+cod_roteiro+", data_partida='"+data_partida+"', data_chegada='"+data_chegada+"', data_marcacao='"+data_marcacao+"' "
				+"WHERE cod_viagem="+cod_viagem;
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			ps.executeQuery(sql);
		}
		catch(SQLException s)
		{
			JOptionPane.showMessageDialog(null,s.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	public boolean cancelarViagem(int cod)
	{
		String sql="UPDATE viagem SET status='CANCELADA' where cod_viagem="+cod;
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			ps.executeQuery(sql);
		}
		catch(SQLException s)
		{
			JOptionPane.showMessageDialog(null,s.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean updateViagem(int cod,String status)
	{
		String sql="UPDATE viagem SET status='"+status+"' where cod_viagem="+cod;
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			ps.executeQuery(sql);
		}
		catch(SQLException s)
		{
			JOptionPane.showMessageDialog(null,s.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
//	public void updateAllViagens()
//	{
//		ArrayList<Object> array=q.todasViagens();
//		
//		for(int a=0;a<array.size();a++)
//		{
//			Viagem v=(Viagem)array.get(a);
//			if(!v.getStatus().equals("CANCELADA"))
//			{
//				String current_Status=val.validarStatus(v.getData_partida().toString(),v.getData_chegada().toString(),v.getStatus());
//				updateViagem(v.getCod_viagem(),current_Status);
//			}
//			
//		}
//	}
	
	public boolean updateAllViagens()
	{
		ArrayList<Object> array=q.todasViagens();
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			for(int a=0;a<array.size();a++)
			{
				Viagem v=(Viagem)array.get(a);
				String sql="CALL STATUSVIAGEM("+v.getCod_viagem()+")";
				ps.execute(sql);
			}
		}
		catch(SQLException s)
		{
			JOptionPane.showMessageDialog(null,s.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
