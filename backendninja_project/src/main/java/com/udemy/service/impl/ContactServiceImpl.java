package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<ContactModel> listAllContacts() {
		
		List<Contact> listContacts = contactRepository.findAll();
		List<ContactModel> listContactModel = new ArrayList<ContactModel>();
		
		for ( Contact contact : listContacts ){
			listContactModel.add( contactConverter.convertContactToContactModel(contact) );
		}
		
		return listContactModel;
	}

	@Override
	public Contact findContactById(Long id) {
		return contactRepository.findById(id);
	}

	public ContactModel findContactModelById( Long id ) {
		return contactConverter.convertContactToContactModel( findContactById( id ) );
	}
	
	@Override
	public void removeContact(Long id) {
		
		Contact contact = findContactById(id);
		
		if ( contact != null ){
			contactRepository.delete( contact );
		}
		
	}

	
	
	
}

