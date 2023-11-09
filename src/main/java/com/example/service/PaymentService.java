package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.PaymentRequest;



//@FeignClient(name = "http://localhost:9090/product/api/v1/")
@FeignClient(name = "payment-service")
public interface PaymentService {

	@PostMapping("/do-payment")
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);
}
