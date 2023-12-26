package com.basseifer.orcamento.controller;

import com.basseifer.orcamento.model.Usuario;
import com.basseifer.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos(){
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.buscarPorId(id));
    }

    //Não trazer o password ao fazer a pesquisa
    @GetMapping("buscar-por-nome/{username}")
    public ResponseEntity<Usuario> buscarPorUsername(@PathVariable String username){
        return ResponseEntity.status(200).body(usuarioService.findByUsuario(username));
    }

    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario){
        usuarioService.inserirUsuario(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){

        usuarioService.atualizar(id, usuario);
        return ResponseEntity.status(201).body(usuario);
    }
}