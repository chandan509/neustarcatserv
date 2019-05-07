package com.nuestar.neustarcatserv.model;

public class Product {
	
	public Product(){
		
	}
	public Product(String category, String subCategory) {
		super();
		this.category = category;
		this.subCategory = subCategory;
	}

	private String category;
	private String subCategory;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (subCategory == null) {
			if (other.subCategory != null) {
				return false;
			}
		} else if (!subCategory.equals(other.subCategory)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Product [category=" + category + ", subCategory=" + subCategory
				+ "]";
	}
}
