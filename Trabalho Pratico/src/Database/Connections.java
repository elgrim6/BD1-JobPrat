package Database;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Connections 
{
	//metodo para connectar a base de dados
	public static Connection getConexao()
	{
		Connection con=null;
		
			try {
				con= DriverManager.getConnection("jdbc:oracle:thin:@"+getIp()+":1521:xe","C##ADMIN","BD2.isctem");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		return con;
	}
	
	public static String getIp()
	{
		String ip="";
		StringTokenizer str;
		
		InetAddress ia;
		
		try
		{
			ia=InetAddress.getLocalHost();
			str=new StringTokenizer(ia+"","/");
			str.nextToken();
			ip=str.nextToken();
		}
		catch(UnknownHostException e) {
			JOptionPane.showMessageDialog(null,"Erro inesperado!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
		return ip;
	}
	
//	public static void main(String[] args) throws Exception 
//	{
//		Connection con=Connections.getConexao();
//		
//query preparada		
//		String sql="select * from CLIENTE where nome='Fred Cuambe'";
//		
//		try
//		{
//			var ps=con.createStatement(); 
//			
//			var rs=ps.executeQuery(sql);
//			
//			while(rs.next())
//			{
//				rs.getRowId(1);
//				int cod_cliente=rs.getInt(1);
//				String nome=rs.getString(2);
//				String email=rs.getString(3);
//				long n_cont=rs.getLong(4);
//				
//				System.out.println("Codigo do Cliente: "+cod_cliente+"\nNome do Cliente: "+nome);
//			}
//		}
//		catch(SQLException s)
//		{
//			System.out.println(s.getMessage());
//		}
//		
//query automatica
//		try
//		{
//			//String sql="select * from CLIENTE where nome=?";
//			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setString(1,"Dylan Cassamo");
//			ResultSet rs=ps.executeQuery();
//			
//			while(rs.next())//se existe a proxima linha
//			{
//				int cod_cliente=rs.getInt(1);
//				String nome=rs.getString(2);
//				String email=rs.getString(3);
//				long n_cont=rs.getLong(4);
//				
//				System.out.println("Codigo do Cliente: "+cod_cliente+"\nNome do Cliente: "+nome);
//			}
//		}
//		catch(SQLException s)
//		{
//			System.out.println(s.getMessage());
//		}
//	}
}