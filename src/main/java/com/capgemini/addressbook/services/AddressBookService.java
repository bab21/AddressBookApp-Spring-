package com.capgemini.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.addressbook.dto.AddressBookDTO;
import com.capgemini.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {
	
	public List<AddressBookData> getAddressBookData(){
		List<AddressBookData> listAddressBookData=new ArrayList<>();
		listAddressBookData.add(new AddressBookData("Babli","Indrapuri",9988776655L,"Patna","Bihar",880099));
		return listAddressBookData;
	};
	
	public AddressBookData getAddressBookDataById(long addressBookDataId) {
		return new AddressBookData("Babli","Indrapuri",9988776655L,"Patna","Bihar",880099);
	}
	
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		return new AddressBookData(1L,addressBookDTO);
	}
	
	public AddressBookData updateAddressBookData(long addressBookDataId,AddressBookDTO addressBookDTO) {
		return new AddressBookData(addressBookDataId,addressBookDTO);
	}
	
	public void deleteAddressBookData(long addressBookDataId) {
		
	}
}