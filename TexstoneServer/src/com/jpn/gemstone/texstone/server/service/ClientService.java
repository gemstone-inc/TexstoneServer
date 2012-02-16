package com.jpn.gemstone.texstone.server.service;

import java.lang.reflect.InvocationTargetException;

import com.jpn.gemstone.texstone.server.json.UpdateDataPack;

public interface ClientService {

	public UpdateDataPack getUpdateData(Long deviceDataVersionId) throws IllegalAccessException, InvocationTargetException ;
	
}
