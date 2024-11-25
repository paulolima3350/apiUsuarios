package br.com.british.api.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.british.api.usuarios.entities.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//metodo para consultar 1 usuario no banco de dados atraves da matricula
	@Query("FROM Usuario u WHERE u.matricula = :matricula")
	Usuario findByMatricula(@Param("matricula") String matricula);
	
	@Query("FROM  Usuario u WHERE u.matricula = :matricula AND u.senha = :senha")
	Usuario findByMatriculaAndSenha(@Param("matricula") String matricula, @Param("senha") String senha);
	
	@Query("FROM Usuario u WHERE u.email = :email")
	Usuario findByEmail(@Param("email") String email);
	
	


	

}
