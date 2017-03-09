package com.amarj.quickshopping.dao;

import java.util.List;

import com.amarj.quickshopping.model.Product;

public interface ProductDAO {
	
	public List<Product> list();
	
	public Product get(String id);
	
	public boolean save(Product product);
	
	public boolean delete(String id);

	public Product getDeleteById(String id);
	
	

}
