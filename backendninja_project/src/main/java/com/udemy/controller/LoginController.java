package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	
	/**
	 * Show login form.
	 *
	 * @param model the model
	 * @param logout the logout
	 * @param error the error
	 * @return the string
	 */
	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "logout", required = false) String logout,
			@RequestParam(name = "error", required = false) String error) {

		LOG.info("METHOD: showLoginForm( ) -- PARAMS: error = " + error + ", logout = " + logout);

		model.addAttribute("error", error);
		model.addAttribute("logout", logout);

		LOG.info("Returning to login view");

		return ViewConstant.LOGIN;
	}

	/**
	 * Login check.
	 *
	 * @return the string
	 */
	@GetMapping( { "/", "/loginSuccess" } )
	public String loginCheck( ) {

		LOG.info("METHOD: loginSucces( )" );
		LOG.info("Redirect to contacts view");
		return "redirect:/contacts/showcontacts";

	}

}
