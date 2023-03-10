package Interfaces_Graficas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.StringTokenizer;

import javax.swing.*;

import Database.Queries;
import Objectos.Cliente;

public class Login_Cliente extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public Login_Cliente() {
    	super("Login Cliente");
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

        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jCheckBox1 = new JCheckBox();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo de Usuario:");

        jLabel2.setText("Palavra-Passe:");
        
        jPasswordField1.addKeyListener(new UpdateCapsLogin());

        jButton1.setText("Entrar");
        jButton1.addActionListener(
        		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
					{
						boolean passou=false;
						
						passou=checkCliente();
						
						if(passou)
							dispose();
					
					}
        		}
        		);

        jButton2.setText("Voltar");
        jButton2.addActionListener(
        		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				new Escolher_Tipo_Usuario();
        				dispose();
        			}
        		}
        		);

        jCheckBox1.setText("Mostrar Password");
        jCheckBox1.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						if(e.getStateChange()==ItemEvent.SELECTED)
							jPasswordField1.setEchoChar((char)0);
						else
							jPasswordField1.setEchoChar('*');
					}
				});

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Caps Lock ligado!");
        jLabel3.setVisible(false);

       

        jLabel6.setIcon(new ImageIcon(".\\Icons\\client.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    Cliente obj;
    // End of variables declaration        
    
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
  			jLabel3.setVisible(true);
  		else
  			jLabel3.setVisible(false);
  	}
  	
	public boolean checkCliente()
	{
		Queries c=new Queries();
		if(c.existeRegistro("cliente",Integer.parseInt( jTextField1.getText())))
		{
			obj=(Cliente) c.umClientes(Integer.parseInt( jTextField1.getText()));
			
			if(obj.getStatus().equalsIgnoreCase("activo"))
			{
				return checkPassword();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Este usuario encontra-se inactivo!\nPara voltar a activar a conta, por favor diriga-se ao balcao mais proximo da nossa agencia.","ERRO",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Usuario nao encontrado! ","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
  	public boolean checkPassword()
  	{
  		Queries c=new Queries();
  		String pass,x;
  		int y;
  		x=obj.getNome();
  		y=obj.getCod_cliente();
  		
  		StringTokenizer str=new StringTokenizer(x," ");
  		x=str.nextToken();
  		pass=x+y;
  		
  		if(jPasswordField1.getText().equals(pass))
  		{
  			new Interface_Cliente(Integer.parseInt( jTextField1.getText()));
			return true;
  		}
  		else
  			JOptionPane.showMessageDialog(null,"Palavra-Passe Incorrecta!","ERRO",JOptionPane.ERROR_MESSAGE);
  		
  		
  		return false;
  	}
	
  	public boolean checkTrabalhador(String passCorrecto,boolean restricao,String tipo)
  	{
  		if(jPasswordField1.getText().equals(passCorrecto))
  		{
  			new Interface_Trabalhador(restricao,tipo);
  			dispose();
  			return true;
  		}
  		else
  			return false;
  	}
}
