package com.jpn.gemstone.texstone.server.web;

import java.util.ArrayList;
import java.util.List;

import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.model.DataVersion;
import com.jpn.gemstone.texstone.server.service.DataVersionService;
import com.jpn.gemstone.texstone.server.serviceImpl.DataVersionServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class VersionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	private DataVersionService dataVersionService = new DataVersionServiceImpl();
	
	private boolean publishNeed;
	
	private DataVersion currentVersion;
	
	private List<Article> newArticleList;
	
	private List<Category> newCategoryList;
	
	public String checkVersion(){
		publishNeed = dataVersionService.checkVersion();
		currentVersion = dataVersionService.getLatestVersion();
		newArticleList = dataVersionService.getNotYetPublishedArticleList();
		newCategoryList = dataVersionService.getNotYetPublishedCategoryList();
		return SUCCESS;
	}
	
	public String publishVersion(){
		dataVersionService.publishVersion();
		currentVersion = dataVersionService.getLatestVersion();
		publishNeed = false;
		newArticleList = new ArrayList<Article>();
		newCategoryList = new ArrayList<Category>();
		return SUCCESS;
	}

	public boolean isPublishNeed() {
		return publishNeed;
	}

	public void setPublishNeed(boolean publishNeed) {
		this.publishNeed = publishNeed;
	}
	
	public DataVersion getCurrentVersion() {
		return currentVersion;
	}
	
	public List<Article> getNewArticleList() {
		return newArticleList;
	}
	
	public List<Category> getNewCategoryList() {
		return newCategoryList;
	}

}