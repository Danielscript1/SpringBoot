package com.testeweb.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.testeweb.course.entities.Order;
import com.testeweb.course.entities.Product;
//anotação que identifica chave composta
@Embeddable
public class OrderItemPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Checklist: 
	  OrderItemPK ok
	  OrderItem 
	  Order one-to-many association ok 
	  Seed 
	 * 
	 * */
	
	//OrderItem -> reference classe product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	//OrderItemPk ->reference classe Order
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	
	
	
	
	
	
	
	
	
}
