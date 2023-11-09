package com.example.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order_details")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Long orderId;
	
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "QUANTITY")
	private Long quantity;
	
	@Column(name = "ORDER_DATE")
	private Instant orderDate;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "TOTAL_AMOUNT")
	private Long totalAmount;
	
}
