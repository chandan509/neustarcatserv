package com.nuestar.neustarcatserv.model;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ProcessedResult {
	Set<Product> productList = new LinkedHashSet<>();
	Map<String, Integer> catGroup = new LinkedHashMap<>();
	
	public Set<Product> getProductList() {
		return productList;
	}
	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}
	public Map<String, Integer> getCatGroup() {
		return catGroup;
	}
	public void setCatGroup(Map<String, Integer> catGroup) {
		this.catGroup = catGroup;
	}
}
