package com.capgemini.addressbook.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.capgemini.addressbook.dto.AddressBookDTO;

import lombok.Data;

@Entity
public @Data class AddressBookData {
	
	@Id
	private long id;
	private String fullName;
	private String address;
	private long phoneNumber;
	private String city;
	private String state;
	private int zip;
	
	public AddressBookData(String fullName,String address,long phoneNumber,String city,String state,int zip) {
		this.fullName=fullName;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	
	public AddressBookData(long id, AddressBookDTO addressBookDTO) {
		this.id=id;
		this.fullName=addressBookDTO.fullName;
		this.address=addressBookDTO.address;
		this.phoneNumber=addressBookDTO.phoneNumber;
		this.city=addressBookDTO.city;
		this.state=addressBookDTO.state;
		this.zip=addressBookDTO.zip;
	}
}

