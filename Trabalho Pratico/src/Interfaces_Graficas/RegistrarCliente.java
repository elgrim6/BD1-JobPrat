package Interfaces_Graficas;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Objectos.Cliente;
import Database.Inserts;
public class RegistrarCliente extends JFrame {
	
	
	private Container cont;
	private JLabel lNome, lNCont, lEmail, lVisDados, lnull1, lnull2;
	private JTextField textNome, textNCont, textEmail, textVisDados;
	private JButton bRegistrar, bDeletar, bPesquisar, bActualizar, bLimpar, bCancelar;
	private GridLayout grid;
	private String sNome, sEmail;
	private int sNCont, sNCodCliente;
	
	public RegistrarCliente()
	{
		 super ("Cliente");
		 cont = getContentPane();
		 grid = new GridLayout (5,2);
		 cont.setLayout(grid);
		 
		 lNome = new JLabel ("Nome");
		 lNCont = new JLabel ("Numero de contribuinte");
		 lEmail = new JLabel ("Email");
		 lVisDados = new JLabel ("Dados", Label.LEFT);
		 lnull1 = new JLabel (" ");
		 lnull2 = new JLabel (" ");
		 
		 textNome = new JTextField (30);
		 textNCont = new JTextField (9);
		 textEmail = new JTextField (30);
		 textVisDados = new JTextField (200);
		 
		 bRegistrar = new JButton ("Registrar");
		 bRegistrar.addActionListener(
				 new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							String nome=textNome.getText();
							int n_cont=Integer.parseInt(textNCont.getText());
							String email=textEmail.getText();
							int cod_cliente=0;
							String status="ACTIVO";
							
							Cliente a=new Cliente(cod_cliente,nome,email,n_cont,status);
							Inserts.inserirCliente(a);
							JOptionPane.showMessageDialog(null, "Operacao Sucedida!");
						}
					}
				 );
		 
		 bDeletar = new JButton ("Deletar");
		 bPesquisar = new JButton ("Pesquisar");
		 bActualizar = new JButton ("Actualizar");
		 bLimpar = new JButton ("Limpar os campos");
		 bCancelar = new JButton ("Cancelar");
		 
		 cont.add(lNome);
		 cont.add(textNome);
		 
		 cont.add(lNCont);
		 cont.add(textNCont);
		 
		 cont.add(lEmail);
		 cont.add(textEmail);
		 
		 
		 //cont.add(lVisDados);
		 //cont.add(lnull1);
		 //cont.add(textVisDados);
		 //cont.add(lnull2);
		 
		 cont.add(bRegistrar);
		// cont.add(bDeletar);
		// cont.add(bPesquisar);
		 //cont.add(bActualizar);
		 cont.add(bLimpar);
		 cont.add(bCancelar);
		 
		 setSize (600,250);
		 setVisible (true);
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 setResizable(false);
		 setLocationRelativeTo(null);
		 
		 bLimpar.addActionListener(
				 new ActionListener()
				 {
					 public void actionPerformed (ActionEvent e)
					 {
						 textNCont.setText(null);
						 textNome.setText(null);
						 textEmail.setText(null);
					 }
				 });
	}
	/*
	 *  sNome = textNome.getText();
						 sNCont = Integer.parseInt(textNCont.getText());
						 sNCodCliente= Integer.parseInt(textCodCliente.getText());
						 sEmail = textEmail.getText();
						 textVisDados.setText("Nome: "+sNome+"\n"+"Numero de contribuinte: "
						 +sNCont+"\n"+"Codigo de cliente: "+sNCodCliente+"\n"+"Email: "+sEmail);
	 */
	public static void main (String [] args)
	{
	
	}

}
