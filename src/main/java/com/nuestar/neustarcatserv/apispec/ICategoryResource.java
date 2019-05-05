package com.nuestar.neustarcatserv.apispec;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;
import com.nuestar.neustarcatserv.model.Category;

public interface ICategoryResource {
	
	public void add(@RequestBody Category category);
	
	public void remove(@RequestBody Category category);
	
	public Set<Category> list();

}
