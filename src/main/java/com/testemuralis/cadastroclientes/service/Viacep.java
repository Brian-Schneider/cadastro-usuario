package com.testemuralis.cadastroclientes.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.testemuralis.cadastroclientes.domain.model.Cliente;
import com.testemuralis.cadastroclientes.domain.model.Endereco;

/**
 * Classe para consumir a API do Viacep e retornar
 * o Endereco completo de acordo com o CEP do Cliente.
 * 
 * @author Brian Schneider
 */
@Service
public class Viacep {
	
	/**
	 * Método para atualizar os dados de Endereco
	 * do Cliente passando o CEP do mesmo pelo Viacep.
	 * @param Cliente a ter seu Endereco atualizado.
	 * @return Cliente com o Endereco atualizado.
	 * @throws IOException se houver algum erro em operações
	 * de entrada e saída de dados.
	 */
	public Cliente enderecoPorCep (Cliente cliente) throws IOException {
		
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
		
		return cliente;
		
	}
	

}
