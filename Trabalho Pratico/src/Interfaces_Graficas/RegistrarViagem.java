package Interfaces_Graficas;
import java.awt.*; 
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.*;
import java.time.LocalDate;

public class RegistrarViagem extends JFrame {
	
	String [] dias = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	String [] meses = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	String [] anos = {"2022", "2023", "2024", "2025", "2026", "2021", "2028", "2029", "2030"};
	
	String [] listRoteiros= {};
	
    private Container cont;
    private GridLayout grid;
    
    private JLabel dPartida, dChegada, codRoteiro, descRoteiro, roteiro;
    private JComboBox diaDpartida, diaDchegada, mesDpartida, mesDchegada, anoDpartida, anoDchegada, roteiroBox;
    private JPanel painelPartida, painelChegada;
    private JButton marcar, cancelar;
	
	
	public RegistrarViagem()
	{
		super ("Viagem");
		cont = getContentPane();
		grid = new GridLayout (5,2);
		cont.setLayout(grid);
		
		
		
		dPartida = new JLabel ("Data de partida");
		dChegada = new JLabel ("Data de chegada");
		//codCliente = new JLabel ("Codigo de Cliente");
		codRoteiro = new JLabel ("Codigo de Roteiro");
		roteiro= new JLabel("Descricao do Roteiro");
		descRoteiro = new JLabel ("");
		roteiroBox=new JComboBox(listRoteiros);
		
		marcar = new JButton ("Marcar");
		cancelar = new JButton ("Cancelar");
		
		//textCodCliente = new JTextField (7);
		
		diaDpartida = new JComboBox (dias);
		diaDpartida.setMaximumRowCount(3);
		mesDpartida = new JComboBox (meses);
		mesDpartida.setMaximumRowCount(3);
		anoDpartida = new JComboBox (anos); //vai mudar para um array de anos
		anoDpartida.setMaximumRowCount(3);
		
		diaDchegada = new JComboBox (dias);
		diaDchegada.setMaximumRowCount(3);
		mesDchegada = new JComboBox (meses);
		mesDchegada.setMaximumRowCount(3);
		anoDchegada = new JComboBox (anos); //vai mudar
		anoDchegada.setMaximumRowCount(3);
		
		Date dataMarcacao = new Date();
		//dataMarcacao=new Date("yyyy/mm/dd");
		
		painelPartida = new JPanel();
		painelChegada = new JPanel ();
	
		painelPartida.add(diaDpartida);
		painelPartida.add(mesDpartida);
		painelPartida.add(anoDpartida);
		
		painelChegada.add(diaDchegada);
		painelChegada.add(mesDchegada);
		painelChegada.add(anoDchegada);

		cont.add(codRoteiro);
		cont.add(roteiroBox);
		cont.add(roteiro);
		cont.add(descRoteiro);
		cont.add(dPartida);
		cont.add(painelPartida);
		cont.add(dChegada);
		cont.add(painelChegada);
		cont.add(marcar);
		cont.add(cancelar);
		
		setSize(600,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	public static void main (String [] args)
	{
		new RegistrarViagem();
	}
	
}
