package com.amarj.quickshopping.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amarj.quickshopping.dao.CategoryDAO;
import com.amarj.quickshopping.model.Category;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CategoryTestCase {

	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.amarj");
		context.refresh(); //its a bean factory used to refresh.
		
		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	// TestCase
	
	@Test
	public void createCategoryTestCase()
	{   
		category.setId("CG003");
		category.setName("Accessories");
		category.setDescription("collection of all kind of accessories");
		
	    boolean flag = categoryDAO.save(category);
	 //compare what you are expecting VS what you are getting from save method.
	 
	 Assert.assertEquals("create categoryTestCase",true, flag);
	}
	
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("CG03032017");
		category.setName("NewCategory");
		category.setDescription("this is Discography category");
		
		boolean flag= categoryDAO.update(category);
		
	   Assert.assertEquals("updateCategoryTestCase",true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = categoryDAO.delete("CT02022017");
		
		Assert.assertEquals("delete category test case", true,flag);
		
	}

	@Test
	public void deleteCategoryByIDTestCase()
	{
		boolean flag = categoryDAO.delete("CG04032017");
		
		Assert.assertEquals("deleteCategoryByIDTestCase",true, flag);
	}
	
	@Test
	public void getCategorybyIDTestCase()
	{
		category = categoryDAO.getCategoryByID("CG0203201");
		
		Assert.assertEquals("getCategoryByIDTestCase",null, category);
	}
	
	
	@Test
	public void getAllCategoryTestCase()
	{
		int recordsFromDAO = categoryDAO.list().size();
		
		assertEquals("getAllCategoryTestCase",7, recordsFromDAO);
	}
	
	
}
