package com.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.Model.Customer;
@Repository
public interface MyRepository extends JpaRepository<Customer, Integer>{
	
}
