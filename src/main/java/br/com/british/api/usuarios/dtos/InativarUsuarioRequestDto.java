package br.com.british.api.usuarios.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InativarUsuarioRequestDto {
    @NotNull(message = "A matrícula é obrigatória.")
    private Long matricula;
}
