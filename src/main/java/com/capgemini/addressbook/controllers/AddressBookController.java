package com.capgemini.addressbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.addressbook.dto.AddressBookDTO;
import com.capgemini.addressbook.dto.ResponseDTO;
import com.capgemini.addressbook.model.AddressBookData;
import com.capgemini.addressbook.services.IAddressBookService;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	@Autowired
	private IAddressBookService addressBookService;

	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddressBookData(){
		List<AddressBookData>  addressBookDataList =null;
		addressBookDataList =addressBookService.getAddressBookData();
		ResponseDTO respDTO =new ResponseDTO("Get Call for ID Successfull",addressBookDataList);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@GetMapping("/get/{addressBookDataId}")
	public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("addressBookDataId") long addressBookDataId){
		AddressBookData addressBookData =null;
		addressBookData=addressBookService.getAddressBookDataById(addressBookDataId);
		ResponseDTO respDTO =new ResponseDTO("Get Call for ID Successfull",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(
							@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData =null;
		addressBookData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created address book data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	@PutMapping("/update/{addressBookDataId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("addressBookDataId") long addressBookDataId,
							@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData =null;
		addressBookData =addressBookService.updateAddressBookData(addressBookDataId, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated address book Data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{addressBookDataId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("addressBookDataId") int addressBookDataId){
		addressBookService.deleteAddressBookData(addressBookDataId);
		ResponseDTO respDTO =new ResponseDTO("Deleted Successfully","Deleted id: "+addressBookDataId);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
