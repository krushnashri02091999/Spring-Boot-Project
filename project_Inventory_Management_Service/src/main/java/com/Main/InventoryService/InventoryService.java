package com.Main.InventoryService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Main.Model.Inventory;

import inv_repository.InventoryRepository;

@Service
public class InventoryService {
	
	/*
	 * private final InventoryRepository inventoryRepository;
	 * 
	 * @Autowired public InventoryService(InventoryRepository inventoryRepository) {
	 * this.inventoryRepository = inventoryRepository; }
	 */

	
	  @Autowired private InventoryRepository inventoryRepository;
	 
	public Inventory createInventory(Inventory inventory) {
		Inventory save = inventoryRepository.save(inventory);
		return save;
	}

	public List<Inventory> getallinventories() {
		List<Inventory> all = (List<Inventory>) inventoryRepository.findAll();
		return all;
	}

	public Optional<Inventory> getInventoryById(Long id) {
		Optional<Inventory> byId = inventoryRepository.findById(id);
		return byId;
	}
	public Inventory updateInventory(Long id, Inventory inventory) {
		Inventory update = inventoryRepository.save(inventory);
		return update;
	}	

	public String deleted(Long id) {
		inventoryRepository.deleteById(id);
		return "Deleted";
	}
}