package com.testemuralis.cadastroclientes.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.testemuralis.cadastroclientes.domain.model.Contato;
import com.testemuralis.cadastroclientes.domain.model.Endereco;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * ClienteDTO é uma classe para a criação de
 * um objeto para transfeência de dados para evitar
 * de o usuário manipular diretamente a entidade Cliente.
 * 
 * @author Brian Schneider
 */
public class ClienteDTO {
	
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório")
	@Size(max = 150, message = " O atributo nome deve ter no máximo 150 caracteres")
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cliente")
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Contato.class)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private List<Contato> contato;
	
	@NotBlank(message = "O atributo dataCadastro é obrigatório")
	@Size(max = 10, message = " O atributo dataCadastro deve ter no máximo 10 caracteres")
	@Column(name = "data_cadastro")
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	

}
