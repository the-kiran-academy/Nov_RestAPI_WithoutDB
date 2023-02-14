package com.jbk.serviceIMPL;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.ProductDao;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService 
{

	// ProductDao dao = new ProductDaoIMPL();


	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) 
	{

		boolean isAdded = dao.saveProduct(product);
		return isAdded;
	}
	
	@Override
	public Product getProductById(long productId) 
	{
		Product product = dao.getProductById(productId);
		return product;
	}

	@Override
	public List<Product> getProducts() 
	{
		List<Product> products = dao.getProducts();
		return products;
	}

	@Override
	public boolean deleteProductById(long id) {

		return dao.deleteProductById(id);
	}

	public boolean updateProduct(Product product) {
		boolean isUpdated=dao.updateProduct(product);
		return isUpdated;
		
	}

}
