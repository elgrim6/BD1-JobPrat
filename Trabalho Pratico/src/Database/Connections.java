package Database;
import java.sql.*;

public class Connections 
{
	//metodo para connectar a base de dados
	public static Connection getConexao()
	{
		Connection con=null;
				
			try {
				con= DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.1:1521:xe","C##DYLAN","DylanCassamo");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		return con;
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