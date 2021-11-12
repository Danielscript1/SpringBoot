package com.testeweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeweb.course.entities.Category;
import com.testeweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	//buscar todos os usuarios
	public List<Category> findAll() {
		return repository.findAll();
	}
	//buscar pelo Id
	public Category findById(Long id){
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
