package com.jpn.gemstone.texstone.server.service;

import java.util.List;

import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.model.DataVersion;

public interface DataVersionService {
	public List<DataVersion> listVersion();
	public DataVersion getLatestVersion();
	public List<Category> getNotYetPublishedCategoryList();
	public List<Article> getNotYetPublishedArticleList();
	public void publishVersion();
	public boolean checkVersion();
}
