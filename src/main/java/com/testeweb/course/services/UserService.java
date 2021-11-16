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
	
	//salvar o user
	public User insert(User obj) {
		return repository.save(obj);
		
	}
	//deletando user
	public void delete(Long id) { 
		repository.deleteById(id);;
		
	}
	
	//update user
	public  User update(Long id, User obj) {
		User entity = repository.getOne(id);//ele deixar o objto monitorado para em seguinda eu ir no banco de dados
		UpdateData(entity,obj);//chama a função que atualizar os dados
		return repository.save(entity);
	}
	//função ataulizar chamada no metodo update
	private void UpdateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
