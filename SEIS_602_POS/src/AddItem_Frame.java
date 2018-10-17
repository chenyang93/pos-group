import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AddItem_Frame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField itemID;      
	private JTextField amount;
	private JButton enterButton;
	private JButton exitButton;
	private JLabel itemIdLabel;
	private JTextArea transDialog;
	private JLabel itemAmount;
	
	private int quantity=0;
	private String id="";
	Sale sale;
	public List<Item> databaseItem = new ArrayList<Item>(); 
	public List<Item> salelist= new ArrayList<Item>();
	String addFlag;
	Inventory inventory;
	public AddItem_Frame(String flag,Sale newsale,JTextArea textShow,String operation){
		setLayout(null);
		setSize(520,200);
		setLocation(500,280);
		
		sale=newsale;
		transDialog = textShow;
		addFlag=flag;
		
		enterButton = new JButton("Enter");
		enterButton.setBounds(170,100,80,20);
		add(enterButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(270,100,80,20);
		add(exitButton);
		
		itemID = new JTextField(15);
		itemID.setToolTipText("itemID:");
		itemID.setBounds(180,30,150,20);
		add(itemID);
		
		itemIdLabel = new JLabel("Item ID:");
		itemIdLabel.setBounds(90,30,150,20);
		add(itemIdLabel);
		
		if (addFlag.equals("Add")||addFlag.equals("Update")){ 
			amount = new JTextField(15);
			amount.setToolTipText("amount");
			amount.setBounds(180,65,150,20);
			add(amount);
			
			itemAmount = new JLabel("Amount:");
			itemAmount.setBounds(90,65,150,20);
			add(itemAmount);
		}
		
		enterButton.addActionListener(this);
		exitButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exitButton){ //Cancels
			this.setVisible(false);
			dispose();
		
		}
		if(e.getSource()==enterButton){
			id=itemID.getText();
			if(addFlag.equals("Add")){
				quantity=Integer.parseInt(amount.getText());
				if(!sale.addItem(id,quantity)){
					JOptionPane.showMessageDialog(null, "Item cannot be found from inventory");
				}else{
					sale.updateTotalPirce();
					updateTextArea();
				}
			}else if(addFlag.equals("Delete")){
				if(!sale.removeItem(id)){
					JOptionPane.showMessageDialog(null, "Item cannot be found from cart");
				}else{
					updateTextArea();
				}
			}else if(addFlag.equals("Update")){
				quantity=Integer.parseInt(amount.getText());
				if(!sale.updateItem(id,quantity)){
					JOptionPane.showMessageDialog(null, "Item cannot be found from inventory");
				}else{
					sale.updateTotalPirce();
					updateTextArea();
				}
			}
			this.setVisible(false);
			dispose();
		}
	}
	public void updateTextArea(){
		transDialog.setText(null);
		salelist=sale.getSaleItemList();
		for(Item item:salelist){
			String itemString=item.getItemId()+"\t"+item.getItemName()+"\t"+ "x" + item.getQuantity() + "\t$" + String.format("%.2f", item.getQuantity()*item.getPrice()) + "\n";
			transDialog.append(itemString);
		}
	}
}
