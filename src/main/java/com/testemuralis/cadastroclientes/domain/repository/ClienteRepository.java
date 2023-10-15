package com.testemuralis.cadastroclientes.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.testemuralis.cadastroclientes.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public List<Cliente> findAllByNomeContainingIgnoreCase(@Param("nome") String cliente);



}
