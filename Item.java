
public class Item {
	private String itemId;
	private String itemName;
	private float price;
	private int quantity;
	private String supplier;
	
	public Item(String itemid,String itemname,float price,int quantity,String supplier){
		this.itemId=itemid;
		this.itemName=itemname;
		this.price=price;
		this.quantity=quantity;
		this.supplier=supplier;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	public void updateQuantity(int quantity){
		this.quantity=quantity;
	}
}
