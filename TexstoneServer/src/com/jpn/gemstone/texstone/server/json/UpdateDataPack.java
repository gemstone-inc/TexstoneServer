package com.jpn.gemstone.texstone.server.json;

import java.util.ArrayList;
import java.util.List;

public class UpdateDataPack {
	
	private Long serverDataVersionId;
	
	private List<CategoryJson> categoryList = new ArrayList<CategoryJson>();
	
	private List<ArticleJson> articleList = new ArrayList<ArticleJson>();
	
	public Long getServerDataVersionId() {
		return serverDataVersionId;
	}

	public List<CategoryJson> getCategoryList() {
		return categoryList;
	}

	public List<ArticleJson> getArticleList() {
		return articleList;
	}

	
	public void setServerDataVersionId(Long serverDataVersionId) {
		this.serverDataVersionId = serverDataVersionId;
	}


	public void setCategoryList(List<CategoryJson> categoryList) {
		this.categoryList = categoryList;
	}

	public void setArticleList(List<ArticleJson> articleList) {
		this.articleList = articleList;
	}
	
	
}
