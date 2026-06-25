package com.microservices.ecom_order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.ecom_order_service.config.FeignConfig;
import com.microservices.ecom_order_service.dto.InventoryResponse;

@FeignClient(name ="inventor-service", url = "http://localhost:8081", configuration = FeignConfig.class)
public interface InventoryClient {
   
   @GetMapping("/inventory/{productId}")
   InventoryResponse  getInventory(@PathVariable Long productId);
   
   @PutMapping("/inventory/")
   String updateInventory(@RequestBody InventoryResponse inventory);
}
