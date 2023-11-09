package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.ProductResponse;



//@FeignClient(name = "http://localhost:9090/product/api/v1/")
@FeignClient(name = "product-service")
public interface ProductService {

	@GetMapping(value = "/fetch-productinfo/{id}")
	public ResponseEntity<ProductResponse> getProductInfo(@PathVariable("id") long productId);
}
