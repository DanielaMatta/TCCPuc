package com.academia.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.academia.domain.models.*;
import com.academia.domain.repository.AlunoRepository;


@RestController
public class AlunoController {

	@Autowired
	private AlunoRepository rep;
	
	// Lista de alunos do BD
	@GetMapping("/alunos")
	public List<Aluno> listar() {
		return rep.findAll();
	}

	// procurar aluno pelo id
	@GetMapping("/alunos/{id}")
	public ResponseEntity<Aluno> encontrarPeloId(@PathVariable Long id) {
		Optional<Aluno> aluno = rep.findById(id);
		if (aluno.isPresent()) {
			return ResponseEntity.ok(aluno.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Cadastro de novos alunos

	@PostMapping("/alunos")
	public Aluno cadastrar(@RequestBody Aluno aluno) {
		return rep.save(aluno);

	}

	// Atualizar dados de um registro
	
	@PutMapping("/alunos/{id}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
		if (!rep.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {

			aluno.setId(id);
			aluno = rep.save(aluno);
		return ResponseEntity.ok(aluno);

	}
	}
	
	
	@DeleteMapping("/alunos/{id}")
	public ResponseEntity<Aluno> excluirPorId(@PathVariable Long id) {
		
		if(!rep.existsById(id)) {
			
			return ResponseEntity.notFound().build();
		} else {
		
		rep.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	}
	}

