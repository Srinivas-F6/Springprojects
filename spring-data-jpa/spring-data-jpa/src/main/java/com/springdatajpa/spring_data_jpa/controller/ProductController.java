package com.springdatajpa.spring_data_jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springdatajpa.spring_data_jpa.entity.Product;
import com.springdatajpa.spring_data_jpa.repository.productRepository;
import com.springdatajpa.spring_data_jpa.service.productService;

@RestController
@CrossOrigin // optional, allows frontend access
public class ProductController {

    private  productService service;
    private productRepository repo;

    @Autowired
    public ProductController(productService service,productRepository repo) {
        this.service = service;
        this.repo = repo;
    }
    
    @PostMapping("/post/allProduct")
    
    public ResponseEntity<List<String>> addAllProducts(@RequestBody List<Product> products) {
    	List<String> res = new ArrayList<>();
    	for(Product product: products) {
    		boolean add = service.addProduct(product);
    		if(add) {
    			res.add(product.getName()+"  Product Successfully Added");
    		}
    		else {
    			res.add(product.getName()+"  Product already Exists");
    		}
    	}
    	return ResponseEntity.ok(res);
    }
    
    @PostMapping("/post/details")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        boolean add = service.addProduct(product);
        if(add) {
        	return ResponseEntity.ok("Product Added Successfully");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already Exists");
    }
    
    @GetMapping("/get/info")
    public ResponseEntity<List<Product>> getAllProducts(){
    	return service.getAllProducts()
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.noContent().build()	);
    }
    
    @PutMapping("/update/details/{id}")
    public ResponseEntity<?> updateProduct(@ PathVariable Long id, @RequestBody Product product){
    	product.setId(id);
    	return service.updateProduct(id, product)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.noContent().build());
    }
    
    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
    	boolean deleted = service.deleteProduct(id);
    	if(deleted) {
    		return ResponseEntity.ok("Product successfully deleted");
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
    
    @DeleteMapping("/delete/all")
    	public void deleteAll() {
    		repo.deleteAll();
    	}
 }
