package com.testemuralis.cadastroclientes.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.dto.ClienteDTO;

/**
 * ClienteMapper é uma classe para mapear e transpor os dados
 * entra a entidade Cliente e Cliente DTO.
 * 
 * @author Brian Schneider
 */
@Component
public class ClienteMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * Método para passar os dados de ClienteDTO
	 * para a entidade Cliente.
	 * @param clienteRequest é um ClienteDTO com os
	 * parâmentros passados pelo usuário.
	 * @return Cliente com os parâmetro de ClienteDTO
	 */
	public Cliente conversorCliente(ClienteDTO clienteRequest) {
		return mapper.map(clienteRequest, Cliente.class);
	}
	
	/**
	 * Método para passar os dados da entidade Cliente
	 * para ClienteDTO.
	 * @param cliente é um Cliente com os
	 * parâmentros retornados do banco de dados.
	 * @return ClienteDTO com os parâmetro de Cliente.
	 */
	public ClienteDTO conversorClienteDTO(Cliente cliente) {
		return mapper.map(cliente, ClienteDTO.class);
	}
	
	/**
	 * Método para passar os dados de uma Lista de entidades Cliente
	 * para uma Lista de ClienteDTO.
	 * @param clientes é uma Lista de Cliente com os
	 * parâmentros retornados do banco de dados.
	 * @return Lista de ClienteDTO com os parâmetro da Lista de Cliente.
	 */
	public List<ClienteDTO> conversorListaClienteDTO (List<Cliente> clientes) {
		return clientes
				.stream()
				.map(this::conversorClienteDTO)
				.collect(Collectors.toList());
	}
}
