package com.springdatajpa.spring_data_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.spring_data_jpa.entity.Product;
import com.springdatajpa.spring_data_jpa.repository.productRepository;


@Service
public class productService {
	
	private productRepository repository;
	
	@Autowired
	public productService(productRepository repository) {
		this.repository = repository;
	}
	
//	Add product
	
	public boolean addProduct(Product product) {
		if(repository.existsByName(product.getName())) {
			return false;
		}
		repository.save(product);
		return true;
	}
    
    //	get all the products in the database
	public Optional<List<Product>> getAllProducts(){
		List<Product> products = repository.findAll();
		return products.isEmpty() ? Optional.empty() : Optional.of(products);
	}
	
    // update the products	
	public Optional<Product> updateProduct(Long id, Product product) {
	    Optional<Product> pro = repository.findById(id);
	    if(pro.isPresent()) {
	    	Product existingProduct = pro.get();
	    	existingProduct.setId(product.getId());
	    	existingProduct.setName(product.getName());
	    	existingProduct.setActive(product.isActive());
	    	existingProduct.setName(product.getName());
	    	existingProduct.setDescription(product.getDescription());
	    	existingProduct.setSku(product.getSku());
	    	existingProduct.setImageUrl(product.getImageUrl());
	    	existingProduct.setLastUpdated(product.getLastUpdated());
	    	existingProduct.setPrice(product.getPrice());
	    	pro = Optional.of(existingProduct);
	    }
	    return pro;
	    
	}
	
   //	Delete the product
	 public boolean deleteProduct(Long id){	
		 if(repository.existsById(id)) {
			 repository.deleteById(id);
			 return true;
		 }
		 return false;
	 }
	
	
	

}

