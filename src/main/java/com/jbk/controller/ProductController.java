package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Product;
import com.jbk.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService service;

	@PostMapping(value = "/saveProduct")
	public boolean saveProduct(@RequestBody Product product) 
	{
		boolean isAdded = service.saveProduct(product);
		return isAdded;
	}
	
	@GetMapping(value = "/getProductById/{productId}")
	public Product getProductById(@PathVariable("productId") long productId)
	{
		Product product = service.getProductById(productId);
		return product;
	}
	

	@GetMapping(value = "/getAllProducts")
	public List<Product> getAllProduct() 
	{
		List<Product> products = service.getProducts();
		return products;
	}
	
	@DeleteMapping(value = "/deleteProductById/{productId}")
	public boolean deleteProductById(@PathVariable long productId) 
	{
		return service.deleteProductById(productId);	
	}
	
	//@PutMapping

}
