package com.jpn.gemstone.texstone.server.serviceImpl;

import java.util.List;

import com.jpn.gemstone.texstone.server.dao.ArticleDao;
import com.jpn.gemstone.texstone.server.daoImpl.ArticleDaoImpl;
import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao = new ArticleDaoImpl();
	
	public void saveArticleList(String tag, List<Article> articleList){
		for (Article article : articleList) {
			article.setTag(tag);
		}
		articleDao.saveArticleList(articleList);
	}

	@Override
	public List<Article> getArticleList(String tag, String category,
			String version) {
		return articleDao.getArticleList(tag, category, version);
	}
	
	@Override
	public void saveOrUpdate(Article article) {
		articleDao.saveOrUpdate(article);
	}
	
	
	@Override
	public void delete(Article article) {
		articleDao.delete(article);
	}
	
	@Override
	public Article findArticleById(Long articleId){
		return articleDao.findArticleById(articleId);
	}

}
