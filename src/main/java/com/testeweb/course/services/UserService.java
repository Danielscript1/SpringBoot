package com.testeweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.testeweb.course.entities.User;
import com.testeweb.course.repositories.UserRepository;
import com.testeweb.course.services.exceptions.DatabaseException;
import com.testeweb.course.services.exceptions.EntityNotFoundException;
import com.testeweb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	//salvar o user
	public User insert(User obj) {
		return repository.save(obj);
		
	}
	//deletando user
	public void delete(Long id) { 
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//update user
	public  User update(Long id, User obj) {
		try {
		User entity = repository.getOne(id);//ele deixar o objto monitorado para em seguinda eu ir no banco de dados
		UpdateData(entity,obj);//chama a função que atualizar os dados
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new EntityNotFoundException(e.getMessage());
		}
		
	}
	//função ataulizar chamada no metodo update
	private void UpdateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
