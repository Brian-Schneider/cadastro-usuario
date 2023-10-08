package com.testemuralis.cadastroclientes.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_cliente")
@Data
@NoArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public Cliente() {
		
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

	//public LocalDateTime getDataCadastro() {
	//	return dataCadastro;
	//}

	//public void setDataCadastro(LocalDateTime dataCadastro) {
	//	this.dataCadastro = dataCadastro;
	//}
	
	

}
