package com.ojas.jpawebapplication.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ojas.jpawebapplication.entity.ProEntity;
import com.ojas.jpawebapplication.model.Product;
import com.ojas.jpawebapplication.repository.ProductRepository;
import com.ojas.jpawebapplication.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository proRepo;

	@Override
	public boolean saveProduct(Product pro) {
		// TODO Auto-generated method stub
		ProEntity product = new ProEntity();
		BeanUtils.copyProperties(pro, product);
		ProEntity entity = proRepo.save(product);
		boolean flag = false;
		if (entity != null)
			flag = true;
		return flag;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProEntity> findAll = proRepo.findAll();
		List<Product> addProducts = new ArrayList<Product>();
		for (ProEntity pro : findAll) {
			Product p = new Product();
			BeanUtils.copyProperties(pro, p);
			addProducts.add(p);
		}
		return addProducts;
	}

	@Override
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProduct(Product pro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		return false;
	}

}
