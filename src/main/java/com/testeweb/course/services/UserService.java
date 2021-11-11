package com.testeweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.testeweb.course.entities.User;
import com.testeweb.course.repositories.UserRepository;
import com.testeweb.course.resources.UserResource;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//buscar todos os usuarios
	public List<User> findAll() {
		return repository.findAll();
	}
	//buscar pelo Id
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}