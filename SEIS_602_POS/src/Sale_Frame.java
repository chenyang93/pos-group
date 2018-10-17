import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Sale_Frame extends JFrame implements ActionListener{
	
	private JButton addItemButton;
	private JButton deleteItemButton;
	private JButton updateItemButton;
	private JButton logOutButton;
	private JButton endSaleButton;
	private JButton cancelSaleButton;
	
	private JTextArea textShow;
	private JScrollPane scroll;
	private String itemdatabase;
	PosSystem system=new PosSystem();
	Sale newsale;
	AddItem_Frame addItem;
	private List<Item> items=null;
	private double saleTotal=0.0;
	private String saleoperation="";
	
	public Sale_Frame(String sale){
		setLayout(null);
		setSize(800,600);
		saleoperation=sale;
		addItemButton=new JButton("Add Item");
		addItemButton.setBounds(800*4/5,600/8,100,50);
		add(addItemButton);
		
		deleteItemButton=new JButton("Delete Item");
		deleteItemButton.setBounds(800*4/5,600*2/8,100,50);
		add(deleteItemButton);
		
		updateItemButton=new JButton("Update Item");
		updateItemButton.setBounds(800*4/5,600*3/8,100,50);
		add(updateItemButton);
		
		endSaleButton=new JButton("End Sale");
		endSaleButton.setBounds(800*4/5,600*4/8,100,50);
		add(endSaleButton);
		
		cancelSaleButton=new JButton("Cancel Sale");
		cancelSaleButton.setBounds(800*4/5,600*5/8,100,50);
		add(cancelSaleButton);
		
		logOutButton=new JButton("Log Out");
		logOutButton.setBounds(800*4/5,600*6/8,100,50);
		add(logOutButton);
		
		addItemButton.addActionListener(this);
		deleteItemButton.addActionListener(this);
		updateItemButton.addActionListener(this);
		endSaleButton.addActionListener(this);
		cancelSaleButton.addActionListener(this);
		logOutButton.addActionListener(this);
		
		textShow=new JTextArea();  
		textShow.setBackground(Color.white);  
		textShow.setForeground(Color.black);  
		textShow.setEditable(false);
		Font font = textShow.getFont();
		float size = font.getSize() + 5.0f;
		textShow.setFont( font.deriveFont(size) );
		
		scroll = new JScrollPane (textShow, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(800/16,600/16,3*800/5,5*600/6);  
		add(scroll);
		if(sale.equals("Sale")){
			//newsale=new Sale(items,saleTotal);
			newsale=new Sale();
			itemdatabase="Database/itemdatabase.csv";
		}
		newsale.connectInventory(itemdatabase);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==logOutButton){
			Login_Frame login = new Login_Frame();
			login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			login.setVisible(true);
			
			this.setVisible(false);
			dispose();
		}
		if(e.getSource()==addItemButton){
			addItem=new AddItem_Frame("Add",newsale,textShow,saleoperation);
			addItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addItem.setVisible(true);
		}
		if(e.getSource()==deleteItemButton){
			addItem=new AddItem_Frame("Delete",newsale,textShow,saleoperation);
			addItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addItem.setVisible(true);
		}
		if(e.getSource()==updateItemButton){
			addItem=new AddItem_Frame("Update",newsale,textShow,saleoperation);
			addItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addItem.setVisible(true);
		}
		if(e.getSource()==endSaleButton){
			if(newsale.getSaleSize()>0){
				newsale.updateToInventory(itemdatabase);
				JOptionPane.showMessageDialog(null,"Transaction Has Been Ended");
				PosSystem sys=new PosSystem();
	            Cashier_Frame cashier = new Cashier_Frame(sys);
	            cashier.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            cashier.setVisible(true);
	            this.setVisible(false);
	 			this.dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Cart is currently empty. Please add items before ending transaction");
			}
		}
		if(e.getSource()==cancelSaleButton){
			JOptionPane.showMessageDialog(null,"Transaction Has Been Cancelled");
			PosSystem sys=new PosSystem();
            Cashier_Frame cashier = new Cashier_Frame(sys);
            cashier.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cashier.setVisible(true);

            this.setVisible(false);
            dispose();
		}
	}

}
