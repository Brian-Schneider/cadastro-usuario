package com.testemuralis.cadastroclientes.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.testemuralis.cadastroclientes.domain.model.Contato;
import com.testemuralis.cadastroclientes.domain.model.Endereco;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class ClienteDTO {
	
	private Long id;
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cliente")
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Contato.class)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private List<Contato> contato;
	
	//@UpdateTimestamp
	//private LocalDateTime dataCadastro;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Long id, String nome, Endereco endereco, List<Contato> contato/*, LocalDateTime dataCadastro*/) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		//this.dataCadastro = dataCadastro;
	}

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

	/*public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}*/
	
	
	
	

}
