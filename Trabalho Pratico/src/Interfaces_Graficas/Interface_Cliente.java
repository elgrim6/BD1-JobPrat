package Interfaces_Graficas;
import Objectos.Cidade;
import Objectos.Cliente;
import Objectos.Roteiro;
import Objectos.Viagem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Database.*;

public class Interface_Cliente extends javax.swing.JFrame {

    Cliente obj;
    Viagem vg;
    ArrayList<Object> array;
    
    public Interface_Cliente(int cod_cliente) 
    {
    	this.cod_cliente=cod_cliente;
    	obj=(Cliente) Queries.umClientes(cod_cliente);
    	array=Queries.viagensCliente(cod_cliente);
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }
                        
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(".\\Icons\\client.png")); // NOI18N

        jLabel2.setText("Codigo de Cliente:");

        jLabel3.setText("Nome de Usuario:");

        jLabel4.setText("Nº de Contribuinte:");

        jLabel5.setText("E-Mail:");

        jLabel6.setText("Status:");

        jLabel7.setText(obj.getCod_cliente()+"");

        jLabel8.setText(obj.getNome());

        jLabel9.setText(obj.getN_cont()+"");

        jLabel10.setText(obj.getEmail());

        jLabel11.setText(obj.getStatus());
        
        if(jLabel11.getText().equalsIgnoreCase("ACTIVO"))
        	jLabel11.setForeground(Color.green);
        else
        	jLabel11.setForeground(Color.red);

        
        jButton1.setText("Alterar Dados");

        jButton2.setText("Desactivar Conta");
        jButton2.addActionListener(
        		new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) 
					{
						int input = JOptionPane.showConfirmDialog(null, "Tem Certeza que Pretende Desactivar a conta?", "Customized Dialog",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if(input==0)
						{
							Updates.alterarEstado("INACTIVO",cod_cliente);
							JOptionPane.showMessageDialog(null, "Usuario Desctivado!\nPara voltar a activar este usuario, por favor diriga-se");
							dispose();
							new Escolher_Tipo_Usuario();
						}
					}
        			
        		}
        		);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)))
                    .addComponent(jLabel1))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Meu Perfil", jPanel1);

    
		
		String [] titulos= {"Codigo","Roteiro","Data de Partida","Data de Chegada","Data de Marcacao","Preco","Status"};
		String[][] x=new String[array.size()][titulos.length];
		
		for(int i=0;i<array.size();i++)
		{		
			vg=(Viagem) array.get(i);
			x[i][0]=vg.getCod_viagem()+"";
			x[i][1]=vg.getCod_roteiro()+"";
			x[i][2]=vg.getData_partida()+"";
			x[i][3]=vg.getData_chegada()+"";
			x[i][4]=vg.getData_marcacao()+"";
			x[i][5]=vg.getPreco()+"";
			x[i][6]=vg.getStatus();
		}
		
		table=new JTable(x,titulos);
		
		scroll=new JScrollPane(table);
        
        jPanel2.add(scroll);

        jTabbedPane1.addTab("Minhas Viagens", jPanel2);

        getContentPane().add(jTabbedPane1, "card2");

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private JTable table;
    private JScrollPane scroll;
    private int cod_cliente;
    // End of variables declaration                   
}