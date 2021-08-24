package com.user.application.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.user.application.entity.PaymentMethod;
import com.user.application.service.PaymentService;


@RestController
public class PaymentController 
{
	@Autowired
	private PaymentService paymentService;
	@GetMapping("/getPayments")
	private ResponseEntity<List<PaymentMethod>> findAllPayments()
	{
		ResponseEntity<List<PaymentMethod>> paymentMethods= null;
		try {
		return new ResponseEntity<List<PaymentMethod>>(paymentService.getPayments(), HttpStatus.OK);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return paymentMethods;
	}
	@GetMapping("/getPaymentById/{paymentId}")
	private ResponseEntity<PaymentMethod> findPaymentById(@PathVariable int paymentId)
	{
		ResponseEntity<PaymentMethod> paymentMethod=null;
		try {
		return new ResponseEntity<PaymentMethod>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return paymentMethod;
	}
	@PutMapping("/updatePayment/{id}")
	public ResponseEntity<PaymentMethod> updatePayment(@RequestBody PaymentMethod payment, @PathVariable int paymentId)
	{
	       return new ResponseEntity<PaymentMethod>(paymentService.updatePayment(payment, paymentId),HttpStatus.CREATED);
	}
}
