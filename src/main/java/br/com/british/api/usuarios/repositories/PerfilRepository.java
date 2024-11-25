package br.com.british.api.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.british.api.usuarios.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

	/*
	 * Método para consultar perfil no banco de dados através do nome
	 */
	@Query("FROM Perfil p WHERE p.nome = :nome")
	Perfil findByNome(@Param("nome") String nome);
}
