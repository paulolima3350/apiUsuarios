package br.com.british.api.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.british.api.usuarios.dtos.AutenticarUsuarioRequestDto;
import br.com.british.api.usuarios.dtos.AutenticarUsuarioResponseDto;
import br.com.british.api.usuarios.dtos.CriarUsuarioRequestDto;
import br.com.british.api.usuarios.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	@Autowired //injeção de dependência
	UsuarioService usuarioService;

    @PostMapping("criar")
    public String criar(@RequestBody @Valid CriarUsuarioRequestDto dto) {
        return usuarioService.criarUSuario(dto);
    }
    
    @PostMapping("autenticar")
	public AutenticarUsuarioResponseDto autenticar(@RequestBody @Valid AutenticarUsuarioRequestDto dto) {
		return usuarioService.autenticarUsuario(dto);
	}

}