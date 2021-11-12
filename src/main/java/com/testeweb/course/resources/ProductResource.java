package com.testeweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeweb.course.entities.Product;
import com.testeweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/Products")
public class ProductResource {

	@Autowired
	private ProductService service;

//RECEBENDO TODOS OS PARAMENTROS
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// recebendo id especifico
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
