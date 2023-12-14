package com.basseifer.orcamento.service;

import com.basseifer.orcamento.model.Orcamento;
import com.basseifer.orcamento.model.Usuario;

public interface IUsuarioService {
    Iterable<Usuario> buscarTodos();
    Usuario buscarPorId(Long id);

    void inserirUsuario(Usuario usuario);
    void atualizar(Long id, Usuario usuario);
}
