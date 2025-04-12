package com.example.springboot_dataset.controller;

import com.example.springboot_dataset.model.Transacao;
import com.example.springboot_dataset.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<Transacao> getAllTransacoes() {
        return transacaoService.getAllTransacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getTransacaoById(@PathVariable String id){
        return transacaoService.getTransacaoById(id);
    }

    @GetMapping("/by-tipo")
    public ResponseEntity<List<Transacao>> getTransacaoByTipo(@RequestParam String tipo){
        return transacaoService.getTransacaoByTipo(tipo);
    }

    @GetMapping("/by-descricao")
    public ResponseEntity<List<Transacao>> getTransacaoByDescricao(@RequestParam String descricao){
        return transacaoService.getTransacaoByDescricao(descricao);
    }

    @GetMapping("/by-valor")
    public ResponseEntity<List<Transacao>> getTransacaoByValor(@RequestParam Double min, @RequestParam Double max){
        return transacaoService.getTransacaoByValorBetween(min, max);
    }

    @GetMapping("/by-data")
    public ResponseEntity<List<Transacao>> getTransacoesPorData(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return transacaoService.getTransacaoByDataBetween(start, end);
    }
}
