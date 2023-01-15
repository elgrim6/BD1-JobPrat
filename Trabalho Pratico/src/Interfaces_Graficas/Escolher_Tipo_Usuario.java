package Interfaces_Graficas;
import Database.*;
import Interfaces.Fontes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Escolher_Tipo_Usuario extends JFrame implements Fontes
{
		private Container cont; //janela
		private JPanel panel_user; //painel de botoes
		private JButton user,func,admin,sair; //botoes dos tipos de usuarios
		
		public Escolher_Tipo_Usuario()
		{
			//titulo da janela
			super("Escolha o seu usuario");
			
			//definicao da janela
			cont=getContentPane();
			
			//definicao do painel de botoes
			panel_user=new JPanel(new GridLayout(1,4,10,10));
			
			//criacao dos botoes
			user=new JButton("Cliente",new ImageIcon(".\\Icons\\client.png"));
			user.setBackground(Color.lightGray);
			
			user.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent a)
						{
							//janela para inserir o codigo do cliente (somente) para entrar na vista de cliente
							new Autenticar_Usuario("Codigo do Cliente");
							dispose();
						}
					}
					);
			
			func=new JButton("Funcionario",new ImageIcon(".\\Icons\\worker.png"));
			func.setBackground(Color.lightGray);
			
			func.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent a)
						{
							//janela para inserir o password (somente) para entrar na vista de funcionarios
							new Autenticar_Usuario("Password do Funcionario");
							dispose();
						}
					}
					);
			
			admin=new JButton("Administrador",new ImageIcon(".\\Icons\\admin.png"));
			admin.setBackground(Color.lightGray);
			
			admin.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent a)
						{
							//janela para inserir o codigo do cliente (somente) para entrar na vista de cliente
							new Autenticar_Usuario("Password do Administrador");
							dispose();
						}
					}
					);
			
			//criacao do botao para sair do programa
			sair=new JButton("Sair");
			sair.setIcon(new ImageIcon(".\\Icons\\power.png"));
			sair.setFont(fontButton);
			sair.setBackground(Color.lightGray);
			sair.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							System.exit(0);
						}
					});
			
			//definicao das fontes dos botoes
			user.setFont(fontButton);
			func.setFont(fontButton);
			admin.setFont(fontButton);
			
			//preenchimento do painel de botoes
			panel_user.add(user);
			panel_user.add(func);
			panel_user.add(admin);
			panel_user.add(sair);
			
			//preenchimento da janela
			cont.add(panel_user);
			
			//definicao da janela
			setSize(1250,600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setVisible(true);
			
			alert();
		}
		
		//aviso sobre escolher o tipo de usuario
		public void alert()
		{
			JOptionPane.showMessageDialog(null,"Identifique o seu usuario!","Alerta",
					JOptionPane.PLAIN_MESSAGE);
		}
}
