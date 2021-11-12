package com.testeweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeweb.course.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	//instancia um objto repository que vai ter varias interações para trabalhar com usuario
	
}
