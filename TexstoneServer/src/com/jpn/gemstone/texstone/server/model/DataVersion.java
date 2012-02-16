package com.jpn.gemstone.texstone.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DATA_VERSION")
public class DataVersion {

	private Long versionId;

	private Date releaseDate;

	@Id
	@GeneratedValue
	@Column(name="VERSION_ID")	
	public Long getVersionId() {
		return versionId;
	}

	@Column(name="RELEASE_DATE")	
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
}
