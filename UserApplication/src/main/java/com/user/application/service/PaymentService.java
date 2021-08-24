package com.user.application.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.application.entity.PaymentMethod;
import com.user.application.exception.BusinessException;
import com.user.application.exception.ResourceNotFoundException;
import com.user.application.repository.PaymentRepository;
@Service
public class PaymentService 
{
	@Autowired
	private PaymentRepository paymentRepository;
	public List<PaymentMethod> getPayments()
	{
		try {
			List<PaymentMethod> empList=paymentRepository.findAll(); 
			if(empList.isEmpty())
				throw new BusinessException("601","Hey list completely empty, we have nothing to return");
			return empList;
			}catch(Exception e) {
				throw new BusinessException("602","Something went wrong in service layer while fetching data" +e.getMessage());
			}
	}
	public PaymentMethod getPaymentById(int paymentId) 
	{
		try 
		{
			return paymentRepository.findById(paymentId).get();
		}
		catch(IllegalArgumentException e) {
		System.out.println("This is my custom exception1"+e);
		throw new BusinessException("603","Given customer id is null"+e.getMessage());
		}
		catch(java.util.NoSuchElementException e) {
		System.out.println("This is my custom exception" +e);
		throw new BusinessException("604","Given customer id does not exist in DB"+e.getMessage());
		}
    }
	public PaymentMethod updatePayment(PaymentMethod payment, int paymentId) {
		PaymentMethod existingPayment= paymentRepository.findById(paymentId).orElseThrow( 
				()-> new ResourceNotFoundException("PaymentMethod","paymentId"));
				existingPayment.setPaymentType(payment.getPaymentType());
				paymentRepository.save(existingPayment);
				return existingPayment;
	}

}

//User existingUser=userJpaRepository.findById(id).orElseThrow(
//		()-> new ResourceNotFoundException("User", "Id", id));
//System.out.println("User from DB"+ existingUser);
//existingUser.setName(user.getName());
//existingUser.setAge(user.getAge());
//existingUser.setCust_phone_Number(user.getCust_phone_Number());
// userJpaRepository.save(existingUser);
// return existingUser;
