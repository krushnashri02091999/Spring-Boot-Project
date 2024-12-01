package com.CRUD.crudService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.Model.Employee;
import com.CRUD.Repository.MyRepository;

@Service
public class MyService implements CRUDService {

	@Autowired
	private MyRepository myrepository;

	@Override
	public Employee insertdata(Employee employee) {
		Employee save = myrepository.save(employee);
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Iterable<Employee> all = myrepository.findAll();
		return (List<Employee>) all;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> byId = myrepository.findById(id);
		return byId.get();
	}
	
	@Override
	public void deleteEmployeeById(int id) {
		myrepository.deleteById(id);
	}

	@Override
	public Employee updateEmployeeById(Employee employee) {
		Employee update = myrepository.save(employee);
		return update;
	}

	@Override
	public List<Employee> getEmployeebyname(String ename) {
		List<Employee> byname = myrepository.byname(ename);
		return byname;
	}
	}