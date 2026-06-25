package com.microservices.ecom_order_service.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {
   private Long productId;
   private int quantity;
}
