package com.basseifer.orcamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "orcamento")

public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrcamento;
    private String nomeCliente;
    private Double peso;
    private Double pesoDiferenca;
    private Double pesoFinal;
    private String obra;
    private Integer romaneio;
    private int posicao;
    private LocalDate dataChegada;
    private LocalDate dataSaida;
    private String tipoProjeto;
    private String situacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPesoDiferenca() {
        return pesoDiferenca;
    }

    public void setPesoDiferenca(Double pesoDiferenca) {
        this.pesoDiferenca = pesoDiferenca;
    }

    public Double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(Double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public Integer getRomaneio() {
        return romaneio;
    }

    public void setRomaneio(Integer romaneio) {
        this.romaneio = romaneio;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public LocalDate getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDate dataChegada) {
        this.dataChegada = dataChegada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(String tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
