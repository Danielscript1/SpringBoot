package com.testeweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Product;
import com.testeweb.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//buscar todos os usuarios
	public List<Product> findAll() {
		return repository.findAll();
	}
	//buscar pelo Id
	public Product findById(Long id){
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
