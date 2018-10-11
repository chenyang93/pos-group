import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AddItem_Frame extends JFrame implements ActionListener{
	private JTextField itemID;      
	private JTextField amount;
	private JButton enterButton;
	private JButton exitButton;
	private JLabel itemIdLabel;
	private JTextArea transDialog;
	private JLabel itemAmount;
	
	private String quantity="";
	private String id="";
	Sale sale=new Sale();
	public List<Item> databaseItem = new ArrayList<Item>(); 
	public List<Item> transactionItem = new ArrayList<Item>();
	String itemdatabase="";
	Inventory inventory;
	public AddItem_Frame(String itemdatabase,Sale newsale,JTextArea textShow,String operation){
		setLayout(null);
		setSize(520,200);
		setLocation(500,280);
		
		this.sale=newsale;
		transDialog = textShow;
		this.itemdatabase=itemdatabase;
		
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
		
		amount = new JTextField(15);
		amount.setToolTipText("amount");
		amount.setBounds(180,65,150,20);
		add(amount);
		
		itemAmount = new JLabel("Amount:");
		itemAmount.setBounds(90,65,150,20);
		add(itemAmount);
		
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
//		if(e.getSource()==enterButton){
//			id=itemID.getText();
//			quantity=amount.getText();
//			inventory.accessInventory(itemdatabase, databaseItem);
//			boolean foundItem = false;
//			for (int counter = 0; counter < databaseItem.size() && foundItem == false; counter++){
//				if (databaseItem.get(counter).getItemId() == id) //checks if item is found on the database
//			      {
//					transactionItem.add(new Item(id,databaseItem.get(counter).getItemName(),databaseItem.get(counter).getPrice(),databaseItem.get(counter).getQuantity(),databaseItem.get(counter).getSupplier()));
//			      }
//			}
//		}
	}

}
