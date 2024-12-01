package com.CRUD.crudService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.CRUD.Model.Customer;
import com.CRUD.Repository.MyRepository;

@Service
public class MyService implements CRUDService {

	@Autowired
	private MyRepository myrepository;

	@Override
	public Customer insertdata(Customer customer) {
		Customer save = myrepository.save(customer);
		return save;
	}

	@Override
	public List<Customer> getAllCustomer() {
		Iterable<Customer> all = myrepository.findAll();
		return (List<Customer>) all;
	}

	@Override
	public Customer getCustomerById(int id) {
		Optional<Customer> byId = myrepository.findById(id);
		return byId.get();
	}

	@Override
	public Customer updateCustomerById(Customer customer) {
		if (!myrepository.existsById(customer.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Is Not Present in Database");
		}
		Customer update = myrepository.save(customer);
		return update;
	}

	@Override
	public void deleteCustomerById(int id) {
		if (!myrepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Is Not Present in Database");
		}
		myrepository.deleteById(id);
		
	}
	}