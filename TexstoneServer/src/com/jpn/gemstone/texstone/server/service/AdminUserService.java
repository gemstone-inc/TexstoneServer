package com.jpn.gemstone.texstone.server.service;


public interface AdminUserService {

	boolean login(String userName, String password) throws Exception;
	
}
