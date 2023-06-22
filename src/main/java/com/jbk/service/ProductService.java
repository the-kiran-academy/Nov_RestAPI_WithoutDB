package com.jbk.service;

import java.util.List;
import com.jbk.model.Product;

public interface ProductService 
{
	
	public boolean saveProduct(Product product);
	public Product getProductById(long productId);
	public List<Product> getProducts();
	public boolean deleteProductById(long productId);
  public boolean updateProduct(Product product);
	public List<Product> sortProductById_ASC();
	public List<Product> sortProductById_DESC();
	public Product getMaxPriceProduct();
	public Double countSumOfProductPrice();
	public Long getTotalCountOfProduct();
}
