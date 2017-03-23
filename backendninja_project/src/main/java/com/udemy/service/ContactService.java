package com.udemy.service;

import java.util.List;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact( ContactModel contactModel );
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById( Long id );
	
	public abstract ContactModel findContactModelById( Long id );
	
	public abstract void removeContact( Long id );
	
}
