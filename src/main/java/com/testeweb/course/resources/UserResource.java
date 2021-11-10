package com.testeweb.course.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeweb.course.entities.User;
import com.testeweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired 
	private UserService service;
//RECEBENDO TODOS OS PARAMENTROS
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	//recebendo id especifico
	@GetMapping(value= "/{id}")
	public ResponseEntity<User> findById(@PathVariable long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
