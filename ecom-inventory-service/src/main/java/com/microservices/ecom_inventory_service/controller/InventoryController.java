package com.microservices.ecom_inventory_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ecom_inventory_service.dto.InventoryDto;
import com.microservices.ecom_inventory_service.model.Inventory;
import com.microservices.ecom_inventory_service.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	private InventoryService inventoryService;
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@GetMapping("/{productId}")
	public InventoryDto checkInventory(@PathVariable Long productId) throws Throwable {
         Thread.sleep(4000);
		Inventory inv = inventoryService.checkInventory(productId);
		 return new InventoryDto(inv.getProductId(), inv.getQuantity());
	}
	
	@PostMapping()
	public String addProduct(@RequestBody Inventory inventory) {
		return inventoryService.addProduct(inventory);
	}
	
	@PutMapping("/")
	public String updateProduct(@RequestBody InventoryDto inventory) {
		return inventoryService.updateProduct(inventory);
	}

}
