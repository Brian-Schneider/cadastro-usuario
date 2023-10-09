package com.testemuralis.cadastroclientes.domain.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.domain.repository.ClienteRepository;

/**
 * Service para implementação dos métodos a
 * serem utilizados em Controller.
 * 
 * @author Brian Schneider
 */
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private Viacep viacep;

	/**
	 * Método para Cadastrar um novo Cliente no banco de dados.
	 * @param cliente é o novo Cliente a ser salvo.
	 * @return cliente salvo no banco de dados.
	 * @throws IOException em {@link Viacep#enderecoPorCep(Cliente) EnderecoPorCep}.
	 */
	public Cliente cadastrarCliente (Cliente cliente) throws IOException {
		
		Cliente clienteComEndereco = viacep.enderecoPorCep(cliente);
		
		return clienteRepository.save(clienteComEndereco);
	}
	
	/**
	 * Método para Listar todos os Clientes no banco de dados.
	 * @return Lista de Clientes no banco de dados.
	 */
	public List<Cliente> listarClientes ()  {
		return clienteRepository.findAll();
	}
	
	/**
	 * Método para buscar um Cliente no banco de dados
	 * pelo seu id.
	 * @param id do Cliente a ser buscado no banco de dados.
	 * @return Cliente do respectivo id informado.
	 */
	public Optional<Cliente> buscarClientePorId (Long id) {
		return clienteRepository.findById(id);
	}
	
	/**
	 * Método para Atualizar um Cliente no banco de dados.
	 * @param cliente é o Cliente a ser atualizado.
	 * @return cliente atualizado no banco de dados.
	 * @throws IOException em {@link Viacep#enderecoPorCep(Cliente) EnderecoPorCep}.
	 */
	public Cliente atualizarCliente (Cliente cliente) throws Exception {
		
		Optional<Cliente> clienteDadosAntigos = clienteRepository.findById(cliente.getId());
		
		if (clienteDadosAntigos.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		Cliente clienteComEndereco = viacep.enderecoPorCep(cliente);
		return clienteRepository.save(clienteComEndereco);
		
	} 
	
	/**
	 * Método para deletar um Cliente do banco de dados.
	 * @param id do Cliente a ser deletado.
	 */
	public void deletarCliente (Long id) {
		clienteRepository.deleteById(id);
	}
} 
