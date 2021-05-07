package com.desafio.registroPessoas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.registroPessoas.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	public List<Contato> findByNomeCttContainingIgnoreCase(String nomeCtt);
	

}
