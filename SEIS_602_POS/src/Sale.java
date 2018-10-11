import java.util.List;
import java.util.Date;

public class Sale {
	//private int saleId;
	//private Date saleDate;
	private List<Item> saleItemList;
	private double saleTotal;
//	public int getSaleId() {
//		return saleId;
//	}
//	public void setSaleId(int saleId) {
//		this.saleId = saleId;
//	}
	public Sale(List<Item> items,double saletotal){
		this.saleItemList=items;
		this.saleTotal=saletotal;
	}
	public Sale() {
		// TODO Auto-generated constructor stub
	}
	public List<Item> getSaleItemList() {
		return saleItemList;
	}
	public void setSaleItemList(List<Item> saleItemList) {
		this.saleItemList = saleItemList;
	}
	public double getSaleTotal() {
		return saleTotal;
	}
	public void setSaleTotal(double saleTotal) {
		this.saleTotal = saleTotal;
	}
	
}
