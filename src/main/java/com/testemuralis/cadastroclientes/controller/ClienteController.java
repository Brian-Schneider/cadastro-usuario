package com.testemuralis.cadastroclientes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.dto.ClienteDTO;
import com.testemuralis.cadastroclientes.mapper.ClienteMapper;
import com.testemuralis.cadastroclientes.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteMapper mapper;
	
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {
		List<Cliente> clientes = clienteService.listarClientes();
		List<ClienteDTO> clientesResponse = mapper.conversorListaClienteDTO(clientes);
		return ResponseEntity.ok(clientesResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
		return cliente.map(resposta -> ResponseEntity.ok(mapper.conversorClienteDTO(resposta)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> post(@Valid @RequestBody ClienteDTO clienteRequest) {
		Cliente cliente = mapper.conversorCliente(clienteRequest);
		Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
		ClienteDTO clienteResponse = mapper.conversorClienteDTO(clienteSalvo);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
		
		if(cliente.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			 
		clienteService.deletarCliente(id);
	}
	
}
