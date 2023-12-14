package com.basseifer.orcamento.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonManagedReference
    private List<Orcamento> orcamento = new ArrayList<>();

    public List<Orcamento> getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(List<Orcamento> orcamento) {
        this.orcamento = orcamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", orcamento=" + orcamento +
                '}';
    }
}
