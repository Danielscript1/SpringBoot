package com.testeweb.course.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeweb.course.entities.Order;
import com.testeweb.course.entities.User;
import com.testeweb.course.services.OrderService;
import com.testeweb.course.services.UserService;

@RestController
@RequestMapping(value = "/Order")
public class OrderResource {

	@Autowired 
	private OrderService service;
//RECEBENDO TODOS OS PARAMENTROS
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	//recebendo id especifico
	@GetMapping(value= "/{id}")
	public ResponseEntity<Order> findById(@PathVariable long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
