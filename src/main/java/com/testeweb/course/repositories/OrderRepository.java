package com.testeweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeweb.course.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	//instancia um objto repository que vai ter varias interações para trabalhar com usuario
	
}
