package com.matheus.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.todo.domain.Todo;
import com.matheus.todo.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void instanciaBaseDeDados() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2", LocalDateTime.parse("25/03/2022 10:40", formatter),false);
		Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal", LocalDateTime.parse("22/03/2021 13:00", formatter),true);
		Todo t3 = new Todo(null, "Exercícios", "Praticar exercícios físicos", LocalDateTime.parse("25/03/2022 10:15", formatter),false);
		Todo t4 = new Todo(null, "Meditar", "Meditar durante 30 minutos pela manhã", LocalDateTime.parse("25/03/2022 05:40", formatter),true);
		

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}
