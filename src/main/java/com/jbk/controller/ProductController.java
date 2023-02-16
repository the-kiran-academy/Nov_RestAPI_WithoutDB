package com.jbk.controller;

import java.util.DoubleSummaryStatistics;
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
	@GetMapping(value = "/get-maxprice-product")
	public Product getMaxPriceProduct() {
		Product maxPriceProduct = service.getMaxPriceProduct();
		return maxPriceProduct;
		
	}
	
	@GetMapping(value = "/sort-productbyid-asc")
	public List<Product> sortProductById_ASC(){
		List<Product> sortProductById_ASC = service.sortProductById_ASC();
		return sortProductById_ASC;
		
	}
	@GetMapping(value = "/sort-product-byid-desc")
	public List<Product> sortProductById_DESC(){
		List<Product> sortProductById_DESC = service.sortProductById_DESC();
		return sortProductById_DESC;
		
	}
	
	@GetMapping(value = "/total-sumofproductprice")
	public Double countSumOfProductPrice() {
		Double countSumOfProductPrice = service.countSumOfProductPrice();
		return countSumOfProductPrice;
		
	}
	
	@GetMapping(value = "/get-totalcountof-Product")
	public Long getTotalCountOfProduct() {
		Long totalCountOfProduct = service.getTotalCountOfProduct();
		System.out.println(totalCountOfProduct);
		return totalCountOfProduct;
		
	}
		
	@GetMapping(value = "/get-ProductCount-StartsWithProductName_P")
	public int getProductStartsWithProductName_P() {
		int productCount = service.getProductCountStartsWithProductName_P();
		System.out.println(productCount);
		return productCount;
		
	}
	
	@GetMapping(value = "/averageOfproductprice")
	public Double averageOfProductPrice() {
		Double average = service.averageOfProductPrice();
		return average;
		
	}
	
	@GetMapping(value = "/SummaryOfProduct")
	public DoubleSummaryStatistics SummaryOfProduct() {
		DoubleSummaryStatistics summaryStatistics = service.SummaryOfProduct();
		return summaryStatistics;
		
	}
}
