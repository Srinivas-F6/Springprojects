package com.microservices.ecom_order_service.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.microservices.ecom_order_service.client.InventoryClient;
import com.microservices.ecom_order_service.dto.InventoryResponse;



@Service
public class OrderService {
	
	private RestClient restClient;
	private InventoryClient inventoryClient;
	
	public OrderService(RestClient restClient,InventoryClient inventoryClient) {
		this.restClient = restClient;
		this.inventoryClient = inventoryClient;
	}
  
	public String placeOrder(Long productId) throws Throwable {
//		RestTemplate
//       String response =  restTemplate.getForObject(
//           "http://localhost:8081/inventory/" + productId,
//           String.class
//        );
		
		
//		RestClient
//		ResponseEntity<InventoryResponse> response = restClient.get()
//				                    .uri("http://localhost:8081/inventory/{productId}",productId)
//				                    .retrieve()
//				                    .toEntity(InventoryResponse.class);
		InventoryResponse response = inventoryClient.getInventory(productId);
		String message = updateStock(response);
			
		return response.getQuantity()>0 ? "Ordered Successfully "+message : "Out of Stock "+message;
		
	}

	private String updateStock(InventoryResponse inventory) {
	   inventory.setQuantity(inventory.getQuantity() - 1);
	   String message = inventoryClient.updateInventory(inventory);
	   return message;
	   
	}
}
