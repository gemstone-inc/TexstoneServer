package com.jpn.gemstone.texstone.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ARTICLE")
public class Article {

	private Long articleId; 
	
	private Long categoryId;
	
	private String title;
	
	private String titleFurigana;
	
	private String body;
	
	private String tag;
	
	private Integer rating;
	
	private DataVersion version;
	
	
	@Id
	@GeneratedValue
	@Column(name="ARTICLE_ID")	
	public Long getArticleId() {
		return articleId;
	}


	@Column(name="REF_CATEGORY_ID", nullable=true)
	public Long getCategoryId() {
		return categoryId;
	}

	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	
	@Column(name="TITLE_FURIGANA")
	public String getTitleFurigana() {
		return titleFurigana;
	}
	

	@Column(name="BODY")
	public String getBody() {
		return body;
	}

	@Column(name="TAG")
	public String getTag() {
		return tag;
	}

	@Column(name="RATING")
	public Integer getRating() {
		return rating;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DATA_VERSION_ID", nullable=true)
	public DataVersion getVersion() {
		return version;
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

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setVersion(DataVersion version) {
		this.version = version;
	}
	
	
	
}
