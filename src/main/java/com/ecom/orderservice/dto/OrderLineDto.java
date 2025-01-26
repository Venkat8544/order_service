package com.ecom.orderservice.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderLineDto {
	private String productId;
	private int quantity;
	private BigDecimal unitPrice;
	private String productName;
	private String productDescription;
}
