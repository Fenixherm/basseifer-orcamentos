package com.basseifer.orcamento.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface OrcamentoRepository  extends JpaRepository<Orcamento, Long> {
    Orcamento findByromaneio(Integer romaneio);

    @Query("select o from Orcamento o where o.nomeCliente like %:nome%")
    Iterable<Orcamento> findAllBynomeCliente(@Param("nome") String nome);

    @Query("select o from Orcamento o where o.dataChegada between ?1 and ?2")
    Iterable<Orcamento> findByLocalDate(LocalDate data1, LocalDate data2);
}
