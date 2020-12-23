package com.capgemini.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.capgemini.addressbook.model.AddressBookData;


@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData,Long>{
	@Query(value="SELECT * FROM address_book_data",nativeQuery=true)
	public List<AddressBookData> getAllAddressBookData();
	
	@Query(value ="SELECT * FROM address_book_data a WHERE a.id=:addressBookDataId",nativeQuery=true)
	public AddressBookData findAddressBookDataById(@Param("addressBookDataId")long addressBookDataId);
	
}
