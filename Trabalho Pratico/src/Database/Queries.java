package Database;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import Interfaces_Graficas.Visualizacoes;
import Objectos.*;
import Operacoes.Calculos;

public class Queries
{
	private Calculos c;
	
	public Queries() {
		c=new Calculos();
	}
	
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
				String data_partida=rs.getString(4);
				String data_chegada=rs.getString(5);
				Date data_marcacao=rs.getDate(6);
				String status=rs.getString(7);
				
				array.add(new Viagem(cod_viagem,cod_cliente,cod_roteiro,data_partida,data_chegada,data_marcacao,status));
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return array;
	}
	
	//metodo para retornar todas cidade_quant
	public ArrayList<Object> todasCidade_Quant()
	{
		String sql="select * from cidade_quant";
		ArrayList<Object> array=new ArrayList<>();
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				String nome_cidade=rs.getString(1);
				int nr_viagens=rs.getInt(2);
				
				array.add(new Cidade_Quant(nome_cidade,nr_viagens));
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return array;
	}
	
	//metodo para retornar os clientes que estao numa viagem
	public ArrayList<Object> clientes_Numa_Cidade()
	{
		String sql="SELECT * from cliente_datas where data_partida<=SYSDATE AND SYSDATE<=data_chegada";
		ArrayList<Object> array=new ArrayList<>();
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				int cod_cliente=rs.getInt(1);
				String nome=rs.getString(2);
				int cod_viagem=rs.getInt(3);
				String data_partida=rs.getString(4);
				String data_chegada=rs.getString(5);
				String data_marcacao=rs.getString(6);
				
				array.add(new Cliente_Datas(cod_cliente,nome,cod_viagem,data_partida,data_chegada,data_marcacao));
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return array;
	}
	
	//metodo para retornar todos nome_preco
	public ArrayList<Object> todasNome_Preco()
	{
		String sql="select * from nome_preco";
		ArrayList<Object> array=new ArrayList<>();
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				int cod_cliente=rs.getInt(1);
				String nome=rs.getString(2);
				int cod_roteiro=rs.getInt(3);
				
				array.add(new Nome_Preco(cod_cliente,nome,cod_roteiro));
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
		
		return array;
	}
	
	//metodo para retornar todas nome e codigo do cliente que pagou mais numa viagem
	public ArrayList<Object> todasCliente_Pagou_Mais()
	{
		Nome_Preco maior=new Nome_Preco(0,null,0);
		Nome_Preco aux=null;
		ArrayList<Object> array=todasNome_Preco();
		
		for(int a=0;a<array.size();a++)
		{
			aux=(Nome_Preco)array.get(a);
			if(aux.getPreco()>maior.getPreco())
				maior=aux;
		}
		array=new ArrayList<>();
		array.add(maior);
		
		return array;	
	}
	
	//metodo para retornar o cliente que fez a viagem mais longa
	public ArrayList<Object> viagem_mais_longa()
	{
		String sql="select cod_cliente,nome,cod_viagem, duracao from viagem_duracao where (duracao=(select max(duracao) from viagem_duracao) )";
		Viagem_Duracao vd;
		ArrayList<Object> array=new ArrayList<>();
		
		
		
		try
		{
			var ps=Connections.getConexao().createStatement(); 
			
			var rs=ps.executeQuery(sql);
			
			rs.next();
			
			int cod_cliente=rs.getInt(1);
			String nome_cliente=rs.getString(2);
			int cod_viagem=rs.getInt(3);
			int duracao=rs.getInt(4);
			vd=new Viagem_Duracao(cod_cliente,nome_cliente,cod_viagem,duracao);
			array.add(vd);
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
					String data_partida=rs.getString(4);
					String data_chegada=rs.getString(5);
					Date data_marcacao=rs.getDate(6);
					String status=rs.getString(7);
					
					array.add(new Viagem(cod_viagem,cod_cliente,cod_roteiro,data_partida,data_chegada,data_marcacao,status));
				}
			}
			catch(SQLException s)
			{
				System.out.println(s.getMessage());
			}
			
			return array;
		}
	
	//metodo para devolver o preco da viajem recebendo o cod da viagem
	public float getPrecoViagem(int cod_roteiro)
	{
		float preco=0;
			
		String sql="SELECT SUM(custo) FROM ligacao_roteiro lr,ligacao l WHERE (lr.cod_cidade=l.cod_cidade AND lr.cod_cidade1=l.cod_cidade1) AND lr.cod_roteiro=?";
		ArrayList<Cidade> array=new ArrayList<>();
			
		try
		{
			PreparedStatement ps=Connections.getConexao().prepareStatement(sql);
			ps.setInt(1,cod_roteiro);
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
	
	//metodo para generico para verificar se existe um cliente com o nr de contribuinte x
	public boolean existeNr_Contribuinte(int nr_cont)
	{
		String sql="Select nr_cont from cliente where nr_cont=?";
		try
		{
			PreparedStatement ps=Connections.getConexao().prepareStatement(sql);
			ps.setInt(1,nr_cont);
			ResultSet rs=ps.executeQuery();
			return rs.next();
				
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
			
		return false;
	}
		
	
	//metodo para calcular preco do roteiro
	public float precoRoteiro(int x)
	{
		float preco=0;
		String sql="SELECT SUM(custo) FROM ligacao_roteiro lr,ligacao l WHERE (lr.cod_cidade=l.cod_cidade AND lr.cod_cidade1=l.cod_cidade1) AND lr.cod_roteiro="+x;
		
		try
		{
			PreparedStatement ps=Connections.getConexao().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			preco=rs.getFloat(1);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return preco;
	}
	
	//metodo para devolver a descricao do roteiro
	public String descricaoRoteiro(int x)
	{
		String desc="";
		String sql="SELECT c.nome_cidade FROM cidade c,cidade_roteiro cr WHERE c.cod_cidade=cr.cod_cidade AND cr.cod_roteiro="+x;
		try
		{
			var ps=Connections.getConexao().createStatement(); 
					
			var rs=ps.executeQuery(sql);
					
			while(rs.next())
			{
				desc=desc+rs.getString(1)+", ";
			}
		}
		catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
				
		return desc;
	}
}
