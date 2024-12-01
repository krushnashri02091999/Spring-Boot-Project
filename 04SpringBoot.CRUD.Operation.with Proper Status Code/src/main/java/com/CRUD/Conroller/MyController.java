package com.CRUD.Conroller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.CRUD.Model.Customer;
import com.CRUD.Repository.MyRepository;
import com.CRUD.crudService.CRUDService;



@RestController
@RequestMapping("/customer")
public class MyController {
	@Autowired
	private MyRepository myrepository;

	@Autowired
	private CRUDService crudservice;

	@PostMapping("/create")
	public ResponseEntity<Customer> CreateData(@RequestBody Customer customer) {
		Customer c = crudservice.insertdata(customer);

		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
	}

	@GetMapping("/getalldata")
	public List<Customer> getData() {
		List<Customer> salaryGreaterThan = crudservice.getAllCustomer();
		return salaryGreaterThan;
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Customer> getDataById(@PathVariable int id) {
		try {
			Customer e = crudservice.getCustomerById(id);
			return ResponseEntity.ok(e);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Is Not Present in Database");
		}
		
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Void> deleteDataById(@PathVariable int id) {
		try {
			crudservice.deleteCustomerById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Is Not Present in Database");
		}
		
	};

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Customer> putMethodName(@PathVariable int id, @RequestBody Customer customer) {
		try {
			customer.setId(id);
			Customer c=crudservice.updateCustomerById(customer);
			return ResponseEntity.ok(c);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Is Not Present in Database");
		}
		
	}

}