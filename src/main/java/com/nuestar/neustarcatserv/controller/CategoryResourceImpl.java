package com.nuestar.neustarcatserv.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryResourceImpl.class);
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(method=RequestMethod.POST, consumes=AppConstants.APPLJSON)
	public void add(@RequestBody Category category) {		
		boolean rValue = categoryService.add(category);
		if(rValue)
			logger.info("Added Category to Repositary", category);
		else
			logger.info("Ignored Category as a duplicate", category);
	}

	@RequestMapping(method=RequestMethod.DELETE, consumes=AppConstants.APPLJSON)
	public void remove(@RequestBody Category category) {
		boolean rValue = categoryService.remove(category);
		if(rValue)
			logger.info("Removed Category from Repositary", category);
		else
			logger.info("Category not available to remove", category);
	}

	@RequestMapping(method=RequestMethod.GET, produces=AppConstants.APPLJSON)
	public Set<Category> list() {
		logger.info("fetching all categories");
		Set<Category> catList = categoryService.getAll();
		logger.info("fetched products", catList);
		return catList;
	}

}
