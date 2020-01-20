package com.rakuten.learning.dal;

import java.util.List;

import com.rakuten.learning.domain.Review;

public interface ReviewDAO {

  Review findById(int id);

  Review save(Review toBeSaved);

  void deleteById(int id);

  List<Review> findAll();
  List<Review> findByProductId(int productId);
}

