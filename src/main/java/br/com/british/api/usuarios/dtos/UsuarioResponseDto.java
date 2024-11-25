package br.com.british.api.usuarios.dtos;

import lombok.Data;

@Data
public class UsuarioResponseDto {
    private Long id;
    private String nome;
    private String email;
    private Long matricula;
    private Boolean ativo;
    private String perfil;
}
