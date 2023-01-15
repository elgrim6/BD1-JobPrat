package Interfaces_Graficas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Interfaces.Fontes;
public class Visualizacoes_Alteracoes extends JFrame implements Fontes
{
	private Container cont; //janela
	private JButton cliente,roteiro,viagem,cidade,voltar;
	private JPanel panel_botoes;
	private String titulo;
	
	public Visualizacoes_Alteracoes(boolean restricao,String tipo_usuario,String tipo_janela)
	{
		//titulo da janela
		super(tipo_janela);
		
		//criacao da janela
		cont=getContentPane();
		
		//criacao do painel do botoes
		panel_botoes=new JPanel(new GridLayout(2,3,10,10));
		
		//criacao do botao para visualizar/alterar dados dos clientes
		cliente=new JButton("Clientes");
		cliente.setIcon(new ImageIcon(".\\Icons\\client.png"));
		cliente.setFont(fontButton);
		cliente.setBackground(Color.lightGray);
		cliente.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(tipo_janela.equals("Visualizacoes")); // ; deve se tirar
							new Visualizacoes('c');
						//else
							//entrar na interface alterar dados dos clientes
					}
				});
		
		//criacao do botao para visualizar/alterar dados dos roteiros
		roteiro=new JButton("Roteiros");
		roteiro.setIcon(new ImageIcon(".\\Icons\\route.png"));
		roteiro.setFont(fontButton);
		roteiro.setBackground(Color.lightGray);
		roteiro.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(tipo_janela.equals("Visualizacoes")); // ; deve se tirar
							new Visualizacoes('r');
							//entrar na interface visualizar dados dos roteiros
						//else
							//entrar na interface alterar dados dos roteiros
					}
				});
		
		//criacao do botao para visualizar/alterar dados das viagens
		viagem=new JButton("Viagens");
		viagem.setIcon(new ImageIcon(".\\Icons\\trip.png"));
		viagem.setFont(fontButton);
		viagem.setBackground(Color.lightGray);
		viagem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(tipo_janela.equals("Visualizacoes")); // ; deve se tirar
							new Visualizacoes('v');
							//entrar na interface visualizar dados das viagens
						//else
							//entrar na interface alterar dados das viagens
					}
				});
		
		//criacao do botao para visualizar/alterar dados das cidades
		cidade=new JButton("Cidades");
		cidade.setIcon(new ImageIcon(".\\Icons\\city.png"));
		cidade.setFont(fontButton);
		cidade.setBackground(Color.lightGray);
		cidade.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(tipo_janela.equals("Visualizacoes")); // ; deve se tirar
							new Visualizacoes('d');
							//entrar na interface visualizar dados das cidades
						//else
							//entrar na interface alterar dados das cidades
					}
				});
		cidade.setEnabled(restricao);
		
		//criacao do botao para voltar a janela anterior
		voltar=new JButton("Voltar");
		voltar.setIcon(new ImageIcon(".\\Icons\\back.png"));
		voltar.setFont(fontButton);
		voltar.setBackground(Color.lightGray);
		voltar.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
		
		//preenchimento do painel
		panel_botoes.add(cliente);
		panel_botoes.add(roteiro);
		panel_botoes.add(viagem);
		panel_botoes.add(cidade);
		panel_botoes.add(voltar);
		
		//preenchimento de espacos vazios
		panel_botoes.add(new JLabel());
		
		//preenchimento da janela
		cont.add(panel_botoes);
		
		//definicoes da janela
		setSize(1200,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
