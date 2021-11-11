package com.testeweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.testeweb.course.entities.enums.OrderStatus;
@Entity
@Table(name="tb_order")
public class Order implements Serializable {
	/*
	 * Basic entity checklist:
	 Basic attributes
	 Associations (instantiate collections)
	 Constructors
	 Getters & Setters (collections: only get)
	 hashCode & equals
	 Serializable
	 * 
	 * */
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	//Association Enums
	private OrderStatus orderStatus;
	//Association 
	//um para um
	@ManyToOne
	@JoinColumn(name="client_id")
	private User client;
	
	
	
	//constructor
	public Order() {


	}
	
	
	
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}
	


	//Gettes & Settes
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public User getClient() {
		return client;
	}


	public void setClientr(User client) {
		this.client = client;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	//Hashcode e equals

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	//metodos
	
	
	
	
}
