package com.jpn.gemstone.texstone.server.daoImpl;

import java.util.List;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.jpn.gemstone.texstone.server.dao.AdminUserDao;
import com.jpn.gemstone.texstone.server.model.AdminUser;


public class AdminUserDaoImpl implements AdminUserDao {
	
	@SessionTarget
	Session session;
	
	@Override
	@SuppressWarnings("unchecked")
	public AdminUser getUserByUserNamePassword(String userName, String md5password) {
		List<AdminUser> adminList = null;
		adminList = session.createQuery("from AdminUser admin where admin.userName = ? AND admin.password = ?").setString(0, userName).setString(1, md5password).list();
		if(adminList == null || adminList.isEmpty()){
			return null;
		}
		else {
			return adminList.get(0);			
		}
	}

}
