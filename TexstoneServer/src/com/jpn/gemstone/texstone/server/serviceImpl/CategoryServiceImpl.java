package com.jpn.gemstone.texstone.server.serviceImpl;

import java.util.List;

import com.jpn.gemstone.texstone.server.dao.CategoryDao;
import com.jpn.gemstone.texstone.server.daoImpl.CategoryDaoImpl;
import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.service.CategoryService;




public class CategoryServiceImpl implements CategoryService {
	
	CategoryDao categoryDAO = new CategoryDaoImpl();


	

	@Override
	public void saveOrUpdateCategory(Category category) {
		categoryDAO.saveOrUpdateCategory(category);
	}



	@Override
	public Category findCategoryById(Long categoryId) {
		return categoryDAO.findCategoryById(categoryId);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		categoryDAO.deleteCategory(categoryId);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryDAO.deleteCategory(category);
	}



	@Override
	public void saveCategory(Category category) {
		categoryDAO.saveCategory(category);
		
	}



	@Override
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}



	@Override
	public List<Category> listCategory() {
		return categoryDAO.listCategory();
	}



	@Override
	public Category findCategoryByName(String categoryName) {
		return categoryDAO.findCategoryByName(categoryName);
	}







}
