package com.testemuralis.cadastroclientes.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * EnderecoDTO é uma classe para a criação de
 * um objeto para transferência de dados para evitar
 * de o usuário manipular diretamente a entidade Endereco.
 * 
 * @author Brian Schneider
 */
public class EnderecoDTO {
	
	private Long id;
	
	@NotBlank(message = "O atributo CEP é obrigatório")
	@Size(max = 9, message = " O atributo CEP deve ter no máximo 9 caracteres")
	private String cep;
	
	@NotBlank(message = "O atributo logradouro é obrigatório")
	@Size(max = 150, message = " O atributo logradouro deve ter no máximo 150 caracteres")
	private String logradouro;
	
	@NotBlank(message = "O atributo localidade é obrigatório")
	@Size(max = 150, message = " O atributo localidade deve ter no máximo 150 caracteres")
	private String localidade;
	
	@NotBlank(message = "O atributo número é obrigatório")
	@Size(max = 10, message = " O atributo nome deve ter no máximo 10 caracteres")
	private String numero;
	
	private String complemento;
	
	@JsonIgnoreProperties("endereco")
	private List<ClienteDTO> cliente;
	
	/**
	 * Constrói um Endereco sem argumentos de entrada
	 */
	public EnderecoDTO() {
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public List<ClienteDTO> getCliente() {
		return cliente;
	}

	public void setCliente(List<ClienteDTO> cliente) {
		this.cliente = cliente;
	}

}
