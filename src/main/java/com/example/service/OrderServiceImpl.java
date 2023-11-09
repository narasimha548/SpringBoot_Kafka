package com.example.service;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.OrderRequest;
import com.example.dto.ProductResponse;
import com.example.entity.Order;
import com.example.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private ProductService productService;
	private PaymentService paymentService;

	public OrderServiceImpl(OrderRepository orderRepository, ProductService productService,
			PaymentService paymentService) {
		this.orderRepository = orderRepository;
		this.productService = productService;
		this.paymentService = paymentService;
	}

	@Override
	public Long placeOrder(OrderRequest orderReq) {
		log.info("place order with order request :: " + orderReq);
		// Order Entity -> save the data with status order created
		// call product service -> to block the products

		Order order = Order.builder().productId(orderReq.getProductId()).quantity(orderReq.getQuantity())
				.orderDate(Instant.now()).totalAmount(orderReq.getTotalAmount()).status("CREATED").build();

		ResponseEntity<ProductResponse> productInfo = productService.getProductInfo(orderReq.getProductId());

		if (productInfo.getStatusCodeValue() == 200) {
			order = orderRepository.save(order);

			paymentService.doPayment(null);

			log.info("Order placed successfully with order id :" + order.getOrderId());
		} else {
			log.error("unable to fetch product details ", productInfo.getBody());
		}

		// Payment service -> to complete the payment as well, if payment is successful
		// then mark as COMPLETED else CANCELED.

		return order.getOrderId();
	}

}
