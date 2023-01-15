package Database;
import java.sql.*;
import java.util.*;

import Interfaces_Graficas.Visualizacoes;
import Objectos.*;

public class Queries
{
	public Queries() {}
	
	//metodo para retornar todos clientes
	public static ArrayList<Object> todosClientes()
	{
		String sql="select * from CLIENTE";
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
				
				array.add(new Cliente(cod_cliente,nome,email,n_cont));
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
				float preco=rs.getFloat(2);
				String cd_partida=rs.getString(3);
				String cd_chegada=rs.getString(4);
				String descricao=rs.getString(5);
				
				array.add(new Roteiro(cod_roteiro,preco,cd_partida,cd_chegada,descricao));
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
				String data_partida=rs.getString(4);
				String data_chegada=rs.getString(5);
				String data_marcacao=rs.getString(6);
				
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
	

}
