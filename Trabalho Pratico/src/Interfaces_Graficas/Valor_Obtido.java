package Interfaces_Graficas;
import javax.swing.*;
import Interfaces.Fontes;
import Operacoes.Calculos;

import java.awt.*;
import java.awt.event.*;

public class Valor_Obtido extends JFrame implements Fontes
{
	private Container cont; //janela
	private JPanel painel; //painel
	private JLabel valtL,valt; //label
	private JButton close; //botao para fechar a janela
	private Calculos c;
	
	public Valor_Obtido()
	{
		//titulo da janela
		super("Valor Obtido");
		
		//classe de calculos
		Calculos c=new Calculos();
		
		//criacao da janela
		cont=getContentPane();
		
		//criacao do painel
		painel=new JPanel(new GridLayout(2,2));
		
		//criacao das labels
		valtL=new JLabel("Valor total Obtido: ");
		valtL.setFont(fontBold);
		
		valt=new JLabel(""+c.calcularLucro());
		valt.setFont(fontItalicBold);
		valt.setForeground(Color.GRAY);
		valt.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//criacao do botao para fechar a janela
		close=new JButton("Fechar");
		close.setIcon(new ImageIcon(".\\Icons\\close small.png"));
		close.setFont(fontBold);
		close.setBackground(Color.LIGHT_GRAY);
		close.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
		
		//preenchimento do painel
		painel.add(valtL);
		painel.add(valt);
		painel.add(new JLabel());
		painel.add(close);
		
		//preenchimento da janela
		cont.add(painel);
		
		//definicao da janela
		setSize(325,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Valor_Obtido();
	}
}
