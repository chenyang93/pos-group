package SaleSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleSystem {
	
	
	public static void main(String[] args) throws IOException {
		  String source = "C:\\Users\\akhil\\Desktop\\Sale System\\csv files\\Product.csv";
		  
		  Inventory Sale = new Inventory();
		  
		  //TestCase1: Get specific product details based on the id
		  //productDetails(source, "8845");
		  //Sale.productDetails(source, "8845");
		  
		  //TestCase10: Update Values in existing csv
		  //Sale.updateProductCount(source, 8845, 898);
		  
		  //TesCase20: Inventory Report
		  /*List<Inventory> Products = Sale.getInventory(source);
		  System.out.println("ProductId,ProductName, ProductCount, ProductPrice, ProductSupplier");
		  for(Inventory u: Products) {
			  
			  System.out.printf("%d, %s, %d, %f, %s\n",u.getproductId(), u.getproductName(),u.getproductCount(),u.getproductPrice(),u.getproductSupplier());
		   }*/
		   
		  
		 
		  
	}
		  
	

}