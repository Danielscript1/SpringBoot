package com.testeweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
	@JsonIgnore
	@ManyToMany
	@JoinColumn(name="product_id")
	private Set<Product> products =  new HashSet<>();
	//criando uma lista do tipo set que não aceitar repeticoes ->product "associação muito pra muitos"
	//constructor

	public Category() {
		
	}
	public Category(Long id, String name) {
		
		this.id = id;
		this.name = name;
		
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
	public Set<Product> getProducts() {
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
