package br.com.british.api.usuarios.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {

	@Size(min = 8, max = 100, message = "Por favor, informe o nome de 8 a 100 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotEmpty(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@Size(min = 4, max = 10, message = "Por favor, informe o numero da matricula de 4 a 10 caracteres.")
	@NotEmpty(message = "Por favor, informe o matricula do usuário.")
	private String matricula;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", 
			message = "Por favor, informe a senha com letras maiúsculas, minúsculas, números, símbolos e pelo menos 8 caracteres.")
	@NotEmpty(message = "Por favor, informe a senha do usuário.")
	private String senha;
	
}
