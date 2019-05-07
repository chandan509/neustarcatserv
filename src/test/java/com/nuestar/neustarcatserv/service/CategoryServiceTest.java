package com.nuestar.neustarcatserv.service;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.nuestar.neustarcatserv.model.Category;

public class CategoryServiceTest {
	private CategoryService service = null;
	
	@BeforeClass
	public void setup(){
		service = new CategoryService();
	}
	
	@Ignore
	@Test
	public void defauktCategoryTest(){
		Set<Category> catSet =  service.getAll();
		Assert.assertNotNull(catSet);
		Assert.assertEquals(catSet.size(), 5);		
	}

}
