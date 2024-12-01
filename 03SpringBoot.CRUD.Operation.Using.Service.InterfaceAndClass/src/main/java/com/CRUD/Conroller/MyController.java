package com.CRUD.Conroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.Model.Employee;
import com.CRUD.Repository.MyRepository;
import com.CRUD.crudService.CRUDService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/employee")
public class MyController {
	@Autowired
	private MyRepository myrepository;

	@Autowired
	private CRUDService crudservice;

	@PostMapping("/create")
	public Employee CreateData(@RequestBody Employee employee) {
		Employee e = crudservice.insertdata(employee);

		return e;
	}

	@GetMapping("/getalldata")
	public List<Employee> getData() {

		List<Employee> genderwiseList = crudservice.getAllEmployee().stream().filter(list -> list.getGender().equals("Male"))
				.collect(Collectors.toList());
		List<Employee> salaryGreaterThan = crudservice.getAllEmployee().stream().filter(list -> list.getSalary()>=50000)
				.collect(Collectors.toList());
		return salaryGreaterThan;
	}

	@GetMapping("/getbyid/{id}")
	public Employee getDataById(@PathVariable int id) {
		Employee e = crudservice.getEmployeeById(id);
		return e;
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public void deleteDataById(@PathVariable int id) {
		crudservice.deleteEmployeeById(id);
	};

	@PutMapping("/updatebyid/{id}")
	public Employee putMethodName(@PathVariable int id, @RequestBody Employee employee) {
		employee.setEid(id);
		Employee e=crudservice.updateEmployeeById(employee);
		return e;
	}

	@GetMapping("/byname")
	public List<Employee> getbyName(@RequestParam String ename) {
		List<Employee> l=crudservice.getEmployeebyname(ename);
		return l;
	}
}