package com.udemy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.model.ContactModel;

@RestController
@RequestMapping( "/rest" )
public class BackendninjaRestController {

	@GetMapping( "/checkrest" )
	public ResponseEntity<ContactModel> checkRest(){
		
		ContactModel contactModel = new ContactModel( new Long(2), "Mikel", "Perez", "987654321", "Madrid" ); 
		return new ResponseEntity<ContactModel>( contactModel , HttpStatus.OK );
	}
	
	
}
