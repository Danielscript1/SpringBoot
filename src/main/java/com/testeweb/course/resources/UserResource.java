package com.testeweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	//salvando o user
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){ //anotação que avisar que voce vai receber uma Json
		User usuario = service.insert(obj);
		//forma correta de inserir um obj no banco de dados
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
}
