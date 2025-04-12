package com.example.springboot_dataset.service;

import com.example.springboot_dataset.model.Transacao;
import com.example.springboot_dataset.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> getAllTransacoes(){
        return transacaoRepository.findAll();
    }

    public ResponseEntity<Transacao> getTransacaoById(String id){
        return transacaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Transacao>> getTransacaoByTipo(String tipo){
        List<Transacao> transacoes = transacaoRepository.findByTipoContainingIgnoreCase(tipo);
        return ResponseEntity.ok(transacoes);
    }

    public ResponseEntity<List<Transacao>> getTransacaoByDescricao(String descricao){
        List<Transacao> transacoes = transacaoRepository.findByDescricaoContainingIgnoreCase(descricao);
        return ResponseEntity.ok(transacoes);
    }

    public ResponseEntity<List<Transacao>> getTransacaoByValorBetween(Double min, Double max){
        List<Transacao> transacoes = transacaoRepository.findByValorBetween(min, max);
        return ResponseEntity.ok(transacoes);
    }

    public ResponseEntity<List<Transacao>> getTransacaoByDataBetween(LocalDateTime start, LocalDateTime end) {
        List<Transacao> transacoes = transacaoRepository.findByDataBetween(start, end);
        return ResponseEntity.ok(transacoes);
    }

    public ResponseEntity<List<Transacao>> getTransacaoByBanco(String banco){
        List<Transacao> transacoes = transacaoRepository.findByBancoContainingIgnoreCase(banco);
        return ResponseEntity.ok(transacoes);
    }

    public ResponseEntity<List<Transacao>> getTransacaoByStatus(String status){
        List<Transacao> transacoes = transacaoRepository.findByStatus(status);
        return ResponseEntity.ok(transacoes);
    }

    public ResponseEntity<List<Transacao>> getTransacaoByAgencia(int agencia){
        List<Transacao> transacoes = transacaoRepository.findByAgencia(agencia);
        return ResponseEntity.ok(transacoes);
    }

    public ResponseEntity<List<Transacao>> getTransacaoByConta(int conta){
        List<Transacao> transacoes = transacaoRepository.findByConta(conta);
        return ResponseEntity.ok(transacoes);
    }
}
