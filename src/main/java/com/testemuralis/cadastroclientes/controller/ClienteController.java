package com.testemuralis.cadastroclientes.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.domain.service.ClienteService;
import com.testemuralis.cadastroclientes.dto.ClienteDTO;
import com.testemuralis.cadastroclientes.mapper.ClienteMapper;

import jakarta.validation.Valid;

/**
 * Controller para os Endpoints REST de Cadastro Clientes.
 * <p>
 * Classe responsável pela operacão dos métodos
 * CRUD dos Cadastros de Cliente por meio de requisições HTTP.
 * </p>
 * O Endpoint é "/clientes".
 * </p>
 * @author Brian Schneider
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteMapper mapper;
	
	/**
	 * Exibe uma Lista com todos os Clientes já Cadastrados.
	 * <p>
	 * 200: Lista retornada com sucesso.
	 * </p>
	 * 
	 * @return Uma Lista de Clientes cadastrados.
	 */
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {
		List<Cliente> clientes = clienteService.listarClientes();
		List<ClienteDTO> clientesResponse = mapper.conversorListaClienteDTO(clientes);
		return ResponseEntity.ok(clientesResponse);
	}
	
	/**
	 * Busca por id um Cliente e exibe um DTO do mesmo.
	 * <p>
	 * O Endpoint desse método é "/id".
	 * </p>
	 * <p>
	 * 200: Cliente encontrado com sucesso.
	 * </p>
	 * <p>
	 * 404: Cliente não foi encontrado.
	 * </p>
	 * @param id do Cliente a ser buscado.
	 * @return um DTO do Cliente encontrado.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
		return cliente.map(resposta -> ResponseEntity.ok(mapper.conversorClienteDTO(resposta)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/buscar-nome/{nome}")
	public ResponseEntity<List<ClienteDTO>> getByNome(@PathVariable String nome) {
		List<Cliente> clientes = clienteService.buscarClientePorNome(nome);
		List<ClienteDTO> clientesResponse = mapper.conversorListaClienteDTO(clientes);
		return ResponseEntity.ok(clientesResponse);
	}
	
	/**
	 * Cadastra um novo objeto Cliente de acordo com os dados de entrada.
	 * <p>
	 * 201: Cliente cadastrado com sucesso.
	 * </p>
	 * @param clienteRequest é um JSON representando um DTO Cliente.
	 * @return o DTO do Cliente recém cadastrado.
	 * @throws IOException em {@link ClienteService#cadastrarCliente(Cliente) CadastrarCliente}.
	 */
	@PostMapping
	public ResponseEntity<ClienteDTO> post(@Valid @RequestBody ClienteDTO clienteRequest) throws Exception {
		Cliente cliente = mapper.conversorCliente(clienteRequest);
		Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
		ClienteDTO clienteResponse = mapper.conversorClienteDTO(clienteSalvo);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
	}
	
	/**
	 * Atualiza um Cliente já existente.
	 * de acordo com os dados de entrada do objeto
	 * 
	 * <p>
	 * 200: Cliente atualizado com sucesso.
	 * </p>
	 * <p>
	 * 404: Cliente não foi encontrado.
	 * </p>
	 * @param clienteRequest é um JSON representando um DTO Cliente.
	 * @return o DTO do Cliente recém atualizado.
	 * @throws IOException em {@link ClienteService#atualizarCliente(Cliente) CadastrarCliente}.
	 */
	@PutMapping
	public ResponseEntity<ClienteDTO> put(@Valid @RequestBody ClienteDTO clienteRequest) throws Exception{
		Cliente cliente = mapper.conversorCliente(clienteRequest);
		Cliente clienteSalvo = clienteService.atualizarCliente(cliente);
		ClienteDTO clienteResponse = mapper.conversorClienteDTO(clienteSalvo);
		return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);
	}
	
	/**
	 * Busca por id um Cliente e deleta o mesmo.
	 * <p>
	 * O Endpoint desse método é "/id"
	 * </p>
	 * <p>
	 * 200: Cliente deletado com sucesso.
	 * </p>
	 * <p>
	 * 404: Cliente não foi encontrado.
	 * </p>
	 * @param id do Cliente a ser deletado.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
		
		if(cliente.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			 
		clienteService.deletarCliente(id);
	}
	
}
