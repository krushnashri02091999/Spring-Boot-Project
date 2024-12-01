package com.CRUD.Controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.CRUD.GlobalExceptionHandling.ProductNotFoundException;
import com.CRUD.model.Product;
import com.CRUD.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;

	@PostMapping("/insert")
	public ResponseEntity<Product> addData(@RequestBody Product product) {
		if (product.getPid() == 0) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		Product p = productservice.createData(product);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getallData() {
		List<Product> list = productservice.getData();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		}
	}

	/*
	 * @GetMapping(value = "/byname/{pname}") public ResponseEntity<Product>
	 * getbyname(@PathVariable String pname) { Product product =
	 * productservice.getProductByName(pname); if (product != null) { return new
	 * ResponseEntity<Product>(product, HttpStatus.OK); } else { throw new
	 * ProductNotFoundException("Product Not Exist with name in the DataBase "); }
	 * };
	 */
	/*
	 * @GetMapping("/byname") public List<Employee> getbyName(@RequestParam String
	 * ename) { List<Employee> l=crudservice.getEmployeebyname(ename); return l; }
	 * 
	 */ @GetMapping("/getbyid/{id}")
	public ResponseEntity<Product> getbyid(@PathVariable int id) {
		Product p = productservice.byid(id);
		if (p != null) {
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Product Not Exist with name in the DataBase");
		}
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Void> deleteDataById(@PathVariable int id) {
		try {
			productservice.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Is Not Present in Database");
		}
	};

	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
		try {
			product.setPid(id);
			Product c = productservice.updateCustomerById(product);
			return ResponseEntity.ok(c);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Is Not Present in Database");
		}
	}
}