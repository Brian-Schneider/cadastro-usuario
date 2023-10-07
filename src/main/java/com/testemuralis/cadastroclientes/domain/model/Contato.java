package com.testemuralis.cadastroclientes.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_contato")
@Data
@NoArgsConstructor
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo tipo é obrigatório")
	@Size(max = 10, message = " O atributo tipo deve ter no máximo 10 caracteres")
	@Column(name = "tipo")
	private String tipo;
	
	@NotBlank(message = "O atributo texto é obrigatório")
	@Size(max = 50, message = " O atributo texto deve ter no máximo 50 caracteres")
	@Column(name = "texto")
	private String texto;
	
	@ManyToOne
	@JsonIgnoreProperties("contato")
	private Cliente cliente;
}
