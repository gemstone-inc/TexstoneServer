package com.jpn.gemstone.texstone.server.dao;

import com.jpn.gemstone.texstone.server.model.AdminUser;






public interface AdminUserDao {
	public AdminUser getUserByUserNamePassword(String userName, String md5password);
	
}
