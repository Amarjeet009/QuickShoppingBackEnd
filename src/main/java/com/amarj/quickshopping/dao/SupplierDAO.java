package com.amarj.quickshopping.dao;

import java.util.List;

import com.amarj.quickshopping.model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> list();

	public Supplier get(String id);

	public boolean saveOrUpdate(Supplier supplier);

	public boolean delete(String id);
	
	public Supplier deleteSupplierById(String id);

}
