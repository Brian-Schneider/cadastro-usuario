package com.testemuralis.cadastroclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testemuralis.cadastroclientes.domain.model.Endereco;
import com.testemuralis.cadastroclientes.domain.service.EnderecoService;
import com.testemuralis.cadastroclientes.dto.EnderecoDTO;
import com.testemuralis.cadastroclientes.mapper.EnderecoMapper;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoMapper enderecoMapper;
	
	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> getAll() {
		List<Endereco> enderecos = enderecoService.listarEnderecos();
		List<EnderecoDTO> enderecosResponse = enderecoMapper.conversorListaEndercoDTO(enderecos);
		return ResponseEntity.ok(enderecosResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTO> getById() {
		return null;
	}
	
	@GetMapping("/rua/{logradouro}")
	public ResponseEntity<List<EnderecoDTO>> getAllByLogradouro() {
		return null;
	}
	
	@GetMapping("/localidade/{localidade}")
	public ResponseEntity<List<EnderecoDTO>> getAllByLocalidade() {
		return null;
	}
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<List<EnderecoDTO>> getAllByCep(@PathVariable String cep) {
		List<Endereco> enderecos = enderecoService.listarEnderecosPorCep(cep);
		List<EnderecoDTO> enderecosResponse = enderecoMapper.conversorListaEndercoDTO(enderecos);
		return ResponseEntity.ok(enderecosResponse);
	}
	
	@GetMapping("/endereco/{lcep}/{numero}")
	public ResponseEntity<List<EnderecoDTO>> getByCepAndNumero() {
		return null;
	}
}
