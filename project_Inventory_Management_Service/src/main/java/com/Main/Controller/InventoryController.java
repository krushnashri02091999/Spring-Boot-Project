package com.Main.Controller;

import java.util.List;
import java.util.Optional;

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

import com.Main.InventoryService.InventoryService;
import com.Main.Model.Inventory;

import Exception.InventoryNotFoundException;
@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/insert")
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		Inventory i=inventoryService.createInventory(inventory);
		return 	new ResponseEntity<Inventory>(i, HttpStatus.ACCEPTED);	
	}

	@GetMapping("/all")
	public ResponseEntity<List<Inventory>> getallInventory() {
		List<Inventory> l=inventoryService.getallinventories();
		return new ResponseEntity<List<Inventory>>(l, HttpStatus.ACCEPTED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) throws InventoryNotFoundException {
		Optional<Inventory> inventoryOptional = inventoryService.getInventoryById(id);
		if (inventoryOptional.isPresent()) {
			return ResponseEntity.ok(inventoryOptional.get());
		} else {
			throw new InventoryNotFoundException("Inventory not found with id: " + id);

		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
		Inventory i=inventoryService.updateInventory(id,inventory);
		
		return new ResponseEntity<Inventory>(i, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInventory(@PathVariable Long id){
	String s=inventoryService.deleted(id);
	return new ResponseEntity<String>(s, HttpStatus.OK);
	}
}
