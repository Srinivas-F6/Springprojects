package com.microservices.ecom_inventory_service.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
   private Long productId;
   private int quantity;
}
