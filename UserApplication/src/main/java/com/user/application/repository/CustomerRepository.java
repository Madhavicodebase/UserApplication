package com.user.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.user.application.dto.OrderResponseDTO;
import com.user.application.entity.CustomerDetails;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerDetails,Integer> 
{
	@Query("SELECT new com.user.application.dto.OrderResponseDTO(p.productId, p.productName,p.productLevel,p.premium) "
			+ "FROM ProductDetails p  INNER JOIN ProductSubscription c  "
			+ "ON  p.productId=c.productId INNER JOIN ProductEligibility d "
			+ "ON  d.productId=c.productId and c.customerId=:customerId and d.customerId=:customerId ")
    public List<OrderResponseDTO> getSubscribedProducts( @Param("customerId") int id);
	
	@Query("SELECT new com.user.application.dto.OrderResponseDTO(p.productId, p.productName, p.productLevel,p.premium) "
	+ "FROM ProductDetails p INNER JOIN ProductEligibility pe "
	+ "ON  pe.productId=p.productId and pe.customerId=:customerId")

	public List<OrderResponseDTO> getOnlyEligibleProducts(@Param("customerId") int id);
	
}