package br.com.british.api.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.british.api.usuarios.entities.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	
	 @Query("FROM Permissao p WHERE p.nome = :nome")
	   Permissao findByNome(@Param("nome") String nome);
}
	