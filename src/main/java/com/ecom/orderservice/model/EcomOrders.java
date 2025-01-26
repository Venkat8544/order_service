package com.ecom.orderservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;

@Document(collection = "ecom_orders")
@Builder
@Getter
public class EcomOrders {

	@Id
	private String id;
	private String orderId;
	private LocalDateTime orderedDate;
	private BigDecimal totalAmount;
	private String orderStatus; 
	private String customerId;
    private String shippingAddress;
    private List<OrderLine> orderLines;
}
