package com.testemuralis.cadastroclientes.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testemuralis.cadastroclientes.domain.model.Endereco;
import com.testemuralis.cadastroclientes.dto.EnderecoDTO;

@Component
public class EnderecoMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public Endereco conversorEndereco(EnderecoDTO enderecoRequest) {
		return mapper.map(enderecoRequest, Endereco.class);
	}
	
	public EnderecoDTO conversorEnderecoDTO(Endereco endereco) {
		return mapper.map(endereco, EnderecoDTO.class);
	}
	
	public List<EnderecoDTO> conversorListaEndercoDTO(List<Endereco> enderecos) {
		return enderecos
				.stream()
				.map(this::conversorEnderecoDTO)
				.collect(Collectors.toList());
	}
}
