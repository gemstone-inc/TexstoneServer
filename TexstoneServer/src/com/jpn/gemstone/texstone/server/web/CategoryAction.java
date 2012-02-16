package com.jpn.gemstone.texstone.server.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jpn.gemstone.texstone.server.model.Category;
import com.jpn.gemstone.texstone.server.service.CategoryService;
import com.jpn.gemstone.texstone.server.serviceImpl.CategoryServiceImpl;
import com.jpn.gemstone.texstone.server.util.Config;
import com.jpn.gemstone.texstone.server.util.FileUtil;
import com.jpn.gemstone.texstone.server.util.Pair;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class CategoryAction extends ActionSupport implements ServletRequestAware, Preparable, ModelDriven<Category> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5449557712529332818L;
	
	private Category category;
	private List<Category> categoryList = new ArrayList<Category>();
	private CategoryService categoryService = new CategoryServiceImpl();
	
	private long id;
	private HttpServletRequest request;
	
	private File categoryImage;
	
	private String categoryImageFileName;
	
	private File categoryImageOver;
	
	private String categoryImageOverFileName;

	@Override
	public Category getModel(){
		return category;
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
			category = new Category();
		}
		else {
			category = categoryService.findCategoryById(id);			
		}
	}
	
	

	public String saveOrUpdate() throws IOException{
		if(getFieldErrors().isEmpty() && getActionErrors().isEmpty()){
			Category existingCategory = categoryService.findCategoryByName(category.getCategoryName()); 
			if(existingCategory != null && !existingCategory.getCategoryName().equals(category.getCategoryName())){
				addFieldError("categoryName", "既に登録されています。");
				return ERROR;
			}

		}
		
		if(categoryImage != null){
			String fileExtension = FilenameUtils.getExtension(categoryImageFileName);
			Pair<String, Long> pr = FileUtil.moveFile(categoryImage, fileExtension, Config.categoryImageDirectory);
			category.setImageFilePath(pr.getFirst());
			category.setImageFileSize(pr.getSecond());
		}
		
		
		if(categoryImageOver != null){
			String fileExtension = FilenameUtils.getExtension(categoryImageOverFileName);
			Pair<String, Long> pr = FileUtil.moveFile(categoryImageOver, fileExtension, Config.categoryImageDirectory);
			category.setImageOverFilePath(pr.getFirst());
			category.setImageOverFileSize(pr.getSecond());
		}
		
		
		categoryService.saveOrUpdateCategory(category);
		return SUCCESS;
	}


	
	
	/**
	 * To list all category.
	 * @return String
	 */
	@SkipValidation
	public String list()
	{
		categoryList = categoryService.listCategory();
		return SUCCESS;
	}
	
	/**
	 * To delete a category.
	 * @return String
	 */
	@SkipValidation
	public String delete()
	{
		categoryService.deleteCategory(category);
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
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	public void setCategoryImage(File categoryImage) {
		this.categoryImage = categoryImage;
	}
	
	public void setCategoryImageFileName(String categoryImageFileName) {
		this.categoryImageFileName = categoryImageFileName;
	}

	public void setCategoryImageOver(File categoryImageOver) {
		this.categoryImageOver = categoryImageOver;
	}
	
	public void setCategoryImageOverFileName(String categoryImageOverFileName) {
		this.categoryImageOverFileName = categoryImageOverFileName;
	}

}
