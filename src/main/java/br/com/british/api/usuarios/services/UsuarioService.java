package br.com.british.api.usuarios.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.british.api.usuarios.components.JwtTokenComponent;
import br.com.british.api.usuarios.components.SHA256Component;
import br.com.british.api.usuarios.dtos.AlterarUsuarioRequestDto;
import br.com.british.api.usuarios.dtos.AutenticarUsuarioRequestDto;
import br.com.british.api.usuarios.dtos.AutenticarUsuarioResponseDto;
import br.com.british.api.usuarios.dtos.CriarUsuarioRequestDto;
import br.com.british.api.usuarios.dtos.UsuarioResponseDto;
import br.com.british.api.usuarios.entities.Usuario;
import br.com.british.api.usuarios.repositories.PerfilRepository;
import br.com.british.api.usuarios.repositories.PermissaoRepository;
import br.com.british.api.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@Autowired
	PermissaoRepository permissaoRepository;

	@Autowired
	SHA256Component sha256Component;

	@Autowired
	JwtTokenComponent jwtTokenComponent;

	public String criarUSuario(CriarUsuarioRequestDto dto) {

		if (usuarioRepository.findByMatricula(dto.getMatricula()) != null)
			throw new IllegalArgumentException("A matricula informada ja esta cadastrada, tente outra");

		// Capturar os dados do usuário
		var usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setMatricula(dto.getMatricula());
		usuario.setSenha(sha256Component.hash(dto.getSenha()));

		// Associa o perfil (exemplo: perfil "OPERADOR")
		usuario.setPerfil(perfilRepository.findByNome("OPERADOR"));

		// Cadastrando o usuário no banco de dados
		usuarioRepository.save(usuario);

		// Retornando mensagem de sucesso
		return "Usuário cadastrado com sucesso.";
	}

	public AutenticarUsuarioResponseDto autenticarUsuario(AutenticarUsuarioRequestDto dto) {

		// buscando os dados do usuário no banco através do email e da senha
		var usuario = usuarioRepository.findByMatriculaAndSenha(dto.getMatricula(),
				sha256Component.hash(dto.getSenha()));

		// verificando se o usuário não foi encontrado
		if (usuario == null)
			throw new IllegalArgumentException("Usuário inválido.");

		// gerando o token do usuário
		var token = jwtTokenComponent.generateToken(usuario.getId());

		var response = new AutenticarUsuarioResponseDto();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setToken(token);
		response.setDataHoraAcesso(new Date()); // Data e hora do acesso
		response.setDataHoraExpiracao(new Date(new Date().getTime() + 600000)); // 10 minutos
		response.setPerfil(usuario.getPerfil().getNome());
		response.setMensagem("Usuário autenticado com sucesso.");

		// retornando o token
		return response;
	}

	public String alterarUsuarioPorMatricula(AlterarUsuarioRequestDto dto) {
	    // Buscar o usuário existente pela matrícula
	    var usuarioExistente = usuarioRepository.findByMatricula(dto.getMatricula());
	    if (usuarioExistente == null) {
	        throw new IllegalArgumentException("Usuário não encontrado com a matrícula: " + dto.getMatricula());
	    }

	    // Buscar e verificar o perfil
	    var perfil = perfilRepository.findByNome(dto.getPerfil());
	    if (perfil == null) {
	        throw new IllegalArgumentException("Perfil não encontrado: " + dto.getPerfil());
	    }

	    // Atualizar os campos permitidos
	    usuarioExistente.setNome(dto.getNome());
	    usuarioExistente.setEmail(dto.getEmail());
	    usuarioExistente.setPerfil(perfil);

	    // Atualizar o status ativo/inativo (se presente no DTO)
	    if (dto.getAtivo() != null) {
	        usuarioExistente.setAtivo(dto.getAtivo());
	    }

	    // Salvar as alterações no banco de dados
	    usuarioRepository.save(usuarioExistente);

	    return "Usuário alterado com sucesso.";
	}


	public UsuarioResponseDto consultarUsuarioPorMatricula(Long matricula) {
	    // Buscar usuário pelo número de matrícula
	    var usuario = usuarioRepository.findByMatricula(matricula);

	    // Verificar se o usuário foi encontrado
	    if (usuario == null) {
	        throw new IllegalArgumentException("Usuário com a matrícula " + matricula + " não foi encontrado.");
	    }

	    // Mapear os dados do usuário para o DTO de resposta
	    var responseDto = new UsuarioResponseDto();
	    responseDto.setId(usuario.getId());
	    responseDto.setNome(usuario.getNome());
	    responseDto.setEmail(usuario.getEmail());
	    responseDto.setMatricula(usuario.getMatricula());
	    responseDto.setAtivo(usuario.getAtivo());
	    responseDto.setPerfil(usuario.getPerfil().getNome());

	    return responseDto;
	}


	public List<UsuarioResponseDto> consultarTodosUsuarios() {
	    // Buscar todos os usuários no banco de dados
	    var usuarios = usuarioRepository.findAll();

	    // Mapear cada usuário para o DTO de resposta
	    return usuarios.stream().map(usuario -> {
	        var responseDto = new UsuarioResponseDto();
	        responseDto.setId(usuario.getId());
	        responseDto.setNome(usuario.getNome());
	        responseDto.setEmail(usuario.getEmail());
	        responseDto.setMatricula(usuario.getMatricula());
	        responseDto.setAtivo(usuario.getAtivo());
	        responseDto.setPerfil(usuario.getPerfil().getNome());
	        return responseDto;
	    }).collect(Collectors.toList());
	}


}
