package com.jpn.gemstone.texstone.server.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jpn.gemstone.texstone.server.service.AdminUserService;
import com.jpn.gemstone.texstone.server.serviceImpl.AdminUserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;


public class LoginAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6159448709761211952L;

	private String userName;
	
	private String password;
	
	AdminUserService adminUserService = new AdminUserServiceImpl();
	
	HttpServletRequest req;
	
	public static final String USER_HANDLE = "logged-in";  
		  
	@Validations(
			requiredStrings =
                    {
            			@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "userName", message = "You must enter a value for userName."),
            			@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "password", message = "You must enter a value for password.")
            		}
    )
	public String execute() throws Exception{


		  if (adminUserService.login(userName, password)) {
			  Map session = ActionContext.getContext().getSession();
			  session.put(USER_HANDLE, new SessionFlag());
			  return SUCCESS;
		  }
		  else{
			  addActionError("パスワードエラー");
			  return ERROR;
		  }
	}
	


	@SkipValidation
	public String logout() throws Exception {
		req.getSession().invalidate();
		return SUCCESS;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	//@RequiredStringValidator(type = ValidatorType.FIELD, message = "ユーザ名は必須です。")
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//@RequiredStringValidator(type = ValidatorType.FIELD, message = "パスワードは必須です。")
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		req = arg0;
	}
	
    private static class SessionFlag  implements HttpSessionBindingListener{

    	@Override
    	public void valueBound(HttpSessionBindingEvent arg0) {
    		// TODO Auto-generated method stub
    	}

    	@Override
    	public void valueUnbound(HttpSessionBindingEvent arg0) {
    		// TODO CHECK IF ANY FILES CREATED BY THIS SESSION EXISTS IN THE SERVER
    	}
    	
    }

}