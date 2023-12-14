package com.basseifer.orcamento.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Query Method
    //Usuario findByNome(String nome);

}
