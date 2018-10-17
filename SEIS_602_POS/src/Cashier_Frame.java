import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Cashier_Frame extends JFrame implements ActionListener{
	private JButton saleButton;
	private JButton returnButton;
	private JButton logOutButton;
	
	PosSystem system=new PosSystem();
	Sale_Frame saleframe;
	public Cashier_Frame(PosSystem system2){
		setLayout(null);
		setSize(800,600);
		
		saleButton=new JButton("Sale");
		saleButton.setBounds(100,600/5,600,100);
		add(saleButton);
		
		returnButton=new JButton("Return");
		returnButton.setBounds(100,600*2/5,600,100);
		add(returnButton);
		
		logOutButton=new JButton("Log Out");
		logOutButton.setBounds(100,600*3/5,600,100);
		add(logOutButton);
		
		saleButton.addActionListener(this);
		returnButton.addActionListener(this);
		logOutButton.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==saleButton){
			saleframe = new Sale_Frame("Sale");
			saleframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			saleframe.setVisible(true);
			this.setVisible(false);
			dispose();
		}
		if(e.getSource()==logOutButton){
			Login_Frame login = new Login_Frame();
			login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			login.setVisible(true);
			
			this.setVisible(false);
			dispose();
		}
	}
}
