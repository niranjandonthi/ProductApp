package com.rakuten.learning.service;

import java.util.List;

import com.rakuten.learning.domain.Review;

public interface ReviewService {
	
	public int addReviewToProduct(int productId,Review toBeAdded);
	public List<Review> getByProductId(int productId);
}