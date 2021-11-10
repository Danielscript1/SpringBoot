package com.testeweb.course.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.testeweb.course.entities.User;
import com.testeweb.course.repositories.UserRepository;


import java.util.Arrays;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { //essa implemetação executar os metodos quando iniciada
		
	//testando injeção depedencia
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
	
	
}
