package com.amarj.quickshopping.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amarj.quickshopping.dao.UserDAO;
import com.amarj.quickshopping.model.User;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext  context;
	
	@Autowired
    private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	
	
	//Previously we written constructor
	//But in JUnit we need to write a method
	//this method should call automatically when JUnit Test case run
	//we can write @BeforeClasses only for the static methods
	
	@BeforeClass    
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.amarj.quickshopping");
		context.refresh();
		
		 user = (User) context.getBean("user");
		
		 userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	@Test
	public void validateCredentialsTestCase()
	{
		boolean flag = userDAO.validate("ankit", "ankit123");
		
		Assert.assertEquals( "validateCredentialsTestCase",true, flag);
	}
	
	
	
	
	@Test
	public void TestCreateUser()
	{
		user.setId("UR006");
		user.setName("Monu");
		user.setPassword("monu123");
		user.setMail("monunick@gmail.com");
		user.setMobile("7042740028");
		user.setRole("ROLE_USER ");
		
		boolean flag= userDAO.save(user);
		
		Assert.assertEquals("create UserTestCase",true, flag);
	}
	
	/*@Test
	public void deleteTestCase()
	{
		boolean flag = userDAO.delete("UR004");
		
		Assert.assertEquals("delete test case", true,flag);
		
		
	}*/
	
	@Test
	public void updateUserTestCase()
	{
	user.setId("UR003");
	user.setName("Ankit Chaurasia");
	user.setPassword("ankit@123");
	user.setMail("ankitch08@gmail.com");
	user.setMobile("789343221");
	user.setRole("ROLE_USER");
	
	boolean flag= userDAO.update(user);
	
	Assert.assertEquals("UpdateUserTestCase",true, flag);
	}
	
	@Test
	public void getAllUserTestCase()
	{
		int recordsFromDAO = userDAO.list().size();
		
		assertEquals("getAllCategoryTestCase",7, recordsFromDAO);
	}
	

}
