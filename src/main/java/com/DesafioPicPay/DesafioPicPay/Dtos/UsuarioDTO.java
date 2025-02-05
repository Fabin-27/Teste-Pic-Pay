package com.DesafioPicPay.DesafioPicPay.Dtos;

import java.math.BigDecimal;

import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.TipoUsuario;

public record UsuarioDTO(String nome, String sobrenome,TipoUsuario tipoUsuario, String documento, BigDecimal saldo, String email, String password) {
    
}
