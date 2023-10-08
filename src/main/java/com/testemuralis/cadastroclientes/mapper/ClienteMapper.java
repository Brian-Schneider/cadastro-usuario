package com.testemuralis.cadastroclientes.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.dto.ClienteDTO;

@Component
public class ClienteMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public Cliente conversorCliente(ClienteDTO clienteRequest) {
		return mapper.map(clienteRequest, Cliente.class);
	}
	
	
	
	public ClienteDTO conversorClienteDTO(Cliente cliente) {
		return mapper.map(cliente, ClienteDTO.class);
	}
	
	public List<ClienteDTO> conversorListaClienteDTO (List<Cliente> clientes) {
		return clientes
				.stream()
				.map(this::conversorClienteDTO)
				.collect(Collectors.toList());
	}
}
