package com.capgemini.addressbook.services;

import java.util.List;

import com.capgemini.addressbook.dto.AddressBookDTO;
import com.capgemini.addressbook.model.AddressBookData;

public interface IAddressBookService {
	List<AddressBookData> getAddressBookData();
	
	AddressBookData getAddressBookDataById(long addressBookDataId);
	
	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
	
	AddressBookData updateAddressBookData(long addressBookDataId,AddressBookDTO addressBookDTO);
	
	void deleteAddressBookData(long addressBookDataId);
}
