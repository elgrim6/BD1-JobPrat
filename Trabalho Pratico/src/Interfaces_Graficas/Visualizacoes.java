package Interfaces_Graficas;
import Interfaces.Fontes;
import Objectos.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import Database.Queries;
public class Visualizacoes extends JFrame implements Fontes
{
	private Container cont; //janela;
	private String [][] content; //conteudo da tabela
	private JScrollPane scroll; //scrollpane
	private JTable table; //tabela
	private JPanel panel; //painel de botoes
	
	//titulos da tabela
	private String [] header;
	private String [] titulosCliente= {"Codigo","Nome","Email","Nr de Contribuinte","Status"}; 
	private String [] titulosViagem= {"Codigo","Cliente","Roteiro","Data de Partida","Data de Chegada","Data de Marcacao"};
	private String [] titulosCidade= {"Codigo","Nome"};
	private String [] titulosRoteiro= {"Codigo","Cidade de Partida","Cidade de Destino"};
	private String [] titulosConsultaDylan= {"Codigo do Cliente","Nome do Cliente","Codigo da Viagem","Duracao(Dias)"};
	private String [] titulosConsultaLindsay= {"Nome da Cidade","Numero de Viagens"};
	private String [] titulosConsultaEugenio= {"Codigo do Cliente","Nome do Cliente","Codigo do Roteiro","Valor"};
	private String [] titulosConsultaGilberto= {"Codigo do Cliente","Nome do Cliente","Codigo da Viagem","Data de Partida","Data de Chegada","Data de Marcacao"};
	
	private JButton close; //botao para fechar a janela
	
	//objectos
	private Cliente cl; 
	private Viagem vg;
	private Cidade cd;
	private Roteiro rt;
	private Viagem_Duracao vd=new Viagem_Duracao(0, "", 0, 0);
	private Cidade_Quant qc;
	private Cliente_Datas cdt;
	private Nome_Preco np;
	
	
	public Visualizacoes(char tipo)
	{
		super("Visualizacao de Dados");
		switch(tipo)
		{
		 case 'c':header=titulosCliente;break;
		 case 'v':header=titulosViagem;break;
		 case 'd':header=titulosCidade;break;
		 case 'r':header=titulosRoteiro;break;
		 case 'y':header=titulosConsultaDylan;break;
		 case 'l':header=titulosConsultaLindsay;break;
		 case 'e':header=titulosConsultaEugenio;break;
		 case 'g':header=titulosConsultaGilberto;break;
		 default:System.out.println("error");
		}
		//titulo da janela
		
		
		//criacao da janela
		cont=getContentPane();
		cont.setLayout(new GridLayout(2,1,10,10));
		
		//preencher a tabela
		content=criarTabela(tipo);
		
		//criacao da tabela
		table=new JTable(content,header);
		
		//criacao do ScrollPane
		scroll=new JScrollPane(table);
		
		//criacao do painel de botoes
		panel=new JPanel(new BorderLayout());
		
		//criacao do botao para fechar a janela
		close=new JButton("Fechar");
		close.setIcon(new ImageIcon(".\\Icons\\close.png"));
		close.setFont(fontButton);
		close.setBackground(Color.LIGHT_GRAY);
		close.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
		
		//preenchimento do painel de botoes
		panel.add(BorderLayout.EAST,close);
		
		//preencimento da janela
		cont.add(scroll);
		cont.add(panel);
		
		//definicao da janela
		setSize(1250,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//metodo para preencher a tabela
	public String[][] criarTabela(char tipo)
	{
		ArrayList<Object> array = null;
		Queries cq=new Queries();
		switch(tipo)
		{
			case 'c':
			{
				array=cq.todosClientes();
			}break;	
			case 'v':
			{
				array=cq.todasViagens();
			}break;
			case 'd':
			{
				array=cq.todasCidades();
			}break;
			case 'r':
			{
				array=cq.todosRoteiros();
			}break;
			case 'y':
			{
				array=cq.viagem_mais_longa();
			}break;
			case 'l':
			{
				array=cq.todasCidade_Quant();
			}break;
			case 'e':
			{
				array=cq.todasCliente_Pagou_Mais();
			}break;
			case 'g':
			{
				array=cq.clientes_Numa_Cidade();
			}break;
			
		}
		
		String[][] x=new String[array.size()][header.length];
		
		for(int i=0;i<array.size();i++)
		{
			switch(tipo)
			{
				case 'c':
				{
					cl=(Cliente) array.get(i);
					x[i][0]=cl.getCod_cliente()+"";
					x[i][1]=cl.getNome();
					x[i][2]=cl.getEmail();
					x[i][3]=cl.getN_cont()+"";
					x[i][4]=cl.getStatus();
				}break;			
				case 'v':
				{
					vg=(Viagem) array.get(i);
					x[i][0]=vg.getCod_viagem()+"";
					x[i][1]=vg.getCod_cliente()+"";
					x[i][2]=vg.getCod_roteiro()+"";
					x[i][3]=vg.getData_partida()+"";
					x[i][4]=vg.getData_chegada()+"";
					x[i][5]=vg.getData_marcacao()+"";
				}break;
				case 'd':
				{
					cd=(Cidade) array.get(i);
					x[i][0]=cd.getCod_cidade()+"";
					x[i][1]=cd.getNome_cidade();
				}break;
				case 'r':
				{
					rt=(Roteiro) array.get(i);
					x[i][0]=rt.getCod_roteiro()+"";
					x[i][1]=rt.getCd_partida()+"";
					x[i][2]=rt.getCd_chegada();
				}break;
				case 'y':
				{
					vd=(Viagem_Duracao) array.get(i);
					x[i][0]=vd.getCod_cliente()+"";
					x[i][1]=vd.getNome_cliente();
					x[i][2]=vd.getCod_viagem()+"";
					x[i][3]=vd.getDuracao()+"";
				}break;
				 case 'l':
				 {
					qc=(Cidade_Quant) array.get(i);
					x[i][0]=qc.getNome_cidade();
					x[i][1]=qc.getNr_viagens()+"";
				}break;
				 case 'e':
				 {
					np=(Nome_Preco) array.get(i);
					x[i][0]=np.getCod_cliente()+"";
					x[i][1]=np.getNome();
					x[i][2]=np.getCod_roteiro()+"";
					x[i][3]=np.getPreco()+"";
				}break;
				 case 'g':
				 {
					cdt=(Cliente_Datas) array.get(i);
					x[i][0]=cdt.getCod_cliente()+"";
					x[i][1]=cdt.getNome();
					x[i][2]=cdt.getCod_viagem()+"";
					x[i][3]=cdt.getData_partida()+"";
					x[i][4]=cdt.getData_chegada()+"";
					x[i][5]=cdt.getData_marcacao()+"";
				}break;
			}
			
		}
		
		return x;
	}
}
