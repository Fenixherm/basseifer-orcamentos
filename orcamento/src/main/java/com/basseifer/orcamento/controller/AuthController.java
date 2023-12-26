package com.basseifer.orcamento.controller;

import com.basseifer.orcamento.model.Credenciais;
import com.basseifer.orcamento.model.Usuario;
import com.basseifer.orcamento.service.UsuarioService;
import com.google.gson.Gson;
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
    public ResponseEntity<Usuario> login(@RequestBody String json){
        Gson gson = new Gson();

        Credenciais credenciais = gson.fromJson(json, Credenciais.class);

        String usuario = credenciais.getUsuario();
        String senha = credenciais.getSenha();

        boolean autorizado = usuarioService.usuarioAutorizado(usuario, senha);
        if(autorizado){
            Usuario usuarioAutorizado = usuarioService.findByUsuario(usuario);
            return ResponseEntity.ok(usuarioAutorizado);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
