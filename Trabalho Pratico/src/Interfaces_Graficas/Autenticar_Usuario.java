package Interfaces_Graficas;
import javax.swing.*;

import Database.Queries;
import Interfaces.Fontes;

import java.awt.*;
import java.awt.event.*;
public class Autenticar_Usuario extends JFrame implements Fontes
{
	private String passFun="Funcionario",passAdmin="Admin"; //password dos funcionario e dos Administradores
	private Container cont; //janela
	private JPanel auth; //painel de Autenticacao
	private JLabel logo,background,cred,show_pass_label; //labels
	private JCheckBox show_pass_box; //checkbox para mostrar o credencial
	private JPasswordField code; //Campo de texto para inserir o credencial necessario para a autenticacao
	private JButton login,exit; //botoes de login e sair
	
	public Autenticar_Usuario(String tipo) //tipo de credencial que deve ser inserido
	{
		//titulo da janela
		super("Autenticacao");
		
		//definicao da janela
		cont=getContentPane();
		
		//criacao da imagem de fundo da janela
		background=new JLabel(new ImageIcon(".\\Icons\\Login Background.png"));
		background.setLayout(new GridLayout(2,1,10,10));
		cont.add(background);
		
		//criacao do logo
		logo=new JLabel("Logo (para colocar mais tarde)");
		logo.setFont(fontBold);
		
		//criacao do painel de autenticacao
		auth=new JPanel(new GridLayout(3,2,10,10));
		auth.setOpaque(false);
		
		//criacao do label do credential
		cred=new JLabel(tipo);
		cred.setFont(fontBold);
		
		//criacao do campo de texto para o credencial
		code=new JPasswordField(10);
		code.setFont(fontPlain);
		code.addKeyListener(new UpdateCapsLogin());
		
		//criacao de caixa de diagnostico de caps lock
		show_pass_label=new JLabel("Caps Lock activo!");
		show_pass_label.setFont(fontItalicBold);
		show_pass_label.setForeground(Color.red);
		show_pass_label.setIcon(new ImageIcon(".\\Icons\\Warning.png"));
		updateCapsLogin();
		
		//criacao de botao para ver o password
		show_pass_box=new JCheckBox("Mostar Password");
		show_pass_box.setFont(fontBold);
		show_pass_box.setOpaque(false);
		show_pass_box.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						if(e.getStateChange()==ItemEvent.SELECTED)
							code.setEchoChar((char)0);
						else
							code.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					}
				});
		
		//criacao do botao para entrar no sistema
		login=new JButton("Iniciar Sessao");
		login.setFont(fontBold);
		login.setToolTipText("Entrar no Sistema");
		login.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						boolean passou=false;
						
						if(tipo.equals("Codigo do Cliente"))
						{
						//	passou=checkCliente();
						}
						else
						{
							if(tipo.equals("Password do Funcionario"))
								passou=checkTrabalhador(passFun,false,"Funcionario");
							else
								passou=checkTrabalhador(passAdmin,true,"Administrador");
						}
						
						if(passou)
							dispose();
					
					}
				});
		
		//criacao do botao para sair desta janela
		exit=new JButton("Sair");
		exit.setFont(fontBold);
		exit.setToolTipText("Sair desta janela");
		exit.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
						new Escolher_Tipo_Usuario();
					}
				});
		
		//preenchimento do painel de autenticacao
		auth.add(cred);
		auth.add(code);
		auth.add(show_pass_label);
		auth.add(show_pass_box);
		auth.add(login);
		auth.add(exit);
		
		//preenchimento da janela
		background.add(logo);
		background.add(auth);
		 
		//definicoes da janela
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	//classe privada para fazer o update do indicador do caps lock no painel de login
	private class UpdateCapsLogin implements KeyListener
	{
		public void keyTyped(KeyEvent e) {}
		
		public void keyPressed(KeyEvent e)
		{
			updateCapsLogin();
		}
		
		public void keyReleased(KeyEvent e) {}
	}
	
	//metodo para fazer update do dectector de caps lock login
	public void updateCapsLogin()
	{
		if(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK))
			show_pass_label.setVisible(true);
		else
			show_pass_label.setVisible(false);
	}
	
//	public boolean checkCliente()
//	{
//		Queries c=new Queries();
//		if(c.getCodCliente(Integer.parseInt(code.getText())))
//		{
//			boolean status=c.statusCliente(Integer.parseInt(code.getText()));
//			System.out.println(status);
//			if(status==true)
//			{
//				new Interface_Cliente(Integer.parseInt(code.getText()));
//				return true;
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null,"Este usuario encontra-se inactivo!\nPara voltar a activar a conta, por favor diriga-se ","ERRO",JOptionPane.ERROR_MESSAGE);
//			}
//		}
//		else
//		{
//			JOptionPane.showMessageDialog(null,"Usuario nao encontrado! ","ERRO",JOptionPane.ERROR_MESSAGE);
//		}
//		return false;
//	}
	
	public boolean checkTrabalhador(String passCorrecto,boolean restricao,String tipo)
	{
		if(code.getText().equals(passCorrecto))
		{
			new Interface_Trabalhador(restricao,tipo);
			dispose();
			return true;
		}
		else
			return false;
	}
}
