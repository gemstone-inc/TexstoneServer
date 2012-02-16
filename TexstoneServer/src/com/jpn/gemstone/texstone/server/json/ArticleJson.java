package com.jpn.gemstone.texstone.server.json;

public class ArticleJson {

	private Long articleId; 
	
	private Long categoryId;
	
	private String title;
	
	private String titleFurigana;
	
	private String body;
	
	private Long versionId;

	public Long getArticleId() {
		return articleId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getTitle() {
		return title;
	}
	
	public String getTitleFurigana() {
		return titleFurigana;
	}

	public String getBody() {
		return body;
	}


	public Long getVersionId() {
		return versionId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleFurigana(String titleFurigana) {
		this.titleFurigana = titleFurigana;
	}
	
	public void setBody(String body) {
		this.body = body;
	}


	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	
	
}
