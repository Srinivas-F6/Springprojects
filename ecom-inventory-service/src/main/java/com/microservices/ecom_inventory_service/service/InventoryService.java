package com.microservices.ecom_inventory_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservices.ecom_inventory_service.dto.InventoryDto;
import com.microservices.ecom_inventory_service.model.Inventory;
import com.microservices.ecom_inventory_service.repository.InventoryRepository;

@Service
public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	public InventoryService(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	public String addProduct(Inventory inventory) {
	    inventoryRepository.save(inventory);
	    return "saved Successfully";
	}

	public String updateProduct(InventoryDto inventoryDto) {

	    Inventory inventory = inventoryRepository
	            .findByProductId(inventoryDto.getProductId())
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    inventory.setQuantity(inventoryDto.getQuantity());

	    inventoryRepository.save(inventory);

	    return "Inventory Updated Successfully";
	}

	public Inventory checkInventory(Long productId) {
		Optional<Inventory> inventory = inventoryRepository.findByProductId(productId);
		return inventory.get();
		
	}

}
