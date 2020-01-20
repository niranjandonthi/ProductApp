package com.rakuten.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.learning.dal.ProductDAO;
import com.rakuten.learning.dal.ProductDAOInMemImpl;
import com.rakuten.learning.domain.Product;
@Service
public class ProductServiceImpl implements ProductService{

  
  ProductDAO dao  ;//new ProductDAOInMemImpl();
  @Autowired
  public void setDao(ProductDAO dao) {
   this.dao = dao;
   }
  public int addNewProduct(Product toBeAdded) {
    // TODO Auto-generated method stub
	  if(toBeAdded.getPrice()*toBeAdded.getQoh()>=10000)
	  {
		  Product added =dao.save(toBeAdded);
		 return added.getId();
	  }
	  else
	  {
		  throw new IllegalArgumentException("Something");
	  }
  }

  @Override
  public void removeProduct(int id) {
    // TODO Auto-generated method stub
	  Product existing = dao.findById(id);
	  if(existing!=null)
	  {
		  if(existing.getPrice()*existing.getQoh()>=10000)
		  {
			  throw new IllegalStateException("U cant delete");
		  }
		  else
		  {
			 dao.deleteById(id);
		  }
	  }
	  else
	  {
		  throw new IllegalStateException("null");
	  }
    
  }

  @Override
  public List<Product> findByAll() {
    // TODO Auto-generated method stub
    return  dao.findAll();
  }

  @Override
  public Product findById(int id) {
    // TODO Auto-generated method stub
    return dao.findById(id);
  }
	
}
