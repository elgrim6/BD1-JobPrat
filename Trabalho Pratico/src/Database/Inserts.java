package Database;
import Objectos.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

public class Inserts {
	
	private static SimpleDateFormat datex = new SimpleDateFormat("yyyy.MM.dd");
	
	public static boolean inserirCliente(Cliente obj)
	{
		String sql="INSERT INTO cliente\r\n"
				+ "    VALUES(id_cliente.NEXTVAL,'"+obj.getNome()+"','"+obj.getEmail()+"',"+obj.getN_cont()+",'"+obj.getStatus()+"')";
		
		try
		{
			var ps=Connections.getConexao().createStatement();
			var rs=ps.executeUpdate(sql);
		}catch(SQLException s)
		{
			JOptionPane.showMessageDialog(null, s.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean inserirViagem(Viagem obj)
	{
		String sql="INSERT INTO VIAGEM\r\n"
				+" VALUES(id_viagem.NEXTVAL,"+obj.getCod_cliente()+","+obj.getCod_roteiro()+",TO_DATE('"+obj.getData_partida()+"','YYYY.MM.DD'),TO_DATE('"+obj.getData_chegada()+"','YYYY.MM.DD'),TO_DATE('"+datex.format(obj.getData_marcacao()).toString()+"','YYYY.MM.DD')),'"+obj.getStatus()+"'";
		try
		{
			var ps=Connections.getConexao().createStatement();
			var rs=ps.executeUpdate(sql);
		}catch(SQLException s)
		{
			JOptionPane.showMessageDialog(null, s.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}
