package com.jpn.gemstone.texstone.server.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.GsonBuilder;
import com.jpn.gemstone.texstone.server.json.UpdateDataPack;
import com.jpn.gemstone.texstone.server.service.ClientService;
import com.jpn.gemstone.texstone.server.serviceImpl.ClientServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeviceAction extends ActionSupport implements ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
 	private ClientService clientService = new ClientServiceImpl();
 	

 	private String jsonResponse="{}";
 	
 	private void setAsJsonResponse(Object obj){
    	GsonBuilder gsonBuilder = new GsonBuilder();
    	gsonBuilder.setDateFormat("yyyy-MM-dd");
    	gsonBuilder.setPrettyPrinting();
    	jsonResponse = gsonBuilder.create().toJson(obj);
 	}
 	
 	
 	
 	
 	long deviceDataVersionId;
 	
 	
	public String getUpdateData() throws IllegalAccessException, InvocationTargetException{
		UpdateDataPack data = clientService.getUpdateData(deviceDataVersionId);
		setAsJsonResponse(data);
		return SUCCESS;
	}
	

	public InputStream getStreamData() throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
		return new ByteArrayInputStream(jsonResponse.getBytes("UTF-8"));
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
	}



	public void setDeviceDataVersionId(long deviceDataVersionId) {
		this.deviceDataVersionId = deviceDataVersionId;
	}


	
	
	
}
