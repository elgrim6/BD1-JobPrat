package Database;
import java.sql.*;
import java.util.*;
import Objectos.*;

public class Updates 
{
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
			System.out.println(s.getMessage());
		}
	}
}
