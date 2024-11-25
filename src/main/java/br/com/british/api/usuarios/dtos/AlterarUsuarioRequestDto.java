package br.com.british.api.usuarios.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlterarUsuarioRequestDto {

	
	 private Long matricula; // Para identificar o usuário
	    private String nome;
	    private String email;
	    private String perfil; // Nome do perfil
	    private Boolean ativo;
}
