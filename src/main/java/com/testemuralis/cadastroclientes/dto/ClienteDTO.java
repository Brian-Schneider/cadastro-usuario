package com.testemuralis.cadastroclientes.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * ClienteDTO é uma classe para a criação de
 * um objeto para transferência de dados para evitar
 * de o usuário manipular diretamente a entidade Cliente.
 * 
 * @author Brian Schneider
 */
public class ClienteDTO {
	
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório")
	@Size(max = 150, message = " O atributo nome deve ter no máximo 150 caracteres")
	private String nome;
	
	@JsonIgnoreProperties("cliente")
	private EnderecoDTO endereco;
	
	private List<ContatoDTO> contato;
	
	@NotBlank(message = "O atributo dataCadastro é obrigatório")
	@Size(max = 10, message = " O atributo dataCadastro deve ter no máximo 10 caracteres")
	private String dataCadastro;
	
	//@UpdateTimestamp
	//private LocalDateTime dataCadastro;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<ContatoDTO> getContato() {
		return contato;
	}

	public void setContato(List<ContatoDTO> contato) {
		this.contato = contato;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	

}
