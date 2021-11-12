package com.testeweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="tb_category")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	//associacao
	@ManyToMany
	@JoinColumn(name="product_id")
	private List<Product> products =  new ArrayList<>();
	//constructor

	public Category() {
		
	}
	public Category(Long id, String name, List<Product> products) {
		
		this.id = id;
		this.name = name;
		this.products = products;
	}

	//Gettes & Settes
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	//hashCode e equals
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
}
