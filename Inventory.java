import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Inventory {
	private int itemId;
	private int quantity;
	private int threshold;
	private boolean orderPlaced;
	private static Inventory uniqueInstance = null;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public boolean isOrderPlaced() {
		return orderPlaced;
	}
	public void setOrderPlaced(boolean orderPlaced) {
		this.orderPlaced = orderPlaced;
	}
	public static synchronized Inventory getInstance()
	{
		if (uniqueInstance == null)
			uniqueInstance = new Inventory();
		return uniqueInstance;
	}
	public boolean accessInventory(String databaseFile,List<Item> databaseItem){
		boolean ableToOpen = true;
		String line = null;
		String[] lineSort;
		try {
			FileReader fileR = new FileReader(databaseFile);
			BufferedReader textReader = new BufferedReader(fileR);
			//reads the entire database
			while ((line = textReader.readLine()) != null)
			{
				lineSort = line.split(" "); //separates words
				databaseItem.add(new Item(lineSort[0],lineSort[1],Float.parseFloat(lineSort[2]),
						Integer.parseInt(lineSort[3]),lineSort[4]));
			}
			textReader.close();
		}catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                		databaseFile + "'"); 
	            ableToOpen = false;
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + databaseFile + "'");  
	            ableToOpen = false;
	        }
		
		
		return ableToOpen;
		
	}
}
