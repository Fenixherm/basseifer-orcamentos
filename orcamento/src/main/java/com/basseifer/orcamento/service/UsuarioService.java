package com.basseifer.orcamento.service;

import com.basseifer.orcamento.configuration.UserConfiguration;
import com.basseifer.orcamento.model.Usuario;
import com.basseifer.orcamento.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UserConfiguration passwordEncoder;


    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public Usuario findByUsuario(String usuario) {
        return usuarioRepository.findByusuario(usuario);
    }


    @Override
    public void inserirUsuario(Usuario usuario) {
        if(usuario.getId() != null) {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId());
            if(usuarioOptional.isPresent()){
                System.out.println("Usuário já existente!");
                return;
            }
        }
        usuarioRepository.save(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioBdOptional = usuarioRepository.findById(id);
        if(usuarioBdOptional.isPresent()){
            Usuario usuarioBd = usuarioBdOptional.get();
            usuarioBd.setNome(usuario.getNome());
            usuarioRepository.save(usuarioBd);
        }else{
            System.out.println("Usuário Inexistente !");
            return;
        }
    }

    @Override
    public Boolean usuarioAutorizado(String usuario, String senha) {
        Usuario usuarioBdOptional = usuarioRepository.findByusuario(usuario);
        return passwordEncoder.encoder().matches(usuarioBdOptional.getSenha(), senha);
    }
}
