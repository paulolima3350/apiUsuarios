package br.com.british.api.usuarios.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController {

    @PostMapping("/criar")
    public String criar() {
        return "Criar perfil";
    }

    @GetMapping
    public String listar() {
        return "Listar perfis";
    }
}
