package com.rakuten.learning.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rakuten.learning.domain.Product;
@Repository
@Transactional
public class ProductDAOJpaImpl implements ProductDAO{
	@Autowired
	EntityManager em;
	

	@Override
	public Product save(Product tobeSaved) {
		// TODO Auto-generated method stub
		em.persist(tobeSaved);
		return tobeSaved;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		Product p=em.find(Product.class,id);
		System.out.println("this product has"+p.getReviews().size()+"reviews");
		return em.find(Product.class,id);
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("Select p from Product as p");
		List<Product> all=q.getResultList();
		return all;
	}

	@Override
	public void deleteById(int id) {
		 //TODO Auto-generated method stub
		Product p=em.getReference(Product.class,id);
		em.remove(p);
//		Query q=em.createQuery("delete from Product as p where p.id=1");
//		q.setParameter(1,id);
//		q.executeUpdate();
		
		
	}
	

}
