package com.CRUD.service;

import java.util.List;

import com.CRUD.model.Product;

public interface ProductService {

	Product createData(Product product);

	List<Product> getData();

	Product byid(int id);

	void deleteById(int id);

	Product updateCustomerById(Product product);

//	Product getProductByName(String pname);

	

}
