package com.desafio.registroPessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.registroPessoas.model.Contato;
import com.desafio.registroPessoas.repository.ContatoRepository;

@RestController
@RequestMapping("/contatos")
@CrossOrigin("*")
public class ContatoController {

	@Autowired
	public ContatoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Contato>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contato> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeCtt/{nomeCtt}")
	public ResponseEntity<List<Contato>> GetByNomeCtt(@PathVariable String nomeCtt){
			return ResponseEntity.ok(repository.findByNomeCttContainingIgnoreCase(nomeCtt));
	}
	
	@PostMapping
	ResponseEntity<Contato> post(@RequestBody Contato contato){
		return  ResponseEntity.status(HttpStatus.CREATED).body(repository.save(contato));
	}
	
	@PutMapping
	ResponseEntity<Contato> put (@RequestBody Contato contato){
		return  ResponseEntity.status(HttpStatus.OK).body(repository.save(contato));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
