package br.com.british.api.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.british.api.usuarios.dtos.AlterarUsuarioRequestDto;
import br.com.british.api.usuarios.dtos.AutenticarUsuarioRequestDto;
import br.com.british.api.usuarios.dtos.AutenticarUsuarioResponseDto;
import br.com.british.api.usuarios.dtos.CriarUsuarioRequestDto;
import br.com.british.api.usuarios.dtos.UsuarioResponseDto;
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
    
    @PutMapping("alterar")
    public String alterar(@RequestBody @Valid AlterarUsuarioRequestDto dto) {
        return usuarioService.alterarUsuarioPorMatricula(dto);
    }

    @GetMapping("/{matricula}")
    public UsuarioResponseDto consultarUsuario(@PathVariable Long matricula) {
        return usuarioService.consultarUsuarioPorMatricula(matricula);
    }
    
    
    @GetMapping
    public List<UsuarioResponseDto> consultarTodosUsuarios() {
        return usuarioService.consultarTodosUsuarios();
    }

}