package com.jbk.dao;

import java.util.List;

import com.jbk.model.Product;

public interface ProductDao 
{
	
	public boolean saveProduct(Product product);
	public Product getProductById(long productById);
	public List<Product> getProducts();
	public boolean deleteProductById(long productId);
	public List<Product> sortProductById_ASC();
	public List<Product> sortProductById_DESC();
	public Product getMaxPriceProduct();
	public Double countSumOfProductPrice();
	public Long getTotalCountOfProduct();
	public Product updateProduct(Product product);

}
