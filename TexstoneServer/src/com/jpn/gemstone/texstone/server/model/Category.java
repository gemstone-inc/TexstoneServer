package com.jpn.gemstone.texstone.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.jpn.gemstone.texstone.server.util.Config;

@Entity
@Table(name="CATEGORY")
public class Category {

	//プライマリ キー
	private Long categoryId;
	
	private String categoryName;
	
	private String imageFilePath;
	
	private Long imageFileSize;
	
	private String imageOverFilePath;
	
	private Long imageOverFileSize;
	
	private DataVersion version;

	
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	public Long getCategoryId() {
		return categoryId;
	}

	@Column(name="IMAGE_FILE_PATH")
	public String getImageFilePath() {
		return imageFilePath;
	}
	
	
	@Transient
	public String getImageHttp(){
		if(StringUtils.isEmpty(imageFilePath)){
			return null;
		}
		return Config.apacheContextHttp+imageFilePath;
	}
	
	@Column(name="IMAGE_FILE_SIZE")
	public Long getImageFileSize() {
		return imageFileSize;
	}
	
	
	@Column(name="IMAGE_OVER_FILE_PATH")
	public String getImageOverFilePath() {
		return imageOverFilePath;
	}
	
	
	@Transient
	public String getImageOverHttp(){
		if(StringUtils.isEmpty(imageOverFilePath)){
			return null;
		}
		return Config.apacheContextHttp+imageOverFilePath;
	}
	
	@Column(name="IMAGE_OVER_FILE_SIZE")
	public Long getImageOverFileSize() {
		return imageOverFileSize;
	}
	
	

	@Column(name="CATEGORY_NAME")
	public String getCategoryName() {
		return categoryName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DATA_VERSION_ID", nullable=true)
	public DataVersion getVersion() {
		return version;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	
	public void setImageFileSize(Long imageFileSize) {
		this.imageFileSize = imageFileSize;
	}
	
	public void setVersion(DataVersion version) {
		this.version = version;
	}
	
	public void setImageOverFilePath(String imageOverFilePath) {
		this.imageOverFilePath = imageOverFilePath;
	}
	
	public void setImageOverFileSize(Long imageOverFileSize) {
		this.imageOverFileSize = imageOverFileSize;
	}
	
}
