package com.DesafioPicPay.DesafioPicPay.dominio.usuarios;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nome;

    private String sobrenome;

    @Column(unique = true)
    private String documento;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    private tipoUsuario tipoDeUsuario;
    
}
