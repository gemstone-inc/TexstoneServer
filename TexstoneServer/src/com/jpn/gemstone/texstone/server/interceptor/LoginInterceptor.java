package com.jpn.gemstone.texstone.server.interceptor;

import static com.jpn.gemstone.texstone.server.web.LoginAction.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = Logger.getLogger(LoginInterceptor.class);
    

    
    @Override
    public void destroy() {
    	logger.debug("Destroying Interceptor");
    }

    @Override
    public void init() {
    	logger.debug("Intialising Interceptor");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
    	final ActionContext context = invocation.getInvocationContext ();
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        HttpSession session =  request.getSession (true);
    	// Is there a "user" object stored in the user's HttpSession?  
    	Object user = session.getAttribute(USER_HANDLE);  
    	if (user == null) {  
    		return "loginpage";
    	} else {
    		return invocation.invoke();  
    	}
    }
    

    
}

