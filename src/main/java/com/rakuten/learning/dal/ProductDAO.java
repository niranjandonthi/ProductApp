package com.rakuten.learning.dal;
import java.util.List;

import com.rakuten.learning.domain.Product;
public interface ProductDAO {
	Product save(Product tobeSaved);
	Product findById(int id);
	List<Product> findAll();
	void deleteById(int id);
}
