package Database;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import Interfaces_Graficas.Visualizacoes;
import Objectos.*;

public class Queries
{
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
	
	public Queries() {}
	
	//metodo para retornar 1 cliente pelo codigo
	public static Object umClientes(int cod)
	{
		
		String sql="select * from CLIENTE where cod_cliente="+cod;
		Object obj=null;
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				int cod_cliente=rs.getInt(1);
				String nome=rs.getString(2);
				String email=rs.getString(3);
				int n_cont=rs.getInt(4);
				String status=rs.getString(5);
				
				obj=new Cliente(cod_cliente,nome,email,n_cont,status);
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return obj;
	}
	
	//metodo para retornar todos clientes
	public static ArrayList<Object> todosClientes()
	{
		String sql="select * from CLIENTE order by 1";
		ArrayList<Object> array=new ArrayList<>();
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				int cod_cliente=rs.getInt(1);
				String nome=rs.getString(2);
				String email=rs.getString(3);
				int n_cont=rs.getInt(4);
				String status=rs.getString(5);
				
				array.add(new Cliente(cod_cliente,nome,email,n_cont,status));
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return array;
	}
	
	//metodo para retornar todas cidades
	public ArrayList<Object> todosRoteiros()
	{
		String sql="select * from roteiro";
		ArrayList<Object> array=new ArrayList<>();
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				int cod_roteiro=rs.getInt(1);
				String cd_partida=rs.getString(2);
				String cd_chegada=rs.getString(3);
				
				array.add(new Roteiro(cod_roteiro,cd_partida,cd_chegada));
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return array;
	}
	
	//metodo para retornar todas cidades
	public ArrayList<Object> todasCidades()
	{
		String sql="select * from cidade";
		ArrayList<Object> array=new ArrayList<>();
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				int cod_cidade=rs.getInt(1);
				String nome_cidade=rs.getString(2);
				
				array.add(new Cidade(cod_cidade,nome_cidade));
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return array;
	}
	
	//metodo para retornar todas cidades
	public static ArrayList<Object> todasViagens()
	{
		String sql="select * from viagem";
		ArrayList<Object> array=new ArrayList<>();
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				int cod_viagem=rs.getInt(1);
				int cod_cliente=rs.getInt(2);
				int cod_roteiro=rs.getInt(3);
				Date data_partida=rs.getDate(4);
				Date data_chegada=rs.getDate(5);
				Date data_marcacao=rs.getDate(6);
				
				array.add(new Viagem(cod_viagem,cod_cliente,cod_roteiro,data_partida,data_chegada,data_marcacao));
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return array;
	}
	
	
	//metodo para retornar cidades pelo codigo de cliente
		public static ArrayList<Object> viagensCliente(int cod)
		{
			String sql="select * from viagem where cod_cliente="+cod;
			ArrayList<Object> array=new ArrayList<>();
			
			try
			{
				var ps=Connections.getConexao().createStatement(); 
				
				var rs=ps.executeQuery(sql);
				
				while(rs.next())
				{
					int cod_viagem=rs.getInt(1);
					int cod_cliente=rs.getInt(2);
					int cod_roteiro=rs.getInt(3);
					Date data_partida=rs.getDate(4);
					Date data_chegada=rs.getDate(5);
					Date data_marcacao=rs.getDate(6);
					
					array.add(new Viagem(cod_viagem,cod_cliente,cod_roteiro,data_partida,data_chegada,data_marcacao));
				}
			}
			catch(SQLException s)
			{
				System.out.println(s.getMessage());
			}
			
			return array;
		}
	
	//metodo para verificar se existe apanhar um cliente com o codigo x
	public boolean getCodCliente(int cod)
	{
		try
		{
			String sql="Select cod_cliente from cliente where cod_cliente=?";
			PreparedStatement ps=Connections.getConexao().prepareStatement(sql);
			ps.setInt(1,cod);
			ResultSet rs=ps.executeQuery();
			return rs.next();
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	//metodo para devolver o preco da viajem recebendo o cod da viagem
		public float getPrecoViagem(int cod_viagem)
		{
			float preco=0;
			
			String sql="select r.preco from viagem v,roteiro r Where v.cod_roteiro=r.cod_roteiro and v.cod_viagem=?";
			ArrayList<Cidade> array=new ArrayList<>();
			
			try
			{
				PreparedStatement ps=Connections.getConexao().prepareStatement(sql);
				ps.setInt(1,cod_viagem);
				ResultSet rs=ps.executeQuery();
				rs.next();
				preco=rs.getFloat(1);
			}
			catch(SQLException s)
			{
				System.out.println(s.getMessage());
			}
			
			return preco;
		}
		
		//metodo para generico para verificar se existe um registro da tabela x com o codigo x
		public boolean existeRegistro(String tabela,int cod)
		{
			String sql="Select cod_"+tabela+" from "+tabela+" where cod_"+tabela+"=?";
			try
			{
				PreparedStatement ps=Connections.getConexao().prepareStatement(sql);
				ps.setInt(1,cod);
				ResultSet rs=ps.executeQuery();
				return rs.next();
				
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			
			return false;
		}
		
	

}
