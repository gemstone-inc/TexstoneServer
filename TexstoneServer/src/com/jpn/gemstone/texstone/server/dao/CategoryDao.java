package com.jpn.gemstone.texstone.server.dao;

import java.util.List;

import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.model.DataVersion;



public interface CategoryDao {
	public void saveCategory(Category image);
	public void updateCategory(Category image);
	public void saveOrUpdateCategory(Category image);
	public List<Category> listCategory();
	public Category findCategoryById(Long imageId);
	public Category findCategoryByName(String categoryName);
	public void deleteCategory(Long imageId);
	public void deleteCategory(Category image);
	public List<Category> getNotYetPublishedCategoryList();
	public void publishCategoryList(DataVersion version);
	public List<Category> getNewCategoryList(Long deviceDataVersionId);
}
