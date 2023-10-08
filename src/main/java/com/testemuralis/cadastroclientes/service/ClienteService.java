package com.testemuralis.cadastroclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.domain.model.Contato;
import com.testemuralis.cadastroclientes.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente cadastrarCliente (Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientes ()  {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscarClientePorId (Long id) {
		return clienteRepository.findById(id);
	}
	
	public Cliente atualizarCliente (Cliente cliente) {
		
		Optional<Cliente> clienteDadosAntigos = clienteRepository.findById(cliente.getId());
		if (clienteDadosAntigos.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return clienteRepository.save(cliente);
		
	} 
	
	public void deletarCliente (Long id) {
		clienteRepository.deleteById(id);
	}
} 
