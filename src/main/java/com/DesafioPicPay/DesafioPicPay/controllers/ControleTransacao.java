package com.DesafioPicPay.DesafioPicPay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DesafioPicPay.DesafioPicPay.Dtos.TransacaoDTO;
import com.DesafioPicPay.DesafioPicPay.Servicos.ServicoTransacao;
import com.DesafioPicPay.DesafioPicPay.dominio.transacao.Transacao;

@RestController
@RequestMapping("/transacoes")
public class ControleTransacao {

    @Autowired
    private ServicoTransacao servicoTransacao;

    @PostMapping
public ResponseEntity<Transacao> criarTransacao(@RequestBody TransacaoDTO transacao) throws Exception {
    Transacao novaTransacao = this.servicoTransacao.criarTransacao(transacao);
    return new ResponseEntity<>(novaTransacao, HttpStatus.OK);
}



    
    
}
