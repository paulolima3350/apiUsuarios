package br.com.british.api.usuarios.dtos;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutenticarUsuarioResponseDto {
   
	
	private Long id; // Altere para Long
    private String nome;
    private String email;
    private String token;
    private Date dataHoraAcesso;
    private Date dataHoraExpiracao;
    private String perfil;
    private String mensagem;
}