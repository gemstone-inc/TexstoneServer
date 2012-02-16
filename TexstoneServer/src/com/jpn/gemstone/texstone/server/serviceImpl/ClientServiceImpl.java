package com.jpn.gemstone.texstone.server.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.jpn.gemstone.texstone.server.dao.ArticleDao;
import com.jpn.gemstone.texstone.server.dao.CategoryDao;
import com.jpn.gemstone.texstone.server.dao.DataVersionDao;
import com.jpn.gemstone.texstone.server.daoImpl.ArticleDaoImpl;
import com.jpn.gemstone.texstone.server.daoImpl.CategoryDaoImpl;
import com.jpn.gemstone.texstone.server.daoImpl.DataVersionDaoImpl;
import com.jpn.gemstone.texstone.server.json.ArticleJson;
import com.jpn.gemstone.texstone.server.json.CategoryJson;
import com.jpn.gemstone.texstone.server.json.UpdateDataPack;
import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.model.DataVersion;
import com.jpn.gemstone.texstone.server.service.ClientService;

public class ClientServiceImpl implements ClientService {

	private DataVersionDao dataVersionDao = new DataVersionDaoImpl();
	
	private ArticleDao articleDao = new ArticleDaoImpl();
	
	private CategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public UpdateDataPack getUpdateData(Long deviceDataVersionId) throws IllegalAccessException, InvocationTargetException {
		List<DataVersion> dataVersionList = dataVersionDao.listVersion();
		if(dataVersionList.isEmpty()){
			return null;
		}
		
		DataVersion serverDataVersion = dataVersionList.get(0);
		
		if(serverDataVersion.getVersionId().equals(deviceDataVersionId)){
			return null;
		}
		
		
		UpdateDataPack dataPack = new UpdateDataPack();
		dataPack.setServerDataVersionId(serverDataVersion.getVersionId());
		
		List<Category> newCategoryList = categoryDao.getNewCategoryList(deviceDataVersionId);
		for (Category category : newCategoryList) {
			CategoryJson cjs = new CategoryJson();
			BeanUtils.copyProperties(cjs, category);
			dataPack.getCategoryList().add(cjs);
		}
		
		
		List<Article> newArticleList = articleDao.getNewArticleList(deviceDataVersionId);
		for (Article article : newArticleList) {
			ArticleJson ajs = new ArticleJson();
			BeanUtils.copyProperties(ajs, article);
			dataPack.getArticleList().add(ajs);
		}


		
		
		
		return dataPack;
	}

}
