package com.ojas.jpawebapplication.service;

import java.util.List;

import com.ojas.jpawebapplication.model.Product;

public interface ProductService {

	public boolean saveProduct(Product pro);

	public List<Product> getAllProducts();

	public Product getProductById(int pid);

	public boolean updateProduct(Product pro);

	public boolean deleteProduct(int pid);

}
