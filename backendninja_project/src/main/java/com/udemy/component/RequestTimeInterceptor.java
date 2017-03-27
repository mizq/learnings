package com.udemy.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.udemy.repository.LogRepository;

@Component( "requestTimeInterceptor" )
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{

	private static final Log LOG = LogFactory.getLog( RequestTimeInterceptor.class );
	
	
	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;
	
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
		
		String url = request.getRequestURL().toString();
		LOG.info("URL to: '" + url + "' -- in: '" + (endTime - startTime) + "' ms" );
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if ( auth != null && auth.isAuthenticated() ){
			username = auth.getName();
		}
			
		com.udemy.entity.Log log = new com.udemy.entity.Log( new Date(), auth.getDetails().toString(), username, url );
		logRepository.save( log );
	}
	
}

