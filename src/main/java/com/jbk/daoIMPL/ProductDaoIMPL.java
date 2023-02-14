package com.jbk.daoIMPL;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

@Repository
public class ProductDaoIMPL implements ProductDao 
{

	List<Product> list = new ArrayList<>();

	@Override
	public boolean saveProduct(Product product) 
	{
		boolean isAdded = list.add(product);
		return isAdded;
	}
	
	@Override
	public Product getProductById(long productById) 
	{
		Product product = list.stream().filter(filtered->filtered.getProductId() == productById).findFirst().orElse(null);
		return product;
	}

	@Override
	public List<Product> getProducts() 
	{
		for (Product product : list) 
		{
			System.out.println(product);
		}

		return list;
	}

	@Override
	public boolean deleteProductById(long productId) 
	{
		list.stream().filter(filtered->filtered.getProductId() == productId).findFirst().map(rem->list.remove(rem));
		//boolean removedProduct = list.remove(prod);
		return true;
	}

	

}
