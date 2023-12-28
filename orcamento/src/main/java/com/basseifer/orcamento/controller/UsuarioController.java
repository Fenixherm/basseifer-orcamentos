package com.basseifer.orcamento.controller;

import com.basseifer.orcamento.configuration.UserConfiguration;
import com.basseifer.orcamento.model.Credenciais;
import com.basseifer.orcamento.model.Usuario;
import com.basseifer.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UserConfiguration passwordEncoder;
    @GetMapping("/usuarios")
    public ResponseEntity<Iterable<Usuario>> buscarTodos(){
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.buscarPorId(id));
    }

    //Não trazer o password ao fazer a pesquisa
    @GetMapping("/buscar-por-nome/{username}")
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

    @PostMapping("/login")
    public ResponseEntity<Credenciais> login(@RequestBody Credenciais usuario){

        Boolean valido = usuarioService.usuarioAutorizado(usuario.getUsuario(), usuario.getSenha());
        if(!valido){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).body(usuario);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            erros.put(fieldName, errorMessage);
        });

        return erros;
    }
}