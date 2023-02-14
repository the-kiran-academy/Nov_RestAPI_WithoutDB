package com.jbk.service;

import java.util.List;

import com.jbk.model.Product;

public interface ProductService {
	
	public boolean saveProduct(Product product);
	public List<Product> getProducts();
	public boolean deleteProductById(long id);
	public boolean updateProduct(Product product);
}
