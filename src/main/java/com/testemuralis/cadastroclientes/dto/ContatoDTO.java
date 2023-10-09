package com.testemuralis.cadastroclientes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * ContatoDTO é uma classe para a criação de
 * um objeto para transferência de dados para evitar
 * de o usuário manipular diretamente a entidade Contato.
 * 
 * @author Brian Schneider
 */
public class ContatoDTO {
	
	private Long id;
	
	@NotBlank(message = "O atributo tipo é obrigatório")
	@Size(max = 10, message = " O atributo tipo deve ter no máximo 10 caracteres")
	private String tipo;
	
	@NotBlank(message = "O atributo texto é obrigatório")
	@Size(max = 50, message = " O atributo texto deve ter no máximo 50 caracteres")
	private String texto;
	
	/**
	 * Constrói um Contato sem argumentos de entrada
	 */
	public ContatoDTO() {
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
