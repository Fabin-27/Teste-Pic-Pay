package com.DesafioPicPay.DesafioPicPay.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DesafioPicPay.DesafioPicPay.dominio.transacao.Transacao;

public interface repositorioTransacao extends JpaRepository<Transacao, Long>{

    
}
