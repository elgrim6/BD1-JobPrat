
import Database.Updates;
import Interfaces_Graficas.Escolher_Tipo_Usuario;
/*
	Grupo 1 - Agencia de Turismo
	Gilberto Botas Junior - 20210204
	Dylan Cassamo - 20210640
	Lindsay Nhancale - 20211073
	Eugenio Castigo Junior - 20210089
*/
public class Main
{
	//metodo main
	public static void main(String[] args)
	{
		Updates up=new Updates();
		up.updateAllViagens();
		new Escolher_Tipo_Usuario();
	}
}
