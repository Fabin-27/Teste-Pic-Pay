package com.DesafioPicPay.DesafioPicPay.dominio.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "transacoes")
@Table(name = "transacoes")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "emissor_id")
    private Usuario emissor;

    @ManyToOne
    @JoinColumn(name = "receptor_id")
    private Usuario receptor;

    private LocalDateTime horario;

    public Transacao(){

    }
    
}
