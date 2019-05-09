package com.nuestar.neustarcatserv.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuestar.neustarcatserv.model.Category;
import com.nuestar.neustarcatserv.model.ProcessedResult;
import com.nuestar.neustarcatserv.model.Product;

@Service
public class ProcessResourceService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessResourceService.class);
	
	@Autowired
	CategoryService catService;
	
	public ProcessedResult process(List<Product> products){
		ProcessedResult result = new ProcessedResult();
		if(products == null || products.isEmpty()){
			logger.info("Empty products list", products);
			return result;
		}		
		
		Set<Category> legalCatList = catService.getAll();
		logger.info("Before Removing Illegal products", legalCatList);
		List<Product> filteredProducts = products.stream()
												.filter(product -> legalCatList.contains(new Category(product.getCategory())))
												.collect(Collectors.toList());
		logger.info("After Removing Illegal products", filteredProducts);
		
		logger.info("Before Removing Duplicate products", filteredProducts);
		Set<Product> setOfFilteredProducts = new LinkedHashSet<>(filteredProducts);
		logger.info("After Removing Duplicate products", setOfFilteredProducts);
		
		Map<String, Integer> catGroup = new LinkedHashMap<>();
		setOfFilteredProducts.stream().forEach(product -> {
			if(!catGroup.containsKey(product.getCategory())){
				catGroup.put(product.getCategory(), 1);
			}
			else{
				int count = catGroup.get(product.getCategory());
				count = count + 1;
				catGroup.put(product.getCategory(), count);
			}
		});
		
		legalCatList.stream().forEach(cat ->{
			if(!catGroup.containsKey(cat.getName())){
				catGroup.put(cat.getName(), 0);
			}			
		});
		
		Set<Entry<String, Integer>> set =  catGroup.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(set);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2){
				return obj2.getValue().compareTo(obj1.getValue());				
			}
		});
		catGroup.clear();
		for(Entry<String, Integer> e: list){
			catGroup.put(e.getKey(), e.getValue());			
		}
		
		
		result.setProductList(setOfFilteredProducts);
		result.setCatGroup(catGroup);													
		
		return result;
		
	}

}
