package com.DesafioPicPay.DesafioPicPay.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.usuario;

public interface repositorioUsuario extends JpaRepository<usuario, Long>{

    Optional<usuario> acharUsuarioPorDocumento(String documento);

    Optional<usuario> acharUsuarioPorId(Long id);

}
