package com.capgemini.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.addressbook.dto.AddressBookDTO;
import com.capgemini.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {
	List<AddressBookData> listAddressBookData=new ArrayList<>();
	
	public List<AddressBookData> getAddressBookData(){
//		listAddressBookData.add(new AddressBookData("Babli","Indrapuri",9988776655L,"Patna","Bihar",880099));
		return listAddressBookData;
	};
	
	public AddressBookData getAddressBookDataById(long addressBookDataId) {
		return listAddressBookData.get((int)addressBookDataId-1);
	}
	
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData =new AddressBookData(listAddressBookData.size(),addressBookDTO);
		listAddressBookData.add(addressBookData);
		return addressBookData;
	}
	
	public AddressBookData updateAddressBookData(long addressBookDataId,AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData =new AddressBookData(1L,addressBookDTO);;
		listAddressBookData.set(((int) addressBookDataId)-1, addressBookData );
		return addressBookData;
	}
	
	public void deleteAddressBookData(long addressBookDataId) {
		listAddressBookData.remove(((int)addressBookDataId)-1);
	}
}