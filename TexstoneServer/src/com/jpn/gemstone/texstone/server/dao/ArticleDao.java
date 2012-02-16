package com.jpn.gemstone.texstone.server.dao;

import java.util.List;

import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.DataVersion;

public interface ArticleDao {

	public void saveArticleList(List<Article> articleList);
	
	public List<Article> getArticleList(String tag, String category, String version);
	
	public void saveOrUpdate(Article article);
	
	public void delete(Article article);
	
	public Article findArticleById(Long articleId);
	
	public List<Article> getNotYetPublishedArticleList();
	
	public List<Article> getNewArticleList(Long deviceDataVersionId);
	
	public void publishArticleList(DataVersion version);
	
}
