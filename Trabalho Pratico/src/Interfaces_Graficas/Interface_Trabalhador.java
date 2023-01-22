package Interfaces_Graficas;
import javax.swing.*;

import Interfaces.Fontes;

import java.awt.*;
import java.awt.event.*;
public class Interface_Trabalhador extends JFrame implements Fontes
{
	private Container cont; //janela
	private JButton criar_cliente,marcar_viagem,cancel_viagem,vis,alt,logout; //botoes
	private JPanel panel_botoes; //painel de botoes
	
	public Interface_Trabalhador(boolean restricao,String tipo)
	{
		//titulo da janela
		super("Bem Vindo "+tipo);
		
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
						//entrar na interface para cancelar uma viagem
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
							new Visualizacoes_Alteracoes(false,tipo,"Visualizacoes");
						else
							new Visualizacoes_Alteracoes(true,tipo,"Alteracoes");
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
						new Visualizacoes_Alteracoes(true,tipo,"Alteracoes");
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
		
		//preenchimento do painel
		panel_botoes.add(criar_cliente);
		panel_botoes.add(marcar_viagem);
		panel_botoes.add(cancel_viagem);
		panel_botoes.add(vis);
		panel_botoes.add(alt);
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
