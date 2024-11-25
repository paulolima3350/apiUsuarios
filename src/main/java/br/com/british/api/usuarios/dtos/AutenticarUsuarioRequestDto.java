package br.com.british.api.usuarios.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AutenticarUsuarioRequestDto {

    @NotNull(message = "Por favor, informe a matrícula do usuário.")
    private Long matricula;

    @Size(min = 8, message = "Por favor, informe a senha com pelo menos 8 caracteres.")
    @NotEmpty(message = "Por favor, informe a senha do usuário.")
    private String senha;
}
