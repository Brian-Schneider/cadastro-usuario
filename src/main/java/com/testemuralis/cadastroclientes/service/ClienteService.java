package com.testemuralis.cadastroclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	/*public Cliente atualizarCliente (Cliente cliente) {
		
		if(clienteRepository.existsById(cliente))
		
	} */
	
	public void deletarCliente (Long id) {
		clienteRepository.deleteById(id);
	}
} 
