package com.amarj.quickshopping.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amarj.quickshopping.dao.SupplierDAO;
import com.amarj.quickshopping.model.Supplier;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SupplierTestCase {
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amarj.quickshopping");
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
	}
	
	@Test
	public void TestCreateSupplier()
	{
		supplier.setId("SP005");
		supplier.setName("Swati Mishra");
		supplier.setAddress("Funmaza.com collection, Rohini, Delhi");
		
		boolean flag=supplierDAO.saveOrUpdate(supplier);
		
		Assert.assertEquals("Test Case of Supplier",true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = supplierDAO.delete("SP005");
		
		Assert.assertEquals("delete Supplier test case", true,flag);
		
	}


}
