package com.gwrocha.vancol.services;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gwrocha.vancol.exceptions.ObjectNotFoundException;
import com.gwrocha.vancol.models.BasicModel;

abstract class CrudService<T extends BasicModel> {
	
	private JpaRepository<T, Long> repository;
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public CrudService(JpaRepository<T, Long> repository) {
		super();
		this.repository = repository;
		 this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T save(T entity) {
		entity.setId(null);
		return repository.save(entity);
	}
	
	public List<T> saveAll(List<T> entities) {
		return repository.saveAll(entities);
	}

	public T update(T entity) {
		if(!repository.existsById(entity.getId())) 
			throw new ObjectNotFoundException(clazz, entity.getId());
		
		return repository.save(entity);
	}
	
	public Optional<T> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<T> findAllByIds(List<Long> ids){
		return repository.findAllById(ids);
	}
	
	public List<T> findAll(){
		return repository.findAll();
	}
	
	public boolean exists(Long id) {
		return repository.existsById(id);
	}
	
	public boolean notExists(Long id) {
		return !exists(id);
	}
	
	public void deleteById(Long id) {
		if(!repository.existsById(id)) 
			throw new ObjectNotFoundException(clazz, id);
		
		repository.deleteById(id);
	}

	public void delete(T entity) {
		if(!repository.existsById(entity.getId())) 
			throw new ObjectNotFoundException(clazz, entity.getId());
		
		repository.delete(entity);
	}

}
