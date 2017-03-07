package com.amarj.quickshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/* Add simple properties - same as Category table
 * generate getter/setter method.
 * Category c=new Category();
 * the instrance name will be same as the class name except first character will be 
 * lower case that is 
 */



@Component  //automatically instance will be created in the name of class but first alphabet is small
@Entity
@Table(name="Category") //if the class name and table name is different
public class Category {

@Id
private String	id;

@Column(name="name") // if the filed name or property name is different then only it is required.
private String	name;

private String	description;


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}





}
