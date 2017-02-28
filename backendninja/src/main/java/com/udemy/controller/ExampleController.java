package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/example" ) 
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	
	//Primera forma. Redirecciones o insertar pocos datos
	@GetMapping( "/exampleString")
	// Hace lo mismo que: @RequestMapping( value="/exampleString", method=RequestMethod.GET )
	public String exampleString( Model model )
	{
		model.addAttribute("name", "GT");
		return EXAMPLE_VIEW;
	}
	
	//Segunda forma. Mejor para insertar datos en plantillas
	@GetMapping( "/exampleMAV")
	public ModelAndView exampleMAV()
	{
		ModelAndView mav = new ModelAndView( EXAMPLE_VIEW );
		mav.addObject("name", "RCATE");
		// return new ModelAndView( EXAMPLE_VIEW );
		return mav;
	}
	
}
