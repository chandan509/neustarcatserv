package com.nuestar.neustarcatserv.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuestar.neustarcatserv.dao.CategoryDao;
import com.nuestar.neustarcatserv.model.Category;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao catDao;
	
	public boolean add(Category cat){
		return catDao.addCategory(cat);		
	}
	
	public boolean remove(Category cat){
		return catDao.removeCategory(cat);
	}
	
	public Set<Category> getAll(){
		return catDao.getAllCategories();
	}

}
