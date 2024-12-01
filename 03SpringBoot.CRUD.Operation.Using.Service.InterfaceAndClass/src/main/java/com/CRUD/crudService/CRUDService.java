package com.CRUD.crudService;

import java.util.List;

import com.CRUD.Model.Employee;

public interface CRUDService {

	Employee insertdata(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	void deleteEmployeeById(int id);

	Employee updateEmployeeById(Employee employee);

	List<Employee> getEmployeebyname(String name);
}
