package com.nuestar.neustarcatserv.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nuestar.neustarcatserv.apispec.ICategoryResource;
import com.nuestar.neustarcatserv.constants.AppConstants;
import com.nuestar.neustarcatserv.model.Category;
import com.nuestar.neustarcatserv.service.CategoryService;

@RestController
@RequestMapping(path="/categories")
public class CategoryResourceImpl implements ICategoryResource {
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(method=RequestMethod.POST, consumes=AppConstants.APPLJSON)
	public void add(@RequestBody Category category) {
		categoryService.add(category);		
	}

	@RequestMapping(method=RequestMethod.DELETE, consumes=AppConstants.APPLJSON)
	public void remove(@RequestBody Category category) {
		categoryService.remove(category);		
	}

	@RequestMapping(method=RequestMethod.GET, produces=AppConstants.APPLJSON)
	public Set<Category> list() {
		return categoryService.getAll();
	}

}
