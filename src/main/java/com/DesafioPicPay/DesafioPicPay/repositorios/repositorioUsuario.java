package com.DesafioPicPay.DesafioPicPay.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.Usuario;

public interface repositorioUsuario extends JpaRepository<Usuario, Long>{

   // Optional<Usuario> findUsuariobydocumento(String documento);

    @SuppressWarnings("null")
    Optional<Usuario> findById(Long id);


}
