package com.CRUD.crudService;

import java.util.Collection;
import java.util.List;

import com.CRUD.Model.Customer;

public interface CRUDService {

	Customer insertdata(Customer customer);

	List<Customer> getAllCustomer();

	Customer getCustomerById(int id);

	Customer updateCustomerById(Customer customer);

	void deleteCustomerById(int id);

}
