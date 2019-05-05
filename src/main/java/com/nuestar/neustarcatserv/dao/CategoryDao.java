package com.nuestar.neustarcatserv.dao;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.nuestar.neustarcatserv.model.Category;

@Repository
public class CategoryDao {
	
	private Set<Category> categories = new LinkedHashSet<>();
	
	public boolean addCategory(Category cat){
		return categories.add(cat);
	}
	
	public boolean removeCategory(Category cat){
		return categories.remove(cat);
	}
	
	public Set<Category> getAllCategories(){
		//List<Category> catList = new ArrayList<>(categories);
		return categories;
	}

}