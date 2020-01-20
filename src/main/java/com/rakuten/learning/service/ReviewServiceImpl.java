package com.rakuten.learning.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.learning.dal.ProductDAO;
import com.rakuten.learning.dal.ReviewDAO;
import com.rakuten.learning.domain.Product;
import com.rakuten.learning.domain.Review;
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
	@Autowired ReviewDAO reviewDAO;
	@Autowired ProductDAO productDAO;
	
	@Override
	public int addReviewToProduct(int productId, Review toBeAdded) {
		// TODO Auto-generated method stub
		Product product = productDAO.findById(productId);
	    if (product == null) {
	      throw new NoSuchProductException();
	    }
	    toBeAdded.setProduct(product);
	    Review added = reviewDAO.save(toBeAdded);
	    return added.getId();
	}

	@Override
	public List<Review> getByProductId(int productId) {
		// TODO Auto-generated method stub
		 return reviewDAO.findByProductId(productId);
	}
	

}
