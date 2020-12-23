package com.capgemini.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.addressbook.dto.AddressBookDTO;
import com.capgemini.addressbook.model.AddressBookData;
import com.capgemini.addressbook.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	List<AddressBookData> listAddressBookData=new ArrayList<>();
	@Autowired
	private AddressBookRepository addressBookRepository;

	public List<AddressBookData> getAddressBookData(){
		List<AddressBookData> addressBookDataList=addressBookRepository.getAllAddressBookData();
		return addressBookDataList;
	};
	
	public AddressBookData getAddressBookDataById(long addressBookDataId) {
		return addressBookRepository.findAddressBookDataById(addressBookDataId);
	}
	
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData =new AddressBookData(addressBookDTO);
		addressBookRepository.save(addressBookData);
		return addressBookData;
	}
	
	public AddressBookData updateAddressBookData(long addressBookDataId,AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData =this.getAddressBookDataById(addressBookDataId);
		addressBookData.setAddress(addressBookDTO.address);
		addressBookData.setCity(addressBookDTO.city);
		addressBookData.setState(addressBookDTO.state);
		addressBookData.setFullName(addressBookDTO.fullName);
		addressBookData.setPhoneNumber(addressBookDTO.phoneNumber);
		addressBookData.setZip(addressBookDTO.zip);
		addressBookRepository.save(addressBookData);
		return addressBookData;
	}
	
	public void deleteAddressBookData(long addressBookDataId) {
		addressBookRepository.deleteById(addressBookDataId);
	}
}