package Interfaces_Graficas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Database.Updates;
import Interfaces.Fontes;

public class Escolher_Tipo_Usuario extends javax.swing.JFrame implements Fontes{

    /**
     * Creates new form NewJFrame
     */
    public Escolher_Tipo_Usuario() {
    	super("Bem Vindo");
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Escolha o seu Usuario");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setIcon(new ImageIcon(".\\Icons\\client.png")); // NOI18N
        jButton2.setToolTipText("Cliente");
        jButton2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent a)
					{
						//janela para inserir o codigo do cliente (somente) para entrar na vista de cliente
						new Login_Cliente();
						dispose();
					}
				}
				);

        jButton3.setIcon(new ImageIcon(".\\Icons\\worker.png")); // NOI18N
        jButton3.setToolTipText("Funcionario");
        jButton3.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent a)
					{
						//janela para inserir o password (somente) para entrar na vista de funcionarios
						new Autenticar_Usuario("Password do Funcionario:");
						dispose();
					}
				}
				);

        jButton4.setIcon(new ImageIcon(".\\Icons\\admin.png")); // NOI18N
        jButton4.setToolTipText("Administrador");
        jButton4.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent a)
					{
						//janela para inserir o codigo do cliente (somente) para entrar na vista de cliente
						new Autenticar_Usuario("Password do Administrador:");
						dispose();
					}
				}
				);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sair");
        jButton1.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				});

        jLabel2.setFont(Fontes.fontBold); // NOI18N
        jLabel2.setText("Bem Vindo, escolha o tipo de usuario");

        jLabel3.setForeground(Color.GRAY);
        jLabel3.setText("Sobre nossa ag??ncia");
        jLabel3.setFont(fontSmall);
        jLabel3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				aboutUs();
				jLabel3.setForeground(Color.GRAY);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jLabel3.setForeground(Color.GRAY);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel3.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				aboutUs();
				jLabel3.setForeground(Color.GRAY);
				
			}
		}
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(54, 54, 54)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        setVisible(true);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration 
    
    public void aboutUs()
    {
    	JOptionPane.showMessageDialog(null,"Bem-vindo ?? Ag??ncia de Viagens!\n"
    			+ "Somos uma ag??ncia de viagens de servi??o completo dedicada a ajud??-lo a planejar e reservar as f??rias dos seus sonhos.\r\n"
    			+ "Quer esteja ?? procura de um pacote de f??rias com tudo inclu??do para uma fam??lia.\n"
    			+ "A nossa ag??ncia de turismo foi criada para ajudar as pessoas a desfrutar de suas viagens e aproveitarem ao m??ximo cada momento.\n"+""
    			+ "Trabalhamos com destinos em todo o mundo, oferecendo pacotes de viagem a pre??os acess??veis.\n"
    			+ "Tamb??m oferecemos servi??os personalizados para aqueles que querem uma experi??ncia ??nica e memor??vel.\n"
    			+ "Nossos profissionais altamente qualificados ir??o gui??-lo por todos os detalhes da sua viagem para que voc?? possa relaxar e desfrutar de suas f??rias.\n"+""
    			+ "\n Dados dos Programadores:\n"+""
    			+ "Grupo 1 - Agencia de Turismo\r\n"
    			+ "	Gilberto Botas Junior - 20210204\r\n"
    			+ "	Dylan Cassamo - 20210640\r\n"
    			+ "	Lindsay Nhancale - 20211073\r\n"
    			+ "	Eugenio Castigo Junior - 20210089");
    }
}