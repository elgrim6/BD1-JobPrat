package Interfaces_Graficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Database.Inserts;
import Database.Queries;
import Objectos.Cliente;
import Objectos.Roteiro;
import Objectos.Viagem;
import Operacoes.Calculos;

public class RegistrarViagem extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
	
	Roteiro rt;
	Cliente cl;
    Queries cq;
    Calculos cal;
	
    public RegistrarViagem() {
    	super("Marcar Viagem");
    	cal=new Calculos();
    	cq=new Queries();
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Codigo do Roteiro");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(codigosRoteiro()));
        jComboBox1.addItemListener(
        			new ItemListener()
        			{
						public void itemStateChanged(ItemEvent e) 
						{
							String desc=cq.descricaoRoteiro(jComboBox1.getSelectedIndex()+1);
							jTextArea1.setText(desc);
						}
        				
        			}
        		);

        jLabel7.setText("Data de Partida");

        jLabel8.setText("Data de Chegada");

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				dispose();
        			}
        		});

        jButton5.setText("Registrar");
        jButton5.addActionListener(
        		new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int cod_roteiro=Integer.parseInt(jComboBox1.getSelectedItem().toString());
						String data_partida=jComboBox2.getSelectedItem().toString()+"."+jComboBox3.getSelectedItem().toString()+"."+jComboBox4.getSelectedItem().toString();
						String data_chegada=jComboBox7.getSelectedItem().toString()+"."+jComboBox5.getSelectedItem().toString()+"."+jComboBox6.getSelectedItem().toString();
						int cod_cliente=Integer.parseInt(jComboBox8.getSelectedItem().toString());
						long millis = System.currentTimeMillis();
						Date data_marcacao=new Date(millis);
						
						Viagem a=new Viagem(0,cod_roteiro,cod_cliente,data_partida,data_chegada,data_marcacao);
						Inserts.inserirViagem(a);
						
						JOptionPane.showMessageDialog(null, "Operacao Sucedida!");
					}
				}
        		
        		);

        jLabel9.setIcon(new javax.swing.ImageIcon(".\\Icons\\new trip.png")); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(anos));
        jComboBox2.addItemListener(
	        		new ItemListener()
	    			{
						public void itemStateChanged(ItemEvent e) 
						{
							int mes=jComboBox3.getSelectedIndex()+1;
							boolean bissexto=cal.calcularBissexto((short) (Integer.parseInt(jComboBox2.getSelectedItem().toString())));
							if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
								jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias3));
							else
							{
								if(mes==4||mes==6||mes==9||mes==11)
									jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias4));
								else
								{
									if(mes==2&&bissexto==true)
										jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias2));
									else
										jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias1));
								}
							}
						}
	    				
	    			}
        		);
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(anos));
        jComboBox7.addItemListener(
        		new ItemListener()
    			{
					public void itemStateChanged(ItemEvent e) 
					{
						int mes=jComboBox5.getSelectedIndex()+1;
						boolean bissexto=cal.calcularBissexto((short) (Integer.parseInt(jComboBox7.getSelectedItem().toString())));
						if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
							jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias3));
						else
						{
							if(mes==4||mes==6||mes==9||mes==11)
								jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias4));
							else
							{
								if(mes==2&&bissexto==true)
									jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias2));
								else
									jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias1));
							}
						}
					}
    				
    			}
    		);
            
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(meses));
        jComboBox3.addItemListener(
        		new ItemListener()
    			{
					public void itemStateChanged(ItemEvent e) 
					{
						int mes=jComboBox3.getSelectedIndex()+1;
						boolean bissexto=cal.calcularBissexto((short) (Integer.parseInt(jComboBox2.getSelectedItem().toString())));
						if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
							jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias3));
						else
						{
							if(mes==4||mes==6||mes==9||mes==11)
								jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias4));
							else
							{
								if(mes==2&&bissexto==true)
									jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias2));
								else
									jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias1));
							}
						}
						
					}
    				
    			}
    		);
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(meses));
        jComboBox5.addItemListener(
        		new ItemListener()
    			{
					public void itemStateChanged(ItemEvent e) 
					{
						int mes=jComboBox5.getSelectedIndex()+1;
						boolean bissexto=cal.calcularBissexto((short) (Integer.parseInt(jComboBox7.getSelectedItem().toString())));
						if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
							jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias3));
						else
						{
							if(mes==4||mes==6||mes==9||mes==11)
								jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias4));
							else
							{
								if(mes==2&&bissexto==true)
									jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias2));
								else
									jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias1));
							}
						}
					}
    				
    			}
    		);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(dias3));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(dias3));

        jLabel1.setText("Descricao do Roteiro");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Codigo do Cliente");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(codigosCliente()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4)
                        .addComponent(jLabel8))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox6, 0, 1, Short.MAX_VALUE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox5, 0, 1, Short.MAX_VALUE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>                        

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          
   

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    String [] dias1 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
    String [] dias2 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};
    String [] dias3 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String [] dias4 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    String [] meses = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	String [] anos = {"2022", "2023", "2024", "2025", "2026", "2021", "2028", "2029", "2030"};
    // End of variables declaration    
    
    public String[] codigosRoteiro()
    {
    	ArrayList<Object> array=cq.todosRoteiros();
    	String[] cods = new String[array.size()];
    	
    	for(int i=0;i<array.size();i++)
		{
    		rt=(Roteiro) array.get(i);
    		
    		cods[i]=rt.getCod_roteiro()+"";
		}
    	
    	return cods;
    }
    
    public String[] codigosCliente()
    {
    	ArrayList<Object> array=cq.todosClientes();
    	String[] cods = new String[array.size()];
    	
    	for(int i=0;i<array.size();i++)
		{
    		cl=(Cliente) array.get(i);
    		
    		cods[i]=cl.getCod_cliente()+"";
		}
    	
    	return cods;
    }
}
