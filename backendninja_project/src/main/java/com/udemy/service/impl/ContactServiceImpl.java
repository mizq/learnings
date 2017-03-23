package com.udemy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

@Service( "contactServiceImpl" )
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier( "contactRepository" )
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier( "contactConverter" )
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		
		Contact contact = contactRepository.save( contactConverter.convertContactModelToContact(contactModel) );
		
		if ( contact == null )
		{
			return null;
		}
		
		return contactConverter.convertContactToContactModel(contact);
	}

	
	
	
}

