package com.basseifer.orcamento.service;

import com.basseifer.orcamento.model.OrcamentoRepository;
import com.basseifer.orcamento.model.Usuario;
import com.basseifer.orcamento.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

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
}
