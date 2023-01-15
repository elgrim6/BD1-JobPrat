package Interfaces_Graficas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Interfaces.Fontes;
public class Interface_Cliente extends JFrame implements Fontes
{
	private Container cont; //janela
	private JButton vis_dados_cliente,vis_viagens_cliente,vis_roteiros,logout; //botoes
	private JPanel panel_botoes; //painel de botoes
	
	public Interface_Cliente(int codigo_cliente)
	{
		//titulo da janela
		super("Bem vindo "/*+nome do cliente*/); //nome do cliente vamos buscar na base de dados
		
		//criacao da janela
		cont=getContentPane();
		 
		//criacao do painel de botoes
		panel_botoes=new JPanel(new GridLayout(2,3,10,10));
		
		//criacao do botao para visualizar dados do cliente
		vis_dados_cliente=new JButton("Dados do Cliente");
		vis_dados_cliente.setIcon(new ImageIcon(".\\Icons\\info.png"));
		vis_dados_cliente.setFont(fontButton);
		vis_dados_cliente.setBackground(Color.lightGray);
		vis_dados_cliente.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//entrar na interface para visualizar os dados do cliente
					}
				});
		
		//criacao do botao para visualizar as viagens feitas pelo cliente
		vis_viagens_cliente=new JButton("Viagens do Cliente");
		vis_viagens_cliente.setIcon(new ImageIcon(".\\Icons\\trip.png"));
		vis_viagens_cliente.setFont(fontButton);
		vis_viagens_cliente.setBackground(Color.lightGray);
		vis_viagens_cliente.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//entrar na interface para visualizar as viagens feitas pelo cliente
					}
				});
		
		//criacao do botao para visualizar os roteiros disponiveis no sistema
		vis_roteiros=new JButton("Roteiros Disponiveis");
		vis_roteiros.setIcon(new ImageIcon(".\\Icons\\route.png"));
		vis_roteiros.setFont(fontButton);
		vis_roteiros.setBackground(Color.lightGray);
		vis_roteiros.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//entrar na interface para visualizar os roteiros disponiveis no sistema
					}
				});
		
		//criacao do botao para fazer o log out da conta
		logout=new JButton("Log Out");
		logout.setIcon(new ImageIcon(".\\Icons\\back.png"));
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
		
		//preenchimento do painel
		panel_botoes.add(vis_dados_cliente);
		panel_botoes.add(vis_viagens_cliente);
		panel_botoes.add(vis_roteiros);
		panel_botoes.add(logout);
		
		//preenchimento de espacos vazios
		panel_botoes.add(new JLabel());
		panel_botoes.add(new JLabel());
		
		//preenchimento da janela
		cont.add(panel_botoes);
		
		//definicoes da janela
		setSize(1200,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
