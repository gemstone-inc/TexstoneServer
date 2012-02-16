package com.jpn.gemstone.texstone.server.service;

import java.util.List;

import com.jpn.gemstone.texstone.server.model.Article;



public interface ArticleService {
	public void saveArticleList(String tag, List<Article> articleList);
	public List<Article> getArticleList(String tag, String category, String version);
	public void saveOrUpdate(Article article);
	public void delete(Article article);
	public Article findArticleById(Long articleId);
}
