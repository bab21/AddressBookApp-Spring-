package com.capgemini.addressbook.controllers;

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

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		AddressBookData addressBookData =null;
		addressBookData =new AddressBookData(1,new AddressBookDTO("Babli","Indrapuri",9998887776L,"Patna","Bihar",800900));
		ResponseDTO respDTO =new ResponseDTO("Get Call for ID Successfull",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@GetMapping("/get/{addressBookDataId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("addressBookDataId") long addressBookDataId){
		AddressBookData addressBookData =null;
		addressBookData=new AddressBookData(1,new AddressBookDTO("Babli","Indrapuri",9998887776L,"Patna","Bihar",800900));
		ResponseDTO respDTO =new ResponseDTO("Get Call for ID Successfull",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(
							@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData =null;
		addressBookData = new AddressBookData(1L,addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created address book data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
							@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData =null;
		addressBookData =new AddressBookData(1,addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated address book Data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{addressBookDataId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("addressBookDataId") int addressBookDataId){
		ResponseDTO respDTO =new ResponseDTO("Deleted Successfully","Deleted id: "+addressBookDataId);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
