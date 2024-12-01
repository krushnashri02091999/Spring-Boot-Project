package com.CRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.CRUD.Repository.MyRepository;
import com.CRUD.model.Product;

@Service
public class ProductServiceImplem implements ProductService {

	@Autowired
	private MyRepository myRepository;
	@Override
	public Product createData(Product product) {
		Product save = myRepository.save(product);
		return save;
	}
	
	@Override
	public List<Product> getData() {
		Iterable<Product> all = myRepository.findAll();
		return (List<Product>) all;
	}

	@Override
	public Product byid(int id) {
		Optional<Product> byId = myRepository.findById(id);
		return byId.get();
	}

	@Override
	public void deleteById(int id) {
		if (!myRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Is Not Present in Database");
		}
		myRepository.deleteById(id);
	}

	@Override
	public Product updateCustomerById(Product product) {
		if (!myRepository.existsById(product.getPid())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Is Not Present in Database");
		}
		Product update = myRepository.save(product);
		return update;
	}
/*
	@Override
	public Product getProductByName(String pname) {
		Product findbyname = myRepository.findbyname(pname);
		return findbyname;
	}
	*/	
	}
