package com.example.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

	private Long orderId;
	private Long amount;
	private String transactionRefernceNumber;
	private PaymentMode paymentMode;
	
}
