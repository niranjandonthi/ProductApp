package com.rakuten.learning.service;

import java.util.List;

import com.rakuten.learning.domain.Product;

public interface ProductService {
	
	int addNewProduct(Product toBeAdded);
	void removeProduct(int id);
	List<Product> findByAll();
	Product findById(int id);
	
	
}
