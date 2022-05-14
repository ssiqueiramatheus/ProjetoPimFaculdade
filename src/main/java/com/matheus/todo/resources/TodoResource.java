package com.matheus.todo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.todo.domain.Todo;
import com.matheus.todo.services.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {
	
	@Autowired
	private TodoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id){
		Todo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//lista as atividades pendentes
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> listOpen(){
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	//lista as atividades concluidas 
	@GetMapping(value = "/close")
	public ResponseEntity<List<Todo>> listclose(){
		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}
	
	//lista todas as atividades
	@GetMapping
	public ResponseEntity<List<Todo>> listAll(){
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Criando uma nova atividade
	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody Todo obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Vai deletar uma atividade
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Atualizando uma atividade
	@PutMapping(value = "/{id}")
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj){
		Todo newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}

//localhost:8080/todos