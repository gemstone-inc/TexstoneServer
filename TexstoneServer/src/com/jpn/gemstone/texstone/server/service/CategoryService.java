package com.jpn.gemstone.texstone.server.service;

import java.util.List;

import com.jpn.gemstone.texstone.server.model.Category;



public interface CategoryService {
	public void saveCategory(Category category);
	public void updateCategory(Category category);
	public void saveOrUpdateCategory(Category category);
	public List<Category> listCategory();
	public Category findCategoryById(Long categoryId);
	public Category findCategoryByName(String categoryName);
	public void deleteCategory(Long categoryId);
	public void deleteCategory(Category category);

}
