package com.gwrocha.vancol.controllers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.val;


public abstract class BasicController<T> {

	private JpaRepository<T, Long> repository;
	
	public BasicController(JpaRepository<T, Long> repository) {
		this.repository = repository;
		System.out.println("Instancing: " + this.getClass().getName());
	}
	
	@GetMapping
	public ResponseEntity<List<T>> getAll(){
		val all = repository.findAll();
		return ResponseEntity.ok(all);
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> getOne(@PathVariable("id") Long id){
		val optional = repository.findById(id);
		return optional.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		repository.deleteById(id);
	}
	
}
