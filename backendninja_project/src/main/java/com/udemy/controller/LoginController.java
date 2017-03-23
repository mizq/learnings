package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;
import com.udemy.model.UserCredential;

@Controller
public class LoginController {

	
	private static final Log LOG = LogFactory.getLog( LoginController.class );
	
	@GetMapping( "/" )
	public String redirectToLoging(){
		LOG.info( "METHOD: redirectToLogin( )" );
		return "redirect:/login";
	}
	
	@GetMapping( "/login" )
	public String showLoginForm( Model model,
					@RequestParam(name="logout", required=false ) String logout, 
					@RequestParam(name="error", required=false ) String error ){
		
		LOG.info( "METHOD: showLoginForm( ) -- PARAMS: error = " + error + ", logout = " +  logout  );
		
		model.addAttribute("userCredentials", new UserCredential() );
		model.addAttribute("error", error );
		model.addAttribute("logout", logout );
		
		LOG.info("Returning to login view");
		
		return ViewConstant.LOGIN;
	}
	
	@PostMapping( "/loginCheck" )
	public String loginCheck( @ModelAttribute( name="userCredentials" ) UserCredential userCredential ){
		
		LOG.info( "METHOD: loginCheck( ) -- PARAMS: " + userCredential.toString()  );
		
		if ( userCredential.getUserName().equals("user") && userCredential.getPassword().equals( "user" ) ){
			
			LOG.info("Redirect to contacts view");
			return "redirect:/contacts/showcontacts";
		}
		
		LOG.info("Redirect to login error");
		
		return "redirect:/login?error";
	}
		
}
