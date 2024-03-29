package com.jbk.daoIMPL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {

	List<Product> list = new ArrayList<>();

	public ProductDaoIMPL() {
		list.add(new Product(1, "pen", 1, 1, 10, 10));
		list.add(new Product(2, "pencil", 1, 1, 10, 10));
		list.add(new Product(3, "book", 1, 1, 10, 100));

	}

	@Override
	public boolean saveProduct(Product product) {
		boolean isAdded = list.add(product);
		return isAdded;
	}

	@Override
	public Product getProductById(long productById) {
		Product product = list.stream().filter(filtered -> filtered.getProductId() == productById).findFirst()
				.orElse(null);
		return product;
	}

	@Override
	public List<Product> getProducts() {
		return list;
	}

	@Override
	public boolean deleteProductById(long id) {
//		IntStream.range(0, list.size())
//        .filter(i -> list.get(i).getProductId()==id)
//        .boxed()
//        .findFirst()
//        .map(i -> list.remove((int) i));
//		return true;

		boolean isDeleted = false;
		try {
			Product product = list.stream().filter(listProduct -> listProduct.getProductId() == id).findFirst().get();
			list.remove(product);
			isDeleted= true;
		} catch (NoSuchElementException e) {
			isDeleted = false;
		}
		return isDeleted;
	}

	@Override
	public List<Product> sortProductById_ASC() {

		try {
			List<Product> sortedProductList_ASC = list.stream()
					.sorted((p1, p2) -> ((Long) p1.getProductId()).compareTo(p2.getProductId()))
					.collect(Collectors.toList());
			return sortedProductList_ASC;
		} catch (Exception e) {
			return null;

		}

	}

	@Override
	public List<Product> sortProductById_DESC() {
		try {
			List<Product> sortProductById_ASC = list.stream()
			.sorted((p1, p2) -> ((Long) p2.getProductId()).compareTo(p1.getProductId()))
			.collect(Collectors.toList());
			return sortProductById_ASC;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Product getMaxPriceProduct() {
		Product maxPriceProduct = list.stream().max(Comparator.comparingDouble(val -> val.getProductPrice())).get();
		System.out.println(maxPriceProduct);
		return maxPriceProduct;
	}

	@Override
	public Double countSumOfProductPrice() {
		Double countSumOfProductPrice = list.stream().map(p->p.getProductPrice()).reduce((double) 0,(sum, price)->sum+price);
		return countSumOfProductPrice;
	}

	@Override
	public Long getTotalCountOfProduct() {
		Long totalCountOfProduct = list.stream().count();
		return totalCountOfProduct;
	}

}
