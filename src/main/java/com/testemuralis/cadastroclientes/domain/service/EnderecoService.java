package com.testemuralis.cadastroclientes.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testemuralis.cadastroclientes.domain.model.Endereco;
import com.testemuralis.cadastroclientes.domain.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> listarEnderecos() {
		return enderecoRepository.findAll();
	}

	public List<Endereco> listarEnderecosPorCep(String cep) {
		String cepComHifen = cep.substring(0, 5) + '-' + cep.substring(5, 8);
		return enderecoRepository.findAllByCepContaining(cepComHifen);
	}

}
