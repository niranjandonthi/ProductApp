package com.rakuten.learning.ui;

import com.rakuten.learning.domain.Product;

import com.rakuten.learning.service.ProductService;
import com.rakuten.learning.service.ProductServiceImpl;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
 public class ProductConsoleUI {
	 
	ProductService service ;// new ProductServiceImpl();
	 @Autowired
	public void setService(ProductService service) {
    this.service = service;
  }
	public void createProductWithUI() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name - "); 
		String name=sc.nextLine();
		System.out.println("Enter price" );
		float price=sc.nextFloat();
		System.out.println("Enter Qoh" );
		int qoh=sc.nextInt();
		Product p = new Product(name , price, qoh);
		int id =service.addNewProduct(p);
		System.out.println("Id created with"+id ); 
		
  
	}
	
}
