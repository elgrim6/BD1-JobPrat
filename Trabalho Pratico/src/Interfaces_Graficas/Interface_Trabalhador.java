package Interfaces_Graficas;
import javax.swing.*;

import Database.Queries;
import Database.Updates;
import Interfaces.Fontes;
import Objectos.Viagem;

import java.awt.*;
import java.awt.event.*;
public class Interface_Trabalhador extends JFrame implements Fontes
{
	private Container cont; //janela
	private JButton criar_cliente,marcar_viagem,cancel_viagem,vis,alt,logout,consultas,lucro; //botoes
	private JPanel panel_botoes; //painel de botoes
	private Queries q;
	private Updates up;
	
	public Interface_Trabalhador(boolean restricao,String tipo)
	{
		//titulo da janela
		super("Bem Vindo "+tipo);
		q=new Queries();
		up=new Updates();
		
		//criacao da janela
		cont=getContentPane();
		
		//criacao do painel do botoes
		panel_botoes=new JPanel(new GridLayout(2,4,10,10));
		
		//criacao do botao para criar um cliente
		criar_cliente=new JButton("Criar Cliente");
		criar_cliente.setIcon(new ImageIcon(".\\Icons\\add user.png"));
		criar_cliente.setFont(fontButton);
		criar_cliente.setBackground(Color.lightGray);
		criar_cliente.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new RegistrarCliente();//entrar na interface para criar o cliente
					}
				});
		
		consultas = new JButton("Consultas");
		consultas.setIcon(new ImageIcon(".\\Icons\\search.png"));
		consultas.setFont(fontButton);
		consultas.setBackground(Color.lightGray);
		consultas.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new Interface_Consultas();
					}
				});
		consultas.setEnabled(restricao);
		
		//criacao do botao para marcar uma viagem
		marcar_viagem=new JButton("Marcar Viagem");
		marcar_viagem.setIcon(new ImageIcon(".\\Icons\\new trip.png"));
		marcar_viagem.setFont(fontButton);
		marcar_viagem.setBackground(Color.lightGray);
		marcar_viagem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new RegistrarViagem();//entrar na interface para criar viagem
					}
				});
		
		//criacao do botao para cancelar uma viagem
		cancel_viagem=new JButton("Cancelar Viagem");
		cancel_viagem.setIcon(new ImageIcon(".\\Icons\\cancel trip.png"));
		cancel_viagem.setFont(fontButton);
		cancel_viagem.setBackground(Color.lightGray);
		cancel_viagem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int cod=0;
						
						try
						{
							cod=Integer.parseInt(JOptionPane.showInputDialog("Insere o codigo da viagem que pretender cancelar"));
						}
						catch(NumberFormatException nfe) {}
							
						if(cod!=0)
						{
							if(q.existeRegistro("Viagem",cod))
							{
								boolean passou=up.cancelarViagem(cod);
								if(passou)
									JOptionPane.showMessageDialog(null,"Operacao executada com sucesso!","MENSAGEM",JOptionPane.PLAIN_MESSAGE);
							}
							else
								JOptionPane.showMessageDialog(null,"Erro! Codigo nao existe!","ERRO",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
		
		//criacao do botao para criar um cliente
		vis=new JButton("Visualizacoes");
		vis.setIcon(new ImageIcon(".\\Icons\\view.png"));
		vis.setFont(fontButton);
		vis.setBackground(Color.lightGray);
		vis.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(tipo.equals("Funcionario"))
						{
							dispose();
							new Visualizacoes_Alteracoes(restricao,tipo,"Visualizacoes");
						}
						else
						{
							dispose();
							new Visualizacoes_Alteracoes(restricao,tipo,"Visualizacoes");
						}
					}
				});
		
		//criacao do botao para criar um cliente
		alt=new JButton("Alteracoes");
		alt.setIcon(new ImageIcon(".\\Icons\\edit.png"));
		alt.setFont(fontButton);
		alt.setBackground(Color.lightGray);
		alt.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
						new Visualizacoes_Alteracoes(restricao,tipo,"Alteracoes");
					}
				});
		alt.setEnabled(restricao);
		
		//criacao do botao para fazer o log out da conta
		logout=new JButton("Log Out");
		logout.setIcon(new ImageIcon(".\\Icons\\logout.png"));
		logout.setFont(fontButton);
		logout.setBackground(Color.lightGray);
		logout.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
						new Escolher_Tipo_Usuario();
					}
				});
		lucro=new JButton("Lucro Adquirido");
		lucro.setIcon(new ImageIcon(".\\Icons\\profit.png"));
		lucro.setFont(fontButton);
		lucro.setBackground(Color.lightGray);
		lucro.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new Valor_Obtido();
					}
				});
		lucro.setEnabled(restricao);
		
		
		//preenchimento do painel
		panel_botoes.add(criar_cliente);
		panel_botoes.add(marcar_viagem);
		panel_botoes.add(cancel_viagem);
		panel_botoes.add(vis);
		panel_botoes.add(alt);
		panel_botoes.add(consultas);
		panel_botoes.add(lucro);
		panel_botoes.add(logout);
		
		
		//preenchimento da janela
		cont.add(panel_botoes);
		
		//definicoes da janela
		setSize(1300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
