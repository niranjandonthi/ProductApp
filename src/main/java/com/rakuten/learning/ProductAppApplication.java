package com.rakuten.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.learning.dal.ProductDAO;
import com.rakuten.learning.dal.ReviewDAO;
import com.rakuten.learning.domain.Product;
import com.rakuten.learning.domain.Review;
import com.rakuten.learning.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductAppApplication {

  public static void main(String[] args) {
    //ApplicationContext springContainer =
    		SpringApplication.run(ProductAppApplication.class, args);//It generates spring container
//    ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//    ui.createProductWithUI();
//    
//
////    ReviewDAO reviewDAO = springContainer.getBean(ReviewDAO.class);
////    Review sample = new Review("self", "this is good", 5);
////    Review saved = reviewDAO.save(sample,1);
////    System.out.println("Created review with id: " + saved.getId());
//    ProductDAO productDAO=springContainer.getBean(ProductDAO.class);
//    Product p=productDAO.findById(3
//    		);
//    System.out.println(p.getName());
//    System.out.println("this product has reviews"+p.getReviews().size());
////    ProductDAO productDAO2=springContainer.getBean(ProductDAO.class);
////    productDAO2.deleteById(1);
  }
}
