package com.jpn.gemstone.texstone.server.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.jpn.gemstone.texstone.server.dao.ArticleDao;
import com.jpn.gemstone.texstone.server.dao.CategoryDao;
import com.jpn.gemstone.texstone.server.dao.DataVersionDao;
import com.jpn.gemstone.texstone.server.daoImpl.ArticleDaoImpl;
import com.jpn.gemstone.texstone.server.daoImpl.CategoryDaoImpl;
import com.jpn.gemstone.texstone.server.daoImpl.DataVersionDaoImpl;
import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.model.DataVersion;
import com.jpn.gemstone.texstone.server.service.DataVersionService;

public class DataVersionServiceImpl implements DataVersionService {
	
	private DataVersionDao dataVersionDao = new DataVersionDaoImpl();
	
	private ArticleDao articleDao = new ArticleDaoImpl();
	
	private CategoryDao categoryDAO = new CategoryDaoImpl();
	
	@SessionTarget
	Session session;
	
	
	private DataVersion latestVersion;
	
	private List<Article> newArticleList;
	
	private List<Category> newCategoryList;
	

	@Override
	public List<DataVersion> listVersion() {
		return dataVersionDao.listVersion();
	}

	@Override
	public boolean checkVersion() {
		List<DataVersion> versionListDesc = dataVersionDao.listVersion();
		if(versionListDesc.isEmpty()){
			latestVersion =  null;
		}
		else {
			latestVersion =  versionListDesc.get(0);
		}
		
		newArticleList = articleDao.getNotYetPublishedArticleList();
		
		newCategoryList = categoryDAO.getNotYetPublishedCategoryList();
		
		return (!newArticleList.isEmpty()) || (!newCategoryList.isEmpty());
	}
	


	@Override
	public void publishVersion() {
		Transaction transation = session.beginTransaction();
		latestVersion = dataVersionDao.createNewVersion();
		articleDao.publishArticleList(latestVersion);
		categoryDAO.publishCategoryList(latestVersion);
		transation.commit();
	}
	
	@Override
	public DataVersion getLatestVersion() {
		return latestVersion;
	}

	@Override
	public List<Category> getNotYetPublishedCategoryList() {
		return newCategoryList;
	}

	@Override
	public List<Article> getNotYetPublishedArticleList() {
		return newArticleList;
	}



}
