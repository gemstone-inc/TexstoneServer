package com.jpn.gemstone.texstone.server.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.jpn.gemstone.texstone.server.dao.CategoryDao;
import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.model.DataVersion;




public class CategoryDaoImpl implements CategoryDao {

	@SessionTarget
	Session session;
	
	@Override
	public void saveCategory(Category category) {
		session.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		session.update(category);
	}

	@Override
	public void saveOrUpdateCategory(Category category) {
		session.saveOrUpdate(category);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> listCategory() {
		List<Category> categorys = null;
		categorys = session.createQuery("from Category").list();
		return categorys;
	}
	
	@Override
	public Category findCategoryById(Long categoryId) {
		return (Category)session.load(Category.class, categoryId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Category findCategoryByName(String categoryName) {
		List<Category> categoryList = null;
		categoryList = session.createQuery("from Category where categoryName = ? ")
							.setString(0, categoryName).list();
		if(categoryList.isEmpty()){
			return null;			
		}
		else {
			return categoryList.get(0);			
		}
	}
	

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = (Category)session.load(Category.class, categoryId);
		session.delete(category);
	}

	@Override
	public void deleteCategory(Category category) {
		session.delete(category);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> getNotYetPublishedCategoryList() {
		Criteria query = session.createCriteria(Category.class);
		query.add(Restrictions.isNull("version"));
		return query.list();
	}


	@Override
	public void publishCategoryList(DataVersion version) {
		Query query = session.createQuery("update Category set version = :version where version is NULL");
		query.setParameter("version", version);
		query.executeUpdate();
	}

	@Override
	public List<Category> getNewCategoryList(Long deviceDataVersionId) {
		Criteria query = session.createCriteria(Category.class);
		query.add(Restrictions.gt("version.versionId", deviceDataVersionId));
		return query.list();
	}

}
