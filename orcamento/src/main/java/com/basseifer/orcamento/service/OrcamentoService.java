package com.basseifer.orcamento.service;

import com.basseifer.orcamento.model.Orcamento;
import com.basseifer.orcamento.model.OrcamentoRepository;
import com.basseifer.orcamento.model.Usuario;
import com.basseifer.orcamento.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OrcamentoService implements IOrcamentoService{
    @Autowired
    private OrcamentoRepository orcamentoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Iterable<Orcamento> buscarTodos() {
        return orcamentoRepository.findAll();
    }

    @Override
    public Iterable<Orcamento> findAllBynomeCliente(String nome) {
        return orcamentoRepository.findAllBynomeCliente(nome);
    }


    @Override
    public Orcamento findByromaneio(Integer romaneio) {
        Orcamento orcamento = orcamentoRepository.findByromaneio(romaneio);
        System.out.println("Romaneio: " + orcamento.getRomaneio());
        return orcamento;
    }

    @Override
    public Orcamento buscarPorId(Long id) {
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
        return orcamento.get();
    }



    @Override
    public long countMethod() {
        return orcamentoRepository.count();
    }

    @Override
    public void inserirOrcamento(Orcamento orcamento) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(orcamento.getUsuario().getId());

        if (usuarioBd.isPresent()) {
            Usuario usuarioOrcamento = usuarioBd.get();
            orcamento.setUsuario(usuarioOrcamento);
            orcamentoRepository.save(orcamento);
        }else {
            System.out.println("Usuário não fornecido ou ID invalido !");
            return;
        }
    }

    @Override
    public void atualizar(Long id, Orcamento orcamento) {

        Optional<Orcamento> orcamenteBd = orcamentoRepository.findById(id);
        if(orcamenteBd.isPresent()){
            Orcamento orcamentoAtualizadp = orcamenteBd.get();
            orcamentoAtualizadp.setNomeCliente(orcamento.getNomeCliente());
            orcamentoAtualizadp.setObra(orcamento.getObra());
            orcamentoAtualizadp.setSituacao(orcamento.getSituacao());
            orcamentoAtualizadp.setPesoDiferenca(orcamento.getPesoDiferenca());
            orcamentoAtualizadp.setPesoFinal(orcamento.getPeso() + orcamento.getPesoDiferenca());
            orcamentoRepository.save(orcamentoAtualizadp);
        }
    }

    @Override
    public void deletar(Long id) {
        orcamentoRepository.delete(buscarPorId(id));
    }

    @Override
    public Iterable<Orcamento> findByLocalDate(LocalDate data1, LocalDate data2) {
        return orcamentoRepository.findByLocalDate(data1, data2);
    }
}
