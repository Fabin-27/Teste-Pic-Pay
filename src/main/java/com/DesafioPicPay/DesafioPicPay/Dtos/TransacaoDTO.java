package com.DesafioPicPay.DesafioPicPay.Dtos;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal valor, Long emissorId, Long recptorId) {
    
}
