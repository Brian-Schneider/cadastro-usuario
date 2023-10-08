package com.testemuralis.cadastroclientes.mapper;

import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.dto.ClienteDTO;

public class ClienteMapper {
	
	public static Cliente conversorToCliente(ClienteDTO clienteRequest) {
		
		Cliente cliente = new Cliente();
		cliente.setNome(clienteRequest.getNome());
		cliente.setEndereco(clienteRequest.getEndereco());
		cliente.setContato(clienteRequest.getContato());
		cliente.setDataCadastro(clienteRequest.getDataCadastro());

		return cliente;
	}
	
	public static ClienteDTO conversorToClienteDTO(Cliente cliente) {
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setEndereco(cliente.getEndereco());
		clienteDTO.setContato(cliente.getContato());
		clienteDTO.setDataCadastro(cliente.getDataCadastro());

		return clienteDTO;
	}
}
