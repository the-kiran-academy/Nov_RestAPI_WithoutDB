package com.jbk.serviceIMPL;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.ProductDao;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	// ProductDao dao = new ProductDaoIMPL();

	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {

		boolean isAdded = dao.saveProduct(product);
		return isAdded;
	}

	@Override
	public Product getProductById(long productId) {
		Product product = dao.getProductById(productId);
		return product;
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products = dao.getProducts();
		return products;
	}

	@Override
	public boolean deleteProductById(long id) {

		return dao.deleteProductById(id);
	}

	@Override
	public List<Product> sortProductById_ASC() {
		List<Product> sortProductById_ASC = dao.sortProductById_ASC();
		return sortProductById_ASC;
	}

	@Override
	public List<Product> sortProductById_DESC() {
		List<Product> sortProductById_DESC = dao.sortProductById_DESC();
		return sortProductById_DESC;
	}

	@Override
	public Product getMaxPriceProduct() {
		Product maxPriceProduct = dao.getMaxPriceProduct();
		return maxPriceProduct;
	}

	@Override
	public Double countSumOfProductPrice() {
		Double countSumOfProductPrice = dao.countSumOfProductPrice();
		return countSumOfProductPrice;
	}

	@Override
	public Long getTotalCountOfProduct() {
		Long totalCountOfProduct = dao.getTotalCountOfProduct();
		
		return totalCountOfProduct;
	}

}
