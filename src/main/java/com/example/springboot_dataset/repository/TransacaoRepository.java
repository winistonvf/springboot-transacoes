package com.example.springboot_dataset.repository;

import com.example.springboot_dataset.model.Transacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransacaoRepository extends MongoRepository<Transacao, String> {

    List<Transacao> findByTipoContainingIgnoreCase(String tipo);

    List<Transacao> findByDescricaoContainingIgnoreCase(String descricao);

    List<Transacao> findByBancoContainingIgnoreCase(String banco);

    List<Transacao> findByStatus(String status);

    List<Transacao> findByValorBetween(Double min, Double max);

    List<Transacao> findByDataBetween(LocalDateTime startDate, LocalDateTime endDate);
}
