package com.jbk.daoIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {

	List<Product> list = new ArrayList<>();

	@Override
	public boolean saveProduct(Product product) {
		list.add(product);

		return true;
	}

	@Override
	public List<Product> getProducts() {

		return list;
	}

	@Override
	public boolean deleteProductById(long id) {
		return false;
	}

}
