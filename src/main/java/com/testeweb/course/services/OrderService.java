package com.testeweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Order;
import com.testeweb.course.repositories.OrderRepository;
import com.testeweb.course.resources.OrderResource;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	//buscar todos os usuarios
	public List<Order> findAll() {
		return repository.findAll();
	}
	//buscar pelo Id
	public Order findById(Long id){
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
