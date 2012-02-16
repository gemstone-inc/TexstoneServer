package com.jpn.gemstone.texstone.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN_USER")
public class AdminUser {

	private Long id;
	private String userName;
	private String password;
	
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")	
	public Long getId() {
		return id;
	}
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	

	
	public void setId(Long id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
 

}
