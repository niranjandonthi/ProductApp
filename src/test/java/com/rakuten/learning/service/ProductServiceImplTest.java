package com.rakuten.learning.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.rakuten.learning.dal.ProductDAO;
import com.rakuten.learning.domain.Product;

public class ProductServiceImplTest {

	@Test
	public void addNewProduct_returns_valid_Id_When_ProductValue_GTEQ_MinValue() {
		//Arrange
		ProductServiceImpl service = new ProductServiceImpl();
		Product toBeAdded = new Product("test",10000,1);
		ProductDAO mockdao=Mockito.mock(ProductDAO.class);
		Product saved=new Product("test",10000,1);
		saved.setId(1);
		Mockito.when(mockdao.save(toBeAdded)).thenReturn(saved);
		service.setDao(mockdao);
		//Act
		int id=service.addNewProduct(toBeAdded);
		//Assert
		assertTrue(id>0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void addNewProduct_returns_valid_Id_When_ProductValue_LT_MinValue() {
		//Arrange
		ProductServiceImpl service = new ProductServiceImpl();
		Product toBeAdded = new Product("test",999,1);
		//Act
		int id=service.addNewProduct(toBeAdded);
		//Assert	
	}
	@Test
	public void removeProduct_return_valid_Id_When_ProductVallue_LT_MinValue() {
		//Arrange
		ProductServiceImpl service = new ProductServiceImpl();
		Product removed=new Product("test",9999,1);
		removed.setId(1);
		ProductDAO mockdao =Mockito.mock(ProductDAO.class);
		Mockito.when(mockdao.findById(1)).thenReturn(removed);
		service.setDao(mockdao);
		service.removeProduct(removed.getId());
		Mockito.verify(mockdao).deleteById(removed.getId());
		//Act
		//Assert
	}
	@Test(expected = IllegalStateException.class)
	public void removeProduct_returns_exception_GTEQ_MinValue() {
		
		ProductServiceImpl service = new ProductServiceImpl();
		Product removed=new Product("test",99999,1);
		removed.setId(1);
		ProductDAO mockdao =Mockito.mock(ProductDAO.class);
		Mockito.when(mockdao.findById(1)).thenReturn(removed);
		service.setDao(mockdao);
		service.removeProduct(removed.getId());
		Mockito.verify(mockdao);
	}
	@Test(expected = IllegalStateException.class)
	public void removeProduct_returns_exception_If_Null()
	{
		Product p=null;
		ProductServiceImpl service = new ProductServiceImpl();
		ProductDAO mockdao =Mockito.mock(ProductDAO.class);
		Mockito.when(mockdao.findById(1)).thenReturn(p);
		service.setDao(mockdao);
		service.removeProduct(1);
	}
	
}
