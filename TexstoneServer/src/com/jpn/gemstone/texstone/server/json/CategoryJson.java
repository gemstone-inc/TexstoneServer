package com.jpn.gemstone.texstone.server.json;



public class CategoryJson {

	//プライマリ キー
	private Long categoryId;
	
	private String categoryName;
	
	private String imageHttp;
	
	private Long imageFileSize;
	
	private String imageOverHttp;
	
	private Long imageOverFileSize;
	
	private Long versionId;

	public Long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getImageHttp() {
		return imageHttp;
	}

	public Long getImageFileSize() {
		return imageFileSize;
	}
	
	public String getImageOverHttp() {
		return imageOverHttp;
	}
	
	public Long getImageOverFileSize() {
		return imageOverFileSize;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setImageHttp(String imageHttp) {
		this.imageHttp = imageHttp;
	}

	public void setImageFileSize(Long imageFileSize) {
		this.imageFileSize = imageFileSize;
	}
	
	public void setImageOverHttp(String imageOverHttp) {
		this.imageOverHttp = imageOverHttp;
	}
	
	public void setImageOverFileSize(Long imageOverFileSize) {
		this.imageOverFileSize = imageOverFileSize;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	
	
	
}
