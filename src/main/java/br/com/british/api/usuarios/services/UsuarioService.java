package br.com.british.api.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.british.api.usuarios.components.JwtTokenComponent;
import br.com.british.api.usuarios.components.SHA256Component;
import br.com.british.api.usuarios.dtos.AutenticarUsuarioRequestDto;
import br.com.british.api.usuarios.dtos.CriarUsuarioRequestDto;
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
		
		if(usuarioRepository.findByMatricula(dto.getMatricula()) != null)
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

	
	
	public String autenticarUsuario(AutenticarUsuarioRequestDto dto) {

		//buscando os dados do usuário no banco através do email e da senha
		var usuario = usuarioRepository.findByMatriculaAndSenha(dto.getMatricula(), sha256Component.hash(dto.getSenha()));
		
		//verificando se o usuário não foi encontrado
		if(usuario == null)
			throw new IllegalArgumentException("Usuário inválido.");
		
		//gerando o token do usuário
		var token = jwtTokenComponent.generateToken(usuario.getId());
		
		//retornando o token
		return token;
	}

}
