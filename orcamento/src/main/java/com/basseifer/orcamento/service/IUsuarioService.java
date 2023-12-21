package com.basseifer.orcamento.service;

import com.basseifer.orcamento.model.Orcamento;
import com.basseifer.orcamento.model.Usuario;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUsuarioService {
    Iterable<Usuario> buscarTodos();
    Usuario buscarPorId(Long id);
    Usuario findByUsername(String username);
    void inserirUsuario(Usuario usuario);
    void atualizar(Long id, Usuario usuario);

    Boolean usuarioAutorizado(String username, String password);
}
