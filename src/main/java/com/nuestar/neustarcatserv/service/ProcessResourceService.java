package com.nuestar.neustarcatserv.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuestar.neustarcatserv.model.Category;
import com.nuestar.neustarcatserv.model.ProcessedResult;
import com.nuestar.neustarcatserv.model.Product;

@Service
public class ProcessResourceService {
	
	@Autowired
	CategoryService catService;
	
	public ProcessedResult process(List<Product> products){
		ProcessedResult result = new ProcessedResult();
		if(products == null || products.isEmpty()){
			return result;
		}		
		
		Set<Category> legalCatList = catService.getAll();
		
		List<Product> filteredProducts = products.stream()
												.filter(product -> legalCatList.contains(new Category(product.getCategory())))
												.collect(Collectors.toList());
		
		Map<String, Integer> catGroup = new LinkedHashMap<>();
		filteredProducts.stream().forEach(product -> {
			if(!catGroup.containsKey(product.getCategory())){
				catGroup.put(product.getCategory(), 1);
			}
			else{
				int count = catGroup.get(product.getCategory());
				count = count + 1;
				catGroup.put(product.getCategory(), count);
			}
		});
		result.setProductList(filteredProducts);
		result.setCatGroup(catGroup);													
		
		return result;
		
	}

}
