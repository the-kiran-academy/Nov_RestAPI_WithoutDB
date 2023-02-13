package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Product;
import com.jbk.service.ProductService;

@RestController
public class ProductController {

	// ProductService service = new ProductServiceIMPL();

	@Autowired
	private ProductService service;

	@PostMapping(value = "/save-product")
	public boolean saveProduct(@RequestBody Product product) {

		boolean isAdded = service.saveProduct(product);

		return isAdded;

	}

	@GetMapping(value = "/get-all-product")
	public List<Product> getAllProduct() {
		List<Product> products = service.getProducts();
		return products;
	}
	
	@DeleteMapping(value = "/delete-by-id/{id}")
	public boolean deleteProductById(@PathVariable long id) {
		return service.deleteProductById(id);
		
	}

}
