package com.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.PaymentBean;
import com.service.PaymentService;

@RestController
@RequestMapping("/user")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("chargecc")
	public ResponseEntity<?> chargeCreditCard(@RequestBody PaymentBean paymentBean) {

		paymentService.chargeCreditCard(paymentBean);
		
		
		return ResponseEntity.ok().build();
	}
}
