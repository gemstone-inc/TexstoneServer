package com.jpn.gemstone.texstone.server.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.model.DataVersion;
import com.jpn.gemstone.texstone.server.service.ArticleService;
import com.jpn.gemstone.texstone.server.service.CategoryService;
import com.jpn.gemstone.texstone.server.service.DataVersionService;
import com.jpn.gemstone.texstone.server.serviceImpl.ArticleServiceImpl;
import com.jpn.gemstone.texstone.server.serviceImpl.CategoryServiceImpl;
import com.jpn.gemstone.texstone.server.serviceImpl.DataVersionServiceImpl;
import com.jpn.gemstone.texstone.server.worker.ExcelReader;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ArticleAction extends ActionSupport implements ServletRequestAware, Preparable, ModelDriven<Article>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8242222733255157796L;
	
	private ArticleService articleService = new ArticleServiceImpl();
	
	private DataVersionService dataVersionService = new DataVersionServiceImpl();
	
	private CategoryService categoryService = new CategoryServiceImpl();

	private File userExcel;
	
	private String userExcelContentType;
	
	private String userExcelFileName;
	
	private String tagInput;
	
	private String tagToSearch;
	
	private String categoryToSearch;
	
	private String versionToSearch;
	
	private Article article;
	
	private List<Article> articleList;
	
	private List<DataVersion> versionList;
	
	private List<Category> categoryList;
	
	private long id;
	
	private HttpServletRequest request;

	@Override
	public Article getModel(){
		return article;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	@Override
	public void prepare() {
		String idStr = request.getParameter("id");
		if(StringUtils.isEmpty(idStr)){
			id = 0;
		}
		else {
			id=Long.parseLong(idStr);
		}
		
		if( id == 0) {
			article = new Article();
		}
		else {
			article = articleService.findArticleById(id);			
		}
	}
	
	
	@SkipValidation
	public String uploadExcel() throws IOException {
		ExcelReader reader = new ExcelReader(userExcel, userExcelContentType);
		articleList = reader.getArticles(0, 1, 2, 3);
		reader.closeReader();
		return SUCCESS;
	}
	
	
	public String saveBatchArticleList() {
		articleService.saveArticleList(tagInput, articleList);
		return SUCCESS;
	}
	
	
	public String list() {
		categoryList = categoryService.listCategory();
		versionList = dataVersionService.listVersion();
		articleList = articleService.getArticleList(tagToSearch, categoryToSearch, versionToSearch);
		return SUCCESS;
	}
	
	
	
	
	/**
	 * To delete a category.
	 * @return String
	 */
	@SkipValidation
	public String delete()
	{
		articleService.delete(article);
		return SUCCESS;
	}
	
	/**
	 * To list a single category by Id.
	 * @return String
	 */
	@SkipValidation
	public String edit()throws Exception
	{
         return SUCCESS;
	}
	
	
	public String saveOrUpdate()
	{
		
		
		articleService.saveOrUpdate(article);
		return SUCCESS;
	}




	
	public String getTagInput() {
		return tagInput;
	}

	public String getTagToSearch() {
		return tagToSearch;
	}

	public String getCategoryToSearch() {
		return categoryToSearch;
	}

	public String getVersionToSearch() {
		return versionToSearch;
	}

	public Article getArticle() {
		return article;
	}

	public void setTagInput(String tagInput) {
		this.tagInput = tagInput;
	}

	public void setTagToSearch(String tagToSearch) {
		this.tagToSearch = tagToSearch;
	}

	public void setCategoryToSearch(String categoryToSearch) {
		this.categoryToSearch = categoryToSearch;
	}

	public void setVersionToSearch(String versionToSearch) {
		this.versionToSearch = versionToSearch;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public File getUserExcel() {
		return userExcel;
	}

	public void setUserExcel(File userExcel) {
		this.userExcel = userExcel;
	}

	public String getUserExcelContentType() {
		return userExcelContentType;
	}
	
	public List<Article> getArticleList() {
		return articleList;
	}

	public void setUserExcelContentType(String userExcelContentType) {
		this.userExcelContentType = userExcelContentType;
	}

	public String getUserExcelFileName() {
		return userExcelFileName;
	}

	public void setUserExcelFileName(String userExcelFileName) {
		this.userExcelFileName = userExcelFileName;
	}
	

	public List<DataVersion> getVersionList() {
		return versionList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}
	
}
