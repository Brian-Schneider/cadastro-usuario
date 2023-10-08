package com.testemuralis.cadastroclientes.service;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.domain.model.Contato;
import com.testemuralis.cadastroclientes.domain.model.Endereco;
import com.testemuralis.cadastroclientes.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente cadastrarCliente (Cliente cliente) throws Exception {
		
		String cep = cliente.getEndereco().getCep();
		
		URL url = new URL("https://viacep.com.br/ws/"+ cep +"/json/");
		URLConnection connection = url.openConnection();
		InputStream iStream = connection.getInputStream();
		BufferedReader buffRd = new BufferedReader(new InputStreamReader(iStream, "UTF-8"));
		
		String dadosEndereco = "";
		StringBuilder jsonEnd = new StringBuilder();
		
		while((dadosEndereco = buffRd.readLine()) != null) {
			jsonEnd.append(dadosEndereco);
		}
		
		Endereco tempEndereco = new Gson().fromJson(jsonEnd.toString(), Endereco.class);
		
		cliente.getEndereco().setCep(tempEndereco.getCep());
		cliente.getEndereco().setLogradouro(tempEndereco.getLogradouro());
		cliente.getEndereco().setLocalidade(tempEndereco.getLocalidade());
		cliente.getEndereco().setComplemento(tempEndereco.getComplemento());
		
		
		
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
