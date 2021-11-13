package com.testeweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant moment;
	//Association Enums
	private Integer orderStatus;
	//Association 
	//muitos para um
	@ManyToOne
	@JoinColumn(name="client_id")
	private User client;
	/*
	 * Checklist: 
	  OrderItemPK ok
	  OrderItem ok
	  Order one-to-many association ok exemplo -> order contem varios product 
	//product esta associado ordemItem que por usa vez retorna orderItemPk
	 * fazendo o mapeamento para retornar o item associado
	  Seed 
	 * 
	 * */
	//associação com minha classe OrdemItem 
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	
	
	//constructor
	public Order() {


	}
	
	
	
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
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


	
	
	public User getClient() {
		return client;
	}


	public void setClient(User client) {
		this.client = client;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus!=null) {
		this.orderStatus = orderStatus.getCode();
		}else {
		throw new IllegalArgumentException("Ops! valor invalido, :( ");
		}
	}
	
	public Set<OrderItem> getItems() {
		return items;
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
