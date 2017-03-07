package com.amarj.quickshopping;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amarj.quickshopping.model.Category;

public class CategoryTest {
	
	public static void main(String[] args)
	{
		/*
		 * we have get context
		 * ask context to get the bean i.e.,category
		 */
		
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		//specify in packge the classes are there
		
		context.scan("com.amarj");//it will scan all the classes which are there in com.nit package
		
		//create the instance
		context.refresh();
		
		//whatever the bean/instance required , you ask context
		Category c = (Category) context.getBean("category");
		
		System.out.println("Category instance created");
		 
		//ClassPathXmlApplicationContext - xml based
		
		
	} 

}
