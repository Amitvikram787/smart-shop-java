package org.cognizant.product.services;

import java.util.List;

import javax.transaction.Transactional;

import org.cognizant.product.entities.Product;
import org.cognizant.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@Transactional
	public Product getProductById(@PathVariable String code){
		return productRepository.findById(code).get();
	}
	
	@Transactional
	public List<Product> getProductsByCategory(int id) {
		return productRepository.findProductsByCategory(id);
	}
}
