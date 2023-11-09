package com.example.service;

import com.example.dto.OrderRequest;

public interface OrderService {

	Long placeOrder(OrderRequest orderReq);
 
}
