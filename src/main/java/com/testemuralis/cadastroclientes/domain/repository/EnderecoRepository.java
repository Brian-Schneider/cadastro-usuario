package com.testemuralis.cadastroclientes.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.testemuralis.cadastroclientes.domain.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	public List<Endereco> findAllByCepContaining(@Param("cep") String cep);

}
