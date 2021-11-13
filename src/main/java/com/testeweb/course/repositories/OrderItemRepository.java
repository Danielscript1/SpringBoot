package com.testeweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeweb.course.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	//instancia um objto repository que vai ter varias interações para trabalhar com usuario
	
}
