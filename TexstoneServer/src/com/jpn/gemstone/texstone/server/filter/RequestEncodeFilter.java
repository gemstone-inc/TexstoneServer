package com.jpn.gemstone.texstone.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class RequestEncodeFilter  implements Filter {
	
	
	private static final Logger logger = Logger.getLogger(RequestEncodeFilter.class);
	
	//FilterConfig object
	@SuppressWarnings("unused")
	private FilterConfig filterConfig = null;

	//Default constructor
	public RequestEncodeFilter()
	{
		logger.info("Request response encoder Filter object has been created");
	}

	//Initialization method
	public void init(FilterConfig filterConfig)
	{
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	public void destroy() { 
		this.filterConfig = null;
	}
}
