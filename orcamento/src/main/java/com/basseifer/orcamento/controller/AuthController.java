package com.basseifer.orcamento.controller;

import com.basseifer.orcamento.model.Usuario;
import com.basseifer.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody String usuario, String senha){
        boolean autorizado = usuarioService.usuarioAutorizado(usuario, senha);
        if(autorizado){
            Usuario usuarioAutorizado = usuarioService.findByUsername(usuario);
            return ResponseEntity.ok(usuarioAutorizado);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

    }
}
