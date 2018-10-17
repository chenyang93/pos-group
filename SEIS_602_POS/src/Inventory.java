import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Inventory {
	private static Inventory uniqueInstance = null;
	public Inventory(){
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
				lineSort = line.split(",");
				databaseItem.add(new Item(lineSort[0],lineSort[1],Float.parseFloat(lineSort[2]),
						Integer.parseInt(lineSort[3]),lineSort[4]));
			}
			textReader.close();
		}catch(FileNotFoundException ex) {
	            System.out.println(
	                "Cannot open the database file '" + 
	                		databaseFile + "'"); 
	            ableToOpen = false;
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error occcurs when reading database file '" 
	                + databaseFile + "'");  
	            ableToOpen = false;
	        }
		
		
		return ableToOpen;
		
	}
	public void updateInventory(String databaseFile,List<Item> saleItem,List<Item> databaseItem){
		int newTotalQuantity;
		for(int i=0;i<saleItem.size();i++){
			for(int j=0;j<databaseItem.size();j++){
				if(saleItem.get(i).getItemId().equals(databaseItem.get(j).getItemId())){
					newTotalQuantity=databaseItem.get(j).getQuantity()-saleItem.get(i).getQuantity();
					databaseItem.get(j).setQuantity(newTotalQuantity);
				}
			}
		}
		try{
			File file=new File(databaseFile);
			FileWriter fileR = new FileWriter(file.getAbsoluteFile(),false);
			BufferedWriter bWriter = new BufferedWriter(fileR);
			PrintWriter writer = new PrintWriter(bWriter);
			for(int i=0;i<databaseItem.size();i++){
				writer.println(String.valueOf(databaseItem.get(i).getItemId()) + "," + databaseItem.get(i).getItemName() + ","
						+ String.valueOf(databaseItem.get(i).getPrice() ) + "," +
						String.valueOf( databaseItem.get(i).getQuantity())+","+databaseItem.get(i).getSupplier() );
			}
			bWriter.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
