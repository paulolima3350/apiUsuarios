package br.com.british.api.usuarios.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario") // Nome da tabela
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false) // Define a coluna "nome" como não nula
    private String nome;

    @Column(name = "email", nullable = false, unique = true) // Define "email" como único e não nulo
    private String email;

    @Column(name = "matricula", nullable = false, unique = true) // Define "matricula" como único e não nulo
    private String matricula;

    @Column(name = "senha", nullable = false) // Define "senha" como não nula
    private String senha;

    @ManyToOne // Relação muitos-para-um com Perfil
    @JoinColumn(name = "perfil_id", nullable = false) // Define a chave estrangeira "perfil_id"
    private Perfil perfil;

    @Column(nullable = false)
    private Boolean ativo = true;

}
