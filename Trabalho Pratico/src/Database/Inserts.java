package Database;
import Objectos.*;
import java.sql.*;
import java.util.*;

public class Inserts {
	
	
	public static void inserirCliente(Cliente obj)
	{
		String sql="INSERT INTO cliente\r\n"
				+ "    VALUES(id_cliente.NEXTVAL,'"+obj.getNome()+"','"+obj.getEmail()+"',"+obj.getN_cont()+",'"+obj.getStatus()+"')";
		
		try
		{
			var ps=Connections.getConexao().createStatement();
			var rs=ps.executeUpdate(sql);
		}catch(SQLException s)
		{
			System.out.println(s.getMessage());
		}
	}

}
