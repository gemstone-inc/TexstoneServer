package com.jpn.gemstone.texstone.server.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jpn.gemstone.texstone.server.model.Article;
import com.jpn.gemstone.texstone.server.worker.ExcelReader;
import com.opensymphony.xwork2.ActionSupport;

public class ExcelFileUploadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -917781152859791638L;
	
	private File userExcel;
	
	private String userExcelContentType;
	
	private String userExcelFileName;
	
	private Integer categoryColumnIndex = 0;
	
	private Integer titleColumnIndex = 1;
	
	private Integer titleFuriganaColumnIndex = 2;
	
	private Integer bodyColumnIndex = 3;
	
	
	private List<Article> articleList;
	
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
	
	public void setCategoryColumnIndex(int categoryColumnIndex) {
		this.categoryColumnIndex = categoryColumnIndex;
	}
	
	public void setTitleColumnIndex(int titleColumnIndex) {
		this.titleColumnIndex = titleColumnIndex;
	}
	
	public void setLyricsColumnIndex(int bodyColumnIndex) {
		this.bodyColumnIndex = bodyColumnIndex;
	}
	
	public String execute() throws IOException {
		ExcelReader reader = new ExcelReader(userExcel, userExcelContentType);
		articleList = reader.getArticles(categoryColumnIndex, titleColumnIndex, titleFuriganaColumnIndex, bodyColumnIndex);
		reader.closeReader();
		return SUCCESS;
	}

}
