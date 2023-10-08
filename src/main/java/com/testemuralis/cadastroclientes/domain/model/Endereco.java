package com.testemuralis.cadastroclientes.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_endereco")
@Data
@NoArgsConstructor
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotBlank(message = "O atributo CEP é obrigatório")
	//@Size(max = 8, message = " O atributo CEP deve ter no máximo 8 caracteres")
	@Column(name = "cep")
	private String cep;
	
	//@NotBlank(message = "O atributo logradouro é obrigatório")
	//@Size(max = 150, message = " O atributo logradouro deve ter no máximo 150 caracteres")
	@Column(name = "logradouro")
	private String logradouro;
	
	//@NotBlank(message = "O atributo cidade é obrigatório")
	//@Size(max = 150, message = " O atributo cidade deve ter no máximo 150 caracteres")
	@Column(name = "cidade")
	private String localidade;
	
	//@NotBlank(message = "O atributo número é obrigatório")
	//@Size(max = 10, message = " O atributo nome deve ter no máximo 10 caracteres")
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "complemento")
	private String complemento;
	
	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
	private List<Cliente> cliente;
	
	public Endereco() {
		
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

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
	this.cliente = cliente;
	}
	
	

}
