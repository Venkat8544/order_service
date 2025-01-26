package com.ecom.orderservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.ecom.orderservice.model.OrderLine;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EcomOrdersDto {
	
	private String id;
	
	@NotNull(message = "Order ID cannot be null")
	private String orderId;

	@NotNull(message = "Ordered Date cannot be null")
	private LocalDateTime orderedDate;

	@NotNull(message = "Total amount cannot be null")
	@Min(value = 0, message = "Total amount must be greater than or equal to 0")
	private BigDecimal totalAmount;

	@NotNull(message = "Order status cannot be null")
	@Size(min = 1, message = "Order status must not be empty")
	private String orderStatus;

	@NotNull(message = "Customer ID cannot be null")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Customer ID must be alphanumeric")
	private String customerId;

	@NotNull(message = "Shipping address cannot be null")
	@Size(min = 1, message = "Shipping address must not be empty")
	private String shippingAddress;

	@NotEmpty(message = "Order lines cannot be empty")
	private List<OrderLine> orderLines;

}
