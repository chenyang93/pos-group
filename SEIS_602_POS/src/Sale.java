import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Sale {
	private int saleId;
	//private Date saleDate;
	private List<Item> saleItem;
	private double saleTotal;
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	Inventory inventory=Inventory.getInstance();
	public List<Item> inventorylist=new ArrayList<Item>();
	public Sale(List<Item> items,double saletotal){
		this.saleItem=items;
		this.saleTotal=saletotal;
	}
	public Sale() {
		// TODO Auto-generated constructor stub
		saleItem=new ArrayList<Item>();		
		saleTotal=0.0;
	}
	public List<Item> getSaleItemList() {
		return saleItem;
	}
	public void setSaleItemList(List<Item> saleItemList) {
		this.saleItem = saleItemList;
	}
	public double getSaleTotal() {
		return saleTotal;
	}
	public void setSaleTotal(double saleTotal) {
		this.saleTotal = saleTotal;
	}
	public boolean connectInventory(String database){
		if(inventory.accessInventory(database,inventorylist)==true)
			return true;
		return false;
	}
	public boolean addItem(String id,int quantity){
		boolean finditem=false;
		for(int i=0;i<inventorylist.size()&&finditem==false;i++){
			if(inventorylist.get(i).getItemId().equals(id)){
				Item item=new Item(id,inventorylist.get(i).getItemName(),inventorylist.get(i).getPrice(),quantity,inventorylist.get(i).getSupplier());
				saleItem.add(item);
				finditem=true;
			}
		}
		return finditem;
	}
	public boolean removeItem(String id){
		boolean finddeleteitem=false;
		int index=-1;
		for(int i=0;i<this.saleItem.size();i++){
			if(id.equals(this.saleItem.get(i).getItemId())){
				index=i;
				finddeleteitem=true;
			}
		}
		if(finddeleteitem==true){
			this.saleTotal -= this.saleItem.get(index).getPrice()*(this.saleItem.get(index).getQuantity());
			this.saleItem.remove(this.saleItem.get(index));
			return true;
		}
		return finddeleteitem;
	}
	public boolean updateItem(String id, int quantity){
		boolean findupdateitem=false;
		int index=-1;
		for(int i=0;i<this.saleItem.size();i++){
			if(id.equals(this.saleItem.get(i).getItemId())){
				index=i;
				findupdateitem=true;
			}
		}
		if(findupdateitem=true){
			this.saleTotal -= this.saleItem.get(index).getPrice()*(this.saleItem.get(index).getQuantity());
			this.saleItem.get(index).setQuantity(quantity);
			this.saleTotal += this.saleItem.get(index).getPrice()*(this.saleItem.get(index).getQuantity());
		}
		return findupdateitem;
	}
	public void updateToInventory(String database){
		inventory.updateInventory(database, this.saleItem, inventorylist);
	}
	public void updateTotalPirce(){
		this.saleTotal+=this.saleItem.get(this.saleItem.size()-1).getPrice()*this.saleItem.get(this.saleItem.size()-1).getQuantity();
	}
	public int getSaleSize(){
		return this.saleItem.size();
	}
}
