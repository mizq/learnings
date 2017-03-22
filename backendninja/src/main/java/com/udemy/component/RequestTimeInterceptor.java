package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component( "requestTimeInterceptor" )
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{

	private static final Log LOG = LogFactory.getLog( RequestTimeInterceptor.class );
	
	// Primero
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		request.setAttribute("startTime", System.currentTimeMillis() );
	    return true;	
	}

	
	// Segundo
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
		long startTime = (long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		
		LOG.info("---REQUEST URL: '" + request.getRequestURI().toString() + "' -- TOTAL TIME: '" + (endTime - startTime) + "' ms" );
	
	}

	
}
