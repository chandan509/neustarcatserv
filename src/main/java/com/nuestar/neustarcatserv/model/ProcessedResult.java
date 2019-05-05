package com.nuestar.neustarcatserv.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProcessedResult {
	List<Product> productList = new ArrayList<>();
	Map<String, Integer> catGroup = new LinkedHashMap<>();
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Map<String, Integer> getCatGroup() {
		return catGroup;
	}
	public void setCatGroup(Map<String, Integer> catGroup) {
		this.catGroup = catGroup;
	}
}
