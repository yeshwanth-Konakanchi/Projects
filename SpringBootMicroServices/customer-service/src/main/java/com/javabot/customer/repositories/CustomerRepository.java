package com.javabot.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.javabot.customer.domain.Customer;

/**
 * @author  Yeshwanth
 *
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
		
	@Query(value = "From Customer customer WHERE customer.email = :email")
	Customer retrieveCustomerInfoByEmail(@Param("email") String email);
	
	@Modifying(clearAutomatically = true)
	@Transactional
    @Query("UPDATE Customer customer SET customer.email = :email WHERE customer.customerId = :customerId")
    int updateCustomerEmail(@Param("email") String email, @Param("customerId") int customerId);
	
	@Query(value = "From Customer customer WHERE customer.lastName = :lastName and customer.dateOfBirth =:dateOfBirth")
	Customer retrieveCustomerInfo(@Param("lastName") String lastName,@Param("dateOfBirth") String dateOfBirth);
}
