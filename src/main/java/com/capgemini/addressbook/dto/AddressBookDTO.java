package com.capgemini.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class AddressBookDTO {
	public String fullName;
	public String address;
	public long phoneNumber;
	public String city;
	public String state;
	public int zip;
}
