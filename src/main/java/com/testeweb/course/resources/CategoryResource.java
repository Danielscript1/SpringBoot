package com.testeweb.course.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.testeweb.course.entities.Category;
import com.testeweb.course.services.OrderService;
import com.testeweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/Categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

//RECEBENDO TODOS OS PARAMENTROS
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// recebendo id especifico
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
