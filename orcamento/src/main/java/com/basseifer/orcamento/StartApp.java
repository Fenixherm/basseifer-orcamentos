package com.basseifer.orcamento;

import com.basseifer.orcamento.model.Usuario;
import com.basseifer.orcamento.model.UsuarioRepository;
import com.basseifer.orcamento.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private IUsuarioService uService;
    @Override
    public void run(String... args) throws Exception {

        Usuario usuario = new Usuario();

        usuario.setNome("Guilherme");
        usuario.setUsuario("Guilherme");
        usuario.setSenha("123456");
        usuario.setRoles(Collections.singletonList("USER"));

        uService.inserirUsuario(usuario);

        for (Usuario u: repository.findAll()){
            System.out.println(u);
        }
    }
}
