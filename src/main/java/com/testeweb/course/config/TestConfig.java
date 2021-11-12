package com.testeweb.course.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.testeweb.course.entities.Category;
import com.testeweb.course.entities.Order;
import com.testeweb.course.entities.User;
import com.testeweb.course.entities.enums.OrderStatus;
import com.testeweb.course.repositories.OrderRepository;
import com.testeweb.course.repositories.UserRepository;
import com.testeweb.course.repositories.CategoryRepository;

import java.time.Instant;
import java.util.Arrays;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

//essa implemetação executar os metodos quando iniciada
	
		
	//testando injeção depedencia
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		//category
		Category cat1 = new Category(null, "Electronics", null); 
		Category cat2 = new Category(null, "Books", null); 
		Category cat3 = new Category(null, "Computers", null); 
		 
		
		
		//users
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		//---- salvando arquivos e associando
		//order
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.SHIPPED ,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.DELIVERED ,u1);
		//salvando dados User
		userRepository.saveAll(Arrays.asList(u1,u2));
		//salvando dados order
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		//salvando category
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
		
	}
	
	
	
}
