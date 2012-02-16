package com.jpn.gemstone.texstone.server.serviceImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.jpn.gemstone.texstone.server.dao.AdminUserDao;
import com.jpn.gemstone.texstone.server.daoImpl.AdminUserDaoImpl;
import com.jpn.gemstone.texstone.server.model.AdminUser;
import com.jpn.gemstone.texstone.server.service.AdminUserService;



public class AdminUserServiceImpl implements AdminUserService{

	AdminUserDao adminUserDAO = new AdminUserDaoImpl();
	
	private static String hashPassword(String password) {
		String hashword = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			BigInteger hash = new BigInteger(1, md5.digest());
			hashword = hash.toString(16);
		} catch (NoSuchAlgorithmException nsae) {
			// ignore
		}
		return hashword;
	}

	@Override
	public boolean login(String userName, String password) throws Exception{
		AdminUser admin = adminUserDAO.getUserByUserNamePassword(userName, hashPassword(password));
		return admin != null;
	}
	
//	public static void main(String[] args) {
//		//e1ab07562f4b25ca2062b6f9c58bf16e
//		System.out.println(hashPassword("z8dcrex3"));
//	}
	
	
}

