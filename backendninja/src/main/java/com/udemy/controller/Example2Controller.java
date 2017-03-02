package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	private static final String EXAMPLE2_VIEW = "example2";
	
	// localhost:8080/example2/request1?nm=JON
	@GetMapping( "/request1")
	public ModelAndView requestOne( @RequestParam( name="nm",required=false, defaultValue="NO NAMED" ) String name ){
		ModelAndView mav = new ModelAndView( EXAMPLE2_VIEW );
		mav.addObject( "nm_in_model", name);
		return mav;
	}
	
	// localhost:8080/example2/request2/JON
	@GetMapping( "/request2/{nm}" )
	public ModelAndView requestTwo( @PathVariable( name="nm" ) String name ){
		// No posee defaultValue. Si no se indica el parámetro, devuelve error.
		ModelAndView mav = new ModelAndView( EXAMPLE2_VIEW );
		mav.addObject( "nm_in_model", name );
		return mav;
	}
	
	
}
